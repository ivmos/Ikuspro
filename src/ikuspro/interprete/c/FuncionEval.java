// $ANTLR 3.1.2 F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\FuncionEval.g 2009-11-20 22:38:59

	package ikuspro.interprete.c;
	import ikuspro.interprete.c.*;
	import ikuspro.interprete.c.ParametroFuncion;
	import java.util.List;
	import java.util.ArrayList;


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class FuncionEval extends TreeParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "PROGRAMA", "DECLARACIONES_GLOBALES", "FUNCIONES", "FUNCION", "CABECERA_FUNCION", "BLOQUE", "DECLARACION_NOMBRE_FUNCION", "LISTA_PARAM_FORMALES", "PARAM_FORMAL", "TIPO_BASE", "NOMBRE_VAR", "NOMBRE_FUNC", "SENTENCIA_ASIG", "SENTENCIA_CALL", "ASIGNACION", "EXPRESION", "LLAMADA", "DEFINE", "VALOR", "INCLUDE", "DECL_VAR", "F_IMPRIMIR", "FORMATO", "F_LEER", "PARAM_ACTUAL", "NEGAR", "SENTENCIAS", "DECLVARS", "POSTFIJO", "PREFIJO", "DECL_VAR_ARR", "LONGITUD", "PARAM_FORMAL_ARR", "ELE_ARR", "INDICE", "DECL", "F_POW", "F_GETS", "F_STRLEN", "F_SQRT", "DECL_VAR_REF", "ASIGNACION_REF", "PUNTOYCOMA", "LPAR", "RPAR", "COMA", "IDENT", "LCOR", "RCOR", "RETURN", "LCURL", "RCURL", "IF", "ELSE", "WHILE", "DO", "FOR", "ASIG", "OR", "AND", "IGUAL", "DISTINTO", "MAYOR", "MENOR", "MENORIGUAL", "MAYORIGUAL", "MAS", "MENOS", "PROD", "DIV", "MOD", "NOT", "INT", "FLOAT", "STRING", "CHAR", "MASMAS", "MENOSMENOS", "FUNCLEER", "AMPERSAND", "FUNCIMPRIMIR", "FUNC_POW", "FUNC_SQRT", "FUNC_GETS", "FUNC_STRLEN", "PUNTO", "EXPONENTE", "WS", "COMENTSIMPLE", "COMENTCOMP", "ESC_SEQ", "HEX_DIGIT", "UNICODE_ESC", "OCTAL_ESC", "LIBRERIA", "IGNORAR", "'void'", "'char'", "'int'", "'float'", "'double'", "'#define'", "'# define'", "'string'"
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
    public static final int T__107=107;
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


        public FuncionEval(TreeNodeStream input) {
            this(input, new RecognizerSharedState());
        }
        public FuncionEval(TreeNodeStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return FuncionEval.tokenNames; }
    public String getGrammarFileName() { return "F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\FuncionEval.g"; }



    // $ANTLR start "programa"
    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\FuncionEval.g:36:1: programa : ( ^( PROGRAMA ^( DECLARACIONES_GLOBALES ( . )* ) ^( FUNCIONES funciones ) . ) | ^( PROGRAMA ^( FUNCIONES funciones ) . ) );
    public final void programa() throws RecognitionException {
        try {
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\FuncionEval.g:37:2: ( ^( PROGRAMA ^( DECLARACIONES_GLOBALES ( . )* ) ^( FUNCIONES funciones ) . ) | ^( PROGRAMA ^( FUNCIONES funciones ) . ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==PROGRAMA) ) {
                int LA2_1 = input.LA(2);

                if ( (LA2_1==DOWN) ) {
                    int LA2_2 = input.LA(3);

                    if ( (LA2_2==DECLARACIONES_GLOBALES) ) {
                        alt2=1;
                    }
                    else if ( (LA2_2==FUNCIONES) ) {
                        alt2=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 2, 2, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\FuncionEval.g:37:4: ^( PROGRAMA ^( DECLARACIONES_GLOBALES ( . )* ) ^( FUNCIONES funciones ) . )
                    {
                    match(input,PROGRAMA,FOLLOW_PROGRAMA_in_programa63); 

                    match(input, Token.DOWN, null); 
                    match(input,DECLARACIONES_GLOBALES,FOLLOW_DECLARACIONES_GLOBALES_in_programa66); 

                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); 
                        // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\FuncionEval.g:37:40: ( . )*
                        loop1:
                        do {
                            int alt1=2;
                            int LA1_0 = input.LA(1);

                            if ( ((LA1_0>=PROGRAMA && LA1_0<=107)) ) {
                                alt1=1;
                            }
                            else if ( (LA1_0==UP) ) {
                                alt1=2;
                            }


                            switch (alt1) {
                        	case 1 :
                        	    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\FuncionEval.g:37:40: .
                        	    {
                        	    matchAny(input); 

                        	    }
                        	    break;

                        	default :
                        	    break loop1;
                            }
                        } while (true);


                        match(input, Token.UP, null); 
                    }
                    match(input,FUNCIONES,FOLLOW_FUNCIONES_in_programa73); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_funciones_in_programa75);
                    funciones();

                    state._fsp--;


                    match(input, Token.UP, null); 
                    matchAny(input); 

                    match(input, Token.UP, null); 

                    }
                    break;
                case 2 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\FuncionEval.g:38:4: ^( PROGRAMA ^( FUNCIONES funciones ) . )
                    {
                    match(input,PROGRAMA,FOLLOW_PROGRAMA_in_programa86); 

                    match(input, Token.DOWN, null); 
                    match(input,FUNCIONES,FOLLOW_FUNCIONES_in_programa89); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_funciones_in_programa91);
                    funciones();

                    state._fsp--;


                    match(input, Token.UP, null); 
                    matchAny(input); 

                    match(input, Token.UP, null); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "programa"


    // $ANTLR start "funciones"
    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\FuncionEval.g:41:1: funciones : ( funcion )+ ;
    public final void funciones() throws RecognitionException {
        try {
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\FuncionEval.g:42:2: ( ( funcion )+ )
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\FuncionEval.g:43:2: ( funcion )+
            {
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\FuncionEval.g:43:2: ( funcion )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==FUNCION) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\FuncionEval.g:43:2: funcion
            	    {
            	    pushFollow(FOLLOW_funcion_in_funciones110);
            	    funcion();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "funciones"


    // $ANTLR start "tipo_base"
    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\FuncionEval.g:49:1: tipo_base returns [String valor] : ( 'void' | 'char' | 'int' | 'float' | 'double' | 'string' );
    public final String tipo_base() throws RecognitionException {
        String valor = null;

        try {
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\FuncionEval.g:50:2: ( 'void' | 'char' | 'int' | 'float' | 'double' | 'string' )
            int alt4=6;
            switch ( input.LA(1) ) {
            case 100:
                {
                alt4=1;
                }
                break;
            case 101:
                {
                alt4=2;
                }
                break;
            case 102:
                {
                alt4=3;
                }
                break;
            case 103:
                {
                alt4=4;
                }
                break;
            case 104:
                {
                alt4=5;
                }
                break;
            case 107:
                {
                alt4=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\FuncionEval.g:50:4: 'void'
                    {
                    match(input,100,FOLLOW_100_in_tipo_base130); 
                     valor = "void"; 

                    }
                    break;
                case 2 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\FuncionEval.g:51:4: 'char'
                    {
                    match(input,101,FOLLOW_101_in_tipo_base137); 
                     valor = "char"; 

                    }
                    break;
                case 3 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\FuncionEval.g:52:5: 'int'
                    {
                    match(input,102,FOLLOW_102_in_tipo_base145); 
                     valor = "int"; 

                    }
                    break;
                case 4 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\FuncionEval.g:53:4: 'float'
                    {
                    match(input,103,FOLLOW_103_in_tipo_base152); 
                     valor = "float"; 

                    }
                    break;
                case 5 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\FuncionEval.g:54:4: 'double'
                    {
                    match(input,104,FOLLOW_104_in_tipo_base159); 
                     valor = "float"; 

                    }
                    break;
                case 6 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\FuncionEval.g:55:4: 'string'
                    {
                    match(input,107,FOLLOW_107_in_tipo_base167); 
                     valor = "string"; 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return valor;
    }
    // $ANTLR end "tipo_base"

    protected static class funcion_scope {
        List<ParametroFuncion> listaParametros;
        // Necesitamos una lista donde guardar los parámetros de la función.
        	String nombre;
        String tipo;
        int ini;
        int fin;
    }
    protected Stack funcion_stack = new Stack();

    public static class funcion_return extends TreeRuleReturnScope {
    };

    // $ANTLR start "funcion"
    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\FuncionEval.g:59:1: funcion : ^( FUNCION ^( CABECERA_FUNCION cabecera_funcion ) . ) ;
    public final FuncionEval.funcion_return funcion() throws RecognitionException {
        funcion_stack.push(new funcion_scope());
        FuncionEval.funcion_return retval = new FuncionEval.funcion_return();
        retval.start = input.LT(1);


        	((funcion_scope)funcion_stack.peek()).listaParametros = new ArrayList<ParametroFuncion>();

        try {
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\FuncionEval.g:105:2: ( ^( FUNCION ^( CABECERA_FUNCION cabecera_funcion ) . ) )
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\FuncionEval.g:105:4: ^( FUNCION ^( CABECERA_FUNCION cabecera_funcion ) . )
            {
            match(input,FUNCION,FOLLOW_FUNCION_in_funcion201); 

             ((funcion_scope)funcion_stack.peek()).ini = input.index();

            match(input, Token.DOWN, null); 
            match(input,CABECERA_FUNCION,FOLLOW_CABECERA_FUNCION_in_funcion206); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_cabecera_funcion_in_funcion208);
            cabecera_funcion();

            state._fsp--;


            match(input, Token.UP, null); 
             ((funcion_scope)funcion_stack.peek()).fin = input.index();
            matchAny(input); 

            match(input, Token.UP, null); 

            }


            	// Guardamos en una variable el nodo que nos interesa del árbol.
            	CommonTree nodoBloque = (CommonTree) ((CommonTree)retval.start).getChild(1);
            	//System.out.println("INDEX : " + String.valueOf(input.index())); 
            	int i = ((funcion_scope)funcion_stack.peek()).ini;
            	boolean encontrado = false;
            	
            	// Sabemos el nodo que queremos pero no sabemos el índice.
            	// Lo que sí sabemos son los índices entre los que acotar la búsquera, inicio y fín
            	// de la función, y también sabemos lo que hay que buscar. 
            	// Menos mal porque de lo contrario sería inviable por lo ineficiente.
            	// En versiones anteriores de ANTLR había métodos que hacían esto directamente pero ya no por
            	// cuestiones de eficiencia. De hecho muchos ejemplos de intérpretes que hay en la WEB para 
            	// Antlr no son funcionales por esta razón.
            	// Es posible que haya una forma más eficiente de hacer esto pero yo no la he encontrado.
            	while(!encontrado && i <= ((funcion_scope)funcion_stack.peek()).fin) {
            		if (input.get(i) == nodoBloque) {
            			encontrado = true;
            		} else {
            			i++;
            		}
            	}
            	// Los System.out residuales no son recomendables pero en algunos casos los mantenemos comentados
            	// porque son tremendamente útiles de cara a debuggear el intérprete.
            	//System.out.println("TREE : " + nodoBloque.toStringTree());
            	
            	// Aquí es donde finalmente declaramos la función con la información que tenemos.
            	Interprete.getTablaSimbolos().declararFuncion(((funcion_scope)funcion_stack.peek()).nombre,((funcion_scope)funcion_stack.peek()).tipo, ((funcion_scope)funcion_stack.peek()).listaParametros, nodoBloque, i);
            	

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            funcion_stack.pop();
        }
        return retval;
    }
    // $ANTLR end "funcion"

    public static class cabecera_funcion_return extends TreeRuleReturnScope {
        public String nombre;
        public String tipo;
    };

    // $ANTLR start "cabecera_funcion"
    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\FuncionEval.g:116:1: cabecera_funcion returns [String nombre, String tipo] : declaracion_nombre_funcion ( lista_param_formales )? ;
    public final FuncionEval.cabecera_funcion_return cabecera_funcion() throws RecognitionException {
        FuncionEval.cabecera_funcion_return retval = new FuncionEval.cabecera_funcion_return();
        retval.start = input.LT(1);

        FuncionEval.declaracion_nombre_funcion_return declaracion_nombre_funcion1 = null;


        try {
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\FuncionEval.g:117:2: ( declaracion_nombre_funcion ( lista_param_formales )? )
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\FuncionEval.g:118:2: declaracion_nombre_funcion ( lista_param_formales )?
            {
            pushFollow(FOLLOW_declaracion_nombre_funcion_in_cabecera_funcion254);
            declaracion_nombre_funcion1=declaracion_nombre_funcion();

            state._fsp--;

            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\FuncionEval.g:118:29: ( lista_param_formales )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==PARAM_FORMAL||LA5_0==PARAM_FORMAL_ARR) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\FuncionEval.g:118:29: lista_param_formales
                    {
                    pushFollow(FOLLOW_lista_param_formales_in_cabecera_funcion256);
                    lista_param_formales();

                    state._fsp--;


                    }
                    break;

            }

             ((funcion_scope)funcion_stack.peek()).nombre = (declaracion_nombre_funcion1!=null?declaracion_nombre_funcion1.nombre:null); ((funcion_scope)funcion_stack.peek()).tipo = (declaracion_nombre_funcion1!=null?declaracion_nombre_funcion1.tipo:null); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "cabecera_funcion"

    public static class declaracion_nombre_funcion_return extends TreeRuleReturnScope {
        public String nombre;
        public String tipo;
    };

    // $ANTLR start "declaracion_nombre_funcion"
    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\FuncionEval.g:123:1: declaracion_nombre_funcion returns [String nombre, String tipo] : ( ^( DECLARACION_NOMBRE_FUNCION ^( NOMBRE_FUNC IDENT ) ) | ^( DECLARACION_NOMBRE_FUNCION ^( TIPO_BASE tipo_base ) ^( NOMBRE_FUNC IDENT ) ) );
    public final FuncionEval.declaracion_nombre_funcion_return declaracion_nombre_funcion() throws RecognitionException {
        FuncionEval.declaracion_nombre_funcion_return retval = new FuncionEval.declaracion_nombre_funcion_return();
        retval.start = input.LT(1);

        CommonTree IDENT2=null;
        CommonTree IDENT3=null;
        String tipo_base4 = null;


        try {
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\FuncionEval.g:124:2: ( ^( DECLARACION_NOMBRE_FUNCION ^( NOMBRE_FUNC IDENT ) ) | ^( DECLARACION_NOMBRE_FUNCION ^( TIPO_BASE tipo_base ) ^( NOMBRE_FUNC IDENT ) ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==DECLARACION_NOMBRE_FUNCION) ) {
                int LA6_1 = input.LA(2);

                if ( (LA6_1==DOWN) ) {
                    int LA6_2 = input.LA(3);

                    if ( (LA6_2==NOMBRE_FUNC) ) {
                        alt6=1;
                    }
                    else if ( (LA6_2==TIPO_BASE) ) {
                        alt6=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 6, 2, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 6, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\FuncionEval.g:124:4: ^( DECLARACION_NOMBRE_FUNCION ^( NOMBRE_FUNC IDENT ) )
                    {
                    match(input,DECLARACION_NOMBRE_FUNCION,FOLLOW_DECLARACION_NOMBRE_FUNCION_in_declaracion_nombre_funcion280); 

                    match(input, Token.DOWN, null); 
                    match(input,NOMBRE_FUNC,FOLLOW_NOMBRE_FUNC_in_declaracion_nombre_funcion283); 

                    match(input, Token.DOWN, null); 
                    IDENT2=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_declaracion_nombre_funcion285); 

                    match(input, Token.UP, null); 

                    match(input, Token.UP, null); 
                     retval.nombre = (IDENT2!=null?IDENT2.getText():null); retval.tipo = "void"; ((funcion_scope)funcion_stack.peek()).tipo = retval.tipo;

                    }
                    break;
                case 2 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\FuncionEval.g:125:4: ^( DECLARACION_NOMBRE_FUNCION ^( TIPO_BASE tipo_base ) ^( NOMBRE_FUNC IDENT ) )
                    {
                    match(input,DECLARACION_NOMBRE_FUNCION,FOLLOW_DECLARACION_NOMBRE_FUNCION_in_declaracion_nombre_funcion295); 

                    match(input, Token.DOWN, null); 
                    match(input,TIPO_BASE,FOLLOW_TIPO_BASE_in_declaracion_nombre_funcion298); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_tipo_base_in_declaracion_nombre_funcion300);
                    tipo_base4=tipo_base();

                    state._fsp--;


                    match(input, Token.UP, null); 
                    match(input,NOMBRE_FUNC,FOLLOW_NOMBRE_FUNC_in_declaracion_nombre_funcion305); 

                    match(input, Token.DOWN, null); 
                    IDENT3=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_declaracion_nombre_funcion307); 

                    match(input, Token.UP, null); 

                    match(input, Token.UP, null); 
                     retval.nombre = (IDENT3!=null?IDENT3.getText():null); retval.tipo = tipo_base4; ((funcion_scope)funcion_stack.peek()).tipo = retval.tipo;

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "declaracion_nombre_funcion"


    // $ANTLR start "lista_param_formales"
    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\FuncionEval.g:129:1: lista_param_formales : param_formal ( param_formal )* ;
    public final void lista_param_formales() throws RecognitionException {
        try {
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\FuncionEval.g:130:2: ( param_formal ( param_formal )* )
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\FuncionEval.g:130:4: param_formal ( param_formal )*
            {
            pushFollow(FOLLOW_param_formal_in_lista_param_formales330);
            param_formal();

            state._fsp--;

            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\FuncionEval.g:130:17: ( param_formal )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==PARAM_FORMAL||LA7_0==PARAM_FORMAL_ARR) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\FuncionEval.g:130:19: param_formal
            	    {
            	    pushFollow(FOLLOW_param_formal_in_lista_param_formales334);
            	    param_formal();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "lista_param_formales"


    // $ANTLR start "param_formal"
    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\FuncionEval.g:138:1: param_formal : ( ^( PARAM_FORMAL ^( TIPO_BASE tipo_base ) ^( NOMBRE_VAR IDENT ) ) | ^( PARAM_FORMAL_ARR ^( TIPO_BASE tipo_base ) ^( NOMBRE_VAR IDENT ) ) );
    public final void param_formal() throws RecognitionException {
        CommonTree IDENT5=null;
        CommonTree IDENT7=null;
        String tipo_base6 = null;

        String tipo_base8 = null;


        try {
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\FuncionEval.g:139:2: ( ^( PARAM_FORMAL ^( TIPO_BASE tipo_base ) ^( NOMBRE_VAR IDENT ) ) | ^( PARAM_FORMAL_ARR ^( TIPO_BASE tipo_base ) ^( NOMBRE_VAR IDENT ) ) )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==PARAM_FORMAL) ) {
                alt8=1;
            }
            else if ( (LA8_0==PARAM_FORMAL_ARR) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\FuncionEval.g:140:3: ^( PARAM_FORMAL ^( TIPO_BASE tipo_base ) ^( NOMBRE_VAR IDENT ) )
                    {
                    match(input,PARAM_FORMAL,FOLLOW_PARAM_FORMAL_in_param_formal357); 

                    match(input, Token.DOWN, null); 
                    match(input,TIPO_BASE,FOLLOW_TIPO_BASE_in_param_formal360); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_tipo_base_in_param_formal362);
                    tipo_base6=tipo_base();

                    state._fsp--;


                    match(input, Token.UP, null); 
                    match(input,NOMBRE_VAR,FOLLOW_NOMBRE_VAR_in_param_formal366); 

                    match(input, Token.DOWN, null); 
                    IDENT5=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_param_formal368); 

                    match(input, Token.UP, null); 

                    match(input, Token.UP, null); 
                     ((funcion_scope)funcion_stack.peek()).listaParametros.add(new ParametroFuncion((IDENT5!=null?IDENT5.getText():null),tipo_base6)); 
                    		

                    }
                    break;
                case 2 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\FuncionEval.g:143:4: ^( PARAM_FORMAL_ARR ^( TIPO_BASE tipo_base ) ^( NOMBRE_VAR IDENT ) )
                    {
                    match(input,PARAM_FORMAL_ARR,FOLLOW_PARAM_FORMAL_ARR_in_param_formal381); 

                    match(input, Token.DOWN, null); 
                    match(input,TIPO_BASE,FOLLOW_TIPO_BASE_in_param_formal384); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_tipo_base_in_param_formal386);
                    tipo_base8=tipo_base();

                    state._fsp--;


                    match(input, Token.UP, null); 
                    match(input,NOMBRE_VAR,FOLLOW_NOMBRE_VAR_in_param_formal390); 

                    match(input, Token.DOWN, null); 
                    IDENT7=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_param_formal392); 

                    match(input, Token.UP, null); 

                    match(input, Token.UP, null); 
                     ((funcion_scope)funcion_stack.peek()).listaParametros.add(new ParametroFuncion((IDENT7!=null?IDENT7.getText():null),tipo_base8,true)); 
                    		  //System.out.println("El parametro es un array");
                    		

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "param_formal"

    // Delegated rules


 

    public static final BitSet FOLLOW_PROGRAMA_in_programa63 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_DECLARACIONES_GLOBALES_in_programa66 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_FUNCIONES_in_programa73 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_funciones_in_programa75 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PROGRAMA_in_programa86 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_FUNCIONES_in_programa89 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_funciones_in_programa91 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_funcion_in_funciones110 = new BitSet(new long[]{0x0000000000000082L});
    public static final BitSet FOLLOW_100_in_tipo_base130 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_101_in_tipo_base137 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_102_in_tipo_base145 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_103_in_tipo_base152 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_104_in_tipo_base159 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_107_in_tipo_base167 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FUNCION_in_funcion201 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_CABECERA_FUNCION_in_funcion206 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cabecera_funcion_in_funcion208 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_declaracion_nombre_funcion_in_cabecera_funcion254 = new BitSet(new long[]{0x0000001000001002L});
    public static final BitSet FOLLOW_lista_param_formales_in_cabecera_funcion256 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DECLARACION_NOMBRE_FUNCION_in_declaracion_nombre_funcion280 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_NOMBRE_FUNC_in_declaracion_nombre_funcion283 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_declaracion_nombre_funcion285 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DECLARACION_NOMBRE_FUNCION_in_declaracion_nombre_funcion295 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_TIPO_BASE_in_declaracion_nombre_funcion298 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_tipo_base_in_declaracion_nombre_funcion300 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NOMBRE_FUNC_in_declaracion_nombre_funcion305 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_declaracion_nombre_funcion307 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_param_formal_in_lista_param_formales330 = new BitSet(new long[]{0x0000001000001002L});
    public static final BitSet FOLLOW_param_formal_in_lista_param_formales334 = new BitSet(new long[]{0x0000001000001002L});
    public static final BitSet FOLLOW_PARAM_FORMAL_in_param_formal357 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_TIPO_BASE_in_param_formal360 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_tipo_base_in_param_formal362 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NOMBRE_VAR_in_param_formal366 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_param_formal368 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PARAM_FORMAL_ARR_in_param_formal381 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_TIPO_BASE_in_param_formal384 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_tipo_base_in_param_formal386 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NOMBRE_VAR_in_param_formal390 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_param_formal392 = new BitSet(new long[]{0x0000000000000008L});

}