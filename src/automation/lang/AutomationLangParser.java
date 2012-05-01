// $ANTLR 3.4 C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g 2012-04-29 18:53:34

package automation.lang;
import java.util.HashMap;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class AutomationLangParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "CHAR", "COMMENT", "ESC_SEQ", "FLAG", "HEX_DIGIT", "ID", "INT", "NEWLINE", "OCTAL_ESC", "PERCENT", "STRING", "UNICODE_ESC", "WS", "','", "'-'", "'..'", "'...'", "':'", "'='", "'>'", "'\\('", "'\\)'", "'\\['", "']'", "'circular'", "'distribution'", "'end'", "'finite'", "'height'", "'mealy'", "'mode'", "'options'", "'random'", "'width'", "'{'", "'}'", "'~'"
    };

    public static final int EOF=-1;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__19=19;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__40=40;
    public static final int CHAR=4;
    public static final int COMMENT=5;
    public static final int ESC_SEQ=6;
    public static final int FLAG=7;
    public static final int HEX_DIGIT=8;
    public static final int ID=9;
    public static final int INT=10;
    public static final int NEWLINE=11;
    public static final int OCTAL_ESC=12;
    public static final int PERCENT=13;
    public static final int STRING=14;
    public static final int UNICODE_ESC=15;
    public static final int WS=16;

    // delegates
    public Parser[] getDelegates() {
        return new Parser[] {};
    }

    // delegators


    public AutomationLangParser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }
    public AutomationLangParser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
    }

    public String[] getTokenNames() { return AutomationLangParser.tokenNames; }
    public String getGrammarFileName() { return "C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g"; }


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



    // $ANTLR start "prog"
    // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:90:1: prog : ( stat )* ;
    public final void prog() throws RecognitionException {
        try {
            // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:90:5: ( ( stat )* )
            // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:90:7: ( stat )*
            {
            // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:90:7: ( stat )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==ID||LA1_0==NEWLINE||LA1_0==18||LA1_0==23||LA1_0==35) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:90:7: stat
            	    {
            	    pushFollow(FOLLOW_stat_in_prog32);
            	    stat();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            if (final_id == "" && last_id != "") getState(last_id).setFinal_state(true); tree.redistributeStates();

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "prog"



    // $ANTLR start "stat"
    // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:93:1: stat : ( ( declaration | transition | var_def | options_rule ) ( NEWLINE | EOF ) | NEWLINE );
    public final void stat() throws RecognitionException {
        try {
            // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:93:6: ( ( declaration | transition | var_def | options_rule ) ( NEWLINE | EOF ) | NEWLINE )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==ID||LA3_0==18||LA3_0==23||LA3_0==35) ) {
                alt3=1;
            }
            else if ( (LA3_0==NEWLINE) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;

            }
            switch (alt3) {
                case 1 :
                    // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:93:8: ( declaration | transition | var_def | options_rule ) ( NEWLINE | EOF )
                    {
                    // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:93:8: ( declaration | transition | var_def | options_rule )
                    int alt2=4;
                    switch ( input.LA(1) ) {
                    case ID:
                        {
                        switch ( input.LA(2) ) {
                        case 22:
                            {
                            alt2=3;
                            }
                            break;
                        case EOF:
                        case NEWLINE:
                        case STRING:
                        case 21:
                        case 26:
                            {
                            alt2=1;
                            }
                            break;
                        case 18:
                            {
                            alt2=2;
                            }
                            break;
                        default:
                            NoViableAltException nvae =
                                new NoViableAltException("", 2, 1, input);

                            throw nvae;

                        }

                        }
                        break;
                    case 18:
                    case 23:
                        {
                        alt2=2;
                        }
                        break;
                    case 35:
                        {
                        alt2=4;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 2, 0, input);

                        throw nvae;

                    }

                    switch (alt2) {
                        case 1 :
                            // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:93:9: declaration
                            {
                            pushFollow(FOLLOW_declaration_in_stat47);
                            declaration();

                            state._fsp--;


                            }
                            break;
                        case 2 :
                            // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:93:23: transition
                            {
                            pushFollow(FOLLOW_transition_in_stat51);
                            transition();

                            state._fsp--;


                            }
                            break;
                        case 3 :
                            // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:93:36: var_def
                            {
                            pushFollow(FOLLOW_var_def_in_stat55);
                            var_def();

                            state._fsp--;


                            }
                            break;
                        case 4 :
                            // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:93:46: options_rule
                            {
                            pushFollow(FOLLOW_options_rule_in_stat59);
                            options_rule();

                            state._fsp--;


                            }
                            break;

                    }


                    if ( input.LA(1)==EOF||input.LA(1)==NEWLINE ) {
                        input.consume();
                        state.errorRecovery=false;
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }


                    }
                    break;
                case 2 :
                    // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:94:4: NEWLINE
                    {
                    match(input,NEWLINE,FOLLOW_NEWLINE_in_stat73); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "stat"



    // $ANTLR start "options_rule"
    // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:97:1: options_rule : 'options' ( NEWLINE | '{' ( NEWLINE )? ) ( ( option_line )? NEWLINE )* ( 'end' NEWLINE | '}' ( NEWLINE )? ) ;
    public final void options_rule() throws RecognitionException {
        try {
            // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:98:2: ( 'options' ( NEWLINE | '{' ( NEWLINE )? ) ( ( option_line )? NEWLINE )* ( 'end' NEWLINE | '}' ( NEWLINE )? ) )
            // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:98:4: 'options' ( NEWLINE | '{' ( NEWLINE )? ) ( ( option_line )? NEWLINE )* ( 'end' NEWLINE | '}' ( NEWLINE )? )
            {
            match(input,35,FOLLOW_35_in_options_rule85); 

            // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:98:14: ( NEWLINE | '{' ( NEWLINE )? )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==NEWLINE) ) {
                alt5=1;
            }
            else if ( (LA5_0==38) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;

            }
            switch (alt5) {
                case 1 :
                    // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:98:15: NEWLINE
                    {
                    match(input,NEWLINE,FOLLOW_NEWLINE_in_options_rule88); 

                    }
                    break;
                case 2 :
                    // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:98:25: '{' ( NEWLINE )?
                    {
                    match(input,38,FOLLOW_38_in_options_rule92); 

                    // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:98:29: ( NEWLINE )?
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0==NEWLINE) ) {
                        alt4=1;
                    }
                    switch (alt4) {
                        case 1 :
                            // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:98:29: NEWLINE
                            {
                            match(input,NEWLINE,FOLLOW_NEWLINE_in_options_rule94); 

                            }
                            break;

                    }


                    }
                    break;

            }


            // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:98:39: ( ( option_line )? NEWLINE )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==NEWLINE||LA7_0==29||LA7_0==32||LA7_0==34||LA7_0==37) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:98:40: ( option_line )? NEWLINE
            	    {
            	    // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:98:40: ( option_line )?
            	    int alt6=2;
            	    int LA6_0 = input.LA(1);

            	    if ( (LA6_0==29||LA6_0==32||LA6_0==34||LA6_0==37) ) {
            	        alt6=1;
            	    }
            	    switch (alt6) {
            	        case 1 :
            	            // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:98:40: option_line
            	            {
            	            pushFollow(FOLLOW_option_line_in_options_rule99);
            	            option_line();

            	            state._fsp--;


            	            }
            	            break;

            	    }


            	    match(input,NEWLINE,FOLLOW_NEWLINE_in_options_rule102); 

            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);


            // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:98:63: ( 'end' NEWLINE | '}' ( NEWLINE )? )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==30) ) {
                alt9=1;
            }
            else if ( (LA9_0==39) ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;

            }
            switch (alt9) {
                case 1 :
                    // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:98:64: 'end' NEWLINE
                    {
                    match(input,30,FOLLOW_30_in_options_rule107); 

                    match(input,NEWLINE,FOLLOW_NEWLINE_in_options_rule109); 

                    }
                    break;
                case 2 :
                    // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:98:80: '}' ( NEWLINE )?
                    {
                    match(input,39,FOLLOW_39_in_options_rule113); 

                    // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:98:84: ( NEWLINE )?
                    int alt8=2;
                    int LA8_0 = input.LA(1);

                    if ( (LA8_0==NEWLINE) ) {
                        int LA8_1 = input.LA(2);

                        if ( (LA8_1==EOF) ) {
                            int LA8_2 = input.LA(3);

                            if ( (LA8_2==EOF||LA8_2==ID||LA8_2==NEWLINE||LA8_2==18||LA8_2==23||LA8_2==35) ) {
                                alt8=1;
                            }
                        }
                        else if ( (LA8_1==NEWLINE) ) {
                            alt8=1;
                        }
                    }
                    switch (alt8) {
                        case 1 :
                            // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:98:84: NEWLINE
                            {
                            match(input,NEWLINE,FOLLOW_NEWLINE_in_options_rule115); 

                            }
                            break;

                    }


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "options_rule"



    // $ANTLR start "option_line"
    // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:101:1: option_line : ( 'mode' ':' ( 'finite' | 'mealy' ) | 'distribution' ':' ( 'random' | 'circular' ) | 'width' ':' INT | 'height' ':' INT );
    public final void option_line() throws RecognitionException {
        Token INT1=null;
        Token INT2=null;

        try {
            // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:102:2: ( 'mode' ':' ( 'finite' | 'mealy' ) | 'distribution' ':' ( 'random' | 'circular' ) | 'width' ':' INT | 'height' ':' INT )
            int alt12=4;
            switch ( input.LA(1) ) {
            case 34:
                {
                alt12=1;
                }
                break;
            case 29:
                {
                alt12=2;
                }
                break;
            case 37:
                {
                alt12=3;
                }
                break;
            case 32:
                {
                alt12=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;

            }

            switch (alt12) {
                case 1 :
                    // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:102:4: 'mode' ':' ( 'finite' | 'mealy' )
                    {
                    match(input,34,FOLLOW_34_in_option_line129); 

                    match(input,21,FOLLOW_21_in_option_line131); 

                    // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:102:15: ( 'finite' | 'mealy' )
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( (LA10_0==31) ) {
                        alt10=1;
                    }
                    else if ( (LA10_0==33) ) {
                        alt10=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 10, 0, input);

                        throw nvae;

                    }
                    switch (alt10) {
                        case 1 :
                            // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:103:5: 'finite'
                            {
                            match(input,31,FOLLOW_31_in_option_line139); 

                            tree.setMode(Tree.Mode.FINITE);

                            }
                            break;
                        case 2 :
                            // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:104:5: 'mealy'
                            {
                            match(input,33,FOLLOW_33_in_option_line147); 

                            tree.setMode(Tree.Mode.MEALY);

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:106:4: 'distribution' ':' ( 'random' | 'circular' )
                    {
                    match(input,29,FOLLOW_29_in_option_line158); 

                    match(input,21,FOLLOW_21_in_option_line160); 

                    // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:106:23: ( 'random' | 'circular' )
                    int alt11=2;
                    int LA11_0 = input.LA(1);

                    if ( (LA11_0==36) ) {
                        alt11=1;
                    }
                    else if ( (LA11_0==28) ) {
                        alt11=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 11, 0, input);

                        throw nvae;

                    }
                    switch (alt11) {
                        case 1 :
                            // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:107:5: 'random'
                            {
                            match(input,36,FOLLOW_36_in_option_line168); 

                            tree.setDistributionMode(4);

                            }
                            break;
                        case 2 :
                            // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:108:5: 'circular'
                            {
                            match(input,28,FOLLOW_28_in_option_line176); 

                            tree.setDistributionMode(5);

                            }
                            break;

                    }


                    }
                    break;
                case 3 :
                    // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:110:4: 'width' ':' INT
                    {
                    match(input,37,FOLLOW_37_in_option_line187); 

                    match(input,21,FOLLOW_21_in_option_line189); 

                    INT1=(Token)match(input,INT,FOLLOW_INT_in_option_line191); 

                    tree.setPaintWidth(ipar((INT1!=null?INT1.getText():null)));

                    }
                    break;
                case 4 :
                    // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:111:4: 'height' ':' INT
                    {
                    match(input,32,FOLLOW_32_in_option_line199); 

                    match(input,21,FOLLOW_21_in_option_line201); 

                    INT2=(Token)match(input,INT,FOLLOW_INT_in_option_line203); 

                    tree.setPaintHeight(ipar((INT2!=null?INT2.getText():null)));

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "option_line"



    // $ANTLR start "declaration"
    // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:114:1: declaration : ID ( STRING )? ( ':' f1= FLAG ( ',' f2= FLAG )* )? opt_position ;
    public final void declaration() throws RecognitionException {
        Token f1=null;
        Token f2=null;
        Token STRING3=null;
        Token ID4=null;
        AutomationLangParser.opt_position_return opt_position5 =null;


        ArrayList<String> flags = new ArrayList<String>();
        try {
            // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:116:2: ( ID ( STRING )? ( ':' f1= FLAG ( ',' f2= FLAG )* )? opt_position )
            // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:116:4: ID ( STRING )? ( ':' f1= FLAG ( ',' f2= FLAG )* )? opt_position
            {
            ID4=(Token)match(input,ID,FOLLOW_ID_in_declaration222); 

            // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:116:7: ( STRING )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==STRING) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:116:7: STRING
                    {
                    STRING3=(Token)match(input,STRING,FOLLOW_STRING_in_declaration224); 

                    }
                    break;

            }


            // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:116:15: ( ':' f1= FLAG ( ',' f2= FLAG )* )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==21) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:116:16: ':' f1= FLAG ( ',' f2= FLAG )*
                    {
                    match(input,21,FOLLOW_21_in_declaration228); 

                    f1=(Token)match(input,FLAG,FOLLOW_FLAG_in_declaration232); 

                    flags.add((f1!=null?f1.getText():null));

                    // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:116:51: ( ',' f2= FLAG )*
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( (LA14_0==17) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:116:52: ',' f2= FLAG
                    	    {
                    	    match(input,17,FOLLOW_17_in_declaration237); 

                    	    f2=(Token)match(input,FLAG,FOLLOW_FLAG_in_declaration241); 

                    	    flags.add((f2!=null?f2.getText():null));

                    	    }
                    	    break;

                    	default :
                    	    break loop14;
                        }
                    } while (true);


                    }
                    break;

            }


            pushFollow(FOLLOW_opt_position_in_declaration249);
            opt_position5=opt_position();

            state._fsp--;



            	String label = gsv((STRING3!=null?STRING3.getText():null)) != "" ? gsv((STRING3!=null?STRING3.getText():null)) : (ID4!=null?ID4.getText():null);
                    boolean is_final = flags == null ? false : flags.contains("final");
                    System.out.println(flags);
            	State state = tree.createState(label, is_final);
            	if (is_final){
                            final_id = label;
                    }
                    if (start_id == "" && (flags != null && flags.contains("initial"))){
            		tree.setStart(state);
            		start_id = (ID4!=null?ID4.getText():null);
            	}
            	if (first_id == ""){
            		first_id = (ID4!=null?ID4.getText():null);
            	}
            	current_from_id = (ID4!=null?ID4.getText():null);
            	dic.put((ID4!=null?ID4.getText():null), label);
            	state.setPosition((opt_position5!=null?opt_position5.x:0.0), (opt_position5!=null?opt_position5.y:0.0));
            	

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "declaration"


    public static class opt_position_return extends ParserRuleReturnScope {
        public double x;
        public double y;
    };


    // $ANTLR start "opt_position"
    // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:138:1: opt_position returns [double x, double y] : ( '\\[' xv= coord ( ',' yv= coord )? ']' )? ;
    public final AutomationLangParser.opt_position_return opt_position() throws RecognitionException {
        AutomationLangParser.opt_position_return retval = new AutomationLangParser.opt_position_return();
        retval.start = input.LT(1);


        double xv =0.0;

        double yv =0.0;


        retval.x = -1; retval.y = -1;
        try {
            // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:140:2: ( ( '\\[' xv= coord ( ',' yv= coord )? ']' )? )
            // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:140:4: ( '\\[' xv= coord ( ',' yv= coord )? ']' )?
            {
            // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:140:4: ( '\\[' xv= coord ( ',' yv= coord )? ']' )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==26) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:140:5: '\\[' xv= coord ( ',' yv= coord )? ']'
                    {
                    match(input,26,FOLLOW_26_in_opt_position273); 

                    pushFollow(FOLLOW_coord_in_opt_position277);
                    xv=coord();

                    state._fsp--;


                    retval.x = xv;

                    // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:140:36: ( ',' yv= coord )?
                    int alt16=2;
                    int LA16_0 = input.LA(1);

                    if ( (LA16_0==17) ) {
                        alt16=1;
                    }
                    switch (alt16) {
                        case 1 :
                            // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:140:37: ',' yv= coord
                            {
                            match(input,17,FOLLOW_17_in_opt_position283); 

                            pushFollow(FOLLOW_coord_in_opt_position287);
                            yv=coord();

                            state._fsp--;


                            retval.y = yv;

                            }
                            break;

                    }


                    match(input,27,FOLLOW_27_in_opt_position293); 

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "opt_position"



    // $ANTLR start "coord"
    // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:143:1: coord returns [double val] : ( PERCENT | INT );
    public final double coord() throws RecognitionException {
        double val = 0.0;


        Token PERCENT6=null;
        Token INT7=null;

        val = -1;
        try {
            // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:145:2: ( PERCENT | INT )
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==PERCENT) ) {
                alt18=1;
            }
            else if ( (LA18_0==INT) ) {
                alt18=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;

            }
            switch (alt18) {
                case 1 :
                    // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:145:4: PERCENT
                    {
                    PERCENT6=(Token)match(input,PERCENT,FOLLOW_PERCENT_in_coord316); 

                    val = perc((PERCENT6!=null?PERCENT6.getText():null));

                    }
                    break;
                case 2 :
                    // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:146:4: INT
                    {
                    INT7=(Token)match(input,INT,FOLLOW_INT_in_coord323); 

                    val = ipar((INT7!=null?INT7.getText():null));

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return val;
    }
    // $ANTLR end "coord"



    // $ANTLR start "var_def"
    // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:149:1: var_def : ID '=' word_outputs ;
    public final void var_def() throws RecognitionException {
        Token ID8=null;
        AutomationLangParser.word_outputs_return word_outputs9 =null;


        in_var_def = true;
        try {
            // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:152:9: ( ID '=' word_outputs )
            // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:152:11: ID '=' word_outputs
            {
            ID8=(Token)match(input,ID,FOLLOW_ID_in_var_def354); 

            match(input,22,FOLLOW_22_in_var_def356); 

            pushFollow(FOLLOW_word_outputs_in_var_def358);
            word_outputs9=word_outputs();

            state._fsp--;


            setVar((ID8!=null?ID8.getText():null), (word_outputs9!=null?word_outputs9.list:null)); current_var_def_id = (ID8!=null?ID8.getText():null);

            }

            in_var_def = false; current_var_def_id = "";
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "var_def"



    // $ANTLR start "var"
    // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:155:1: var returns [ArrayList<String[]> list] : ID {...}?;
    public final ArrayList<String[]> var() throws RecognitionException {
        ArrayList<String[]> list = null;


        Token ID10=null;

        try {
            // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:156:9: ( ID {...}?)
            // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:156:11: ID {...}?
            {
            ID10=(Token)match(input,ID,FOLLOW_ID_in_var389); 

            if ( !((varExists((ID10!=null?ID10.getText():null)) && current_var_def_id != (ID10!=null?ID10.getText():null))) ) {
                throw new FailedPredicateException(input, "var", "varExists($ID.text) && current_var_def_id != $ID.text");
            }

            list = getVarValue((ID10!=null?ID10.getText():null));

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return list;
    }
    // $ANTLR end "var"



    // $ANTLR start "single_var"
    // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:159:1: single_var returns [String value] : ID {...}?;
    public final String single_var() throws RecognitionException {
        String value = null;


        Token ID11=null;

        try {
            // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:160:9: ( ID {...}?)
            // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:160:11: ID {...}?
            {
            ID11=(Token)match(input,ID,FOLLOW_ID_in_single_var422); 

            if ( !((singleVarExists((ID11!=null?ID11.getText():null)) && current_var_def_id != (ID11!=null?ID11.getText():null))) ) {
                throw new FailedPredicateException(input, "single_var", "singleVarExists($ID.text) && current_var_def_id != $ID.text");
            }

            value = getSingleVarValue((ID11!=null?ID11.getText():null));

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return value;
    }
    // $ANTLR end "single_var"



    // $ANTLR start "transition"
    // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:163:1: transition : ( (from= ID '-' ) | '>' {...}?| '-' {...}?) w= word_outputs ( '-' to= ID ( '~' )? )? ;
    public final void transition() throws RecognitionException {
        Token from=null;
        Token to=null;
        AutomationLangParser.word_outputs_return w =null;


        boolean reverse = false; String to_str = "";
        try {
            // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:165:2: ( ( (from= ID '-' ) | '>' {...}?| '-' {...}?) w= word_outputs ( '-' to= ID ( '~' )? )? )
            // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:165:5: ( (from= ID '-' ) | '>' {...}?| '-' {...}?) w= word_outputs ( '-' to= ID ( '~' )? )?
            {
            // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:165:5: ( (from= ID '-' ) | '>' {...}?| '-' {...}?)
            int alt19=3;
            switch ( input.LA(1) ) {
            case ID:
                {
                alt19=1;
                }
                break;
            case 23:
                {
                alt19=2;
                }
                break;
            case 18:
                {
                alt19=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;

            }

            switch (alt19) {
                case 1 :
                    // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:165:6: (from= ID '-' )
                    {
                    // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:165:6: (from= ID '-' )
                    // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:165:7: from= ID '-'
                    {
                    from=(Token)match(input,ID,FOLLOW_ID_in_transition462); 

                    current_from_id = (from!=null?from.getText():null);

                    match(input,18,FOLLOW_18_in_transition466); 

                    }


                    }
                    break;
                case 2 :
                    // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:166:4: '>' {...}?
                    {
                    match(input,23,FOLLOW_23_in_transition474); 

                    if ( !((current_from_id != "")) ) {
                        throw new FailedPredicateException(input, "transition", "current_from_id != \"\"");
                    }

                    }
                    break;
                case 3 :
                    // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:167:5: '-' {...}?
                    {
                    match(input,18,FOLLOW_18_in_transition484); 

                    if ( !((last_id != "")) ) {
                        throw new FailedPredicateException(input, "transition", "last_id != \"\"");
                    }

                    current_from_id = last_id;

                    }
                    break;

            }


            pushFollow(FOLLOW_word_outputs_in_transition493);
            w=word_outputs();

            state._fsp--;


            // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:167:71: ( '-' to= ID ( '~' )? )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==18) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:167:72: '-' to= ID ( '~' )?
                    {
                    match(input,18,FOLLOW_18_in_transition496); 

                    to=(Token)match(input,ID,FOLLOW_ID_in_transition500); 

                    to_str = (to!=null?to.getText():null);

                    // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:167:103: ( '~' )?
                    int alt20=2;
                    int LA20_0 = input.LA(1);

                    if ( (LA20_0==40) ) {
                        alt20=1;
                    }
                    switch (alt20) {
                        case 1 :
                            // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:167:104: '~'
                            {
                            match(input,40,FOLLOW_40_in_transition505); 

                            reverse = true;

                            }
                            break;

                    }


                    }
                    break;

            }


                   
            		State current = getState(current_from_id);
                            if (start_id == ""){
                                 tree.setStart(current);
                                 start_id = current_from_id;
                            }
            		State to_state = to_str == "" ? current : getState(to_str);
                            last_id = to_str == "" ? current_from_id : to_str;
            		for(String[] arr : (w!=null?w.list:null)){
            			tree.createTransition(current, to_state, arr[0], arr[1]);
            			if (reverse) tree.createTransition(to_state, current, arr[0], arr[1]);
            		}
            		tree.createVerbalTransition(current, to_state, (w!=null?input.toString(w.start,w.stop):null), (from!=null?from.getLine():0));
                            if (reverse) tree.createVerbalTransition(to_state, current, (w!=null?input.toString(w.start,w.stop):null), (from!=null?from.getLine():0));
                     

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "transition"


    public static class word_outputs_return extends ParserRuleReturnScope {
        public ArrayList<String[]> list;
    };


    // $ANTLR start "word_outputs"
    // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:184:1: word_outputs returns [ArrayList<String[]> list] : ( word_output | '\\(' w= word_outputs ( ',' t= word_outputs )* '\\)' );
    public final AutomationLangParser.word_outputs_return word_outputs() throws RecognitionException {
        AutomationLangParser.word_outputs_return retval = new AutomationLangParser.word_outputs_return();
        retval.start = input.LT(1);


        AutomationLangParser.word_outputs_return w =null;

        AutomationLangParser.word_outputs_return t =null;

        ArrayList<String[]> word_output12 =null;


        retval.list = new ArrayList<String[]>();
        try {
            // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:186:2: ( word_output | '\\(' w= word_outputs ( ',' t= word_outputs )* '\\)' )
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==CHAR||(LA23_0 >= ID && LA23_0 <= INT)||LA23_0==STRING) ) {
                alt23=1;
            }
            else if ( (LA23_0==24) ) {
                alt23=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;

            }
            switch (alt23) {
                case 1 :
                    // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:186:4: word_output
                    {
                    pushFollow(FOLLOW_word_output_in_word_outputs534);
                    word_output12=word_output();

                    state._fsp--;


                    retval.list.addAll(word_output12);

                    }
                    break;
                case 2 :
                    // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:187:4: '\\(' w= word_outputs ( ',' t= word_outputs )* '\\)'
                    {
                    match(input,24,FOLLOW_24_in_word_outputs541); 

                    pushFollow(FOLLOW_word_outputs_in_word_outputs545);
                    w=word_outputs();

                    state._fsp--;


                    retval.list.addAll((w!=null?w.list:null));

                    // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:187:49: ( ',' t= word_outputs )*
                    loop22:
                    do {
                        int alt22=2;
                        int LA22_0 = input.LA(1);

                        if ( (LA22_0==17) ) {
                            alt22=1;
                        }


                        switch (alt22) {
                    	case 1 :
                    	    // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:187:50: ',' t= word_outputs
                    	    {
                    	    match(input,17,FOLLOW_17_in_word_outputs550); 

                    	    pushFollow(FOLLOW_word_outputs_in_word_outputs554);
                    	    t=word_outputs();

                    	    state._fsp--;


                    	    retval.list.addAll((t!=null?t.list:null));

                    	    }
                    	    break;

                    	default :
                    	    break loop22;
                        }
                    } while (true);


                    match(input,25,FOLLOW_25_in_word_outputs560); 

                    }
                    break;

            }
            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "word_outputs"



    // $ANTLR start "word_output"
    // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:189:1: word_output returns [ArrayList<String[]> list] : ( ID {...}?| word ( ':' STRING )? );
    public final ArrayList<String[]> word_output() throws RecognitionException {
        ArrayList<String[]> list = null;


        Token ID13=null;
        Token STRING14=null;
        ArrayList<String> word15 =null;


        list = new ArrayList<String[]>();
        try {
            // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:191:2: ( ID {...}?| word ( ':' STRING )? )
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==ID) ) {
                alt25=1;
            }
            else if ( (LA25_0==CHAR||LA25_0==INT||LA25_0==STRING) ) {
                alt25=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;

            }
            switch (alt25) {
                case 1 :
                    // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:191:4: ID {...}?
                    {
                    ID13=(Token)match(input,ID,FOLLOW_ID_in_word_output579); 

                    if ( !((varExists((ID13!=null?ID13.getText():null)) && current_var_def_id != (ID13!=null?ID13.getText():null))) ) {
                        throw new FailedPredicateException(input, "word_output", "varExists($ID.text) && current_var_def_id != $ID.text");
                    }

                    list.addAll(getVarValue((ID13!=null?ID13.getText():null)));

                    }
                    break;
                case 2 :
                    // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:192:11: word ( ':' STRING )?
                    {
                    pushFollow(FOLLOW_word_in_word_output595);
                    word15=word();

                    state._fsp--;


                    // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:192:16: ( ':' STRING )?
                    int alt24=2;
                    int LA24_0 = input.LA(1);

                    if ( (LA24_0==21) ) {
                        alt24=1;
                    }
                    switch (alt24) {
                        case 1 :
                            // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:192:17: ':' STRING
                            {
                            match(input,21,FOLLOW_21_in_word_output598); 

                            STRING14=(Token)match(input,STRING,FOLLOW_STRING_in_word_output600); 

                            }
                            break;

                    }



                    	String output = gsv((STRING14!=null?STRING14.getText():null));
                    	if (output == ""){
                    		for (String w : word15){
                    			list.add(new String[]{w, ""});
                    		}
                    	} else {
                    		for (String w : word15){
                    			list.add(new String[]{w, output.replaceAll("$", w)});
                    		}
                    	}
                    	

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return list;
    }
    // $ANTLR end "word_output"



    // $ANTLR start "word"
    // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:207:1: word returns [ArrayList<String> list] : t= word_part ( ',' l= word_part )* ;
    public final ArrayList<String> word() throws RecognitionException {
        ArrayList<String> list = null;


        ArrayList<String> t =null;

        ArrayList<String> l =null;


        list = new ArrayList<String>();
        try {
            // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:209:3: (t= word_part ( ',' l= word_part )* )
            // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:209:5: t= word_part ( ',' l= word_part )*
            {
            pushFollow(FOLLOW_word_part_in_word629);
            t=word_part();

            state._fsp--;


            list.addAll(t);

            // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:209:42: ( ',' l= word_part )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==17) ) {
                    switch ( input.LA(2) ) {
                    case ID:
                        {
                        alt26=1;
                        }
                        break;
                    case CHAR:
                        {
                        alt26=1;
                        }
                        break;
                    case INT:
                        {
                        alt26=1;
                        }
                        break;
                    case STRING:
                        {
                        alt26=1;
                        }
                        break;

                    }

                }


                switch (alt26) {
            	case 1 :
            	    // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:209:43: ',' l= word_part
            	    {
            	    match(input,17,FOLLOW_17_in_word634); 

            	    pushFollow(FOLLOW_word_part_in_word638);
            	    l=word_part();

            	    state._fsp--;


            	    list.addAll(l);

            	    }
            	    break;

            	default :
            	    break loop26;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return list;
    }
    // $ANTLR end "word"



    // $ANTLR start "word_part"
    // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:212:1: word_part returns [ArrayList<String> list] : (fp= range_part_var '..' ( INT | single_var ) range_points lp= range_part_var |fp= range_part_var range_points lp= range_part_var | CHAR | INT | STRING | ID {...}?);
    public final ArrayList<String> word_part() throws RecognitionException {
        ArrayList<String> list = null;


        Token INT16=null;
        Token CHAR20=null;
        Token INT21=null;
        Token STRING22=null;
        Token ID23=null;
        String fp =null;

        String lp =null;

        String single_var17 =null;

        boolean range_points18 =false;

        boolean range_points19 =false;


        list = new ArrayList<String>(); int incr = 0;
        try {
            // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:214:2: (fp= range_part_var '..' ( INT | single_var ) range_points lp= range_part_var |fp= range_part_var range_points lp= range_part_var | CHAR | INT | STRING | ID {...}?)
            int alt28=6;
            switch ( input.LA(1) ) {
            case CHAR:
                {
                switch ( input.LA(2) ) {
                case 19:
                    {
                    switch ( input.LA(3) ) {
                    case INT:
                        {
                        int LA28_11 = input.LA(4);

                        if ( ((LA28_11 >= 19 && LA28_11 <= 20)) ) {
                            alt28=1;
                        }
                        else if ( (LA28_11==EOF||LA28_11==NEWLINE||(LA28_11 >= 17 && LA28_11 <= 18)||LA28_11==21||LA28_11==25) ) {
                            alt28=2;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 28, 11, input);

                            throw nvae;

                        }
                        }
                        break;
                    case ID:
                        {
                        int LA28_12 = input.LA(4);

                        if ( ((LA28_12 >= 19 && LA28_12 <= 20)) ) {
                            alt28=1;
                        }
                        else if ( (LA28_12==EOF||LA28_12==NEWLINE||(LA28_12 >= 17 && LA28_12 <= 18)||LA28_12==21||LA28_12==25) ) {
                            alt28=2;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 28, 12, input);

                            throw nvae;

                        }
                        }
                        break;
                    case CHAR:
                    case STRING:
                        {
                        alt28=2;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 28, 5, input);

                        throw nvae;

                    }

                    }
                    break;
                case 20:
                    {
                    alt28=2;
                    }
                    break;
                case EOF:
                case NEWLINE:
                case 17:
                case 18:
                case 21:
                case 25:
                    {
                    alt28=3;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 28, 1, input);

                    throw nvae;

                }

                }
                break;
            case INT:
                {
                switch ( input.LA(2) ) {
                case 19:
                    {
                    switch ( input.LA(3) ) {
                    case INT:
                        {
                        int LA28_11 = input.LA(4);

                        if ( ((LA28_11 >= 19 && LA28_11 <= 20)) ) {
                            alt28=1;
                        }
                        else if ( (LA28_11==EOF||LA28_11==NEWLINE||(LA28_11 >= 17 && LA28_11 <= 18)||LA28_11==21||LA28_11==25) ) {
                            alt28=2;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 28, 11, input);

                            throw nvae;

                        }
                        }
                        break;
                    case ID:
                        {
                        int LA28_12 = input.LA(4);

                        if ( ((LA28_12 >= 19 && LA28_12 <= 20)) ) {
                            alt28=1;
                        }
                        else if ( (LA28_12==EOF||LA28_12==NEWLINE||(LA28_12 >= 17 && LA28_12 <= 18)||LA28_12==21||LA28_12==25) ) {
                            alt28=2;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 28, 12, input);

                            throw nvae;

                        }
                        }
                        break;
                    case CHAR:
                    case STRING:
                        {
                        alt28=2;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 28, 5, input);

                        throw nvae;

                    }

                    }
                    break;
                case 20:
                    {
                    alt28=2;
                    }
                    break;
                case EOF:
                case NEWLINE:
                case 17:
                case 18:
                case 21:
                case 25:
                    {
                    alt28=4;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 28, 2, input);

                    throw nvae;

                }

                }
                break;
            case STRING:
                {
                switch ( input.LA(2) ) {
                case 19:
                    {
                    switch ( input.LA(3) ) {
                    case INT:
                        {
                        int LA28_11 = input.LA(4);

                        if ( ((LA28_11 >= 19 && LA28_11 <= 20)) ) {
                            alt28=1;
                        }
                        else if ( (LA28_11==EOF||LA28_11==NEWLINE||(LA28_11 >= 17 && LA28_11 <= 18)||LA28_11==21||LA28_11==25) ) {
                            alt28=2;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 28, 11, input);

                            throw nvae;

                        }
                        }
                        break;
                    case ID:
                        {
                        int LA28_12 = input.LA(4);

                        if ( ((LA28_12 >= 19 && LA28_12 <= 20)) ) {
                            alt28=1;
                        }
                        else if ( (LA28_12==EOF||LA28_12==NEWLINE||(LA28_12 >= 17 && LA28_12 <= 18)||LA28_12==21||LA28_12==25) ) {
                            alt28=2;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 28, 12, input);

                            throw nvae;

                        }
                        }
                        break;
                    case CHAR:
                    case STRING:
                        {
                        alt28=2;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 28, 5, input);

                        throw nvae;

                    }

                    }
                    break;
                case 20:
                    {
                    alt28=2;
                    }
                    break;
                case EOF:
                case NEWLINE:
                case 17:
                case 18:
                case 21:
                case 25:
                    {
                    alt28=5;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 28, 3, input);

                    throw nvae;

                }

                }
                break;
            case ID:
                {
                switch ( input.LA(2) ) {
                case 19:
                    {
                    switch ( input.LA(3) ) {
                    case INT:
                        {
                        int LA28_11 = input.LA(4);

                        if ( ((LA28_11 >= 19 && LA28_11 <= 20)) ) {
                            alt28=1;
                        }
                        else if ( (LA28_11==EOF||LA28_11==NEWLINE||(LA28_11 >= 17 && LA28_11 <= 18)||LA28_11==21||LA28_11==25) ) {
                            alt28=2;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 28, 11, input);

                            throw nvae;

                        }
                        }
                        break;
                    case ID:
                        {
                        int LA28_12 = input.LA(4);

                        if ( ((LA28_12 >= 19 && LA28_12 <= 20)) ) {
                            alt28=1;
                        }
                        else if ( (LA28_12==EOF||LA28_12==NEWLINE||(LA28_12 >= 17 && LA28_12 <= 18)||LA28_12==21||LA28_12==25) ) {
                            alt28=2;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 28, 12, input);

                            throw nvae;

                        }
                        }
                        break;
                    case CHAR:
                    case STRING:
                        {
                        alt28=2;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 28, 5, input);

                        throw nvae;

                    }

                    }
                    break;
                case 20:
                    {
                    alt28=2;
                    }
                    break;
                case EOF:
                case NEWLINE:
                case 17:
                case 18:
                case 21:
                case 25:
                    {
                    alt28=6;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 28, 4, input);

                    throw nvae;

                }

                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;

            }

            switch (alt28) {
                case 1 :
                    // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:214:4: fp= range_part_var '..' ( INT | single_var ) range_points lp= range_part_var
                    {
                    pushFollow(FOLLOW_range_part_var_in_word_part665);
                    fp=range_part_var();

                    state._fsp--;


                    match(input,19,FOLLOW_19_in_word_part668); 

                    // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:214:28: ( INT | single_var )
                    int alt27=2;
                    int LA27_0 = input.LA(1);

                    if ( (LA27_0==INT) ) {
                        alt27=1;
                    }
                    else if ( (LA27_0==ID) ) {
                        alt27=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 27, 0, input);

                        throw nvae;

                    }
                    switch (alt27) {
                        case 1 :
                            // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:214:29: INT
                            {
                            INT16=(Token)match(input,INT,FOLLOW_INT_in_word_part671); 

                            incr = ipar((INT16!=null?INT16.getText():null));

                            }
                            break;
                        case 2 :
                            // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:214:61: single_var
                            {
                            pushFollow(FOLLOW_single_var_in_word_part677);
                            single_var17=single_var();

                            state._fsp--;


                            incr = ipar(single_var17);

                            }
                            break;

                    }


                    pushFollow(FOLLOW_range_points_in_word_part682);
                    range_points18=range_points();

                    state._fsp--;


                    pushFollow(FOLLOW_range_part_var_in_word_part686);
                    lp=range_part_var();

                    state._fsp--;



                    		list = Utils.range(fp, lp, incr, range_points18);
                    	

                    }
                    break;
                case 2 :
                    // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:218:4: fp= range_part_var range_points lp= range_part_var
                    {
                    pushFollow(FOLLOW_range_part_var_in_word_part696);
                    fp=range_part_var();

                    state._fsp--;


                    pushFollow(FOLLOW_range_points_in_word_part698);
                    range_points19=range_points();

                    state._fsp--;


                    pushFollow(FOLLOW_range_part_var_in_word_part702);
                    lp=range_part_var();

                    state._fsp--;



                    		list = Utils.range(fp, lp, range_points19);
                    	

                    }
                    break;
                case 3 :
                    // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:222:4: CHAR
                    {
                    CHAR20=(Token)match(input,CHAR,FOLLOW_CHAR_in_word_part710); 

                    list.add(gsv((CHAR20!=null?CHAR20.getText():null)));

                    }
                    break;
                case 4 :
                    // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:223:4: INT
                    {
                    INT21=(Token)match(input,INT,FOLLOW_INT_in_word_part717); 

                    list.add((INT21!=null?INT21.getText():null));

                    }
                    break;
                case 5 :
                    // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:224:4: STRING
                    {
                    STRING22=(Token)match(input,STRING,FOLLOW_STRING_in_word_part724); 

                    list.add(gsv((STRING22!=null?STRING22.getText():null)));

                    }
                    break;
                case 6 :
                    // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:225:11: ID {...}?
                    {
                    ID23=(Token)match(input,ID,FOLLOW_ID_in_word_part738); 

                    if ( !((varExists((ID23!=null?ID23.getText():null)) && current_var_def_id != (ID23!=null?ID23.getText():null))) ) {
                        throw new FailedPredicateException(input, "word_part", "varExists($ID.text) && current_var_def_id != $ID.text");
                    }

                    for (String[] arr : getVarValue((ID23!=null?ID23.getText():null))){
                                   list.add(arr[0]);
                             }

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return list;
    }
    // $ANTLR end "word_part"



    // $ANTLR start "range_part_var"
    // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:231:1: range_part_var returns [String value] : ( range_part | single_var );
    public final String range_part_var() throws RecognitionException {
        String value = null;


        String range_part24 =null;

        String single_var25 =null;


        try {
            // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:232:10: ( range_part | single_var )
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==CHAR||LA29_0==INT||LA29_0==STRING) ) {
                alt29=1;
            }
            else if ( (LA29_0==ID) ) {
                alt29=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;

            }
            switch (alt29) {
                case 1 :
                    // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:232:13: range_part
                    {
                    pushFollow(FOLLOW_range_part_in_range_part_var777);
                    range_part24=range_part();

                    state._fsp--;


                    value = range_part24;

                    }
                    break;
                case 2 :
                    // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:233:13: single_var
                    {
                    pushFollow(FOLLOW_single_var_in_range_part_var793);
                    single_var25=single_var();

                    state._fsp--;


                    value = single_var25;

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return value;
    }
    // $ANTLR end "range_part_var"



    // $ANTLR start "range_part"
    // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:236:1: range_part returns [String value] : (ce= CHAR |ie= INT |se= STRING );
    public final String range_part() throws RecognitionException {
        String value = null;


        Token ce=null;
        Token ie=null;
        Token se=null;

        try {
            // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:237:2: (ce= CHAR |ie= INT |se= STRING )
            int alt30=3;
            switch ( input.LA(1) ) {
            case CHAR:
                {
                alt30=1;
                }
                break;
            case INT:
                {
                alt30=2;
                }
                break;
            case STRING:
                {
                alt30=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 0, input);

                throw nvae;

            }

            switch (alt30) {
                case 1 :
                    // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:237:4: ce= CHAR
                    {
                    ce=(Token)match(input,CHAR,FOLLOW_CHAR_in_range_part820); 

                    value = gsv((ce!=null?ce.getText():null));

                    }
                    break;
                case 2 :
                    // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:238:4: ie= INT
                    {
                    ie=(Token)match(input,INT,FOLLOW_INT_in_range_part829); 

                    value = (ie!=null?ie.getText():null);

                    }
                    break;
                case 3 :
                    // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:239:4: se= STRING
                    {
                    se=(Token)match(input,STRING,FOLLOW_STRING_in_range_part838); 

                    value = gsv((se!=null?se.getText():null));

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return value;
    }
    // $ANTLR end "range_part"



    // $ANTLR start "range_points"
    // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:241:1: range_points returns [boolean include_end] : ( '..' | '...' );
    public final boolean range_points() throws RecognitionException {
        boolean include_end = false;


        try {
            // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:242:2: ( '..' | '...' )
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==19) ) {
                alt31=1;
            }
            else if ( (LA31_0==20) ) {
                alt31=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 31, 0, input);

                throw nvae;

            }
            switch (alt31) {
                case 1 :
                    // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:242:4: '..'
                    {
                    match(input,19,FOLLOW_19_in_range_points854); 

                    include_end = true;

                    }
                    break;
                case 2 :
                    // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:243:4: '...'
                    {
                    match(input,20,FOLLOW_20_in_range_points861); 

                    include_end = false;

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return include_end;
    }
    // $ANTLR end "range_points"

    // Delegated rules


 

    public static final BitSet FOLLOW_stat_in_prog32 = new BitSet(new long[]{0x0000000800840A02L});
    public static final BitSet FOLLOW_declaration_in_stat47 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_transition_in_stat51 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_var_def_in_stat55 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_options_rule_in_stat59 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_set_in_stat62 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NEWLINE_in_stat73 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_options_rule85 = new BitSet(new long[]{0x0000004000000800L});
    public static final BitSet FOLLOW_NEWLINE_in_options_rule88 = new BitSet(new long[]{0x000000A560000800L});
    public static final BitSet FOLLOW_38_in_options_rule92 = new BitSet(new long[]{0x000000A560000800L});
    public static final BitSet FOLLOW_NEWLINE_in_options_rule94 = new BitSet(new long[]{0x000000A560000800L});
    public static final BitSet FOLLOW_option_line_in_options_rule99 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_NEWLINE_in_options_rule102 = new BitSet(new long[]{0x000000A560000800L});
    public static final BitSet FOLLOW_30_in_options_rule107 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_NEWLINE_in_options_rule109 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_options_rule113 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_NEWLINE_in_options_rule115 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_option_line129 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_option_line131 = new BitSet(new long[]{0x0000000280000000L});
    public static final BitSet FOLLOW_31_in_option_line139 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_option_line147 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_option_line158 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_option_line160 = new BitSet(new long[]{0x0000001010000000L});
    public static final BitSet FOLLOW_36_in_option_line168 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_option_line176 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_option_line187 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_option_line189 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_INT_in_option_line191 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_option_line199 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_option_line201 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_INT_in_option_line203 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_declaration222 = new BitSet(new long[]{0x0000000004204000L});
    public static final BitSet FOLLOW_STRING_in_declaration224 = new BitSet(new long[]{0x0000000004200000L});
    public static final BitSet FOLLOW_21_in_declaration228 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_FLAG_in_declaration232 = new BitSet(new long[]{0x0000000004020000L});
    public static final BitSet FOLLOW_17_in_declaration237 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_FLAG_in_declaration241 = new BitSet(new long[]{0x0000000004020000L});
    public static final BitSet FOLLOW_opt_position_in_declaration249 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_opt_position273 = new BitSet(new long[]{0x0000000000002400L});
    public static final BitSet FOLLOW_coord_in_opt_position277 = new BitSet(new long[]{0x0000000008020000L});
    public static final BitSet FOLLOW_17_in_opt_position283 = new BitSet(new long[]{0x0000000000002400L});
    public static final BitSet FOLLOW_coord_in_opt_position287 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_opt_position293 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PERCENT_in_coord316 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_coord323 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_var_def354 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_var_def356 = new BitSet(new long[]{0x0000000001004610L});
    public static final BitSet FOLLOW_word_outputs_in_var_def358 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_var389 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_single_var422 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_transition462 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_transition466 = new BitSet(new long[]{0x0000000001004610L});
    public static final BitSet FOLLOW_23_in_transition474 = new BitSet(new long[]{0x0000000001004610L});
    public static final BitSet FOLLOW_18_in_transition484 = new BitSet(new long[]{0x0000000001004610L});
    public static final BitSet FOLLOW_word_outputs_in_transition493 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_18_in_transition496 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_ID_in_transition500 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_40_in_transition505 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_word_output_in_word_outputs534 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_word_outputs541 = new BitSet(new long[]{0x0000000001004610L});
    public static final BitSet FOLLOW_word_outputs_in_word_outputs545 = new BitSet(new long[]{0x0000000002020000L});
    public static final BitSet FOLLOW_17_in_word_outputs550 = new BitSet(new long[]{0x0000000001004610L});
    public static final BitSet FOLLOW_word_outputs_in_word_outputs554 = new BitSet(new long[]{0x0000000002020000L});
    public static final BitSet FOLLOW_25_in_word_outputs560 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_word_output579 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_word_in_word_output595 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_21_in_word_output598 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_STRING_in_word_output600 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_word_part_in_word629 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_17_in_word634 = new BitSet(new long[]{0x0000000000004610L});
    public static final BitSet FOLLOW_word_part_in_word638 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_range_part_var_in_word_part665 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_word_part668 = new BitSet(new long[]{0x0000000000000600L});
    public static final BitSet FOLLOW_INT_in_word_part671 = new BitSet(new long[]{0x0000000000180000L});
    public static final BitSet FOLLOW_single_var_in_word_part677 = new BitSet(new long[]{0x0000000000180000L});
    public static final BitSet FOLLOW_range_points_in_word_part682 = new BitSet(new long[]{0x0000000000004610L});
    public static final BitSet FOLLOW_range_part_var_in_word_part686 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_range_part_var_in_word_part696 = new BitSet(new long[]{0x0000000000180000L});
    public static final BitSet FOLLOW_range_points_in_word_part698 = new BitSet(new long[]{0x0000000000004610L});
    public static final BitSet FOLLOW_range_part_var_in_word_part702 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CHAR_in_word_part710 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_word_part717 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_word_part724 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_word_part738 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_range_part_in_range_part_var777 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_single_var_in_range_part_var793 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CHAR_in_range_part820 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_range_part829 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_range_part838 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_range_points854 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_range_points861 = new BitSet(new long[]{0x0000000000000002L});

}