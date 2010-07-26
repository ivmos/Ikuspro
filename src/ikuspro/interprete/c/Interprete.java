package ikuspro.interprete.c;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import ikuspro.gui.ConfiguracionGUI;
import ikuspro.interprete.IInterprete;
import ikuspro.modelo.DetectorEncoding;
import ikuspro.modelo.EFile;
import ikuspro.modelo.InterpreteModelo;
import ikuspro.simulador.Mensaje;
import ikuspro.simulador.Simulador;

import org.antlr.runtime.*;
import org.antlr.runtime.tree.BufferedTreeNodeStream;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeNodeStream;
import org.antlr.runtime.tree.TreeNodeStream;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;


import com.sun.org.apache.xerces.internal.parsers.DOMParser;
import com.sun.xml.internal.txw2.Document;


import antlr.BaseAST;
import antlr.StringUtils;


/**
 * 
 * @author Iván Mosquera Paulo
 * 
 * Implementación de un intérprete de C que se ajusta a los requisitos de la asignatura
 * "Fundamentos de Informática" del departamento LSI de EUITI-BI (UPV/EHU).
 */
public class Interprete implements IInterprete {
	
	// Todo interprete debe dar esta información
	public static final int INDICE_INICIO_ARRAY = 0;
	public static final String NOMBRE = "euiti-bi_LSI_FI_C";
	public static final String VERSION = "1.0a";
	public static final String EXTENSIONES = "c cpp";
	// // // //
	
	private static final Logger LOGGER = Logger.getLogger(Interprete.class.getName());
	
	private static TablaSimbolos tablaSimbolos = new TablaSimbolos();
	
	private static BufferedTreeNodeStream nodos;
    private static final ResourceBundle mensajes = ResourceBundle.getBundle("ikuspro/gui/Mensajes");
	
	
	private String entrada;
	private EFile fichero;
	
	private Simulador simulador;
	private DetectorEncoding detectorEncoding;
	
	public Interprete(final Simulador pSimulador) {
		detectorEncoding = new DetectorEncoding();
		simulador = pSimulador;
	}
	
	public Interprete() {
		detectorEncoding = new DetectorEncoding();
	}
	
