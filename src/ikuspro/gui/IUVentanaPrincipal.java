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




/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * IUPrincipal.java
 *
 * Created on 17-abr-2009, 21:06:09
 */

package ikuspro.gui;

import ikuspro.main.Ikuspro;
import ikuspro.modelo.InterpreteModelo.LogString;
import ikuspro.simulador.IUSimulador;
import ikuspro.vista.Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.Ellipse2D;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.prefs.Preferences;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;

import org.fife.ui.rsyntaxtextarea.SyntaxConstants;
import org.fife.ui.rtextarea.RTextScrollPane;
import org.jdesktop.swingx.JXBusyLabel;
import org.jdesktop.swingx.JXMultiSplitPane;
import org.jdesktop.swingx.MultiSplitLayout;
import org.jdesktop.swingx.MultiSplitLayout.Node;
import org.jdesktop.swingx.icon.EmptyIcon;
import org.jdesktop.swingx.painter.BusyPainter;


/**
 *
 * @author ktulur
 */
public final class IUVentanaPrincipal extends javax.swing.JFrame {


	private static final Logger LOGGER = Logger.getLogger(IUVentanaPrincipal.class
			.getName());
	private Vista vista;

	private IUbarraMenu barraMenu;
	private JToolBar panelBotones;
	private javax.swing.JButton jButtonSimular;
	private javax.swing.JButton jButtonSiguiente;
	private javax.swing.JButton jButtonTerminar;
	private JXBusyLabel jxOcupado;
	private javax.swing.JScrollPane jScrollComentarios;
	private IUVisorTexto visorComentarios;
	private IUVisorTexto visorSalida;
	private JScrollPane jScrollSalida;
	private IUbarraEstado barraEstado;
	private RTextScrollPane panelEditor;
	private IUEditor editor;
	private JXMultiSplitPane multiSplitPane;
	private IUBarraBuscar barraBuscarReemplazar;
	private JScrollPane jScrollSimulacion;

	private IUBarraHerramientas barraHerramientas;
	private IUPanelVisor panelSalida;
	private IUPanelVisor panelComentarios;
	private IUPanelVisor panelSimulador;
	private JButton jButtonCancelar;


	/**
	 *
	 */
	private static final long serialVersionUID = -2769353018536387197L;
    private static final ResourceBundle mensajes = ResourceBundle.getBundle("ikuspro/gui/Mensajes");

	public IUVentanaPrincipal(Vista pVista, File pFile) {
		LOGGER.setLevel(Level.WARNING);
		vista = pVista;
		iniciar(pFile);
	}

