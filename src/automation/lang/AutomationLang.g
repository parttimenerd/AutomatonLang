grammar AutomationLang;

@parser::header {
package automation.lang;
import java.util.HashMap;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
}

@lexer::header {
package automation.lang;
}

@members {
   HashMap<String, String> dic = new HashMap<String, String>();
   HashMap<String, ArrayList<String[]>> var_dic = new HashMap<String, ArrayList<String[]>>();
   Tree tree = new Tree();
   String current_from_id;
   String start_id = "";
   String first_id = "";
   String final_id = "";
   String last_id = "";
   boolean in_var_def = false;
   String current_var_def_id = "";

   public State getState(String id){
         if (!dic.containsKey(id)){
                  dic.put(id, id);
                  return tree.createState(id, false);
         } else {
                  return (State)tree.getState(dic.get(id));
         }
   }

   public String gsv(String text){
         if (text == null || text.length() <= 2) return "";
         return text.substring(1, text.length() - 1);
   }

   public int ipar(String text){
         if(text == null) return -1;
         return Integer.parseInt(text);
   }

   public double perc(String text){
         if (text == null || text.length() <= 2) return 0;
         return Integer.parseInt(text.substring(0, text.length() - 1)) / 100.0;
   }

   public static Tree saveCodeInFileAndParseToTree(String code, String file) throws IOException, RecognitionException {
         AutomationLangParser parser = new AutomationLangParser(Utils.saveCodeInFileAndGetTokenStream(code, file));
         parser.prog();
         return parser.getTree();
   }

   public Tree getTree(){
         return tree;
   }

   public boolean varExists(String id){
      return var_dic.containsKey(id);
   }

   public boolean singleVarExists(String id){
      if (!varExists(id)) return false;
      ArrayList<String[]> list = var_dic.get(id);
      return list.size() == 1;
   }

   public ArrayList<String[]> getVarValue(String id){
      return (ArrayList<String[]>)var_dic.get(id);
   }

   public String getSingleVarValue(String id){
      return ((ArrayList<String[]>)var_dic.get(id)).get(0)[0];
   }

   public void setVar(String id, String value){
      ArrayList<String[]> list = new ArrayList<String[]>();
      list.add(new String[]{value, ""});
      setVar(id, list);
   }

   public void setVar(String id, ArrayList<String[]> list){
      var_dic.put(id, list);
   }
}
prog: stat*
   {if (final_id == "" && last_id != "") getState(last_id).setFinal_state(true); tree.redistributeStates();};

stat	: (declaration | transition | var_def | options_rule) COMMENT? (NEWLINE | EOF)
	| NEWLINE
	;
	
options_rule
	: 'options' (NEWLINE | '{' NEWLINE?) (option_line? NEWLINE)* ('end' NEWLINE | '}' NEWLINE?)
	;
	
option_line
	: 'mode' ':' (
		  'finite' {tree.setMode(Tree.Mode.FINITE);}
		| 'mealy' {tree.setMode(Tree.Mode.MEALY);}
		)
	| 'distribution' ':' (
		  'random' {tree.setDistributionMode(4);}
		| 'circular' {tree.setDistributionMode(5);}
		)
	| 'width' ':' INT {tree.setPaintWidth(ipar($INT.text));} 
	| 'height' ':' INT {tree.setPaintHeight(ipar($INT.text));} 
	;

declaration
@init {ArrayList<String> flags = new ArrayList<String>();}
	:	ID STRING? (':' f1=FLAG {flags.add($f1.text);} (',' f2=FLAG {flags.add($f2.text);})*)? opt_position
	{
	String label = gsv($STRING.text) != "" ? gsv($STRING.text) : $ID.text;
        boolean is_final = flags == null ? false : flags.contains("final");
	State state = tree.createState(label, is_final);
	if (is_final){
                final_id = label;
        }
        if (start_id == "" && (flags != null && flags.contains("initial"))){
		tree.setStart(state);
		start_id = $ID.text;
	}
	if (first_id == ""){
		first_id = $ID.text;
	}
	current_from_id = $ID.text;
	dic.put($ID.text, label);
	state.setPosition($opt_position.x, $opt_position.y);
	}
	;

opt_position returns [double x, double y]
@init {$x = -1; $y = -1;}
	: ('\[' xv=coord {$x = $xv.val;}  (',' yv=coord {$y = $yv.val;})? ']')?
	;
	
coord returns [double val]
@init {val = -1;}
	: PERCENT {$val = perc($PERCENT.text);}
	| INT {$val = ipar($INT.text);}
	;
	
var_def
@init {in_var_def = true;}
@after {in_var_def = false; current_var_def_id = "";}
        : ID '=' word_outputs {setVar($ID.text, $word_outputs.list); current_var_def_id = $ID.text;}
        ;

var returns [ArrayList<String[\]> list]
        : ID {varExists($ID.text) && current_var_def_id != $ID.text}? {$list = getVarValue($ID.text);}
        ;