	public void ejecutar() throws Exception {
		simulador.setIniciado(true);
		LOGGER.setLevel(Level.WARNING);
		String entrada = "";
		
		
		String encoding = fichero.getEncoding();
		tablaSimbolos.reinicializar();
		
		entrada = fichero.getContenido();
		CharStream input = new ANTLRStringStream(entrada); 
		LOGGER.info("Voy a correr lexer");
		CLexer lexer = new CLexer(input); // Análisis léxico
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		
		CParser parser = new CParser(tokens); // Análisis sintáctico
		
		try {
			LOGGER.info("Analizando...");
			CParser.programa_return r = parser.programa();
			CommonTree t = (CommonTree)r.getTree(); 
			LOGGER.info(t.toStringTree());
			
			// Interprete
			setNodos(new BufferedTreeNodeStream(t));
			LOGGER.info("Interpretando funciones...");
			FuncionEval funcionEval = new FuncionEval(nodos); // Primera pasada al AST
			funcionEval.programa();
			
			LOGGER.info(t.toStringTree());
			setNodos(new BufferedTreeNodeStream(t));
			Eval eval = new Eval(nodos,this); // Segunda pasada al AST
			eval.programa();
			
			
		
		} catch (Exception e) {
			if (! (e instanceof java.lang.InterruptedException || e instanceof java.lang.RuntimeException)) {
				
				final String mensaje=mensajes.getString("Ha_ocurrido_un_error..") + "\n" + 
						mensajes.getString("Puede_ser_debido_a") + "\n" + mensajes.getString("-_Un_valor_inaceptable_para_un_tipo_de") +
						 "\n" + mensajes.getString("-_Código_incorrecto_(depure_el_código_con_un_compilador)");
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						JOptionPane.showMessageDialog(null,
								mensaje, "Error", JOptionPane.ERROR_MESSAGE );
	
					}
				});
			}
			e.printStackTrace();
			
			
		} finally {
			//simulador.getInterpreteModelo().setEjecutando(false);
			simulador.setTerminar(false);
		}
		simulador.setIniciado(false);
		//enviar("FIN"); // Es necesario mandar algo finalmente al simulador por si 
						// se ha quedado esperando, un poco chapuza pero podría ser más grave
		
	}
	
	public void ejecutarConsola() throws Exception {
		
		
		String entrada = "";
		fichero.leer();
		tablaSimbolos.reinicializar();
		
		entrada = fichero.getContenido();
		CharStream input = new ANTLRStringStream(entrada); 
		LOGGER.info("Voy a correr lexer");
		CLexer lexer = new CLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		LOGGER.info("Voy a correr parser");
		CParser parser = new CParser(tokens);
		//parser.programa();
		LOGGER.info("Voy a ejecutar");
		CParser.programa_return r = parser.programa();
		
//		
//		
		CommonTree t = (CommonTree)r.getTree(); 
		//System.out.println(t.toStringTree());
		
		// Interprete
		setNodos(new BufferedTreeNodeStream(t));
		
		FuncionEval funcionEval = new FuncionEval(nodos);
		funcionEval.programa();
		//System.out.println(t.toStringTree());
		setNodos(new BufferedTreeNodeStream(t));
		Eval eval = new Eval(nodos,this);
		eval.programa();
	
	}
	
	
	public static TablaSimbolos getTablaSimbolos() {
		return tablaSimbolos;
	}
	public static void setTablaSimbolos(TablaSimbolos pTablaSimbolos) {
		tablaSimbolos = pTablaSimbolos;
	}
	public static BufferedTreeNodeStream getNodos() {
		return nodos;
	}
	public static void setNodos(BufferedTreeNodeStream pNodos) {
		nodos = pNodos;
	}




	public void enviar(String pTexto) {
		if (isConectadoIkuspro()) {
			try {
				// Parece raro, pero parece necesario mirar el encoding del string que se manda
				// desde el parser. Que el origen sea UTF-8 no implica que este mensaje lo sea.
				
				String cabecera = "<?xml version=\"1.0\" encoding=\"" + detectorEncoding.detectar(pTexto) +"\"?>";
				//System.out.println(cabecera + pTexto);
				if (simulador.isIniciado()) {
					simulador.entregar(new Mensaje(cabecera + pTexto));
				} else {
					// Esto es muy sucio y no debería hacerse pero es que desde el interprete no es fácil parar la ejecución
					// una vez terminada.
					// Ocurre que de lo contrario cuando se da a cancelar este hilo queda vivo.
					// Con más tiempo habría implementado una alternativa
					
					Thread.currentThread().interrupt(); // puajj!!
				}
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			// Al usar interprete aisladamente es normal tirar de consola
			System.out.println(pTexto);
		}
	}

	/**
	 * @return
	 */
	private boolean isConectadoIkuspro() {
		return simulador != null; 
	}


	@Override
	public void run() {
		// Damos un nombre para que se pueda identificar el hilo fácilmente desde jconsole
		Thread.currentThread().setName(Thread.currentThread().getName() + " interprete");
		try {
			ejecutar();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		LOGGER.info("El interprete " + NOMBRE + " ha terminado");
		
	}





	@Override
	public void ejecutar(EFile pFile) throws Exception {
		ejecutar(fichero);
		
	}

	public EFile getFichero() {
		return fichero;
	}

	public void setFichero(EFile pFichero) {
		fichero = pFichero;
	}

	public Simulador getSimulador() {
		return simulador;
	}


	
	
	/**
	 * 
	 * @param args
	 * @throws Exception
	 * 
	 * Permite ejecutar el interprete de forma aislada al resto de ikuspro.
	 * No está muy probado pero funciona.
	 */
	public static void main(String[] args) throws Exception {
		if (args.length == 0) {
			System.out.println("Sintaxis: java Interprete.class C:\tmp\fichero.cpp");
		} else {
			Interprete interprete = new Interprete();
			EFile file = new EFile(new File(args[0]));
			interprete.setFichero(file);
			interprete.ejecutarConsola();
		}
		
	}
	
	/**
	 * 
	 * @param pNombre
	 * @return la lectura realizada gráficamente
	 * 
	 * 
	 */
	public String leerStdinGrafico(final String pNombre) {
    	
		String resultado = "";
		String salida = "";
		if (simulador.isIniciado()) {
			final String ultimaLineaSalida; 
			int longitudSalida = getSimulador().getInterpreteModelo().getListaSalida().size();
			if (longitudSalida > 0) { // Si hay salida almacenada...
				salida = getSimulador().getInterpreteModelo().getListaSalida().get(longitudSalida - 1).getTexto();
				// Queremos que en ultimaLineaSalida esté la última linea de salida real, no simplemente el último printf
				for(int j=longitudSalida - 2; j>=0;j--) { 
					String lineaActual = getSimulador().getInterpreteModelo().getListaSalida().get(j).getTexto();
					if (lineaActual.contains("\n")) {
						break; // No es parte de la ultima linea real
					} else {
						salida = lineaActual + salida;
					}
				}
				ultimaLineaSalida = salida;
			} else {
				ultimaLineaSalida = "";
			}
			
		
			try {
			SwingUtilities.invokeAndWait(new Runnable() {
				public void run() {
					int optionType = JOptionPane.DEFAULT_OPTION;
						int messageType = JOptionPane.PLAIN_MESSAGE; 
						JPanel jpanel = new JPanel();
						jpanel.setLayout(new BorderLayout());
						JButton ok = new JButton("Aceptar");
						final JTextField jt = new JTextField("");
						Object[] selValues = { ok};
						String mensaje = "<html>" + 
	                    "\u00DAltima salida: <b>" + ultimaLineaSalida + "<html>" + "<p>(Introduzca valor para la variable " + "<b>" + pNombre + "</b>)</p></html>";
						JLabel jl = new JLabel(mensaje);
						jpanel.add(jl, BorderLayout.NORTH);
						jpanel.add(jt, BorderLayout.SOUTH);
						JOptionPane jopt = new JOptionPane(jpanel,messageType,optionType,null,selValues);
	
						
						final JDialog dialogo = jopt.createDialog("Entrada est\u00E1ndar");
						ok.addActionListener(new ActionListener() {
	
							@Override
							public void actionPerformed(ActionEvent pArg0) {
								dialogo.dispose();
								
							}
							
						});
						jt.addKeyListener(new EnterKeyListener(dialogo));
						dialogo.addWindowListener(new WindowAdapter()
					     {
						       public void windowOpened(WindowEvent e)
						       {
						         jt.requestFocusInWindow();
						       }
					     });
						dialogo.setIconImage(ConfiguracionGUI.getInstance().getIconoIkuspro());
						dialogo.setVisible(true);
						entrada = jt.getText();
						
					
				}
			});
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
	            if (entrada.equals("")) { 
	            	resultado = "0"; 
	            } else {
	            	resultado = entrada;
	            }
		} else {
			throw new RuntimeException(); // Usamos esta excepcion para abortar, mejor que parar con stop
											// creo que es.
		}
		return resultado;
	
	}
	
	/**
	 * 
	 * @return la lectura realizada por consola
	 * 
	 * 
	 */
	public String leerStdinConsola(){
		String resultado = "";
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		try{
			System.out.print("ENTRADA> ");
			resultado = stdin.readLine();
		
			
		}catch (IOException e){
			e.printStackTrace();
			resultado = "error";
		}
		return resultado;
	}
	
	/**
	 * 
	 * @param pNombre
	 * @return la lectura de entrada realizada
	 */
	public String leerStdin(String pNombre) {
		return isConectadoIkuspro()?leerStdinGrafico(pNombre):leerStdin(pNombre);
	}
	
	

}
