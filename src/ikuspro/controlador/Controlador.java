/**
 * Ikuspro 1.0
 *
 * Copyright 2010,
 * Ivan Mosquera Paulo (ivanmosp@gmail.com)
 * Mikel Villamañe Girones (mikel.villamane@ehu.es)
 *
 * Licensed under the GNU General Public License (*)
 *
 * (*) Complete information is provided at license.txt
 *
 **/


package ikuspro.controlador;

import ikuspro.gui.ConfiguracionGUI;
import ikuspro.gui.VistaSwing;
import ikuspro.gui.util.Impresora;
import ikuspro.main.ConfiguracionMain;
import ikuspro.main.Ikuspro;
import ikuspro.modelo.EFileModelo;
import ikuspro.modelo.InterpreteModelo;
import ikuspro.simulador.IUSimulador;
import ikuspro.vista.Vista;

import java.awt.Component;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.Book;
import java.awt.print.PageFormat;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.beans.XMLEncoder;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Logger;
import java.util.prefs.Preferences;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import org.jdesktop.swingx.MultiSplitLayout.Node;







public class Controlador implements IControlador, ActionListener {
	private final EFileModelo efileModelo;
	private final InterpreteModelo interpreteModelo;
	private Vista vista;
	private boolean aceptado;
	private static final Logger LOGGER = Logger.getLogger(Controlador.class.getName());
	private static final ResourceBundle mensajes = ResourceBundle.getBundle("ikuspro/gui/Mensajes");

	private static final String ENGLISH = "English";
	private static final String EUSKARA = "Euskara";
	private static final String ESPAÑOL = "Español";
	private static final String DEFAULT = "Default";

	/**
	 *
	 * @author Iván Mosquera Paulo
	 *
	 * Comandos del controlador
	 */
	public static enum Comando {
		GUARDAR,
		GUARDARCOMO,
		SELECCIONARTODO,
		BUSCARREEMPLAZAR,
		DESHACER,
		REHACER,
		NUEVO,
		ACERCADE,
		ABRIR,
		IMPRIMIR,
		IMPRIMIR_PRELIMINAR,
		CORTAR,
		COPIAR,
		PEGAR,
		CONFIGURAR_PAGINA,
		SALIR,
		SIMULACION_INICIAR,
		SIMULACION_AVANZAR,
		SIMULACION_TERMINAR,
		SIMULACION_CANCELAR,
		SELECCIONAR_IDIOMA,
		MOSTRAR_MANUAL_AYUDA;
	}


