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
import ikuspro.simulador.IUSimulador;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JToolBar;

public final class IUBarraHerramientas extends JToolBar implements MouseListener {
	/**
	 *
	 */
	private static final long serialVersionUID = -1614102560398428800L;
	private JButton barraHerramientasBotonNuevo;
	private JButton barraHerramientasBotonAbrir;
	private JButton barraHerramientasBotonGuardar;
	private JButton barraHerramientasImprimir;
	private JButton barraHerramientasBuscar;
	private JButton barraHerramientasCortar;
	private JButton barraHerramientasCopiar;
	private JButton barraHerramientasPegar;
	private JButton barraHerramientasDeshacer;
	private JButton barraHerramientasZoomIn;
	private JButton barraHerramientasZoomOut;
	private JButton barraHerramientasExportar;

	private static IUBarraHerramientas instance;
    private static final ResourceBundle mensajes = ResourceBundle.getBundle("ikuspro/gui/Mensajes");
	private JPopupMenu menu;

	private IUBarraHerramientas() {
		super();

		this.setFloatable(false);

		barraHerramientasBotonNuevo = new JButton(new ImageIcon(getClass().getResource(ConfiguracionGUI.RUTA_ICONOS_22 + "/iconoNuevo22.png"))) {{
			setFocusable(false);
			setActionCommand(Controlador.Comando.NUEVO.toString());
			setToolTipText(mensajes.getString("Nuevo"));
		}};
		barraHerramientasBotonAbrir = new JButton(new ImageIcon(getClass().getResource(ConfiguracionGUI.RUTA_ICONOS_22 + "/iconoAbrir22.png"))) {{
			setFocusable(false);
			setActionCommand(Controlador.Comando.ABRIR.toString());
			setToolTipText(mensajes.getString("Abrir"));


		}};

		barraHerramientasBotonGuardar = new JButton(new ImageIcon(getClass().getResource(ConfiguracionGUI.RUTA_ICONOS_22 + "/iconoGuardar22.png"))) {{
			setFocusable(false);
			setActionCommand(Controlador.Comando.GUARDAR.toString());
			setToolTipText(mensajes.getString("Guardar"));
		}};

		Dimension separacion = new Dimension(10,0);
		this.addSeparator(separacion);
		this.add(barraHerramientasBotonNuevo);
		this.add(barraHerramientasBotonAbrir);
		this.add(barraHerramientasBotonGuardar);
		this.addSeparator(separacion);

		barraHerramientasImprimir = new JButton(new ImageIcon(getClass().getResource(ConfiguracionGUI.RUTA_ICONOS_22 + "/iconoImprimir22.png"))) {{
			setFocusable(false);
			setActionCommand(Controlador.Comando.IMPRIMIR.toString());
			setToolTipText(mensajes.getString("Imprimir"));
		}};

		this.add(barraHerramientasImprimir);

//		barraHerramientasImprimirPreliminar = new JButton(new ImageIcon(getClass().getResource("/iconoImprimirPreliminar.png"))) {{
//			setFocusable(false);
//			setActionCommand(Controlador.comandos.IMPRIMIR_PRELIMINAR.toString());
//			setToolTipText("Abrir");
//		}};

//		this.add(barraHerramientasImprimirPreliminar);

		this.addSeparator(separacion);
		barraHerramientasBuscar = new JButton(new ImageIcon(getClass().getResource(ConfiguracionGUI.RUTA_ICONOS_22 + "/iconoBuscar22.png"))) {{
			setFocusable(false);
			setActionCommand(Controlador.Comando.BUSCARREEMPLAZAR.toString());
			setToolTipText(mensajes.getString("Buscar"));
		}};

		this.add(barraHerramientasBuscar);

		this.addSeparator(separacion);
		barraHerramientasCortar = new JButton(new ImageIcon(getClass().getResource(ConfiguracionGUI.RUTA_ICONOS_22 + "/iconoCortar22.png"))) {{
			setFocusable(false);
			setActionCommand(Controlador.Comando.CORTAR.toString());
			setToolTipText(mensajes.getString("Cortar"));
		}};

		this.add(barraHerramientasCortar);
		barraHerramientasCopiar = new JButton(new ImageIcon(getClass().getResource(ConfiguracionGUI.RUTA_ICONOS_22 + "/iconoCopiar22.png"))) {{
			setFocusable(false);
			setEnabled(false);
			setToolTipText(mensajes.getString("Copiar"));

			//IUEditor.getAction(IUEditor.COPY_ACTION)
		}};

		this.add(barraHerramientasCopiar);

		barraHerramientasPegar = new JButton(new ImageIcon(getClass().getResource(ConfiguracionGUI.RUTA_ICONOS_22 + "/iconoPegar22.png"))) {{
			setFocusable(false);
			setActionCommand(Controlador.Comando.PEGAR.toString());
			setToolTipText(mensajes.getString("Pegar"));
		}};

		this.add(barraHerramientasPegar);
		barraHerramientasDeshacer = new JButton(new ImageIcon(getClass().getResource(ConfiguracionGUI.RUTA_ICONOS_22 + "/iconoDeshacer22.png"))) {{
			setFocusable(false);
			setActionCommand(Controlador.Comando.DESHACER.toString());
			setToolTipText(mensajes.getString("Deshacer"));
		}};

		this.add(barraHerramientasDeshacer);

		barraHerramientasZoomIn = new JButton(new ImageIcon(getClass().getResource(ConfiguracionGUI.RUTA_ICONOS_22 + "/iconoZoomIn22.png"))) {{
			setFocusable(false);
			setEnabled(false);
			addActionListener(IUSimulador.getInstance());
			setActionCommand(IUSimulador.comandos.AMPLIAR.toString());
			setToolTipText(mensajes.getString("Aumentar"));
		}};

		this.addSeparator(separacion);
		IUSimulador.getInstance().setBotonAumentar(barraHerramientasZoomIn);
		this.add(barraHerramientasZoomIn);


		barraHerramientasZoomOut = new JButton(new ImageIcon(getClass().getResource(ConfiguracionGUI.RUTA_ICONOS_22 + "/iconoZoomOut22.png"))) {{
			setFocusable(false);
			setEnabled(false);
			addActionListener(IUSimulador.getInstance());
			setActionCommand(IUSimulador.comandos.REDUCIR.toString());
			setToolTipText(mensajes.getString("Reducir"));

		}};
		IUSimulador.getInstance().setBotonReducir(barraHerramientasZoomOut);
		this.add(barraHerramientasZoomOut);

		barraHerramientasExportar = new JButton(new ImageIcon(getClass().getResource(ConfiguracionGUI.RUTA_ICONOS_22 + "/iconoExportar22.png"))) {{
			setFocusable(false);
			setEnabled(false);
			addActionListener(IUSimulador.getInstance());
			setActionCommand(IUSimulador.comandos.EXPORTAR.toString());
			setToolTipText(mensajes.getString("Exportar"));
		}};
		IUSimulador.getInstance().setBotonExportar(barraHerramientasExportar);
		addMouseListener(this);
		this.add(barraHerramientasExportar);
	}


