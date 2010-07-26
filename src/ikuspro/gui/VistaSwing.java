/**
 * Ikuspro 1.0
 *
 * Copyright 2010,
 *
 * Ivan Mosquera Paulo (ivanmosp@gmail.com)
 * Mikel Villamañe Girones (mikel.villamane@ehu.es)
 *
 * Licensed under the GNU General Public License (*)
 *
 * (*) Complete information is provided at license.txt
 *
 **/




package ikuspro.gui;





import ikuspro.controlador.Controlador;
import ikuspro.gui.util.GuiUtil;
import ikuspro.main.ConfiguracionMain;
import ikuspro.modelo.EFileModelo;
import ikuspro.modelo.EFileModeloObserver;
import ikuspro.modelo.InterpreteModelo;
import ikuspro.modelo.InterpreteModeloObserver;
import ikuspro.simulador.IUSimulador;
import ikuspro.vista.Vista;

import java.awt.Point;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.fife.ui.rsyntaxtextarea.SyntaxConstants;



public class VistaSwing extends Vista  {


	private static final Logger LOGGER = Logger.getLogger(VistaSwing.class.getName());
    private static final ResourceBundle mensajes = ResourceBundle.getBundle("ikuspro/gui/Mensajes");
	private IUVentanaPrincipal ventana;
	private InterpreteModelo modeloTmp; // Usar solo para el caso en que por un error se ha perdido
										// el evento MVC. Se usa como contenedor temporal.

	public VistaSwing(Controlador pControlador, EFileModelo pEfileModelo,
			InterpreteModelo pInterpreteModelo) {
		super(pControlador,pEfileModelo, pInterpreteModelo);
		LOGGER.setLevel(Level.WARNING);
		LOGGER.info("En gui");

		GuiUtil.setNativeLookAndFeel();
		ventana = new IUVentanaPrincipal(this,null);
		ventana.instalarMenu();

		getEfileModelo().anyadirModeloObserver(
				new EFileModeloObserver() {
					public void actualizar(final EFileModelo pModelo) {
						actualizarModeloFichero();

					}
				}

		);

		getInterpreteModelo().anyadirModeloObserver (
				new InterpreteModeloObserver() {

					public void actualizar(final InterpreteModelo pModelo) {
						actualizarModeloInterprete(pModelo);


					}
				}
		);

	}







	@Override
	public void abrirFichero() {
		new IUAbrirFichero(this);


	}


	public String getContenidoEditor() {
		return ventana.getEditor().getText();
	}


	@Override
	public void guardarFicheroComo(String pContenido) {
		new IUGuardarComoFichero(this,pContenido);

	}

	@Override
	public IUVentanaPrincipal getVentana() {
		return ventana;
	}




	@Override
	public void deshacerEditor() {
		ventana.getEditor().undoLastAction();

	}

	@Override
	public void rehacerEditor() {
		ventana.getEditor().redoLastAction();
	}






	@Override
	public IUEditor getEditor() {
		// TODO Auto-generated method stub
		return ventana.getEditor();
	}



	@Override
	public void seleccionarTodoEditor() {
		ventana.getEditor().selectAll();

	}


	@Override
	public void buscarReemplazarEditor() {
		ventana.getBarraEstado().add(ventana.getBarraBuscarReemplazar());

		ventana.pack();
	}


	@Override
	public void mostrarAcercaDe() {
		IUAcercaDe iua = new IUAcercaDe(ventana,true);
		iua.setVisible(true);
	}


	@Override
	public void copiarEditor() {
		ventana.getEditor().copy();

	}


	@Override
	public void addListener(ActionListener pListener) {
		ventana.getBarraMenu().addActionListener(pListener);
		ventana.getBarraHerramientas().addActionListener(pListener);
	}

	/**
	 *
	 */
	private void activarBotonesSimulacionEnCurso() {
		ventana.getJButtonSimular().setEnabled(false);
		ventana.getJButtonSiguiente().setEnabled(true);
		ventana.getJButtonTerminar().setEnabled(true);
		ventana.getJButtonCancelar().setEnabled(true);
		ventana.getBarraHerramientas().getBarraHerramientasCortar().setEnabled(false);
		ventana.getBarraHerramientas().getBarraHerramientasDeshacer().setEnabled(false);
		ventana.getBarraHerramientas().getBarraHerramientasPegar().setEnabled(false);
		ventana.getBarraMenu().getJMenuSimulacionIniciar().setEnabled(false);
		ventana.getBarraMenu().getJMenuSimulacionAvanzar().setEnabled(true);
		ventana.getBarraMenu().getJMenuSimulacionTerminar().setEnabled(true);
		ventana.getBarraMenu().getJMenuSimulacionCancelar().setEnabled(true);
	}



