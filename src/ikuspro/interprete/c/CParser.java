// $ANTLR 3.1.2 F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g 2009-11-20 22:37:37

	package ikuspro.interprete.c;
	



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.tree.*;

public class CParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "PROGRAMA", "DECLARACIONES_GLOBALES", "FUNCIONES", "FUNCION", "CABECERA_FUNCION", "BLOQUE", "DECLARACION_NOMBRE_FUNCION", "LISTA_PARAM_FORMALES", "PARAM_FORMAL", "TIPO_BASE", "NOMBRE_VAR", "NOMBRE_FUNC", "SENTENCIA_ASIG", "SENTENCIA_CALL", "ASIGNACION", "EXPRESION", "LLAMADA", "DEFINE", "VALOR", "INCLUDE", "DECL_VAR", "F_IMPRIMIR", "FORMATO", "F_LEER", "PARAM_ACTUAL", "NEGAR", "SENTENCIAS", "DECLVARS", "POSTFIJO", "PREFIJO", "DECL_VAR_ARR", "LONGITUD", "PARAM_FORMAL_ARR", "ELE_ARR", "INDICE", "DECL", "F_POW", "F_GETS", "F_STRLEN", "F_SQRT", "DECL_VAR_REF", "ASIGNACION_REF", "PUNTOYCOMA", "LPAR", "RPAR", "COMA", "IDENT", "LCOR", "RCOR", "RETURN", "LCURL", "RCURL", "IF", "ELSE", "WHILE", "DO", "FOR", "ASIG", "OR", "AND", "IGUAL", "DISTINTO", "MAYOR", "MENOR", "MENORIGUAL", "MAYORIGUAL", "MAS", "MENOS", "PROD", "DIV", "MOD", "NOT", "INT", "FLOAT", "STRING", "CHAR", "MASMAS", "MENOSMENOS", "FUNCLEER", "AMPERSAND", "FUNCIMPRIMIR", "FUNC_POW", "FUNC_SQRT", "FUNC_GETS", "FUNC_STRLEN", "PUNTO", "EXPONENTE", "WS", "COMENTSIMPLE", "COMENTCOMP", "ESC_SEQ", "HEX_DIGIT", "UNICODE_ESC", "OCTAL_ESC", "LIBRERIA", "IGNORAR", "'void'", "'char'", "'int'", "'float'", "'double'", "'#define'", "'# define'"
    };
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
    public static final int IGNORAR=99;
    public static final int ELSE=57;
    public static final int DECL_VAR=24;
    public static final int INT=76;
    public static final int MENORIGUAL=68;
    public static final int LONGITUD=35;
    public static final int PARAM_FORMAL=12;
    public static final int ASIGNACION_REF=45;
    public static final int MENOSMENOS=81;
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
    public static final int POSTFIJO=32;
    public static final int SENTENCIA_CALL=17;
    public static final int DECLARACIONES_GLOBALES=5;
    public static final int DECL=39;
    public static final int MAS=70;
    public static final int CABECERA_FUNCION=8;
    public static final int RCURL=55;
    public static final int SENTENCIAS=30;
    public static final int PROGRAMA=4;
    public static final int RPAR=48;
    public static final int DIV=73;
    public static final int MAYORIGUAL=69;
    public static final int STRING=78;
    public static final int FUNC_POW=85;

    // delegates
    // delegators


        public CParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public CParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return CParser.tokenNames; }
    public String getGrammarFileName() { return "F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g"; }


       	// nada


    public static class programa_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "programa"
    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:71:1: programa : ( declaraciones_globales funciones EOF -> ^( PROGRAMA ^( DECLARACIONES_GLOBALES declaraciones_globales ) ^( FUNCIONES funciones ) ^( LLAMADA ^( NOMBRE_FUNC ) ) ) | funciones EOF -> ^( PROGRAMA ^( FUNCIONES funciones ) ^( LLAMADA ^( NOMBRE_FUNC ) ) ) );
    public final CParser.programa_return programa() throws RecognitionException {
        CParser.programa_return retval = new CParser.programa_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token EOF3=null;
        Token EOF5=null;
        CParser.declaraciones_globales_return declaraciones_globales1 = null;

        CParser.funciones_return funciones2 = null;

        CParser.funciones_return funciones4 = null;


        CommonTree EOF3_tree=null;
        CommonTree EOF5_tree=null;
        RewriteRuleTokenStream stream_EOF=new RewriteRuleTokenStream(adaptor,"token EOF");
        RewriteRuleSubtreeStream stream_funciones=new RewriteRuleSubtreeStream(adaptor,"rule funciones");
        RewriteRuleSubtreeStream stream_declaraciones_globales=new RewriteRuleSubtreeStream(adaptor,"rule declaraciones_globales");
        try {
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:73:2: ( declaraciones_globales funciones EOF -> ^( PROGRAMA ^( DECLARACIONES_GLOBALES declaraciones_globales ) ^( FUNCIONES funciones ) ^( LLAMADA ^( NOMBRE_FUNC ) ) ) | funciones EOF -> ^( PROGRAMA ^( FUNCIONES funciones ) ^( LLAMADA ^( NOMBRE_FUNC ) ) ) )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( ((LA1_0>=105 && LA1_0<=106)) ) {
                alt1=1;
            }
            else if ( (LA1_0==IDENT||(LA1_0>=100 && LA1_0<=104)) ) {
                alt1=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:73:4: declaraciones_globales funciones EOF
                    {
                    pushFollow(FOLLOW_declaraciones_globales_in_programa233);
                    declaraciones_globales1=declaraciones_globales();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_declaraciones_globales.add(declaraciones_globales1.getTree());
                    pushFollow(FOLLOW_funciones_in_programa235);
                    funciones2=funciones();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_funciones.add(funciones2.getTree());
                    EOF3=(Token)match(input,EOF,FOLLOW_EOF_in_programa237); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_EOF.add(EOF3);



                    // AST REWRITE
                    // elements: declaraciones_globales, funciones
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 74:3: -> ^( PROGRAMA ^( DECLARACIONES_GLOBALES declaraciones_globales ) ^( FUNCIONES funciones ) ^( LLAMADA ^( NOMBRE_FUNC ) ) )
                    {
                        // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:74:6: ^( PROGRAMA ^( DECLARACIONES_GLOBALES declaraciones_globales ) ^( FUNCIONES funciones ) ^( LLAMADA ^( NOMBRE_FUNC ) ) )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(PROGRAMA, "PROGRAMA"), root_1);

                        // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:74:17: ^( DECLARACIONES_GLOBALES declaraciones_globales )
                        {
                        CommonTree root_2 = (CommonTree)adaptor.nil();
                        root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(DECLARACIONES_GLOBALES, "DECLARACIONES_GLOBALES"), root_2);

                        adaptor.addChild(root_2, stream_declaraciones_globales.nextTree());

                        adaptor.addChild(root_1, root_2);
                        }
                        // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:74:66: ^( FUNCIONES funciones )
                        {
                        CommonTree root_2 = (CommonTree)adaptor.nil();
                        root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(FUNCIONES, "FUNCIONES"), root_2);

                        adaptor.addChild(root_2, stream_funciones.nextTree());

                        adaptor.addChild(root_1, root_2);
                        }
                        // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:74:89: ^( LLAMADA ^( NOMBRE_FUNC ) )
                        {
                        CommonTree root_2 = (CommonTree)adaptor.nil();
                        root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(LLAMADA, "LLAMADA"), root_2);

                        // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:74:99: ^( NOMBRE_FUNC )
                        {
                        CommonTree root_3 = (CommonTree)adaptor.nil();
                        root_3 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NOMBRE_FUNC, "NOMBRE_FUNC"), root_3);

                        adaptor.addChild(root_3, adaptor.create(IDENT,"main"));

                        adaptor.addChild(root_2, root_3);
                        }

                        adaptor.addChild(root_1, root_2);
                        }

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:75:4: funciones EOF
                    {
                    pushFollow(FOLLOW_funciones_in_programa274);
                    funciones4=funciones();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_funciones.add(funciones4.getTree());
                    EOF5=(Token)match(input,EOF,FOLLOW_EOF_in_programa276); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_EOF.add(EOF5);



                    // AST REWRITE
                    // elements: funciones
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 76:3: -> ^( PROGRAMA ^( FUNCIONES funciones ) ^( LLAMADA ^( NOMBRE_FUNC ) ) )
                    {
                        // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:76:6: ^( PROGRAMA ^( FUNCIONES funciones ) ^( LLAMADA ^( NOMBRE_FUNC ) ) )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(PROGRAMA, "PROGRAMA"), root_1);

                        // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:76:17: ^( FUNCIONES funciones )
                        {
                        CommonTree root_2 = (CommonTree)adaptor.nil();
                        root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(FUNCIONES, "FUNCIONES"), root_2);

                        adaptor.addChild(root_2, stream_funciones.nextTree());

                        adaptor.addChild(root_1, root_2);
                        }
                        // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:76:40: ^( LLAMADA ^( NOMBRE_FUNC ) )
                        {
                        CommonTree root_2 = (CommonTree)adaptor.nil();
                        root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(LLAMADA, "LLAMADA"), root_2);

                        // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:76:50: ^( NOMBRE_FUNC )
                        {
                        CommonTree root_3 = (CommonTree)adaptor.nil();
                        root_3 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NOMBRE_FUNC, "NOMBRE_FUNC"), root_3);

                        adaptor.addChild(root_3, adaptor.create(IDENT,"main"));

                        adaptor.addChild(root_2, root_3);
                        }

                        adaptor.addChild(root_1, root_2);
                        }

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "programa"

    public static class declaraciones_globales_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "declaraciones_globales"
    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:81:1: declaraciones_globales : ( declaracion_global )+ ;
    public final CParser.declaraciones_globales_return declaraciones_globales() throws RecognitionException {
        CParser.declaraciones_globales_return retval = new CParser.declaraciones_globales_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CParser.declaracion_global_return declaracion_global6 = null;



        try {
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:82:2: ( ( declaracion_global )+ )
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:83:2: ( declaracion_global )+
            {
            root_0 = (CommonTree)adaptor.nil();

            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:83:2: ( declaracion_global )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>=105 && LA2_0<=106)) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:83:2: declaracion_global
            	    {
            	    pushFollow(FOLLOW_declaracion_global_in_declaraciones_globales319);
            	    declaracion_global6=declaracion_global();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, declaracion_global6.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt2 >= 1 ) break loop2;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "declaraciones_globales"

    public static class funciones_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "funciones"
    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:87:1: funciones : ( funcion )+ ;
    public final CParser.funciones_return funciones() throws RecognitionException {
        CParser.funciones_return retval = new CParser.funciones_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CParser.funcion_return funcion7 = null;



        try {
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:88:2: ( ( funcion )+ )
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:89:2: ( funcion )+
            {
            root_0 = (CommonTree)adaptor.nil();

            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:89:2: ( funcion )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==IDENT||(LA3_0>=100 && LA3_0<=104)) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:89:2: funcion
            	    {
            	    pushFollow(FOLLOW_funcion_in_funciones335);
            	    funcion7=funcion();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, funcion7.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "funciones"

    public static class tipo_base_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "tipo_base"
    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:94:1: tipo_base : ( 'void' | 'char' | 'int' | 'float' | 'double' );
    public final CParser.tipo_base_return tipo_base() throws RecognitionException {
        CParser.tipo_base_return retval = new CParser.tipo_base_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set8=null;

        CommonTree set8_tree=null;

        try {
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:95:2: ( 'void' | 'char' | 'int' | 'float' | 'double' )
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:
            {
            root_0 = (CommonTree)adaptor.nil();

            set8=(Token)input.LT(1);
            if ( (input.LA(1)>=100 && input.LA(1)<=104) ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set8));
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "tipo_base"

    public static class declaracion_global_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "declaracion_global"
    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:106:1: declaracion_global : precompilacion ;
    public final CParser.declaracion_global_return declaracion_global() throws RecognitionException {
        CParser.declaracion_global_return retval = new CParser.declaracion_global_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CParser.precompilacion_return precompilacion9 = null;



        try {
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:108:2: ( precompilacion )
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:108:4: precompilacion
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_precompilacion_in_declaracion_global397);
            precompilacion9=precompilacion();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, precompilacion9.getTree());

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "declaracion_global"

    public static class funcion_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "funcion"
    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:129:1: funcion : ( cabecera_funcion bloque -> ^( FUNCION ^( CABECERA_FUNCION cabecera_funcion ) ^( bloque ) ) | cabecera_funcion PUNTOYCOMA );
    public final CParser.funcion_return funcion() throws RecognitionException {
        CParser.funcion_return retval = new CParser.funcion_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token PUNTOYCOMA13=null;
        CParser.cabecera_funcion_return cabecera_funcion10 = null;

        CParser.bloque_return bloque11 = null;

        CParser.cabecera_funcion_return cabecera_funcion12 = null;


        CommonTree PUNTOYCOMA13_tree=null;
        RewriteRuleSubtreeStream stream_cabecera_funcion=new RewriteRuleSubtreeStream(adaptor,"rule cabecera_funcion");
        RewriteRuleSubtreeStream stream_bloque=new RewriteRuleSubtreeStream(adaptor,"rule bloque");
        try {
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:130:2: ( cabecera_funcion bloque -> ^( FUNCION ^( CABECERA_FUNCION cabecera_funcion ) ^( bloque ) ) | cabecera_funcion PUNTOYCOMA )
            int alt4=2;
            alt4 = dfa4.predict(input);
            switch (alt4) {
                case 1 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:131:3: cabecera_funcion bloque
                    {
                    pushFollow(FOLLOW_cabecera_funcion_in_funcion434);
                    cabecera_funcion10=cabecera_funcion();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_cabecera_funcion.add(cabecera_funcion10.getTree());
                    pushFollow(FOLLOW_bloque_in_funcion436);
                    bloque11=bloque();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_bloque.add(bloque11.getTree());


                    // AST REWRITE
                    // elements: cabecera_funcion, bloque
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 131:27: -> ^( FUNCION ^( CABECERA_FUNCION cabecera_funcion ) ^( bloque ) )
                    {
                        // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:131:30: ^( FUNCION ^( CABECERA_FUNCION cabecera_funcion ) ^( bloque ) )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(FUNCION, "FUNCION"), root_1);

                        // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:131:40: ^( CABECERA_FUNCION cabecera_funcion )
                        {
                        CommonTree root_2 = (CommonTree)adaptor.nil();
                        root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(CABECERA_FUNCION, "CABECERA_FUNCION"), root_2);

                        adaptor.addChild(root_2, stream_cabecera_funcion.nextTree());

                        adaptor.addChild(root_1, root_2);
                        }
                        // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:131:77: ^( bloque )
                        {
                        CommonTree root_2 = (CommonTree)adaptor.nil();
                        root_2 = (CommonTree)adaptor.becomeRoot(stream_bloque.nextNode(), root_2);

                        adaptor.addChild(root_1, root_2);
                        }

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:132:4: cabecera_funcion PUNTOYCOMA
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_cabecera_funcion_in_funcion457);
                    cabecera_funcion12=cabecera_funcion();

                    state._fsp--;
                    if (state.failed) return retval;
                    PUNTOYCOMA13=(Token)match(input,PUNTOYCOMA,FOLLOW_PUNTOYCOMA_in_funcion460); if (state.failed) return retval;

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "funcion"

    public static class cabecera_funcion_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "cabecera_funcion"
    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:144:1: cabecera_funcion : declaracion_nombre_funcion LPAR ( lista_param_formales )? RPAR ;
    public final CParser.cabecera_funcion_return cabecera_funcion() throws RecognitionException {
        CParser.cabecera_funcion_return retval = new CParser.cabecera_funcion_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token LPAR15=null;
        Token RPAR17=null;
        CParser.declaracion_nombre_funcion_return declaracion_nombre_funcion14 = null;

        CParser.lista_param_formales_return lista_param_formales16 = null;


        CommonTree LPAR15_tree=null;
        CommonTree RPAR17_tree=null;

        try {
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:145:2: ( declaracion_nombre_funcion LPAR ( lista_param_formales )? RPAR )
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:145:4: declaracion_nombre_funcion LPAR ( lista_param_formales )? RPAR
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_declaracion_nombre_funcion_in_cabecera_funcion483);
            declaracion_nombre_funcion14=declaracion_nombre_funcion();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, declaracion_nombre_funcion14.getTree());
            LPAR15=(Token)match(input,LPAR,FOLLOW_LPAR_in_cabecera_funcion485); if (state.failed) return retval;
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:145:37: ( lista_param_formales )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( ((LA5_0>=100 && LA5_0<=104)) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:145:37: lista_param_formales
                    {
                    pushFollow(FOLLOW_lista_param_formales_in_cabecera_funcion488);
                    lista_param_formales16=lista_param_formales();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, lista_param_formales16.getTree());

                    }
                    break;

            }

            RPAR17=(Token)match(input,RPAR,FOLLOW_RPAR_in_cabecera_funcion491); if (state.failed) return retval;

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "cabecera_funcion"

    public static class lista_param_formales_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "lista_param_formales"
    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:153:1: lista_param_formales : param_formal ( COMA param_formal )* ;
    public final CParser.lista_param_formales_return lista_param_formales() throws RecognitionException {
        CParser.lista_param_formales_return retval = new CParser.lista_param_formales_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token COMA19=null;
        CParser.param_formal_return param_formal18 = null;

        CParser.param_formal_return param_formal20 = null;


        CommonTree COMA19_tree=null;

        try {
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:154:2: ( param_formal ( COMA param_formal )* )
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:154:4: param_formal ( COMA param_formal )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_param_formal_in_lista_param_formales510);
            param_formal18=param_formal();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, param_formal18.getTree());
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:154:17: ( COMA param_formal )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==COMA) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:154:19: COMA param_formal
            	    {
            	    COMA19=(Token)match(input,COMA,FOLLOW_COMA_in_lista_param_formales514); if (state.failed) return retval;
            	    pushFollow(FOLLOW_param_formal_in_lista_param_formales517);
            	    param_formal20=param_formal();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, param_formal20.getTree());

            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "lista_param_formales"

    public static class param_formal_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "param_formal"
    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:166:1: param_formal : ( tipo_base IDENT -> ^( PARAM_FORMAL ^( TIPO_BASE tipo_base ) ^( NOMBRE_VAR IDENT ) ) | tipo_base IDENT LCOR RCOR -> ^( PARAM_FORMAL_ARR ^( TIPO_BASE tipo_base ) ^( NOMBRE_VAR IDENT ) ) | tipo_base '*' IDENT -> ^( PARAM_FORMAL_ARR ^( TIPO_BASE tipo_base ) ^( NOMBRE_VAR IDENT ) ) );
    public final CParser.param_formal_return param_formal() throws RecognitionException {
        CParser.param_formal_return retval = new CParser.param_formal_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token IDENT22=null;
        Token IDENT24=null;
        Token LCOR25=null;
        Token RCOR26=null;
        Token char_literal28=null;
        Token IDENT29=null;
        CParser.tipo_base_return tipo_base21 = null;

        CParser.tipo_base_return tipo_base23 = null;

        CParser.tipo_base_return tipo_base27 = null;


        CommonTree IDENT22_tree=null;
        CommonTree IDENT24_tree=null;
        CommonTree LCOR25_tree=null;
        CommonTree RCOR26_tree=null;
        CommonTree char_literal28_tree=null;
        CommonTree IDENT29_tree=null;
        RewriteRuleTokenStream stream_IDENT=new RewriteRuleTokenStream(adaptor,"token IDENT");
        RewriteRuleTokenStream stream_RCOR=new RewriteRuleTokenStream(adaptor,"token RCOR");
        RewriteRuleTokenStream stream_LCOR=new RewriteRuleTokenStream(adaptor,"token LCOR");
        RewriteRuleTokenStream stream_PROD=new RewriteRuleTokenStream(adaptor,"token PROD");
        RewriteRuleSubtreeStream stream_tipo_base=new RewriteRuleSubtreeStream(adaptor,"rule tipo_base");
        try {
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:167:2: ( tipo_base IDENT -> ^( PARAM_FORMAL ^( TIPO_BASE tipo_base ) ^( NOMBRE_VAR IDENT ) ) | tipo_base IDENT LCOR RCOR -> ^( PARAM_FORMAL_ARR ^( TIPO_BASE tipo_base ) ^( NOMBRE_VAR IDENT ) ) | tipo_base '*' IDENT -> ^( PARAM_FORMAL_ARR ^( TIPO_BASE tipo_base ) ^( NOMBRE_VAR IDENT ) ) )
            int alt7=3;
            int LA7_0 = input.LA(1);

            if ( ((LA7_0>=100 && LA7_0<=104)) ) {
                int LA7_1 = input.LA(2);

                if ( (LA7_1==IDENT) ) {
                    int LA7_2 = input.LA(3);

                    if ( (LA7_2==LCOR) ) {
                        alt7=2;
                    }
                    else if ( ((LA7_2>=RPAR && LA7_2<=COMA)) ) {
                        alt7=1;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 7, 2, input);

                        throw nvae;
                    }
                }
                else if ( (LA7_1==PROD) ) {
                    alt7=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 7, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:167:4: tipo_base IDENT
                    {
                    pushFollow(FOLLOW_tipo_base_in_param_formal542);
                    tipo_base21=tipo_base();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_tipo_base.add(tipo_base21.getTree());
                    IDENT22=(Token)match(input,IDENT,FOLLOW_IDENT_in_param_formal544); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_IDENT.add(IDENT22);



                    // AST REWRITE
                    // elements: IDENT, tipo_base
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 167:20: -> ^( PARAM_FORMAL ^( TIPO_BASE tipo_base ) ^( NOMBRE_VAR IDENT ) )
                    {
                        // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:167:23: ^( PARAM_FORMAL ^( TIPO_BASE tipo_base ) ^( NOMBRE_VAR IDENT ) )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(PARAM_FORMAL, "PARAM_FORMAL"), root_1);

                        // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:167:38: ^( TIPO_BASE tipo_base )
                        {
                        CommonTree root_2 = (CommonTree)adaptor.nil();
                        root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(TIPO_BASE, "TIPO_BASE"), root_2);

                        adaptor.addChild(root_2, stream_tipo_base.nextTree());

                        adaptor.addChild(root_1, root_2);
                        }
                        // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:167:61: ^( NOMBRE_VAR IDENT )
                        {
                        CommonTree root_2 = (CommonTree)adaptor.nil();
                        root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NOMBRE_VAR, "NOMBRE_VAR"), root_2);

                        adaptor.addChild(root_2, stream_IDENT.nextNode());

                        adaptor.addChild(root_1, root_2);
                        }

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:168:4: tipo_base IDENT LCOR RCOR
                    {
                    pushFollow(FOLLOW_tipo_base_in_param_formal569);
                    tipo_base23=tipo_base();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_tipo_base.add(tipo_base23.getTree());
                    IDENT24=(Token)match(input,IDENT,FOLLOW_IDENT_in_param_formal571); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_IDENT.add(IDENT24);

                    LCOR25=(Token)match(input,LCOR,FOLLOW_LCOR_in_param_formal573); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_LCOR.add(LCOR25);

                    RCOR26=(Token)match(input,RCOR,FOLLOW_RCOR_in_param_formal575); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_RCOR.add(RCOR26);



                    // AST REWRITE
                    // elements: IDENT, tipo_base
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 168:30: -> ^( PARAM_FORMAL_ARR ^( TIPO_BASE tipo_base ) ^( NOMBRE_VAR IDENT ) )
                    {
                        // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:168:33: ^( PARAM_FORMAL_ARR ^( TIPO_BASE tipo_base ) ^( NOMBRE_VAR IDENT ) )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(PARAM_FORMAL_ARR, "PARAM_FORMAL_ARR"), root_1);

                        // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:168:52: ^( TIPO_BASE tipo_base )
                        {
                        CommonTree root_2 = (CommonTree)adaptor.nil();
                        root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(TIPO_BASE, "TIPO_BASE"), root_2);

                        adaptor.addChild(root_2, stream_tipo_base.nextTree());

                        adaptor.addChild(root_1, root_2);
                        }
                        // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:168:75: ^( NOMBRE_VAR IDENT )
                        {
                        CommonTree root_2 = (CommonTree)adaptor.nil();
                        root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NOMBRE_VAR, "NOMBRE_VAR"), root_2);

                        adaptor.addChild(root_2, stream_IDENT.nextNode());

                        adaptor.addChild(root_1, root_2);
                        }

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 3 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:169:4: tipo_base '*' IDENT
                    {
                    pushFollow(FOLLOW_tipo_base_in_param_formal600);
                    tipo_base27=tipo_base();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_tipo_base.add(tipo_base27.getTree());
                    char_literal28=(Token)match(input,PROD,FOLLOW_PROD_in_param_formal602); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_PROD.add(char_literal28);

                    IDENT29=(Token)match(input,IDENT,FOLLOW_IDENT_in_param_formal604); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_IDENT.add(IDENT29);



                    // AST REWRITE
                    // elements: IDENT, tipo_base
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 169:24: -> ^( PARAM_FORMAL_ARR ^( TIPO_BASE tipo_base ) ^( NOMBRE_VAR IDENT ) )
                    {
                        // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:169:28: ^( PARAM_FORMAL_ARR ^( TIPO_BASE tipo_base ) ^( NOMBRE_VAR IDENT ) )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(PARAM_FORMAL_ARR, "PARAM_FORMAL_ARR"), root_1);

                        // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:169:47: ^( TIPO_BASE tipo_base )
                        {
                        CommonTree root_2 = (CommonTree)adaptor.nil();
                        root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(TIPO_BASE, "TIPO_BASE"), root_2);

                        adaptor.addChild(root_2, stream_tipo_base.nextTree());

                        adaptor.addChild(root_1, root_2);
                        }
                        // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:169:70: ^( NOMBRE_VAR IDENT )
                        {
                        CommonTree root_2 = (CommonTree)adaptor.nil();
                        root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NOMBRE_VAR, "NOMBRE_VAR"), root_2);

                        adaptor.addChild(root_2, stream_IDENT.nextNode());

                        adaptor.addChild(root_1, root_2);
                        }

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "param_formal"

    public static class declaracion_nombre_funcion_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "declaracion_nombre_funcion"
    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:180:1: declaracion_nombre_funcion : ( IDENT -> ^( DECLARACION_NOMBRE_FUNCION ^( NOMBRE_FUNC IDENT ) ) | tipo_base IDENT -> ^( DECLARACION_NOMBRE_FUNCION ^( TIPO_BASE tipo_base ) ^( NOMBRE_FUNC IDENT ) ) );
    public final CParser.declaracion_nombre_funcion_return declaracion_nombre_funcion() throws RecognitionException {
        CParser.declaracion_nombre_funcion_return retval = new CParser.declaracion_nombre_funcion_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token IDENT30=null;
        Token IDENT32=null;
        CParser.tipo_base_return tipo_base31 = null;


        CommonTree IDENT30_tree=null;
        CommonTree IDENT32_tree=null;
        RewriteRuleTokenStream stream_IDENT=new RewriteRuleTokenStream(adaptor,"token IDENT");
        RewriteRuleSubtreeStream stream_tipo_base=new RewriteRuleSubtreeStream(adaptor,"rule tipo_base");
        try {
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:181:2: ( IDENT -> ^( DECLARACION_NOMBRE_FUNCION ^( NOMBRE_FUNC IDENT ) ) | tipo_base IDENT -> ^( DECLARACION_NOMBRE_FUNCION ^( TIPO_BASE tipo_base ) ^( NOMBRE_FUNC IDENT ) ) )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==IDENT) ) {
                alt8=1;
            }
            else if ( ((LA8_0>=100 && LA8_0<=104)) ) {
                alt8=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:181:4: IDENT
                    {
                    IDENT30=(Token)match(input,IDENT,FOLLOW_IDENT_in_declaracion_nombre_funcion645); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_IDENT.add(IDENT30);



                    // AST REWRITE
                    // elements: IDENT
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 181:10: -> ^( DECLARACION_NOMBRE_FUNCION ^( NOMBRE_FUNC IDENT ) )
                    {
                        // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:181:13: ^( DECLARACION_NOMBRE_FUNCION ^( NOMBRE_FUNC IDENT ) )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(DECLARACION_NOMBRE_FUNCION, "DECLARACION_NOMBRE_FUNCION"), root_1);

                        // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:181:42: ^( NOMBRE_FUNC IDENT )
                        {
                        CommonTree root_2 = (CommonTree)adaptor.nil();
                        root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NOMBRE_FUNC, "NOMBRE_FUNC"), root_2);

                        adaptor.addChild(root_2, stream_IDENT.nextNode());

                        adaptor.addChild(root_1, root_2);
                        }

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:182:4: tipo_base IDENT
                    {
                    pushFollow(FOLLOW_tipo_base_in_declaracion_nombre_funcion662);
                    tipo_base31=tipo_base();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_tipo_base.add(tipo_base31.getTree());
                    IDENT32=(Token)match(input,IDENT,FOLLOW_IDENT_in_declaracion_nombre_funcion664); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_IDENT.add(IDENT32);



                    // AST REWRITE
                    // elements: IDENT, tipo_base
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 182:20: -> ^( DECLARACION_NOMBRE_FUNCION ^( TIPO_BASE tipo_base ) ^( NOMBRE_FUNC IDENT ) )
                    {
                        // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:182:23: ^( DECLARACION_NOMBRE_FUNCION ^( TIPO_BASE tipo_base ) ^( NOMBRE_FUNC IDENT ) )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(DECLARACION_NOMBRE_FUNCION, "DECLARACION_NOMBRE_FUNCION"), root_1);

                        // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:182:52: ^( TIPO_BASE tipo_base )
                        {
                        CommonTree root_2 = (CommonTree)adaptor.nil();
                        root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(TIPO_BASE, "TIPO_BASE"), root_2);

                        adaptor.addChild(root_2, stream_tipo_base.nextTree());

                        adaptor.addChild(root_1, root_2);
                        }
                        // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:182:75: ^( NOMBRE_FUNC IDENT )
                        {
                        CommonTree root_2 = (CommonTree)adaptor.nil();
                        root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NOMBRE_FUNC, "NOMBRE_FUNC"), root_2);

                        adaptor.addChild(root_2, stream_IDENT.nextNode());

                        adaptor.addChild(root_1, root_2);
                        }

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "declaracion_nombre_funcion"

    public static class sentencia_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "sentencia"
    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:188:1: sentencia : ( bloque | sentencia_asignacion | llamada | RETURN expr -> ^( RETURN expr ) | prim | funcion_predefinida | sentenciaIF | sentenciaWHILE | sentenciaDOWHILE | sentenciaFOR | PUNTOYCOMA );
    public final CParser.sentencia_return sentencia() throws RecognitionException {
        CParser.sentencia_return retval = new CParser.sentencia_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token RETURN36=null;
        Token PUNTOYCOMA44=null;
        CParser.bloque_return bloque33 = null;

        CParser.sentencia_asignacion_return sentencia_asignacion34 = null;

        CParser.llamada_return llamada35 = null;

        CParser.expr_return expr37 = null;

        CParser.prim_return prim38 = null;

        CParser.funcion_predefinida_return funcion_predefinida39 = null;

        CParser.sentenciaIF_return sentenciaIF40 = null;

        CParser.sentenciaWHILE_return sentenciaWHILE41 = null;

        CParser.sentenciaDOWHILE_return sentenciaDOWHILE42 = null;

        CParser.sentenciaFOR_return sentenciaFOR43 = null;


        CommonTree RETURN36_tree=null;
        CommonTree PUNTOYCOMA44_tree=null;
        RewriteRuleTokenStream stream_RETURN=new RewriteRuleTokenStream(adaptor,"token RETURN");
        RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
        try {
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:189:2: ( bloque | sentencia_asignacion | llamada | RETURN expr -> ^( RETURN expr ) | prim | funcion_predefinida | sentenciaIF | sentenciaWHILE | sentenciaDOWHILE | sentenciaFOR | PUNTOYCOMA )
            int alt9=11;
            alt9 = dfa9.predict(input);
            switch (alt9) {
                case 1 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:190:4: bloque
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_bloque_in_sentencia701);
                    bloque33=bloque();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, bloque33.getTree());

                    }
                    break;
                case 2 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:191:4: sentencia_asignacion
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_sentencia_asignacion_in_sentencia706);
                    sentencia_asignacion34=sentencia_asignacion();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, sentencia_asignacion34.getTree());

                    }
                    break;
                case 3 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:192:4: llamada
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_llamada_in_sentencia711);
                    llamada35=llamada();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, llamada35.getTree());

                    }
                    break;
                case 4 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:193:4: RETURN expr
                    {
                    RETURN36=(Token)match(input,RETURN,FOLLOW_RETURN_in_sentencia717); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_RETURN.add(RETURN36);

                    pushFollow(FOLLOW_expr_in_sentencia719);
                    expr37=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expr.add(expr37.getTree());


                    // AST REWRITE
                    // elements: RETURN, expr
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 193:16: -> ^( RETURN expr )
                    {
                        // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:193:20: ^( RETURN expr )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(stream_RETURN.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_expr.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 5 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:194:4: prim
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_prim_in_sentencia733);
                    prim38=prim();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, prim38.getTree());

                    }
                    break;
                case 6 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:195:4: funcion_predefinida
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_funcion_predefinida_in_sentencia738);
                    funcion_predefinida39=funcion_predefinida();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, funcion_predefinida39.getTree());

                    }
                    break;
                case 7 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:196:4: sentenciaIF
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_sentenciaIF_in_sentencia743);
                    sentenciaIF40=sentenciaIF();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, sentenciaIF40.getTree());

                    }
                    break;
                case 8 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:197:4: sentenciaWHILE
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_sentenciaWHILE_in_sentencia748);
                    sentenciaWHILE41=sentenciaWHILE();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, sentenciaWHILE41.getTree());

                    }
                    break;
                case 9 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:198:4: sentenciaDOWHILE
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_sentenciaDOWHILE_in_sentencia753);
                    sentenciaDOWHILE42=sentenciaDOWHILE();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, sentenciaDOWHILE42.getTree());

                    }
                    break;
                case 10 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:199:4: sentenciaFOR
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_sentenciaFOR_in_sentencia758);
                    sentenciaFOR43=sentenciaFOR();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, sentenciaFOR43.getTree());

                    }
                    break;
                case 11 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:200:4: PUNTOYCOMA
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    PUNTOYCOMA44=(Token)match(input,PUNTOYCOMA,FOLLOW_PUNTOYCOMA_in_sentencia763); if (state.failed) return retval;

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "sentencia"

    public static class bloque_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "bloque"
    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:204:1: bloque : LCURL ( elemento_bloque )* RCURL -> ^( BLOQUE ( elemento_bloque )* ) ;
    public final CParser.bloque_return bloque() throws RecognitionException {
        CParser.bloque_return retval = new CParser.bloque_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token LCURL45=null;
        Token RCURL47=null;
        CParser.elemento_bloque_return elemento_bloque46 = null;


        CommonTree LCURL45_tree=null;
        CommonTree RCURL47_tree=null;
        RewriteRuleTokenStream stream_LCURL=new RewriteRuleTokenStream(adaptor,"token LCURL");
        RewriteRuleTokenStream stream_RCURL=new RewriteRuleTokenStream(adaptor,"token RCURL");
        RewriteRuleSubtreeStream stream_elemento_bloque=new RewriteRuleSubtreeStream(adaptor,"rule elemento_bloque");
        try {
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:204:8: ( LCURL ( elemento_bloque )* RCURL -> ^( BLOQUE ( elemento_bloque )* ) )
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:205:3: LCURL ( elemento_bloque )* RCURL
            {
            LCURL45=(Token)match(input,LCURL,FOLLOW_LCURL_in_bloque778); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_LCURL.add(LCURL45);

            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:205:9: ( elemento_bloque )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==PUNTOYCOMA||LA10_0==IDENT||(LA10_0>=RETURN && LA10_0<=LCURL)||LA10_0==IF||(LA10_0>=WHILE && LA10_0<=FOR)||LA10_0==PROD||(LA10_0>=MASMAS && LA10_0<=FUNCLEER)||(LA10_0>=FUNCIMPRIMIR && LA10_0<=FUNC_STRLEN)||(LA10_0>=100 && LA10_0<=104)) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:205:9: elemento_bloque
            	    {
            	    pushFollow(FOLLOW_elemento_bloque_in_bloque780);
            	    elemento_bloque46=elemento_bloque();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_elemento_bloque.add(elemento_bloque46.getTree());

            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

            RCURL47=(Token)match(input,RCURL,FOLLOW_RCURL_in_bloque783); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_RCURL.add(RCURL47);



            // AST REWRITE
            // elements: elemento_bloque
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 205:32: -> ^( BLOQUE ( elemento_bloque )* )
            {
                // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:205:35: ^( BLOQUE ( elemento_bloque )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(BLOQUE, "BLOQUE"), root_1);

                // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:205:44: ( elemento_bloque )*
                while ( stream_elemento_bloque.hasNext() ) {
                    adaptor.addChild(root_1, stream_elemento_bloque.nextTree());

                }
                stream_elemento_bloque.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "bloque"

    public static class elemento_bloque_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "elemento_bloque"
    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:210:1: elemento_bloque : ( declaracion_variables | sentencia );
    public final CParser.elemento_bloque_return elemento_bloque() throws RecognitionException {
        CParser.elemento_bloque_return retval = new CParser.elemento_bloque_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CParser.declaracion_variables_return declaracion_variables48 = null;

        CParser.sentencia_return sentencia49 = null;



        try {
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:211:2: ( declaracion_variables | sentencia )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( ((LA11_0>=100 && LA11_0<=104)) ) {
                alt11=1;
            }
            else if ( (LA11_0==PUNTOYCOMA||LA11_0==IDENT||(LA11_0>=RETURN && LA11_0<=LCURL)||LA11_0==IF||(LA11_0>=WHILE && LA11_0<=FOR)||LA11_0==PROD||(LA11_0>=MASMAS && LA11_0<=FUNCLEER)||(LA11_0>=FUNCIMPRIMIR && LA11_0<=FUNC_STRLEN)) ) {
                alt11=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:211:4: declaracion_variables
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_declaracion_variables_in_elemento_bloque806);
                    declaracion_variables48=declaracion_variables();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, declaracion_variables48.getTree());

                    }
                    break;
                case 2 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:212:4: sentencia
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_sentencia_in_elemento_bloque811);
                    sentencia49=sentencia();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, sentencia49.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "elemento_bloque"

    protected static class declaracion_variables_scope {
        // En scope definimos variables globales de la regla.
        	String tipo;
    }
    protected Stack declaracion_variables_stack = new Stack();

    public static class declaracion_variables_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "declaracion_variables"
    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:217:1: declaracion_variables options {backtrack=true; } : tipo_base declaracion_var_asig ( COMA declaracion_var_asig )* PUNTOYCOMA -> ^( DECL tipo_base ( declaracion_var_asig )+ ) ;
    public final CParser.declaracion_variables_return declaracion_variables() throws RecognitionException {
        declaracion_variables_stack.push(new declaracion_variables_scope());
        CParser.declaracion_variables_return retval = new CParser.declaracion_variables_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token COMA52=null;
        Token PUNTOYCOMA54=null;
        CParser.tipo_base_return tipo_base50 = null;

        CParser.declaracion_var_asig_return declaracion_var_asig51 = null;

        CParser.declaracion_var_asig_return declaracion_var_asig53 = null;


        CommonTree COMA52_tree=null;
        CommonTree PUNTOYCOMA54_tree=null;
        RewriteRuleTokenStream stream_PUNTOYCOMA=new RewriteRuleTokenStream(adaptor,"token PUNTOYCOMA");
        RewriteRuleTokenStream stream_COMA=new RewriteRuleTokenStream(adaptor,"token COMA");
        RewriteRuleSubtreeStream stream_tipo_base=new RewriteRuleSubtreeStream(adaptor,"rule tipo_base");
        RewriteRuleSubtreeStream stream_declaracion_var_asig=new RewriteRuleSubtreeStream(adaptor,"rule declaracion_var_asig");
        try {
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:229:3: ( tipo_base declaracion_var_asig ( COMA declaracion_var_asig )* PUNTOYCOMA -> ^( DECL tipo_base ( declaracion_var_asig )+ ) )
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:230:3: tipo_base declaracion_var_asig ( COMA declaracion_var_asig )* PUNTOYCOMA
            {
            pushFollow(FOLLOW_tipo_base_in_declaracion_variables852);
            tipo_base50=tipo_base();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_tipo_base.add(tipo_base50.getTree());
            pushFollow(FOLLOW_declaracion_var_asig_in_declaracion_variables855);
            declaracion_var_asig51=declaracion_var_asig();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_declaracion_var_asig.add(declaracion_var_asig51.getTree());
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:230:35: ( COMA declaracion_var_asig )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==COMA) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:230:36: COMA declaracion_var_asig
            	    {
            	    COMA52=(Token)match(input,COMA,FOLLOW_COMA_in_declaracion_variables858); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_COMA.add(COMA52);

            	    pushFollow(FOLLOW_declaracion_var_asig_in_declaracion_variables860);
            	    declaracion_var_asig53=declaracion_var_asig();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_declaracion_var_asig.add(declaracion_var_asig53.getTree());

            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

            PUNTOYCOMA54=(Token)match(input,PUNTOYCOMA,FOLLOW_PUNTOYCOMA_in_declaracion_variables864); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_PUNTOYCOMA.add(PUNTOYCOMA54);



            // AST REWRITE
            // elements: tipo_base, declaracion_var_asig
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 231:2: -> ^( DECL tipo_base ( declaracion_var_asig )+ )
            {
                // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:231:5: ^( DECL tipo_base ( declaracion_var_asig )+ )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(DECL, "DECL"), root_1);

                adaptor.addChild(root_1, stream_tipo_base.nextTree());
                if ( !(stream_declaracion_var_asig.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_declaracion_var_asig.hasNext() ) {
                    adaptor.addChild(root_1, stream_declaracion_var_asig.nextTree());

                }
                stream_declaracion_var_asig.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            declaracion_variables_stack.pop();
        }
        return retval;
    }
    // $ANTLR end "declaracion_variables"

    public static class declaracion_var_asig_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "declaracion_var_asig"
    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:236:1: declaracion_var_asig : declaracion_variable ( asignacion )? ;
    public final CParser.declaracion_var_asig_return declaracion_var_asig() throws RecognitionException {
        CParser.declaracion_var_asig_return retval = new CParser.declaracion_var_asig_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CParser.declaracion_variable_return declaracion_variable55 = null;

        CParser.asignacion_return asignacion56 = null;



        try {
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:237:2: ( declaracion_variable ( asignacion )? )
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:238:3: declaracion_variable ( asignacion )?
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_declaracion_variable_in_declaracion_var_asig897);
            declaracion_variable55=declaracion_variable();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, declaracion_variable55.getTree());
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:238:24: ( asignacion )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==ASIG) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:238:24: asignacion
                    {
                    pushFollow(FOLLOW_asignacion_in_declaracion_var_asig899);
                    asignacion56=asignacion();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, asignacion56.getTree());

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "declaracion_var_asig"

    public static class sentenciaIF_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "sentenciaIF"
    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:243:1: sentenciaIF options {backtrack=true; } : ( IF LPAR expr RPAR s1= sentencia ELSE s2= sentencia -> ^( IF ^( EXPRESION expr ) $s1 $s2) | IF LPAR expr RPAR sentencia -> ^( IF ^( EXPRESION expr ) sentencia ) );
    public final CParser.sentenciaIF_return sentenciaIF() throws RecognitionException {
        CParser.sentenciaIF_return retval = new CParser.sentenciaIF_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token IF57=null;
        Token LPAR58=null;
        Token RPAR60=null;
        Token ELSE61=null;
        Token IF62=null;
        Token LPAR63=null;
        Token RPAR65=null;
        CParser.sentencia_return s1 = null;

        CParser.sentencia_return s2 = null;

        CParser.expr_return expr59 = null;

        CParser.expr_return expr64 = null;

        CParser.sentencia_return sentencia66 = null;


        CommonTree IF57_tree=null;
        CommonTree LPAR58_tree=null;
        CommonTree RPAR60_tree=null;
        CommonTree ELSE61_tree=null;
        CommonTree IF62_tree=null;
        CommonTree LPAR63_tree=null;
        CommonTree RPAR65_tree=null;
        RewriteRuleTokenStream stream_RPAR=new RewriteRuleTokenStream(adaptor,"token RPAR");
        RewriteRuleTokenStream stream_LPAR=new RewriteRuleTokenStream(adaptor,"token LPAR");
        RewriteRuleTokenStream stream_IF=new RewriteRuleTokenStream(adaptor,"token IF");
        RewriteRuleTokenStream stream_ELSE=new RewriteRuleTokenStream(adaptor,"token ELSE");
        RewriteRuleSubtreeStream stream_sentencia=new RewriteRuleSubtreeStream(adaptor,"rule sentencia");
        RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
        try {
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:247:2: ( IF LPAR expr RPAR s1= sentencia ELSE s2= sentencia -> ^( IF ^( EXPRESION expr ) $s1 $s2) | IF LPAR expr RPAR sentencia -> ^( IF ^( EXPRESION expr ) sentencia ) )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==IF) ) {
                int LA14_1 = input.LA(2);

                if ( (synpred1_C()) ) {
                    alt14=1;
                }
                else if ( (true) ) {
                    alt14=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 14, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:249:3: IF LPAR expr RPAR s1= sentencia ELSE s2= sentencia
                    {
                    IF57=(Token)match(input,IF,FOLLOW_IF_in_sentenciaIF931); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_IF.add(IF57);

                    LPAR58=(Token)match(input,LPAR,FOLLOW_LPAR_in_sentenciaIF933); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_LPAR.add(LPAR58);

                    pushFollow(FOLLOW_expr_in_sentenciaIF935);
                    expr59=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expr.add(expr59.getTree());
                    RPAR60=(Token)match(input,RPAR,FOLLOW_RPAR_in_sentenciaIF937); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_RPAR.add(RPAR60);

                    pushFollow(FOLLOW_sentencia_in_sentenciaIF941);
                    s1=sentencia();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_sentencia.add(s1.getTree());
                    ELSE61=(Token)match(input,ELSE,FOLLOW_ELSE_in_sentenciaIF944); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ELSE.add(ELSE61);

                    pushFollow(FOLLOW_sentencia_in_sentenciaIF948);
                    s2=sentencia();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_sentencia.add(s2.getTree());


                    // AST REWRITE
                    // elements: expr, IF, s2, s1
                    // token labels: 
                    // rule labels: retval, s2, s1
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_s2=new RewriteRuleSubtreeStream(adaptor,"rule s2",s2!=null?s2.tree:null);
                    RewriteRuleSubtreeStream stream_s1=new RewriteRuleSubtreeStream(adaptor,"rule s1",s1!=null?s1.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 249:53: -> ^( IF ^( EXPRESION expr ) $s1 $s2)
                    {
                        // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:249:56: ^( IF ^( EXPRESION expr ) $s1 $s2)
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(stream_IF.nextNode(), root_1);

                        // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:249:61: ^( EXPRESION expr )
                        {
                        CommonTree root_2 = (CommonTree)adaptor.nil();
                        root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(EXPRESION, "EXPRESION"), root_2);

                        adaptor.addChild(root_2, stream_expr.nextTree());

                        adaptor.addChild(root_1, root_2);
                        }
                        adaptor.addChild(root_1, stream_s1.nextTree());
                        adaptor.addChild(root_1, stream_s2.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:250:4: IF LPAR expr RPAR sentencia
                    {
                    IF62=(Token)match(input,IF,FOLLOW_IF_in_sentenciaIF972); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_IF.add(IF62);

                    LPAR63=(Token)match(input,LPAR,FOLLOW_LPAR_in_sentenciaIF974); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_LPAR.add(LPAR63);

                    pushFollow(FOLLOW_expr_in_sentenciaIF976);
                    expr64=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expr.add(expr64.getTree());
                    RPAR65=(Token)match(input,RPAR,FOLLOW_RPAR_in_sentenciaIF978); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_RPAR.add(RPAR65);

                    pushFollow(FOLLOW_sentencia_in_sentenciaIF980);
                    sentencia66=sentencia();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_sentencia.add(sentencia66.getTree());


                    // AST REWRITE
                    // elements: IF, sentencia, expr
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 250:32: -> ^( IF ^( EXPRESION expr ) sentencia )
                    {
                        // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:250:35: ^( IF ^( EXPRESION expr ) sentencia )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(stream_IF.nextNode(), root_1);

                        // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:250:40: ^( EXPRESION expr )
                        {
                        CommonTree root_2 = (CommonTree)adaptor.nil();
                        root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(EXPRESION, "EXPRESION"), root_2);

                        adaptor.addChild(root_2, stream_expr.nextTree());

                        adaptor.addChild(root_1, root_2);
                        }
                        adaptor.addChild(root_1, stream_sentencia.nextTree());
                        adaptor.addChild(root_1, adaptor.create(BLOQUE,"BLOQUE"));

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "sentenciaIF"

    public static class sentenciaWHILE_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "sentenciaWHILE"
    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:260:1: sentenciaWHILE : WHILE LPAR expr RPAR sentencia -> ^( WHILE expr sentencia ) ;
    public final CParser.sentenciaWHILE_return sentenciaWHILE() throws RecognitionException {
        CParser.sentenciaWHILE_return retval = new CParser.sentenciaWHILE_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token WHILE67=null;
        Token LPAR68=null;
        Token RPAR70=null;
        CParser.expr_return expr69 = null;

        CParser.sentencia_return sentencia71 = null;


        CommonTree WHILE67_tree=null;
        CommonTree LPAR68_tree=null;
        CommonTree RPAR70_tree=null;
        RewriteRuleTokenStream stream_RPAR=new RewriteRuleTokenStream(adaptor,"token RPAR");
        RewriteRuleTokenStream stream_LPAR=new RewriteRuleTokenStream(adaptor,"token LPAR");
        RewriteRuleTokenStream stream_WHILE=new RewriteRuleTokenStream(adaptor,"token WHILE");
        RewriteRuleSubtreeStream stream_sentencia=new RewriteRuleSubtreeStream(adaptor,"rule sentencia");
        RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
        try {
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:261:2: ( WHILE LPAR expr RPAR sentencia -> ^( WHILE expr sentencia ) )
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:261:4: WHILE LPAR expr RPAR sentencia
            {
            WHILE67=(Token)match(input,WHILE,FOLLOW_WHILE_in_sentenciaWHILE1016); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_WHILE.add(WHILE67);

            LPAR68=(Token)match(input,LPAR,FOLLOW_LPAR_in_sentenciaWHILE1018); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_LPAR.add(LPAR68);

            pushFollow(FOLLOW_expr_in_sentenciaWHILE1020);
            expr69=expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_expr.add(expr69.getTree());
            RPAR70=(Token)match(input,RPAR,FOLLOW_RPAR_in_sentenciaWHILE1022); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_RPAR.add(RPAR70);

            pushFollow(FOLLOW_sentencia_in_sentenciaWHILE1024);
            sentencia71=sentencia();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_sentencia.add(sentencia71.getTree());


            // AST REWRITE
            // elements: WHILE, expr, sentencia
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 261:35: -> ^( WHILE expr sentencia )
            {
                // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:261:38: ^( WHILE expr sentencia )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(stream_WHILE.nextNode(), root_1);

                adaptor.addChild(root_1, stream_expr.nextTree());
                adaptor.addChild(root_1, stream_sentencia.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "sentenciaWHILE"

    public static class sentenciaDOWHILE_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "sentenciaDOWHILE"
    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:264:1: sentenciaDOWHILE : DO sentencia WHILE LPAR expr RPAR -> ( sentencia )* ^( WHILE expr sentencia ) ;
    public final CParser.sentenciaDOWHILE_return sentenciaDOWHILE() throws RecognitionException {
        CParser.sentenciaDOWHILE_return retval = new CParser.sentenciaDOWHILE_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token DO72=null;
        Token WHILE74=null;
        Token LPAR75=null;
        Token RPAR77=null;
        CParser.sentencia_return sentencia73 = null;

        CParser.expr_return expr76 = null;


        CommonTree DO72_tree=null;
        CommonTree WHILE74_tree=null;
        CommonTree LPAR75_tree=null;
        CommonTree RPAR77_tree=null;
        RewriteRuleTokenStream stream_DO=new RewriteRuleTokenStream(adaptor,"token DO");
        RewriteRuleTokenStream stream_RPAR=new RewriteRuleTokenStream(adaptor,"token RPAR");
        RewriteRuleTokenStream stream_LPAR=new RewriteRuleTokenStream(adaptor,"token LPAR");
        RewriteRuleTokenStream stream_WHILE=new RewriteRuleTokenStream(adaptor,"token WHILE");
        RewriteRuleSubtreeStream stream_sentencia=new RewriteRuleSubtreeStream(adaptor,"rule sentencia");
        RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
        try {
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:265:2: ( DO sentencia WHILE LPAR expr RPAR -> ( sentencia )* ^( WHILE expr sentencia ) )
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:265:4: DO sentencia WHILE LPAR expr RPAR
            {
            DO72=(Token)match(input,DO,FOLLOW_DO_in_sentenciaDOWHILE1047); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_DO.add(DO72);

            pushFollow(FOLLOW_sentencia_in_sentenciaDOWHILE1049);
            sentencia73=sentencia();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_sentencia.add(sentencia73.getTree());
            WHILE74=(Token)match(input,WHILE,FOLLOW_WHILE_in_sentenciaDOWHILE1051); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_WHILE.add(WHILE74);

            LPAR75=(Token)match(input,LPAR,FOLLOW_LPAR_in_sentenciaDOWHILE1053); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_LPAR.add(LPAR75);

            pushFollow(FOLLOW_expr_in_sentenciaDOWHILE1055);
            expr76=expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_expr.add(expr76.getTree());
            RPAR77=(Token)match(input,RPAR,FOLLOW_RPAR_in_sentenciaDOWHILE1057); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_RPAR.add(RPAR77);



            // AST REWRITE
            // elements: expr, sentencia, WHILE, sentencia
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 265:38: -> ( sentencia )* ^( WHILE expr sentencia )
            {
                // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:265:41: ( sentencia )*
                while ( stream_sentencia.hasNext() ) {
                    adaptor.addChild(root_0, stream_sentencia.nextTree());

                }
                stream_sentencia.reset();
                // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:265:53: ^( WHILE expr sentencia )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(stream_WHILE.nextNode(), root_1);

                adaptor.addChild(root_1, stream_expr.nextTree());
                adaptor.addChild(root_1, stream_sentencia.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "sentenciaDOWHILE"

    public static class sentenciaFOR_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "sentenciaFOR"
    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:268:1: sentenciaFOR : FOR LPAR ini= sentencia_asignacion PUNTOYCOMA cond= expr PUNTOYCOMA inc= sentencia RPAR cuerpo= sentencia -> $ini ^( WHILE $cond ^( BLOQUE $cuerpo $inc) ) ;
    public final CParser.sentenciaFOR_return sentenciaFOR() throws RecognitionException {
        CParser.sentenciaFOR_return retval = new CParser.sentenciaFOR_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token FOR78=null;
        Token LPAR79=null;
        Token PUNTOYCOMA80=null;
        Token PUNTOYCOMA81=null;
        Token RPAR82=null;
        CParser.sentencia_asignacion_return ini = null;

        CParser.expr_return cond = null;

        CParser.sentencia_return inc = null;

        CParser.sentencia_return cuerpo = null;


        CommonTree FOR78_tree=null;
        CommonTree LPAR79_tree=null;
        CommonTree PUNTOYCOMA80_tree=null;
        CommonTree PUNTOYCOMA81_tree=null;
        CommonTree RPAR82_tree=null;
        RewriteRuleTokenStream stream_PUNTOYCOMA=new RewriteRuleTokenStream(adaptor,"token PUNTOYCOMA");
        RewriteRuleTokenStream stream_FOR=new RewriteRuleTokenStream(adaptor,"token FOR");
        RewriteRuleTokenStream stream_RPAR=new RewriteRuleTokenStream(adaptor,"token RPAR");
        RewriteRuleTokenStream stream_LPAR=new RewriteRuleTokenStream(adaptor,"token LPAR");
        RewriteRuleSubtreeStream stream_sentencia_asignacion=new RewriteRuleSubtreeStream(adaptor,"rule sentencia_asignacion");
        RewriteRuleSubtreeStream stream_sentencia=new RewriteRuleSubtreeStream(adaptor,"rule sentencia");
        RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
        try {
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:270:2: ( FOR LPAR ini= sentencia_asignacion PUNTOYCOMA cond= expr PUNTOYCOMA inc= sentencia RPAR cuerpo= sentencia -> $ini ^( WHILE $cond ^( BLOQUE $cuerpo $inc) ) )
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:270:4: FOR LPAR ini= sentencia_asignacion PUNTOYCOMA cond= expr PUNTOYCOMA inc= sentencia RPAR cuerpo= sentencia
            {
            FOR78=(Token)match(input,FOR,FOLLOW_FOR_in_sentenciaFOR1084); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_FOR.add(FOR78);

            LPAR79=(Token)match(input,LPAR,FOLLOW_LPAR_in_sentenciaFOR1086); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_LPAR.add(LPAR79);

            pushFollow(FOLLOW_sentencia_asignacion_in_sentenciaFOR1090);
            ini=sentencia_asignacion();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_sentencia_asignacion.add(ini.getTree());
            PUNTOYCOMA80=(Token)match(input,PUNTOYCOMA,FOLLOW_PUNTOYCOMA_in_sentenciaFOR1092); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_PUNTOYCOMA.add(PUNTOYCOMA80);

            pushFollow(FOLLOW_expr_in_sentenciaFOR1096);
            cond=expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_expr.add(cond.getTree());
            PUNTOYCOMA81=(Token)match(input,PUNTOYCOMA,FOLLOW_PUNTOYCOMA_in_sentenciaFOR1098); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_PUNTOYCOMA.add(PUNTOYCOMA81);

            pushFollow(FOLLOW_sentencia_in_sentenciaFOR1102);
            inc=sentencia();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_sentencia.add(inc.getTree());
            RPAR82=(Token)match(input,RPAR,FOLLOW_RPAR_in_sentenciaFOR1104); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_RPAR.add(RPAR82);

            pushFollow(FOLLOW_sentencia_in_sentenciaFOR1108);
            cuerpo=sentencia();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_sentencia.add(cuerpo.getTree());


            // AST REWRITE
            // elements: cond, cuerpo, inc, ini
            // token labels: 
            // rule labels: retval, inc, ini, cuerpo, cond
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
            RewriteRuleSubtreeStream stream_inc=new RewriteRuleSubtreeStream(adaptor,"rule inc",inc!=null?inc.tree:null);
            RewriteRuleSubtreeStream stream_ini=new RewriteRuleSubtreeStream(adaptor,"rule ini",ini!=null?ini.tree:null);
            RewriteRuleSubtreeStream stream_cuerpo=new RewriteRuleSubtreeStream(adaptor,"rule cuerpo",cuerpo!=null?cuerpo.tree:null);
            RewriteRuleSubtreeStream stream_cond=new RewriteRuleSubtreeStream(adaptor,"rule cond",cond!=null?cond.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 271:3: -> $ini ^( WHILE $cond ^( BLOQUE $cuerpo $inc) )
            {
                adaptor.addChild(root_0, stream_ini.nextTree());
                // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:271:11: ^( WHILE $cond ^( BLOQUE $cuerpo $inc) )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(WHILE, "WHILE"), root_1);

                adaptor.addChild(root_1, stream_cond.nextTree());
                // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:271:25: ^( BLOQUE $cuerpo $inc)
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(BLOQUE, "BLOQUE"), root_2);

                adaptor.addChild(root_2, stream_cuerpo.nextTree());
                adaptor.addChild(root_2, stream_inc.nextTree());

                adaptor.addChild(root_1, root_2);
                }

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "sentenciaFOR"

    public static class asignacion_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "asignacion"
    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:277:1: asignacion : ( ASIG expr -> ^( ASIGNACION ^( EXPRESION expr ) ) | ASIG '*' expr -> ^( ASIGNACION ^( EXPRESION expr ) ) | ASIG listaValores -> ^( ASIGNACION ^( EXPRESION listaValores ) ) | ASIG '&' IDENT -> ^( ASIGNACION_REF ^( EXPRESION IDENT ) ) );
    public final CParser.asignacion_return asignacion() throws RecognitionException {
        CParser.asignacion_return retval = new CParser.asignacion_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token ASIG83=null;
        Token ASIG85=null;
        Token char_literal86=null;
        Token ASIG88=null;
        Token ASIG90=null;
        Token char_literal91=null;
        Token IDENT92=null;
        CParser.expr_return expr84 = null;

        CParser.expr_return expr87 = null;

        CParser.listaValores_return listaValores89 = null;


        CommonTree ASIG83_tree=null;
        CommonTree ASIG85_tree=null;
        CommonTree char_literal86_tree=null;
        CommonTree ASIG88_tree=null;
        CommonTree ASIG90_tree=null;
        CommonTree char_literal91_tree=null;
        CommonTree IDENT92_tree=null;
        RewriteRuleTokenStream stream_AMPERSAND=new RewriteRuleTokenStream(adaptor,"token AMPERSAND");
        RewriteRuleTokenStream stream_IDENT=new RewriteRuleTokenStream(adaptor,"token IDENT");
        RewriteRuleTokenStream stream_ASIG=new RewriteRuleTokenStream(adaptor,"token ASIG");
        RewriteRuleTokenStream stream_PROD=new RewriteRuleTokenStream(adaptor,"token PROD");
        RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
        RewriteRuleSubtreeStream stream_listaValores=new RewriteRuleSubtreeStream(adaptor,"rule listaValores");
        try {
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:278:2: ( ASIG expr -> ^( ASIGNACION ^( EXPRESION expr ) ) | ASIG '*' expr -> ^( ASIGNACION ^( EXPRESION expr ) ) | ASIG listaValores -> ^( ASIGNACION ^( EXPRESION listaValores ) ) | ASIG '&' IDENT -> ^( ASIGNACION_REF ^( EXPRESION IDENT ) ) )
            int alt15=4;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==ASIG) ) {
                switch ( input.LA(2) ) {
                case PROD:
                    {
                    alt15=2;
                    }
                    break;
                case AMPERSAND:
                    {
                    alt15=4;
                    }
                    break;
                case LCURL:
                    {
                    alt15=3;
                    }
                    break;
                case LPAR:
                case IDENT:
                case MENOS:
                case NOT:
                case INT:
                case FLOAT:
                case STRING:
                case CHAR:
                case MASMAS:
                case MENOSMENOS:
                case FUNCLEER:
                case FUNCIMPRIMIR:
                case FUNC_POW:
                case FUNC_SQRT:
                case FUNC_GETS:
                case FUNC_STRLEN:
                    {
                    alt15=1;
                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 15, 1, input);

                    throw nvae;
                }

            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:279:3: ASIG expr
                    {
                    ASIG83=(Token)match(input,ASIG,FOLLOW_ASIG_in_asignacion1151); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ASIG.add(ASIG83);

                    pushFollow(FOLLOW_expr_in_asignacion1153);
                    expr84=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expr.add(expr84.getTree());


                    // AST REWRITE
                    // elements: expr
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 279:13: -> ^( ASIGNACION ^( EXPRESION expr ) )
                    {
                        // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:279:16: ^( ASIGNACION ^( EXPRESION expr ) )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(ASIGNACION, "ASIGNACION"), root_1);

                        // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:279:30: ^( EXPRESION expr )
                        {
                        CommonTree root_2 = (CommonTree)adaptor.nil();
                        root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(EXPRESION, "EXPRESION"), root_2);

                        adaptor.addChild(root_2, stream_expr.nextTree());

                        adaptor.addChild(root_1, root_2);
                        }

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:280:4: ASIG '*' expr
                    {
                    ASIG85=(Token)match(input,ASIG,FOLLOW_ASIG_in_asignacion1171); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ASIG.add(ASIG85);

                    char_literal86=(Token)match(input,PROD,FOLLOW_PROD_in_asignacion1173); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_PROD.add(char_literal86);

                    pushFollow(FOLLOW_expr_in_asignacion1175);
                    expr87=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expr.add(expr87.getTree());


                    // AST REWRITE
                    // elements: expr
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 280:18: -> ^( ASIGNACION ^( EXPRESION expr ) )
                    {
                        // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:280:21: ^( ASIGNACION ^( EXPRESION expr ) )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(ASIGNACION, "ASIGNACION"), root_1);

                        // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:280:34: ^( EXPRESION expr )
                        {
                        CommonTree root_2 = (CommonTree)adaptor.nil();
                        root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(EXPRESION, "EXPRESION"), root_2);

                        adaptor.addChild(root_2, stream_expr.nextTree());

                        adaptor.addChild(root_1, root_2);
                        }

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 3 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:281:4: ASIG listaValores
                    {
                    ASIG88=(Token)match(input,ASIG,FOLLOW_ASIG_in_asignacion1193); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ASIG.add(ASIG88);

                    pushFollow(FOLLOW_listaValores_in_asignacion1195);
                    listaValores89=listaValores();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_listaValores.add(listaValores89.getTree());


                    // AST REWRITE
                    // elements: listaValores
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 281:22: -> ^( ASIGNACION ^( EXPRESION listaValores ) )
                    {
                        // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:281:25: ^( ASIGNACION ^( EXPRESION listaValores ) )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(ASIGNACION, "ASIGNACION"), root_1);

                        // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:281:38: ^( EXPRESION listaValores )
                        {
                        CommonTree root_2 = (CommonTree)adaptor.nil();
                        root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(EXPRESION, "EXPRESION"), root_2);

                        adaptor.addChild(root_2, stream_listaValores.nextTree());

                        adaptor.addChild(root_1, root_2);
                        }

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 4 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:282:4: ASIG '&' IDENT
                    {
                    ASIG90=(Token)match(input,ASIG,FOLLOW_ASIG_in_asignacion1214); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ASIG.add(ASIG90);

                    char_literal91=(Token)match(input,AMPERSAND,FOLLOW_AMPERSAND_in_asignacion1216); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_AMPERSAND.add(char_literal91);

                    IDENT92=(Token)match(input,IDENT,FOLLOW_IDENT_in_asignacion1218); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_IDENT.add(IDENT92);



                    // AST REWRITE
                    // elements: IDENT
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 282:19: -> ^( ASIGNACION_REF ^( EXPRESION IDENT ) )
                    {
                        // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:282:22: ^( ASIGNACION_REF ^( EXPRESION IDENT ) )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(ASIGNACION_REF, "ASIGNACION_REF"), root_1);

                        // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:282:39: ^( EXPRESION IDENT )
                        {
                        CommonTree root_2 = (CommonTree)adaptor.nil();
                        root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(EXPRESION, "EXPRESION"), root_2);

                        adaptor.addChild(root_2, stream_IDENT.nextNode());

                        adaptor.addChild(root_1, root_2);
                        }

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "asignacion"

    public static class declaracion_variable_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "declaracion_variable"
    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:286:1: declaracion_variable : ( IDENT LCOR expr RCOR -> ^( DECL_VAR_ARR ^( NOMBRE_VAR IDENT ) ^( LONGITUD expr ) ) | IDENT -> ^( DECL_VAR ^( NOMBRE_VAR IDENT ) ) | '*' IDENT -> ^( DECL_VAR_REF ^( NOMBRE_VAR IDENT ) ) );
    public final CParser.declaracion_variable_return declaracion_variable() throws RecognitionException {
        CParser.declaracion_variable_return retval = new CParser.declaracion_variable_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token IDENT93=null;
        Token LCOR94=null;
        Token RCOR96=null;
        Token IDENT97=null;
        Token char_literal98=null;
        Token IDENT99=null;
        CParser.expr_return expr95 = null;


        CommonTree IDENT93_tree=null;
        CommonTree LCOR94_tree=null;
        CommonTree RCOR96_tree=null;
        CommonTree IDENT97_tree=null;
        CommonTree char_literal98_tree=null;
        CommonTree IDENT99_tree=null;
        RewriteRuleTokenStream stream_IDENT=new RewriteRuleTokenStream(adaptor,"token IDENT");
        RewriteRuleTokenStream stream_RCOR=new RewriteRuleTokenStream(adaptor,"token RCOR");
        RewriteRuleTokenStream stream_LCOR=new RewriteRuleTokenStream(adaptor,"token LCOR");
        RewriteRuleTokenStream stream_PROD=new RewriteRuleTokenStream(adaptor,"token PROD");
        RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
        try {
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:287:2: ( IDENT LCOR expr RCOR -> ^( DECL_VAR_ARR ^( NOMBRE_VAR IDENT ) ^( LONGITUD expr ) ) | IDENT -> ^( DECL_VAR ^( NOMBRE_VAR IDENT ) ) | '*' IDENT -> ^( DECL_VAR_REF ^( NOMBRE_VAR IDENT ) ) )
            int alt16=3;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==IDENT) ) {
                int LA16_1 = input.LA(2);

                if ( (LA16_1==LCOR) ) {
                    alt16=1;
                }
                else if ( (LA16_1==PUNTOYCOMA||LA16_1==COMA||LA16_1==ASIG) ) {
                    alt16=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 16, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA16_0==PROD) ) {
                alt16=3;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }
            switch (alt16) {
                case 1 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:288:3: IDENT LCOR expr RCOR
                    {
                    IDENT93=(Token)match(input,IDENT,FOLLOW_IDENT_in_declaracion_variable1244); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_IDENT.add(IDENT93);

                    LCOR94=(Token)match(input,LCOR,FOLLOW_LCOR_in_declaracion_variable1246); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_LCOR.add(LCOR94);

                    pushFollow(FOLLOW_expr_in_declaracion_variable1248);
                    expr95=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expr.add(expr95.getTree());
                    RCOR96=(Token)match(input,RCOR,FOLLOW_RCOR_in_declaracion_variable1250); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_RCOR.add(RCOR96);



                    // AST REWRITE
                    // elements: expr, IDENT
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 288:24: -> ^( DECL_VAR_ARR ^( NOMBRE_VAR IDENT ) ^( LONGITUD expr ) )
                    {
                        // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:288:28: ^( DECL_VAR_ARR ^( NOMBRE_VAR IDENT ) ^( LONGITUD expr ) )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(DECL_VAR_ARR, "DECL_VAR_ARR"), root_1);

                        // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:288:43: ^( NOMBRE_VAR IDENT )
                        {
                        CommonTree root_2 = (CommonTree)adaptor.nil();
                        root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NOMBRE_VAR, "NOMBRE_VAR"), root_2);

                        adaptor.addChild(root_2, stream_IDENT.nextNode());

                        adaptor.addChild(root_1, root_2);
                        }
                        // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:288:63: ^( LONGITUD expr )
                        {
                        CommonTree root_2 = (CommonTree)adaptor.nil();
                        root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(LONGITUD, "LONGITUD"), root_2);

                        adaptor.addChild(root_2, stream_expr.nextTree());

                        adaptor.addChild(root_1, root_2);
                        }

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:289:4: IDENT
                    {
                    IDENT97=(Token)match(input,IDENT,FOLLOW_IDENT_in_declaracion_variable1274); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_IDENT.add(IDENT97);



                    // AST REWRITE
                    // elements: IDENT
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 289:10: -> ^( DECL_VAR ^( NOMBRE_VAR IDENT ) )
                    {
                        // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:289:13: ^( DECL_VAR ^( NOMBRE_VAR IDENT ) )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(DECL_VAR, "DECL_VAR"), root_1);

                        // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:289:24: ^( NOMBRE_VAR IDENT )
                        {
                        CommonTree root_2 = (CommonTree)adaptor.nil();
                        root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NOMBRE_VAR, "NOMBRE_VAR"), root_2);

                        adaptor.addChild(root_2, stream_IDENT.nextNode());

                        adaptor.addChild(root_1, root_2);
                        }

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 3 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:290:4: '*' IDENT
                    {
                    char_literal98=(Token)match(input,PROD,FOLLOW_PROD_in_declaracion_variable1291); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_PROD.add(char_literal98);

                    IDENT99=(Token)match(input,IDENT,FOLLOW_IDENT_in_declaracion_variable1293); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_IDENT.add(IDENT99);



                    // AST REWRITE
                    // elements: IDENT
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 290:14: -> ^( DECL_VAR_REF ^( NOMBRE_VAR IDENT ) )
                    {
                        // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:290:17: ^( DECL_VAR_REF ^( NOMBRE_VAR IDENT ) )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(DECL_VAR_REF, "DECL_VAR_REF"), root_1);

                        // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:290:32: ^( NOMBRE_VAR IDENT )
                        {
                        CommonTree root_2 = (CommonTree)adaptor.nil();
                        root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NOMBRE_VAR, "NOMBRE_VAR"), root_2);

                        adaptor.addChild(root_2, stream_IDENT.nextNode());

                        adaptor.addChild(root_1, root_2);
                        }

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "declaracion_variable"

    public static class nombre_variable_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "nombre_variable"
    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:293:1: nombre_variable : ( IDENT LCOR expr RCOR -> ^( NOMBRE_VAR IDENT ) ^( INDICE expr ) | IDENT -> ^( NOMBRE_VAR IDENT ) );
    public final CParser.nombre_variable_return nombre_variable() throws RecognitionException {
        CParser.nombre_variable_return retval = new CParser.nombre_variable_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token IDENT100=null;
        Token LCOR101=null;
        Token RCOR103=null;
        Token IDENT104=null;
        CParser.expr_return expr102 = null;


        CommonTree IDENT100_tree=null;
        CommonTree LCOR101_tree=null;
        CommonTree RCOR103_tree=null;
        CommonTree IDENT104_tree=null;
        RewriteRuleTokenStream stream_IDENT=new RewriteRuleTokenStream(adaptor,"token IDENT");
        RewriteRuleTokenStream stream_RCOR=new RewriteRuleTokenStream(adaptor,"token RCOR");
        RewriteRuleTokenStream stream_LCOR=new RewriteRuleTokenStream(adaptor,"token LCOR");
        RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
        try {
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:294:2: ( IDENT LCOR expr RCOR -> ^( NOMBRE_VAR IDENT ) ^( INDICE expr ) | IDENT -> ^( NOMBRE_VAR IDENT ) )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==IDENT) ) {
                int LA17_1 = input.LA(2);

                if ( (LA17_1==LCOR) ) {
                    alt17=1;
                }
                else if ( (LA17_1==ASIG) ) {
                    alt17=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 17, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:295:3: IDENT LCOR expr RCOR
                    {
                    IDENT100=(Token)match(input,IDENT,FOLLOW_IDENT_in_nombre_variable1321); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_IDENT.add(IDENT100);

                    LCOR101=(Token)match(input,LCOR,FOLLOW_LCOR_in_nombre_variable1323); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_LCOR.add(LCOR101);

                    pushFollow(FOLLOW_expr_in_nombre_variable1325);
                    expr102=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expr.add(expr102.getTree());
                    RCOR103=(Token)match(input,RCOR,FOLLOW_RCOR_in_nombre_variable1327); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_RCOR.add(RCOR103);



                    // AST REWRITE
                    // elements: IDENT, expr
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 295:24: -> ^( NOMBRE_VAR IDENT ) ^( INDICE expr )
                    {
                        // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:295:28: ^( NOMBRE_VAR IDENT )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NOMBRE_VAR, "NOMBRE_VAR"), root_1);

                        adaptor.addChild(root_1, stream_IDENT.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }
                        // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:295:48: ^( INDICE expr )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(INDICE, "INDICE"), root_1);

                        adaptor.addChild(root_1, stream_expr.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:296:4: IDENT
                    {
                    IDENT104=(Token)match(input,IDENT,FOLLOW_IDENT_in_nombre_variable1347); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_IDENT.add(IDENT104);



                    // AST REWRITE
                    // elements: IDENT
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 296:10: -> ^( NOMBRE_VAR IDENT )
                    {
                        // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:296:13: ^( NOMBRE_VAR IDENT )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NOMBRE_VAR, "NOMBRE_VAR"), root_1);

                        adaptor.addChild(root_1, stream_IDENT.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "nombre_variable"

    public static class sentencia_asignacion_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "sentencia_asignacion"
    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:300:1: sentencia_asignacion : ( '*' nombre_variable asignacion -> ^( SENTENCIA_ASIG nombre_variable asignacion ) | nombre_variable asignacion -> ^( SENTENCIA_ASIG nombre_variable asignacion ) );
    public final CParser.sentencia_asignacion_return sentencia_asignacion() throws RecognitionException {
        CParser.sentencia_asignacion_return retval = new CParser.sentencia_asignacion_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal105=null;
        CParser.nombre_variable_return nombre_variable106 = null;

        CParser.asignacion_return asignacion107 = null;

        CParser.nombre_variable_return nombre_variable108 = null;

        CParser.asignacion_return asignacion109 = null;


        CommonTree char_literal105_tree=null;
        RewriteRuleTokenStream stream_PROD=new RewriteRuleTokenStream(adaptor,"token PROD");
        RewriteRuleSubtreeStream stream_nombre_variable=new RewriteRuleSubtreeStream(adaptor,"rule nombre_variable");
        RewriteRuleSubtreeStream stream_asignacion=new RewriteRuleSubtreeStream(adaptor,"rule asignacion");
        try {
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:301:2: ( '*' nombre_variable asignacion -> ^( SENTENCIA_ASIG nombre_variable asignacion ) | nombre_variable asignacion -> ^( SENTENCIA_ASIG nombre_variable asignacion ) )
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==PROD) ) {
                alt18=1;
            }
            else if ( (LA18_0==IDENT) ) {
                alt18=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }
            switch (alt18) {
                case 1 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:302:3: '*' nombre_variable asignacion
                    {
                    char_literal105=(Token)match(input,PROD,FOLLOW_PROD_in_sentencia_asignacion1370); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_PROD.add(char_literal105);

                    pushFollow(FOLLOW_nombre_variable_in_sentencia_asignacion1372);
                    nombre_variable106=nombre_variable();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_nombre_variable.add(nombre_variable106.getTree());
                    pushFollow(FOLLOW_asignacion_in_sentencia_asignacion1374);
                    asignacion107=asignacion();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_asignacion.add(asignacion107.getTree());


                    // AST REWRITE
                    // elements: nombre_variable, asignacion
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 303:3: -> ^( SENTENCIA_ASIG nombre_variable asignacion )
                    {
                        // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:303:7: ^( SENTENCIA_ASIG nombre_variable asignacion )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(SENTENCIA_ASIG, "SENTENCIA_ASIG"), root_1);

                        adaptor.addChild(root_1, stream_nombre_variable.nextTree());
                        adaptor.addChild(root_1, stream_asignacion.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:304:4: nombre_variable asignacion
                    {
                    pushFollow(FOLLOW_nombre_variable_in_sentencia_asignacion1394);
                    nombre_variable108=nombre_variable();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_nombre_variable.add(nombre_variable108.getTree());
                    pushFollow(FOLLOW_asignacion_in_sentencia_asignacion1396);
                    asignacion109=asignacion();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_asignacion.add(asignacion109.getTree());


                    // AST REWRITE
                    // elements: nombre_variable, asignacion
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 305:3: -> ^( SENTENCIA_ASIG nombre_variable asignacion )
                    {
                        // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:305:7: ^( SENTENCIA_ASIG nombre_variable asignacion )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(SENTENCIA_ASIG, "SENTENCIA_ASIG"), root_1);

                        adaptor.addChild(root_1, stream_nombre_variable.nextTree());
                        adaptor.addChild(root_1, stream_asignacion.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "sentencia_asignacion"

    public static class llamada_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "llamada"
    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:309:1: llamada : ( IDENT LPAR listaExpr RPAR -> ^( LLAMADA ^( NOMBRE_FUNC IDENT ) ^( PARAM_ACTUAL listaExpr ) ) | IDENT LPAR RPAR -> ^( LLAMADA ^( NOMBRE_FUNC IDENT ) ) );
    public final CParser.llamada_return llamada() throws RecognitionException {
        CParser.llamada_return retval = new CParser.llamada_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token IDENT110=null;
        Token LPAR111=null;
        Token RPAR113=null;
        Token IDENT114=null;
        Token LPAR115=null;
        Token RPAR116=null;
        CParser.listaExpr_return listaExpr112 = null;


        CommonTree IDENT110_tree=null;
        CommonTree LPAR111_tree=null;
        CommonTree RPAR113_tree=null;
        CommonTree IDENT114_tree=null;
        CommonTree LPAR115_tree=null;
        CommonTree RPAR116_tree=null;
        RewriteRuleTokenStream stream_IDENT=new RewriteRuleTokenStream(adaptor,"token IDENT");
        RewriteRuleTokenStream stream_RPAR=new RewriteRuleTokenStream(adaptor,"token RPAR");
        RewriteRuleTokenStream stream_LPAR=new RewriteRuleTokenStream(adaptor,"token LPAR");
        RewriteRuleSubtreeStream stream_listaExpr=new RewriteRuleSubtreeStream(adaptor,"rule listaExpr");
        try {
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:310:2: ( IDENT LPAR listaExpr RPAR -> ^( LLAMADA ^( NOMBRE_FUNC IDENT ) ^( PARAM_ACTUAL listaExpr ) ) | IDENT LPAR RPAR -> ^( LLAMADA ^( NOMBRE_FUNC IDENT ) ) )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==IDENT) ) {
                int LA19_1 = input.LA(2);

                if ( (LA19_1==LPAR) ) {
                    int LA19_2 = input.LA(3);

                    if ( (LA19_2==RPAR) ) {
                        alt19=2;
                    }
                    else if ( (LA19_2==LPAR||(LA19_2>=COMA && LA19_2<=IDENT)||LA19_2==MENOS||(LA19_2>=NOT && LA19_2<=FUNCLEER)||(LA19_2>=FUNCIMPRIMIR && LA19_2<=FUNC_STRLEN)) ) {
                        alt19=1;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 19, 2, input);

                        throw nvae;
                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 19, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:311:3: IDENT LPAR listaExpr RPAR
                    {
                    IDENT110=(Token)match(input,IDENT,FOLLOW_IDENT_in_llamada1424); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_IDENT.add(IDENT110);

                    LPAR111=(Token)match(input,LPAR,FOLLOW_LPAR_in_llamada1426); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_LPAR.add(LPAR111);

                    pushFollow(FOLLOW_listaExpr_in_llamada1428);
                    listaExpr112=listaExpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_listaExpr.add(listaExpr112.getTree());
                    RPAR113=(Token)match(input,RPAR,FOLLOW_RPAR_in_llamada1430); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_RPAR.add(RPAR113);



                    // AST REWRITE
                    // elements: IDENT, listaExpr
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 311:29: -> ^( LLAMADA ^( NOMBRE_FUNC IDENT ) ^( PARAM_ACTUAL listaExpr ) )
                    {
                        // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:311:32: ^( LLAMADA ^( NOMBRE_FUNC IDENT ) ^( PARAM_ACTUAL listaExpr ) )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(LLAMADA, "LLAMADA"), root_1);

                        // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:311:42: ^( NOMBRE_FUNC IDENT )
                        {
                        CommonTree root_2 = (CommonTree)adaptor.nil();
                        root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NOMBRE_FUNC, "NOMBRE_FUNC"), root_2);

                        adaptor.addChild(root_2, stream_IDENT.nextNode());

                        adaptor.addChild(root_1, root_2);
                        }
                        // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:311:63: ^( PARAM_ACTUAL listaExpr )
                        {
                        CommonTree root_2 = (CommonTree)adaptor.nil();
                        root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(PARAM_ACTUAL, "PARAM_ACTUAL"), root_2);

                        adaptor.addChild(root_2, stream_listaExpr.nextTree());

                        adaptor.addChild(root_1, root_2);
                        }

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:312:4: IDENT LPAR RPAR
                    {
                    IDENT114=(Token)match(input,IDENT,FOLLOW_IDENT_in_llamada1454); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_IDENT.add(IDENT114);

                    LPAR115=(Token)match(input,LPAR,FOLLOW_LPAR_in_llamada1456); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_LPAR.add(LPAR115);

                    RPAR116=(Token)match(input,RPAR,FOLLOW_RPAR_in_llamada1458); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_RPAR.add(RPAR116);



                    // AST REWRITE
                    // elements: IDENT
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 312:20: -> ^( LLAMADA ^( NOMBRE_FUNC IDENT ) )
                    {
                        // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:312:23: ^( LLAMADA ^( NOMBRE_FUNC IDENT ) )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(LLAMADA, "LLAMADA"), root_1);

                        // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:312:33: ^( NOMBRE_FUNC IDENT )
                        {
                        CommonTree root_2 = (CommonTree)adaptor.nil();
                        root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NOMBRE_FUNC, "NOMBRE_FUNC"), root_2);

                        adaptor.addChild(root_2, stream_IDENT.nextNode());

                        adaptor.addChild(root_1, root_2);
                        }

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "llamada"

    public static class expr_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "expr"
    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:320:1: expr options {backtrack=true; } : orExpr ;
    public final CParser.expr_return expr() throws RecognitionException {
        CParser.expr_return retval = new CParser.expr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CParser.orExpr_return orExpr117 = null;



        try {
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:324:2: ( orExpr )
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:325:3: orExpr
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_orExpr_in_expr1502);
            orExpr117=orExpr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, orExpr117.getTree());

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "expr"

    public static class listaValores_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "listaValores"
    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:329:1: listaValores : LCURL listaExpr RCURL ;
    public final CParser.listaValores_return listaValores() throws RecognitionException {
        CParser.listaValores_return retval = new CParser.listaValores_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token LCURL118=null;
        Token RCURL120=null;
        CParser.listaExpr_return listaExpr119 = null;


        CommonTree LCURL118_tree=null;
        CommonTree RCURL120_tree=null;

        try {
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:330:2: ( LCURL listaExpr RCURL )
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:330:4: LCURL listaExpr RCURL
            {
            root_0 = (CommonTree)adaptor.nil();

            LCURL118=(Token)match(input,LCURL,FOLLOW_LCURL_in_listaValores1515); if (state.failed) return retval;
            pushFollow(FOLLOW_listaExpr_in_listaValores1518);
            listaExpr119=listaExpr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, listaExpr119.getTree());
            RCURL120=(Token)match(input,RCURL,FOLLOW_RCURL_in_listaValores1520); if (state.failed) return retval;

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "listaValores"

    public static class listaExpr_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "listaExpr"
    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:333:1: listaExpr : ( COMA )? expr ( COMA expr )* ;
    public final CParser.listaExpr_return listaExpr() throws RecognitionException {
        CParser.listaExpr_return retval = new CParser.listaExpr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token COMA121=null;
        Token COMA123=null;
        CParser.expr_return expr122 = null;

        CParser.expr_return expr124 = null;


        CommonTree COMA121_tree=null;
        CommonTree COMA123_tree=null;

        try {
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:334:2: ( ( COMA )? expr ( COMA expr )* )
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:334:4: ( COMA )? expr ( COMA expr )*
            {
            root_0 = (CommonTree)adaptor.nil();

            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:334:8: ( COMA )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==COMA) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:334:8: COMA
                    {
                    COMA121=(Token)match(input,COMA,FOLLOW_COMA_in_listaExpr1532); if (state.failed) return retval;

                    }
                    break;

            }

            pushFollow(FOLLOW_expr_in_listaExpr1536);
            expr122=expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, expr122.getTree());
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:334:16: ( COMA expr )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==COMA) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:334:17: COMA expr
            	    {
            	    COMA123=(Token)match(input,COMA,FOLLOW_COMA_in_listaExpr1539); if (state.failed) return retval;
            	    pushFollow(FOLLOW_expr_in_listaExpr1542);
            	    expr124=expr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, expr124.getTree());

            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "listaExpr"

    public static class orExpr_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "orExpr"
    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:338:1: orExpr : andExpr ( OR andExpr )* ;
    public final CParser.orExpr_return orExpr() throws RecognitionException {
        CParser.orExpr_return retval = new CParser.orExpr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token OR126=null;
        CParser.andExpr_return andExpr125 = null;

        CParser.andExpr_return andExpr127 = null;


        CommonTree OR126_tree=null;

        try {
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:338:8: ( andExpr ( OR andExpr )* )
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:338:10: andExpr ( OR andExpr )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_andExpr_in_orExpr1559);
            andExpr125=andExpr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, andExpr125.getTree());
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:338:18: ( OR andExpr )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==OR) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:338:19: OR andExpr
            	    {
            	    OR126=(Token)match(input,OR,FOLLOW_OR_in_orExpr1562); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    OR126_tree = (CommonTree)adaptor.create(OR126);
            	    root_0 = (CommonTree)adaptor.becomeRoot(OR126_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_andExpr_in_orExpr1565);
            	    andExpr127=andExpr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, andExpr127.getTree());

            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "orExpr"

    public static class andExpr_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "andExpr"
    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:341:1: andExpr : eqExpr ( AND eqExpr )* ;
    public final CParser.andExpr_return andExpr() throws RecognitionException {
        CParser.andExpr_return retval = new CParser.andExpr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token AND129=null;
        CParser.eqExpr_return eqExpr128 = null;

        CParser.eqExpr_return eqExpr130 = null;


        CommonTree AND129_tree=null;

        try {
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:341:9: ( eqExpr ( AND eqExpr )* )
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:341:11: eqExpr ( AND eqExpr )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_eqExpr_in_andExpr1577);
            eqExpr128=eqExpr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, eqExpr128.getTree());
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:341:18: ( AND eqExpr )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==AND) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:341:19: AND eqExpr
            	    {
            	    AND129=(Token)match(input,AND,FOLLOW_AND_in_andExpr1580); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    AND129_tree = (CommonTree)adaptor.create(AND129);
            	    root_0 = (CommonTree)adaptor.becomeRoot(AND129_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_eqExpr_in_andExpr1583);
            	    eqExpr130=eqExpr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, eqExpr130.getTree());

            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "andExpr"

    public static class eqExpr_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "eqExpr"
    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:344:1: eqExpr : compExpr ( ( IGUAL | DISTINTO ) compExpr )* ;
    public final CParser.eqExpr_return eqExpr() throws RecognitionException {
        CParser.eqExpr_return retval = new CParser.eqExpr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set132=null;
        CParser.compExpr_return compExpr131 = null;

        CParser.compExpr_return compExpr133 = null;


        CommonTree set132_tree=null;

        try {
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:344:8: ( compExpr ( ( IGUAL | DISTINTO ) compExpr )* )
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:344:10: compExpr ( ( IGUAL | DISTINTO ) compExpr )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_compExpr_in_eqExpr1596);
            compExpr131=compExpr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, compExpr131.getTree());
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:344:19: ( ( IGUAL | DISTINTO ) compExpr )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( ((LA24_0>=IGUAL && LA24_0<=DISTINTO)) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:344:20: ( IGUAL | DISTINTO ) compExpr
            	    {
            	    set132=(Token)input.LT(1);
            	    set132=(Token)input.LT(1);
            	    if ( (input.LA(1)>=IGUAL && input.LA(1)<=DISTINTO) ) {
            	        input.consume();
            	        if ( state.backtracking==0 ) root_0 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(set132), root_0);
            	        state.errorRecovery=false;state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }

            	    pushFollow(FOLLOW_compExpr_in_eqExpr1606);
            	    compExpr133=compExpr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, compExpr133.getTree());

            	    }
            	    break;

            	default :
            	    break loop24;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "eqExpr"

    public static class compExpr_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "compExpr"
    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:347:1: compExpr : sumExpr ( ( MAYOR | MENOR | MENORIGUAL | MAYORIGUAL ) sumExpr )* ;
    public final CParser.compExpr_return compExpr() throws RecognitionException {
        CParser.compExpr_return retval = new CParser.compExpr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set135=null;
        CParser.sumExpr_return sumExpr134 = null;

        CParser.sumExpr_return sumExpr136 = null;


        CommonTree set135_tree=null;

        try {
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:348:2: ( sumExpr ( ( MAYOR | MENOR | MENORIGUAL | MAYORIGUAL ) sumExpr )* )
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:348:4: sumExpr ( ( MAYOR | MENOR | MENORIGUAL | MAYORIGUAL ) sumExpr )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_sumExpr_in_compExpr1620);
            sumExpr134=sumExpr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, sumExpr134.getTree());
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:348:12: ( ( MAYOR | MENOR | MENORIGUAL | MAYORIGUAL ) sumExpr )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( ((LA25_0>=MAYOR && LA25_0<=MAYORIGUAL)) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:348:13: ( MAYOR | MENOR | MENORIGUAL | MAYORIGUAL ) sumExpr
            	    {
            	    set135=(Token)input.LT(1);
            	    set135=(Token)input.LT(1);
            	    if ( (input.LA(1)>=MAYOR && input.LA(1)<=MAYORIGUAL) ) {
            	        input.consume();
            	        if ( state.backtracking==0 ) root_0 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(set135), root_0);
            	        state.errorRecovery=false;state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }

            	    pushFollow(FOLLOW_sumExpr_in_compExpr1634);
            	    sumExpr136=sumExpr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, sumExpr136.getTree());

            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "compExpr"

    public static class sumExpr_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "sumExpr"
    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:351:1: sumExpr : multExpr ( ( MAS | MENOS ) multExpr )* ;
    public final CParser.sumExpr_return sumExpr() throws RecognitionException {
        CParser.sumExpr_return retval = new CParser.sumExpr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set138=null;
        CParser.multExpr_return multExpr137 = null;

        CParser.multExpr_return multExpr139 = null;


        CommonTree set138_tree=null;

        try {
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:351:9: ( multExpr ( ( MAS | MENOS ) multExpr )* )
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:351:11: multExpr ( ( MAS | MENOS ) multExpr )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_multExpr_in_sumExpr1646);
            multExpr137=multExpr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, multExpr137.getTree());
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:351:20: ( ( MAS | MENOS ) multExpr )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( ((LA26_0>=MAS && LA26_0<=MENOS)) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:351:21: ( MAS | MENOS ) multExpr
            	    {
            	    set138=(Token)input.LT(1);
            	    set138=(Token)input.LT(1);
            	    if ( (input.LA(1)>=MAS && input.LA(1)<=MENOS) ) {
            	        input.consume();
            	        if ( state.backtracking==0 ) root_0 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(set138), root_0);
            	        state.errorRecovery=false;state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }

            	    pushFollow(FOLLOW_multExpr_in_sumExpr1656);
            	    multExpr139=multExpr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, multExpr139.getTree());

            	    }
            	    break;

            	default :
            	    break loop26;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "sumExpr"

    public static class multExpr_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "multExpr"
    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:355:1: multExpr : notExpr ( ( PROD | DIV | MOD ) notExpr )* ;
    public final CParser.multExpr_return multExpr() throws RecognitionException {
        CParser.multExpr_return retval = new CParser.multExpr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set141=null;
        CParser.notExpr_return notExpr140 = null;

        CParser.notExpr_return notExpr142 = null;


        CommonTree set141_tree=null;

        try {
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:355:9: ( notExpr ( ( PROD | DIV | MOD ) notExpr )* )
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:355:11: notExpr ( ( PROD | DIV | MOD ) notExpr )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_notExpr_in_multExpr1668);
            notExpr140=notExpr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, notExpr140.getTree());
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:355:19: ( ( PROD | DIV | MOD ) notExpr )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==PROD) ) {
                    alt27=1;
                }
                else if ( ((LA27_0>=DIV && LA27_0<=MOD)) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:355:20: ( PROD | DIV | MOD ) notExpr
            	    {
            	    set141=(Token)input.LT(1);
            	    set141=(Token)input.LT(1);
            	    if ( (input.LA(1)>=PROD && input.LA(1)<=MOD) ) {
            	        input.consume();
            	        if ( state.backtracking==0 ) root_0 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(set141), root_0);
            	        state.errorRecovery=false;state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }

            	    pushFollow(FOLLOW_notExpr_in_multExpr1680);
            	    notExpr142=notExpr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, notExpr142.getTree());

            	    }
            	    break;

            	default :
            	    break loop27;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "multExpr"

    public static class notExpr_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "notExpr"
    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:358:1: notExpr : ( NOT negExpr -> ^( NOT negExpr ) | negExpr );
    public final CParser.notExpr_return notExpr() throws RecognitionException {
        CParser.notExpr_return retval = new CParser.notExpr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token NOT143=null;
        CParser.negExpr_return negExpr144 = null;

        CParser.negExpr_return negExpr145 = null;


        CommonTree NOT143_tree=null;
        RewriteRuleTokenStream stream_NOT=new RewriteRuleTokenStream(adaptor,"token NOT");
        RewriteRuleSubtreeStream stream_negExpr=new RewriteRuleSubtreeStream(adaptor,"rule negExpr");
        try {
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:358:9: ( NOT negExpr -> ^( NOT negExpr ) | negExpr )
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==NOT) ) {
                alt28=1;
            }
            else if ( (LA28_0==LPAR||LA28_0==IDENT||LA28_0==MENOS||(LA28_0>=INT && LA28_0<=FUNCLEER)||(LA28_0>=FUNCIMPRIMIR && LA28_0<=FUNC_STRLEN)) ) {
                alt28=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;
            }
            switch (alt28) {
                case 1 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:358:11: NOT negExpr
                    {
                    NOT143=(Token)match(input,NOT,FOLLOW_NOT_in_notExpr1692); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_NOT.add(NOT143);

                    pushFollow(FOLLOW_negExpr_in_notExpr1694);
                    negExpr144=negExpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_negExpr.add(negExpr144.getTree());


                    // AST REWRITE
                    // elements: negExpr, NOT
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 358:23: -> ^( NOT negExpr )
                    {
                        // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:358:27: ^( NOT negExpr )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(stream_NOT.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_negExpr.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:359:4: negExpr
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_negExpr_in_notExpr1708);
                    negExpr145=negExpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, negExpr145.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "notExpr"

    public static class negExpr_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "negExpr"
    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:363:1: negExpr : ( MENOS atom -> ^( NEGAR atom ) | atom );
    public final CParser.negExpr_return negExpr() throws RecognitionException {
        CParser.negExpr_return retval = new CParser.negExpr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token MENOS146=null;
        CParser.atom_return atom147 = null;

        CParser.atom_return atom148 = null;


        CommonTree MENOS146_tree=null;
        RewriteRuleTokenStream stream_MENOS=new RewriteRuleTokenStream(adaptor,"token MENOS");
        RewriteRuleSubtreeStream stream_atom=new RewriteRuleSubtreeStream(adaptor,"rule atom");
        try {
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:363:9: ( MENOS atom -> ^( NEGAR atom ) | atom )
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==MENOS) ) {
                alt29=1;
            }
            else if ( (LA29_0==LPAR||LA29_0==IDENT||(LA29_0>=INT && LA29_0<=FUNCLEER)||(LA29_0>=FUNCIMPRIMIR && LA29_0<=FUNC_STRLEN)) ) {
                alt29=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;
            }
            switch (alt29) {
                case 1 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:365:3: MENOS atom
                    {
                    MENOS146=(Token)match(input,MENOS,FOLLOW_MENOS_in_negExpr1724); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_MENOS.add(MENOS146);

                    pushFollow(FOLLOW_atom_in_negExpr1726);
                    atom147=atom();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_atom.add(atom147.getTree());


                    // AST REWRITE
                    // elements: atom
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 365:14: -> ^( NEGAR atom )
                    {
                        // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:365:18: ^( NEGAR atom )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NEGAR, "NEGAR"), root_1);

                        adaptor.addChild(root_1, stream_atom.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:366:4: atom
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_atom_in_negExpr1740);
                    atom148=atom();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, atom148.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "negExpr"

    public static class atom_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "atom"
    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:370:1: atom : ( LPAR expr RPAR | LPAR tipo_base RPAR expr -> expr | prim | INT | FLOAT | STRING | CHAR | IDENT LCOR expr RCOR | IDENT | funcion_predefinida | llamada );
    public final CParser.atom_return atom() throws RecognitionException {
        CParser.atom_return retval = new CParser.atom_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token LPAR149=null;
        Token RPAR151=null;
        Token LPAR152=null;
        Token RPAR154=null;
        Token INT157=null;
        Token FLOAT158=null;
        Token STRING159=null;
        Token CHAR160=null;
        Token IDENT161=null;
        Token LCOR162=null;
        Token RCOR164=null;
        Token IDENT165=null;
        CParser.expr_return expr150 = null;

        CParser.tipo_base_return tipo_base153 = null;

        CParser.expr_return expr155 = null;

        CParser.prim_return prim156 = null;

        CParser.expr_return expr163 = null;

        CParser.funcion_predefinida_return funcion_predefinida166 = null;

        CParser.llamada_return llamada167 = null;


        CommonTree LPAR149_tree=null;
        CommonTree RPAR151_tree=null;
        CommonTree LPAR152_tree=null;
        CommonTree RPAR154_tree=null;
        CommonTree INT157_tree=null;
        CommonTree FLOAT158_tree=null;
        CommonTree STRING159_tree=null;
        CommonTree CHAR160_tree=null;
        CommonTree IDENT161_tree=null;
        CommonTree LCOR162_tree=null;
        CommonTree RCOR164_tree=null;
        CommonTree IDENT165_tree=null;
        RewriteRuleTokenStream stream_RPAR=new RewriteRuleTokenStream(adaptor,"token RPAR");
        RewriteRuleTokenStream stream_LPAR=new RewriteRuleTokenStream(adaptor,"token LPAR");
        RewriteRuleSubtreeStream stream_tipo_base=new RewriteRuleSubtreeStream(adaptor,"rule tipo_base");
        RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
        try {
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:371:2: ( LPAR expr RPAR | LPAR tipo_base RPAR expr -> expr | prim | INT | FLOAT | STRING | CHAR | IDENT LCOR expr RCOR | IDENT | funcion_predefinida | llamada )
            int alt30=11;
            alt30 = dfa30.predict(input);
            switch (alt30) {
                case 1 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:373:3: LPAR expr RPAR
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    LPAR149=(Token)match(input,LPAR,FOLLOW_LPAR_in_atom1763); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LPAR149_tree = (CommonTree)adaptor.create(LPAR149);
                    adaptor.addChild(root_0, LPAR149_tree);
                    }
                    pushFollow(FOLLOW_expr_in_atom1765);
                    expr150=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expr150.getTree());
                    RPAR151=(Token)match(input,RPAR,FOLLOW_RPAR_in_atom1767); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    RPAR151_tree = (CommonTree)adaptor.create(RPAR151);
                    adaptor.addChild(root_0, RPAR151_tree);
                    }

                    }
                    break;
                case 2 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:374:4: LPAR tipo_base RPAR expr
                    {
                    LPAR152=(Token)match(input,LPAR,FOLLOW_LPAR_in_atom1772); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_LPAR.add(LPAR152);

                    pushFollow(FOLLOW_tipo_base_in_atom1774);
                    tipo_base153=tipo_base();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_tipo_base.add(tipo_base153.getTree());
                    RPAR154=(Token)match(input,RPAR,FOLLOW_RPAR_in_atom1776); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_RPAR.add(RPAR154);

                    pushFollow(FOLLOW_expr_in_atom1778);
                    expr155=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expr.add(expr155.getTree());


                    // AST REWRITE
                    // elements: expr
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 374:29: -> expr
                    {
                        adaptor.addChild(root_0, stream_expr.nextTree());

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 3 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:375:4: prim
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_prim_in_atom1788);
                    prim156=prim();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, prim156.getTree());

                    }
                    break;
                case 4 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:376:4: INT
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    INT157=(Token)match(input,INT,FOLLOW_INT_in_atom1793); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INT157_tree = (CommonTree)adaptor.create(INT157);
                    adaptor.addChild(root_0, INT157_tree);
                    }

                    }
                    break;
                case 5 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:377:4: FLOAT
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    FLOAT158=(Token)match(input,FLOAT,FOLLOW_FLOAT_in_atom1798); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FLOAT158_tree = (CommonTree)adaptor.create(FLOAT158);
                    adaptor.addChild(root_0, FLOAT158_tree);
                    }

                    }
                    break;
                case 6 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:378:4: STRING
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    STRING159=(Token)match(input,STRING,FOLLOW_STRING_in_atom1803); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STRING159_tree = (CommonTree)adaptor.create(STRING159);
                    adaptor.addChild(root_0, STRING159_tree);
                    }

                    }
                    break;
                case 7 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:379:4: CHAR
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    CHAR160=(Token)match(input,CHAR,FOLLOW_CHAR_in_atom1808); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CHAR160_tree = (CommonTree)adaptor.create(CHAR160);
                    adaptor.addChild(root_0, CHAR160_tree);
                    }

                    }
                    break;
                case 8 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:380:4: IDENT LCOR expr RCOR
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    IDENT161=(Token)match(input,IDENT,FOLLOW_IDENT_in_atom1813); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENT161_tree = (CommonTree)adaptor.create(IDENT161);
                    adaptor.addChild(root_0, IDENT161_tree);
                    }
                    LCOR162=(Token)match(input,LCOR,FOLLOW_LCOR_in_atom1815); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LCOR162_tree = (CommonTree)adaptor.create(LCOR162);
                    adaptor.addChild(root_0, LCOR162_tree);
                    }
                    pushFollow(FOLLOW_expr_in_atom1817);
                    expr163=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expr163.getTree());
                    RCOR164=(Token)match(input,RCOR,FOLLOW_RCOR_in_atom1819); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    RCOR164_tree = (CommonTree)adaptor.create(RCOR164);
                    adaptor.addChild(root_0, RCOR164_tree);
                    }

                    }
                    break;
                case 9 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:381:4: IDENT
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    IDENT165=(Token)match(input,IDENT,FOLLOW_IDENT_in_atom1825); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENT165_tree = (CommonTree)adaptor.create(IDENT165);
                    adaptor.addChild(root_0, IDENT165_tree);
                    }

                    }
                    break;
                case 10 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:382:4: funcion_predefinida
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_funcion_predefinida_in_atom1830);
                    funcion_predefinida166=funcion_predefinida();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, funcion_predefinida166.getTree());

                    }
                    break;
                case 11 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:383:4: llamada
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_llamada_in_atom1835);
                    llamada167=llamada();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, llamada167.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "atom"

    public static class prim_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "prim"
    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:388:1: prim : ( IDENT MASMAS -> ^( POSTFIJO ^( NOMBRE_VAR IDENT ) ^( INT ) ) | IDENT MENOSMENOS -> ^( POSTFIJO ^( NOMBRE_VAR IDENT ) ^( INT ) ) | MASMAS IDENT -> ^( PREFIJO ^( NOMBRE_VAR IDENT ) ^( INT ) ) | MENOSMENOS IDENT -> ^( PREFIJO ^( NOMBRE_VAR IDENT ) ^( INT ) ) );
    public final CParser.prim_return prim() throws RecognitionException {
        CParser.prim_return retval = new CParser.prim_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token IDENT168=null;
        Token MASMAS169=null;
        Token IDENT170=null;
        Token MENOSMENOS171=null;
        Token MASMAS172=null;
        Token IDENT173=null;
        Token MENOSMENOS174=null;
        Token IDENT175=null;

        CommonTree IDENT168_tree=null;
        CommonTree MASMAS169_tree=null;
        CommonTree IDENT170_tree=null;
        CommonTree MENOSMENOS171_tree=null;
        CommonTree MASMAS172_tree=null;
        CommonTree IDENT173_tree=null;
        CommonTree MENOSMENOS174_tree=null;
        CommonTree IDENT175_tree=null;
        RewriteRuleTokenStream stream_IDENT=new RewriteRuleTokenStream(adaptor,"token IDENT");
        RewriteRuleTokenStream stream_MASMAS=new RewriteRuleTokenStream(adaptor,"token MASMAS");
        RewriteRuleTokenStream stream_MENOSMENOS=new RewriteRuleTokenStream(adaptor,"token MENOSMENOS");

        try {
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:388:6: ( IDENT MASMAS -> ^( POSTFIJO ^( NOMBRE_VAR IDENT ) ^( INT ) ) | IDENT MENOSMENOS -> ^( POSTFIJO ^( NOMBRE_VAR IDENT ) ^( INT ) ) | MASMAS IDENT -> ^( PREFIJO ^( NOMBRE_VAR IDENT ) ^( INT ) ) | MENOSMENOS IDENT -> ^( PREFIJO ^( NOMBRE_VAR IDENT ) ^( INT ) ) )
            int alt31=4;
            switch ( input.LA(1) ) {
            case IDENT:
                {
                int LA31_1 = input.LA(2);

                if ( (LA31_1==MASMAS) ) {
                    alt31=1;
                }
                else if ( (LA31_1==MENOSMENOS) ) {
                    alt31=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 31, 1, input);

                    throw nvae;
                }
                }
                break;
            case MASMAS:
                {
                alt31=3;
                }
                break;
            case MENOSMENOS:
                {
                alt31=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 31, 0, input);

                throw nvae;
            }

            switch (alt31) {
                case 1 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:389:3: IDENT MASMAS
                    {
                    IDENT168=(Token)match(input,IDENT,FOLLOW_IDENT_in_prim1852); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_IDENT.add(IDENT168);

                    MASMAS169=(Token)match(input,MASMAS,FOLLOW_MASMAS_in_prim1854); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_MASMAS.add(MASMAS169);



                    // AST REWRITE
                    // elements: IDENT
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 389:16: -> ^( POSTFIJO ^( NOMBRE_VAR IDENT ) ^( INT ) )
                    {
                        // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:389:19: ^( POSTFIJO ^( NOMBRE_VAR IDENT ) ^( INT ) )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(POSTFIJO, "POSTFIJO"), root_1);

                        // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:389:30: ^( NOMBRE_VAR IDENT )
                        {
                        CommonTree root_2 = (CommonTree)adaptor.nil();
                        root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NOMBRE_VAR, "NOMBRE_VAR"), root_2);

                        adaptor.addChild(root_2, stream_IDENT.nextNode());

                        adaptor.addChild(root_1, root_2);
                        }
                        // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:389:50: ^( INT )
                        {
                        CommonTree root_2 = (CommonTree)adaptor.nil();
                        root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(INT, "INT"), root_2);

                        adaptor.addChild(root_2,  adaptor.create(INT,"1"));

                        adaptor.addChild(root_1, root_2);
                        }

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:390:4: IDENT MENOSMENOS
                    {
                    IDENT170=(Token)match(input,IDENT,FOLLOW_IDENT_in_prim1878); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_IDENT.add(IDENT170);

                    MENOSMENOS171=(Token)match(input,MENOSMENOS,FOLLOW_MENOSMENOS_in_prim1880); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_MENOSMENOS.add(MENOSMENOS171);



                    // AST REWRITE
                    // elements: IDENT
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 390:21: -> ^( POSTFIJO ^( NOMBRE_VAR IDENT ) ^( INT ) )
                    {
                        // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:390:24: ^( POSTFIJO ^( NOMBRE_VAR IDENT ) ^( INT ) )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(POSTFIJO, "POSTFIJO"), root_1);

                        // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:390:35: ^( NOMBRE_VAR IDENT )
                        {
                        CommonTree root_2 = (CommonTree)adaptor.nil();
                        root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NOMBRE_VAR, "NOMBRE_VAR"), root_2);

                        adaptor.addChild(root_2, stream_IDENT.nextNode());

                        adaptor.addChild(root_1, root_2);
                        }
                        // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:390:55: ^( INT )
                        {
                        CommonTree root_2 = (CommonTree)adaptor.nil();
                        root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(INT, "INT"), root_2);

                        adaptor.addChild(root_2,  adaptor.create(INT,"-1"));

                        adaptor.addChild(root_1, root_2);
                        }

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 3 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:391:4: MASMAS IDENT
                    {
                    MASMAS172=(Token)match(input,MASMAS,FOLLOW_MASMAS_in_prim1904); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_MASMAS.add(MASMAS172);

                    IDENT173=(Token)match(input,IDENT,FOLLOW_IDENT_in_prim1906); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_IDENT.add(IDENT173);



                    // AST REWRITE
                    // elements: IDENT
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 391:17: -> ^( PREFIJO ^( NOMBRE_VAR IDENT ) ^( INT ) )
                    {
                        // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:391:20: ^( PREFIJO ^( NOMBRE_VAR IDENT ) ^( INT ) )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(PREFIJO, "PREFIJO"), root_1);

                        // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:391:30: ^( NOMBRE_VAR IDENT )
                        {
                        CommonTree root_2 = (CommonTree)adaptor.nil();
                        root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NOMBRE_VAR, "NOMBRE_VAR"), root_2);

                        adaptor.addChild(root_2, stream_IDENT.nextNode());

                        adaptor.addChild(root_1, root_2);
                        }
                        // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:391:50: ^( INT )
                        {
                        CommonTree root_2 = (CommonTree)adaptor.nil();
                        root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(INT, "INT"), root_2);

                        adaptor.addChild(root_2,  adaptor.create(INT,"1"));

                        adaptor.addChild(root_1, root_2);
                        }

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 4 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:392:4: MENOSMENOS IDENT
                    {
                    MENOSMENOS174=(Token)match(input,MENOSMENOS,FOLLOW_MENOSMENOS_in_prim1930); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_MENOSMENOS.add(MENOSMENOS174);

                    IDENT175=(Token)match(input,IDENT,FOLLOW_IDENT_in_prim1932); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_IDENT.add(IDENT175);



                    // AST REWRITE
                    // elements: IDENT
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 392:21: -> ^( PREFIJO ^( NOMBRE_VAR IDENT ) ^( INT ) )
                    {
                        // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:392:24: ^( PREFIJO ^( NOMBRE_VAR IDENT ) ^( INT ) )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(PREFIJO, "PREFIJO"), root_1);

                        // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:392:34: ^( NOMBRE_VAR IDENT )
                        {
                        CommonTree root_2 = (CommonTree)adaptor.nil();
                        root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NOMBRE_VAR, "NOMBRE_VAR"), root_2);

                        adaptor.addChild(root_2, stream_IDENT.nextNode());

                        adaptor.addChild(root_1, root_2);
                        }
                        // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:392:54: ^( INT )
                        {
                        CommonTree root_2 = (CommonTree)adaptor.nil();
                        root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(INT, "INT"), root_2);

                        adaptor.addChild(root_2,  adaptor.create(INT,"-1"));

                        adaptor.addChild(root_1, root_2);
                        }

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "prim"

    public static class leer_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "leer"
    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:398:1: leer : ( FUNCLEER LPAR STRING COMA AMPERSAND IDENT RPAR PUNTOYCOMA -> ^( F_LEER ^( FORMATO STRING ) ^( NOMBRE_VAR IDENT ) ) | FUNCLEER LPAR STRING COMA AMPERSAND IDENT LCOR expr RCOR RPAR PUNTOYCOMA -> ^( F_LEER ^( FORMATO STRING ) ^( NOMBRE_VAR IDENT ) ^( INDICE expr ) ) );
    public final CParser.leer_return leer() throws RecognitionException {
        CParser.leer_return retval = new CParser.leer_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token FUNCLEER176=null;
        Token LPAR177=null;
        Token STRING178=null;
        Token COMA179=null;
        Token AMPERSAND180=null;
        Token IDENT181=null;
        Token RPAR182=null;
        Token PUNTOYCOMA183=null;
        Token FUNCLEER184=null;
        Token LPAR185=null;
        Token STRING186=null;
        Token COMA187=null;
        Token AMPERSAND188=null;
        Token IDENT189=null;
        Token LCOR190=null;
        Token RCOR192=null;
        Token RPAR193=null;
        Token PUNTOYCOMA194=null;
        CParser.expr_return expr191 = null;


        CommonTree FUNCLEER176_tree=null;
        CommonTree LPAR177_tree=null;
        CommonTree STRING178_tree=null;
        CommonTree COMA179_tree=null;
        CommonTree AMPERSAND180_tree=null;
        CommonTree IDENT181_tree=null;
        CommonTree RPAR182_tree=null;
        CommonTree PUNTOYCOMA183_tree=null;
        CommonTree FUNCLEER184_tree=null;
        CommonTree LPAR185_tree=null;
        CommonTree STRING186_tree=null;
        CommonTree COMA187_tree=null;
        CommonTree AMPERSAND188_tree=null;
        CommonTree IDENT189_tree=null;
        CommonTree LCOR190_tree=null;
        CommonTree RCOR192_tree=null;
        CommonTree RPAR193_tree=null;
        CommonTree PUNTOYCOMA194_tree=null;
        RewriteRuleTokenStream stream_PUNTOYCOMA=new RewriteRuleTokenStream(adaptor,"token PUNTOYCOMA");
        RewriteRuleTokenStream stream_AMPERSAND=new RewriteRuleTokenStream(adaptor,"token AMPERSAND");
        RewriteRuleTokenStream stream_IDENT=new RewriteRuleTokenStream(adaptor,"token IDENT");
        RewriteRuleTokenStream stream_RPAR=new RewriteRuleTokenStream(adaptor,"token RPAR");
        RewriteRuleTokenStream stream_LPAR=new RewriteRuleTokenStream(adaptor,"token LPAR");
        RewriteRuleTokenStream stream_COMA=new RewriteRuleTokenStream(adaptor,"token COMA");
        RewriteRuleTokenStream stream_RCOR=new RewriteRuleTokenStream(adaptor,"token RCOR");
        RewriteRuleTokenStream stream_FUNCLEER=new RewriteRuleTokenStream(adaptor,"token FUNCLEER");
        RewriteRuleTokenStream stream_LCOR=new RewriteRuleTokenStream(adaptor,"token LCOR");
        RewriteRuleTokenStream stream_STRING=new RewriteRuleTokenStream(adaptor,"token STRING");
        RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
        try {
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:398:6: ( FUNCLEER LPAR STRING COMA AMPERSAND IDENT RPAR PUNTOYCOMA -> ^( F_LEER ^( FORMATO STRING ) ^( NOMBRE_VAR IDENT ) ) | FUNCLEER LPAR STRING COMA AMPERSAND IDENT LCOR expr RCOR RPAR PUNTOYCOMA -> ^( F_LEER ^( FORMATO STRING ) ^( NOMBRE_VAR IDENT ) ^( INDICE expr ) ) )
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==FUNCLEER) ) {
                int LA32_1 = input.LA(2);

                if ( (LA32_1==LPAR) ) {
                    int LA32_2 = input.LA(3);

                    if ( (LA32_2==STRING) ) {
                        int LA32_3 = input.LA(4);

                        if ( (LA32_3==COMA) ) {
                            int LA32_4 = input.LA(5);

                            if ( (LA32_4==AMPERSAND) ) {
                                int LA32_5 = input.LA(6);

                                if ( (LA32_5==IDENT) ) {
                                    int LA32_6 = input.LA(7);

                                    if ( (LA32_6==RPAR) ) {
                                        alt32=1;
                                    }
                                    else if ( (LA32_6==LCOR) ) {
                                        alt32=2;
                                    }
                                    else {
                                        if (state.backtracking>0) {state.failed=true; return retval;}
                                        NoViableAltException nvae =
                                            new NoViableAltException("", 32, 6, input);

                                        throw nvae;
                                    }
                                }
                                else {
                                    if (state.backtracking>0) {state.failed=true; return retval;}
                                    NoViableAltException nvae =
                                        new NoViableAltException("", 32, 5, input);

                                    throw nvae;
                                }
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 32, 4, input);

                                throw nvae;
                            }
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 32, 3, input);

                            throw nvae;
                        }
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 32, 2, input);

                        throw nvae;
                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 32, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 32, 0, input);

                throw nvae;
            }
            switch (alt32) {
                case 1 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:399:3: FUNCLEER LPAR STRING COMA AMPERSAND IDENT RPAR PUNTOYCOMA
                    {
                    FUNCLEER176=(Token)match(input,FUNCLEER,FOLLOW_FUNCLEER_in_leer1967); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_FUNCLEER.add(FUNCLEER176);

                    LPAR177=(Token)match(input,LPAR,FOLLOW_LPAR_in_leer1969); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_LPAR.add(LPAR177);

                    STRING178=(Token)match(input,STRING,FOLLOW_STRING_in_leer1971); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_STRING.add(STRING178);

                    COMA179=(Token)match(input,COMA,FOLLOW_COMA_in_leer1973); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_COMA.add(COMA179);

                    AMPERSAND180=(Token)match(input,AMPERSAND,FOLLOW_AMPERSAND_in_leer1975); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_AMPERSAND.add(AMPERSAND180);

                    IDENT181=(Token)match(input,IDENT,FOLLOW_IDENT_in_leer1977); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_IDENT.add(IDENT181);

                    RPAR182=(Token)match(input,RPAR,FOLLOW_RPAR_in_leer1979); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_RPAR.add(RPAR182);

                    PUNTOYCOMA183=(Token)match(input,PUNTOYCOMA,FOLLOW_PUNTOYCOMA_in_leer1981); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_PUNTOYCOMA.add(PUNTOYCOMA183);



                    // AST REWRITE
                    // elements: IDENT, STRING
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 399:61: -> ^( F_LEER ^( FORMATO STRING ) ^( NOMBRE_VAR IDENT ) )
                    {
                        // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:399:64: ^( F_LEER ^( FORMATO STRING ) ^( NOMBRE_VAR IDENT ) )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(F_LEER, "F_LEER"), root_1);

                        // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:399:73: ^( FORMATO STRING )
                        {
                        CommonTree root_2 = (CommonTree)adaptor.nil();
                        root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(FORMATO, "FORMATO"), root_2);

                        adaptor.addChild(root_2, stream_STRING.nextNode());

                        adaptor.addChild(root_1, root_2);
                        }
                        // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:399:91: ^( NOMBRE_VAR IDENT )
                        {
                        CommonTree root_2 = (CommonTree)adaptor.nil();
                        root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NOMBRE_VAR, "NOMBRE_VAR"), root_2);

                        adaptor.addChild(root_2, stream_IDENT.nextNode());

                        adaptor.addChild(root_1, root_2);
                        }

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:400:4: FUNCLEER LPAR STRING COMA AMPERSAND IDENT LCOR expr RCOR RPAR PUNTOYCOMA
                    {
                    FUNCLEER184=(Token)match(input,FUNCLEER,FOLLOW_FUNCLEER_in_leer2004); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_FUNCLEER.add(FUNCLEER184);

                    LPAR185=(Token)match(input,LPAR,FOLLOW_LPAR_in_leer2006); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_LPAR.add(LPAR185);

                    STRING186=(Token)match(input,STRING,FOLLOW_STRING_in_leer2008); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_STRING.add(STRING186);

                    COMA187=(Token)match(input,COMA,FOLLOW_COMA_in_leer2010); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_COMA.add(COMA187);

                    AMPERSAND188=(Token)match(input,AMPERSAND,FOLLOW_AMPERSAND_in_leer2012); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_AMPERSAND.add(AMPERSAND188);

                    IDENT189=(Token)match(input,IDENT,FOLLOW_IDENT_in_leer2014); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_IDENT.add(IDENT189);

                    LCOR190=(Token)match(input,LCOR,FOLLOW_LCOR_in_leer2016); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_LCOR.add(LCOR190);

                    pushFollow(FOLLOW_expr_in_leer2018);
                    expr191=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expr.add(expr191.getTree());
                    RCOR192=(Token)match(input,RCOR,FOLLOW_RCOR_in_leer2020); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_RCOR.add(RCOR192);

                    RPAR193=(Token)match(input,RPAR,FOLLOW_RPAR_in_leer2022); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_RPAR.add(RPAR193);

                    PUNTOYCOMA194=(Token)match(input,PUNTOYCOMA,FOLLOW_PUNTOYCOMA_in_leer2024); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_PUNTOYCOMA.add(PUNTOYCOMA194);



                    // AST REWRITE
                    // elements: expr, IDENT, STRING
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 400:77: -> ^( F_LEER ^( FORMATO STRING ) ^( NOMBRE_VAR IDENT ) ^( INDICE expr ) )
                    {
                        // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:400:80: ^( F_LEER ^( FORMATO STRING ) ^( NOMBRE_VAR IDENT ) ^( INDICE expr ) )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(F_LEER, "F_LEER"), root_1);

                        // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:400:89: ^( FORMATO STRING )
                        {
                        CommonTree root_2 = (CommonTree)adaptor.nil();
                        root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(FORMATO, "FORMATO"), root_2);

                        adaptor.addChild(root_2, stream_STRING.nextNode());

                        adaptor.addChild(root_1, root_2);
                        }
                        // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:400:107: ^( NOMBRE_VAR IDENT )
                        {
                        CommonTree root_2 = (CommonTree)adaptor.nil();
                        root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NOMBRE_VAR, "NOMBRE_VAR"), root_2);

                        adaptor.addChild(root_2, stream_IDENT.nextNode());

                        adaptor.addChild(root_1, root_2);
                        }
                        // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:400:127: ^( INDICE expr )
                        {
                        CommonTree root_2 = (CommonTree)adaptor.nil();
                        root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(INDICE, "INDICE"), root_2);

                        adaptor.addChild(root_2, stream_expr.nextTree());

                        adaptor.addChild(root_1, root_2);
                        }

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "leer"

    public static class imprimir_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "imprimir"
    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:404:1: imprimir : ( FUNCIMPRIMIR LPAR STRING listaExpr RPAR PUNTOYCOMA -> ^( F_IMPRIMIR ^( FORMATO STRING ) ^( NOMBRE_VAR listaExpr ) ) | FUNCIMPRIMIR LPAR STRING RPAR PUNTOYCOMA -> ^( F_IMPRIMIR ^( FORMATO STRING ) ) );
    public final CParser.imprimir_return imprimir() throws RecognitionException {
        CParser.imprimir_return retval = new CParser.imprimir_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token FUNCIMPRIMIR195=null;
        Token LPAR196=null;
        Token STRING197=null;
        Token RPAR199=null;
        Token PUNTOYCOMA200=null;
        Token FUNCIMPRIMIR201=null;
        Token LPAR202=null;
        Token STRING203=null;
        Token RPAR204=null;
        Token PUNTOYCOMA205=null;
        CParser.listaExpr_return listaExpr198 = null;


        CommonTree FUNCIMPRIMIR195_tree=null;
        CommonTree LPAR196_tree=null;
        CommonTree STRING197_tree=null;
        CommonTree RPAR199_tree=null;
        CommonTree PUNTOYCOMA200_tree=null;
        CommonTree FUNCIMPRIMIR201_tree=null;
        CommonTree LPAR202_tree=null;
        CommonTree STRING203_tree=null;
        CommonTree RPAR204_tree=null;
        CommonTree PUNTOYCOMA205_tree=null;
        RewriteRuleTokenStream stream_PUNTOYCOMA=new RewriteRuleTokenStream(adaptor,"token PUNTOYCOMA");
        RewriteRuleTokenStream stream_RPAR=new RewriteRuleTokenStream(adaptor,"token RPAR");
        RewriteRuleTokenStream stream_LPAR=new RewriteRuleTokenStream(adaptor,"token LPAR");
        RewriteRuleTokenStream stream_FUNCIMPRIMIR=new RewriteRuleTokenStream(adaptor,"token FUNCIMPRIMIR");
        RewriteRuleTokenStream stream_STRING=new RewriteRuleTokenStream(adaptor,"token STRING");
        RewriteRuleSubtreeStream stream_listaExpr=new RewriteRuleSubtreeStream(adaptor,"rule listaExpr");
        try {
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:404:9: ( FUNCIMPRIMIR LPAR STRING listaExpr RPAR PUNTOYCOMA -> ^( F_IMPRIMIR ^( FORMATO STRING ) ^( NOMBRE_VAR listaExpr ) ) | FUNCIMPRIMIR LPAR STRING RPAR PUNTOYCOMA -> ^( F_IMPRIMIR ^( FORMATO STRING ) ) )
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==FUNCIMPRIMIR) ) {
                int LA33_1 = input.LA(2);

                if ( (LA33_1==LPAR) ) {
                    int LA33_2 = input.LA(3);

                    if ( (LA33_2==STRING) ) {
                        int LA33_3 = input.LA(4);

                        if ( (LA33_3==RPAR) ) {
                            alt33=2;
                        }
                        else if ( (LA33_3==LPAR||(LA33_3>=COMA && LA33_3<=IDENT)||LA33_3==MENOS||(LA33_3>=NOT && LA33_3<=FUNCLEER)||(LA33_3>=FUNCIMPRIMIR && LA33_3<=FUNC_STRLEN)) ) {
                            alt33=1;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 33, 3, input);

                            throw nvae;
                        }
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 33, 2, input);

                        throw nvae;
                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 33, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 33, 0, input);

                throw nvae;
            }
            switch (alt33) {
                case 1 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:405:3: FUNCIMPRIMIR LPAR STRING listaExpr RPAR PUNTOYCOMA
                    {
                    FUNCIMPRIMIR195=(Token)match(input,FUNCIMPRIMIR,FOLLOW_FUNCIMPRIMIR_in_imprimir2063); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_FUNCIMPRIMIR.add(FUNCIMPRIMIR195);

                    LPAR196=(Token)match(input,LPAR,FOLLOW_LPAR_in_imprimir2065); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_LPAR.add(LPAR196);

                    STRING197=(Token)match(input,STRING,FOLLOW_STRING_in_imprimir2067); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_STRING.add(STRING197);

                    pushFollow(FOLLOW_listaExpr_in_imprimir2069);
                    listaExpr198=listaExpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_listaExpr.add(listaExpr198.getTree());
                    RPAR199=(Token)match(input,RPAR,FOLLOW_RPAR_in_imprimir2071); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_RPAR.add(RPAR199);

                    PUNTOYCOMA200=(Token)match(input,PUNTOYCOMA,FOLLOW_PUNTOYCOMA_in_imprimir2073); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_PUNTOYCOMA.add(PUNTOYCOMA200);



                    // AST REWRITE
                    // elements: STRING, listaExpr
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 405:54: -> ^( F_IMPRIMIR ^( FORMATO STRING ) ^( NOMBRE_VAR listaExpr ) )
                    {
                        // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:405:57: ^( F_IMPRIMIR ^( FORMATO STRING ) ^( NOMBRE_VAR listaExpr ) )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(F_IMPRIMIR, "F_IMPRIMIR"), root_1);

                        // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:405:70: ^( FORMATO STRING )
                        {
                        CommonTree root_2 = (CommonTree)adaptor.nil();
                        root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(FORMATO, "FORMATO"), root_2);

                        adaptor.addChild(root_2, stream_STRING.nextNode());

                        adaptor.addChild(root_1, root_2);
                        }
                        // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:405:88: ^( NOMBRE_VAR listaExpr )
                        {
                        CommonTree root_2 = (CommonTree)adaptor.nil();
                        root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NOMBRE_VAR, "NOMBRE_VAR"), root_2);

                        adaptor.addChild(root_2, stream_listaExpr.nextTree());

                        adaptor.addChild(root_1, root_2);
                        }

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:406:4: FUNCIMPRIMIR LPAR STRING RPAR PUNTOYCOMA
                    {
                    FUNCIMPRIMIR201=(Token)match(input,FUNCIMPRIMIR,FOLLOW_FUNCIMPRIMIR_in_imprimir2096); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_FUNCIMPRIMIR.add(FUNCIMPRIMIR201);

                    LPAR202=(Token)match(input,LPAR,FOLLOW_LPAR_in_imprimir2098); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_LPAR.add(LPAR202);

                    STRING203=(Token)match(input,STRING,FOLLOW_STRING_in_imprimir2100); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_STRING.add(STRING203);

                    RPAR204=(Token)match(input,RPAR,FOLLOW_RPAR_in_imprimir2102); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_RPAR.add(RPAR204);

                    PUNTOYCOMA205=(Token)match(input,PUNTOYCOMA,FOLLOW_PUNTOYCOMA_in_imprimir2104); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_PUNTOYCOMA.add(PUNTOYCOMA205);



                    // AST REWRITE
                    // elements: STRING
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 406:45: -> ^( F_IMPRIMIR ^( FORMATO STRING ) )
                    {
                        // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:406:48: ^( F_IMPRIMIR ^( FORMATO STRING ) )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(F_IMPRIMIR, "F_IMPRIMIR"), root_1);

                        // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:406:61: ^( FORMATO STRING )
                        {
                        CommonTree root_2 = (CommonTree)adaptor.nil();
                        root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(FORMATO, "FORMATO"), root_2);

                        adaptor.addChild(root_2, stream_STRING.nextNode());

                        adaptor.addChild(root_1, root_2);
                        }

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "imprimir"

    public static class funcion_predefinida_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "funcion_predefinida"
    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:415:1: funcion_predefinida : ( leer | imprimir | pow | sqrt | gets | strlen );
    public final CParser.funcion_predefinida_return funcion_predefinida() throws RecognitionException {
        CParser.funcion_predefinida_return retval = new CParser.funcion_predefinida_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CParser.leer_return leer206 = null;

        CParser.imprimir_return imprimir207 = null;

        CParser.pow_return pow208 = null;

        CParser.sqrt_return sqrt209 = null;

        CParser.gets_return gets210 = null;

        CParser.strlen_return strlen211 = null;



        try {
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:416:2: ( leer | imprimir | pow | sqrt | gets | strlen )
            int alt34=6;
            switch ( input.LA(1) ) {
            case FUNCLEER:
                {
                alt34=1;
                }
                break;
            case FUNCIMPRIMIR:
                {
                alt34=2;
                }
                break;
            case FUNC_POW:
                {
                alt34=3;
                }
                break;
            case FUNC_SQRT:
                {
                alt34=4;
                }
                break;
            case FUNC_GETS:
                {
                alt34=5;
                }
                break;
            case FUNC_STRLEN:
                {
                alt34=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 34, 0, input);

                throw nvae;
            }

            switch (alt34) {
                case 1 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:417:3: leer
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_leer_in_funcion_predefinida2136);
                    leer206=leer();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, leer206.getTree());

                    }
                    break;
                case 2 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:418:4: imprimir
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_imprimir_in_funcion_predefinida2141);
                    imprimir207=imprimir();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, imprimir207.getTree());

                    }
                    break;
                case 3 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:419:4: pow
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_pow_in_funcion_predefinida2146);
                    pow208=pow();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, pow208.getTree());

                    }
                    break;
                case 4 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:420:4: sqrt
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_sqrt_in_funcion_predefinida2152);
                    sqrt209=sqrt();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, sqrt209.getTree());

                    }
                    break;
                case 5 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:421:4: gets
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_gets_in_funcion_predefinida2158);
                    gets210=gets();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, gets210.getTree());

                    }
                    break;
                case 6 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:422:4: strlen
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_strlen_in_funcion_predefinida2164);
                    strlen211=strlen();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, strlen211.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "funcion_predefinida"

    public static class pow_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "pow"
    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:426:1: pow : FUNC_POW LPAR a= expr COMA b= expr RPAR -> ^( F_POW $a $b) ;
    public final CParser.pow_return pow() throws RecognitionException {
        CParser.pow_return retval = new CParser.pow_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token FUNC_POW212=null;
        Token LPAR213=null;
        Token COMA214=null;
        Token RPAR215=null;
        CParser.expr_return a = null;

        CParser.expr_return b = null;


        CommonTree FUNC_POW212_tree=null;
        CommonTree LPAR213_tree=null;
        CommonTree COMA214_tree=null;
        CommonTree RPAR215_tree=null;
        RewriteRuleTokenStream stream_RPAR=new RewriteRuleTokenStream(adaptor,"token RPAR");
        RewriteRuleTokenStream stream_LPAR=new RewriteRuleTokenStream(adaptor,"token LPAR");
        RewriteRuleTokenStream stream_COMA=new RewriteRuleTokenStream(adaptor,"token COMA");
        RewriteRuleTokenStream stream_FUNC_POW=new RewriteRuleTokenStream(adaptor,"token FUNC_POW");
        RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
        try {
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:426:5: ( FUNC_POW LPAR a= expr COMA b= expr RPAR -> ^( F_POW $a $b) )
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:427:3: FUNC_POW LPAR a= expr COMA b= expr RPAR
            {
            FUNC_POW212=(Token)match(input,FUNC_POW,FOLLOW_FUNC_POW_in_pow2179); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_FUNC_POW.add(FUNC_POW212);

            LPAR213=(Token)match(input,LPAR,FOLLOW_LPAR_in_pow2181); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_LPAR.add(LPAR213);

            pushFollow(FOLLOW_expr_in_pow2185);
            a=expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_expr.add(a.getTree());
            COMA214=(Token)match(input,COMA,FOLLOW_COMA_in_pow2187); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_COMA.add(COMA214);

            pushFollow(FOLLOW_expr_in_pow2191);
            b=expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_expr.add(b.getTree());
            RPAR215=(Token)match(input,RPAR,FOLLOW_RPAR_in_pow2193); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_RPAR.add(RPAR215);



            // AST REWRITE
            // elements: a, b
            // token labels: 
            // rule labels: retval, b, a
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
            RewriteRuleSubtreeStream stream_b=new RewriteRuleSubtreeStream(adaptor,"rule b",b!=null?b.tree:null);
            RewriteRuleSubtreeStream stream_a=new RewriteRuleSubtreeStream(adaptor,"rule a",a!=null?a.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 427:42: -> ^( F_POW $a $b)
            {
                // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:427:45: ^( F_POW $a $b)
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(F_POW, "F_POW"), root_1);

                adaptor.addChild(root_1, stream_a.nextTree());
                adaptor.addChild(root_1, stream_b.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "pow"

    public static class sqrt_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "sqrt"
    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:430:1: sqrt : FUNC_SQRT LPAR expr RPAR -> ^( F_SQRT expr ) ;
    public final CParser.sqrt_return sqrt() throws RecognitionException {
        CParser.sqrt_return retval = new CParser.sqrt_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token FUNC_SQRT216=null;
        Token LPAR217=null;
        Token RPAR219=null;
        CParser.expr_return expr218 = null;


        CommonTree FUNC_SQRT216_tree=null;
        CommonTree LPAR217_tree=null;
        CommonTree RPAR219_tree=null;
        RewriteRuleTokenStream stream_RPAR=new RewriteRuleTokenStream(adaptor,"token RPAR");
        RewriteRuleTokenStream stream_FUNC_SQRT=new RewriteRuleTokenStream(adaptor,"token FUNC_SQRT");
        RewriteRuleTokenStream stream_LPAR=new RewriteRuleTokenStream(adaptor,"token LPAR");
        RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
        try {
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:430:6: ( FUNC_SQRT LPAR expr RPAR -> ^( F_SQRT expr ) )
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:430:8: FUNC_SQRT LPAR expr RPAR
            {
            FUNC_SQRT216=(Token)match(input,FUNC_SQRT,FOLLOW_FUNC_SQRT_in_sqrt2216); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_FUNC_SQRT.add(FUNC_SQRT216);

            LPAR217=(Token)match(input,LPAR,FOLLOW_LPAR_in_sqrt2218); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_LPAR.add(LPAR217);

            pushFollow(FOLLOW_expr_in_sqrt2220);
            expr218=expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_expr.add(expr218.getTree());
            RPAR219=(Token)match(input,RPAR,FOLLOW_RPAR_in_sqrt2222); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_RPAR.add(RPAR219);



            // AST REWRITE
            // elements: expr
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 430:33: -> ^( F_SQRT expr )
            {
                // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:430:36: ^( F_SQRT expr )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(F_SQRT, "F_SQRT"), root_1);

                adaptor.addChild(root_1, stream_expr.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "sqrt"

    public static class gets_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "gets"
    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:433:1: gets : FUNC_GETS LPAR IDENT RPAR -> ^( F_GETS IDENT ) ;
    public final CParser.gets_return gets() throws RecognitionException {
        CParser.gets_return retval = new CParser.gets_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token FUNC_GETS220=null;
        Token LPAR221=null;
        Token IDENT222=null;
        Token RPAR223=null;

        CommonTree FUNC_GETS220_tree=null;
        CommonTree LPAR221_tree=null;
        CommonTree IDENT222_tree=null;
        CommonTree RPAR223_tree=null;
        RewriteRuleTokenStream stream_IDENT=new RewriteRuleTokenStream(adaptor,"token IDENT");
        RewriteRuleTokenStream stream_RPAR=new RewriteRuleTokenStream(adaptor,"token RPAR");
        RewriteRuleTokenStream stream_FUNC_GETS=new RewriteRuleTokenStream(adaptor,"token FUNC_GETS");
        RewriteRuleTokenStream stream_LPAR=new RewriteRuleTokenStream(adaptor,"token LPAR");

        try {
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:433:6: ( FUNC_GETS LPAR IDENT RPAR -> ^( F_GETS IDENT ) )
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:433:8: FUNC_GETS LPAR IDENT RPAR
            {
            FUNC_GETS220=(Token)match(input,FUNC_GETS,FOLLOW_FUNC_GETS_in_gets2241); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_FUNC_GETS.add(FUNC_GETS220);

            LPAR221=(Token)match(input,LPAR,FOLLOW_LPAR_in_gets2243); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_LPAR.add(LPAR221);

            IDENT222=(Token)match(input,IDENT,FOLLOW_IDENT_in_gets2245); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_IDENT.add(IDENT222);

            RPAR223=(Token)match(input,RPAR,FOLLOW_RPAR_in_gets2247); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_RPAR.add(RPAR223);



            // AST REWRITE
            // elements: IDENT
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 433:35: -> ^( F_GETS IDENT )
            {
                // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:433:38: ^( F_GETS IDENT )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(F_GETS, "F_GETS"), root_1);

                adaptor.addChild(root_1, stream_IDENT.nextNode());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "gets"

    public static class strlen_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "strlen"
    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:436:1: strlen : FUNC_STRLEN LPAR IDENT RPAR -> ^( F_STRLEN IDENT ) ;
    public final CParser.strlen_return strlen() throws RecognitionException {
        CParser.strlen_return retval = new CParser.strlen_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token FUNC_STRLEN224=null;
        Token LPAR225=null;
        Token IDENT226=null;
        Token RPAR227=null;

        CommonTree FUNC_STRLEN224_tree=null;
        CommonTree LPAR225_tree=null;
        CommonTree IDENT226_tree=null;
        CommonTree RPAR227_tree=null;
        RewriteRuleTokenStream stream_IDENT=new RewriteRuleTokenStream(adaptor,"token IDENT");
        RewriteRuleTokenStream stream_RPAR=new RewriteRuleTokenStream(adaptor,"token RPAR");
        RewriteRuleTokenStream stream_LPAR=new RewriteRuleTokenStream(adaptor,"token LPAR");
        RewriteRuleTokenStream stream_FUNC_STRLEN=new RewriteRuleTokenStream(adaptor,"token FUNC_STRLEN");

        try {
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:436:8: ( FUNC_STRLEN LPAR IDENT RPAR -> ^( F_STRLEN IDENT ) )
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:436:10: FUNC_STRLEN LPAR IDENT RPAR
            {
            FUNC_STRLEN224=(Token)match(input,FUNC_STRLEN,FOLLOW_FUNC_STRLEN_in_strlen2267); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_FUNC_STRLEN.add(FUNC_STRLEN224);

            LPAR225=(Token)match(input,LPAR,FOLLOW_LPAR_in_strlen2269); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_LPAR.add(LPAR225);

            IDENT226=(Token)match(input,IDENT,FOLLOW_IDENT_in_strlen2271); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_IDENT.add(IDENT226);

            RPAR227=(Token)match(input,RPAR,FOLLOW_RPAR_in_strlen2273); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_RPAR.add(RPAR227);



            // AST REWRITE
            // elements: IDENT
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 436:39: -> ^( F_STRLEN IDENT )
            {
                // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:436:42: ^( F_STRLEN IDENT )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(F_STRLEN, "F_STRLEN"), root_1);

                adaptor.addChild(root_1, stream_IDENT.nextNode());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "strlen"

    public static class precompilacion_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "precompilacion"
    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:440:1: precompilacion : define ;
    public final CParser.precompilacion_return precompilacion() throws RecognitionException {
        CParser.precompilacion_return retval = new CParser.precompilacion_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CParser.define_return define228 = null;



        try {
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:441:2: ( define )
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:441:4: define
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_define_in_precompilacion2295);
            define228=define();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, define228.getTree());

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "precompilacion"

    public static class define_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "define"
    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:445:1: define : ( '#define' | '# define' ) IDENT atom -> ^( DEFINE ^( NOMBRE_VAR IDENT ) ^( VALOR atom ) ) ;
    public final CParser.define_return define() throws RecognitionException {
        CParser.define_return retval = new CParser.define_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal229=null;
        Token string_literal230=null;
        Token IDENT231=null;
        CParser.atom_return atom232 = null;


        CommonTree string_literal229_tree=null;
        CommonTree string_literal230_tree=null;
        CommonTree IDENT231_tree=null;
        RewriteRuleTokenStream stream_IDENT=new RewriteRuleTokenStream(adaptor,"token IDENT");
        RewriteRuleTokenStream stream_106=new RewriteRuleTokenStream(adaptor,"token 106");
        RewriteRuleTokenStream stream_105=new RewriteRuleTokenStream(adaptor,"token 105");
        RewriteRuleSubtreeStream stream_atom=new RewriteRuleSubtreeStream(adaptor,"rule atom");
        try {
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:445:8: ( ( '#define' | '# define' ) IDENT atom -> ^( DEFINE ^( NOMBRE_VAR IDENT ) ^( VALOR atom ) ) )
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:445:10: ( '#define' | '# define' ) IDENT atom
            {
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:445:10: ( '#define' | '# define' )
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==105) ) {
                alt35=1;
            }
            else if ( (LA35_0==106) ) {
                alt35=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 35, 0, input);

                throw nvae;
            }
            switch (alt35) {
                case 1 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:445:11: '#define'
                    {
                    string_literal229=(Token)match(input,105,FOLLOW_105_in_define2307); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_105.add(string_literal229);


                    }
                    break;
                case 2 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:445:21: '# define'
                    {
                    string_literal230=(Token)match(input,106,FOLLOW_106_in_define2309); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_106.add(string_literal230);


                    }
                    break;

            }

            IDENT231=(Token)match(input,IDENT,FOLLOW_IDENT_in_define2312); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_IDENT.add(IDENT231);

            pushFollow(FOLLOW_atom_in_define2314);
            atom232=atom();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_atom.add(atom232.getTree());


            // AST REWRITE
            // elements: atom, IDENT
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 445:44: -> ^( DEFINE ^( NOMBRE_VAR IDENT ) ^( VALOR atom ) )
            {
                // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:445:47: ^( DEFINE ^( NOMBRE_VAR IDENT ) ^( VALOR atom ) )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(DEFINE, "DEFINE"), root_1);

                // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:445:56: ^( NOMBRE_VAR IDENT )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NOMBRE_VAR, "NOMBRE_VAR"), root_2);

                adaptor.addChild(root_2, stream_IDENT.nextNode());

                adaptor.addChild(root_1, root_2);
                }
                // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:445:76: ^( VALOR atom )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VALOR, "VALOR"), root_2);

                adaptor.addChild(root_2, stream_atom.nextTree());

                adaptor.addChild(root_1, root_2);
                }

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "define"

    // $ANTLR start synpred1_C
    public final void synpred1_C_fragment() throws RecognitionException {   
        CParser.sentencia_return s1 = null;

        CParser.sentencia_return s2 = null;


        // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:249:3: ( IF LPAR expr RPAR s1= sentencia ELSE s2= sentencia )
        // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\C.g:249:3: IF LPAR expr RPAR s1= sentencia ELSE s2= sentencia
        {
        match(input,IF,FOLLOW_IF_in_synpred1_C931); if (state.failed) return ;
        match(input,LPAR,FOLLOW_LPAR_in_synpred1_C933); if (state.failed) return ;
        pushFollow(FOLLOW_expr_in_synpred1_C935);
        expr();

        state._fsp--;
        if (state.failed) return ;
        match(input,RPAR,FOLLOW_RPAR_in_synpred1_C937); if (state.failed) return ;
        pushFollow(FOLLOW_sentencia_in_synpred1_C941);
        s1=sentencia();

        state._fsp--;
        if (state.failed) return ;
        match(input,ELSE,FOLLOW_ELSE_in_synpred1_C944); if (state.failed) return ;
        pushFollow(FOLLOW_sentencia_in_synpred1_C948);
        s2=sentencia();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred1_C

    // Delegated rules

    public final boolean synpred1_C() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_C_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA4 dfa4 = new DFA4(this);
    protected DFA9 dfa9 = new DFA9(this);
    protected DFA30 dfa30 = new DFA30(this);
    static final String DFA4_eotS =
        "\25\uffff";
    static final String DFA4_eofS =
        "\25\uffff";
    static final String DFA4_minS =
        "\1\62\1\57\1\62\1\60\1\57\1\62\1\56\1\60\1\62\2\uffff\1\64\1\144"+
        "\2\60\1\62\1\60\1\62\1\64\2\60";
    static final String DFA4_maxS =
        "\1\150\1\57\1\62\1\150\1\57\1\110\1\66\1\63\1\62\2\uffff\1\64\1"+
        "\150\2\61\1\110\1\63\1\62\1\64\2\61";
    static final String DFA4_acceptS =
        "\11\uffff\1\1\1\2\12\uffff";
    static final String DFA4_specialS =
        "\25\uffff}>";
    static final String[] DFA4_transitionS = {
            "\1\1\61\uffff\5\2",
            "\1\3",
            "\1\4",
            "\1\6\63\uffff\5\5",
            "\1\3",
            "\1\7\25\uffff\1\10",
            "\1\12\7\uffff\1\11",
            "\1\6\1\14\1\uffff\1\13",
            "\1\15",
            "",
            "",
            "\1\16",
            "\5\17",
            "\1\6\1\14",
            "\1\6\1\14",
            "\1\20\25\uffff\1\21",
            "\1\6\1\14\1\uffff\1\22",
            "\1\23",
            "\1\24",
            "\1\6\1\14",
            "\1\6\1\14"
    };

    static final short[] DFA4_eot = DFA.unpackEncodedString(DFA4_eotS);
    static final short[] DFA4_eof = DFA.unpackEncodedString(DFA4_eofS);
    static final char[] DFA4_min = DFA.unpackEncodedStringToUnsignedChars(DFA4_minS);
    static final char[] DFA4_max = DFA.unpackEncodedStringToUnsignedChars(DFA4_maxS);
    static final short[] DFA4_accept = DFA.unpackEncodedString(DFA4_acceptS);
    static final short[] DFA4_special = DFA.unpackEncodedString(DFA4_specialS);
    static final short[][] DFA4_transition;

    static {
        int numStates = DFA4_transitionS.length;
        DFA4_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA4_transition[i] = DFA.unpackEncodedString(DFA4_transitionS[i]);
        }
    }

    class DFA4 extends DFA {

        public DFA4(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 4;
            this.eot = DFA4_eot;
            this.eof = DFA4_eof;
            this.min = DFA4_min;
            this.max = DFA4_max;
            this.accept = DFA4_accept;
            this.special = DFA4_special;
            this.transition = DFA4_transition;
        }
        public String getDescription() {
            return "129:1: funcion : ( cabecera_funcion bloque -> ^( FUNCION ^( CABECERA_FUNCION cabecera_funcion ) ^( bloque ) ) | cabecera_funcion PUNTOYCOMA );";
        }
    }
    static final String DFA9_eotS =
        "\15\uffff";
    static final String DFA9_eofS =
        "\15\uffff";
    static final String DFA9_minS =
        "\1\56\2\uffff\1\57\11\uffff";
    static final String DFA9_maxS =
        "\1\130\2\uffff\1\121\11\uffff";
    static final String DFA9_acceptS =
        "\1\uffff\1\1\1\2\1\uffff\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1"+
        "\3";
    static final String DFA9_specialS =
        "\15\uffff}>";
    static final String[] DFA9_transitionS = {
            "\1\13\3\uffff\1\3\2\uffff\1\4\1\1\1\uffff\1\7\1\uffff\1\10"+
            "\1\11\1\12\13\uffff\1\2\7\uffff\2\5\1\6\1\uffff\5\6",
            "",
            "",
            "\1\14\3\uffff\1\2\11\uffff\1\2\22\uffff\2\5",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA9_eot = DFA.unpackEncodedString(DFA9_eotS);
    static final short[] DFA9_eof = DFA.unpackEncodedString(DFA9_eofS);
    static final char[] DFA9_min = DFA.unpackEncodedStringToUnsignedChars(DFA9_minS);
    static final char[] DFA9_max = DFA.unpackEncodedStringToUnsignedChars(DFA9_maxS);
    static final short[] DFA9_accept = DFA.unpackEncodedString(DFA9_acceptS);
    static final short[] DFA9_special = DFA.unpackEncodedString(DFA9_specialS);
    static final short[][] DFA9_transition;

    static {
        int numStates = DFA9_transitionS.length;
        DFA9_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA9_transition[i] = DFA.unpackEncodedString(DFA9_transitionS[i]);
        }
    }

    class DFA9 extends DFA {

        public DFA9(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 9;
            this.eot = DFA9_eot;
            this.eof = DFA9_eof;
            this.min = DFA9_min;
            this.max = DFA9_max;
            this.accept = DFA9_accept;
            this.special = DFA9_special;
            this.transition = DFA9_transition;
        }
        public String getDescription() {
            return "188:1: sentencia : ( bloque | sentencia_asignacion | llamada | RETURN expr -> ^( RETURN expr ) | prim | funcion_predefinida | sentenciaIF | sentenciaWHILE | sentenciaDOWHILE | sentenciaFOR | PUNTOYCOMA );";
        }
    }
    static final String DFA30_eotS =
        "\26\uffff";
    static final String DFA30_eofS =
        "\2\uffff\1\17\10\uffff\2\3\11\uffff";
    static final String DFA30_minS =
        "\2\57\1\56\10\uffff\2\56\3\uffff\6\56";
    static final String DFA30_maxS =
        "\1\130\1\150\1\152\10\uffff\2\152\3\uffff\6\150";
    static final String DFA30_acceptS =
        "\3\uffff\1\3\1\4\1\5\1\6\1\7\1\12\1\1\1\2\2\uffff\1\10\1\13\1\11"+
        "\6\uffff";
    static final String DFA30_specialS =
        "\26\uffff}>";
    static final String[] DFA30_transitionS = {
            "\1\1\2\uffff\1\2\31\uffff\1\4\1\5\1\6\1\7\2\3\1\10\1\uffff"+
            "\5\10",
            "\1\11\2\uffff\1\11\24\uffff\1\11\3\uffff\10\11\1\uffff\5\11"+
            "\13\uffff\5\12",
            "\1\17\1\16\3\17\1\15\11\17\1\uffff\15\17\5\uffff\1\13\1\14"+
            "\1\17\1\uffff\5\17\13\uffff\7\17",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\3\1\uffff\2\3\1\20\1\uffff\11\3\1\uffff\15\3\5\uffff\3"+
            "\3\1\uffff\5\3\13\uffff\7\3",
            "\1\3\1\uffff\2\3\1\21\1\uffff\11\3\1\uffff\15\3\5\uffff\3"+
            "\3\1\uffff\5\3\13\uffff\7\3",
            "",
            "",
            "",
            "\1\17\1\3\2\uffff\1\17\1\3\1\uffff\4\17\1\uffff\3\17\1\3\12"+
            "\uffff\1\17\7\uffff\1\22\1\23\1\17\1\uffff\5\17\13\uffff\5\17",
            "\1\17\1\3\2\uffff\1\17\1\3\1\uffff\4\17\1\uffff\3\17\1\3\12"+
            "\uffff\1\17\7\uffff\1\22\1\23\1\17\1\uffff\5\17\13\uffff\5\17",
            "\1\3\3\uffff\1\24\2\uffff\4\3\1\uffff\3\3\13\uffff\1\3\7\uffff"+
            "\3\3\1\uffff\5\3\13\uffff\5\3",
            "\1\3\3\uffff\1\25\2\uffff\4\3\1\uffff\3\3\13\uffff\1\3\7\uffff"+
            "\3\3\1\uffff\5\3\13\uffff\5\3",
            "\1\17\1\3\2\uffff\1\17\1\3\1\uffff\4\17\1\uffff\3\17\1\3\12"+
            "\uffff\1\17\7\uffff\1\22\1\23\1\17\1\uffff\5\17\13\uffff\5\17",
            "\1\17\1\3\2\uffff\1\17\1\3\1\uffff\4\17\1\uffff\3\17\1\3\12"+
            "\uffff\1\17\7\uffff\1\22\1\23\1\17\1\uffff\5\17\13\uffff\5\17"
    };

    static final short[] DFA30_eot = DFA.unpackEncodedString(DFA30_eotS);
    static final short[] DFA30_eof = DFA.unpackEncodedString(DFA30_eofS);
    static final char[] DFA30_min = DFA.unpackEncodedStringToUnsignedChars(DFA30_minS);
    static final char[] DFA30_max = DFA.unpackEncodedStringToUnsignedChars(DFA30_maxS);
    static final short[] DFA30_accept = DFA.unpackEncodedString(DFA30_acceptS);
    static final short[] DFA30_special = DFA.unpackEncodedString(DFA30_specialS);
    static final short[][] DFA30_transition;

    static {
        int numStates = DFA30_transitionS.length;
        DFA30_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA30_transition[i] = DFA.unpackEncodedString(DFA30_transitionS[i]);
        }
    }

    class DFA30 extends DFA {

        public DFA30(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 30;
            this.eot = DFA30_eot;
            this.eof = DFA30_eof;
            this.min = DFA30_min;
            this.max = DFA30_max;
            this.accept = DFA30_accept;
            this.special = DFA30_special;
            this.transition = DFA30_transition;
        }
        public String getDescription() {
            return "370:1: atom : ( LPAR expr RPAR | LPAR tipo_base RPAR expr -> expr | prim | INT | FLOAT | STRING | CHAR | IDENT LCOR expr RCOR | IDENT | funcion_predefinida | llamada );";
        }
    }
 

    public static final BitSet FOLLOW_declaraciones_globales_in_programa233 = new BitSet(new long[]{0x0004000000000000L,0x000001F000000000L});
    public static final BitSet FOLLOW_funciones_in_programa235 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_programa237 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_funciones_in_programa274 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_programa276 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_declaracion_global_in_declaraciones_globales319 = new BitSet(new long[]{0x0000000000000002L,0x0000060000000000L});
    public static final BitSet FOLLOW_funcion_in_funciones335 = new BitSet(new long[]{0x0004000000000002L,0x000001F000000000L});
    public static final BitSet FOLLOW_set_in_tipo_base0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_precompilacion_in_declaracion_global397 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_cabecera_funcion_in_funcion434 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_bloque_in_funcion436 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_cabecera_funcion_in_funcion457 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_PUNTOYCOMA_in_funcion460 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_declaracion_nombre_funcion_in_cabecera_funcion483 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_LPAR_in_cabecera_funcion485 = new BitSet(new long[]{0x0005000000000000L,0x000001F000000000L});
    public static final BitSet FOLLOW_lista_param_formales_in_cabecera_funcion488 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_RPAR_in_cabecera_funcion491 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_param_formal_in_lista_param_formales510 = new BitSet(new long[]{0x0002000000000002L});
    public static final BitSet FOLLOW_COMA_in_lista_param_formales514 = new BitSet(new long[]{0x0004000000000000L,0x000001F000000000L});
    public static final BitSet FOLLOW_param_formal_in_lista_param_formales517 = new BitSet(new long[]{0x0002000000000002L});
    public static final BitSet FOLLOW_tipo_base_in_param_formal542 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_IDENT_in_param_formal544 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tipo_base_in_param_formal569 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_IDENT_in_param_formal571 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_LCOR_in_param_formal573 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_RCOR_in_param_formal575 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tipo_base_in_param_formal600 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_PROD_in_param_formal602 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_IDENT_in_param_formal604 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_declaracion_nombre_funcion645 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tipo_base_in_declaracion_nombre_funcion662 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_IDENT_in_declaracion_nombre_funcion664 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bloque_in_sentencia701 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_sentencia_asignacion_in_sentencia706 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_llamada_in_sentencia711 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RETURN_in_sentencia717 = new BitSet(new long[]{0x0004800000000000L,0x0000000001F7F880L});
    public static final BitSet FOLLOW_expr_in_sentencia719 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_prim_in_sentencia733 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_funcion_predefinida_in_sentencia738 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_sentenciaIF_in_sentencia743 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_sentenciaWHILE_in_sentencia748 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_sentenciaDOWHILE_in_sentencia753 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_sentenciaFOR_in_sentencia758 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PUNTOYCOMA_in_sentencia763 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LCURL_in_bloque778 = new BitSet(new long[]{0x1DE4C00000000000L,0x000001F001F7F980L});
    public static final BitSet FOLLOW_elemento_bloque_in_bloque780 = new BitSet(new long[]{0x1DE4C00000000000L,0x000001F001F7F980L});
    public static final BitSet FOLLOW_RCURL_in_bloque783 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_declaracion_variables_in_elemento_bloque806 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_sentencia_in_elemento_bloque811 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tipo_base_in_declaracion_variables852 = new BitSet(new long[]{0x0004000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_declaracion_var_asig_in_declaracion_variables855 = new BitSet(new long[]{0x0002400000000000L});
    public static final BitSet FOLLOW_COMA_in_declaracion_variables858 = new BitSet(new long[]{0x0004000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_declaracion_var_asig_in_declaracion_variables860 = new BitSet(new long[]{0x0002400000000000L});
    public static final BitSet FOLLOW_PUNTOYCOMA_in_declaracion_variables864 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_declaracion_variable_in_declaracion_var_asig897 = new BitSet(new long[]{0x2000000000000002L});
    public static final BitSet FOLLOW_asignacion_in_declaracion_var_asig899 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IF_in_sentenciaIF931 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_LPAR_in_sentenciaIF933 = new BitSet(new long[]{0x0004800000000000L,0x0000000001F7F880L});
    public static final BitSet FOLLOW_expr_in_sentenciaIF935 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_RPAR_in_sentenciaIF937 = new BitSet(new long[]{0x1D64C00000000000L,0x000001F001F7F980L});
    public static final BitSet FOLLOW_sentencia_in_sentenciaIF941 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_ELSE_in_sentenciaIF944 = new BitSet(new long[]{0x1D64C00000000000L,0x000001F001F7F980L});
    public static final BitSet FOLLOW_sentencia_in_sentenciaIF948 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IF_in_sentenciaIF972 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_LPAR_in_sentenciaIF974 = new BitSet(new long[]{0x0004800000000000L,0x0000000001F7F880L});
    public static final BitSet FOLLOW_expr_in_sentenciaIF976 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_RPAR_in_sentenciaIF978 = new BitSet(new long[]{0x1D64C00000000000L,0x000001F001F7F980L});
    public static final BitSet FOLLOW_sentencia_in_sentenciaIF980 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WHILE_in_sentenciaWHILE1016 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_LPAR_in_sentenciaWHILE1018 = new BitSet(new long[]{0x0004800000000000L,0x0000000001F7F880L});
    public static final BitSet FOLLOW_expr_in_sentenciaWHILE1020 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_RPAR_in_sentenciaWHILE1022 = new BitSet(new long[]{0x1D64C00000000000L,0x000001F001F7F980L});
    public static final BitSet FOLLOW_sentencia_in_sentenciaWHILE1024 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DO_in_sentenciaDOWHILE1047 = new BitSet(new long[]{0x1D64C00000000000L,0x000001F001F7F980L});
    public static final BitSet FOLLOW_sentencia_in_sentenciaDOWHILE1049 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_WHILE_in_sentenciaDOWHILE1051 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_LPAR_in_sentenciaDOWHILE1053 = new BitSet(new long[]{0x0004800000000000L,0x0000000001F7F880L});
    public static final BitSet FOLLOW_expr_in_sentenciaDOWHILE1055 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_RPAR_in_sentenciaDOWHILE1057 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FOR_in_sentenciaFOR1084 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_LPAR_in_sentenciaFOR1086 = new BitSet(new long[]{0x0004000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_sentencia_asignacion_in_sentenciaFOR1090 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_PUNTOYCOMA_in_sentenciaFOR1092 = new BitSet(new long[]{0x0004800000000000L,0x0000000001F7F880L});
    public static final BitSet FOLLOW_expr_in_sentenciaFOR1096 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_PUNTOYCOMA_in_sentenciaFOR1098 = new BitSet(new long[]{0x1D64C00000000000L,0x000001F001F7F980L});
    public static final BitSet FOLLOW_sentencia_in_sentenciaFOR1102 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_RPAR_in_sentenciaFOR1104 = new BitSet(new long[]{0x1D64C00000000000L,0x000001F001F7F980L});
    public static final BitSet FOLLOW_sentencia_in_sentenciaFOR1108 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ASIG_in_asignacion1151 = new BitSet(new long[]{0x0004800000000000L,0x0000000001F7F880L});
    public static final BitSet FOLLOW_expr_in_asignacion1153 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ASIG_in_asignacion1171 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_PROD_in_asignacion1173 = new BitSet(new long[]{0x0004800000000000L,0x0000000001F7F880L});
    public static final BitSet FOLLOW_expr_in_asignacion1175 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ASIG_in_asignacion1193 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_listaValores_in_asignacion1195 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ASIG_in_asignacion1214 = new BitSet(new long[]{0x0000000000000000L,0x0000000000080000L});
    public static final BitSet FOLLOW_AMPERSAND_in_asignacion1216 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_IDENT_in_asignacion1218 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_declaracion_variable1244 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_LCOR_in_declaracion_variable1246 = new BitSet(new long[]{0x0004800000000000L,0x0000000001F7F880L});
    public static final BitSet FOLLOW_expr_in_declaracion_variable1248 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_RCOR_in_declaracion_variable1250 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_declaracion_variable1274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PROD_in_declaracion_variable1291 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_IDENT_in_declaracion_variable1293 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_nombre_variable1321 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_LCOR_in_nombre_variable1323 = new BitSet(new long[]{0x0004800000000000L,0x0000000001F7F880L});
    public static final BitSet FOLLOW_expr_in_nombre_variable1325 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_RCOR_in_nombre_variable1327 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_nombre_variable1347 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PROD_in_sentencia_asignacion1370 = new BitSet(new long[]{0x0004000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_nombre_variable_in_sentencia_asignacion1372 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_asignacion_in_sentencia_asignacion1374 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nombre_variable_in_sentencia_asignacion1394 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_asignacion_in_sentencia_asignacion1396 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_llamada1424 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_LPAR_in_llamada1426 = new BitSet(new long[]{0x0006800000000000L,0x0000000001F7F880L});
    public static final BitSet FOLLOW_listaExpr_in_llamada1428 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_RPAR_in_llamada1430 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_llamada1454 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_LPAR_in_llamada1456 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_RPAR_in_llamada1458 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_orExpr_in_expr1502 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LCURL_in_listaValores1515 = new BitSet(new long[]{0x0006800000000000L,0x0000000001F7F880L});
    public static final BitSet FOLLOW_listaExpr_in_listaValores1518 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_RCURL_in_listaValores1520 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COMA_in_listaExpr1532 = new BitSet(new long[]{0x0004800000000000L,0x0000000001F7F880L});
    public static final BitSet FOLLOW_expr_in_listaExpr1536 = new BitSet(new long[]{0x0002000000000002L});
    public static final BitSet FOLLOW_COMA_in_listaExpr1539 = new BitSet(new long[]{0x0004800000000000L,0x0000000001F7F880L});
    public static final BitSet FOLLOW_expr_in_listaExpr1542 = new BitSet(new long[]{0x0002000000000002L});
    public static final BitSet FOLLOW_andExpr_in_orExpr1559 = new BitSet(new long[]{0x4000000000000002L});
    public static final BitSet FOLLOW_OR_in_orExpr1562 = new BitSet(new long[]{0x0004800000000000L,0x0000000001F7F880L});
    public static final BitSet FOLLOW_andExpr_in_orExpr1565 = new BitSet(new long[]{0x4000000000000002L});
    public static final BitSet FOLLOW_eqExpr_in_andExpr1577 = new BitSet(new long[]{0x8000000000000002L});
    public static final BitSet FOLLOW_AND_in_andExpr1580 = new BitSet(new long[]{0x0004800000000000L,0x0000000001F7F880L});
    public static final BitSet FOLLOW_eqExpr_in_andExpr1583 = new BitSet(new long[]{0x8000000000000002L});
    public static final BitSet FOLLOW_compExpr_in_eqExpr1596 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000003L});
    public static final BitSet FOLLOW_set_in_eqExpr1599 = new BitSet(new long[]{0x0004800000000000L,0x0000000001F7F880L});
    public static final BitSet FOLLOW_compExpr_in_eqExpr1606 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000003L});
    public static final BitSet FOLLOW_sumExpr_in_compExpr1620 = new BitSet(new long[]{0x0000000000000002L,0x000000000000003CL});
    public static final BitSet FOLLOW_set_in_compExpr1623 = new BitSet(new long[]{0x0004800000000000L,0x0000000001F7F880L});
    public static final BitSet FOLLOW_sumExpr_in_compExpr1634 = new BitSet(new long[]{0x0000000000000002L,0x000000000000003CL});
    public static final BitSet FOLLOW_multExpr_in_sumExpr1646 = new BitSet(new long[]{0x0000000000000002L,0x00000000000000C0L});
    public static final BitSet FOLLOW_set_in_sumExpr1649 = new BitSet(new long[]{0x0004800000000000L,0x0000000001F7F880L});
    public static final BitSet FOLLOW_multExpr_in_sumExpr1656 = new BitSet(new long[]{0x0000000000000002L,0x00000000000000C0L});
    public static final BitSet FOLLOW_notExpr_in_multExpr1668 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000700L});
    public static final BitSet FOLLOW_set_in_multExpr1671 = new BitSet(new long[]{0x0004800000000000L,0x0000000001F7F880L});
    public static final BitSet FOLLOW_notExpr_in_multExpr1680 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000700L});
    public static final BitSet FOLLOW_NOT_in_notExpr1692 = new BitSet(new long[]{0x0004800000000000L,0x0000000001F7F880L});
    public static final BitSet FOLLOW_negExpr_in_notExpr1694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_negExpr_in_notExpr1708 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MENOS_in_negExpr1724 = new BitSet(new long[]{0x0004800000000000L,0x0000000001F7F880L});
    public static final BitSet FOLLOW_atom_in_negExpr1726 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atom_in_negExpr1740 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAR_in_atom1763 = new BitSet(new long[]{0x0004800000000000L,0x0000000001F7F880L});
    public static final BitSet FOLLOW_expr_in_atom1765 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_RPAR_in_atom1767 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAR_in_atom1772 = new BitSet(new long[]{0x0004000000000000L,0x000001F000000000L});
    public static final BitSet FOLLOW_tipo_base_in_atom1774 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_RPAR_in_atom1776 = new BitSet(new long[]{0x0004800000000000L,0x0000000001F7F880L});
    public static final BitSet FOLLOW_expr_in_atom1778 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_prim_in_atom1788 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_atom1793 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOAT_in_atom1798 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_atom1803 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CHAR_in_atom1808 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_atom1813 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_LCOR_in_atom1815 = new BitSet(new long[]{0x0004800000000000L,0x0000000001F7F880L});
    public static final BitSet FOLLOW_expr_in_atom1817 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_RCOR_in_atom1819 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_atom1825 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_funcion_predefinida_in_atom1830 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_llamada_in_atom1835 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_prim1852 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_MASMAS_in_prim1854 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_prim1878 = new BitSet(new long[]{0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_MENOSMENOS_in_prim1880 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MASMAS_in_prim1904 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_IDENT_in_prim1906 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MENOSMENOS_in_prim1930 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_IDENT_in_prim1932 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FUNCLEER_in_leer1967 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_LPAR_in_leer1969 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_STRING_in_leer1971 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_COMA_in_leer1973 = new BitSet(new long[]{0x0000000000000000L,0x0000000000080000L});
    public static final BitSet FOLLOW_AMPERSAND_in_leer1975 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_IDENT_in_leer1977 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_RPAR_in_leer1979 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_PUNTOYCOMA_in_leer1981 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FUNCLEER_in_leer2004 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_LPAR_in_leer2006 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_STRING_in_leer2008 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_COMA_in_leer2010 = new BitSet(new long[]{0x0000000000000000L,0x0000000000080000L});
    public static final BitSet FOLLOW_AMPERSAND_in_leer2012 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_IDENT_in_leer2014 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_LCOR_in_leer2016 = new BitSet(new long[]{0x0004800000000000L,0x0000000001F7F880L});
    public static final BitSet FOLLOW_expr_in_leer2018 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_RCOR_in_leer2020 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_RPAR_in_leer2022 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_PUNTOYCOMA_in_leer2024 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FUNCIMPRIMIR_in_imprimir2063 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_LPAR_in_imprimir2065 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_STRING_in_imprimir2067 = new BitSet(new long[]{0x0006800000000000L,0x0000000001F7F880L});
    public static final BitSet FOLLOW_listaExpr_in_imprimir2069 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_RPAR_in_imprimir2071 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_PUNTOYCOMA_in_imprimir2073 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FUNCIMPRIMIR_in_imprimir2096 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_LPAR_in_imprimir2098 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_STRING_in_imprimir2100 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_RPAR_in_imprimir2102 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_PUNTOYCOMA_in_imprimir2104 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_leer_in_funcion_predefinida2136 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_imprimir_in_funcion_predefinida2141 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pow_in_funcion_predefinida2146 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_sqrt_in_funcion_predefinida2152 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_gets_in_funcion_predefinida2158 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_strlen_in_funcion_predefinida2164 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FUNC_POW_in_pow2179 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_LPAR_in_pow2181 = new BitSet(new long[]{0x0004800000000000L,0x0000000001F7F880L});
    public static final BitSet FOLLOW_expr_in_pow2185 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_COMA_in_pow2187 = new BitSet(new long[]{0x0004800000000000L,0x0000000001F7F880L});
    public static final BitSet FOLLOW_expr_in_pow2191 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_RPAR_in_pow2193 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FUNC_SQRT_in_sqrt2216 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_LPAR_in_sqrt2218 = new BitSet(new long[]{0x0004800000000000L,0x0000000001F7F880L});
    public static final BitSet FOLLOW_expr_in_sqrt2220 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_RPAR_in_sqrt2222 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FUNC_GETS_in_gets2241 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_LPAR_in_gets2243 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_IDENT_in_gets2245 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_RPAR_in_gets2247 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FUNC_STRLEN_in_strlen2267 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_LPAR_in_strlen2269 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_IDENT_in_strlen2271 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_RPAR_in_strlen2273 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_define_in_precompilacion2295 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_105_in_define2307 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_106_in_define2309 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_IDENT_in_define2312 = new BitSet(new long[]{0x0004800000000000L,0x0000000001F7F880L});
    public static final BitSet FOLLOW_atom_in_define2314 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IF_in_synpred1_C931 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_LPAR_in_synpred1_C933 = new BitSet(new long[]{0x0004800000000000L,0x0000000001F7F880L});
    public static final BitSet FOLLOW_expr_in_synpred1_C935 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_RPAR_in_synpred1_C937 = new BitSet(new long[]{0x1D64C00000000000L,0x000001F001F7F980L});
    public static final BitSet FOLLOW_sentencia_in_synpred1_C941 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_ELSE_in_synpred1_C944 = new BitSet(new long[]{0x1D64C00000000000L,0x000001F001F7F980L});
    public static final BitSet FOLLOW_sentencia_in_synpred1_C948 = new BitSet(new long[]{0x0000000000000002L});

}