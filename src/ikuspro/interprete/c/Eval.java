// $ANTLR 3.1.2 F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g 2009-11-20 22:45:59

	package ikuspro.interprete.c;
	import ikuspro.interprete.c.*;
	import ikuspro.simulador.*;
	import java.util.HashMap;
	import java.io.*;
	import java.util.Properties;
	import java.util.Iterator;
	import ikuspro.gui.*;
	import javax.swing.JOptionPane;
	import java.lang.reflect.InvocationTargetException;
	


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
public class Eval extends TreeParser {
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


        public Eval(TreeNodeStream input) {
            this(input, new RecognizerSharedState());
        }
        public Eval(TreeNodeStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return Eval.tokenNames; }
    public String getGrammarFileName() { return "F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g"; }


    	
    	BufferedTreeNodeStream flujo = (BufferedTreeNodeStream) input; // El input en realidad se entiende mejor como flujo.
    									// Es el flujo de ejecución.
    	
    	Interprete interprete; // Necesitaremos referencia a la clase interprete para algunas cosas.
    	
    	String texto; // Por necesidad de tener referencias globales tenemos algunos atributos que ahora pueden no parecer
    		      // tener sentido pero sí luego.
    	
    	private String entrada;
    	
    	// Un constructor personalizado para poder recibir la referencia al interprete
    	public Eval(TreeNodeStream input, Interprete pInterprete) {
    		this(input);
    		interprete = pInterprete;
    		texto = "";
    	}
       	
       	// Mada al interprete que lea la entrada estándar para cierta variable de nombre pNombre
       	public String leerStdin(String pNombre) {
       		return interprete.leerStdin(pNombre);
       	}	
        	
        	// Lo que hacemos en Eval es ir formando Strings con el XML correspondiente a lo que se va
        	// interpretando. Es decir, un compilador suele generar código máquina y un intérprete suele 
        	// limitarse a ir interpretando las acciones.
        	// En nuestro caso nuestro intérprete hace más cosas que un intérprete al uso ya que se va explicando
        	// diciendo paso a paso con XML lo que va haciendo y la línea en que está. Esto servirá para que Ikuspro realice la 
        	// simulación gráfica.
        	
        	// Salida estándar
       	public void echo(String pString) {
       		interprete.enviar("<salida><texto>" + pString + "</texto></salida>");
       	}
       	
       	// Método genérico para mandar XML.
       	public void enviar(String pString) {
       		interprete.enviar(pString);
       	}
       	
       	// Notificar línea 
       	public void enviarLinea(int pNum) {
       		interprete.enviar("<linea><num>" + pNum + "</num></linea>");
       	}
       	