single_var returns [String value]
        : ID {singleVarExists($ID.text) && current_var_def_id != $ID.text}? {$value = getSingleVarValue($ID.text);}
        ;
        
transition
@init {boolean reverse = false; String to_str = "";}
	:	 ((from=ID {current_from_id = $from.text;} '-') |
		 '>' {current_from_id != ""}? |
		  '-' {last_id != ""}? {current_from_id = last_id;}) w=word_outputs ('-' to=ID {to_str = $to.text;} ('~' {reverse = true;})?)?
	{       
		State current = getState(current_from_id);
                if (start_id == ""){
                     tree.setStart(current);
                     start_id = current_from_id;
                }
		State to_state = to_str == "" ? current : getState(to_str);
                last_id = to_str == "" ? current_from_id : to_str;
		for(String[] arr : $w.list){
			tree.createTransition(current, to_state, arr[0], arr[1]);
			if (reverse) tree.createTransition(to_state, current, arr[0], arr[1]);
		}
		tree.createVerbalTransition(current, to_state, $w.text, $from.line);
                if (reverse) tree.createVerbalTransition(to_state, current, $w.text, $from.line);
         }	
	;
word_outputs returns [ArrayList<String[\]> list]
@init {$list = new ArrayList<String[]>();}
	: word_output {$list.addAll($word_output.list);}
	| '\(' w=word_outputs {$list.addAll($w.list);} (',' t=word_outputs {$list.addAll($t.list);})* '\)'
	;
word_output returns [ArrayList<String[\]> list]
@init {list = new ArrayList<String[]>();}
	: ID {varExists($ID.text) && current_var_def_id != $ID.text}? {$list.addAll(getVarValue($ID.text));}
        | word (':' STRING )?
	{
	String output = gsv($STRING.text);
	if (output == ""){
		for (String w : $word.list){
			$list.add(new String[]{w, ""});
		}
	} else {
		for (String w : $word.list){
			$list.add(new String[]{w, output.replaceAll("$", w)});
		}
	}
	}
	;

word returns [ArrayList<String> list]
@init {$list = new ArrayList<String>();}
 	: t=word_part {$list.addAll($t.list);} (',' l=word_part {$list.addAll($l.list);})*
 	;

word_part returns [ArrayList<String> list]
@init {$list = new ArrayList<String>(); int incr = 0;}
	: fp=range_part_var  '..' (INT {incr = ipar($INT.text);} | single_var {incr = ipar($single_var.value);}) range_points lp=range_part_var
	{
		$list = Utils.range($fp.value, $lp.value, incr, $range_points.include_end);
	}
	| fp=range_part_var range_points lp=range_part_var
	{
		$list = Utils.range($fp.value, $lp.value, $range_points.include_end);
	}
	| CHAR {$list.add(gsv($CHAR.text));}
	| INT {$list.add($INT.text);}
	| STRING {$list.add(gsv($STRING.text));}
        | ID {varExists($ID.text) && current_var_def_id != $ID.text}? 
         {for (String[] arr : getVarValue($ID.text)){
               $list.add(arr[0]);
         }}
	; 

range_part_var returns [String value]
         :  range_part {$value = $range_part.value;}
         |  single_var {$value = $single_var.value;}
         ;

range_part returns [String value]
	: ce=CHAR {$value = gsv($ce.text);}
	| ie=INT {$value = $ie.text;}
	| se=STRING {$value = gsv($se.text);}
	;
range_points returns [boolean include_end]
	: '..' {$include_end = true;}
	| '...' {$include_end = false;}
	;
	
FLAG	:	'final'
	|	 'initial';

NEWLINE
	:'\r'? '\n'
	| ';'?
	;

WS  :   (' '|'\t')+ {skip();} ;

ID  :	('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'0'..'9'|'_')*
    ;

INT :	('+'|'-')?('0'..'9')+
    ;
PERCENT	: ('0'..'9')+ '%'
	;
COMMENT
    :   ('//' | '#') ~('\n'|'\r')* {$channel=HIDDEN;}
    |   '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;}
    ;
STRING
    :  '"' ( ESC_SEQ | ~('\\'|'"') )* '"'
    ;
CHAR:  '\'' ( ESC_SEQ | ~('\''|'\\') ) '\''
    ;

fragment
HEX_DIGIT : ('0'..'9'|'a'..'f'|'A'..'F') ;

fragment
ESC_SEQ
    :   '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\')
    |   UNICODE_ESC
    |   OCTAL_ESC
    ;

fragment
OCTAL_ESC
    :   '\\' ('0'..'3') ('0'..'7') ('0'..'7')
    |   '\\' ('0'..'7') ('0'..'7')
    |   '\\' ('0'..'7')
    ;

fragment
UNICODE_ESC
    :   '\\' 'u' HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT
    ;