	public void addActionListener(ActionListener pListener) {
		barraHerramientasBotonNuevo.addActionListener(pListener);
		barraHerramientasBotonAbrir.addActionListener(pListener);
		barraHerramientasImprimir.addActionListener(pListener);
		barraHerramientasBotonGuardar.addActionListener(pListener);
		barraHerramientasDeshacer.addActionListener(pListener);
		barraHerramientasBuscar.addActionListener(pListener);
		barraHerramientasCortar.addActionListener(pListener);
		barraHerramientasDeshacer.addActionListener(pListener);
	}

	public List<JButton> getBotonesEditor() {
		List<JButton> lista = new ArrayList<JButton>();
		lista.add(barraHerramientasCortar);
		lista.add(barraHerramientasCopiar);
		lista.add(barraHerramientasPegar);
		lista.add(barraHerramientasDeshacer);
		return lista;
	}

	/**
	 * @return the barraHerramientasCopiar
	 */
	public JButton getBarraHerramientasCopiar() {
		return barraHerramientasCopiar;
	}

	/**
	 * @return the instance
	 */
	public static synchronized IUBarraHerramientas getInstance() {
		if (instance == null) {
			instance = new IUBarraHerramientas();
		}
		return instance;
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
			getPopupMenu().setLocation(pEvento.getLocationOnScreen());
			getPopupMenu().show(this, pEvento.getX(), pEvento.getY());
		}
	}

	public JPopupMenu getPopupMenu() {

		if (menu == null) {
			menu = new JPopupMenu();
			JMenuItem menuItem;

			menuItem = new JMenuItem();
			menuItem.setText(mensajes.getString("Ocultar"));

			menuItem.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent pE) {
					IUBarraHerramientas.this.setVisible(false);
				}

			});


			menu.add(menuItem);

		}

		return menu;

	}


/**
 * @return the barraHerramientasCortar
 */
public JButton getBarraHerramientasCortar() {
	return barraHerramientasCortar;
}


/**
 * @return the barraHerramientasDeshacer
 */
public JButton getBarraHerramientasDeshacer() {
	return barraHerramientasDeshacer;
}


/**
 * @return the barraHerramientasPegar
 */
public JButton getBarraHerramientasPegar() {
	return barraHerramientasPegar;
}

}