	private final void iniciar(File pFile) {

		String layoutDef = "(COLUMN (ROW weight=1.0 left right) (ROW (COLUMN bottom.left.top bottom.left.bottom) bottom.right))";
		//String layoutDef = "(COLUMN (ROW up.left up.right) (ROW weight=1.0 left right) (ROW (COLUMN bottom.left.top bottom.left.bottom) bottom.right))";

		setJMenuBar(getBarraMenu());
		/////////////
		multiSplitPane = new JXMultiSplitPane();
		MultiSplitLayout mspLayout = multiSplitPane.getMultiSplitLayout();

		/// Cargar modelo del GUI
		Node model = null;

		try {
			 Preferences prefs = Preferences
				.userNodeForPackage(Ikuspro.class) ;
			String sModelo = prefs.get("MULTISPLITPANE_PARTE1", null) + prefs.get("MULTISPLITPANE_PARTE2", null);

			ByteArrayInputStream in = new ByteArrayInputStream(sModelo.getBytes());

		    XMLDecoder d = new XMLDecoder(in);
			model = (Node)(d.readObject());
		    mspLayout.setModel(model);
		    mspLayout.setFloatingDividers(false);
		    d.close();
		}
		catch (Exception exc) {
		    model = MultiSplitLayout.parseModel(layoutDef);
		    mspLayout.setModel(model);
		}
		/////////

        multiSplitPane.setDividerSize(5);
        multiSplitPane.getMultiSplitLayout().setModel(model);
       	multiSplitPane.add(getPanelEditor(), "left");
       	multiSplitPane.add(getPanelSimulador("right"), "right");
        multiSplitPane.add(getPanelBotones(), "bottom.left.top");
        multiSplitPane.add(getPanelSalida(this, "bottom.left.bottom"), "bottom.left.bottom");
        multiSplitPane.add(getPanelComentarios(this, "bottom.right"), "bottom.right");
        getContentPane().add(getBarraHerramientas(), BorderLayout.NORTH);
        getContentPane().add(multiSplitPane, BorderLayout.CENTER);


        getContentPane().add(getBarraEstado(),BorderLayout.SOUTH);
        LOGGER.info("Añadir menu");

        setPreferredSize(new Dimension(1024,768));


        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
			vista.getControlador().salir();
			}
		});

        setIconImage(ConfiguracionGUI.getInstance().getIconoIkuspro());
        pack();

		setVisible(true);
	}





	public IUBarraHerramientas getBarraHerramientas() {

		if (barraHerramientas == null) {
			barraHerramientas = IUBarraHerramientas.getInstance();
		}
		return barraHerramientas;
	}

	public final IUbarraMenu getBarraMenu() {
		if (barraMenu == null) {
			barraMenu = new IUbarraMenu(vista);
		}
		return barraMenu;
	}


	public IUEditor getEditor() {
		if (editor == null) {
			editor = new IUEditor();
			editor.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_JAVA);
			editor.setBotonCopiar(barraHerramientas.getInstance().getBarraHerramientasCopiar());
			editor.setBotonCortar(barraHerramientas.getInstance().getBarraHerramientasCortar());
		}
		return editor;
	}

	public final RTextScrollPane getPanelEditor() {
		if (panelEditor == null) {
			editor = getEditor();
		    panelEditor = new RTextScrollPane(editor);

		}
		return panelEditor;

	}

	public final JScrollPane getScrollPanelSimulador() {

		if (jScrollSimulacion == null) {
			jScrollSimulacion = new JScrollPane();
			jScrollSimulacion.setViewportView(IUSimulador.getInstance());
//			jScrollSimulacion.getHorizontalScrollBar().setBlockIncrement(150);
//			jScrollSimulacion.getVerticalScrollBar().setBlockIncrement(150);

		}
		return jScrollSimulacion;
	}

	private JToolBar getPanelBotones() {
		if (panelBotones == null) {
			panelBotones = new JToolBar();
			panelBotones.setFloatable(false);

			panelBotones.setLayout(new BoxLayout(panelBotones, BoxLayout.X_AXIS));


	        jButtonSimular = new javax.swing.JButton() {{
	        	setIcon(new ImageIcon(getClass().getResource(ConfiguracionGUI.RUTA_ICONOS_32 + "/iconoSimular.png")));
	        	setEnabled(true);
	        	setToolTipText(mensajes.getString("Iniciar_simulación"));
	        	setFocusable(false);

	        	addActionListener(new ActionListener() {
		        	public void actionPerformed(ActionEvent event) {
		        		vista.getControlador().iniciarSimulacion();
		        	}
		        });

	        }};
	        jButtonSiguiente = new javax.swing.JButton() {{
	        	setIcon(new ImageIcon(getClass().getResource(ConfiguracionGUI.RUTA_ICONOS_32 + "/iconoSiguiente.png")));
	        	setEnabled(false);
	        	setToolTipText(mensajes.getString("Avanzar_simulación"));
	        	setFocusable(false);
	        	addActionListener(new ActionListener() {
		        	public void actionPerformed(ActionEvent event) {
		        		vista.getControlador().avanzarSimulacion();
		        	}
		        });
	        }};

	        jButtonTerminar = new javax.swing.JButton() {{
	        	setIcon(new ImageIcon(getClass().getResource(ConfiguracionGUI.RUTA_ICONOS_32 + "/iconoTerminar.png")));
	        	setEnabled(false);
	        	setToolTipText(mensajes.getString("Terminar_simulación"));
	        	setFocusable(false);
	        	addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent pArg0) {
						vista.getControlador().terminarSimulacion();

					}
		        });
	        }};

	        jButtonCancelar = new javax.swing.JButton() {{
	        	setIcon(new ImageIcon(getClass().getResource(ConfiguracionGUI.RUTA_ICONOS_32 + "/iconoCancelar.png")));
	        	setEnabled(false);
	        	setToolTipText(mensajes.getString("Cancelar_simulación"));
	        	setFocusable(false);
	        	addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent pArg0) {
						vista.getControlador().cancelarSimulacion();

					}
		        });
	        }};



	        jxOcupado = new JXBusyLabel(new Dimension(150,150));

	        BusyPainter painter = new BusyPainter(

	        new Ellipse2D.Float(0, 0,25.5f * 1.0f,25.0f * 1.0f),
	    	new Ellipse2D.Float(15.0f * 1.5f,15.0f * 1.5f,70.0f * 1.5f,70.0f * 1.5f));
	        painter.setTrailLength(4);
	        painter.setPoints(11);
	        painter.setFrame(-1);
	        jxOcupado.setPreferredSize(new Dimension(300,300));
	        jxOcupado.setIcon(new EmptyIcon(150,150));
	        jxOcupado.setBusyPainter(painter);


	        jxOcupado.setToolTipText(mensajes.getString("Ocupado"));
	        jxOcupado.setVisible(false);
	        IUSimulador.getInstance().add(jxOcupado);
	        Dimension separacion = new Dimension(100,10);


	        panelBotones.addSeparator(separacion);

	        panelBotones.add(jButtonSimular);
	        panelBotones.add(jButtonSiguiente);

	        panelBotones.add(jButtonTerminar);
	        panelBotones.add(jButtonCancelar);
	        panelBotones.addSeparator(separacion);


		}
		return panelBotones;
	}

	public JScrollPane getScrollPanelComentarios() {
		if (jScrollComentarios == null) {
			jScrollComentarios = new javax.swing.JScrollPane();
			visorComentarios = new IUVisorTexto();
			visorComentarios.setBackground(new Color(255,255,212));
		    jScrollComentarios.setViewportView(visorComentarios);

		    jScrollComentarios.setAutoscrolls(true);
		}
		return jScrollComentarios;
	}

	public JScrollPane getScrollPanelSalida() {
		if (jScrollSalida == null) {
			jScrollSalida = new javax.swing.JScrollPane();
	        visorSalida = new IUVisorTexto(false);
	        visorSalida.setBackground(Color.WHITE);
	        visorSalida.setForeground(Color.BLACK);
	        jScrollSalida.setViewportView(visorSalida);
	        jScrollSalida.setAutoscrolls(true);
		}
		return jScrollSalida;
	}


	public IUPanelVisor getPanelSimulador() {
		return getPanelSimulador("");
	}
	public IUPanelVisor getPanelSimulador(String pPosicion) {
		if (panelSimulador == null) {
			panelSimulador = new IUPanelVisor(this, pPosicion, mensajes.getString("Simulación"), new ImageIcon(getClass().getResource("/iconoIkuspro.png")), getScrollPanelSimulador());
		}
		return panelSimulador;
	}

	private IUPanelVisor getPanelComentarios(IUVentanaPrincipal pVentana, String pPosicion) {
		if (panelComentarios == null) {
			panelComentarios = new IUPanelVisor(this, pPosicion, mensajes.getString("Comentarios"), new ImageIcon(getClass().getResource(ConfiguracionGUI.RUTA_ICONOS_16 + "/iconoComentarios16.png")), getScrollPanelComentarios());
			panelComentarios.setPreferredSize(new Dimension(400,200));
		}
		return panelComentarios;
	}

	private IUPanelVisor getPanelSalida(IUVentanaPrincipal pVentana, String pPosicion) {
		if (panelSalida == null) {
			panelSalida = new IUPanelVisor(this, pPosicion, mensajes.getString("Salida_estándar"), new ImageIcon(getClass().getResource(ConfiguracionGUI.RUTA_ICONOS_16 + "/iconoConsola16.png")), getScrollPanelSalida());
		}
		return panelSalida;
	}

	public final IUbarraEstado getBarraEstado() {
		if (barraEstado == null ) {
			 barraEstado = new IUbarraEstado(this);
			 editor.addCaretListener(barraEstado);

		}
		return barraEstado;
	}

	public JToolBar getBarraBuscarReemplazar() {
		if (barraBuscarReemplazar == null) {
			barraBuscarReemplazar = new IUBarraBuscar(this);
		}
		return barraBuscarReemplazar;
	}


	public void guardar(File pFile) {

		XMLEncoder e = null;;
		try {
			e = new XMLEncoder(new BufferedOutputStream(
		            new FileOutputStream(pFile)));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Node model = multiSplitPane.getMultiSplitLayout().getModel();
		e.writeObject(model);
		e.close();
	}

	public void instalarMenu() {
		getBarraMenu().addMenuEdicionEditor(new JSeparator());
		getBarraMenu().addMenuEdicionEditor(vista.getEditor().getPopupMenu().getComponent(2));
		getBarraMenu().addMenuEdicionEditor(vista.getEditor().getPopupMenu().getComponent(1));
		getBarraMenu().addMenuEdicionEditor(vista.getEditor().getPopupMenu().getComponent(0));

		List<JButton> listaBotones = barraHerramientas.getBotonesEditor();
		Iterator<JButton> ite = listaBotones.iterator();
		int i=0;
		while(ite.hasNext()) {
			JButton elemento = ite.next();

		}

	}



	// Inicio como aplicación escritorio.
	public static void main(String args[]) {
		LOGGER.info(mensajes.getString("Iniciando"));
		IUVentanaPrincipal iu = new IUVentanaPrincipal(null,null);
	}

	public void setComentarios(String pComentarios) {
		visorComentarios.setText(pComentarios);
	}

	public void setComentarios(int pLinea, List<LogString> pListaComentarios) {
		visorComentarios.setText(pLinea, pListaComentarios);
	}

	public void setSalida(int pLinea, List<LogString> pListaSalida) {
		visorSalida.setText(pLinea, pListaSalida);
	}

	public void setSalida(String pSalida) {
		visorSalida.setText(pSalida);
	}

	public javax.swing.JButton getJButtonSimular() {
		return jButtonSimular;
	}

	public javax.swing.JButton getJButtonSiguiente() {
		return jButtonSiguiente;
	}

	public javax.swing.JButton getJButtonTerminar() {
		return jButtonTerminar;
	}

	public JXMultiSplitPane getMultiSplitPane() {
		return multiSplitPane;
	}

	public void mostrarOcupado() {
		jButtonSimular.setEnabled(false);
		jButtonSiguiente.setEnabled(false);
		jButtonTerminar.setEnabled(false);
		jButtonCancelar.setEnabled(true);
		getBarraMenu().getJMenuSimulacionIniciar().setEnabled(false);
		getBarraMenu().getJMenuSimulacionAvanzar().setEnabled(false);
		getBarraMenu().getJMenuSimulacionTerminar().setEnabled(false);
		getBarraMenu().getJMenuSimulacionCancelar().setEnabled(true);
		desactivarScrollPanelSimulador();
		jxOcupado.setBusy(true);
		jxOcupado.setVisible(true);
	}

	/**
	 *
	 */
	private void desactivarScrollPanelSimulador() {
		getScrollPanelSimulador().getViewport().setViewPosition(new Point(0,0));
		getScrollPanelSimulador().getVerticalScrollBar().setEnabled(false);
		getScrollPanelSimulador().getHorizontalScrollBar().setEnabled(false);
	}



	public void restablecerOcupado() {

		jxOcupado.setVisible(false);
		jxOcupado.setBusy(false);
		jButtonSimular.setEnabled(true);
		jButtonSiguiente.setEnabled(false);
		jButtonTerminar.setEnabled(false);
		jButtonCancelar.setEnabled(false);
		getScrollPanelSimulador().getVerticalScrollBar().setEnabled(true);
		getScrollPanelSimulador().getHorizontalScrollBar().setEnabled(true);
		getBarraMenu().getJMenuSimulacionIniciar().setEnabled(true);
		getBarraMenu().getJMenuSimulacionAvanzar().setEnabled(false);
		getBarraMenu().getJMenuSimulacionTerminar().setEnabled(false);
		getBarraMenu().getJMenuSimulacionCancelar().setEnabled(false);

	}

	/**
	 * @return the jButtonCancelar
	 */
	public JButton getJButtonCancelar() {
		return jButtonCancelar;
	}

	/**
	 * @return the visorSalida
	 */
	public IUVisorTexto getVisorSalida() {
		return visorSalida;
	}

	/**
	 * @return the visorComentarios
	 */
	public IUVisorTexto getVisorComentarios() {
		return visorComentarios;
	}


}
