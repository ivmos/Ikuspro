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
import ikuspro.main.ConfiguracionMain;
import ikuspro.main.Ikuspro;
import ikuspro.modelo.EFile;
import ikuspro.simulador.IUSimulador;
import ikuspro.vista.Vista;

import java.awt.Component;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.security.CodeSource;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JSeparator;
import javax.swing.KeyStroke;

public class IUbarraMenu extends JMenuBar implements MouseListener{



	/**
	 *
	 */
	private static final Logger LOGGER = Logger.getLogger(IUbarraMenu.class.getName());
	private static final long serialVersionUID = -1212052688877409662L;
    private static final ResourceBundle mensajes = ResourceBundle.getBundle("ikuspro/gui/Mensajes");
	private javax.swing.JMenu jMenuArchivo;
	private JMenuItem jMenuArchivoNuevo;
	private javax.swing.JMenuItem jMenuArchivoAbrir;
    private javax.swing.JMenuItem jMenuArchivoSalir;
    private javax.swing.JMenu jMenuAyuda;
    private javax.swing.JMenuItem jMenuAyudaManual;
    private javax.swing.JMenu jMenuEdicion;
    private JMenuItem jMenuEdicionSeleccionarTodo;
    private JMenuItem jMenuEdicionBuscarReemplazar;
    private JMenuItem jMenuEdicionSeleccionarIdioma;
    private javax.swing.JMenuItem jMenuAyudaAcercaDe;
	private Vista vista;
	private JMenuItem jMenuArchivoGuardar;
	private JMenuItem jMenuArchivoGuardarComo;
	private JMenuItem jMenuArchivoImprimir;
	private JMenuItem jMenuArchivoConfigurarPagina;

	private JMenu jMenuSimulacion;
	private JMenuItem jMenuSimulacionIniciar;
	private JMenuItem jMenuSimulacionAvanzar;
	private JMenuItem jMenuSimulacionTerminar;
	private JMenuItem jMenuSimulacionCancelar;
	private JMenuItem jMenuSimulacionAumentar;
	private JMenuItem jMenuSimulacionReducir;
	private JMenuItem jMenuSimulacionExportar;
	private JMenuItem jMenuSimulacionCambiarEstilo;


	private JFrame padre;
	private JMenuItem jMenuEdicionDeshacer;
	private JMenuItem jMenuEdicionRehacer;
	private JPopupMenu menu;



