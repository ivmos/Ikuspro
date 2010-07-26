// $ANTLR 3.1.2 F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g 2009-11-20 22:37:37
 package ikuspro.interprete.c; 

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class CLexer extends Lexer {
    public static final int SENTENCIA_ASIG=16;
    public static final int DISTINTO=65;
    public static final int WHILE=58;
    public static final int FUNC_STRLEN=88;
    public static final int F_LEER=27;
    public static final int MOD=74;
    public static final int F_IMPRIMIR=25;
    public static final int OCTAL_ESC=97;
    public static final int LIBRERIA=98;
    public static final int CHAR=79;
    public static final int DO=59;
    public static final int NEGAR=29;
    public static final int NOT=75;
    public static final int LLAMADA=20;
    public static final int EOF=-1;
    public static final int LPAR=47;
    public static final int PARAM_ACTUAL=28;
    public static final int INCLUDE=23;
    public static final int DECLARACION_NOMBRE_FUNCION=10;
    public static final int RETURN=53;
    public static final int PREFIJO=33;
    public static final int EXPRESION=19;
    public static final int F_GETS=41;
    public static final int FUNCION=7;
    public static final int INDICE=38;
    public static final int NOMBRE_FUNC=15;
    public static final int FUNC_GETS=87;
    public static final int ELSE=57;
    public static final int IGNORAR=99;
    public static final int DECL_VAR=24;
    public static final int INT=76;
    public static final int MENORIGUAL=68;
    public static final int LONGITUD=35;
    public static final int PARAM_FORMAL=12;
    public static final int MENOSMENOS=81;
    public static final int ASIGNACION_REF=45;
    public static final int PUNTO=89;
    public static final int LISTA_PARAM_FORMALES=11;
    public static final int WS=91;
    public static final int FUNCIONES=6;
    public static final int OR=62;
    public static final int DECL_VAR_ARR=34;
    public static final int MAYOR=66;
    public static final int ASIG=61;
    public static final int IGUAL=64;
    public static final int PARAM_FORMAL_ARR=36;
    public static final int F_SQRT=43;
    public static final int FORMATO=26;
    public static final int COMENTCOMP=93;
    public static final int MENOS=71;
    public static final int MENOR=67;
    public static final int F_STRLEN=42;
    public static final int ASIGNACION=18;
    public static final int DECLVARS=31;
    public static final int FOR=60;
    public static final int FLOAT=77;
    public static final int AND=63;
    public static final int DEFINE=21;
    public static final int FUNCIMPRIMIR=84;
    public static final int F_POW=40;
    public static final int IF=56;
    public static final int ESC_SEQ=94;
    public static final int FUNC_SQRT=86;
    public static final int FUNCLEER=82;
    public static final int T__103=103;
    public static final int T__104=104;
    public static final int T__105=105;
    public static final int ELE_ARR=37;
    public static final int PROD=72;
    public static final int T__106=106;
    public static final int COMENTSIMPLE=92;
    public static final int IDENT=50;
    public static final int NOMBRE_VAR=14;
    public static final int RCOR=52;
    public static final int LCOR=51;
    public static final int MASMAS=80;
    public static final int VALOR=22;
    public static final int BLOQUE=9;
    public static final int DECL_VAR_REF=44;
    public static final int UNICODE_ESC=96;
    public static final int TIPO_BASE=13;
    public static final int EXPONENTE=90;
    public static final int AMPERSAND=83;
    public static final int HEX_DIGIT=95;
    public static final int T__102=102;
    public static final int T__101=101;
    public static final int T__100=100;
    public static final int COMA=49;
    public static final int PUNTOYCOMA=46;
    public static final int LCURL=54;
    public static final int DECLARACIONES_GLOBALES=5;
    public static final int SENTENCIA_CALL=17;
    public static final int POSTFIJO=32;
    public static final int DECL=39;
    public static final int MAS=70;
    public static final int RCURL=55;
    public static final int CABECERA_FUNCION=8;
    public static final int PROGRAMA=4;
    public static final int SENTENCIAS=30;
    public static final int RPAR=48;
    public static final int DIV=73;
    public static final int MAYORIGUAL=69;
    public static final int STRING=78;
    public static final int FUNC_POW=85;

    // delegates
    // delegators

    public CLexer() {;} 
    public CLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public CLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g"; }

    // $ANTLR start "T__100"
    public final void mT__100() throws RecognitionException {
        try {
            int _type = T__100;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:5:8: ( 'void' )
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:5:10: 'void'
            {
            match("void"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__100"

    // $ANTLR start "T__101"
    public final void mT__101() throws RecognitionException {
        try {
            int _type = T__101;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:6:8: ( 'char' )
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:6:10: 'char'
            {
            match("char"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__101"

    // $ANTLR start "T__102"
    public final void mT__102() throws RecognitionException {
        try {
            int _type = T__102;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:7:8: ( 'int' )
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:7:10: 'int'
            {
            match("int"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__102"

    // $ANTLR start "T__103"
    public final void mT__103() throws RecognitionException {
        try {
            int _type = T__103;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:8:8: ( 'float' )
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:8:10: 'float'
            {
            match("float"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__103"

    // $ANTLR start "T__104"
    public final void mT__104() throws RecognitionException {
        try {
            int _type = T__104;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:9:8: ( 'double' )
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:9:10: 'double'
            {
            match("double"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__104"

    // $ANTLR start "T__105"
    public final void mT__105() throws RecognitionException {
        try {
            int _type = T__105;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:10:8: ( '#define' )
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:10:10: '#define'
            {
            match("#define"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__105"

    // $ANTLR start "T__106"
    public final void mT__106() throws RecognitionException {
        try {
            int _type = T__106;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:11:8: ( '# define' )
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:11:10: '# define'
            {
            match("# define"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__106"

    // $ANTLR start "INT"
    public final void mINT() throws RecognitionException {
        try {
            int _type = INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:460:5: ( ( '0' .. '9' )+ )
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:460:7: ( '0' .. '9' )+
            {
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:460:7: ( '0' .. '9' )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='0' && LA1_0<='9')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:460:8: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "INT"

    // $ANTLR start "FUNCLEER"
    public final void mFUNCLEER() throws RecognitionException {
        try {
            int _type = FUNCLEER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:462:9: ( 'scanf' )
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:462:11: 'scanf'
            {
            match("scanf"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FUNCLEER"

    // $ANTLR start "FUNCIMPRIMIR"
    public final void mFUNCIMPRIMIR() throws RecognitionException {
        try {
            int _type = FUNCIMPRIMIR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:465:2: ( 'printf' )
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:465:4: 'printf'
            {
            match("printf"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FUNCIMPRIMIR"

    // $ANTLR start "FUNC_POW"
    public final void mFUNC_POW() throws RecognitionException {
        try {
            int _type = FUNC_POW;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:468:2: ( 'pow' )
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:468:4: 'pow'
            {
            match("pow"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FUNC_POW"

    // $ANTLR start "FUNC_SQRT"
    public final void mFUNC_SQRT() throws RecognitionException {
        try {
            int _type = FUNC_SQRT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:471:2: ( 'sqrt' )
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:471:4: 'sqrt'
            {
            match("sqrt"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FUNC_SQRT"

    // $ANTLR start "FUNC_GETS"
    public final void mFUNC_GETS() throws RecognitionException {
        try {
            int _type = FUNC_GETS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:474:2: ( 'gets' )
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:474:4: 'gets'
            {
            match("gets"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FUNC_GETS"

    // $ANTLR start "FUNC_STRLEN"
    public final void mFUNC_STRLEN() throws RecognitionException {
        try {
            int _type = FUNC_STRLEN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:477:2: ( 'strlen' )
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:477:4: 'strlen'
            {
            match("strlen"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FUNC_STRLEN"

    // $ANTLR start "IF"
    public final void mIF() throws RecognitionException {
        try {
            int _type = IF;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:480:4: ( 'if' )
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:480:6: 'if'
            {
            match("if"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "IF"

    // $ANTLR start "ELSE"
    public final void mELSE() throws RecognitionException {
        try {
            int _type = ELSE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:482:6: ( 'else' )
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:482:8: 'else'
            {
            match("else"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ELSE"

    // $ANTLR start "WHILE"
    public final void mWHILE() throws RecognitionException {
        try {
            int _type = WHILE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:484:7: ( 'while' )
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:484:9: 'while'
            {
            match("while"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WHILE"

    // $ANTLR start "DO"
    public final void mDO() throws RecognitionException {
        try {
            int _type = DO;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:486:4: ( 'do' )
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:486:6: 'do'
            {
            match("do"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DO"

    // $ANTLR start "FOR"
    public final void mFOR() throws RecognitionException {
        try {
            int _type = FOR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:488:5: ( 'for' )
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:488:7: 'for'
            {
            match("for"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FOR"

    // $ANTLR start "RETURN"
    public final void mRETURN() throws RecognitionException {
        try {
            int _type = RETURN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:490:8: ( 'return' )
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:490:10: 'return'
            {
            match("return"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RETURN"

    // $ANTLR start "IDENT"
    public final void mIDENT() throws RecognitionException {
        try {
            int _type = IDENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:493:7: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:493:9: ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:493:32: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='0' && LA2_0<='9')||(LA2_0>='A' && LA2_0<='Z')||LA2_0=='_'||(LA2_0>='a' && LA2_0<='z')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "IDENT"

    // $ANTLR start "LCURL"
    public final void mLCURL() throws RecognitionException {
        try {
            int _type = LCURL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:495:8: ( '{' )
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:495:10: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LCURL"

    // $ANTLR start "RCURL"
    public final void mRCURL() throws RecognitionException {
        try {
            int _type = RCURL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:496:7: ( '}' )
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:496:9: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RCURL"

    // $ANTLR start "LPAR"
    public final void mLPAR() throws RecognitionException {
        try {
            int _type = LPAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:497:6: ( '(' )
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:497:8: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LPAR"

    // $ANTLR start "RPAR"
    public final void mRPAR() throws RecognitionException {
        try {
            int _type = RPAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:498:6: ( ')' )
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:498:8: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RPAR"

    // $ANTLR start "LCOR"
    public final void mLCOR() throws RecognitionException {
        try {
            int _type = LCOR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:499:6: ( '[' )
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:499:8: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LCOR"

    // $ANTLR start "RCOR"
    public final void mRCOR() throws RecognitionException {
        try {
            int _type = RCOR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:500:6: ( ']' )
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:500:8: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RCOR"

    // $ANTLR start "PUNTO"
    public final void mPUNTO() throws RecognitionException {
        try {
            int _type = PUNTO;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:503:7: ( '.' )
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:503:9: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PUNTO"

    // $ANTLR start "PUNTOYCOMA"
    public final void mPUNTOYCOMA() throws RecognitionException {
        try {
            int _type = PUNTOYCOMA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:507:2: ( ';' )
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:507:4: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PUNTOYCOMA"

    // $ANTLR start "FLOAT"
    public final void mFLOAT() throws RecognitionException {
        try {
            int _type = FLOAT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:509:7: ( INT PUNTO INT | PUNTO INT EXPONENTE | INT PUNTO INT EXPONENTE | INT EXPONENTE )
            int alt3=4;
            alt3 = dfa3.predict(input);
            switch (alt3) {
                case 1 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:509:9: INT PUNTO INT
                    {
                    mINT(); 
                    mPUNTO(); 
                    mINT(); 

                    }
                    break;
                case 2 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:510:4: PUNTO INT EXPONENTE
                    {
                    mPUNTO(); 
                    mINT(); 
                    mEXPONENTE(); 

                    }
                    break;
                case 3 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:511:4: INT PUNTO INT EXPONENTE
                    {
                    mINT(); 
                    mPUNTO(); 
                    mINT(); 
                    mEXPONENTE(); 

                    }
                    break;
                case 4 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:512:4: INT EXPONENTE
                    {
                    mINT(); 
                    mEXPONENTE(); 

                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FLOAT"

    // $ANTLR start "AMPERSAND"
    public final void mAMPERSAND() throws RecognitionException {
        try {
            int _type = AMPERSAND;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:517:2: ( '&' )
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:517:4: '&'
            {
            match('&'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "AMPERSAND"

    // $ANTLR start "COMA"
    public final void mCOMA() throws RecognitionException {
        try {
            int _type = COMA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:518:6: ( ',' )
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:518:8: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COMA"

    // $ANTLR start "PROD"
    public final void mPROD() throws RecognitionException {
        try {
            int _type = PROD;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:520:6: ( '*' )
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:520:8: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PROD"

    // $ANTLR start "DIV"
    public final void mDIV() throws RecognitionException {
        try {
            int _type = DIV;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:521:5: ( '/' )
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:521:7: '/'
            {
            match('/'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DIV"

    // $ANTLR start "MOD"
    public final void mMOD() throws RecognitionException {
        try {
            int _type = MOD;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:522:5: ( '%' )
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:522:7: '%'
            {
            match('%'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "MOD"

    // $ANTLR start "MASMAS"
    public final void mMASMAS() throws RecognitionException {
        try {
            int _type = MASMAS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:524:8: ( '++' )
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:524:10: '++'
            {
            match("++"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "MASMAS"

    // $ANTLR start "MENOSMENOS"
    public final void mMENOSMENOS() throws RecognitionException {
        try {
            int _type = MENOSMENOS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:526:2: ( '--' )
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:526:4: '--'
            {
            match("--"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "MENOSMENOS"

    // $ANTLR start "MAS"
    public final void mMAS() throws RecognitionException {
        try {
            int _type = MAS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:528:5: ( '+' )
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:528:7: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "MAS"

    // $ANTLR start "MENOS"
    public final void mMENOS() throws RecognitionException {
        try {
            int _type = MENOS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:529:7: ( '-' )
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:529:9: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "MENOS"

    // $ANTLR start "ASIG"
    public final void mASIG() throws RecognitionException {
        try {
            int _type = ASIG;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:530:6: ( '=' )
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:530:8: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ASIG"

    // $ANTLR start "IGUAL"
    public final void mIGUAL() throws RecognitionException {
        try {
            int _type = IGUAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:532:7: ( '==' )
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:532:9: '=='
            {
            match("=="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "IGUAL"

    // $ANTLR start "DISTINTO"
    public final void mDISTINTO() throws RecognitionException {
        try {
            int _type = DISTINTO;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:533:9: ( '!=' )
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:533:11: '!='
            {
            match("!="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DISTINTO"

    // $ANTLR start "NOT"
    public final void mNOT() throws RecognitionException {
        try {
            int _type = NOT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:534:5: ( '!' )
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:534:7: '!'
            {
            match('!'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NOT"

    // $ANTLR start "AND"
    public final void mAND() throws RecognitionException {
        try {
            int _type = AND;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:535:5: ( '&&' )
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:535:7: '&&'
            {
            match("&&"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "AND"

    // $ANTLR start "OR"
    public final void mOR() throws RecognitionException {
        try {
            int _type = OR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:536:4: ( '||' )
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:536:6: '||'
            {
            match("||"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "OR"

    // $ANTLR start "MAYOR"
    public final void mMAYOR() throws RecognitionException {
        try {
            int _type = MAYOR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:537:7: ( '>' )
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:537:9: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "MAYOR"

    // $ANTLR start "MAYORIGUAL"
    public final void mMAYORIGUAL() throws RecognitionException {
        try {
            int _type = MAYORIGUAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:539:2: ( '>=' )
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:539:4: '>='
            {
            match(">="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "MAYORIGUAL"

    // $ANTLR start "MENOR"
    public final void mMENOR() throws RecognitionException {
        try {
            int _type = MENOR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:542:2: ( '<' )
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:542:4: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "MENOR"

    // $ANTLR start "MENORIGUAL"
    public final void mMENORIGUAL() throws RecognitionException {
        try {
            int _type = MENORIGUAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:545:2: ( '<=' )
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:545:4: '<='
            {
            match("<="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "MENORIGUAL"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:550:4: ( ( ' ' | '\\t' | '\\n' | '\\r' ) )
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:551:2: ( ' ' | '\\t' | '\\n' | '\\r' )
            {
            if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            _channel=HIDDEN;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WS"

    // $ANTLR start "COMENTSIMPLE"
    public final void mCOMENTSIMPLE() throws RecognitionException {
        try {
            int _type = COMENTSIMPLE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:562:2: ( '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n' )
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:562:4: '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n'
            {
            match("//"); 

            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:564:3: (~ ( '\\n' | '\\r' ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>='\u0000' && LA4_0<='\t')||(LA4_0>='\u000B' && LA4_0<='\f')||(LA4_0>='\u000E' && LA4_0<='\uFFFF')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:564:3: ~ ( '\\n' | '\\r' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:564:17: ( '\\r' )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0=='\r') ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:564:17: '\\r'
                    {
                    match('\r'); 

                    }
                    break;

            }

            match('\n'); 
            _channel=HIDDEN;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COMENTSIMPLE"

    // $ANTLR start "COMENTCOMP"
    public final void mCOMENTCOMP() throws RecognitionException {
        try {
            int _type = COMENTCOMP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:570:2: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:570:4: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:570:9: ( options {greedy=false; } : . )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0=='*') ) {
                    int LA6_1 = input.LA(2);

                    if ( (LA6_1=='/') ) {
                        alt6=2;
                    }
                    else if ( ((LA6_1>='\u0000' && LA6_1<='.')||(LA6_1>='0' && LA6_1<='\uFFFF')) ) {
                        alt6=1;
                    }


                }
                else if ( ((LA6_0>='\u0000' && LA6_0<=')')||(LA6_0>='+' && LA6_0<='\uFFFF')) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:570:37: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            match("*/"); 

            _channel=HIDDEN;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COMENTCOMP"

    // $ANTLR start "STRING"
    public final void mSTRING() throws RecognitionException {
        try {
            int _type = STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:579:5: ( '\"' ( ESC_SEQ | ~ ( '\\\\' | '\"' ) )* '\"' )
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:579:8: '\"' ( ESC_SEQ | ~ ( '\\\\' | '\"' ) )* '\"'
            {
            match('\"'); 
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:579:12: ( ESC_SEQ | ~ ( '\\\\' | '\"' ) )*
            loop7:
            do {
                int alt7=3;
                int LA7_0 = input.LA(1);

                if ( (LA7_0=='\\') ) {
                    alt7=1;
                }
                else if ( ((LA7_0>='\u0000' && LA7_0<='!')||(LA7_0>='#' && LA7_0<='[')||(LA7_0>=']' && LA7_0<='\uFFFF')) ) {
                    alt7=2;
                }


                switch (alt7) {
            	case 1 :
            	    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:579:14: ESC_SEQ
            	    {
            	    mESC_SEQ(); 

            	    }
            	    break;
            	case 2 :
            	    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:579:24: ~ ( '\\\\' | '\"' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            match('\"'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "STRING"

    // $ANTLR start "CHAR"
    public final void mCHAR() throws RecognitionException {
        try {
            int _type = CHAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:583:5: ( '\\'' ( ESC_SEQ | ~ ( '\\'' | '\\\\' ) ) '\\'' )
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:583:8: '\\'' ( ESC_SEQ | ~ ( '\\'' | '\\\\' ) ) '\\''
            {
            match('\''); 
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:583:13: ( ESC_SEQ | ~ ( '\\'' | '\\\\' ) )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0=='\\') ) {
                alt8=1;
            }
            else if ( ((LA8_0>='\u0000' && LA8_0<='&')||(LA8_0>='(' && LA8_0<='[')||(LA8_0>=']' && LA8_0<='\uFFFF')) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:583:15: ESC_SEQ
                    {
                    mESC_SEQ(); 

                    }
                    break;
                case 2 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:583:25: ~ ( '\\'' | '\\\\' )
                    {
                    if ( (input.LA(1)>='\u0000' && input.LA(1)<='&')||(input.LA(1)>='(' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}


                    }
                    break;

            }

            match('\''); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CHAR"

    // $ANTLR start "EXPONENTE"
    public final void mEXPONENTE() throws RecognitionException {
        try {
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:588:11: ( ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+ )
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:588:13: ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+
            {
            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:588:23: ( '+' | '-' )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0=='+'||LA9_0=='-') ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:
                    {
                    if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}


                    }
                    break;

            }

            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:588:34: ( '0' .. '9' )+
            int cnt10=0;
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0>='0' && LA10_0<='9')) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:588:35: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt10 >= 1 ) break loop10;
                        EarlyExitException eee =
                            new EarlyExitException(10, input);
                        throw eee;
                }
                cnt10++;
            } while (true);


            }

        }
        finally {
        }
    }
    // $ANTLR end "EXPONENTE"

    // $ANTLR start "HEX_DIGIT"
    public final void mHEX_DIGIT() throws RecognitionException {
        try {
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:591:11: ( ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) )
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:591:13: ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )
            {
            if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='F')||(input.LA(1)>='a' && input.LA(1)<='f') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "HEX_DIGIT"

    // $ANTLR start "ESC_SEQ"
    public final void mESC_SEQ() throws RecognitionException {
        try {
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:595:5: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | UNICODE_ESC | OCTAL_ESC )
            int alt11=3;
            int LA11_0 = input.LA(1);

            if ( (LA11_0=='\\') ) {
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
                    alt11=1;
                    }
                    break;
                case 'u':
                    {
                    alt11=2;
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
                    alt11=3;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 11, 1, input);

                    throw nvae;
                }

            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:595:9: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' )
                    {
                    match('\\'); 
                    if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='\\'||input.LA(1)=='b'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||input.LA(1)=='t' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}


                    }
                    break;
                case 2 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:596:9: UNICODE_ESC
                    {
                    mUNICODE_ESC(); 

                    }
                    break;
                case 3 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:597:9: OCTAL_ESC
                    {
                    mOCTAL_ESC(); 

                    }
                    break;

            }
        }
        finally {
        }
    }
    // $ANTLR end "ESC_SEQ"

    // $ANTLR start "OCTAL_ESC"
    public final void mOCTAL_ESC() throws RecognitionException {
        try {
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:602:5: ( '\\\\' ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' ) | '\\\\' ( '0' .. '7' ) ( '0' .. '7' ) | '\\\\' ( '0' .. '7' ) )
            int alt12=3;
            int LA12_0 = input.LA(1);

            if ( (LA12_0=='\\') ) {
                int LA12_1 = input.LA(2);

                if ( ((LA12_1>='0' && LA12_1<='3')) ) {
                    int LA12_2 = input.LA(3);

                    if ( ((LA12_2>='0' && LA12_2<='7')) ) {
                        int LA12_5 = input.LA(4);

                        if ( ((LA12_5>='0' && LA12_5<='7')) ) {
                            alt12=1;
                        }
                        else {
                            alt12=2;}
                    }
                    else {
                        alt12=3;}
                }
                else if ( ((LA12_1>='4' && LA12_1<='7')) ) {
                    int LA12_3 = input.LA(3);

                    if ( ((LA12_3>='0' && LA12_3<='7')) ) {
                        alt12=2;
                    }
                    else {
                        alt12=3;}
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 12, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:602:9: '\\\\' ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' )
                    {
                    match('\\'); 
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:602:14: ( '0' .. '3' )
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:602:15: '0' .. '3'
                    {
                    matchRange('0','3'); 

                    }

                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:602:25: ( '0' .. '7' )
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:602:26: '0' .. '7'
                    {
                    matchRange('0','7'); 

                    }

                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:602:36: ( '0' .. '7' )
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:602:37: '0' .. '7'
                    {
                    matchRange('0','7'); 

                    }


                    }
                    break;
                case 2 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:603:9: '\\\\' ( '0' .. '7' ) ( '0' .. '7' )
                    {
                    match('\\'); 
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:603:14: ( '0' .. '7' )
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:603:15: '0' .. '7'
                    {
                    matchRange('0','7'); 

                    }

                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:603:25: ( '0' .. '7' )
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:603:26: '0' .. '7'
                    {
                    matchRange('0','7'); 

                    }


                    }
                    break;
                case 3 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:604:9: '\\\\' ( '0' .. '7' )
                    {
                    match('\\'); 
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:604:14: ( '0' .. '7' )
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:604:15: '0' .. '7'
                    {
                    matchRange('0','7'); 

                    }


                    }
                    break;

            }
        }
        finally {
        }
    }
    // $ANTLR end "OCTAL_ESC"

    // $ANTLR start "UNICODE_ESC"
    public final void mUNICODE_ESC() throws RecognitionException {
        try {
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:614:5: ( '\\\\' 'u' HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT )
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:614:9: '\\\\' 'u' HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT
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
        }
    }
    // $ANTLR end "UNICODE_ESC"

    // $ANTLR start "LIBRERIA"
    public final void mLIBRERIA() throws RecognitionException {
        try {
            int _type = LIBRERIA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:624:2: ( '#' ( WS )* 'include' (~ '>' )* '>' )
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:625:3: '#' ( WS )* 'include' (~ '>' )* '>'
            {
            match('#'); 
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:625:7: ( WS )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( ((LA13_0>='\t' && LA13_0<='\n')||LA13_0=='\r'||LA13_0==' ') ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:625:7: WS
            	    {
            	    mWS(); 

            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

            match("include"); 

            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:625:22: (~ '>' )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( ((LA14_0>='\u0000' && LA14_0<='=')||(LA14_0>='?' && LA14_0<='\uFFFF')) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:625:24: ~ '>'
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='=')||(input.LA(1)>='?' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);

            match('>'); 
            _channel = HIDDEN;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LIBRERIA"

    // $ANTLR start "IGNORAR"
    public final void mIGNORAR() throws RecognitionException {
        try {
            int _type = IGNORAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:634:9: ( 'fflush' (~ ( PUNTOYCOMA ) )* PUNTOYCOMA | 'getc' (~ ( PUNTOYCOMA ) )* PUNTOYCOMA )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0=='f') ) {
                alt17=1;
            }
            else if ( (LA17_0=='g') ) {
                alt17=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:636:3: 'fflush' (~ ( PUNTOYCOMA ) )* PUNTOYCOMA
                    {
                    match("fflush"); 

                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:636:12: (~ ( PUNTOYCOMA ) )*
                    loop15:
                    do {
                        int alt15=2;
                        int LA15_0 = input.LA(1);

                        if ( ((LA15_0>='\u0000' && LA15_0<=':')||(LA15_0>='<' && LA15_0<='\uFFFF')) ) {
                            alt15=1;
                        }


                        switch (alt15) {
                    	case 1 :
                    	    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:636:12: ~ ( PUNTOYCOMA )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<=':')||(input.LA(1)>='<' && input.LA(1)<='\uFFFF') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop15;
                        }
                    } while (true);

                    mPUNTOYCOMA(); 
                    _channel=HIDDEN;

                    }
                    break;
                case 2 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:638:4: 'getc' (~ ( PUNTOYCOMA ) )* PUNTOYCOMA
                    {
                    match("getc"); 

                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:638:11: (~ ( PUNTOYCOMA ) )*
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( ((LA16_0>='\u0000' && LA16_0<=':')||(LA16_0>='<' && LA16_0<='\uFFFF')) ) {
                            alt16=1;
                        }


                        switch (alt16) {
                    	case 1 :
                    	    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:638:11: ~ ( PUNTOYCOMA )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<=':')||(input.LA(1)>='<' && input.LA(1)<='\uFFFF') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop16;
                        }
                    } while (true);

                    mPUNTOYCOMA(); 
                    _channel=HIDDEN;

                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "IGNORAR"

    public void mTokens() throws RecognitionException {
        // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:1:8: ( T__100 | T__101 | T__102 | T__103 | T__104 | T__105 | T__106 | INT | FUNCLEER | FUNCIMPRIMIR | FUNC_POW | FUNC_SQRT | FUNC_GETS | FUNC_STRLEN | IF | ELSE | WHILE | DO | FOR | RETURN | IDENT | LCURL | RCURL | LPAR | RPAR | LCOR | RCOR | PUNTO | PUNTOYCOMA | FLOAT | AMPERSAND | COMA | PROD | DIV | MOD | MASMAS | MENOSMENOS | MAS | MENOS | ASIG | IGUAL | DISTINTO | NOT | AND | OR | MAYOR | MAYORIGUAL | MENOR | MENORIGUAL | WS | COMENTSIMPLE | COMENTCOMP | STRING | CHAR | LIBRERIA | IGNORAR )
        int alt18=56;
        alt18 = dfa18.predict(input);
        switch (alt18) {
            case 1 :
                // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:1:10: T__100
                {
                mT__100(); 

                }
                break;
            case 2 :
                // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:1:17: T__101
                {
                mT__101(); 

                }
                break;
            case 3 :
                // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:1:24: T__102
                {
                mT__102(); 

                }
                break;
            case 4 :
                // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:1:31: T__103
                {
                mT__103(); 

                }
                break;
            case 5 :
                // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:1:38: T__104
                {
                mT__104(); 

                }
                break;
            case 6 :
                // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:1:45: T__105
                {
                mT__105(); 

                }
                break;
            case 7 :
                // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:1:52: T__106
                {
                mT__106(); 

                }
                break;
            case 8 :
                // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:1:59: INT
                {
                mINT(); 

                }
                break;
            case 9 :
                // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:1:63: FUNCLEER
                {
                mFUNCLEER(); 

                }
                break;
            case 10 :
                // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:1:72: FUNCIMPRIMIR
                {
                mFUNCIMPRIMIR(); 

                }
                break;
            case 11 :
                // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:1:85: FUNC_POW
                {
                mFUNC_POW(); 

                }
                break;
            case 12 :
                // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:1:94: FUNC_SQRT
                {
                mFUNC_SQRT(); 

                }
                break;
            case 13 :
                // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:1:104: FUNC_GETS
                {
                mFUNC_GETS(); 

                }
                break;
            case 14 :
                // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:1:114: FUNC_STRLEN
                {
                mFUNC_STRLEN(); 

                }
                break;
            case 15 :
                // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:1:126: IF
                {
                mIF(); 

                }
                break;
            case 16 :
                // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:1:129: ELSE
                {
                mELSE(); 

                }
                break;
            case 17 :
                // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:1:134: WHILE
                {
                mWHILE(); 

                }
                break;
            case 18 :
                // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:1:140: DO
                {
                mDO(); 

                }
                break;
            case 19 :
                // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:1:143: FOR
                {
                mFOR(); 

                }
                break;
            case 20 :
                // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:1:147: RETURN
                {
                mRETURN(); 

                }
                break;
            case 21 :
                // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:1:154: IDENT
                {
                mIDENT(); 

                }
                break;
            case 22 :
                // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:1:160: LCURL
                {
                mLCURL(); 

                }
                break;
            case 23 :
                // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:1:166: RCURL
                {
                mRCURL(); 

                }
                break;
            case 24 :
                // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:1:172: LPAR
                {
                mLPAR(); 

                }
                break;
            case 25 :
                // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:1:177: RPAR
                {
                mRPAR(); 

                }
                break;
            case 26 :
                // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:1:182: LCOR
                {
                mLCOR(); 

                }
                break;
            case 27 :
                // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:1:187: RCOR
                {
                mRCOR(); 

                }
                break;
            case 28 :
                // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:1:192: PUNTO
                {
                mPUNTO(); 

                }
                break;
            case 29 :
                // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:1:198: PUNTOYCOMA
                {
                mPUNTOYCOMA(); 

                }
                break;
            case 30 :
                // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:1:209: FLOAT
                {
                mFLOAT(); 

                }
                break;
            case 31 :
                // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:1:215: AMPERSAND
                {
                mAMPERSAND(); 

                }
                break;
            case 32 :
                // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:1:225: COMA
                {
                mCOMA(); 

                }
                break;
            case 33 :
                // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:1:230: PROD
                {
                mPROD(); 

                }
                break;
            case 34 :
                // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:1:235: DIV
                {
                mDIV(); 

                }
                break;
            case 35 :
                // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:1:239: MOD
                {
                mMOD(); 

                }
                break;
            case 36 :
                // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:1:243: MASMAS
                {
                mMASMAS(); 

                }
                break;
            case 37 :
                // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:1:250: MENOSMENOS
                {
                mMENOSMENOS(); 

                }
                break;
            case 38 :
                // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:1:261: MAS
                {
                mMAS(); 

                }
                break;
            case 39 :
                // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:1:265: MENOS
                {
                mMENOS(); 

                }
                break;
            case 40 :
                // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:1:271: ASIG
                {
                mASIG(); 

                }
                break;
            case 41 :
                // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:1:276: IGUAL
                {
                mIGUAL(); 

                }
                break;
            case 42 :
                // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:1:282: DISTINTO
                {
                mDISTINTO(); 

                }
                break;
            case 43 :
                // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:1:291: NOT
                {
                mNOT(); 

                }
                break;
            case 44 :
                // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:1:295: AND
                {
                mAND(); 

                }
                break;
            case 45 :
                // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:1:299: OR
                {
                mOR(); 

                }
                break;
            case 46 :
                // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:1:302: MAYOR
                {
                mMAYOR(); 

                }
                break;
            case 47 :
                // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:1:308: MAYORIGUAL
                {
                mMAYORIGUAL(); 

                }
                break;
            case 48 :
                // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:1:319: MENOR
                {
                mMENOR(); 

                }
                break;
            case 49 :
                // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:1:325: MENORIGUAL
                {
                mMENORIGUAL(); 

                }
                break;
            case 50 :
                // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:1:336: WS
                {
                mWS(); 

                }
                break;
            case 51 :
                // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:1:339: COMENTSIMPLE
                {
                mCOMENTSIMPLE(); 

                }
                break;
            case 52 :
                // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:1:352: COMENTCOMP
                {
                mCOMENTCOMP(); 

                }
                break;
            case 53 :
                // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:1:363: STRING
                {
                mSTRING(); 

                }
                break;
            case 54 :
                // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:1:370: CHAR
                {
                mCHAR(); 

                }
                break;
            case 55 :
                // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:1:375: LIBRERIA
                {
                mLIBRERIA(); 

                }
                break;
            case 56 :
                // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:1:384: IGNORAR
                {
                mIGNORAR(); 

                }
                break;

        }

    }


    protected DFA3 dfa3 = new DFA3(this);
    protected DFA18 dfa18 = new DFA18(this);
    static final String DFA3_eotS =
        "\5\uffff\1\6\2\uffff";
    static final String DFA3_eofS =
        "\10\uffff";
    static final String DFA3_minS =
        "\2\56\1\uffff\1\60\1\uffff\1\60\2\uffff";
    static final String DFA3_maxS =
        "\1\71\1\145\1\uffff\1\71\1\uffff\1\145\2\uffff";
    static final String DFA3_acceptS =
        "\2\uffff\1\2\1\uffff\1\4\1\uffff\1\1\1\3";
    static final String DFA3_specialS =
        "\10\uffff}>";
    static final String[] DFA3_transitionS = {
            "\1\2\1\uffff\12\1",
            "\1\3\1\uffff\12\1\13\uffff\1\4\37\uffff\1\4",
            "",
            "\12\5",
            "",
            "\12\5\13\uffff\1\7\37\uffff\1\7",
            "",
            ""
    };

    static final short[] DFA3_eot = DFA.unpackEncodedString(DFA3_eotS);
    static final short[] DFA3_eof = DFA.unpackEncodedString(DFA3_eofS);
    static final char[] DFA3_min = DFA.unpackEncodedStringToUnsignedChars(DFA3_minS);
    static final char[] DFA3_max = DFA.unpackEncodedStringToUnsignedChars(DFA3_maxS);
    static final short[] DFA3_accept = DFA.unpackEncodedString(DFA3_acceptS);
    static final short[] DFA3_special = DFA.unpackEncodedString(DFA3_specialS);
    static final short[][] DFA3_transition;

    static {
        int numStates = DFA3_transitionS.length;
        DFA3_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA3_transition[i] = DFA.unpackEncodedString(DFA3_transitionS[i]);
        }
    }

    class DFA3 extends DFA {

        public DFA3(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 3;
            this.eot = DFA3_eot;
            this.eof = DFA3_eof;
            this.min = DFA3_min;
            this.max = DFA3_max;
            this.accept = DFA3_accept;
            this.special = DFA3_special;
            this.transition = DFA3_transition;
        }
        public String getDescription() {
            return "509:1: FLOAT : ( INT PUNTO INT | PUNTO INT EXPONENTE | INT PUNTO INT EXPONENTE | INT EXPONENTE );";
        }
    }
    static final String DFA18_eotS =
        "\1\uffff\5\16\1\uffff\1\61\6\16\7\uffff\1\74\1\uffff\1\76\2\uffff"+
        "\1\101\1\uffff\1\103\1\105\1\107\1\111\1\uffff\1\113\1\115\3\uffff"+
        "\3\16\1\121\3\16\1\126\5\uffff\11\16\22\uffff\2\16\1\143\1\uffff"+
        "\1\16\1\145\2\16\2\uffff\4\16\1\154\4\16\1\162\1\163\1\uffff\1\16"+
        "\1\uffff\3\16\1\170\2\16\1\uffff\1\173\1\16\1\176\2\16\2\uffff\1"+
        "\u0081\2\16\1\u0084\1\uffff\2\16\1\uffff\1\16\2\uffff\1\u0087\1"+
        "\16\1\uffff\1\16\1\u008a\1\uffff\1\u008b\1\u008c\1\uffff\1\u008d"+
        "\1\16\4\uffff";
    static final String DFA18_eofS =
        "\u008e\uffff";
    static final String DFA18_minS =
        "\1\11\1\157\1\150\2\146\1\157\1\11\1\56\1\143\1\157\1\145\1\154"+
        "\1\150\1\145\7\uffff\1\60\1\uffff\1\46\2\uffff\1\52\1\uffff\1\53"+
        "\1\55\2\75\1\uffff\2\75\3\uffff\1\151\1\141\1\164\1\60\1\157\1\162"+
        "\1\154\1\60\1\uffff\1\11\3\uffff\1\141\2\162\1\151\1\167\1\164\1"+
        "\163\1\151\1\164\22\uffff\1\144\1\162\1\60\1\uffff\1\141\1\60\1"+
        "\165\1\142\2\uffff\1\156\1\164\1\154\1\156\1\60\1\143\1\145\1\154"+
        "\1\165\2\60\1\uffff\1\164\1\uffff\1\163\1\154\1\146\1\60\1\145\1"+
        "\164\1\uffff\1\60\1\0\1\60\1\145\1\162\2\uffff\1\60\1\150\1\145"+
        "\1\60\1\uffff\1\156\1\146\1\uffff\1\0\2\uffff\1\60\1\156\1\uffff"+
        "\1\0\1\60\1\uffff\2\60\1\uffff\1\60\1\0\4\uffff";
    static final String DFA18_maxS =
        "\1\175\1\157\1\150\1\156\2\157\1\151\1\145\1\164\1\162\1\145\1"+
        "\154\1\150\1\145\7\uffff\1\71\1\uffff\1\46\2\uffff\1\57\1\uffff"+
        "\1\53\1\55\2\75\1\uffff\2\75\3\uffff\1\151\1\141\1\164\1\172\1\157"+
        "\1\162\1\154\1\172\1\uffff\1\151\3\uffff\1\141\2\162\1\151\1\167"+
        "\1\164\1\163\1\151\1\164\22\uffff\1\144\1\162\1\172\1\uffff\1\141"+
        "\1\172\1\165\1\142\2\uffff\1\156\1\164\1\154\1\156\1\172\1\163\1"+
        "\145\1\154\1\165\2\172\1\uffff\1\164\1\uffff\1\163\1\154\1\146\1"+
        "\172\1\145\1\164\1\uffff\1\172\1\uffff\1\172\1\145\1\162\2\uffff"+
        "\1\172\1\150\1\145\1\172\1\uffff\1\156\1\146\1\uffff\1\uffff\2\uffff"+
        "\1\172\1\156\1\uffff\1\uffff\1\172\1\uffff\2\172\1\uffff\1\172\1"+
        "\uffff\4\uffff";
    static final String DFA18_acceptS =
        "\16\uffff\1\25\1\26\1\27\1\30\1\31\1\32\1\33\1\uffff\1\35\1\uffff"+
        "\1\40\1\41\1\uffff\1\43\4\uffff\1\55\2\uffff\1\62\1\65\1\66\10\uffff"+
        "\1\6\1\uffff\1\67\1\10\1\36\11\uffff\1\34\1\54\1\37\1\63\1\64\1"+
        "\42\1\44\1\46\1\45\1\47\1\51\1\50\1\52\1\53\1\57\1\56\1\61\1\60"+
        "\3\uffff\1\17\4\uffff\1\22\1\7\13\uffff\1\3\1\uffff\1\23\6\uffff"+
        "\1\13\5\uffff\1\1\1\2\4\uffff\1\14\2\uffff\1\15\1\uffff\1\70\1\20"+
        "\2\uffff\1\4\2\uffff\1\11\2\uffff\1\21\2\uffff\1\5\1\16\1\12\1\24";
    static final String DFA18_specialS =
        "\156\uffff\1\1\15\uffff\1\2\5\uffff\1\3\6\uffff\1\0\4\uffff}>";
    static final String[] DFA18_transitionS = {
            "\2\43\2\uffff\1\43\22\uffff\1\43\1\37\1\44\1\6\1\uffff\1\33"+
            "\1\27\1\45\1\21\1\22\1\31\1\34\1\30\1\35\1\25\1\32\12\7\1\uffff"+
            "\1\26\1\42\1\36\1\41\2\uffff\32\16\1\23\1\uffff\1\24\1\uffff"+
            "\1\16\1\uffff\2\16\1\2\1\5\1\13\1\4\1\12\1\16\1\3\6\16\1\11"+
            "\1\16\1\15\1\10\2\16\1\1\1\14\3\16\1\17\1\40\1\20",
            "\1\46",
            "\1\47",
            "\1\51\7\uffff\1\50",
            "\1\54\5\uffff\1\52\2\uffff\1\53",
            "\1\55",
            "\2\60\2\uffff\1\60\22\uffff\1\57\103\uffff\1\56\4\uffff\1"+
            "\60",
            "\1\62\1\uffff\12\7\13\uffff\1\62\37\uffff\1\62",
            "\1\63\15\uffff\1\64\2\uffff\1\65",
            "\1\67\2\uffff\1\66",
            "\1\70",
            "\1\71",
            "\1\72",
            "\1\73",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\12\62",
            "",
            "\1\75",
            "",
            "",
            "\1\100\4\uffff\1\77",
            "",
            "\1\102",
            "\1\104",
            "\1\106",
            "\1\110",
            "",
            "\1\112",
            "\1\114",
            "",
            "",
            "",
            "\1\116",
            "\1\117",
            "\1\120",
            "\12\16\7\uffff\32\16\4\uffff\1\16\1\uffff\32\16",
            "\1\122",
            "\1\123",
            "\1\124",
            "\12\16\7\uffff\32\16\4\uffff\1\16\1\uffff\24\16\1\125\5\16",
            "",
            "\2\60\2\uffff\1\60\22\uffff\1\60\103\uffff\1\127\4\uffff\1"+
            "\60",
            "",
            "",
            "",
            "\1\130",
            "\1\131",
            "\1\132",
            "\1\133",
            "\1\134",
            "\1\135",
            "\1\136",
            "\1\137",
            "\1\140",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\141",
            "\1\142",
            "\12\16\7\uffff\32\16\4\uffff\1\16\1\uffff\32\16",
            "",
            "\1\144",
            "\12\16\7\uffff\32\16\4\uffff\1\16\1\uffff\32\16",
            "\1\146",
            "\1\147",
            "",
            "",
            "\1\150",
            "\1\151",
            "\1\152",
            "\1\153",
            "\12\16\7\uffff\32\16\4\uffff\1\16\1\uffff\32\16",
            "\1\156\17\uffff\1\155",
            "\1\157",
            "\1\160",
            "\1\161",
            "\12\16\7\uffff\32\16\4\uffff\1\16\1\uffff\32\16",
            "\12\16\7\uffff\32\16\4\uffff\1\16\1\uffff\32\16",
            "",
            "\1\164",
            "",
            "\1\165",
            "\1\166",
            "\1\167",
            "\12\16\7\uffff\32\16\4\uffff\1\16\1\uffff\32\16",
            "\1\171",
            "\1\172",
            "",
            "\12\16\7\uffff\32\16\4\uffff\1\16\1\uffff\32\16",
            "\60\175\12\174\7\175\32\174\4\175\1\174\1\175\32\174\uff85"+
            "\175",
            "\12\16\7\uffff\32\16\4\uffff\1\16\1\uffff\32\16",
            "\1\177",
            "\1\u0080",
            "",
            "",
            "\12\16\7\uffff\32\16\4\uffff\1\16\1\uffff\32\16",
            "\1\u0082",
            "\1\u0083",
            "\12\16\7\uffff\32\16\4\uffff\1\16\1\uffff\32\16",
            "",
            "\1\u0085",
            "\1\u0086",
            "",
            "\60\175\12\174\7\175\32\174\4\175\1\174\1\175\32\174\uff85"+
            "\175",
            "",
            "",
            "\12\16\7\uffff\32\16\4\uffff\1\16\1\uffff\32\16",
            "\1\u0088",
            "",
            "\60\175\12\u0089\7\175\32\u0089\4\175\1\u0089\1\175\32\u0089"+
            "\uff85\175",
            "\12\16\7\uffff\32\16\4\uffff\1\16\1\uffff\32\16",
            "",
            "\12\16\7\uffff\32\16\4\uffff\1\16\1\uffff\32\16",
            "\12\16\7\uffff\32\16\4\uffff\1\16\1\uffff\32\16",
            "",
            "\12\16\7\uffff\32\16\4\uffff\1\16\1\uffff\32\16",
            "\60\175\12\u0089\7\175\32\u0089\4\175\1\u0089\1\175\32\u0089"+
            "\uff85\175",
            "",
            "",
            "",
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
            return "1:1: Tokens : ( T__100 | T__101 | T__102 | T__103 | T__104 | T__105 | T__106 | INT | FUNCLEER | FUNCIMPRIMIR | FUNC_POW | FUNC_SQRT | FUNC_GETS | FUNC_STRLEN | IF | ELSE | WHILE | DO | FOR | RETURN | IDENT | LCURL | RCURL | LPAR | RPAR | LCOR | RCOR | PUNTO | PUNTOYCOMA | FLOAT | AMPERSAND | COMA | PROD | DIV | MOD | MASMAS | MENOSMENOS | MAS | MENOS | ASIG | IGUAL | DISTINTO | NOT | AND | OR | MAYOR | MAYORIGUAL | MENOR | MENORIGUAL | WS | COMENTSIMPLE | COMENTCOMP | STRING | CHAR | LIBRERIA | IGNORAR );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA18_137 = input.LA(1);

                        s = -1;
                        if ( ((LA18_137>='0' && LA18_137<='9')||(LA18_137>='A' && LA18_137<='Z')||LA18_137=='_'||(LA18_137>='a' && LA18_137<='z')) ) {s = 137;}

                        else if ( ((LA18_137>='\u0000' && LA18_137<='/')||(LA18_137>=':' && LA18_137<='@')||(LA18_137>='[' && LA18_137<='^')||LA18_137=='`'||(LA18_137>='{' && LA18_137<='\uFFFF')) ) {s = 125;}

                        else s = 14;

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA18_110 = input.LA(1);

                        s = -1;
                        if ( ((LA18_110>='0' && LA18_110<='9')||(LA18_110>='A' && LA18_110<='Z')||LA18_110=='_'||(LA18_110>='a' && LA18_110<='z')) ) {s = 124;}

                        else if ( ((LA18_110>='\u0000' && LA18_110<='/')||(LA18_110>=':' && LA18_110<='@')||(LA18_110>='[' && LA18_110<='^')||LA18_110=='`'||(LA18_110>='{' && LA18_110<='\uFFFF')) ) {s = 125;}

                        else s = 14;

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA18_124 = input.LA(1);

                        s = -1;
                        if ( ((LA18_124>='0' && LA18_124<='9')||(LA18_124>='A' && LA18_124<='Z')||LA18_124=='_'||(LA18_124>='a' && LA18_124<='z')) ) {s = 124;}

                        else if ( ((LA18_124>='\u0000' && LA18_124<='/')||(LA18_124>=':' && LA18_124<='@')||(LA18_124>='[' && LA18_124<='^')||LA18_124=='`'||(LA18_124>='{' && LA18_124<='\uFFFF')) ) {s = 125;}

                        else s = 14;

                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA18_130 = input.LA(1);

                        s = -1;
                        if ( ((LA18_130>='0' && LA18_130<='9')||(LA18_130>='A' && LA18_130<='Z')||LA18_130=='_'||(LA18_130>='a' && LA18_130<='z')) ) {s = 137;}

                        else if ( ((LA18_130>='\u0000' && LA18_130<='/')||(LA18_130>=':' && LA18_130<='@')||(LA18_130>='[' && LA18_130<='^')||LA18_130=='`'||(LA18_130>='{' && LA18_130<='\uFFFF')) ) {s = 125;}

                        else s = 14;

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 18, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}