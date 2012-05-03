// $ANTLR 3.4 C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g 2012-04-29 18:53:35

package automatonlang;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class AutomatonLangLexer extends Lexer {
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
    // delegators
    public Lexer[] getDelegates() {
        return new Lexer[] {};
    }

    public AutomatonLangLexer() {} 
    public AutomatonLangLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public AutomatonLangLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);
    }
    public String getGrammarFileName() { return "C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g"; }

    // $ANTLR start "T__17"
    public final void mT__17() throws RecognitionException {
        try {
            int _type = T__17;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:6:7: ( ',' )
            // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:6:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__17"

    // $ANTLR start "T__18"
    public final void mT__18() throws RecognitionException {
        try {
            int _type = T__18;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:7:7: ( '-' )
            // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:7:9: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__18"

    // $ANTLR start "T__19"
    public final void mT__19() throws RecognitionException {
        try {
            int _type = T__19;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:8:7: ( '..' )
            // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:8:9: '..'
            {
            match(".."); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__19"

    // $ANTLR start "T__20"
    public final void mT__20() throws RecognitionException {
        try {
            int _type = T__20;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:9:7: ( '...' )
            // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:9:9: '...'
            {
            match("..."); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__20"

    // $ANTLR start "T__21"
    public final void mT__21() throws RecognitionException {
        try {
            int _type = T__21;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:10:7: ( ':' )
            // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:10:9: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__21"

    // $ANTLR start "T__22"
    public final void mT__22() throws RecognitionException {
        try {
            int _type = T__22;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:11:7: ( '=' )
            // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:11:9: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__22"

    // $ANTLR start "T__23"
    public final void mT__23() throws RecognitionException {
        try {
            int _type = T__23;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:12:7: ( '>' )
            // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:12:9: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__23"

    // $ANTLR start "T__24"
    public final void mT__24() throws RecognitionException {
        try {
            int _type = T__24;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:13:7: ( '\\(' )
            // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:13:9: '\\('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__24"

    // $ANTLR start "T__25"
    public final void mT__25() throws RecognitionException {
        try {
            int _type = T__25;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:14:7: ( '\\)' )
            // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:14:9: '\\)'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__25"

    // $ANTLR start "T__26"
    public final void mT__26() throws RecognitionException {
        try {
            int _type = T__26;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:15:7: ( '\\[' )
            // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:15:9: '\\['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__26"

    // $ANTLR start "T__27"
    public final void mT__27() throws RecognitionException {
        try {
            int _type = T__27;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:16:7: ( ']' )
            // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:16:9: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__27"

    // $ANTLR start "T__28"
    public final void mT__28() throws RecognitionException {
        try {
            int _type = T__28;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:17:7: ( 'circular' )
            // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:17:9: 'circular'
            {
            match("circular"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__28"

    // $ANTLR start "T__29"
    public final void mT__29() throws RecognitionException {
        try {
            int _type = T__29;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:18:7: ( 'distribution' )
            // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:18:9: 'distribution'
            {
            match("distribution"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__29"

    // $ANTLR start "T__30"
    public final void mT__30() throws RecognitionException {
        try {
            int _type = T__30;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:19:7: ( 'end' )
            // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:19:9: 'end'
            {
            match("end"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__30"

    // $ANTLR start "T__31"
    public final void mT__31() throws RecognitionException {
        try {
            int _type = T__31;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:20:7: ( 'finite' )
            // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:20:9: 'finite'
            {
            match("finite"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__31"

    // $ANTLR start "T__32"
    public final void mT__32() throws RecognitionException {
        try {
            int _type = T__32;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:21:7: ( 'height' )
            // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:21:9: 'height'
            {
            match("height"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__32"

    // $ANTLR start "T__33"
    public final void mT__33() throws RecognitionException {
        try {
            int _type = T__33;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:22:7: ( 'mealy' )
            // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:22:9: 'mealy'
            {
            match("mealy"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__33"

    // $ANTLR start "T__34"
    public final void mT__34() throws RecognitionException {
        try {
            int _type = T__34;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:23:7: ( 'mode' )
            // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:23:9: 'mode'
            {
            match("mode"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__34"

    // $ANTLR start "T__35"
    public final void mT__35() throws RecognitionException {
        try {
            int _type = T__35;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:24:7: ( 'options' )
            // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:24:9: 'options'
            {
            match("options"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__35"

    // $ANTLR start "T__36"
    public final void mT__36() throws RecognitionException {
        try {
            int _type = T__36;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:25:7: ( 'random' )
            // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:25:9: 'random'
            {
            match("random"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__36"

    // $ANTLR start "T__37"
    public final void mT__37() throws RecognitionException {
        try {
            int _type = T__37;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:26:7: ( 'width' )
            // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:26:9: 'width'
            {
            match("width"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__37"

    // $ANTLR start "T__38"
    public final void mT__38() throws RecognitionException {
        try {
            int _type = T__38;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:27:7: ( '{' )
            // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:27:9: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__38"

    // $ANTLR start "T__39"
    public final void mT__39() throws RecognitionException {
        try {
            int _type = T__39;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:28:7: ( '}' )
            // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:28:9: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__39"

    // $ANTLR start "T__40"
    public final void mT__40() throws RecognitionException {
        try {
            int _type = T__40;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:29:7: ( '~' )
            // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:29:9: '~'
            {
            match('~'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__40"

    // $ANTLR start "FLAG"
    public final void mFLAG() throws RecognitionException {
        try {
            int _type = FLAG;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:246:6: ( 'final' | 'initial' )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='f') ) {
                alt1=1;
            }
            else if ( (LA1_0=='i') ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;

            }
            switch (alt1) {
                case 1 :
                    // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:246:8: 'final'
                    {
                    match("final"); 



                    }
                    break;
                case 2 :
                    // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:247:5: 'initial'
                    {
                    match("initial"); 



                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "FLAG"

    // $ANTLR start "NEWLINE"
    public final void mNEWLINE() throws RecognitionException {
        try {
            int _type = NEWLINE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:250:2: ( ( '\\r' )? '\\n' | ( ';' )? )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0=='\n'||LA4_0=='\r') ) {
                alt4=1;
            }
            else {
                alt4=2;
            }
            switch (alt4) {
                case 1 :
                    // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:250:3: ( '\\r' )? '\\n'
                    {
                    // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:250:3: ( '\\r' )?
                    int alt2=2;
                    int LA2_0 = input.LA(1);

                    if ( (LA2_0=='\r') ) {
                        alt2=1;
                    }
                    switch (alt2) {
                        case 1 :
                            // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:250:3: '\\r'
                            {
                            match('\r'); 

                            }
                            break;

                    }


                    match('\n'); 

                    }
                    break;
                case 2 :
                    // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:251:4: ( ';' )?
                    {
                    // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:251:4: ( ';' )?
                    int alt3=2;
                    int LA3_0 = input.LA(1);

                    if ( (LA3_0==';') ) {
                        alt3=1;
                    }
                    switch (alt3) {
                        case 1 :
                            // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:251:4: ';'
                            {
                            match(';'); 

                            }
                            break;

                    }


                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "NEWLINE"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:254:5: ( ( ' ' | '\\t' )+ )
            // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:254:9: ( ' ' | '\\t' )+
            {
            // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:254:9: ( ' ' | '\\t' )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0=='\t'||LA5_0==' ') ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:
            	    {
            	    if ( input.LA(1)=='\t'||input.LA(1)==' ' ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt5 >= 1 ) break loop5;
                        EarlyExitException eee =
                            new EarlyExitException(5, input);
                        throw eee;
                }
                cnt5++;
            } while (true);


            skip();

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "WS"

    // $ANTLR start "ID"
    public final void mID() throws RecognitionException {
        try {
            int _type = ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:256:5: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
            // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:256:7: ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            {
            if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:256:31: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0 >= '0' && LA6_0 <= '9')||(LA6_0 >= 'A' && LA6_0 <= 'Z')||LA6_0=='_'||(LA6_0 >= 'a' && LA6_0 <= 'z')) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ID"

    // $ANTLR start "INT"
    public final void mINT() throws RecognitionException {
        try {
            int _type = INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:259:5: ( ( '+' | '-' )? ( '0' .. '9' )+ )
            // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:259:7: ( '+' | '-' )? ( '0' .. '9' )+
            {
            // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:259:7: ( '+' | '-' )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0=='+'||LA7_0=='-') ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:
                    {
                    if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    }
                    break;

            }


            // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:259:17: ( '0' .. '9' )+
            int cnt8=0;
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0 >= '0' && LA8_0 <= '9')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt8 >= 1 ) break loop8;
                        EarlyExitException eee =
                            new EarlyExitException(8, input);
                        throw eee;
                }
                cnt8++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "INT"

    // $ANTLR start "PERCENT"
    public final void mPERCENT() throws RecognitionException {
        try {
            int _type = PERCENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:261:9: ( ( '0' .. '9' )+ '%' )
            // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:261:11: ( '0' .. '9' )+ '%'
            {
            // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:261:11: ( '0' .. '9' )+
            int cnt9=0;
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( ((LA9_0 >= '0' && LA9_0 <= '9')) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt9 >= 1 ) break loop9;
                        EarlyExitException eee =
                            new EarlyExitException(9, input);
                        throw eee;
                }
                cnt9++;
            } while (true);


            match('%'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "PERCENT"

    // $ANTLR start "COMMENT"
    public final void mCOMMENT() throws RecognitionException {
        try {
            int _type = COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:264:5: ( ( '//' | '#' ) (~ ( '\\n' | '\\r' ) )* NEWLINE | '/*' ( options {greedy=false; } : . )* '*/' )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0=='/') ) {
                int LA13_1 = input.LA(2);

                if ( (LA13_1=='/') ) {
                    alt13=1;
                }
                else if ( (LA13_1=='*') ) {
                    alt13=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 13, 1, input);

                    throw nvae;

                }
            }
            else if ( (LA13_0=='#') ) {
                alt13=1;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;

            }
            switch (alt13) {
                case 1 :
                    // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:264:9: ( '//' | '#' ) (~ ( '\\n' | '\\r' ) )* NEWLINE
                    {
                    // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:264:9: ( '//' | '#' )
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( (LA10_0=='/') ) {
                        alt10=1;
                    }
                    else if ( (LA10_0=='#') ) {
                        alt10=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 10, 0, input);

                        throw nvae;

                    }
                    switch (alt10) {
                        case 1 :
                            // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:264:10: '//'
                            {
                            match("//"); 



                            }
                            break;
                        case 2 :
                            // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:264:17: '#'
                            {
                            match('#'); 

                            }
                            break;

                    }


                    // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:264:22: (~ ( '\\n' | '\\r' ) )*
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( ((LA11_0 >= '\u0000' && LA11_0 <= '\t')||(LA11_0 >= '\u000B' && LA11_0 <= '\f')||(LA11_0 >= '\u000E' && LA11_0 <= '\uFFFF')) ) {
                            alt11=1;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:
                    	    {
                    	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\t')||(input.LA(1) >= '\u000B' && input.LA(1) <= '\f')||(input.LA(1) >= '\u000E' && input.LA(1) <= '\uFFFF') ) {
                    	        input.consume();
                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop11;
                        }
                    } while (true);


                    mNEWLINE(); 


                    _channel=HIDDEN;

                    }
                    break;
                case 2 :
                    // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:265:9: '/*' ( options {greedy=false; } : . )* '*/'
                    {
                    match("/*"); 



                    // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:265:14: ( options {greedy=false; } : . )*
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0=='*') ) {
                            int LA12_1 = input.LA(2);

                            if ( (LA12_1=='/') ) {
                                alt12=2;
                            }
                            else if ( ((LA12_1 >= '\u0000' && LA12_1 <= '.')||(LA12_1 >= '0' && LA12_1 <= '\uFFFF')) ) {
                                alt12=1;
                            }


                        }
                        else if ( ((LA12_0 >= '\u0000' && LA12_0 <= ')')||(LA12_0 >= '+' && LA12_0 <= '\uFFFF')) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:265:42: .
                    	    {
                    	    matchAny(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop12;
                        }
                    } while (true);


                    match("*/"); 



                    _channel=HIDDEN;

                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "COMMENT"

    // $ANTLR start "STRING"
    public final void mSTRING() throws RecognitionException {
        try {
            int _type = STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:268:5: ( '\"' ( ESC_SEQ |~ ( '\\\\' | '\"' ) )* '\"' )
            // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:268:8: '\"' ( ESC_SEQ |~ ( '\\\\' | '\"' ) )* '\"'
            {
            match('\"'); 

            // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:268:12: ( ESC_SEQ |~ ( '\\\\' | '\"' ) )*
            loop14:
            do {
                int alt14=3;
                int LA14_0 = input.LA(1);

                if ( (LA14_0=='\\') ) {
                    alt14=1;
                }
                else if ( ((LA14_0 >= '\u0000' && LA14_0 <= '!')||(LA14_0 >= '#' && LA14_0 <= '[')||(LA14_0 >= ']' && LA14_0 <= '\uFFFF')) ) {
                    alt14=2;
                }


                switch (alt14) {
            	case 1 :
            	    // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:268:14: ESC_SEQ
            	    {
            	    mESC_SEQ(); 


            	    }
            	    break;
            	case 2 :
            	    // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:268:24: ~ ( '\\\\' | '\"' )
            	    {
            	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '!')||(input.LA(1) >= '#' && input.LA(1) <= '[')||(input.LA(1) >= ']' && input.LA(1) <= '\uFFFF') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);


            match('\"'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "STRING"

    // $ANTLR start "CHAR"
    public final void mCHAR() throws RecognitionException {
        try {
            int _type = CHAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:270:5: ( '\\'' ( ESC_SEQ |~ ( '\\'' | '\\\\' ) ) '\\'' )
            // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:270:8: '\\'' ( ESC_SEQ |~ ( '\\'' | '\\\\' ) ) '\\''
            {
            match('\''); 

            // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:270:13: ( ESC_SEQ |~ ( '\\'' | '\\\\' ) )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0=='\\') ) {
                alt15=1;
            }
            else if ( ((LA15_0 >= '\u0000' && LA15_0 <= '&')||(LA15_0 >= '(' && LA15_0 <= '[')||(LA15_0 >= ']' && LA15_0 <= '\uFFFF')) ) {
                alt15=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;

            }
            switch (alt15) {
                case 1 :
                    // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:270:15: ESC_SEQ
                    {
                    mESC_SEQ(); 


                    }
                    break;
                case 2 :
                    // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:270:25: ~ ( '\\'' | '\\\\' )
                    {
                    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '&')||(input.LA(1) >= '(' && input.LA(1) <= '[')||(input.LA(1) >= ']' && input.LA(1) <= '\uFFFF') ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    }
                    break;

            }


            match('\''); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "CHAR"

    // $ANTLR start "HEX_DIGIT"
    public final void mHEX_DIGIT() throws RecognitionException {
        try {
            // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:275:11: ( ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) )
            // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:
            {
            if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'F')||(input.LA(1) >= 'a' && input.LA(1) <= 'f') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "HEX_DIGIT"

    // $ANTLR start "ESC_SEQ"
    public final void mESC_SEQ() throws RecognitionException {
        try {
            // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:279:5: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | UNICODE_ESC | OCTAL_ESC )
            int alt16=3;
            int LA16_0 = input.LA(1);

            if ( (LA16_0=='\\') ) {
                switch ( input.LA(2) ) {
                case '\"':
                case '\'':
                case '\\':
                case 'b':
                case 'f':
                case 'n':
                case 'r':
                case 't':
                    {
                    alt16=1;
                    }
                    break;
                case 'u':
                    {
                    alt16=2;
                    }
                    break;
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                    {
                    alt16=3;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 16, 1, input);

                    throw nvae;

                }

            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;

            }
            switch (alt16) {
                case 1 :
                    // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:279:9: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' )
                    {
                    match('\\'); 

                    if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='\\'||input.LA(1)=='b'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||input.LA(1)=='t' ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    }
                    break;
                case 2 :
                    // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:280:9: UNICODE_ESC
                    {
                    mUNICODE_ESC(); 


                    }
                    break;
                case 3 :
                    // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:281:9: OCTAL_ESC
                    {
                    mOCTAL_ESC(); 


                    }
                    break;

            }

        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ESC_SEQ"

    // $ANTLR start "OCTAL_ESC"
    public final void mOCTAL_ESC() throws RecognitionException {
        try {
            // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:286:5: ( '\\\\' ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' ) | '\\\\' ( '0' .. '7' ) ( '0' .. '7' ) | '\\\\' ( '0' .. '7' ) )
            int alt17=3;
            int LA17_0 = input.LA(1);

            if ( (LA17_0=='\\') ) {
                int LA17_1 = input.LA(2);

                if ( ((LA17_1 >= '0' && LA17_1 <= '3')) ) {
                    int LA17_2 = input.LA(3);

                    if ( ((LA17_2 >= '0' && LA17_2 <= '7')) ) {
                        int LA17_4 = input.LA(4);

                        if ( ((LA17_4 >= '0' && LA17_4 <= '7')) ) {
                            alt17=1;
                        }
                        else {
                            alt17=2;
                        }
                    }
                    else {
                        alt17=3;
                    }
                }
                else if ( ((LA17_1 >= '4' && LA17_1 <= '7')) ) {
                    int LA17_3 = input.LA(3);

                    if ( ((LA17_3 >= '0' && LA17_3 <= '7')) ) {
                        alt17=2;
                    }
                    else {
                        alt17=3;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 17, 1, input);

                    throw nvae;

                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;

            }
            switch (alt17) {
                case 1 :
                    // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:286:9: '\\\\' ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' )
                    {
                    match('\\'); 

                    if ( (input.LA(1) >= '0' && input.LA(1) <= '3') ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    if ( (input.LA(1) >= '0' && input.LA(1) <= '7') ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    if ( (input.LA(1) >= '0' && input.LA(1) <= '7') ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    }
                    break;
                case 2 :
                    // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:287:9: '\\\\' ( '0' .. '7' ) ( '0' .. '7' )
                    {
                    match('\\'); 

                    if ( (input.LA(1) >= '0' && input.LA(1) <= '7') ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    if ( (input.LA(1) >= '0' && input.LA(1) <= '7') ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    }
                    break;
                case 3 :
                    // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:288:9: '\\\\' ( '0' .. '7' )
                    {
                    match('\\'); 

                    if ( (input.LA(1) >= '0' && input.LA(1) <= '7') ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    }
                    break;

            }

        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "OCTAL_ESC"

    // $ANTLR start "UNICODE_ESC"
    public final void mUNICODE_ESC() throws RecognitionException {
        try {
            // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:293:5: ( '\\\\' 'u' HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT )
            // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:293:9: '\\\\' 'u' HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT
            {
            match('\\'); 

            match('u'); 

            mHEX_DIGIT(); 


            mHEX_DIGIT(); 


            mHEX_DIGIT(); 


            mHEX_DIGIT(); 


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "UNICODE_ESC"

    public void mTokens() throws RecognitionException {
        // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:1:8: ( T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | FLAG | NEWLINE | WS | ID | INT | PERCENT | COMMENT | STRING | CHAR )
        int alt18=33;
        alt18 = dfa18.predict(input);
        switch (alt18) {
            case 1 :
                // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:1:10: T__17
                {
                mT__17(); 


                }
                break;
            case 2 :
                // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:1:16: T__18
                {
                mT__18(); 


                }
                break;
            case 3 :
                // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:1:22: T__19
                {
                mT__19(); 


                }
                break;
            case 4 :
                // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:1:28: T__20
                {
                mT__20(); 


                }
                break;
            case 5 :
                // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:1:34: T__21
                {
                mT__21(); 


                }
                break;
            case 6 :
                // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:1:40: T__22
                {
                mT__22(); 


                }
                break;
            case 7 :
                // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:1:46: T__23
                {
                mT__23(); 


                }
                break;
            case 8 :
                // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:1:52: T__24
                {
                mT__24(); 


                }
                break;
            case 9 :
                // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:1:58: T__25
                {
                mT__25(); 


                }
                break;
            case 10 :
                // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:1:64: T__26
                {
                mT__26(); 


                }
                break;
            case 11 :
                // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:1:70: T__27
                {
                mT__27(); 


                }
                break;
            case 12 :
                // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:1:76: T__28
                {
                mT__28(); 


                }
                break;
            case 13 :
                // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:1:82: T__29
                {
                mT__29(); 


                }
                break;
            case 14 :
                // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:1:88: T__30
                {
                mT__30(); 


                }
                break;
            case 15 :
                // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:1:94: T__31
                {
                mT__31(); 


                }
                break;
            case 16 :
                // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:1:100: T__32
                {
                mT__32(); 


                }
                break;
            case 17 :
                // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:1:106: T__33
                {
                mT__33(); 


                }
                break;
            case 18 :
                // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:1:112: T__34
                {
                mT__34(); 


                }
                break;
            case 19 :
                // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:1:118: T__35
                {
                mT__35(); 


                }
                break;
            case 20 :
                // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:1:124: T__36
                {
                mT__36(); 


                }
                break;
            case 21 :
                // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:1:130: T__37
                {
                mT__37(); 


                }
                break;
            case 22 :
                // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:1:136: T__38
                {
                mT__38(); 


                }
                break;
            case 23 :
                // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:1:142: T__39
                {
                mT__39(); 


                }
                break;
            case 24 :
                // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:1:148: T__40
                {
                mT__40(); 


                }
                break;
            case 25 :
                // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:1:154: FLAG
                {
                mFLAG(); 


                }
                break;
            case 26 :
                // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:1:159: NEWLINE
                {
                mNEWLINE(); 


                }
                break;
            case 27 :
                // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:1:167: WS
                {
                mWS(); 


                }
                break;
            case 28 :
                // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:1:170: ID
                {
                mID(); 


                }
                break;
            case 29 :
                // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:1:173: INT
                {
                mINT(); 


                }
                break;
            case 30 :
                // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:1:177: PERCENT
                {
                mPERCENT(); 


                }
                break;
            case 31 :
                // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:1:185: COMMENT
                {
                mCOMMENT(); 


                }
                break;
            case 32 :
                // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:1:193: STRING
                {
                mSTRING(); 


                }
                break;
            case 33 :
                // C:\\Users\\Johannes\\Code\\Automation\\src\\automation\\lang\\AutomationLang.g:1:200: CHAR
                {
                mCHAR(); 


                }
                break;

        }

    }


    protected DFA18 dfa18 = new DFA18(this);
    static final String DFA18_eotS =
        "\1\30\1\uffff\1\40\10\uffff\11\32\3\uffff\1\32\4\uffff\1\33\4\uffff"+
        "\1\57\13\32\3\uffff\2\32\1\75\12\32\1\uffff\4\32\1\115\7\32\1\125"+
        "\1\32\1\127\1\uffff\2\32\1\132\3\32\1\136\1\uffff\1\137\1\uffff"+
        "\1\32\1\141\1\uffff\3\32\2\uffff\1\145\1\uffff\1\125\1\146\1\32"+
        "\2\uffff\3\32\1\153\1\uffff";
    static final String DFA18_eofS =
        "\154\uffff";
    static final String DFA18_minS =
        "\1\11\1\uffff\1\60\1\56\7\uffff\2\151\1\156\1\151\2\145\1\160\1"+
        "\141\1\151\3\uffff\1\156\4\uffff\1\45\4\uffff\1\56\1\162\1\163\1"+
        "\144\1\156\1\151\1\141\1\144\1\164\1\156\1\144\1\151\3\uffff\1\143"+
        "\1\164\1\60\1\141\1\147\1\154\1\145\1\151\1\144\2\164\1\165\1\162"+
        "\1\uffff\1\164\1\154\1\150\1\171\1\60\2\157\1\150\1\151\1\154\1"+
        "\151\1\145\1\60\1\164\1\60\1\uffff\1\156\1\155\1\60\2\141\1\142"+
        "\1\60\1\uffff\1\60\1\uffff\1\163\1\60\1\uffff\1\154\1\162\1\165"+
        "\2\uffff\1\60\1\uffff\2\60\1\164\2\uffff\1\151\1\157\1\156\1\60"+
        "\1\uffff";
    static final String DFA18_maxS =
        "\1\176\1\uffff\1\71\1\56\7\uffff\2\151\1\156\1\151\1\145\1\157\1"+
        "\160\1\141\1\151\3\uffff\1\156\4\uffff\1\71\4\uffff\1\56\1\162\1"+
        "\163\1\144\1\156\1\151\1\141\1\144\1\164\1\156\1\144\1\151\3\uffff"+
        "\1\143\1\164\1\172\1\151\1\147\1\154\1\145\1\151\1\144\2\164\1\165"+
        "\1\162\1\uffff\1\164\1\154\1\150\1\171\1\172\2\157\1\150\1\151\1"+
        "\154\1\151\1\145\1\172\1\164\1\172\1\uffff\1\156\1\155\1\172\2\141"+
        "\1\142\1\172\1\uffff\1\172\1\uffff\1\163\1\172\1\uffff\1\154\1\162"+
        "\1\165\2\uffff\1\172\1\uffff\2\172\1\164\2\uffff\1\151\1\157\1\156"+
        "\1\172\1\uffff";
    static final String DFA18_acceptS =
        "\1\uffff\1\1\2\uffff\1\5\1\6\1\7\1\10\1\11\1\12\1\13\11\uffff\1"+
        "\26\1\27\1\30\1\uffff\1\32\1\33\1\34\1\35\1\uffff\1\37\1\40\1\41"+
        "\1\2\14\uffff\1\36\1\4\1\3\15\uffff\1\16\17\uffff\1\22\7\uffff\1"+
        "\31\1\uffff\1\21\2\uffff\1\25\3\uffff\1\17\1\20\1\uffff\1\24\3\uffff"+
        "\1\23\1\14\4\uffff\1\15";
    static final String DFA18_specialS =
        "\154\uffff}>";
    static final String[] DFA18_transitionS = {
            "\1\31\26\uffff\1\31\1\uffff\1\36\1\35\3\uffff\1\37\1\7\1\10"+
            "\1\uffff\1\33\1\1\1\2\1\3\1\35\12\34\1\4\2\uffff\1\5\1\6\2\uffff"+
            "\32\32\1\11\1\uffff\1\12\1\uffff\1\32\1\uffff\2\32\1\13\1\14"+
            "\1\15\1\16\1\32\1\17\1\27\3\32\1\20\1\32\1\21\2\32\1\22\4\32"+
            "\1\23\3\32\1\24\1\uffff\1\25\1\26",
            "",
            "\12\33",
            "\1\41",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\42",
            "\1\43",
            "\1\44",
            "\1\45",
            "\1\46",
            "\1\47\11\uffff\1\50",
            "\1\51",
            "\1\52",
            "\1\53",
            "",
            "",
            "",
            "\1\54",
            "",
            "",
            "",
            "",
            "\1\55\12\uffff\12\34",
            "",
            "",
            "",
            "",
            "\1\56",
            "\1\60",
            "\1\61",
            "\1\62",
            "\1\63",
            "\1\64",
            "\1\65",
            "\1\66",
            "\1\67",
            "\1\70",
            "\1\71",
            "\1\72",
            "",
            "",
            "",
            "\1\73",
            "\1\74",
            "\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
            "\1\77\7\uffff\1\76",
            "\1\100",
            "\1\101",
            "\1\102",
            "\1\103",
            "\1\104",
            "\1\105",
            "\1\106",
            "\1\107",
            "\1\110",
            "",
            "\1\111",
            "\1\112",
            "\1\113",
            "\1\114",
            "\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
            "\1\116",
            "\1\117",
            "\1\120",
            "\1\121",
            "\1\122",
            "\1\123",
            "\1\124",
            "\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
            "\1\126",
            "\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
            "",
            "\1\130",
            "\1\131",
            "\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
            "\1\133",
            "\1\134",
            "\1\135",
            "\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
            "",
            "\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
            "",
            "\1\140",
            "\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
            "",
            "\1\142",
            "\1\143",
            "\1\144",
            "",
            "",
            "\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
            "",
            "\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
            "\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
            "\1\147",
            "",
            "",
            "\1\150",
            "\1\151",
            "\1\152",
            "\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
            ""
    };

    static final short[] DFA18_eot = DFA.unpackEncodedString(DFA18_eotS);
    static final short[] DFA18_eof = DFA.unpackEncodedString(DFA18_eofS);
    static final char[] DFA18_min = DFA.unpackEncodedStringToUnsignedChars(DFA18_minS);
    static final char[] DFA18_max = DFA.unpackEncodedStringToUnsignedChars(DFA18_maxS);
    static final short[] DFA18_accept = DFA.unpackEncodedString(DFA18_acceptS);
    static final short[] DFA18_special = DFA.unpackEncodedString(DFA18_specialS);
    static final short[][] DFA18_transition;

    static {
        int numStates = DFA18_transitionS.length;
        DFA18_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA18_transition[i] = DFA.unpackEncodedString(DFA18_transitionS[i]);
        }
    }

    class DFA18 extends DFA {

        public DFA18(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 18;
            this.eot = DFA18_eot;
            this.eof = DFA18_eof;
            this.min = DFA18_min;
            this.max = DFA18_max;
            this.accept = DFA18_accept;
            this.special = DFA18_special;
            this.transition = DFA18_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | FLAG | NEWLINE | WS | ID | INT | PERCENT | COMMENT | STRING | CHAR );";
        }
    }
 

}