	private void activarBotonIniciarYdesactivarBotonesSimulacionCurso() {
		ventana.getJButtonSimular().setEnabled(true);
		ventana.getJButtonSiguiente().setEnabled(false);
		ventana.getJButtonTerminar().setEnabled(false);
		ventana.getJButtonCancelar().setEnabled(false);
		ventana.getBarraMenu().getJMenuSimulacionIniciar().setEnabled(true);
		ventana.getBarraHerramientas().getBarraHerramientasCortar().setEnabled(true);
		ventana.getBarraHerramientas().getBarraHerramientasDeshacer().setEnabled(true);
		ventana.getBarraHerramientas().getBarraHerramientasPegar().setEnabled(false);
		ventana.getBarraMenu().getJMenuSimulacionAvanzar().setEnabled(false);
		ventana.getBarraMenu().getJMenuSimulacionTerminar().setEnabled(false);
		ventana.getBarraMenu().getJMenuSimulacionCancelar().setEnabled(false);

		// Esto asegura que se marca la ultima linea
		ventana.getEditor().setPosicionCursor(0, modeloTmp.getLinea());
	}



	/**
	 *
	 */
	private void actualizarModeloFichero() {
		final String extension = getEfileModelo().getExtFile();


		if (extension == null || extension.equals("cpp") || extension.equals("c")) {
				ventana.getEditor().setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_C);
		} else if (extension.equals("ada")) {
				// No hay soporte de la libreria para Ada, si lo quieres lo puedes implementar
				// echa un vistazo a la docu
				ventana.getEditor().setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_NONE);
		}
		ventana.getEditor().setText(getEfileModelo().getStrFile());
		ventana.setTitle(getEfileModelo().getFileName() + " - " + ConfiguracionMain.NOMBRE_PROY + " " + ConfiguracionMain.VERSION);
		ventana.setComentarios("");
		ventana.setSalida("");
		IUSimulador.getInstance().iniciar();
	}


	/**
	 * @param pModelo
	 */
	private void actualizarModeloInterprete(final InterpreteModelo pModelo) {
		modeloTmp = pModelo;
		if (!pModelo.interpretandoSinParar() || !pModelo.isEjecutando()) {
			ventana.restablecerOcupado();
			if (pModelo.isNuevaSalidaDisponible()) {
				ventana.setSalida(pModelo.getLinea(), pModelo.getListaSalida());
				pModelo.setNuevaSalidaDisponible(false);
			}
			if (pModelo.isNuevoComentarioDisponible()) {
				ventana.setComentarios(pModelo.getLinea(), pModelo.getListaComentarios());
				pModelo.setNuevoComentarioDisponible(false);
			}
			ventana.getEditor().setPosicionCursor(0, pModelo.getLineaAnterior());
			// Mostramos la ultima parte del simulador grafico, que sera probablemente la
			// de mas a la dcha.

			// BUG: esto produce flick
			if (IUSimulador.getInstance().getWidth() > ventana.getScrollPanelSimulador().getViewport().getWidth()) {
			ventana.getScrollPanelSimulador().getViewport().setViewPosition(new Point(
					IUSimulador.getInstance().getPosicionScroll().intValue(),0));
			}

		} else { // Si esta interpretando sin parar..
				//ventana.getMultiSplitPane().setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
				ventana.mostrarOcupado();

		}
		if(pModelo.isEjecutando() && !pModelo.interpretandoSinParar()) {
			ventana.getEditor().setInterpretando(true);

			activarBotonesSimulacionEnCurso();

		} else if (!pModelo.interpretandoSinParar()){
			ventana.getEditor().setInterpretando(false);
			activarBotonIniciarYdesactivarBotonesSimulacionCurso();

			//ventana.getMultiSplitPane().updateUI();
		}
	}




}