    // $ANTLR start "programa"
    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:88:1: programa : ( ^( PROGRAMA ^( DECLARACIONES_GLOBALES declaraciones_globales ) ^( FUNCIONES ( . )* ) llamada ) | ^( PROGRAMA ^( FUNCIONES ( . )* ) llamada ) );
    public final void programa() throws RecognitionException {

        	

        try {
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:96:2: ( ^( PROGRAMA ^( DECLARACIONES_GLOBALES declaraciones_globales ) ^( FUNCIONES ( . )* ) llamada ) | ^( PROGRAMA ^( FUNCIONES ( . )* ) llamada ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==PROGRAMA) ) {
                int LA3_1 = input.LA(2);

                if ( (LA3_1==DOWN) ) {
                    int LA3_2 = input.LA(3);

                    if ( (LA3_2==DECLARACIONES_GLOBALES) ) {
                        alt3=1;
                    }
                    else if ( (LA3_2==FUNCIONES) ) {
                        alt3=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 3, 2, input);

                        throw nvae;
                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 3, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:96:4: ^( PROGRAMA ^( DECLARACIONES_GLOBALES declaraciones_globales ) ^( FUNCIONES ( . )* ) llamada )
                    {
                    match(input,PROGRAMA,FOLLOW_PROGRAMA_in_programa76); if (state.failed) return ;

                    if ( state.backtracking==0 ) {
                       /***/ 
                    }

                    match(input, Token.DOWN, null); if (state.failed) return ;
                    match(input,DECLARACIONES_GLOBALES,FOLLOW_DECLARACIONES_GLOBALES_in_programa81); if (state.failed) return ;

                    match(input, Token.DOWN, null); if (state.failed) return ;
                    pushFollow(FOLLOW_declaraciones_globales_in_programa83);
                    declaraciones_globales();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input, Token.UP, null); if (state.failed) return ;
                    match(input,FUNCIONES,FOLLOW_FUNCIONES_in_programa87); if (state.failed) return ;

                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); if (state.failed) return ;
                        // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:96:86: ( . )*
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
                        	    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:96:86: .
                        	    {
                        	    matchAny(input); if (state.failed) return ;

                        	    }
                        	    break;

                        	default :
                        	    break loop1;
                            }
                        } while (true);


                        match(input, Token.UP, null); if (state.failed) return ;
                    }
                    pushFollow(FOLLOW_llamada_in_programa93);
                    llamada();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input, Token.UP, null); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:97:4: ^( PROGRAMA ^( FUNCIONES ( . )* ) llamada )
                    {
                    match(input,PROGRAMA,FOLLOW_PROGRAMA_in_programa104); if (state.failed) return ;

                    if ( state.backtracking==0 ) {
                       /***/ 
                    }

                    match(input, Token.DOWN, null); if (state.failed) return ;
                    match(input,FUNCIONES,FOLLOW_FUNCIONES_in_programa109); if (state.failed) return ;

                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); if (state.failed) return ;
                        // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:97:37: ( . )*
                        loop2:
                        do {
                            int alt2=2;
                            int LA2_0 = input.LA(1);

                            if ( ((LA2_0>=PROGRAMA && LA2_0<=107)) ) {
                                alt2=1;
                            }
                            else if ( (LA2_0==UP) ) {
                                alt2=2;
                            }


                            switch (alt2) {
                        	case 1 :
                        	    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:97:37: .
                        	    {
                        	    matchAny(input); if (state.failed) return ;

                        	    }
                        	    break;

                        	default :
                        	    break loop2;
                            }
                        } while (true);


                        match(input, Token.UP, null); if (state.failed) return ;
                    }
                    pushFollow(FOLLOW_llamada_in_programa115);
                    llamada();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input, Token.UP, null); if (state.failed) return ;

                    }
                    break;

            }
            if ( state.backtracking==0 ) {

              	

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


    // $ANTLR start "declaraciones_globales"
    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:101:1: declaraciones_globales : ( declaracion_global )+ ;
    public final void declaraciones_globales() throws RecognitionException {

        	/////////

        try {
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:109:2: ( ( declaracion_global )+ )
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:110:2: ( declaracion_global )+
            {
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:110:2: ( declaracion_global )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==DEFINE) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:110:2: declaracion_global
            	    {
            	    pushFollow(FOLLOW_declaracion_global_in_declaraciones_globales144);
            	    declaracion_global();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    if ( cnt4 >= 1 ) break loop4;
            	    if (state.backtracking>0) {state.failed=true; return ;}
                        EarlyExitException eee =
                            new EarlyExitException(4, input);
                        throw eee;
                }
                cnt4++;
            } while (true);


            }

            if ( state.backtracking==0 ) {

              	/////////////

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
    // $ANTLR end "declaraciones_globales"


    // $ANTLR start "tipo_base"
    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:116:1: tipo_base returns [String valor] : ( 'void' | 'char' | 'int' | 'float' | 'double' | 'string' );
    public final String tipo_base() throws RecognitionException {
        String valor = null;


        	

        try {
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:124:2: ( 'void' | 'char' | 'int' | 'float' | 'double' | 'string' )
            int alt5=6;
            switch ( input.LA(1) ) {
            case 100:
                {
                alt5=1;
                }
                break;
            case 101:
                {
                alt5=2;
                }
                break;
            case 102:
                {
                alt5=3;
                }
                break;
            case 103:
                {
                alt5=4;
                }
                break;
            case 104:
                {
                alt5=5;
                }
                break;
            case 107:
                {
                alt5=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return valor;}
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:124:4: 'void'
                    {
                    match(input,100,FOLLOW_100_in_tipo_base176); if (state.failed) return valor;
                    if ( state.backtracking==0 ) {
                       valor = "void"; 
                    }

                    }
                    break;
                case 2 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:125:4: 'char'
                    {
                    match(input,101,FOLLOW_101_in_tipo_base183); if (state.failed) return valor;
                    if ( state.backtracking==0 ) {
                       valor = "char"; 
                    }

                    }
                    break;
                case 3 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:126:5: 'int'
                    {
                    match(input,102,FOLLOW_102_in_tipo_base191); if (state.failed) return valor;
                    if ( state.backtracking==0 ) {
                       valor = "int"; 
                    }

                    }
                    break;
                case 4 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:127:4: 'float'
                    {
                    match(input,103,FOLLOW_103_in_tipo_base198); if (state.failed) return valor;
                    if ( state.backtracking==0 ) {
                       valor = "float"; 
                    }

                    }
                    break;
                case 5 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:128:4: 'double'
                    {
                    match(input,104,FOLLOW_104_in_tipo_base205); if (state.failed) return valor;
                    if ( state.backtracking==0 ) {
                       valor = "float"; /* Lo dicho en FuncionEval */ 
                    }

                    }
                    break;
                case 6 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:129:4: 'string'
                    {
                    match(input,107,FOLLOW_107_in_tipo_base212); if (state.failed) return valor;
                    if ( state.backtracking==0 ) {
                       valor = "string"; 
                    }

                    }
                    break;

            }
            if ( state.backtracking==0 ) {

              	

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


    // $ANTLR start "declaracion_global"
    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:133:1: declaracion_global : precompilacion ;
    public final void declaracion_global() throws RecognitionException {

        	

        try {
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:141:2: ( precompilacion )
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:141:4: precompilacion
            {
            pushFollow(FOLLOW_precompilacion_in_declaracion_global238);
            precompilacion();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {

              	

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
    // $ANTLR end "declaracion_global"


    // $ANTLR start "sentencia"
    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:147:1: sentencia : ( bloque | ^( RETURN expr ) | sentencia_asignacion | llamada | prim | funcion_predefinida | sentenciaIF | sentenciaWHILE );
    public final void sentencia() throws RecognitionException {
        Valor expr1 = null;



        	// Puede que estemos dentro de una función. Si no lo estamos no hacemos nada pero sino hay que evaluar desde ese indice.
        	try{
        		if(! ((llamada_scope)llamada_stack.peek()).ejecutable){
                        	matchAny(flujo);
                        	return;
                	}
                } catch(java.util.EmptyStackException ignore){
                	// Hay algunas excepciones que nos permitimos la licencia de ignorar
                	// En este caso esta excepción aparece cuando no estamos en una funcion por lo que 
                	// el atributo ::ejecutable no está accesible.
                	
                }


        	

        try {
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:171:2: ( bloque | ^( RETURN expr ) | sentencia_asignacion | llamada | prim | funcion_predefinida | sentenciaIF | sentenciaWHILE )
            int alt6=8;
            switch ( input.LA(1) ) {
            case BLOQUE:
                {
                alt6=1;
                }
                break;
            case RETURN:
                {
                alt6=2;
                }
                break;
            case SENTENCIA_ASIG:
                {
                alt6=3;
                }
                break;
            case LLAMADA:
                {
                alt6=4;
                }
                break;
            case POSTFIJO:
            case PREFIJO:
                {
                alt6=5;
                }
                break;
            case F_IMPRIMIR:
            case F_LEER:
            case F_POW:
            case F_GETS:
            case F_STRLEN:
            case F_SQRT:
                {
                alt6=6;
                }
                break;
            case IF:
                {
                alt6=7;
                }
                break;
            case WHILE:
                {
                alt6=8;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:172:4: bloque
                    {
                    pushFollow(FOLLOW_bloque_in_sentencia271);
                    bloque();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:173:4: ^( RETURN expr )
                    {
                    match(input,RETURN,FOLLOW_RETURN_in_sentencia277); if (state.failed) return ;

                    match(input, Token.DOWN, null); if (state.failed) return ;
                    pushFollow(FOLLOW_expr_in_sentencia279);
                    expr1=expr();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input, Token.UP, null); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      ((llamada_scope)llamada_stack.peek()).valorRetorno =expr1; ((llamada_scope)llamada_stack.peek()).ejecutable =false;
                    }

                    }
                    break;
                case 3 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:174:4: sentencia_asignacion
                    {
                    pushFollow(FOLLOW_sentencia_asignacion_in_sentencia287);
                    sentencia_asignacion();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 4 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:175:4: llamada
                    {
                    pushFollow(FOLLOW_llamada_in_sentencia292);
                    llamada();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 5 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:176:4: prim
                    {
                    pushFollow(FOLLOW_prim_in_sentencia297);
                    prim();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 6 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:177:4: funcion_predefinida
                    {
                    pushFollow(FOLLOW_funcion_predefinida_in_sentencia302);
                    funcion_predefinida();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 7 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:178:4: sentenciaIF
                    {
                    pushFollow(FOLLOW_sentenciaIF_in_sentencia307);
                    sentenciaIF();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 8 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:179:4: sentenciaWHILE
                    {
                    pushFollow(FOLLOW_sentenciaWHILE_in_sentencia312);
                    sentenciaWHILE();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }
            if ( state.backtracking==0 ) {

              	///////////
              	

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
    // $ANTLR end "sentencia"

    protected static class bloque_scope {
        int linea;
    }
    protected Stack bloque_stack = new Stack();


    // $ANTLR start "bloque"
    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:183:1: bloque : ^( BLOQUE ( elemento_bloque )* ) ;
    public final void bloque() throws RecognitionException {
        bloque_stack.push(new bloque_scope());
        CommonTree BLOQUE2=null;


        	
        	Interprete.getTablaSimbolos().entrar();

        try {
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:195:2: ( ^( BLOQUE ( elemento_bloque )* ) )
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:196:2: ^( BLOQUE ( elemento_bloque )* )
            {
            BLOQUE2=(CommonTree)match(input,BLOQUE,FOLLOW_BLOQUE_in_bloque342); if (state.failed) return ;

            if ( state.backtracking==0 ) {
               enviar("<ini_bloque><linea>" + (BLOQUE2!=null?BLOQUE2.getLine():0) + "</linea></ini_bloque>");
            }

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return ;
                // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:196:86: ( elemento_bloque )*
                loop7:
                do {
                    int alt7=2;
                    int LA7_0 = input.LA(1);

                    if ( (LA7_0==BLOQUE||LA7_0==SENTENCIA_ASIG||LA7_0==LLAMADA||LA7_0==F_IMPRIMIR||LA7_0==F_LEER||(LA7_0>=POSTFIJO && LA7_0<=PREFIJO)||(LA7_0>=DECL && LA7_0<=F_SQRT)||LA7_0==RETURN||LA7_0==IF||LA7_0==WHILE) ) {
                        alt7=1;
                    }


                    switch (alt7) {
                	case 1 :
                	    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:196:86: elemento_bloque
                	    {
                	    pushFollow(FOLLOW_elemento_bloque_in_bloque346);
                	    elemento_bloque();

                	    state._fsp--;
                	    if (state.failed) return ;

                	    }
                	    break;

                	default :
                	    break loop7;
                    }
                } while (true);


                match(input, Token.UP, null); if (state.failed) return ;
            }

            }

            if ( state.backtracking==0 ) {

              	enviar("<fin_bloque></fin_bloque>");
              	Interprete.getTablaSimbolos().salir();

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            bloque_stack.pop();
        }
        return ;
    }
    // $ANTLR end "bloque"


    // $ANTLR start "elemento_bloque"
    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:199:1: elemento_bloque : ( declaracion_variables | sentencia );
    public final void elemento_bloque() throws RecognitionException {
        try {
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:200:2: ( declaracion_variables | sentencia )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==DECL) ) {
                alt8=1;
            }
            else if ( (LA8_0==BLOQUE||LA8_0==SENTENCIA_ASIG||LA8_0==LLAMADA||LA8_0==F_IMPRIMIR||LA8_0==F_LEER||(LA8_0>=POSTFIJO && LA8_0<=PREFIJO)||(LA8_0>=F_POW && LA8_0<=F_SQRT)||LA8_0==RETURN||LA8_0==IF||LA8_0==WHILE) ) {
                alt8=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:200:4: declaracion_variables
                    {
                    pushFollow(FOLLOW_declaracion_variables_in_elemento_bloque360);
                    declaracion_variables();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:201:4: sentencia
                    {
                    pushFollow(FOLLOW_sentencia_in_elemento_bloque365);
                    sentencia();

                    state._fsp--;
                    if (state.failed) return ;

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
    // $ANTLR end "elemento_bloque"

    protected static class declaracion_variables_scope {
        String tipo;
        String nombre;
        Integer longitud;
    }
    protected Stack declaracion_variables_stack = new Stack();


    // $ANTLR start "declaracion_variables"
    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:205:1: declaracion_variables : ^( DECL tipo_base ( declaracion_var_asig )+ ) ;
    public final void declaracion_variables() throws RecognitionException {
        declaracion_variables_stack.push(new declaracion_variables_scope());
        String tipo_base3 = null;




        	((declaracion_variables_scope)declaracion_variables_stack.peek()).longitud = -1; // Muchas veces se usa -1 como flag

        try {
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:220:2: ( ^( DECL tipo_base ( declaracion_var_asig )+ ) )
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:221:3: ^( DECL tipo_base ( declaracion_var_asig )+ )
            {
            match(input,DECL,FOLLOW_DECL_in_declaracion_variables398); if (state.failed) return ;

            match(input, Token.DOWN, null); if (state.failed) return ;
            pushFollow(FOLLOW_tipo_base_in_declaracion_variables400);
            tipo_base3=tipo_base();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
              ((declaracion_variables_scope)declaracion_variables_stack.peek()).tipo = tipo_base3; 
            }
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:221:72: ( declaracion_var_asig )+
            int cnt9=0;
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==DECL_VAR||LA9_0==DECL_VAR_ARR||LA9_0==DECL_VAR_REF) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:221:72: declaracion_var_asig
            	    {
            	    pushFollow(FOLLOW_declaracion_var_asig_in_declaracion_variables404);
            	    declaracion_var_asig();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    if ( cnt9 >= 1 ) break loop9;
            	    if (state.backtracking>0) {state.failed=true; return ;}
                        EarlyExitException eee =
                            new EarlyExitException(9, input);
                        throw eee;
                }
                cnt9++;
            } while (true);


            match(input, Token.UP, null); if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {



            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            declaracion_variables_stack.pop();
        }
        return ;
    }
    // $ANTLR end "declaracion_variables"

    protected static class declaracion_var_asig_scope {
        String tipo;
    }
    protected Stack declaracion_var_asig_stack = new Stack();


    // $ANTLR start "declaracion_var_asig"
    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:224:1: declaracion_var_asig : declaracion_variable ( asignacion )? ;
    public final void declaracion_var_asig() throws RecognitionException {
        declaracion_var_asig_stack.push(new declaracion_var_asig_scope());

        	((declaracion_var_asig_scope)declaracion_var_asig_stack.peek()).tipo = ((declaracion_variables_scope)declaracion_variables_stack.peek()).tipo;


        try {
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:233:2: ( declaracion_variable ( asignacion )? )
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:233:5: declaracion_variable ( asignacion )?
            {
            pushFollow(FOLLOW_declaracion_variable_in_declaracion_var_asig430);
            declaracion_variable();

            state._fsp--;
            if (state.failed) return ;
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:233:26: ( asignacion )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==ASIGNACION||LA10_0==ASIGNACION_REF) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:233:26: asignacion
                    {
                    pushFollow(FOLLOW_asignacion_in_declaracion_var_asig432);
                    asignacion();

                    state._fsp--;
                    if (state.failed) return ;

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
            declaracion_var_asig_stack.pop();
        }
        return ;
    }
    // $ANTLR end "declaracion_var_asig"

    protected static class declaracion_variable_scope {
        String nombre;
        Integer longitud;
    }
    protected Stack declaracion_variable_stack = new Stack();


    // $ANTLR start "declaracion_variable"
    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:237:1: declaracion_variable : ( ^( DECL_VAR ^( NOMBRE_VAR a= IDENT ) ) | ^( DECL_VAR_ARR ^( NOMBRE_VAR a= IDENT ) ^( LONGITUD expr ) ) | ^( DECL_VAR_REF ^( NOMBRE_VAR a= IDENT ) ) );
    public final void declaracion_variable() throws RecognitionException {
        declaracion_variable_stack.push(new declaracion_variable_scope());
        CommonTree a=null;
        Valor expr4 = null;



        	((declaracion_variable_scope)declaracion_variable_stack.peek()).nombre = "";
        	((declaracion_variables_scope)declaracion_variables_stack.peek()).longitud = -1;
        	((declaracion_variable_scope)declaracion_variable_stack.peek()).longitud = -1;


        try {
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:250:2: ( ^( DECL_VAR ^( NOMBRE_VAR a= IDENT ) ) | ^( DECL_VAR_ARR ^( NOMBRE_VAR a= IDENT ) ^( LONGITUD expr ) ) | ^( DECL_VAR_REF ^( NOMBRE_VAR a= IDENT ) ) )
            int alt11=3;
            switch ( input.LA(1) ) {
            case DECL_VAR:
                {
                alt11=1;
                }
                break;
            case DECL_VAR_ARR:
                {
                alt11=2;
                }
                break;
            case DECL_VAR_REF:
                {
                alt11=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }

            switch (alt11) {
                case 1 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:250:4: ^( DECL_VAR ^( NOMBRE_VAR a= IDENT ) )
                    {
                    match(input,DECL_VAR,FOLLOW_DECL_VAR_in_declaracion_variable456); if (state.failed) return ;

                    match(input, Token.DOWN, null); if (state.failed) return ;
                    match(input,NOMBRE_VAR,FOLLOW_NOMBRE_VAR_in_declaracion_variable459); if (state.failed) return ;

                    match(input, Token.DOWN, null); if (state.failed) return ;
                    a=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_declaracion_variable463); if (state.failed) return ;

                    match(input, Token.UP, null); if (state.failed) return ;

                    match(input, Token.UP, null); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       
                      		  ((declaracion_variable_scope)declaracion_variable_stack.peek()).nombre = (a!=null?a.getText():null);
                      		  ((declaracion_variables_scope)declaracion_variables_stack.peek()).nombre = ((declaracion_variable_scope)declaracion_variable_stack.peek()).nombre;
                      		  Interprete.getTablaSimbolos().declararVariable((a!=null?a.getText():null), ((declaracion_variables_scope)declaracion_variables_stack.peek()).tipo); 
                      		  enviar("<variable><nombre>" + (a!=null?a.getText():null) + "</nombre><tipo>" + ((declaracion_variables_scope)declaracion_variables_stack.peek()).tipo 
                      		  	+ "</tipo><linea>" + (a!=null?a.getLine():0) + "</linea></variable>");
                      		
                    }

                    }
                    break;
                case 2 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:258:4: ^( DECL_VAR_ARR ^( NOMBRE_VAR a= IDENT ) ^( LONGITUD expr ) )
                    {
                    match(input,DECL_VAR_ARR,FOLLOW_DECL_VAR_ARR_in_declaracion_variable476); if (state.failed) return ;

                    match(input, Token.DOWN, null); if (state.failed) return ;
                    match(input,NOMBRE_VAR,FOLLOW_NOMBRE_VAR_in_declaracion_variable479); if (state.failed) return ;

                    match(input, Token.DOWN, null); if (state.failed) return ;
                    a=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_declaracion_variable483); if (state.failed) return ;

                    match(input, Token.UP, null); if (state.failed) return ;
                    match(input,LONGITUD,FOLLOW_LONGITUD_in_declaracion_variable487); if (state.failed) return ;

                    match(input, Token.DOWN, null); if (state.failed) return ;
                    pushFollow(FOLLOW_expr_in_declaracion_variable489);
                    expr4=expr();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input, Token.UP, null); if (state.failed) return ;

                    match(input, Token.UP, null); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      		  ((declaracion_variable_scope)declaracion_variable_stack.peek()).nombre = (a!=null?a.getText():null);
                      		  ((declaracion_variables_scope)declaracion_variables_stack.peek()).nombre = ((declaracion_variable_scope)declaracion_variable_stack.peek()).nombre;
                      		  ((declaracion_variable_scope)declaracion_variable_stack.peek()).longitud = (Integer) expr4.get();
                      		  ((declaracion_variables_scope)declaracion_variables_stack.peek()).longitud = ((declaracion_variable_scope)declaracion_variable_stack.peek()).longitud;
                      		  Interprete.getTablaSimbolos().declararVariable((a!=null?a.getText():null), ((declaracion_variables_scope)declaracion_variables_stack.peek()).tipo, (Integer) expr4.get() );
                      		  enviar("<variable><nombre>" + (a!=null?a.getText():null) + "</nombre><tipo>" 
                      		  	+ ((declaracion_variables_scope)declaracion_variables_stack.peek()).tipo + "</tipo><longitud>" + expr4.get() 
                      		  	+ "</longitud><linea>" + (a!=null?a.getLine():0) + "</linea></variable>");
                      			
                      		
                    }

                    }
                    break;
                case 3 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:270:4: ^( DECL_VAR_REF ^( NOMBRE_VAR a= IDENT ) )
                    {
                    match(input,DECL_VAR_REF,FOLLOW_DECL_VAR_REF_in_declaracion_variable502); if (state.failed) return ;

                    match(input, Token.DOWN, null); if (state.failed) return ;
                    match(input,NOMBRE_VAR,FOLLOW_NOMBRE_VAR_in_declaracion_variable505); if (state.failed) return ;

                    match(input, Token.DOWN, null); if (state.failed) return ;
                    a=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_declaracion_variable509); if (state.failed) return ;

                    match(input, Token.UP, null); if (state.failed) return ;

                    match(input, Token.UP, null); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      		  ((declaracion_variable_scope)declaracion_variable_stack.peek()).nombre = (a!=null?a.getText():null);
                      		  ((declaracion_variables_scope)declaracion_variables_stack.peek()).nombre = ((declaracion_variable_scope)declaracion_variable_stack.peek()).nombre;
                      		  
                      		  Interprete.getTablaSimbolos().declararVariable((a!=null?a.getText():null), ((declaracion_variables_scope)declaracion_variables_stack.peek()).tipo, true);
                      		  enviar("<variable><nombre>" + (a!=null?a.getText():null) + "</nombre><tipo>" + ((declaracion_variables_scope)declaracion_variables_stack.peek()).tipo + "</tipo>" 
                      		  	+ "<esReferencia>TRUE</esReferencia>" + "<linea>" + (a!=null?a.getLine():0) + "</linea></variable>");
                      		
                      		
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
            declaracion_variable_stack.pop();
        }
        return ;
    }
    // $ANTLR end "declaracion_variable"

    protected static class asignacion_scope {
        String tipo;
        //El tipo de la asignacion, se va a usar para la autoconversion de tipos
        	boolean enDeclaracion;
        String nombre;
        Integer longitud;
    }
    protected Stack asignacion_stack = new Stack();


    // $ANTLR start "asignacion"
    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:285:1: asignacion options {backtrack=true; } : ( ^( ASIGNACION ^( EXPRESION expr ) ) | ^( ASIGNACION ^( EXPRESION listaExpr[false] ) ) | ^( ASIGNACION_REF ^( EXPRESION IDENT ) ) );
    public final void asignacion() throws RecognitionException {
        asignacion_stack.push(new asignacion_scope());
        CommonTree EXPRESION6=null;
        CommonTree EXPRESION8=null;
        CommonTree IDENT9=null;
        CommonTree EXPRESION10=null;
        Valor expr5 = null;

        List<Valor> listaExpr7 = null;



        	
        	
        	try {
        		String tipo = ((declaracion_variables_scope)declaracion_variables_stack.peek()).tipo;
        		((asignacion_scope)asignacion_stack.peek()).tipo = tipo;
        		((asignacion_scope)asignacion_stack.peek()).enDeclaracion = true;
        		((asignacion_scope)asignacion_stack.peek()).nombre = ((declaracion_variables_scope)declaracion_variables_stack.peek()).nombre;
        		((asignacion_scope)asignacion_stack.peek()).longitud = ((declaracion_variables_scope)declaracion_variables_stack.peek()).longitud;
        		
        	} catch (java.util.EmptyStackException e) { // Si falla es porque no estamos en declaracion_variables_stack
        		((asignacion_scope)asignacion_stack.peek()).enDeclaracion = false;
        		((asignacion_scope)asignacion_stack.peek()).nombre = ((sentencia_asignacion_scope)sentencia_asignacion_stack.peek()).nombre;
        		((asignacion_scope)asignacion_stack.peek()).tipo = ((sentencia_asignacion_scope)sentencia_asignacion_stack.peek()).tipo;
        		((asignacion_scope)asignacion_stack.peek()).longitud = ((sentencia_asignacion_scope)sentencia_asignacion_stack.peek()).indice;
        	}

        try {
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:315:2: ( ^( ASIGNACION ^( EXPRESION expr ) ) | ^( ASIGNACION ^( EXPRESION listaExpr[false] ) ) | ^( ASIGNACION_REF ^( EXPRESION IDENT ) ) )
            int alt12=3;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==ASIGNACION) ) {
                int LA12_1 = input.LA(2);

                if ( (synpred1_Eval()) ) {
                    alt12=1;
                }
                else if ( (synpred2_Eval()) ) {
                    alt12=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 12, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA12_0==ASIGNACION_REF) ) {
                alt12=3;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:315:4: ^( ASIGNACION ^( EXPRESION expr ) )
                    {
                    match(input,ASIGNACION,FOLLOW_ASIGNACION_in_asignacion558); if (state.failed) return ;

                    match(input, Token.DOWN, null); if (state.failed) return ;
                    EXPRESION6=(CommonTree)match(input,EXPRESION,FOLLOW_EXPRESION_in_asignacion561); if (state.failed) return ;

                    match(input, Token.DOWN, null); if (state.failed) return ;
                    pushFollow(FOLLOW_expr_in_asignacion563);
                    expr5=expr();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input, Token.UP, null); if (state.failed) return ;

                    match(input, Token.UP, null); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       
                      		 
                      		  if (((asignacion_scope)asignacion_stack.peek()).longitud == -1) { //No es un array
                      		  	Interprete.getTablaSimbolos().setValor(((asignacion_scope)asignacion_stack.peek()).nombre, expr5); 
                      		  	if (expr5.get() instanceof Variable) {
                      		  		enviar("<asignacion><nombre>" + ((asignacion_scope)asignacion_stack.peek()).nombre + "</nombre><valor>" + expr5 
                      		  			+ "</valor><ref>" + ((Variable) expr5.get()).getNombre() + "</ref><linea>" 
                      		  			+ (EXPRESION6!=null?EXPRESION6.getLine():0) + "</linea></asignacion>");
                      		  	} else {
                      		  		enviar("<asignacion><nombre>" + ((asignacion_scope)asignacion_stack.peek()).nombre + "</nombre><valor>" + expr5 
                      		  			+ "</valor><linea>" + (EXPRESION6!=null?EXPRESION6.getLine():0) + "</linea></asignacion>");
                      		  	}
                      		  } else {
                      		  	Interprete.getTablaSimbolos().setValor(((asignacion_scope)asignacion_stack.peek()).nombre, expr5, ((asignacion_scope)asignacion_stack.peek()).longitud); 
                      		  	enviar("<asignacion><nombre>" + ((asignacion_scope)asignacion_stack.peek()).nombre + "</nombre><valor>" + expr5 + "</valor><indice>" + ((asignacion_scope)asignacion_stack.peek()).longitud + "</indice><linea>" + (EXPRESION6!=null?EXPRESION6.getLine():0) 
                      		  		+ "</linea></asignacion>");
                      		  }
                      		  
                      		
                    }

                    }
                    break;
                case 2 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:336:4: ^( ASIGNACION ^( EXPRESION listaExpr[false] ) )
                    {
                    match(input,ASIGNACION,FOLLOW_ASIGNACION_in_asignacion578); if (state.failed) return ;

                    match(input, Token.DOWN, null); if (state.failed) return ;
                    EXPRESION8=(CommonTree)match(input,EXPRESION,FOLLOW_EXPRESION_in_asignacion581); if (state.failed) return ;

                    match(input, Token.DOWN, null); if (state.failed) return ;
                    pushFollow(FOLLOW_listaExpr_in_asignacion583);
                    listaExpr7=listaExpr(false);

                    state._fsp--;
                    if (state.failed) return ;

                    match(input, Token.UP, null); if (state.failed) return ;

                    match(input, Token.UP, null); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      		  //No hace falta comprobar , sabemos que es un array
                      		  List<Valor> listaValores = listaExpr7;
                      		  Iterator<Valor> iteValor = listaValores.iterator();
                      		  int i=0;
                      		  while(iteValor.hasNext()) {
                      		  	Valor valor = iteValor.next();
                      		  	Interprete.getTablaSimbolos().setValor(((asignacion_scope)asignacion_stack.peek()).nombre, valor, i); 
                      		  	enviar("<asignacion><nombre>" + ((asignacion_scope)asignacion_stack.peek()).nombre + "</nombre><valor>" + valor 
                      		  		+ "</valor><indice>" + i + "</indice><linea>" + (EXPRESION8!=null?EXPRESION8.getLine():0) + "</linea></asignacion>");	
                      		  	i++;
                      		  }
                      		

                      		
                    }

                    }
                    break;
                case 3 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:352:4: ^( ASIGNACION_REF ^( EXPRESION IDENT ) )
                    {
                    match(input,ASIGNACION_REF,FOLLOW_ASIGNACION_REF_in_asignacion596); if (state.failed) return ;

                    match(input, Token.DOWN, null); if (state.failed) return ;
                    EXPRESION10=(CommonTree)match(input,EXPRESION,FOLLOW_EXPRESION_in_asignacion599); if (state.failed) return ;

                    match(input, Token.DOWN, null); if (state.failed) return ;
                    IDENT9=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_asignacion601); if (state.failed) return ;

                    match(input, Token.UP, null); if (state.failed) return ;

                    match(input, Token.UP, null); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       
                      		 
                      		 	Variable variable = Interprete.getTablaSimbolos().getVariable((IDENT9!=null?IDENT9.getText():null)); 
                      			Interprete.getTablaSimbolos().setValor(((asignacion_scope)asignacion_stack.peek()).nombre, new Valor<Variable>(variable)); 
                      		 	enviar("<asignacion><nombre>" + ((asignacion_scope)asignacion_stack.peek()).nombre + "</nombre><nombreRef>" 
                      		 		+ variable.getNombre() + "</nombreRef><linea>" + (EXPRESION10!=null?EXPRESION10.getLine():0) + "</linea></asignacion>");
                      		 
                      		
                    }

                    }
                    break;

            }
            if ( state.backtracking==0 ) {

              	

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            asignacion_stack.pop();
        }
        return ;
    }
    // $ANTLR end "asignacion"

    protected static class nombre_variable_scope {
        String nombre;
        String tipo;
        Integer indice;
    }
    protected Stack nombre_variable_stack = new Stack();


    // $ANTLR start "nombre_variable"
    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:364:1: nombre_variable : ( ^( NOMBRE_VAR IDENT ) ^( INDICE expr ) | ^( NOMBRE_VAR IDENT ) );
    public final void nombre_variable() throws RecognitionException {
        nombre_variable_stack.push(new nombre_variable_scope());
        CommonTree IDENT11=null;
        CommonTree IDENT13=null;
        Valor expr12 = null;



        	((nombre_variable_scope)nombre_variable_stack.peek()).indice = -1;

        try {
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:380:2: ( ^( NOMBRE_VAR IDENT ) ^( INDICE expr ) | ^( NOMBRE_VAR IDENT ) )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==NOMBRE_VAR) ) {
                int LA13_1 = input.LA(2);

                if ( (LA13_1==DOWN) ) {
                    int LA13_2 = input.LA(3);

                    if ( (LA13_2==IDENT) ) {
                        int LA13_3 = input.LA(4);

                        if ( (LA13_3==UP) ) {
                            int LA13_4 = input.LA(5);

                            if ( (LA13_4==INDICE) ) {
                                alt13=1;
                            }
                            else if ( (LA13_4==ASIGNACION||LA13_4==ASIGNACION_REF) ) {
                                alt13=2;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return ;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 13, 4, input);

                                throw nvae;
                            }
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return ;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 13, 3, input);

                            throw nvae;
                        }
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 13, 2, input);

                        throw nvae;
                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 13, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:382:3: ^( NOMBRE_VAR IDENT ) ^( INDICE expr )
                    {
                    match(input,NOMBRE_VAR,FOLLOW_NOMBRE_VAR_in_nombre_variable641); if (state.failed) return ;

                    match(input, Token.DOWN, null); if (state.failed) return ;
                    IDENT11=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_nombre_variable643); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       ((nombre_variable_scope)nombre_variable_stack.peek()).nombre = (IDENT11!=null?IDENT11.getText():null); 
                      				     ((nombre_variable_scope)nombre_variable_stack.peek()).tipo = "int"; 
                      				   
                    }

                    match(input, Token.UP, null); if (state.failed) return ;
                    match(input,INDICE,FOLLOW_INDICE_in_nombre_variable654); if (state.failed) return ;

                    match(input, Token.DOWN, null); if (state.failed) return ;
                    pushFollow(FOLLOW_expr_in_nombre_variable656);
                    expr12=expr();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       ((nombre_variable_scope)nombre_variable_stack.peek()).tipo = Interprete.getTablaSimbolos().getTipo((IDENT11!=null?IDENT11.getText():null)); 
                      					((nombre_variable_scope)nombre_variable_stack.peek()).indice = (Integer) expr12.get(); 
                    }

                    match(input, Token.UP, null); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:387:4: ^( NOMBRE_VAR IDENT )
                    {
                    match(input,NOMBRE_VAR,FOLLOW_NOMBRE_VAR_in_nombre_variable665); if (state.failed) return ;

                    match(input, Token.DOWN, null); if (state.failed) return ;
                    IDENT13=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_nombre_variable667); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       ((nombre_variable_scope)nombre_variable_stack.peek()).nombre = (IDENT13!=null?IDENT13.getText():null); 
                      				     ((nombre_variable_scope)nombre_variable_stack.peek()).tipo = Interprete.getTablaSimbolos().getTipo((IDENT13!=null?IDENT13.getText():null));
                    }

                    match(input, Token.UP, null); if (state.failed) return ;

                    }
                    break;

            }
            if ( state.backtracking==0 ) {

              	//Volcamos para que pueda leer asignacion_stack
              	((sentencia_asignacion_scope)sentencia_asignacion_stack.peek()).nombre = ((nombre_variable_scope)nombre_variable_stack.peek()).nombre;
              	((sentencia_asignacion_scope)sentencia_asignacion_stack.peek()).tipo = ((nombre_variable_scope)nombre_variable_stack.peek()).tipo;
              	((sentencia_asignacion_scope)sentencia_asignacion_stack.peek()).indice = ((nombre_variable_scope)nombre_variable_stack.peek()).indice;


            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            nombre_variable_stack.pop();
        }
        return ;
    }
    // $ANTLR end "nombre_variable"

    protected static class sentencia_asignacion_scope {
        String nombre;
        Integer indice;
        String tipo;
    }
    protected Stack sentencia_asignacion_stack = new Stack();


    // $ANTLR start "sentencia_asignacion"
    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:391:1: sentencia_asignacion : ^( SENTENCIA_ASIG nombre_variable asignacion ) ;
    public final void sentencia_asignacion() throws RecognitionException {
        sentencia_asignacion_stack.push(new sentencia_asignacion_scope());

        	((sentencia_asignacion_scope)sentencia_asignacion_stack.peek()).indice = -1;

        try {
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:400:2: ( ^( SENTENCIA_ASIG nombre_variable asignacion ) )
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:401:3: ^( SENTENCIA_ASIG nombre_variable asignacion )
            {
            match(input,SENTENCIA_ASIG,FOLLOW_SENTENCIA_ASIG_in_sentencia_asignacion694); if (state.failed) return ;

            match(input, Token.DOWN, null); if (state.failed) return ;
            pushFollow(FOLLOW_nombre_variable_in_sentencia_asignacion696);
            nombre_variable();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_asignacion_in_sentencia_asignacion698);
            asignacion();

            state._fsp--;
            if (state.failed) return ;

            match(input, Token.UP, null); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            sentencia_asignacion_stack.pop();
        }
        return ;
    }
    // $ANTLR end "sentencia_asignacion"

    protected static class llamada_scope {
        Valor valorRetorno;
        boolean ejecutable;
    }
    protected Stack llamada_stack = new Stack();

    public static class llamada_return extends TreeRuleReturnScope {
        public Valor valor;
        public String tipo;
    };

    // $ANTLR start "llamada"
    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:405:1: llamada returns [Valor valor, String tipo] : ( ^( LLAMADA ^( NOMBRE_FUNC IDENT ) ^( PARAM_ACTUAL listaExpr[false] ) ) | ^( LLAMADA ^( NOMBRE_FUNC IDENT ) ) );
    public final Eval.llamada_return llamada() throws RecognitionException {
        llamada_stack.push(new llamada_scope());
        Eval.llamada_return retval = new Eval.llamada_return();
        retval.start = input.LT(1);

        CommonTree IDENT14=null;
        CommonTree IDENT16=null;
        List<Valor> listaExpr15 = null;



        	
        	
        	Funcion funcion = null;
        	List<ParametroFuncion> listaParametros= new ArrayList<ParametroFuncion>();
        	((llamada_scope)llamada_stack.peek()).ejecutable = true;	
        	

        try {
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:427:2: ( ^( LLAMADA ^( NOMBRE_FUNC IDENT ) ^( PARAM_ACTUAL listaExpr[false] ) ) | ^( LLAMADA ^( NOMBRE_FUNC IDENT ) ) )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==LLAMADA) ) {
                int LA14_1 = input.LA(2);

                if ( (LA14_1==DOWN) ) {
                    int LA14_2 = input.LA(3);

                    if ( (LA14_2==NOMBRE_FUNC) ) {
                        int LA14_3 = input.LA(4);

                        if ( (LA14_3==DOWN) ) {
                            int LA14_4 = input.LA(5);

                            if ( (LA14_4==IDENT) ) {
                                int LA14_5 = input.LA(6);

                                if ( (LA14_5==UP) ) {
                                    int LA14_6 = input.LA(7);

                                    if ( (LA14_6==PARAM_ACTUAL) ) {
                                        alt14=1;
                                    }
                                    else if ( (LA14_6==UP) ) {
                                        alt14=2;
                                    }
                                    else {
                                        if (state.backtracking>0) {state.failed=true; return retval;}
                                        NoViableAltException nvae =
                                            new NoViableAltException("", 14, 6, input);

                                        throw nvae;
                                    }
                                }
                                else {
                                    if (state.backtracking>0) {state.failed=true; return retval;}
                                    NoViableAltException nvae =
                                        new NoViableAltException("", 14, 5, input);

                                    throw nvae;
                                }
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 14, 4, input);

                                throw nvae;
                            }
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 14, 3, input);

                            throw nvae;
                        }
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 14, 2, input);

                        throw nvae;
                    }
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
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:428:3: ^( LLAMADA ^( NOMBRE_FUNC IDENT ) ^( PARAM_ACTUAL listaExpr[false] ) )
                    {
                    match(input,LLAMADA,FOLLOW_LLAMADA_in_llamada734); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    match(input,NOMBRE_FUNC,FOLLOW_NOMBRE_FUNC_in_llamada737); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    IDENT14=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_llamada739); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {

                      				funcion = Interprete.getTablaSimbolos().getFuncion((IDENT14!=null?IDENT14.getText():null)); 
                      				
                    }

                    match(input, Token.UP, null); if (state.failed) return retval;
                    match(input,PARAM_ACTUAL,FOLLOW_PARAM_ACTUAL_in_llamada745); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    pushFollow(FOLLOW_listaExpr_in_llamada747);
                    listaExpr15=listaExpr(false);

                    state._fsp--;
                    if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                      	
                      			
                      			if(! (IDENT14!=null?IDENT14.getText():null).equals("system")) {
                      				//System.out.println("EMPIEZA LA EJECUCION DE " + (IDENT14!=null?IDENT14.getText():null));
                      				Iterator<Valor> iteValores = listaExpr15.iterator();
                      				
                      				while(iteValores.hasNext()) {
                      					Valor valor = iteValores.next();
                      					listaParametros.add(new ParametroFuncion(valor));
                      				}
                      				enviar("<ini_llamada><nombre>" + (IDENT14!=null?IDENT14.getText():null) + "</nombre><linea>" + (IDENT14!=null?IDENT14.getLine():0) 
                      					+ "</linea></ini_llamada>");
                      				
                      				// Hay que generar este bloque para que se puedan situar las variables de los parametros formales.
                      				enviar("<ini_bloque></ini_bloque>");
                      				
                      				// TablaSimbolos.iniciarEjecucion realiza declaraciones internamente por lo que
                      				// hay que pasarle una referencia a Interprete para que pueda enviar los mensajes.
                      				Interprete.getTablaSimbolos().iniciarEjecucion(funcion,listaParametros,interprete);
                      				
                      				
                      				
                      				flujo.push(funcion.getIndiceFlujo());
                      				bloque();
                      				flujo.pop();
                      				Interprete.getTablaSimbolos().finalizarEjecucion();
                      				retval.valor = ((llamada_scope)llamada_stack.peek()).valorRetorno;
                      				retval.tipo = funcion.getTipoRetorno();
                      				
                      			}
                      			
                      			//System.out.println(" : " + listaExpr15.toString() );
                      			
                      		 
                    }

                    }
                    break;
                case 2 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:465:4: ^( LLAMADA ^( NOMBRE_FUNC IDENT ) )
                    {
                    match(input,LLAMADA,FOLLOW_LLAMADA_in_llamada761); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    match(input,NOMBRE_FUNC,FOLLOW_NOMBRE_FUNC_in_llamada764); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    IDENT16=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_llamada766); if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                      funcion = Interprete.getTablaSimbolos().getFuncion((IDENT16!=null?IDENT16.getText():null)); 
                    }

                    match(input, Token.UP, null); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {

                      			
                      			
                      			if(! (IDENT16!=null?IDENT16.getText():null).equals("system")) {
                      				//System.out.println("EMPIEZA LA EJECUCION DE " + (IDENT16!=null?IDENT16.getText():null));
                      				Interprete.getTablaSimbolos().iniciarEjecucion(funcion);
                      				enviar("<ini_llamada><nombre>" + (IDENT16!=null?IDENT16.getText():null) + "</nombre><linea>" + (IDENT16!=null?IDENT16.getLine():0) 
                      					+ "</linea></ini_llamada>");
                      				flujo.push(funcion.getIndiceFlujo());
                      				bloque();
                      				flujo.pop();
                      				Interprete.getTablaSimbolos().finalizarEjecucion();
                      				retval.valor = ((llamada_scope)llamada_stack.peek()).valorRetorno;
                      				retval.tipo = funcion.getTipoRetorno();
                      			} 
                      			//retval.tipo = "CALL";
                      			
                      			
                      		
                    }

                    }
                    break;

            }
            if ( state.backtracking==0 ) {

              	enviar("<fin_bloque></fin_bloque>");
              	if (((llamada_scope)llamada_stack.peek()).valorRetorno == null) {
              		enviar("<fin_llamada></fin_llamada>");
              	} else {
              		enviar("<fin_llamada><retorno>" + ((llamada_scope)llamada_stack.peek()).valorRetorno + "</retorno></fin_llamada>");
              	}
              	

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            llamada_stack.pop();
        }
        return retval;
    }
    // $ANTLR end "llamada"

    protected static class sentenciaIF_scope {
        int tipo;
        int ini;
        //Para tener una referencia desde la que empezar a buscar el nodo
        	// 0 : if-else
        	// 1 : if
        	int linea;
    }
    protected Stack sentenciaIF_stack = new Stack();

    public static class sentenciaIF_return extends TreeRuleReturnScope {
    };

    // $ANTLR start "sentenciaIF"
    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:487:1: sentenciaIF : ^( IF ^( EXPRESION a= expr ) . . ) ;
    public final Eval.sentenciaIF_return sentenciaIF() throws RecognitionException {
        sentenciaIF_stack.push(new sentenciaIF_scope());
        Eval.sentenciaIF_return retval = new Eval.sentenciaIF_return();
        retval.start = input.LT(1);

        CommonTree EXPRESION17=null;
        Valor a = null;



        	((sentenciaIF_scope)sentenciaIF_stack.peek()).ini = input.index();

        try {
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:532:2: ( ^( IF ^( EXPRESION a= expr ) . . ) )
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:533:3: ^( IF ^( EXPRESION a= expr ) . . )
            {
            match(input,IF,FOLLOW_IF_in_sentenciaIF802); if (state.failed) return retval;

            match(input, Token.DOWN, null); if (state.failed) return retval;
            EXPRESION17=(CommonTree)match(input,EXPRESION,FOLLOW_EXPRESION_in_sentenciaIF805); if (state.failed) return retval;

            match(input, Token.DOWN, null); if (state.failed) return retval;
            pushFollow(FOLLOW_expr_in_sentenciaIF809);
            a=expr();

            state._fsp--;
            if (state.failed) return retval;

            match(input, Token.UP, null); if (state.failed) return retval;
            if ( state.backtracking==0 ) {

              			((sentenciaIF_scope)sentenciaIF_stack.peek()).ini = input.index(); 
              			((sentenciaIF_scope)sentenciaIF_stack.peek()).linea = (EXPRESION17!=null?EXPRESION17.getLine():0);  
            }
            matchAny(input); if (state.failed) return retval;
            matchAny(input); if (state.failed) return retval;

            match(input, Token.UP, null); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
               ((sentenciaIF_scope)sentenciaIF_stack.peek()).tipo = 0; 
            }

            }

            if ( state.backtracking==0 ) {

              	
              	CommonTree nodo = (CommonTree) ((CommonTree)retval.start).getChild(1);
              	System.out.println(nodo.toStringTree());
              	int i;
              	// Si es true
              	if ((Integer) a.get() != 0) {
              		enviar("<condicional><linea>" + ((sentenciaIF_scope)sentenciaIF_stack.peek()).linea 
              			+ "</linea><ramaElegida>PRINCIPAL</ramaElegida></condicional>");
              		nodo = (CommonTree) ((CommonTree)retval.start).getChild(1);
              	} else {
              		if (((CommonTree)retval.start).getChild(2) != null) {
              			enviar("<condicional><linea>" + ((sentenciaIF_scope)sentenciaIF_stack.peek()).linea 
              				+ "</linea><ramaElegida>ELSE</ramaElegida></condicional>");
              			nodo = (CommonTree) ((CommonTree)retval.start).getChild(2);
              		} else {
              			enviar("<condicional></condicional>");
              		}
              	}
              	i = ((sentenciaIF_scope)sentenciaIF_stack.peek()).ini;
                      boolean encontrado = false;
              	while(!encontrado && i<= input.index() ) {
              		if(flujo.get(i) == nodo) {
              			encontrado = true;
              		} else {
              			i++;
              		}	
              	}
              	flujo.push(i);
              	
              	sentencia();
              	flujo.pop();
              	

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            sentenciaIF_stack.pop();
        }
        return retval;
    }
    // $ANTLR end "sentenciaIF"

    protected static class sentenciaWHILE_scope {
        boolean terminado;
        int ini;
        int linea;
    }
    protected Stack sentenciaWHILE_stack = new Stack();

    public static class sentenciaWHILE_return extends TreeRuleReturnScope {
    };

    // $ANTLR start "sentenciaWHILE"
    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:539:1: sentenciaWHILE : ^( WHILE . . ) ;
    public final Eval.sentenciaWHILE_return sentenciaWHILE() throws RecognitionException {
        sentenciaWHILE_stack.push(new sentenciaWHILE_scope());
        Eval.sentenciaWHILE_return retval = new Eval.sentenciaWHILE_return();
        retval.start = input.LT(1);

        CommonTree WHILE18=null;

        try {
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:590:2: ( ^( WHILE . . ) )
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:590:4: ^( WHILE . . )
            {
            WHILE18=(CommonTree)match(input,WHILE,FOLLOW_WHILE_in_sentenciaWHILE845); if (state.failed) return retval;

            if ( state.backtracking==0 ) {
               ((sentenciaWHILE_scope)sentenciaWHILE_stack.peek()).ini = flujo.index(); ((sentenciaWHILE_scope)sentenciaWHILE_stack.peek()).linea = (WHILE18!=null?WHILE18.getLine():0); 
            }

            match(input, Token.DOWN, null); if (state.failed) return retval;
            matchAny(input); if (state.failed) return retval;
            matchAny(input); if (state.failed) return retval;

            match(input, Token.UP, null); if (state.failed) return retval;

            }

            if ( state.backtracking==0 ) {

              	CommonTree nodoExpr=(CommonTree)((CommonTree)retval.start).getChild(0);
              	CommonTree nodoSentencia=(CommonTree)((CommonTree)retval.start).getChild(1);
              	
              	int cond;
              	int i;
              	int fin = flujo.index();
              	boolean encontrado;
              	
              	((sentenciaWHILE_scope)sentenciaWHILE_stack.peek()).terminado =false;
              	while(! ((sentenciaWHILE_scope)sentenciaWHILE_stack.peek()).terminado){
              		
              		i = ((sentenciaWHILE_scope)sentenciaWHILE_stack.peek()).ini;
              		encontrado = false;
              		while(!encontrado && i<=fin) {
              			if(nodoExpr == flujo.get(i)) {
              				encontrado = true;
              			} else {
              				i++;
              			}
              		}
              		flujo.push(i);
                      	cond=(Integer)expr().get();
                      	flujo.pop();
                      	if (cond == 0) {
                      		enviar("<loop><linea>" + ((sentenciaWHILE_scope)sentenciaWHILE_stack.peek()).linea + "</linea><sigue>FALSE</sigue></loop>");
                      		break;
                      	} else {
                      		enviar("<loop><linea>" + ((sentenciaWHILE_scope)sentenciaWHILE_stack.peek()).linea + "</linea><sigue>TRUE</sigue></loop>");
                      	}
                      	
                      	i = ((sentenciaWHILE_scope)sentenciaWHILE_stack.peek()).ini;
              		encontrado = false;
              		while(!encontrado && i<=fin) {
              			if(nodoSentencia == flujo.get(i)) {
              				encontrado = true;
              			} else {
              				i++;
              			}
              		}
                      	flujo.push(i);
                      	sentencia();
                      	flujo.pop();
                      }

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            sentenciaWHILE_stack.pop();
        }
        return retval;
    }
    // $ANTLR end "sentenciaWHILE"


    // $ANTLR start "expr"
    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:596:1: expr returns [Valor valor] : ( funcion_predefinida | ^( OR a= expr b= expr ) | ^( AND a= expr b= expr ) | ^( IGUAL a= expr b= expr ) | ^( DISTINTO a= expr b= expr ) | ^( MAYOR a= expr b= expr ) | ^( MENOR a= expr b= expr ) | ^( MAYORIGUAL a= expr b= expr ) | ^( MENORIGUAL a= expr b= expr ) | ^( MAS a= expr b= expr ) | ^( MENOS a= expr b= expr ) | ^( NOT a= expr ) | ^( NEGAR a= expr ) | ^( PROD a= expr b= expr ) | ^( DIV a= expr b= expr ) | ^( MOD a= expr b= expr ) | atom );
    public final Valor expr() throws RecognitionException {
        Valor valor = null;

        Valor a = null;

        Valor b = null;

        Valor funcion_predefinida19 = null;

        Eval.atom_return atom20 = null;



        	

        try {
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:605:2: ( funcion_predefinida | ^( OR a= expr b= expr ) | ^( AND a= expr b= expr ) | ^( IGUAL a= expr b= expr ) | ^( DISTINTO a= expr b= expr ) | ^( MAYOR a= expr b= expr ) | ^( MENOR a= expr b= expr ) | ^( MAYORIGUAL a= expr b= expr ) | ^( MENORIGUAL a= expr b= expr ) | ^( MAS a= expr b= expr ) | ^( MENOS a= expr b= expr ) | ^( NOT a= expr ) | ^( NEGAR a= expr ) | ^( PROD a= expr b= expr ) | ^( DIV a= expr b= expr ) | ^( MOD a= expr b= expr ) | atom )
            int alt15=17;
            switch ( input.LA(1) ) {
            case F_IMPRIMIR:
            case F_LEER:
            case F_POW:
            case F_GETS:
            case F_STRLEN:
            case F_SQRT:
                {
                alt15=1;
                }
                break;
            case OR:
                {
                alt15=2;
                }
                break;
            case AND:
                {
                alt15=3;
                }
                break;
            case IGUAL:
                {
                alt15=4;
                }
                break;
            case DISTINTO:
                {
                alt15=5;
                }
                break;
            case MAYOR:
                {
                alt15=6;
                }
                break;
            case MENOR:
                {
                alt15=7;
                }
                break;
            case MAYORIGUAL:
                {
                alt15=8;
                }
                break;
            case MENORIGUAL:
                {
                alt15=9;
                }
                break;
            case MAS:
                {
                alt15=10;
                }
                break;
            case MENOS:
                {
                alt15=11;
                }
                break;
            case NOT:
                {
                alt15=12;
                }
                break;
            case NEGAR:
                {
                alt15=13;
                }
                break;
            case PROD:
                {
                alt15=14;
                }
                break;
            case DIV:
                {
                alt15=15;
                }
                break;
            case MOD:
                {
                alt15=16;
                }
                break;
            case LLAMADA:
            case POSTFIJO:
            case PREFIJO:
            case LPAR:
            case IDENT:
            case INT:
            case FLOAT:
            case STRING:
            case CHAR:
                {
                alt15=17;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return valor;}
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }

            switch (alt15) {
                case 1 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:606:3: funcion_predefinida
                    {
                    pushFollow(FOLLOW_funcion_predefinida_in_expr888);
                    funcion_predefinida19=funcion_predefinida();

                    state._fsp--;
                    if (state.failed) return valor;
                    if ( state.backtracking==0 ) {
                       valor = funcion_predefinida19; 
                    }

                    }
                    break;
                case 2 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:609:3: ^( OR a= expr b= expr )
                    {
                    match(input,OR,FOLLOW_OR_in_expr901); if (state.failed) return valor;

                    match(input, Token.DOWN, null); if (state.failed) return valor;
                    pushFollow(FOLLOW_expr_in_expr905);
                    a=expr();

                    state._fsp--;
                    if (state.failed) return valor;
                    pushFollow(FOLLOW_expr_in_expr909);
                    b=expr();

                    state._fsp--;
                    if (state.failed) return valor;

                    match(input, Token.UP, null); if (state.failed) return valor;
                    if ( state.backtracking==0 ) {

                      			//Primero miramos el valor de la izda, si es true se acabo
                      			if ((Integer)a.get() != 0) {
                      				valor = new Valor<Integer>(1);
                      			} else {
                      				valor = b;
                      			}
                      				
                      		
                      		
                    }

                    }
                    break;
                case 3 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:620:4: ^( AND a= expr b= expr )
                    {
                    match(input,AND,FOLLOW_AND_in_expr920); if (state.failed) return valor;

                    match(input, Token.DOWN, null); if (state.failed) return valor;
                    pushFollow(FOLLOW_expr_in_expr924);
                    a=expr();

                    state._fsp--;
                    if (state.failed) return valor;
                    pushFollow(FOLLOW_expr_in_expr928);
                    b=expr();

                    state._fsp--;
                    if (state.failed) return valor;

                    match(input, Token.UP, null); if (state.failed) return valor;
                    if ( state.backtracking==0 ) {

                      			//Primero miramos el valor de la izda, si es false se acabo
                      			if ((Integer)a.get() == 0) {
                      				valor = new Valor<Integer>(0);
                      			} else {
                      				valor = b;
                      			}
                      	
                      		
                    }

                    }
                    break;
                case 4 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:631:4: ^( IGUAL a= expr b= expr )
                    {
                    match(input,IGUAL,FOLLOW_IGUAL_in_expr942); if (state.failed) return valor;

                    match(input, Token.DOWN, null); if (state.failed) return valor;
                    pushFollow(FOLLOW_expr_in_expr946);
                    a=expr();

                    state._fsp--;
                    if (state.failed) return valor;
                    pushFollow(FOLLOW_expr_in_expr950);
                    b=expr();

                    state._fsp--;
                    if (state.failed) return valor;

                    match(input, Token.UP, null); if (state.failed) return valor;
                    if ( state.backtracking==0 ) {

                      			if( a.get() instanceof Integer) { 
                      				if ( b.get() instanceof Integer) {
                      					valor = ( ( (Integer) a.get() ).equals( (Integer) b.get() ) )? 
                      					new Valor<Integer>(1) : new Valor<Integer>(0); 
                      				} else  {
                      					if ( b.get() instanceof Double) { // Si es float
                      						valor = ( ( (Integer) a.get() ).equals( ((Double) b.get()).intValue() ) )? 
                      						new Valor<Integer>(1) : new Valor<Integer>(0); 
                      					} else { //.. probablemente sea Character
                      						valor = ( ((Integer) a.get() ).equals( (int) ((Character) b.get()).charValue() )  )? 
                      						new Valor<Integer>(1) : new Valor<Integer>(0);
                      					}
                      				}
                      			} else if(a.get() instanceof Double) {
                      				// Conversion automatica para casos como por ejemplo (2.0 == 2)
                      				if(b.get() instanceof Integer) {
                      					valor = ( ((Double) a.get()).equals((Integer) b.get() * 1.0 ))? 
                      					new Valor<Integer>(1) : new Valor<Integer>(0); 
                      				} else  { // Si es double normalmente
                      					valor = ( ((Double) a.get()).equals((Double) b.get()) )? 
                      					new Valor<Integer>(1) : new Valor<Integer>(0); 
                      				}
                      			} else if(a.get() instanceof Character) {
                      				valor = ( ((Character) a.get() ).equals( (Character) b.get() )  )? 
                      				new Valor<Integer>(1) : new Valor<Integer>(0);
                      			} else {
                      				System.out.printf("ERROR: tipo no reconocido");
                      			}
                      		
                    }

                    }
                    break;
                case 5 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:661:4: ^( DISTINTO a= expr b= expr )
                    {
                    match(input,DISTINTO,FOLLOW_DISTINTO_in_expr959); if (state.failed) return valor;

                    match(input, Token.DOWN, null); if (state.failed) return valor;
                    pushFollow(FOLLOW_expr_in_expr963);
                    a=expr();

                    state._fsp--;
                    if (state.failed) return valor;
                    pushFollow(FOLLOW_expr_in_expr967);
                    b=expr();

                    state._fsp--;
                    if (state.failed) return valor;

                    match(input, Token.UP, null); if (state.failed) return valor;
                    if ( state.backtracking==0 ) {
                       
                      			if( a.get() instanceof Integer) { 
                      				if ( b.get() instanceof Integer) {
                      					valor = ( ( (Integer) a.get() ).equals( (Integer) b.get() ) )? 
                      					new Valor<Integer>(0) : new Valor<Integer>(1); 
                      				} else  { 
                      					if ( b.get() instanceof Double) { // Si es float
                      						valor = ( ( (Integer) a.get() ).equals( ((Double) b.get()).intValue() ) )? 
                      						new Valor<Integer>(0) : new Valor<Integer>(1); 
                      					} else { //.. probablemente sea Character
                      						valor = ( ((Integer) a.get() ).equals( (int) ((Character) b.get()).charValue() )  )? 
                      						new Valor<Integer>(0) : new Valor<Integer>(1);
                      					}
                      				}
                      			} else if(a.get() instanceof Double) {
                      				// Conversion automatica para casos como por ejemplo (2.0 == 2)
                      				if(b.get() instanceof Integer) {
                      					valor = ( ((Double) a.get()).equals((Integer) b.get() * 1.0 ))? 
                      					new Valor<Integer>(0) : new Valor<Integer>(1); 
                      				} else  { // Si es double normalmente
                      					valor = ( ((Double) a.get()).equals((Double) b.get()) )? 
                      					new Valor<Integer>(0) : new Valor<Integer>(1); 
                      				}
                      			} else if(a.get() instanceof Character) {
                      				valor = ( ((Character) a.get() ).equals( (Character) b.get() )  )? 
                      				new Valor<Integer>(0) : new Valor<Integer>(1);
                      			} else {
                      				System.out.printf("ERROR: tipo no reconocido");
                      			}
                      		
                    }

                    }
                    break;
                case 6 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:691:4: ^( MAYOR a= expr b= expr )
                    {
                    match(input,MAYOR,FOLLOW_MAYOR_in_expr976); if (state.failed) return valor;

                    match(input, Token.DOWN, null); if (state.failed) return valor;
                    pushFollow(FOLLOW_expr_in_expr980);
                    a=expr();

                    state._fsp--;
                    if (state.failed) return valor;
                    pushFollow(FOLLOW_expr_in_expr984);
                    b=expr();

                    state._fsp--;
                    if (state.failed) return valor;

                    match(input, Token.UP, null); if (state.failed) return valor;
                    if ( state.backtracking==0 ) {
                       
                      			if( a.get() instanceof Integer) { 
                      				if (b.get() instanceof Integer) {
                      					valor = ((Integer) a.get() > (Integer) b.get())? 
                      					new Valor<Integer>(1) : new Valor<Integer>(0); 
                      				} else {
                      					valor = ((Integer) a.get() > ((Double) b.get()).intValue() )? 
                      					new Valor<Integer>(1) : new Valor<Integer>(0); 
                      				}
                      			} else if(a.get() instanceof Double) {
                      				if(b.get() instanceof Integer) {
                      					valor = ( (Double) a.get() > (Integer) b.get() * 1.0 )? 
                      					new Valor<Integer>(1) : new Valor<Integer>(0); 
                      				} else {
                      					valor = ((Double) a.get() > (Double) b.get())? 
                      					new Valor<Integer>(1) : new Valor<Integer>(0); 
                      				}
                      			} else 
                      			if (a.get() instanceof Character) { 
                      				if (b.get() instanceof Integer) { // Si el segundo operando es un entero...
                      					valor = ( ((int) ( (Character)a.get() ).charValue() ) > (Integer) b.get() )? 
                      					new Valor<Integer>(1) : new Valor<Integer>(0);
                      				} else if (b.get() instanceof Character) { // Si el segundo operando es un caracter...
                      					valor = ( ((int) ( (Character)a.get() ).charValue() ) > ((int) ( (Character)b.get() ).charValue() ) )? 
                      					new Valor<Integer>(1) : new Valor<Integer>(0);
                      				}
                      			} else {
                      				System.out.printf("ERROR: tipo no reconocido");
                      			}
                      		
                    }

                    }
                    break;
                case 7 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:721:4: ^( MENOR a= expr b= expr )
                    {
                    match(input,MENOR,FOLLOW_MENOR_in_expr993); if (state.failed) return valor;

                    match(input, Token.DOWN, null); if (state.failed) return valor;
                    pushFollow(FOLLOW_expr_in_expr997);
                    a=expr();

                    state._fsp--;
                    if (state.failed) return valor;
                    pushFollow(FOLLOW_expr_in_expr1001);
                    b=expr();

                    state._fsp--;
                    if (state.failed) return valor;

                    match(input, Token.UP, null); if (state.failed) return valor;
                    if ( state.backtracking==0 ) {
                       
                      			if( a.get() instanceof Integer) { 
                      				if (b.get() instanceof Integer) {
                      					valor = ((Integer) a.get() < (Integer) b.get())? 
                      					new Valor<Integer>(1) : new Valor<Integer>(0); 
                      				} else {
                      					valor = ((Integer) a.get() < ((Double) b.get()).intValue() )? 
                      					new Valor<Integer>(1) : new Valor<Integer>(0); 
                      				}
                      			} else if(a.get() instanceof Double) {
                      				if(b.get() instanceof Integer) {
                      					valor = ( (Double) a.get() < (Integer) b.get() * 1.0 )? new Valor<Integer>(1) : 
                      					new Valor<Integer>(0); 
                      				} else {
                      					valor = ((Double) a.get() < (Double) b.get())? new Valor<Integer>(1) : 
                      					new Valor<Integer>(0);
                      				}
                      			} else 
                      			if (a.get() instanceof Character) { 
                      				if (b.get() instanceof Integer) { // Si el segundo operando es un entero...
                      					valor = ( ((int) ( (Character)a.get() ).charValue() ) < (Integer) b.get() )? 
                      					new Valor<Integer>(1) : new Valor<Integer>(0);
                      				} else if (b.get() instanceof Character) { // Si el segundo operando es un caracter...
                      					valor = ( ((int) ( (Character)a.get() ).charValue() ) < ((int) ( (Character)b.get() ).charValue() ) )? 
                      					new Valor<Integer>(1) : new Valor<Integer>(0);
                      				}
                      			}
                      		
                    }

                    }
                    break;
                case 8 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:749:4: ^( MAYORIGUAL a= expr b= expr )
                    {
                    match(input,MAYORIGUAL,FOLLOW_MAYORIGUAL_in_expr1010); if (state.failed) return valor;

                    match(input, Token.DOWN, null); if (state.failed) return valor;
                    pushFollow(FOLLOW_expr_in_expr1014);
                    a=expr();

                    state._fsp--;
                    if (state.failed) return valor;
                    pushFollow(FOLLOW_expr_in_expr1018);
                    b=expr();

                    state._fsp--;
                    if (state.failed) return valor;

                    match(input, Token.UP, null); if (state.failed) return valor;
                    if ( state.backtracking==0 ) {
                       
                      			if( a.get() instanceof Integer) { 	
                      				if (b.get() instanceof Integer) {
                      					valor = ((Integer) a.get() >= (Integer) b.get())? 
                      					new Valor<Integer>(1) : new Valor<Integer>(0); 
                      				} else {
                      					valor = ((Integer) a.get() >= ((Double) b.get()).intValue() )? 
                      					new Valor<Integer>(1) : new Valor<Integer>(0); 
                      				}
                      			} else if(a.get() instanceof Double) {
                      				if(b.get() instanceof Integer) {
                      					valor = ( (Double) a.get() >= (Integer) b.get() * 1.0 )? 
                      					new Valor<Integer>(1) : new Valor<Integer>(0); 
                      				} else {
                      					valor = ((Double) a.get() >= (Double) b.get())? 
                      					new Valor<Integer>(1) : new Valor<Integer>(0); 
                      				}
                      			} else 
                      			if (a.get() instanceof Character) { 
                      				if (b.get() instanceof Integer) { // Si el segundo operando es un entero...
                      					valor = ( ((int) ( (Character)a.get() ).charValue() ) >= (Integer) b.get() )? 
                      					new Valor<Integer>(1) : new Valor<Integer>(0);
                      				} else if (b.get() instanceof Character) { // Si el segundo operando es un caracter...
                      					valor = ( ((int) ( (Character)a.get() ).charValue() ) >= ((int) ( (Character)b.get() ).charValue() ) )? 
                      					new Valor<Integer>(1) : new Valor<Integer>(0);
                      				}
                      			}
                      		
                    }

                    }
                    break;
                case 9 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:777:4: ^( MENORIGUAL a= expr b= expr )
                    {
                    match(input,MENORIGUAL,FOLLOW_MENORIGUAL_in_expr1027); if (state.failed) return valor;

                    match(input, Token.DOWN, null); if (state.failed) return valor;
                    pushFollow(FOLLOW_expr_in_expr1031);
                    a=expr();

                    state._fsp--;
                    if (state.failed) return valor;
                    pushFollow(FOLLOW_expr_in_expr1035);
                    b=expr();

                    state._fsp--;
                    if (state.failed) return valor;

                    match(input, Token.UP, null); if (state.failed) return valor;
                    if ( state.backtracking==0 ) {
                       
                      			if( a.get() instanceof Integer) {
                      				if (b.get() instanceof Integer) {
                      					valor = ((Integer) a.get() <= (Integer) b.get())? 
                      					new Valor<Integer>(1) : new Valor<Integer>(0); 
                      				} else {
                      					valor = ((Integer) a.get() <= ((Double) b.get()).intValue() )? 
                      					new Valor<Integer>(1) : new Valor<Integer>(0); 
                      				}
                      			} else if(a.get() instanceof Double) {
                      				if(b.get() instanceof Integer) {
                      					valor = ( (Double) a.get() <= (Integer) b.get() * 1.0 )? 
                      					new Valor<Integer>(1) : new Valor<Integer>(0); 
                      				} else {
                      					valor = ((Double) a.get() <= (Double) b.get())? 
                      					new Valor<Integer>(1) : new Valor<Integer>(0); 
                      				}
                      			} else 
                      			if (a.get() instanceof Character) { 
                      				if (b.get() instanceof Integer) { // Si el segundo operando es un entero...
                      					valor = ( ((int) ( (Character)a.get() ).charValue() ) <= (Integer) b.get() )? 
                      					new Valor<Integer>(1) : new Valor<Integer>(0);
                      				} else if (b.get() instanceof Character) { // Si el segundo operando es un caracter...
                      					valor = ( ((int) ( (Character)a.get() ).charValue() ) 
                      						<= ((int) ( (Character)b.get() ).charValue() ) )? 
                      					new Valor<Integer>(1) : new Valor<Integer>(0);
                      				}
                      			}
                      		
                    }

                    }
                    break;
                case 10 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:809:3: ^( MAS a= expr b= expr )
                    {
                    match(input,MAS,FOLLOW_MAS_in_expr1052); if (state.failed) return valor;

                    match(input, Token.DOWN, null); if (state.failed) return valor;
                    pushFollow(FOLLOW_expr_in_expr1056);
                    a=expr();

                    state._fsp--;
                    if (state.failed) return valor;
                    pushFollow(FOLLOW_expr_in_expr1060);
                    b=expr();

                    state._fsp--;
                    if (state.failed) return valor;

                    match(input, Token.UP, null); if (state.failed) return valor;
                    if ( state.backtracking==0 ) {
                       
                      			if (a.get() instanceof Integer) {
                      				if (b.get() instanceof Integer) {
                      					valor = new Valor<Integer>((Integer)a.get() 
                      						+ (Integer)b.get() ); 
                      				} else {
                      					valor = new Valor<Integer>((Integer)a.get() 
                      						+ ((Double)b.get()).intValue() );
                      				}
                      			} else 
                      			if (a.get() instanceof Double) {
                      				if (b.get() instanceof Double) {
                      					valor = new Valor<Double>((Double)a.get() 
                      						+ (Double)b.get());
                      				} else if (b.get() instanceof Integer) {
                      					valor = new Valor<Double>((Double)a.get() 
                      						+ (Integer)b.get() * 1.0);
                      				}
                      			}
                      			  else 
                      			if (a.get() instanceof Character) { 
                      				if (b.get() instanceof Integer) { // Si el segundo operando es un entero...
                      					valor = new Valor<Character>( 
                      						(char) ( ((int) ( (Character)a.get() ).charValue() ) 
                      						+ (Integer) b.get() ));
                      				} else if (b.get() instanceof Character) { // Si el segundo operando es un caracter...
                      					valor = new Valor<Character>( 
                      						(char) ( ((int) ( (Character)a.get() ).charValue() ) 
                      						+ ((int) ( (Character)b.get() ).charValue() ) ));
                      				}
                      			}
                      		
                    }

                    }
                    break;
                case 11 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:842:4: ^( MENOS a= expr b= expr )
                    {
                    match(input,MENOS,FOLLOW_MENOS_in_expr1072); if (state.failed) return valor;

                    match(input, Token.DOWN, null); if (state.failed) return valor;
                    pushFollow(FOLLOW_expr_in_expr1076);
                    a=expr();

                    state._fsp--;
                    if (state.failed) return valor;
                    pushFollow(FOLLOW_expr_in_expr1080);
                    b=expr();

                    state._fsp--;
                    if (state.failed) return valor;

                    match(input, Token.UP, null); if (state.failed) return valor;
                    if ( state.backtracking==0 ) {
                       	
                      			if (a.get() instanceof Integer) {
                      				if (b.get() instanceof Integer) {
                      					valor = new Valor<Integer>((Integer)a.get() 
                      						- (Integer)b.get() ); 
                      				} else {
                      					valor = new Valor<Integer>((Integer)a.get() 
                      						- ((Double)b.get()).intValue() );
                      				}
                      			} else 
                      			if (a.get() instanceof Double) {
                      				if (b.get() instanceof Double) {
                      					valor = new Valor<Double>((Double)a.get() 
                      						- (Double)b.get());
                      				} else if (b.get() instanceof Integer) {
                      					valor = new Valor<Double>((Double)a.get() 
                      						- (Integer)b.get() * 1.0);
                      				}
                      			}
                      			  else 
                      			if (a.get() instanceof Character) { 
                      				if (b.get() instanceof Integer) { // Si el segundo operando es un entero...
                      					valor = new Valor<Character>( 
                      						(char) ( ((int) ( (Character)a.get() ).charValue() ) 
                      						- (Integer) b.get() ));
                      				} else if (b.get() instanceof Character) { // Si el segundo operando es un caracter...
                      					valor = new Valor<Character>( 
                      						(char) ( ((int) ( (Character)a.get() ).charValue() ) 
                      						- ((int) ( (Character)b.get() ).charValue() ) ));
                      				}
                      			}
                      		
                    }

                    }
                    break;
                case 12 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:876:4: ^( NOT a= expr )
                    {
                    match(input,NOT,FOLLOW_NOT_in_expr1095); if (state.failed) return valor;

                    match(input, Token.DOWN, null); if (state.failed) return valor;
                    pushFollow(FOLLOW_expr_in_expr1099);
                    a=expr();

                    state._fsp--;
                    if (state.failed) return valor;

                    match(input, Token.UP, null); if (state.failed) return valor;
                    if ( state.backtracking==0 ) {

                      			if (a.get() instanceof Integer) {
                      				if ((Integer)a.get() == 0) {
                      					valor = new Valor<Integer>(1);
                      				} else {
                      					valor = new Valor<Integer>(0);
                      				} 
                      			}
                      		
                    }

                    }
                    break;
                case 13 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:886:4: ^( NEGAR a= expr )
                    {
                    match(input,NEGAR,FOLLOW_NEGAR_in_expr1110); if (state.failed) return valor;

                    match(input, Token.DOWN, null); if (state.failed) return valor;
                    pushFollow(FOLLOW_expr_in_expr1114);
                    a=expr();

                    state._fsp--;
                    if (state.failed) return valor;

                    match(input, Token.UP, null); if (state.failed) return valor;
                    if ( state.backtracking==0 ) {
                      	
                      			if (a.get() instanceof Integer) {
                      				valor = new Valor<Integer>(-(Integer)a.get()); 
                      			} else 
                      			if (a.get() instanceof Double) {
                      				valor = new Valor<Double>(-(Double)a.get());
                      			}
                      		
                    }

                    }
                    break;
                case 14 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:896:4: ^( PROD a= expr b= expr )
                    {
                    match(input,PROD,FOLLOW_PROD_in_expr1127); if (state.failed) return valor;

                    match(input, Token.DOWN, null); if (state.failed) return valor;
                    pushFollow(FOLLOW_expr_in_expr1131);
                    a=expr();

                    state._fsp--;
                    if (state.failed) return valor;
                    pushFollow(FOLLOW_expr_in_expr1135);
                    b=expr();

                    state._fsp--;
                    if (state.failed) return valor;

                    match(input, Token.UP, null); if (state.failed) return valor;
                    if ( state.backtracking==0 ) {

                      		  if (a.get() instanceof Integer) {
                      		  	valor = new Valor<Integer>((Integer)a.get() * (Integer)b.get());  
                      		  } else 
                      		  if (a.get() instanceof Double) {
                      		  	if (b.get() instanceof Double) {
                                            		valor = new Valor<Double>((Double)a.get() * (Double)b.get());
                                            	} else if (b.get() instanceof Integer){
                                            		valor = new Valor<Double>((Double)a.get() * (Integer)b.get() * 1.0);
                                            	}
                      		  }
                      		
                    }

                    }
                    break;
                case 15 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:910:4: ^( DIV a= expr b= expr )
                    {
                    match(input,DIV,FOLLOW_DIV_in_expr1154); if (state.failed) return valor;

                    match(input, Token.DOWN, null); if (state.failed) return valor;
                    pushFollow(FOLLOW_expr_in_expr1158);
                    a=expr();

                    state._fsp--;
                    if (state.failed) return valor;
                    pushFollow(FOLLOW_expr_in_expr1162);
                    b=expr();

                    state._fsp--;
                    if (state.failed) return valor;

                    match(input, Token.UP, null); if (state.failed) return valor;
                    if ( state.backtracking==0 ) {
                       
                      			if (a.get() instanceof Integer) {
                      				valor = new Valor<Integer>((Integer)a.get() / (Integer)b.get()); 
                      			} else 
                      			if (a.get() instanceof Double) {
                      				if (b.get() instanceof Double) {
                                            			valor = new Valor<Double>((Double)a.get() / (Double)b.get());
                                            		} else if (b.get() instanceof Integer){
                                            			valor = new Valor<Double>((Double)a.get() / (Integer)b.get() * 1.0);
                                            		}
                      			}
                      		
                    }

                    }
                    break;
                case 16 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:922:4: ^( MOD a= expr b= expr )
                    {
                    match(input,MOD,FOLLOW_MOD_in_expr1171); if (state.failed) return valor;

                    match(input, Token.DOWN, null); if (state.failed) return valor;
                    pushFollow(FOLLOW_expr_in_expr1175);
                    a=expr();

                    state._fsp--;
                    if (state.failed) return valor;
                    pushFollow(FOLLOW_expr_in_expr1179);
                    b=expr();

                    state._fsp--;
                    if (state.failed) return valor;

                    match(input, Token.UP, null); if (state.failed) return valor;
                    if ( state.backtracking==0 ) {
                       
                      		
                      			valor = new Valor<Integer>((Integer)a.get() % (Integer)b.get()); 
                      		
                      		
                    }

                    }
                    break;
                case 17 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:927:4: atom
                    {
                    pushFollow(FOLLOW_atom_in_expr1187);
                    atom20=atom();

                    state._fsp--;
                    if (state.failed) return valor;
                    if ( state.backtracking==0 ) {
                       
                      		valor = (atom20!=null?atom20.valor:null);
                      		/** CONVERSION DE TIPOS
                      		*   ===================
                      		*   	
                      		*   Se realiza la comparacion entre el tipo destino y el actual.
                      		*   Si no coinciden se intenta convertir.
                      		*
                      		**/
                      		try {
                      			String tipo = ((asignacion_scope)asignacion_stack.peek()).tipo;
                      			
                      			//  
                      			//echo ("El tipo destino es " + tipo + "y el otro es " + (atom20!=null?atom20.tipo:null) + /**"y vale" + (atom20!=null?atom20.valor:null).get()*/);
                      			//
                      			if (!tipo.equals((atom20!=null?atom20.tipo:null)) && !(atom20!=null?atom20.tipo:null).equals("expr")) {
                      				
                      				if (tipo.equals("int")) { // Si el objetivo es integer
                      					try {
                      						if ((atom20!=null?atom20.tipo:null).equals("char")) {
                      							//Si es una variable hay que mirar dentro.
                      			
                      							if ((atom20!=null?atom20.valor:null).get() instanceof Variable) {
                      								valor = new Valor<Integer>( 
                      									(int)  ( (Character) (atom20!=null?atom20.valor:null).get() ).charValue() );
                      							} else { 
                      								if ((atom20!=null?atom20.valor:null).get() instanceof Character) {
                      									valor = new Valor<Integer>( 
                      										(int)  ( (Character) (atom20!=null?atom20.valor:null).get() ).charValue() );
                      								} else { // No es una Character, probablemente sera un Integer
                      									valor = new Valor<Integer>( (Integer) (atom20!=null?atom20.valor:null).get() ); 
                      								}
                      							}
                      							
                      						} else {	
                      							valor = new Valor<Integer>( ((Double) (atom20!=null?atom20.valor:null).get()).intValue() );
                      						}
                      					} catch (Exception e) {
                      						System.out.println("ERROR: fallo en conversion");
                      						e.printStackTrace();
                      					}
                      				}
                      				if (tipo.equals("float")) { //Si el objetivo es float
                      					
                      					valor = new Valor<Double>( (Integer) (atom20!=null?atom20.valor:null).get() * 1.0 );
                      				}
                      				
                      			}
                      		} catch (java.util.EmptyStackException e) {
                      			// Si entramos aqui es porque no estamos bajo un tipo objetivo
                      			// Como puede ser normal no imprimimos traza
                      		}
                      		
                      		
                    }

                    }
                    break;

            }
            if ( state.backtracking==0 ) {

              	

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
    // $ANTLR end "expr"


    // $ANTLR start "prim"
    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:983:1: prim returns [Valor valor] : ( ^( PREFIJO ^( NOMBRE_VAR IDENT ) ^( INT num= INT ) ) | ^( POSTFIJO ^( NOMBRE_VAR IDENT ) ^( INT num= INT ) ) );
    public final Valor prim() throws RecognitionException {
        Valor valor = null;

        CommonTree num=null;
        CommonTree IDENT21=null;
        CommonTree IDENT22=null;

        try {
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:984:2: ( ^( PREFIJO ^( NOMBRE_VAR IDENT ) ^( INT num= INT ) ) | ^( POSTFIJO ^( NOMBRE_VAR IDENT ) ^( INT num= INT ) ) )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==PREFIJO) ) {
                alt16=1;
            }
            else if ( (LA16_0==POSTFIJO) ) {
                alt16=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return valor;}
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }
            switch (alt16) {
                case 1 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:984:4: ^( PREFIJO ^( NOMBRE_VAR IDENT ) ^( INT num= INT ) )
                    {
                    match(input,PREFIJO,FOLLOW_PREFIJO_in_prim1207); if (state.failed) return valor;

                    match(input, Token.DOWN, null); if (state.failed) return valor;
                    match(input,NOMBRE_VAR,FOLLOW_NOMBRE_VAR_in_prim1210); if (state.failed) return valor;

                    match(input, Token.DOWN, null); if (state.failed) return valor;
                    IDENT21=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_prim1212); if (state.failed) return valor;

                    match(input, Token.UP, null); if (state.failed) return valor;
                    match(input,INT,FOLLOW_INT_in_prim1216); if (state.failed) return valor;

                    match(input, Token.DOWN, null); if (state.failed) return valor;
                    num=(CommonTree)match(input,INT,FOLLOW_INT_in_prim1220); if (state.failed) return valor;

                    match(input, Token.UP, null); if (state.failed) return valor;

                    match(input, Token.UP, null); if (state.failed) return valor;
                    if ( state.backtracking==0 ) {

                      			Variable variable = Interprete.getTablaSimbolos().getVariable((IDENT21!=null?IDENT21.getText():null)); 
                      			valor = variable.getValor(); 
                      			valor = new Valor<Integer>((Integer)valor.get() + Integer.parseInt((num!=null?num.getText():null)) );
                      			Interprete.getTablaSimbolos().setValor((IDENT21!=null?IDENT21.getText():null), valor);
                      			enviar("<asignacion><nombre>" + (IDENT21!=null?IDENT21.getText():null) + "</nombre><valor>" 
                      				+ (Integer)valor.get() + "</valor><linea>" + (IDENT21!=null?IDENT21.getLine():0) + "</linea></asignacion>");
                      			
                      		
                    }

                    }
                    break;
                case 2 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:993:4: ^( POSTFIJO ^( NOMBRE_VAR IDENT ) ^( INT num= INT ) )
                    {
                    match(input,POSTFIJO,FOLLOW_POSTFIJO_in_prim1230); if (state.failed) return valor;

                    match(input, Token.DOWN, null); if (state.failed) return valor;
                    match(input,NOMBRE_VAR,FOLLOW_NOMBRE_VAR_in_prim1233); if (state.failed) return valor;

                    match(input, Token.DOWN, null); if (state.failed) return valor;
                    IDENT22=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_prim1235); if (state.failed) return valor;

                    match(input, Token.UP, null); if (state.failed) return valor;
                    match(input,INT,FOLLOW_INT_in_prim1239); if (state.failed) return valor;

                    match(input, Token.DOWN, null); if (state.failed) return valor;
                    num=(CommonTree)match(input,INT,FOLLOW_INT_in_prim1243); if (state.failed) return valor;

                    match(input, Token.UP, null); if (state.failed) return valor;

                    match(input, Token.UP, null); if (state.failed) return valor;
                    if ( state.backtracking==0 ) {

                      			Variable variable = Interprete.getTablaSimbolos().getVariable((IDENT22!=null?IDENT22.getText():null)); 
                      			valor = variable.getValor();
                      			Interprete.getTablaSimbolos().setValor(
                      				(IDENT22!=null?IDENT22.getText():null), new Valor<Integer>((Integer)valor.get() + Integer.parseInt((num!=null?num.getText():null)) ) );
                      			// Internamente respetamos la esencia del postfijo, es decir, mandamos valor desactualizado
                      			// pero al simulador le mandamos el valor actualizado por coherencia
                      			variable = Interprete.getTablaSimbolos().getVariable((IDENT22!=null?IDENT22.getText():null)); 
                      			Valor valorSimulacion = variable.getValor();
                      			enviar("<asignacion><nombre>" + (IDENT22!=null?IDENT22.getText():null) 
                      				+ "</nombre><valor>" + (Integer) valorSimulacion.get() + "</valor><linea>" 
                      				+ (IDENT22!=null?IDENT22.getLine():0) + "</linea></asignacion>");
                      				
                      		
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
        }
        return valor;
    }
    // $ANTLR end "prim"

    protected static class listaExpr_scope {
        String tipo_tmp;
    }
    protected Stack listaExpr_stack = new Stack();


    // $ANTLR start "listaExpr"
    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:1012:1: listaExpr[boolean debeImprimir] returns [List<Valor> listaValores] : a= expr (b= expr )* ;
    public final List<Valor> listaExpr(boolean debeImprimir) throws RecognitionException {
        listaExpr_stack.push(new listaExpr_scope());
        List<Valor> listaValores = null;

        Valor a = null;

        Valor b = null;



        	listaValores = new ArrayList<Valor>();
        	
        	

        try {
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:1034:2: (a= expr (b= expr )* )
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:1035:3: a= expr (b= expr )*
            {
            if ( state.backtracking==0 ) {

              			// Si estamos en una llamada hay que falsear el tipo para 
              			// evitar que se haga casting de un parametro a la asignacion
              			// Por ejemplo: char la = hacerSuma(numero);  
              			//	Hay que evitar que numero:int se convierta a char.
              			//	La conversion solo debe aceptar al retorno en hacerSuma
              			try {	
              				// Si no estamos bajo llamada se saldra por la expcecion
              				boolean prueba = ((llamada_scope)llamada_stack.peek()).ejecutable;
              				// Si no estamos bajo una asignacion se saldra por la excepcion
              				((listaExpr_scope)listaExpr_stack.peek()).tipo_tmp = ((asignacion_scope)asignacion_stack.peek()).tipo;
              				((asignacion_scope)asignacion_stack.peek()).tipo = "NO_CONVERTIR";
              			} catch (java.util.EmptyStackException e) 
              			{  /*Se da esta excepcipn cuando no estamos en una asignacion, es normal.*/}
              		
              		
            }
            pushFollow(FOLLOW_expr_in_listaExpr1290);
            a=expr();

            state._fsp--;
            if (state.failed) return listaValores;
            if ( state.backtracking==0 ) {

              			 if(debeImprimir) ((imprimir_scope)imprimir_stack.peek()).listaImprimir.add((Object) a.get()); 
              			 listaValores.add(a);
              			
              			
              			
            }
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:1056:6: (b= expr )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==LLAMADA||LA17_0==F_IMPRIMIR||LA17_0==F_LEER||LA17_0==NEGAR||(LA17_0>=POSTFIJO && LA17_0<=PREFIJO)||(LA17_0>=F_POW && LA17_0<=F_SQRT)||LA17_0==LPAR||LA17_0==IDENT||(LA17_0>=OR && LA17_0<=CHAR)) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:1056:8: b= expr
            	    {
            	    pushFollow(FOLLOW_expr_in_listaExpr1298);
            	    b=expr();

            	    state._fsp--;
            	    if (state.failed) return listaValores;
            	    if ( state.backtracking==0 ) {
            	       if(debeImprimir) ((imprimir_scope)imprimir_stack.peek()).listaImprimir.add((Object) b.get()); 
            	      				       listaValores.add(b); 
            	    }

            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);


            }

            if ( state.backtracking==0 ) {

              	//int i;
              	//for(i=0;i<=listaValores.size() - 1; i++) {
              	//	System.out.println("-- " + listaValores.get(i).toString());
              	//}
              	
              	try {  // Restablecemos el tipo de la asignacion si se ha falseado
              		boolean prueba = ((llamada_scope)llamada_stack.peek()).ejecutable;
              		((asignacion_scope)asignacion_stack.peek()).tipo = ((listaExpr_scope)listaExpr_stack.peek()).tipo_tmp;
              	} catch (java.util.EmptyStackException e) 
              	{  /*Se da esta excepcipn cuando no estamos en una asignacion, es normal.*/}

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            listaExpr_stack.pop();
        }
        return listaValores;
    }
    // $ANTLR end "listaExpr"

    protected static class atom_scope {
        boolean ejecutable;
        String tipo_tmp;
    }
    protected Stack atom_stack = new Stack();

    public static class atom_return extends TreeRuleReturnScope {
        public Valor valor;
        public String tipo;
    };

    // $ANTLR start "atom"
    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:1063:1: atom returns [Valor valor, String tipo] : ( LPAR expr RPAR | prim | INT | FLOAT | STRING | CHAR | IDENT LCOR expr RCOR | IDENT | llamada );
    public final Eval.atom_return atom() throws RecognitionException {
        atom_stack.push(new atom_scope());
        Eval.atom_return retval = new Eval.atom_return();
        retval.start = input.LT(1);

        CommonTree INT25=null;
        CommonTree FLOAT26=null;
        CommonTree STRING27=null;
        CommonTree CHAR28=null;
        CommonTree IDENT29=null;
        CommonTree IDENT31=null;
        Valor expr23 = null;

        Valor prim24 = null;

        Valor expr30 = null;

        Eval.llamada_return llamada32 = null;



        	
        	

        try {
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:1075:2: ( LPAR expr RPAR | prim | INT | FLOAT | STRING | CHAR | IDENT LCOR expr RCOR | IDENT | llamada )
            int alt18=9;
            alt18 = dfa18.predict(input);
            switch (alt18) {
                case 1 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:1075:4: LPAR expr RPAR
                    {
                    match(input,LPAR,FOLLOW_LPAR_in_atom1337); if (state.failed) return retval;
                    pushFollow(FOLLOW_expr_in_atom1339);
                    expr23=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    match(input,RPAR,FOLLOW_RPAR_in_atom1341); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                      retval.valor = expr23; retval.tipo = "expr";
                    }

                    }
                    break;
                case 2 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:1076:4: prim
                    {
                    pushFollow(FOLLOW_prim_in_atom1348);
                    prim24=prim();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                      retval.valor = prim24;
                    }

                    }
                    break;
                case 3 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:1077:4: INT
                    {
                    INT25=(CommonTree)match(input,INT,FOLLOW_INT_in_atom1355); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                      retval.valor = new Valor<Integer>(Integer.parseInt((INT25!=null?INT25.getText():null))); retval.tipo = "int";
                    }

                    }
                    break;
                case 4 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:1078:4: FLOAT
                    {
                    FLOAT26=(CommonTree)match(input,FLOAT,FOLLOW_FLOAT_in_atom1362); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                      retval.valor = new Valor<Double>(Double.parseDouble((FLOAT26!=null?FLOAT26.getText():null))); retval.tipo = "float";
                    }

                    }
                    break;
                case 5 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:1079:4: STRING
                    {
                    STRING27=(CommonTree)match(input,STRING,FOLLOW_STRING_in_atom1370); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                      retval.valor = new Valor<String>((STRING27!=null?STRING27.getText():null)); retval.tipo = "string";  
                    }

                    }
                    break;
                case 6 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:1080:4: CHAR
                    {
                    CHAR28=(CommonTree)match(input,CHAR,FOLLOW_CHAR_in_atom1377); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {

                      			String carStr = (CHAR28!=null?CHAR28.getText():null); 
                      			// Hay que librarse de las comillas..
                      			carStr = carStr.replace("\"","");
                      			Character caracter = null;
                      			if (carStr.length() > 3) { // Si tras quitar comillas mide mas que uno...
                      				// ... es porque hay un escape y lo normal es que sea porque
                      				// se trata de \0 (final de array)
                      				caracter = '\0';
                      			} else {
                      				caracter = carStr.charAt(1);
                      			}
                      			//retval.valor = new Valor<Character>((CHAR28!=null?CHAR28.getText():null).charAt(1)); retval.tipo = "char"; 
                      			retval.valor = new Valor<Character>(caracter); retval.tipo = "char";
                      		
                    }

                    }
                    break;
                case 7 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:1095:4: IDENT LCOR expr RCOR
                    {
                    IDENT29=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_atom1384); if (state.failed) return retval;
                    match(input,LCOR,FOLLOW_LCOR_in_atom1386); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {

                      		try {
                      			((atom_scope)atom_stack.peek()).tipo_tmp = ((asignacion_scope)asignacion_stack.peek()).tipo;
                      			((asignacion_scope)asignacion_stack.peek()).tipo = "int";
                      		} catch (java.util.EmptyStackException e) 
                      		{  /*Se da esta excepcopn cuando no estamos en una asignacion, es normal.*/}
                      		
                      		
                    }
                    pushFollow(FOLLOW_expr_in_atom1390);
                    expr30=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    match(input,RCOR,FOLLOW_RCOR_in_atom1392); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                       
                      			try {
                      				((asignacion_scope)asignacion_stack.peek()).tipo = ((atom_scope)atom_stack.peek()).tipo_tmp; 
                      			} catch (java.util.EmptyStackException e) {  /***/ }
                      			Variable variable = Interprete.getTablaSimbolos().getVariable((IDENT29!=null?IDENT29.getText():null)); 
                      			retval.valor = variable.getValor((Integer) expr30.get()); retval.tipo = variable.getTipo(); 
                    }

                    }
                    break;
                case 8 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:1108:4: IDENT
                    {
                    IDENT31=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_atom1399); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                       Variable variable = Interprete.getTablaSimbolos().getVariable((IDENT31!=null?IDENT31.getText():null)); 
                      			retval.valor = variable.getValor(); retval.tipo = variable.getTipo(); 
                    }

                    }
                    break;
                case 9 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:1110:4: llamada
                    {
                    pushFollow(FOLLOW_llamada_in_atom1407);
                    llamada32=llamada();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                      retval.valor = (llamada32!=null?llamada32.valor:null); retval.tipo = (llamada32!=null?llamada32.tipo:null); 
                    }

                    }
                    break;

            }
            if ( state.backtracking==0 ) {

              	

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            atom_stack.pop();
        }
        return retval;
    }
    // $ANTLR end "atom"

    protected static class leer_scope {
        String entrada;
    }
    protected Stack leer_stack = new Stack();


    // $ANTLR start "leer"
    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:1113:1: leer : ( ^( F_LEER ^( FORMATO STRING ) ^( NOMBRE_VAR IDENT ) ) | ^( F_LEER ^( FORMATO STRING ) ^( NOMBRE_VAR IDENT ) ^( INDICE expr ) ) );
    public final void leer() throws RecognitionException {
        leer_stack.push(new leer_scope());
        CommonTree IDENT33=null;
        CommonTree STRING34=null;
        CommonTree IDENT35=null;
        CommonTree STRING37=null;
        Valor expr36 = null;



        	

        try {
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:1123:2: ( ^( F_LEER ^( FORMATO STRING ) ^( NOMBRE_VAR IDENT ) ) | ^( F_LEER ^( FORMATO STRING ) ^( NOMBRE_VAR IDENT ) ^( INDICE expr ) ) )
            int alt19=2;
            alt19 = dfa19.predict(input);
            switch (alt19) {
                case 1 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:1123:4: ^( F_LEER ^( FORMATO STRING ) ^( NOMBRE_VAR IDENT ) )
                    {
                    match(input,F_LEER,FOLLOW_F_LEER_in_leer1436); if (state.failed) return ;

                    match(input, Token.DOWN, null); if (state.failed) return ;
                    match(input,FORMATO,FOLLOW_FORMATO_in_leer1439); if (state.failed) return ;

                    match(input, Token.DOWN, null); if (state.failed) return ;
                    STRING34=(CommonTree)match(input,STRING,FOLLOW_STRING_in_leer1441); if (state.failed) return ;

                    match(input, Token.UP, null); if (state.failed) return ;
                    match(input,NOMBRE_VAR,FOLLOW_NOMBRE_VAR_in_leer1445); if (state.failed) return ;

                    match(input, Token.DOWN, null); if (state.failed) return ;
                    IDENT33=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_leer1447); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      			enviar("<entrada><nombre>" + (IDENT33!=null?IDENT33.getText():null) + "</nombre><linea>" + (IDENT33!=null?IDENT33.getLine():0) + "</linea></entrada>");
                      			final String nombre = (IDENT33!=null?IDENT33.getText():null);
                      			
                      			((leer_scope)leer_stack.peek()).entrada = leerStdin(nombre);
                      			
                      			if ( (STRING34!=null?STRING34.getText():null).indexOf("%d") != -1) { 
                      				// Vamos a permitir que el usuario introduzca float.
                      				// Asi que habra que filtrar por si acaso.
                      								
                      				String [] entradaArr = ((leer_scope)leer_stack.peek()).entrada.split("\\.");
                      				((leer_scope)leer_stack.peek()).entrada = entradaArr[0];
                      					
                      				Interprete.getTablaSimbolos().setValor((IDENT33!=null?IDENT33.getText():null), 
                      					new Valor<Integer>(Integer.parseInt(((leer_scope)leer_stack.peek()).entrada)) );
                      			} else if ( (STRING34!=null?STRING34.getText():null).indexOf("%s") != -1) {
                      				Interprete.getTablaSimbolos().setValor((IDENT33!=null?IDENT33.getText():null), 
                      					new Valor<String>(((leer_scope)leer_stack.peek()).entrada) );
                      			} else if ( ((STRING34!=null?STRING34.getText():null).indexOf("%f") != -1) || ((STRING34!=null?STRING34.getText():null).indexOf("%lf") != -1) ){
                      				// Con los float no tenemos ese problema ya que parseDouble admite un formato entero.
                      				Interprete.getTablaSimbolos().setValor((IDENT33!=null?IDENT33.getText():null), 
                      					new Valor<Double>(Double.parseDouble(((leer_scope)leer_stack.peek()).entrada)) );
                      			} else if ( (STRING34!=null?STRING34.getText():null).indexOf("%c") != -1) {
                      				Interprete.getTablaSimbolos().setValor((IDENT33!=null?IDENT33.getText():null), 
                      					new Valor<Character> ((Character) ((leer_scope)leer_stack.peek()).entrada.charAt(0)) );
                      			}
                      			enviar("<asignacion><nombre>" + (IDENT33!=null?IDENT33.getText():null) + "</nombre><valor>" 
                      				+ ((leer_scope)leer_stack.peek()).entrada + "</valor><linea>" + (IDENT33!=null?IDENT33.getLine():0) + "</linea></asignacion>");
                      			// Mandamos salida para que haya eco en la salida estandar
                      			echo(((leer_scope)leer_stack.peek()).entrada + "\n");
                      			
                      		
                    }

                    match(input, Token.UP, null); if (state.failed) return ;

                    match(input, Token.UP, null); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:1157:4: ^( F_LEER ^( FORMATO STRING ) ^( NOMBRE_VAR IDENT ) ^( INDICE expr ) )
                    {
                    match(input,F_LEER,FOLLOW_F_LEER_in_leer1463); if (state.failed) return ;

                    match(input, Token.DOWN, null); if (state.failed) return ;
                    match(input,FORMATO,FOLLOW_FORMATO_in_leer1466); if (state.failed) return ;

                    match(input, Token.DOWN, null); if (state.failed) return ;
                    STRING37=(CommonTree)match(input,STRING,FOLLOW_STRING_in_leer1468); if (state.failed) return ;

                    match(input, Token.UP, null); if (state.failed) return ;
                    match(input,NOMBRE_VAR,FOLLOW_NOMBRE_VAR_in_leer1472); if (state.failed) return ;

                    match(input, Token.DOWN, null); if (state.failed) return ;
                    IDENT35=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_leer1474); if (state.failed) return ;

                    match(input, Token.UP, null); if (state.failed) return ;
                    match(input,INDICE,FOLLOW_INDICE_in_leer1478); if (state.failed) return ;

                    match(input, Token.DOWN, null); if (state.failed) return ;
                    pushFollow(FOLLOW_expr_in_leer1480);
                    expr36=expr();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input, Token.UP, null); if (state.failed) return ;

                    match(input, Token.UP, null); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      			enviar("<entrada><nombre>" + (IDENT35!=null?IDENT35.getText():null) + "[" + expr36.get() + "]" 
                      				+ "</nombre><linea>" + (IDENT35!=null?IDENT35.getLine():0) + "</linea></entrada>");
                      			final String nombre = (IDENT35!=null?IDENT35.getText():null);
                      		
                      			((leer_scope)leer_stack.peek()).entrada = leerStdin(nombre + "[" + expr36.get() + "]");
                      				
                      			if ( (STRING37!=null?STRING37.getText():null).indexOf("%d") != -1) { 
                      				// Vamos a permitir que el usuario introduzca float.
                      				// Asi que habra que filtrar por si acaso.
                      								
                      				String [] entradaArr = ((leer_scope)leer_stack.peek()).entrada.split("\\.");
                      				((leer_scope)leer_stack.peek()).entrada = entradaArr[0];
                      					
                      				Interprete.getTablaSimbolos().setValor(
                      					(IDENT35!=null?IDENT35.getText():null), new Valor<Integer>(Integer.parseInt(((leer_scope)leer_stack.peek()).entrada)), 
                      						(Integer) expr36.get() );
                      			} else if ( (STRING37!=null?STRING37.getText():null).indexOf("%s") != -1) {
                      				Interprete.getTablaSimbolos().setValor(
                      					(IDENT35!=null?IDENT35.getText():null), new Valor<String>(((leer_scope)leer_stack.peek()).entrada), (Integer) expr36.get() );
                      			} else if ( ((STRING37!=null?STRING37.getText():null).indexOf("%f") != -1) || ((STRING37!=null?STRING37.getText():null).indexOf("%lf") != -1)  ) {
                      				// Con los float no tenemos ese problema ya que parseDouble admite un formato entero.
                      				Interprete.getTablaSimbolos().setValor(
                      					(IDENT35!=null?IDENT35.getText():null), new Valor<Double>(
                      						Double.parseDouble(((leer_scope)leer_stack.peek()).entrada)), (Integer) expr36.get() );
                      			} else if ( (STRING37!=null?STRING37.getText():null).indexOf("%c") != -1) {
                      				Interprete.getTablaSimbolos().setValor(
                      					(IDENT35!=null?IDENT35.getText():null), new Valor<Character> (((leer_scope)leer_stack.peek()).entrada.charAt(0)), 
                      						(Integer) expr36.get() );
                      			}
                      			enviar("<asignacion><nombre>" + (IDENT35!=null?IDENT35.getText():null) + "</nombre><valor>" 
                      				+ ((leer_scope)leer_stack.peek()).entrada + "</valor><indice>" + expr36.get() + "</indice><linea>" 
                      				+ (IDENT35!=null?IDENT35.getLine():0) + "</linea></asignacion>");
                      			// Mandamos salida para que haya eco en la salida estandar
                      			echo(((leer_scope)leer_stack.peek()).entrada + "\n");
                      		
                    }

                    }
                    break;

            }
            if ( state.backtracking==0 ) {

              	

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            leer_stack.pop();
        }
        return ;
    }
    // $ANTLR end "leer"

    protected static class imprimir_scope {
        String formato;
        List<Object> listaImprimir;
    }
    protected Stack imprimir_stack = new Stack();


    // $ANTLR start "imprimir"
    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:1197:1: imprimir : ( ^( F_IMPRIMIR ^( FORMATO STRING ) ^( NOMBRE_VAR listaExpr[true] ) ) | ^( F_IMPRIMIR ^( FORMATO STRING ) ) );
    public final void imprimir() throws RecognitionException {
        imprimir_stack.push(new imprimir_scope());
        CommonTree STRING38=null;
        CommonTree STRING39=null;


        	((imprimir_scope)imprimir_stack.peek()).listaImprimir = new ArrayList<Object>();

        try {
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:1232:2: ( ^( F_IMPRIMIR ^( FORMATO STRING ) ^( NOMBRE_VAR listaExpr[true] ) ) | ^( F_IMPRIMIR ^( FORMATO STRING ) ) )
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==F_IMPRIMIR) ) {
                int LA20_1 = input.LA(2);

                if ( (LA20_1==DOWN) ) {
                    int LA20_2 = input.LA(3);

                    if ( (LA20_2==FORMATO) ) {
                        int LA20_3 = input.LA(4);

                        if ( (LA20_3==DOWN) ) {
                            int LA20_4 = input.LA(5);

                            if ( (LA20_4==STRING) ) {
                                int LA20_5 = input.LA(6);

                                if ( (LA20_5==UP) ) {
                                    int LA20_6 = input.LA(7);

                                    if ( (LA20_6==UP) ) {
                                        alt20=2;
                                    }
                                    else if ( (LA20_6==NOMBRE_VAR) ) {
                                        alt20=1;
                                    }
                                    else {
                                        if (state.backtracking>0) {state.failed=true; return ;}
                                        NoViableAltException nvae =
                                            new NoViableAltException("", 20, 6, input);

                                        throw nvae;
                                    }
                                }
                                else {
                                    if (state.backtracking>0) {state.failed=true; return ;}
                                    NoViableAltException nvae =
                                        new NoViableAltException("", 20, 5, input);

                                    throw nvae;
                                }
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return ;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 20, 4, input);

                                throw nvae;
                            }
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return ;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 20, 3, input);

                            throw nvae;
                        }
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 20, 2, input);

                        throw nvae;
                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 20, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }
            switch (alt20) {
                case 1 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:1233:3: ^( F_IMPRIMIR ^( FORMATO STRING ) ^( NOMBRE_VAR listaExpr[true] ) )
                    {
                    match(input,F_IMPRIMIR,FOLLOW_F_IMPRIMIR_in_imprimir1520); if (state.failed) return ;

                    match(input, Token.DOWN, null); if (state.failed) return ;
                    match(input,FORMATO,FOLLOW_FORMATO_in_imprimir1523); if (state.failed) return ;

                    match(input, Token.DOWN, null); if (state.failed) return ;
                    STRING38=(CommonTree)match(input,STRING,FOLLOW_STRING_in_imprimir1525); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      enviarLinea((STRING38!=null?STRING38.getLine():0)); 
                      					((imprimir_scope)imprimir_stack.peek()).formato = (STRING38!=null?STRING38.getText():null);
                    }

                    match(input, Token.UP, null); if (state.failed) return ;
                    match(input,NOMBRE_VAR,FOLLOW_NOMBRE_VAR_in_imprimir1531); if (state.failed) return ;

                    match(input, Token.DOWN, null); if (state.failed) return ;
                    pushFollow(FOLLOW_listaExpr_in_imprimir1533);
                    listaExpr(true);

                    state._fsp--;
                    if (state.failed) return ;

                    match(input, Token.UP, null); if (state.failed) return ;

                    match(input, Token.UP, null); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:1236:4: ^( F_IMPRIMIR ^( FORMATO STRING ) )
                    {
                    match(input,F_IMPRIMIR,FOLLOW_F_IMPRIMIR_in_imprimir1544); if (state.failed) return ;

                    match(input, Token.DOWN, null); if (state.failed) return ;
                    match(input,FORMATO,FOLLOW_FORMATO_in_imprimir1547); if (state.failed) return ;

                    match(input, Token.DOWN, null); if (state.failed) return ;
                    STRING39=(CommonTree)match(input,STRING,FOLLOW_STRING_in_imprimir1549); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      enviarLinea((STRING39!=null?STRING39.getLine():0)); ((imprimir_scope)imprimir_stack.peek()).formato = (STRING39!=null?STRING39.getText():null);
                    }

                    match(input, Token.UP, null); if (state.failed) return ;

                    match(input, Token.UP, null); if (state.failed) return ;

                    }
                    break;

            }
            if ( state.backtracking==0 ) {

              	String salida;
              	// Vamos a soportar cuatro parametros como maximo
              	// No importa que haya menos que cuatro, si es necesario lo rellenamos ahora...
              	for(int i=0; i<=3; i++) {
              		if (((imprimir_scope)imprimir_stack.peek()).listaImprimir.size() - 1 < i) {
              			((imprimir_scope)imprimir_stack.peek()).listaImprimir.add(new Object());
              		} else if (((imprimir_scope)imprimir_stack.peek()).listaImprimir.get(0) instanceof Variable) {
              			((imprimir_scope)imprimir_stack.peek()).listaImprimir.set(i, ((Variable) ((imprimir_scope)imprimir_stack.peek()).listaImprimir.get(i)).getStrArrValor());
              		}
              	}
              	try { 
              	salida = String.format(((imprimir_scope)imprimir_stack.peek()).formato, ((imprimir_scope)imprimir_stack.peek()).listaImprimir.get(0), 
              		((imprimir_scope)imprimir_stack.peek()).listaImprimir.get(1), ((imprimir_scope)imprimir_stack.peek()).listaImprimir.get(2), ((imprimir_scope)imprimir_stack.peek()).listaImprimir.get(3));
              	} catch(java.util.UnknownFormatConversionException e) { // String.format no soporta exactamente 
              								//lo mismo que el printf de ANSI-C. Ej %.0lf
              		System.out.println("ERROR: Conversion fallida");
              		salida = ((imprimir_scope)imprimir_stack.peek()).formato;
              		int i=0;
              		while((i <= ((imprimir_scope)imprimir_stack.peek()).listaImprimir.size() - 1) && (((imprimir_scope)imprimir_stack.peek()).listaImprimir.get(i) != null)) {
              			salida += " " + ((imprimir_scope)imprimir_stack.peek()).listaImprimir.get(i);
              			i++;
              		}
              	}
              	//salida = salida.replace("\\n",""); // Comentado porque sí que vamos a mandar saltos de línea
              	echo(salida.substring(1, salida.length() - 1));

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            imprimir_stack.pop();
        }
        return ;
    }
    // $ANTLR end "imprimir"


    // $ANTLR start "funcion_predefinida"
    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:1240:1: funcion_predefinida returns [Valor valor] : ( leer | imprimir | pow | sqrt | gets | strlen );
    public final Valor funcion_predefinida() throws RecognitionException {
        Valor valor = null;

        Valor pow40 = null;

        Valor sqrt41 = null;

        Valor strlen42 = null;


        try {
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:1241:2: ( leer | imprimir | pow | sqrt | gets | strlen )
            int alt21=6;
            switch ( input.LA(1) ) {
            case F_LEER:
                {
                alt21=1;
                }
                break;
            case F_IMPRIMIR:
                {
                alt21=2;
                }
                break;
            case F_POW:
                {
                alt21=3;
                }
                break;
            case F_SQRT:
                {
                alt21=4;
                }
                break;
            case F_GETS:
                {
                alt21=5;
                }
                break;
            case F_STRLEN:
                {
                alt21=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return valor;}
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }

            switch (alt21) {
                case 1 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:1242:3: leer
                    {
                    pushFollow(FOLLOW_leer_in_funcion_predefinida1572);
                    leer();

                    state._fsp--;
                    if (state.failed) return valor;

                    }
                    break;
                case 2 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:1243:4: imprimir
                    {
                    pushFollow(FOLLOW_imprimir_in_funcion_predefinida1577);
                    imprimir();

                    state._fsp--;
                    if (state.failed) return valor;

                    }
                    break;
                case 3 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:1244:4: pow
                    {
                    pushFollow(FOLLOW_pow_in_funcion_predefinida1582);
                    pow40=pow();

                    state._fsp--;
                    if (state.failed) return valor;
                    if ( state.backtracking==0 ) {
                       valor = pow40; 
                    }

                    }
                    break;
                case 4 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:1245:4: sqrt
                    {
                    pushFollow(FOLLOW_sqrt_in_funcion_predefinida1589);
                    sqrt41=sqrt();

                    state._fsp--;
                    if (state.failed) return valor;
                    if ( state.backtracking==0 ) {
                       valor = sqrt41; 
                    }

                    }
                    break;
                case 5 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:1246:4: gets
                    {
                    pushFollow(FOLLOW_gets_in_funcion_predefinida1596);
                    gets();

                    state._fsp--;
                    if (state.failed) return valor;

                    }
                    break;
                case 6 :
                    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:1247:4: strlen
                    {
                    pushFollow(FOLLOW_strlen_in_funcion_predefinida1601);
                    strlen42=strlen();

                    state._fsp--;
                    if (state.failed) return valor;
                    if ( state.backtracking==0 ) {
                       valor = strlen42; 
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
        }
        return valor;
    }
    // $ANTLR end "funcion_predefinida"


    // $ANTLR start "pow"
    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:1250:1: pow returns [Valor valor] : ^( F_POW a= expr b= expr ) ;
    public final Valor pow() throws RecognitionException {
        Valor valor = null;

        Valor a = null;

        Valor b = null;


        try {
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:1252:2: ( ^( F_POW a= expr b= expr ) )
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:1252:4: ^( F_POW a= expr b= expr )
            {
            match(input,F_POW,FOLLOW_F_POW_in_pow1621); if (state.failed) return valor;

            match(input, Token.DOWN, null); if (state.failed) return valor;
            pushFollow(FOLLOW_expr_in_pow1625);
            a=expr();

            state._fsp--;
            if (state.failed) return valor;
            pushFollow(FOLLOW_expr_in_pow1629);
            b=expr();

            state._fsp--;
            if (state.failed) return valor;

            match(input, Token.UP, null); if (state.failed) return valor;
            if ( state.backtracking==0 ) {

              			// Si el primer operador es integer
              			if (a.get() instanceof Integer) {
              				Double resultado = Math.pow((Integer)a.get() * 1.0, (Integer)b.get() * 1.0);
              				Integer resultadoInt = (int) Math.floor(resultado);
              				valor = new Valor<Integer>(resultadoInt);
              				
              			} else {
              				Double resultado = Math.pow((Double)a.get(),(Double)b.get());
              				valor = new Valor<Double>(resultado);
              			}
              			
              		
            }

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
    // $ANTLR end "pow"


    // $ANTLR start "sqrt"
    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:1268:1: sqrt returns [Valor valor] : ^( F_SQRT a= expr ) ;
    public final Valor sqrt() throws RecognitionException {
        Valor valor = null;

        Valor a = null;


        try {
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:1269:2: ( ^( F_SQRT a= expr ) )
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:1269:4: ^( F_SQRT a= expr )
            {
            match(input,F_SQRT,FOLLOW_F_SQRT_in_sqrt1651); if (state.failed) return valor;

            match(input, Token.DOWN, null); if (state.failed) return valor;
            pushFollow(FOLLOW_expr_in_sqrt1655);
            a=expr();

            state._fsp--;
            if (state.failed) return valor;

            match(input, Token.UP, null); if (state.failed) return valor;
            if ( state.backtracking==0 ) {

              			if (a.get() instanceof Integer) {
              				Double resultado = Math.sqrt((Integer)a.get() * 1.0);
              				Integer resultadoInt = (int) Math.floor(resultado);
              				valor = new Valor<Integer>(resultadoInt);
              			} else {
              				Double resultado = Math.sqrt((Double)a.get());
              				valor = new Valor<Double>(resultado);
              			}
              		
              		
            }

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
    // $ANTLR end "sqrt"


    // $ANTLR start "strlen"
    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:1283:1: strlen returns [Valor valor] : ^( F_STRLEN IDENT ) ;
    public final Valor strlen() throws RecognitionException {
        Valor valor = null;

        CommonTree IDENT43=null;

        try {
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:1284:2: ( ^( F_STRLEN IDENT ) )
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:1284:4: ^( F_STRLEN IDENT )
            {
            match(input,F_STRLEN,FOLLOW_F_STRLEN_in_strlen1677); if (state.failed) return valor;

            match(input, Token.DOWN, null); if (state.failed) return valor;
            IDENT43=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_strlen1679); if (state.failed) return valor;

            match(input, Token.UP, null); if (state.failed) return valor;
            if ( state.backtracking==0 ) {

              			Variable variable = Interprete.getTablaSimbolos().getVariable((IDENT43!=null?IDENT43.getText():null));
              			valor = new Valor<Integer>(variable.getLongitud());
              		
            }

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
    // $ANTLR end "strlen"


    // $ANTLR start "gets"
    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:1291:1: gets : ^( F_GETS IDENT ) ;
    public final void gets() throws RecognitionException {
        CommonTree IDENT44=null;

        try {
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:1291:6: ( ^( F_GETS IDENT ) )
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:1291:8: ^( F_GETS IDENT )
            {
            match(input,F_GETS,FOLLOW_F_GETS_in_gets1698); if (state.failed) return ;

            match(input, Token.DOWN, null); if (state.failed) return ;
            IDENT44=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_gets1700); if (state.failed) return ;

            match(input, Token.UP, null); if (state.failed) return ;
            if ( state.backtracking==0 ) {

              			enviar("<entrada><nombre>" + (IDENT44!=null?IDENT44.getText():null) + "</nombre><linea>" + (IDENT44!=null?IDENT44.getLine():0) + "</linea></entrada>");
              			String resultado = leerStdin((IDENT44!=null?IDENT44.getText():null));
              			char resultadoArr[] = resultado.toCharArray();
              			Variable variable = Interprete.getTablaSimbolos().getVariable((IDENT44!=null?IDENT44.getText():null));
              			variable.reinicializar(); // Hay que limpiar el char array previamente
              			int i=0;
              			for(i=0;i<=resultadoArr.length - 1;i++) { // Intentamos copiar todos los valores, 
              								//si alguno no entra Variable lo ignorara
              				Interprete.getTablaSimbolos().setValor((IDENT44!=null?IDENT44.getText():null), new Valor<Character>(resultadoArr[i]), i); 
              				System.out.println("MIERDA");
              				enviar("<asignacion><nombre>" + (IDENT44!=null?IDENT44.getText():null) 
              					+ "</nombre><valor>" + resultadoArr[i] + "</valor><indice>" 
              					+ i + "</indice><linea>" + (IDENT44!=null?IDENT44.getLine():0) 
              					+ "</linea><comentario>FALSE</comentario></asignacion>");
              				//  Enviamos salida tambien para que haya eco de la entrada en la salida estandar
              				echo(((Character)resultadoArr[i]).toString());
              			}
              			// Insertamos caracter de FIN de chararray
              			Interprete.getTablaSimbolos().setValor((IDENT44!=null?IDENT44.getText():null), new Valor<Character>('\0'), i); 
              			enviar("<asignacion><nombre>" + (IDENT44!=null?IDENT44.getText():null) + "</nombre><valor>" 
              				+ "END" + "</valor><indice>" + i + "</indice><linea>" + (IDENT44!=null?IDENT44.getLine():0) 
              				+ "</linea><comentario>FALSE</comentario></asignacion>");
              			// Ahora hay que rellenar el resto de posiciones del array
              			int j;
              			for(j=i+1;j<=variable.getLongitudMAX()-1;j++) { // Como puede ver se envía "?" porque son posiciones basura
              				String comentar = "FALSE";
              				if (j==variable.getLongitudMAX()-1) { // En la última posición sí que se manda comentar
              					comentar = "TRUE";
              				}
              				enviar("<asignacion><nombre>" + (IDENT44!=null?IDENT44.getText():null) + "</nombre><valor>" 
              					+ "?" + "</valor><indice>" + j + "</indice><linea>" + (IDENT44!=null?IDENT44.getLine():0) 
              					+ "</linea><comentario>" + comentar + "</comentario></asignacion>");
              			}
              		
            }

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
    // $ANTLR end "gets"


    // $ANTLR start "precompilacion"
    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:1329:1: precompilacion : define ;
    public final void precompilacion() throws RecognitionException {

        	

        try {
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:1336:2: ( define )
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:1336:4: define
            {
            pushFollow(FOLLOW_define_in_precompilacion1728);
            define();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {

              	

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
    // $ANTLR end "precompilacion"


    // $ANTLR start "define"
    // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:1339:1: define : ^( DEFINE ^( NOMBRE_VAR l= IDENT ) ^( VALOR m= atom ) ) ;
    public final void define() throws RecognitionException {
        CommonTree l=null;
        CommonTree DEFINE45=null;
        Eval.atom_return m = null;



        	

        try {
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:1346:2: ( ^( DEFINE ^( NOMBRE_VAR l= IDENT ) ^( VALOR m= atom ) ) )
            // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:1347:2: ^( DEFINE ^( NOMBRE_VAR l= IDENT ) ^( VALOR m= atom ) )
            {
            DEFINE45=(CommonTree)match(input,DEFINE,FOLLOW_DEFINE_in_define1753); if (state.failed) return ;

            match(input, Token.DOWN, null); if (state.failed) return ;
            match(input,NOMBRE_VAR,FOLLOW_NOMBRE_VAR_in_define1756); if (state.failed) return ;

            match(input, Token.DOWN, null); if (state.failed) return ;
            l=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_define1760); if (state.failed) return ;

            match(input, Token.UP, null); if (state.failed) return ;
            match(input,VALOR,FOLLOW_VALOR_in_define1764); if (state.failed) return ;

            match(input, Token.DOWN, null); if (state.failed) return ;
            pushFollow(FOLLOW_atom_in_define1768);
            m=atom();

            state._fsp--;
            if (state.failed) return ;

            match(input, Token.UP, null); if (state.failed) return ;

            match(input, Token.UP, null); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               
              		enviarLinea((DEFINE45!=null?DEFINE45.getLine():0));
              		Interprete.getTablaSimbolos().declararVariable((l!=null?l.getText():null), (m!=null?m.tipo:null)); 
              		Interprete.getTablaSimbolos().setValor((l!=null?l.getText():null), (m!=null?m.valor:null));
              	
            }

            }

            if ( state.backtracking==0 ) {

              	

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
    // $ANTLR end "define"

    // $ANTLR start synpred1_Eval
    public final void synpred1_Eval_fragment() throws RecognitionException {   
        // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:315:4: ( ^( ASIGNACION ^( EXPRESION expr ) ) )
        // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:315:4: ^( ASIGNACION ^( EXPRESION expr ) )
        {
        match(input,ASIGNACION,FOLLOW_ASIGNACION_in_synpred1_Eval558); if (state.failed) return ;

        match(input, Token.DOWN, null); if (state.failed) return ;
        match(input,EXPRESION,FOLLOW_EXPRESION_in_synpred1_Eval561); if (state.failed) return ;

        match(input, Token.DOWN, null); if (state.failed) return ;
        pushFollow(FOLLOW_expr_in_synpred1_Eval563);
        expr();

        state._fsp--;
        if (state.failed) return ;

        match(input, Token.UP, null); if (state.failed) return ;

        match(input, Token.UP, null); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred1_Eval

    // $ANTLR start synpred2_Eval
    public final void synpred2_Eval_fragment() throws RecognitionException {   
        // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:336:4: ( ^( ASIGNACION ^( EXPRESION listaExpr[false] ) ) )
        // F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\Eval.g:336:4: ^( ASIGNACION ^( EXPRESION listaExpr[false] ) )
        {
        match(input,ASIGNACION,FOLLOW_ASIGNACION_in_synpred2_Eval578); if (state.failed) return ;

        match(input, Token.DOWN, null); if (state.failed) return ;
        match(input,EXPRESION,FOLLOW_EXPRESION_in_synpred2_Eval581); if (state.failed) return ;

        match(input, Token.DOWN, null); if (state.failed) return ;
        pushFollow(FOLLOW_listaExpr_in_synpred2_Eval583);
        listaExpr(false);

        state._fsp--;
        if (state.failed) return ;

        match(input, Token.UP, null); if (state.failed) return ;

        match(input, Token.UP, null); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred2_Eval

    // Delegated rules

    public final boolean synpred2_Eval() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_Eval_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred1_Eval() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_Eval_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA18 dfa18 = new DFA18(this);
    protected DFA19 dfa19 = new DFA19(this);
    static final String DFA18_eotS =
        "\13\uffff";
    static final String DFA18_eofS =
        "\13\uffff";
    static final String DFA18_minS =
        "\1\24\6\uffff\1\3\3\uffff";
    static final String DFA18_maxS =
        "\1\117\6\uffff\1\117\3\uffff";
    static final String DFA18_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\uffff\1\11\1\7\1\10";
    static final String DFA18_specialS =
        "\13\uffff}>";
    static final String[] DFA18_transitionS = {
            "\1\10\13\uffff\2\2\15\uffff\1\1\2\uffff\1\7\31\uffff\1\3\1"+
            "\4\1\5\1\6",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\12\20\uffff\1\12\4\uffff\1\12\1\uffff\1\12\1\uffff\1\12"+
            "\2\uffff\2\12\6\uffff\4\12\3\uffff\2\12\1\uffff\1\12\1\11\1"+
            "\12\11\uffff\22\12",
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
            return "1063:1: atom returns [Valor valor, String tipo] : ( LPAR expr RPAR | prim | INT | FLOAT | STRING | CHAR | IDENT LCOR expr RCOR | IDENT | llamada );";
        }
    }
    static final String DFA19_eotS =
        "\15\uffff";
    static final String DFA19_eofS =
        "\15\uffff";
    static final String DFA19_minS =
        "\1\33\1\2\1\32\1\2\1\116\1\3\1\16\1\2\1\62\2\3\2\uffff";
    static final String DFA19_maxS =
        "\1\33\1\2\1\32\1\2\1\116\1\3\1\16\1\2\1\62\1\3\1\46\2\uffff";
    static final String DFA19_acceptS =
        "\13\uffff\1\2\1\1";
    static final String DFA19_specialS =
        "\15\uffff}>";
    static final String[] DFA19_transitionS = {
            "\1\1",
            "\1\2",
            "\1\3",
            "\1\4",
            "\1\5",
            "\1\6",
            "\1\7",
            "\1\10",
            "\1\11",
            "\1\12",
            "\1\14\42\uffff\1\13",
            "",
            ""
    };

    static final short[] DFA19_eot = DFA.unpackEncodedString(DFA19_eotS);
    static final short[] DFA19_eof = DFA.unpackEncodedString(DFA19_eofS);
    static final char[] DFA19_min = DFA.unpackEncodedStringToUnsignedChars(DFA19_minS);
    static final char[] DFA19_max = DFA.unpackEncodedStringToUnsignedChars(DFA19_maxS);
    static final short[] DFA19_accept = DFA.unpackEncodedString(DFA19_acceptS);
    static final short[] DFA19_special = DFA.unpackEncodedString(DFA19_specialS);
    static final short[][] DFA19_transition;

    static {
        int numStates = DFA19_transitionS.length;
        DFA19_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA19_transition[i] = DFA.unpackEncodedString(DFA19_transitionS[i]);
        }
    }

    class DFA19 extends DFA {

        public DFA19(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 19;
            this.eot = DFA19_eot;
            this.eof = DFA19_eof;
            this.min = DFA19_min;
            this.max = DFA19_max;
            this.accept = DFA19_accept;
            this.special = DFA19_special;
            this.transition = DFA19_transition;
        }
        public String getDescription() {
            return "1113:1: leer : ( ^( F_LEER ^( FORMATO STRING ) ^( NOMBRE_VAR IDENT ) ) | ^( F_LEER ^( FORMATO STRING ) ^( NOMBRE_VAR IDENT ) ^( INDICE expr ) ) );";
        }
    }
 

    public static final BitSet FOLLOW_PROGRAMA_in_programa76 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_DECLARACIONES_GLOBALES_in_programa81 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_declaraciones_globales_in_programa83 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FUNCIONES_in_programa87 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_llamada_in_programa93 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PROGRAMA_in_programa104 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_FUNCIONES_in_programa109 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_llamada_in_programa115 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_declaracion_global_in_declaraciones_globales144 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_100_in_tipo_base176 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_101_in_tipo_base183 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_102_in_tipo_base191 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_103_in_tipo_base198 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_104_in_tipo_base205 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_107_in_tipo_base212 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_precompilacion_in_declaracion_global238 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bloque_in_sentencia271 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RETURN_in_sentencia277 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_sentencia279 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_sentencia_asignacion_in_sentencia287 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_llamada_in_sentencia292 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_prim_in_sentencia297 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_funcion_predefinida_in_sentencia302 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_sentenciaIF_in_sentencia307 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_sentenciaWHILE_in_sentencia312 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BLOQUE_in_bloque342 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_elemento_bloque_in_bloque346 = new BitSet(new long[]{0x05200F830A110208L});
    public static final BitSet FOLLOW_declaracion_variables_in_elemento_bloque360 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_sentencia_in_elemento_bloque365 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DECL_in_declaracion_variables398 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_tipo_base_in_declaracion_variables400 = new BitSet(new long[]{0x0000100401000000L});
    public static final BitSet FOLLOW_declaracion_var_asig_in_declaracion_variables404 = new BitSet(new long[]{0x0000100401000008L});
    public static final BitSet FOLLOW_declaracion_variable_in_declaracion_var_asig430 = new BitSet(new long[]{0x0000200000040002L});
    public static final BitSet FOLLOW_asignacion_in_declaracion_var_asig432 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DECL_VAR_in_declaracion_variable456 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_NOMBRE_VAR_in_declaracion_variable459 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_declaracion_variable463 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DECL_VAR_ARR_in_declaracion_variable476 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_NOMBRE_VAR_in_declaracion_variable479 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_declaracion_variable483 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LONGITUD_in_declaracion_variable487 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_declaracion_variable489 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DECL_VAR_REF_in_declaracion_variable502 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_NOMBRE_VAR_in_declaracion_variable505 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_declaracion_variable509 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ASIGNACION_in_asignacion558 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_EXPRESION_in_asignacion561 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_asignacion563 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ASIGNACION_in_asignacion578 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_EXPRESION_in_asignacion581 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_listaExpr_in_asignacion583 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ASIGNACION_REF_in_asignacion596 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_EXPRESION_in_asignacion599 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_asignacion601 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NOMBRE_VAR_in_nombre_variable641 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_nombre_variable643 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INDICE_in_nombre_variable654 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_nombre_variable656 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NOMBRE_VAR_in_nombre_variable665 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_nombre_variable667 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SENTENCIA_ASIG_in_sentencia_asignacion694 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_nombre_variable_in_sentencia_asignacion696 = new BitSet(new long[]{0x0000200000040000L});
    public static final BitSet FOLLOW_asignacion_in_sentencia_asignacion698 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LLAMADA_in_llamada734 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_NOMBRE_FUNC_in_llamada737 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_llamada739 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PARAM_ACTUAL_in_llamada745 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_listaExpr_in_llamada747 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LLAMADA_in_llamada761 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_NOMBRE_FUNC_in_llamada764 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_llamada766 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_IF_in_sentenciaIF802 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_EXPRESION_in_sentenciaIF805 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_sentenciaIF809 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_WHILE_in_sentenciaWHILE845 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_funcion_predefinida_in_expr888 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OR_in_expr901 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr905 = new BitSet(new long[]{0xC0048F032A100000L,0x000000000000FFFFL});
    public static final BitSet FOLLOW_expr_in_expr909 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_AND_in_expr920 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr924 = new BitSet(new long[]{0xC0048F032A100000L,0x000000000000FFFFL});
    public static final BitSet FOLLOW_expr_in_expr928 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_IGUAL_in_expr942 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr946 = new BitSet(new long[]{0xC0048F032A100000L,0x000000000000FFFFL});
    public static final BitSet FOLLOW_expr_in_expr950 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DISTINTO_in_expr959 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr963 = new BitSet(new long[]{0xC0048F032A100000L,0x000000000000FFFFL});
    public static final BitSet FOLLOW_expr_in_expr967 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MAYOR_in_expr976 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr980 = new BitSet(new long[]{0xC0048F032A100000L,0x000000000000FFFFL});
    public static final BitSet FOLLOW_expr_in_expr984 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MENOR_in_expr993 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr997 = new BitSet(new long[]{0xC0048F032A100000L,0x000000000000FFFFL});
    public static final BitSet FOLLOW_expr_in_expr1001 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MAYORIGUAL_in_expr1010 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1014 = new BitSet(new long[]{0xC0048F032A100000L,0x000000000000FFFFL});
    public static final BitSet FOLLOW_expr_in_expr1018 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MENORIGUAL_in_expr1027 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1031 = new BitSet(new long[]{0xC0048F032A100000L,0x000000000000FFFFL});
    public static final BitSet FOLLOW_expr_in_expr1035 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MAS_in_expr1052 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1056 = new BitSet(new long[]{0xC0048F032A100000L,0x000000000000FFFFL});
    public static final BitSet FOLLOW_expr_in_expr1060 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MENOS_in_expr1072 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1076 = new BitSet(new long[]{0xC0048F032A100000L,0x000000000000FFFFL});
    public static final BitSet FOLLOW_expr_in_expr1080 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NOT_in_expr1095 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1099 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NEGAR_in_expr1110 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1114 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PROD_in_expr1127 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1131 = new BitSet(new long[]{0xC0048F032A100000L,0x000000000000FFFFL});
    public static final BitSet FOLLOW_expr_in_expr1135 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DIV_in_expr1154 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1158 = new BitSet(new long[]{0xC0048F032A100000L,0x000000000000FFFFL});
    public static final BitSet FOLLOW_expr_in_expr1162 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MOD_in_expr1171 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1175 = new BitSet(new long[]{0xC0048F032A100000L,0x000000000000FFFFL});
    public static final BitSet FOLLOW_expr_in_expr1179 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_atom_in_expr1187 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PREFIJO_in_prim1207 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_NOMBRE_VAR_in_prim1210 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_prim1212 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INT_in_prim1216 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_INT_in_prim1220 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_POSTFIJO_in_prim1230 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_NOMBRE_VAR_in_prim1233 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_prim1235 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INT_in_prim1239 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_INT_in_prim1243 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_expr_in_listaExpr1290 = new BitSet(new long[]{0xC0048F032A100002L,0x000000000000FFFFL});
    public static final BitSet FOLLOW_expr_in_listaExpr1298 = new BitSet(new long[]{0xC0048F032A100002L,0x000000000000FFFFL});
    public static final BitSet FOLLOW_LPAR_in_atom1337 = new BitSet(new long[]{0xC0048F032A100000L,0x000000000000FFFFL});
    public static final BitSet FOLLOW_expr_in_atom1339 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_RPAR_in_atom1341 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_prim_in_atom1348 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_atom1355 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOAT_in_atom1362 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_atom1370 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CHAR_in_atom1377 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_atom1384 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_LCOR_in_atom1386 = new BitSet(new long[]{0xC0048F032A100000L,0x000000000000FFFFL});
    public static final BitSet FOLLOW_expr_in_atom1390 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_RCOR_in_atom1392 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_atom1399 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_llamada_in_atom1407 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_F_LEER_in_leer1436 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_FORMATO_in_leer1439 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_STRING_in_leer1441 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NOMBRE_VAR_in_leer1445 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_leer1447 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_F_LEER_in_leer1463 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_FORMATO_in_leer1466 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_STRING_in_leer1468 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NOMBRE_VAR_in_leer1472 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_leer1474 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INDICE_in_leer1478 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_leer1480 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_F_IMPRIMIR_in_imprimir1520 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_FORMATO_in_imprimir1523 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_STRING_in_imprimir1525 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NOMBRE_VAR_in_imprimir1531 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_listaExpr_in_imprimir1533 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_F_IMPRIMIR_in_imprimir1544 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_FORMATO_in_imprimir1547 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_STRING_in_imprimir1549 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_leer_in_funcion_predefinida1572 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_imprimir_in_funcion_predefinida1577 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pow_in_funcion_predefinida1582 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_sqrt_in_funcion_predefinida1589 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_gets_in_funcion_predefinida1596 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_strlen_in_funcion_predefinida1601 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_F_POW_in_pow1621 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_pow1625 = new BitSet(new long[]{0xC0048F032A100000L,0x000000000000FFFFL});
    public static final BitSet FOLLOW_expr_in_pow1629 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_F_SQRT_in_sqrt1651 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_sqrt1655 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_F_STRLEN_in_strlen1677 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_strlen1679 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_F_GETS_in_gets1698 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_gets1700 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_define_in_precompilacion1728 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DEFINE_in_define1753 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_NOMBRE_VAR_in_define1756 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_define1760 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_VALOR_in_define1764 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_atom_in_define1768 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ASIGNACION_in_synpred1_Eval558 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_EXPRESION_in_synpred1_Eval561 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_synpred1_Eval563 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ASIGNACION_in_synpred2_Eval578 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_EXPRESION_in_synpred2_Eval581 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_listaExpr_in_synpred2_Eval583 = new BitSet(new long[]{0x0000000000000008L});

}