	public IUbarraMenu(Vista pVista) {
		vista = pVista;
		LOGGER.setLevel(Level.WARNING);
		LOGGER.info("Constructor de IUMenuBar");
		jMenuArchivoNuevo = new javax.swing.JMenuItem() {{
			setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
			setIcon(new ImageIcon(getClass().getResource(ConfiguracionGUI.RUTA_ICONOS_16 + "/iconoNuevo16.png")));
		}};
		jMenuArchivoAbrir = new javax.swing.JMenuItem() {{
			setIcon(new ImageIcon(getClass().getResource(ConfiguracionGUI.RUTA_ICONOS_16 + "/iconoAbrir16.png")));
			setActionCommand(Controlador.Comando.ABRIR.toString());
		}};
		jMenuArchivoGuardar = new javax.swing.JMenuItem() {{
			setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
			setIcon(new ImageIcon(getClass().getResource(ConfiguracionGUI.RUTA_ICONOS_16 + "/iconoGuardar16.png")));
		}};
		jMenuArchivoGuardarComo = new javax.swing.JMenuItem() {{
			setIcon(new ImageIcon(getClass().getResource(ConfiguracionGUI.RUTA_ICONOS_16 + "/iconoGuardarComo16.png")));
		}};
		jMenuArchivoImprimir = new JMenuItem() {{
			setText(mensajes.getString("Imprimir..."));
			setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
			setActionCommand(Controlador.Comando.IMPRIMIR.toString());
			setIcon(new ImageIcon(getClass().getResource(ConfiguracionGUI.RUTA_ICONOS_16 + "/iconoImprimir16.png")));
		}};
		jMenuArchivoConfigurarPagina = new JMenuItem() {{
			setText(mensajes.getString("Configurar_página..."));
			setActionCommand(Controlador.Comando.CONFIGURAR_PAGINA.toString());
		}};

        jMenuArchivoSalir = new javax.swing.JMenuItem() {{
        	setActionCommand(Controlador.Comando.SALIR.toString());
        }};
        jMenuEdicion = new javax.swing.JMenu();
        jMenuEdicionDeshacer = new javax.swing.JMenuItem() {{
        	setIcon(new ImageIcon(getClass().getResource(ConfiguracionGUI.RUTA_ICONOS_16 + "/iconoDeshacer.png")));
        }};
        jMenuEdicionRehacer = new javax.swing.JMenuItem() {{
        	setIcon(new ImageIcon(getClass().getResource(ConfiguracionGUI.RUTA_ICONOS_16 + "/iconoRehacer.png")));
        }};




        jMenuEdicionSeleccionarTodo = new javax.swing.JMenuItem() {{
        	//setIcon(new ImageIcon(getClass().getResource("/iconoSeleccionarTodo.png")));
        }};

        jMenuEdicionSeleccionarIdioma = new JMenuItem();

        jMenuEdicionBuscarReemplazar = new JMenuItem() {{
        	setIcon(new ImageIcon(getClass().getResource(ConfiguracionGUI.RUTA_ICONOS_16 + "/iconoBuscar16.png")));
        }};
        jMenuAyuda = new javax.swing.JMenu();
        jMenuAyudaManual = new javax.swing.JMenuItem();
        jMenuAyudaAcercaDe = new javax.swing.JMenuItem();
        jMenuArchivo = new javax.swing.JMenu();

		jMenuArchivo.setText(mensajes.getString("Archivo"));
		jMenuArchivoNuevo.setText(mensajes.getString("Nuevo"));
		jMenuArchivoGuardar.setText(mensajes.getString("Guardar"));
		jMenuArchivoGuardarComo.setText(mensajes.getString("Guardar_Como..."));
        jMenuArchivoAbrir.setText(mensajes.getString("Abrir..."));
        jMenuEdicionDeshacer.setText(mensajes.getString("Deshacer"));
        jMenuEdicionRehacer.setText(mensajes.getString("Rehacer"));
        jMenuEdicionSeleccionarIdioma.setText(mensajes.getString("Configurar_idioma"));
//        jMenuEdicionSeleccionarIdioma.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent pE) {
//
//				vista.getControlador().cambiarIdioma(seleccionarIdioma());
//			}
//
//        });
        jMenuEdicionSeleccionarIdioma.setActionCommand(Controlador.Comando.SELECCIONAR_IDIOMA.toString());

        jMenuEdicionDeshacer.setActionCommand(Controlador.Comando.DESHACER.toString());
        jMenuEdicionRehacer.setActionCommand(Controlador.Comando.REHACER.toString());
        jMenuArchivoGuardar.setActionCommand(Controlador.Comando.GUARDAR.toString());

        jMenuArchivoGuardarComo.setActionCommand(Controlador.Comando.GUARDARCOMO.toString());
        jMenuArchivoNuevo.setActionCommand(Controlador.Comando.NUEVO.toString());

        jMenuEdicionSeleccionarTodo.setActionCommand(Controlador.Comando.SELECCIONARTODO.toString());

        jMenuEdicionBuscarReemplazar.setActionCommand(Controlador.Comando.BUSCARREEMPLAZAR.toString());

        jMenuArchivo.add(jMenuArchivoNuevo);
        jMenuArchivo.add(jMenuArchivoAbrir);
        jMenuArchivo.add(jMenuArchivoGuardar);
        jMenuArchivo.add(jMenuArchivoGuardarComo);
        jMenuArchivo.add(new JSeparator());
        jMenuArchivo.add(jMenuArchivoImprimir);
        jMenuArchivo.add(jMenuArchivoConfigurarPagina);
        jMenuArchivo.add(new JSeparator());

        jMenuArchivoSalir.setText(mensajes.getString("Salir"));
        jMenuArchivo.add(jMenuArchivoSalir);

        add(jMenuArchivo);

        jMenuEdicion.setText(mensajes.getString("Edición"));

        jMenuEdicionDeshacer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, ActionEvent.CTRL_MASK));
        jMenuEdicion.add(jMenuEdicionDeshacer);
        jMenuEdicionRehacer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y, ActionEvent.CTRL_MASK));
        jMenuEdicion.add(jMenuEdicionRehacer);
        jMenuEdicionSeleccionarTodo.setText(mensajes.getString("Seleccionar_todo"));
        jMenuEdicionSeleccionarTodo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
        jMenuEdicionBuscarReemplazar.setText(mensajes.getString("Buscar"));
        jMenuEdicionBuscarReemplazar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, ActionEvent.CTRL_MASK));
        jMenuEdicion.add(jMenuEdicionSeleccionarTodo);
        jMenuEdicion.add(jMenuEdicionBuscarReemplazar);
        jMenuEdicion.addSeparator();
        if (ConfiguracionGUI.PERMITIDO_CONFIGURAR_IDIOMA) {
        	jMenuEdicion.add(jMenuEdicionSeleccionarIdioma);
        }
        add(jMenuEdicion);

        jMenuSimulacion = new JMenu();




        jMenuSimulacion.setText(mensajes.getString("Simulación"));
        jMenuSimulacionIniciar = new JMenuItem(mensajes.getString("Iniciar"), new ImageIcon(getClass().getResource(ConfiguracionGUI.RUTA_ICONOS_16 + "/iconoSimular16.png"))) {{
        	setActionCommand(Controlador.Comando.SIMULACION_INICIAR.toString());
        	setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F11, ActionEvent.CTRL_MASK));
        }};
        jMenuSimulacionAvanzar = new JMenuItem(mensajes.getString("Avanzar"), new ImageIcon(getClass().getResource(ConfiguracionGUI.RUTA_ICONOS_16 + "/iconoSiguiente16.png"))) {{
        	setActionCommand(Controlador.Comando.SIMULACION_AVANZAR.toString());
        	setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F11, 0));
        }};

        jMenuSimulacionTerminar = new JMenuItem(mensajes.getString("Terminar"), new ImageIcon(getClass().getResource(ConfiguracionGUI.RUTA_ICONOS_16 + "/iconoTerminar16.png"))) {{
        	setActionCommand(Controlador.Comando.SIMULACION_TERMINAR.toString());

        }};
        jMenuSimulacionCancelar = new JMenuItem(mensajes.getString("Cancelar"), new ImageIcon(getClass().getResource(ConfiguracionGUI.RUTA_ICONOS_16 + "/iconoCancelar16.png"))) {{
        	setActionCommand(Controlador.Comando.SIMULACION_CANCELAR.toString());
        }};

        addBotonesControlSimulador();
        jMenuSimulacion.addSeparator();
        addBotonesExternosSimulador();

        add(jMenuSimulacion);
        jMenuAyuda.setText(mensajes.getString("Ayuda"));

        jMenuAyudaManual.setText(mensajes.getString("Manual"));
        jMenuAyudaManual.setActionCommand(Controlador.Comando.MOSTRAR_MANUAL_AYUDA.toString());
        jMenuAyuda.add(jMenuAyudaManual);

        jMenuAyudaAcercaDe.setText(mensajes.getString("Acerca_de..."));
        jMenuAyudaAcercaDe.setActionCommand(Controlador.Comando.ACERCADE.toString());

        jMenuAyuda.add(jMenuAyudaAcercaDe);

        add(jMenuAyuda);
        addMouseListener(this);
        setVisible(true);

	}


	private final void addBotonesControlSimulador() {
		jMenuSimulacion.add(getJMenuSimulacionIniciar());
		jMenuSimulacion.add(getJMenuSimulacionAvanzar());
		jMenuSimulacion.add(getJMenuSimulacionTerminar());
		jMenuSimulacion.add(getJMenuSimulacionCancelar());

	}


	/**
	 *
	 */
	private final void addBotonesExternosSimulador() {
		jMenuSimulacion.add(getJMenuSimulacionAumentar());
		jMenuSimulacion.add(getJMenuSimulacionReducir());
		jMenuSimulacion.add(getJMenuSimulacionExportar());
		jMenuSimulacion.addSeparator();
		jMenuSimulacion.add(getJMenuSimulacionCambiarEstilo());
	}





	public void addMenuEdicionEditor(Component pComponent) {
		jMenuEdicion.add(pComponent,0);
	}

	public void addActionListener(ActionListener pListener) {
		jMenuArchivoNuevo.addActionListener(pListener);
		jMenuArchivoConfigurarPagina.addActionListener(pListener);
		jMenuArchivoAbrir.addActionListener(pListener);
		jMenuArchivoGuardar.addActionListener(pListener);
		jMenuArchivoGuardarComo.addActionListener(pListener);
		jMenuArchivoImprimir.addActionListener(pListener);
		jMenuArchivoSalir.addActionListener(pListener);
		jMenuEdicionDeshacer.addActionListener(pListener);
		jMenuEdicionRehacer.addActionListener(pListener);
		jMenuEdicionBuscarReemplazar.addActionListener(pListener);
		jMenuEdicionSeleccionarTodo.addActionListener(pListener);
		jMenuAyudaAcercaDe.addActionListener(pListener);
		jMenuSimulacionIniciar.addActionListener(pListener);
		jMenuSimulacionAvanzar.addActionListener(pListener);
		jMenuSimulacionTerminar.addActionListener(pListener);
		jMenuSimulacionCancelar.addActionListener(pListener);
		jMenuEdicionSeleccionarIdioma.addActionListener(pListener);
		jMenuAyudaManual.addActionListener(pListener);
	}




	public JPopupMenu getPopupMenu() {

		if (menu == null) {
			menu = new JPopupMenu();
			JMenuItem menuItem;

			menuItem = new JMenuItem();
			menuItem.setText(mensajes.getString("Mostrar_barra_herramientas"));

			menuItem.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent pE) {
					vista.getVentana().getBarraHerramientas().setVisible(true);
				}

			});


			menu.add(menuItem);

		}

		return menu;

	}

	@Override
	public void mouseClicked(MouseEvent pArg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent pArg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent pArg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent pArg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent pEvento) {
		if (pEvento.getButton() == MouseEvent.BUTTON3) {
			if (!vista.getVentana().getBarraHerramientas().isVisible()) {
				getPopupMenu().setLocation(pEvento.getLocationOnScreen());
				getPopupMenu().show(this, pEvento.getX(), pEvento.getY());
			}
		}
	}


	/**
	 * @return the jMenuSimulacionIniciar
	 */
	public JMenuItem getJMenuSimulacionIniciar() {
		return jMenuSimulacionIniciar;
	}


	/**
	 * @return the jMenuSimulacionAvanzar
	 */
	public JMenuItem getJMenuSimulacionAvanzar() {
		return jMenuSimulacionAvanzar;
	}


	/**
	 * @return the jMenuSimulacionTerminar
	 */
	public JMenuItem getJMenuSimulacionTerminar() {
		return jMenuSimulacionTerminar;
	}


	/**
	 * @return the jMenuSimulacionCancelar
	 */
	public JMenuItem getJMenuSimulacionCancelar() {
		return jMenuSimulacionCancelar;
	}


	/**
	 * @return the jMenuSimulacionAumentar
	 */
	public JMenuItem getJMenuSimulacionAumentar() {
		if (jMenuSimulacionAumentar == null) {
			jMenuSimulacionAumentar = new JMenuItem(mensajes.getString("Aumentar"), new ImageIcon(getClass().getResource(ConfiguracionGUI.RUTA_ICONOS_16 + "/iconoAumentar16.png")));
			jMenuSimulacionAumentar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_PLUS, ActionEvent.CTRL_MASK));
			jMenuSimulacionAumentar.setActionCommand(IUSimulador.comandos.AMPLIAR.toString());
			jMenuSimulacionAumentar.addActionListener(IUSimulador.getInstance());
			jMenuSimulacionAumentar.setEnabled(false);
			IUSimulador.getInstance().setBotonMenuAumentar(jMenuSimulacionAumentar);

		}
		return jMenuSimulacionAumentar;
	}

	private JMenuItem getJMenuSimulacionCambiarEstilo() {
		if (jMenuSimulacionCambiarEstilo == null) {
			jMenuSimulacionCambiarEstilo = new JMenuItem(mensajes.getString("Cambiar_Estilo"));
			jMenuSimulacionCambiarEstilo.setActionCommand(IUSimulador.comandos.CAMBIAR_ESTILO.toString());
			jMenuSimulacionCambiarEstilo.addActionListener(IUSimulador.getInstance());
			jMenuSimulacionCambiarEstilo.setEnabled(true);
		}
		return jMenuSimulacionCambiarEstilo;
	}

	/**
	 * @return the jMenuSimulacionReducir
	 */
	public JMenuItem getJMenuSimulacionReducir() {
		if (jMenuSimulacionReducir == null) {
			jMenuSimulacionReducir = new JMenuItem(mensajes.getString("Reducir"), new ImageIcon(getClass().getResource(ConfiguracionGUI.RUTA_ICONOS_16 + "/iconoReducir16.png")));
			jMenuSimulacionReducir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_MINUS, ActionEvent.CTRL_MASK));
			jMenuSimulacionReducir.setActionCommand(IUSimulador.comandos.REDUCIR.toString());
			jMenuSimulacionReducir.addActionListener(IUSimulador.getInstance());
			jMenuSimulacionReducir.setEnabled(false);
			IUSimulador.getInstance().setBotonMenuReducir(jMenuSimulacionReducir);
		}
		return jMenuSimulacionReducir;
	}


	/**
	 * @return the jMenuSimulacionExportar
	 */
	public JMenuItem getJMenuSimulacionExportar() {
		if (jMenuSimulacionExportar == null) {
			jMenuSimulacionExportar = new JMenuItem(mensajes.getString("Exportar"), new ImageIcon(getClass().getResource(ConfiguracionGUI.RUTA_ICONOS_16 + "/iconoExportar16.png")));
			jMenuSimulacionExportar.setActionCommand(IUSimulador.comandos.EXPORTAR.toString());
			jMenuSimulacionExportar.addActionListener(IUSimulador.getInstance());
			jMenuSimulacionExportar.setEnabled(false);
			IUSimulador.getInstance().setBotonMenuExportar(jMenuSimulacionExportar);
		}
		return jMenuSimulacionExportar;
	}


	/**
	 * @return the jMenuEdicionDeshacer
	 */
	public JMenuItem getJMenuEdicionDeshacer() {
		return jMenuEdicionDeshacer;
	}


	/**
	 * @param pMenuEdicionDeshacer the jMenuEdicionDeshacer to set
	 */
	public void setJMenuEdicionDeshacer(JMenuItem pMenuEdicionDeshacer) {
		jMenuEdicionDeshacer = pMenuEdicionDeshacer;
	}


	/**
	 * @return the jMenuEdicionRehacer
	 */
	public JMenuItem getJMenuEdicionRehacer() {
		return jMenuEdicionRehacer;
	}


	/**
	 * @param pMenuEdicionRehacer the jMenuEdicionRehacer to set
	 */
	public void setJMenuEdicionRehacer(JMenuItem pMenuEdicionRehacer) {
		jMenuEdicionRehacer = pMenuEdicionRehacer;
	}










}