	public Controlador(EFileModelo pEfileModelo,
			InterpreteModelo pInterpreteModelo) {
		LOGGER.setLevel(ConfiguracionMain.LOGGER_LEVEL);
		this.efileModelo = pEfileModelo;
		this.interpreteModelo = pInterpreteModelo;
		aceptado = false;

		final Controlador controlador = this;
		try {
			SwingUtilities.invokeAndWait(new Runnable() {

				@Override
				public void run() {
					crearVista(controlador);
				}
			});
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		abrirFicheroPorDefecto();
		LOGGER.info("VISTA creada");
	}



	/**
	 * @param controlador
	 */
	private void crearVista(final Controlador controlador) {
		vista = new VistaSwing(controlador, efileModelo, interpreteModelo);
		vista.addListener(this);
	}



	/**
	 *
	 */
	private final void abrirFicheroPorDefecto() {
		if (ConfiguracionGUI.getInstance().getUltimoFicheroAbierto() == null) {
			InputStream s =
			Thread.currentThread().getContextClassLoader().getResourceAsStream(ConfiguracionMain.FICHERO_DEFAULT);
			abrirFichero(s,ConfiguracionMain.FICHERO_DEFAULT);

		} else {
			abrirFichero(ConfiguracionGUI.getInstance().getUltimoFicheroAbierto());
		}

	}



	@Override
	public void abrirFichero() {
		//TODO Habría que obtener del modelo los tipos disponibles...
		interpreteModelo.cancelar();
		vista.abrirFichero();
	}

	@Override
	public void guardarFicheroComo() {
		guardarFicheroComo(vista.getContenidoEditor());

	}

	@Override
	public void guardarFichero(String pContenido) {
		if (efileModelo.existe()) {
			efileModelo.setFile(pContenido);
			LOGGER.info("Existe, guardar directamente.. " + efileModelo.getAbsolutFileName());
		} else {
			LOGGER.info("No existe, guardar como.. " + efileModelo.getAbsolutFileName());
			guardarFicheroComo(pContenido);
		}

	}

	public void guardarFicheroComo(String pContenido) {
		vista.guardarFicheroComo(pContenido);

	}

	@Override
	public void guardarFichero() {
		guardarFichero(vista.getContenidoEditor());

	}

	@Override
	public void abrirFichero(File pFile) {

		interpreteModelo.cancelar();
		efileModelo.setFile(pFile);

	}

	@Override
	public void abrirFichero(InputStream pInputStream, String pNombre) {
		interpreteModelo.cancelar();
		efileModelo.setFile(pInputStream, pNombre);
	}

	@Override
	public void guardarFichero(File pFile, String pContenido) {
		abrirFichero(pFile);
		guardarFichero(pContenido);
		abrirFichero(pFile);
	}

	@Override
	public void salir() {


		Node model = vista.getVentana().getMultiSplitPane().getMultiSplitLayout().getModel();
		ByteArrayOutputStream xml = new ByteArrayOutputStream();
		XMLEncoder e =
	           new XMLEncoder(
	              xml);
	        e.writeObject(model);
	        e.close();


	    Preferences prefs = Preferences
			.userNodeForPackage(Ikuspro.class) ;
	    String xml_guardar = xml.toString();
	    String parte1 = xml_guardar.substring(0,xml_guardar.length() / 2); // Hasta la mitad
	    String parte2 = xml_guardar.substring(xml_guardar.length() / 2 , xml_guardar.length() - 1);
		prefs.put("MULTISPLITPANE_PARTE1", parte1);
		prefs.put("MULTISPLITPANE_PARTE2", parte2);

		ConfiguracionGUI.getInstance().guardar();

		if (ficheroCambiosNoGuardados()){
			String mensaje = mensajes.getString("Ha_realizado_cambios_que_no_ha_guardado._¿Seguro_que_desea_salir?");
			int resultado = JOptionPane.showConfirmDialog(vista.getVentana(),
					mensaje, mensajes.getString("Aviso"),
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

			if (resultado == JOptionPane.OK_OPTION) {
				System.exit(0);
			}

		} else {
			System.exit(0);
		}



	}





	private boolean ficheroCambiosNoGuardados() {
		return !(vista.getContenidoEditor().equals(efileModelo.getStrFile()));
	}

	@Override
	public void deshacerEditor() {
		vista.deshacerEditor();

	}

	@Override
	public void rehacerEditor() {
		vista.rehacerEditor();
	}

	@Override
	public void seleccionarTodoEditor() {
		vista.seleccionarTodoEditor();

	}

	@Override
	public void buscarReemplazarEditor() {
		vista.buscarReemplazarEditor();

	}

	public void configurarPagina() {
		PrinterJob pj = PrinterJob.getPrinterJob();
		PageFormat mPageFormat = pj.defaultPage();
		Impresora.getInstance().setFormatoPagina(pj.pageDialog(mPageFormat));
	}






	private void imprimir() {


		JCheckBox checkboxEditor = new JCheckBox(mensajes.getString("Editor"));
		JCheckBox checkboxSim = new JCheckBox(mensajes.getString("Simulación_gráfica"));
		JCheckBox checkboxComentarios = new JCheckBox(mensajes.getString("Comentarios"));
		JCheckBox checkboxSalida = new JCheckBox(mensajes.getString("Salida_estándar"));

		String message = mensajes.getString("Seleccione_los_elementos_que_desea_imprimir:");
		// Hemos dejado fuera la simulación porque no funciona adecuadamente y no hay tiempo
		// de mejorarlo
		Object[] params = {message, checkboxEditor, checkboxComentarios, checkboxSalida};
		int n = JOptionPane.showConfirmDialog(vista.getVentana(), params, mensajes.getString("Configurar_impresión"), JOptionPane.OK_CANCEL_OPTION);


		PrinterJob pj = PrinterJob.getPrinterJob();
		Book book = new Book();

        int i = 0;

		List<Component> listaAimprimir = new ArrayList<Component>();
		if (checkboxEditor.isSelected()) {
			int maximo = (vista.getEditor().paginarContenidoEditor(vista.getEditor().getText())).size();

			int j = 0;
			for (j=0;j<=maximo-1;j++) {
				listaAimprimir.add(vista.getEditor());
				Impresora.getInstance().getFormatoPagina().setOrientation(PageFormat.PORTRAIT);
				book.append(vista.getEditor(), Impresora.getInstance().getFormatoPagina(), 1);
			}
			i += j;
		}
		if (checkboxSim.isSelected()) {
			PageFormat landscape = pj.defaultPage();
			landscape.setPaper(Impresora.getInstance().getFormatoPagina().getPaper());
	        landscape.setOrientation(PageFormat.LANDSCAPE);
			book.append(IUSimulador.getInstance(), landscape,1);
			i += 1;
		}
		if (checkboxSalida.isSelected()) {
			int maximo = (vista.getVentana().getVisorSalida().paginarContenidoEditor(
					vista.getVentana().getVisorSalida().getListaTextoActual())
				).size();
			vista.getVentana().getVisorSalida().setPrimeraPaginaImprimir(i);
			int j = 0;
			for (j=0;j<=maximo-1;j++) {
				Impresora.getInstance().getFormatoPagina().setOrientation(PageFormat.PORTRAIT);
				book.append(vista.getVentana().getVisorSalida(), Impresora.getInstance().getFormatoPagina(), 1);
			}
			i += j;
		}
		if (checkboxComentarios.isSelected()) {

			int maximo = (vista.getVentana().getVisorComentarios().paginarContenidoEditor(
										vista.getVentana().getVisorComentarios().getListaTextoActual())
									).size();
			vista.getVentana().getVisorComentarios().setPrimeraPaginaImprimir(i);
			int j = 0;
			for (j=0;j<=maximo-1;j++) {
				Impresora.getInstance().getFormatoPagina().setOrientation(PageFormat.PORTRAIT);
				book.append(vista.getVentana().getVisorComentarios(), Impresora.getInstance().getFormatoPagina(), 1);
			}
			i += j;
		}


		if (n == JOptionPane.OK_OPTION) {

			pj.setPageable(book);
			if (pj.printDialog()) {
				try { pj.print(); }
				catch (PrinterException e) {
					e.printStackTrace();
				}
			}
		}
	}





	@Override
	public void iniciarSimulacion() {
		LOGGER.info(mensajes.getString("Simular"));
		LOGGER.info(mensajes.getString("La_extension_es_") + efileModelo.getExtFile());
		final boolean cambiosNoGuardados = ficheroCambiosNoGuardados();
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				if (cambiosNoGuardados){
					String mensaje = mensajes.getString("Se_guardaran_los_cambios_antes_de_realizar_la_simulacion");

					int resultado = JOptionPane.showConfirmDialog(vista.getVentana(),
							mensaje, mensajes.getString("Aviso"),
							JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);

					aceptado = (resultado == JOptionPane.OK_OPTION);
					if (aceptado) {
						guardarFichero();
					}
					//if (aceptado || !cambiosNoGuardados) {
					if (!cambiosNoGuardados) {
						interpreteModelo.ejecutar(efileModelo.getEfile());
					}
					aceptado = false;
				} else {
					interpreteModelo.ejecutar(efileModelo.getEfile());
					IUSimulador.getInstance().mostrarBotones();
				}
			}
		});


	}


	public void cortarEditor() {
		vista.getEditor().cut();
	}



	public void copiarEditor() {
		vista.copiarEditor();
	}

	public void pegarEditor() {
		vista.getEditor().paste();
	}

	public void mostrarAcercaDe() {

		vista.mostrarAcercaDe();
	}



	@Override
	public void terminarSimulacion() {
		if (interpreteModelo.isSimuladorIniciado()) {

			interpreteModelo.terminar();
			interpreteModelo.siguiente();
		}

	}

	@Override
	public void cancelarSimulacion() {

		if (interpreteModelo.isSimuladorIniciado()) {
			interpreteModelo.cancelar();

		}
		vista.getEditor().setInterpretando(false);

	}

	public void avanzarSimulacion() {
		if (interpreteModelo.isSimuladorIniciado()) {
			interpreteModelo.siguiente();
		}
	}




	@Override
	/**
	 * Maneja los eventos
	 */
	public void actionPerformed(ActionEvent pEvent) {
		 Comando comando = Comando.valueOf(pEvent.getActionCommand());
		 switch(comando) {
		 	case GUARDAR:
		 		guardarFichero(vista.getContenidoEditor());
		 		break;
		 	case GUARDARCOMO:
		 		guardarFicheroComo();
		 		break;
		 	case SELECCIONARTODO:
		 		seleccionarTodoEditor();
		 		break;
		 	case BUSCARREEMPLAZAR:
		 		buscarReemplazarEditor();
		 		break;
		 	case DESHACER:
		 		deshacerEditor();
		 		break;
		 	case REHACER:
		 		rehacerEditor();
		 		break;
		 	case NUEVO:
		 		crearNuevoFicheroAccion();
		 		break;
		 	case ACERCADE:
		 		mostrarAcercaDe();
		 		break;
		 	case ABRIR:

				abrirFicheroAccion();
		 		break;
		 	case IMPRIMIR:
		 		imprimir();

		 		break;
		 	case IMPRIMIR_PRELIMINAR:

		 		break;
		 	case CORTAR:
		 		cortarEditor();
		 		break;
		 	case COPIAR:
		 		copiarEditor();
		 		break;
		 	case PEGAR:
		 		pegarEditor();
		 		break;
		 	case CONFIGURAR_PAGINA:
		 		configurarPagina();
		 		break;
		 	case SELECCIONAR_IDIOMA:
		 		cambiarIdioma(seleccionarIdioma());
		 		break;
		 	case MOSTRAR_MANUAL_AYUDA:
		 		mostrarManualAyuda();
		 		break;
		 	case SALIR:
		 		salir();
		 		break;
		 	case SIMULACION_INICIAR:
		 		iniciarSimulacion();
		 		break;
		 	case SIMULACION_AVANZAR:
		 		avanzarSimulacion();
		 		break;
		 	case SIMULACION_TERMINAR:
		 		terminarSimulacion();
		 		break;
		 	case SIMULACION_CANCELAR:
		 		cancelarSimulacion();
		 		break;
		 	default:
		 }

	}



	/**
	 *
	 */
	private void crearNuevoFicheroAccion() {
		if (ficheroCambiosNoGuardados()) {
			String mensaje = mensajes.getString("Ha_realizado_cambios_que_no_ha_guardado._¿Desea_continuar?");

			int resultado = JOptionPane.showConfirmDialog(vista.getVentana(),
					mensaje, mensajes.getString("Aviso"),
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

			if (resultado == JOptionPane.OK_OPTION) {
				interpreteModelo.cancelar();
				efileModelo.reiniciar(mensajes.getString("Nuevo") + interpreteModelo.getExtensionesFicheroDisponibles().get(0));
				IUSimulador.getInstance().limpiar();
			}


		} else {
			interpreteModelo.cancelar();
			efileModelo.reiniciar(mensajes.getString("Nuevo") + interpreteModelo.getExtensionesFicheroDisponibles().get(0));
			IUSimulador.getInstance().limpiar();
		}
	}



	/**
	 *
	 */
	private void abrirFicheroAccion() {
		if (ficheroCambiosNoGuardados()) {
			String mensaje = mensajes.getString("Ha_realizado_cambios_que_no_ha_guardado._¿Desea_continuar?");

			int resultado = JOptionPane.showConfirmDialog(vista.getVentana(),
					mensaje, mensajes.getString("Aviso"),
					JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);

			if (resultado == JOptionPane.OK_OPTION) {
				vista.abrirFichero();
			}

		} else {
			vista.abrirFichero();
		}
	}

	private void mostrarManualAyuda() {

		try
	    {
		    File f=new File(System.getProperty("java.io.tmpdir") + System.getProperty("file.separator") + ConfiguracionGUI.FILE_MANUAL_AYUDA);
		    InputStream inputStream= getClass().getResourceAsStream("/" + ConfiguracionGUI.FILE_MANUAL_AYUDA);
		    OutputStream out=new FileOutputStream(f);
		    byte buf[]=new byte[1024];
		    int len;
		    while((len=inputStream.read(buf))>0)
		    	out.write(buf,0,len);
		    out.close();
		    inputStream.close();
		    try {
				Desktop.getDesktop().browse(new URI(System.getProperty("java.io.tmpdir").replace("\\","/") + ConfiguracionGUI.FILE_MANUAL_AYUDA));
			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	    } catch (IOException e){
	    	e.printStackTrace();
	    }




	}

	private String seleccionarIdioma() {
		String resultado = null;
		String mensaje = mensajes.getString("Seleccione_el_idioma_que_desea_utilizar_(Default_para_utilizar_el_del_sistema)_:_");
		JComboBox combo = new JComboBox() {{
			addItem(DEFAULT);
			addItem(ESPAÑOL);
			addItem(EUSKARA);
			//addItem(ENGLISH); //No vamos a traducir en inglés

		}};
		Object[] params = {mensaje, combo};
		int n = JOptionPane.showConfirmDialog(null, params, mensajes.getString("Configurar_Idioma"), JOptionPane.OK_CANCEL_OPTION);
		if (n == JOptionPane.OK_OPTION) {
			resultado = combo.getSelectedItem().toString();
			JOptionPane.showConfirmDialog(null, mensajes.getString("El_cambio_de_idioma_se_efectuará_en_la_próxima_ejecución_de_Ikuspro."),mensajes.getString("Cambio_de_idioma"),JOptionPane.DEFAULT_OPTION);
		}
		return resultado!=null?resultado.toUpperCase():resultado;
	}



	private String convertirPrimeraLetraAmayusc(String pCad) {
		String aux = pCad;
		char primera = pCad.toCharArray()[0];
		primera = Character.toUpperCase(primera);
		char[] resul = null;
		resul[0] = primera;
		for(int i=1;i<=pCad.length();i++) {
			resul[i] = pCad.charAt(i);
		}
		return String.valueOf(resul);
	}

	@Override
	public void cambiarIdioma(final String pSeleccionarIdioma) {

		 if (pSeleccionarIdioma != null) {

				ConfiguracionMain.Idioma idioma = ConfiguracionMain.Idioma.valueOf(
								pSeleccionarIdioma);
				switch(idioma) {
				case DEFAULT:
					ConfiguracionGUI.getInstance().setLocale(null);
				case ESPAÑOL:
					ConfiguracionGUI.getInstance().setLocale(new Locale("es","ES"));
					break;
				case EUSKARA:
					ConfiguracionGUI.getInstance().setLocale(new Locale("eu","ES"));
					break;
				case ENGLISH:
					ConfiguracionGUI.getInstance().setLocale(Locale.US);
					break;
					default:
				}
		 }


	}



}


