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

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ResourceBundle;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class IUPanelVisor extends JTabbedPane implements MouseListener{


	private static final Dimension MINIMA_DIMENSION = new Dimension(150,150);
	/**
	 *
	 */
	private static final long serialVersionUID = -719492109818842495L;
	private String nombre;
	private ImageIcon iconoDetach;
    private static final ResourceBundle mensajes = ResourceBundle.getBundle("ikuspro/gui/Mensajes");
	private ImageIcon iconoAttach;
	private IUVentanaPrincipal ventanaPrincipal;
	private boolean despegado;
	private String posicion;
	private IUVentanaPanelVisor iuv;
	private IUPanelFalso panelSustitutivo;

	public class IUPanelFalso extends JPanel {

		/**
		 *
		 */
		private static final long serialVersionUID = 8672413326613017163L;

		public IUPanelFalso() {
			super();
			this.setMinimumSize(MINIMA_DIMENSION);
		}


	}

	public class IUVentanaPanelVisor extends JDialog{

		public IUVentanaPanelVisor(IUPanelVisor pPanel) throws HeadlessException {
			super(ventanaPrincipal, nombre);
			int x = pPanel.getX();
			int y = pPanel.getY();
			int ancho = pPanel.getWidth();
			int alto = pPanel.getHeight();
			add(pPanel);
			setSize(ancho,alto);
			this.setLocation(x, y);
			addWindowListener(new java.awt.event.WindowAdapter() {
                public void windowClosing(java.awt.event.WindowEvent e) {
                    despegado = false;
                    restablecer();
                }
            });
			setVisible(true);
		}

	}

	public IUPanelVisor(IUVentanaPrincipal pVentana, String pPosicion, String pNombre, ImageIcon pIcono, JComponent pComponente) {
		super();
		nombre = pNombre;
		ventanaPrincipal = pVentana;
		despegado = false;
		posicion = pPosicion;
		if (pIcono == null) {
			addTab(nombre,pComponente);
		} else {
			addTab(nombre, pIcono, pComponente);
		}
		this.setFocusable(false);
		this.addMouseListener(this);
		iconoDetach = new ImageIcon(getClass().getResource(ConfiguracionGUI.RUTA_ICONOS_12 + "/iconoDetach.png"));
		iconoAttach = new ImageIcon(getClass().getResource(ConfiguracionGUI.RUTA_ICONOS_12 + "/iconoAttach.png"));
		this.setMinimumSize(MINIMA_DIMENSION);
		panelSustitutivo = new IUPanelFalso();

	}

	public IUPanelVisor(IUVentanaPrincipal pVentana, String pPosicion, String pNombre, JComponent pComponente) {
		this(pVentana, pPosicion, pNombre, null, pComponente);

	}


	private ImageIcon getIcono() {
		ImageIcon icono = null;
		if (despegado)
			icono = iconoAttach;
		else
			icono = iconoDetach;
		return icono;
	}


	/* (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override
	protected void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);



		Graphics2D pen = (Graphics2D) graphics;
		Image im = getIcono().getImage();
		pen.drawImage(im, this.getWidth() - getIcono().getIconWidth() - 2, getIcono().getIconHeight(), null);

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

		int posXa = this.getWidth() - iconoDetach.getIconWidth() - 2;
		int posXb = this.getWidth() + iconoDetach.getIconWidth();
		int posYa = (this.getY() + iconoDetach.getIconHeight());
		int posYb = (this.getY() + 2 * iconoDetach.getIconHeight());
		boolean hitX = (pEvento.getX() >= posXa)
								&&
						(pEvento.getX() <= posXb);
		boolean hitY = (this.getY() + pEvento.getY() >= posYa)
								&&
						(this.getY() + pEvento.getY() <= posYb);

		if (hitX && hitY) {
			if (!despegado)  {
				despegado = true;
				iuv = new IUVentanaPanelVisor(this);

				sustituirPorFalso();
			} else {
				despegado = false;
				restablecer();
			}
		}
	}


	private void restablecer() {
		iuv.add(panelSustitutivo);
		ventanaPrincipal.getMultiSplitPane().add(this,posicion);
		iuv.dispose();
		ventanaPrincipal.getMultiSplitPane().updateUI();
	}

	private void sustituirPorFalso() {
		ventanaPrincipal.getMultiSplitPane().add(panelSustitutivo, posicion);
		ventanaPrincipal.getMultiSplitPane().updateUI();
	}






}
