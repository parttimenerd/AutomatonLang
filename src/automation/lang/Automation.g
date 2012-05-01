grammar Automation;

options {
	k = *;
}

@header {
package automation.lang;
import automation.lang.Tree;
import java.util.HashMap;
import java.util.ArrayList;
}

@members {
HashMap<String, String> dic = new HashMap<String, String>();
Tree tree;
String current_from_id;
String start_id;
String first_id;

public State getState(String id){
	if (!dic.containsKey(id)){
		dic.put(id, id);
		return tree.createState(id, false);
	} else {
		return (State)tree.getState(dic.get(id));
	}
}
}

prog:  mode (NEWLINE | ';')? ((declaration) (NEWLINE | ';' | EOF))*
{System.out.println(tree.serialize());} ;

mode	: 'mode: finite' {tree = new Tree(Tree.FINITE);}
	| 'mode: mealy' {tree = new Tree(Tree.MEALY);}
	;  

declaration
	:	ID STRING? (':' flags += FLAG (',' flags += FLAG)*)?
	{
	String label = $STRING.text != "" ? $STRING.text : $ID.text;
	State state = tree.createState(label, $flags.contains("final"));
	if (start_id == null && $flags.contains("initial")){
		tree.setStart(state);
		start_id = $ID.text;
	}
	if (first_id == null){
		first_id = $ID.text;
	}
	current_from_id = $ID.text;
	dic.put(ID.text, label);
	}
	;

transition
@init {ArrayList<String> list = new ArrayList<String>()}
	:	 ((from=ID '-') | '>') w=word (':' output=STRING)? '-' to=ID
	{
		current_from_id = $from.text == "" ? current_from_id : $from.text;
		for(String str : $w.list){
			tree.createTransition(getState(current_from_id), getState($to.text), str, $output.text == "" ? "" : $output.text );
		}
	}	
	;
	
 	word returns [ArrayList<String> list]
@init {$list = new ArrayList<String>()}
 	:(l = word_part {$list.addAll($l.list);}// (',' l = word_part {$list.addAll($l.list);})*
 	;
word_part returns [ArrayList<String> list]
@init {$list = new ArrayList<String>()}
	: (CHAR '..' CHAR)
	| (INT '..' INT)
	| CHAR {$list.add($CHAR.text);}
	| INT {$list.add($INT.text);}
	| STRING {$list.add($STRING.text);}
	;
FLAG	:	'final'
	|	 'initial';
NEWLINE:'\r'? '\n' ;

WS  :   (' '|'\t')+ {skip(); $channel=HIDDEN;} ;

ID  :	('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'0'..'9'|'_')*
    ;

INT :	'0'..'9'+
    ;

COMMENT
    :   ('//' | '#') ~('\n'|'\r')* '\r'? '\n' {$channel=HIDDEN;}
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
