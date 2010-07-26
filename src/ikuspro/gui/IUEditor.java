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

import ikuspro.gui.util.Impresora;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.print.PageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.text.BadLocationException;

import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;

public class IUEditor extends RSyntaxTextArea {

	/**
	 *
	 */
	private static final long serialVersionUID = -7015615025453542187L;

	private JPopupMenu menu;
	private IUEditorExpuesto exposicion;

	private JButton botonCopiar;
	private JButton botonCortar;
	private int posicionCursor;
	private boolean interpretando;


	private int subindice;
	private int anterior;
	private boolean nuevaPagina;
	private List<String> listaPaginas;


	private static final Logger LOGGER = Logger.getLogger(IUEditor.class
			.getName());

	public class IUEditorExpuesto implements MouseMotionListener, MouseListener   {
		public IUEditorExpuesto() {
			IUEditor.this.addMouseMotionListener(this);
			IUEditor.this.addMouseListener(this);

		}

		@Override
		public void mouseDragged(MouseEvent pArg0) {
			if (IUEditor.this.getSelectedText() != null) {
				IUEditor.this.setPuedeCopiar(true);

			} else {
				IUEditor.this.setPuedeCopiar(false);

			}

		}

		@Override
		public void mouseMoved(MouseEvent pArg0) {
			// TODO Auto-generated method stub


		}

		@Override
		public void mouseClicked(MouseEvent pArg0) {
			if (IUEditor.this.isInterpretando()) {
				IUEditor.this.setPosicionCursor(0, posicionCursor + 1);
			}

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
			if (IUEditor.this.getSelectedText() != null ) {
				IUEditor.this.setPuedeCopiar(true);
			} else {
				IUEditor.this.setPuedeCopiar(false);
			}

		}

		@Override
		public void mouseReleased(MouseEvent pArg0) {
			// TODO Auto-generated method stub

		}





	}
    private static final ResourceBundle mensajes = ResourceBundle.getBundle("ikuspro/gui/Mensajes");

	public IUEditor() {

		LOGGER.setLevel(Level.WARNING);
		LOGGER.info("contruido");

		exposicion = new IUEditorExpuesto();
		botonCopiar = new JButton();
		interpretando = false;
		posicionCursor = 0;
		nuevaPagina = true;
		subindice = 0;
		anterior = -1;

	}

	private void setPuedeCopiar(boolean pPuede) {
		botonCopiar.setEnabled(pPuede);
		// Si puede copiar tambien puede cortar..
		botonCortar.setEnabled(pPuede);


	}

	public JPopupMenu getPopupMenu() {

			menu = new JPopupMenu();


		JMenuItem menuItem;


		menuItem = new JMenuItem(IUEditor.getAction(CUT_ACTION));
		menuItem.setIcon(new ImageIcon(getClass().getResource(ConfiguracionGUI.RUTA_ICONOS_16 + "/iconoCortar16.png")));
		menu.add(menuItem);

		menuItem = new JMenuItem(IUEditor.getAction(COPY_ACTION));
		menuItem.setIcon(new ImageIcon(getClass().getResource(ConfiguracionGUI.RUTA_ICONOS_16 + "/iconoCopiar16.png")));
		menu.add(menuItem);

		menuItem = new JMenuItem(IUEditor.getAction(PASTE_ACTION));
		menuItem.setIcon(new ImageIcon(getClass().getResource(ConfiguracionGUI.RUTA_ICONOS_16 + "/iconoPegar16.png")));
		menu.add(menuItem);
		return menu;

	}



	public void setInterpretando(boolean pB) {
		interpretando = pB;
		//setEditable(!pB); // Parece que no funciona bien, mejor usar setEditable
		this.setEnabled(!pB);

		if (pB) {
			setCurrentLineHighlightColor(Color.ORANGE.brighter());
		} else {
			setCurrentLineHighlightColor(IUEditor.getDefaultCurrentLineHighlightColor());
		}

	}

	public void setPosicionCursor(int pX, int pY) {
		posicionCursor = pY;
		if (posicionCursor > 0) {
			posicionCursor = posicionCursor - 1;
		}

		try {

			this.setCaretPosition(this.getLineStartOffset(posicionCursor));
		} catch (BadLocationException e) {
			// TODO Auto-generated catch block
			LOGGER.warning("Error posicionamiento cursor");
		}

	}

	/**
	 * @param pBotonCopiar the botonCopiar to set
	 */
	public void setBotonCopiar(JButton pBotonCopiar) {
		botonCopiar = pBotonCopiar;
	}

	public void setBotonCortar(JButton pBotonCortar) {

		botonCortar = pBotonCortar;
	}

	/**
	 * @return the interpretando
	 */
	private boolean isInterpretando() {
		return interpretando;
	}

	public int print(Graphics g, PageFormat pageFormat, int pageIndex) {
		listaPaginas = paginarContenidoEditor(this.getText());
		if (anterior != pageIndex) {
			nuevaPagina = true;
		} else {
			nuevaPagina = false;
		}

		Graphics2D g2 = (Graphics2D)g;
		g2.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
		boolean wasBuffered = Impresora.getInstance().disableDoubleBuffering(this);
		imprimirPaginaSiguiente(g2);
		anterior = pageIndex;
		Impresora.getInstance().restoreDoubleBuffering(this, wasBuffered);
		return PAGE_EXISTS;
	}

	private String paginarEditor(IUEditor pEditor, int pPaginaActual) {

		int i;

		listaPaginas = new ArrayList<String>();
		String contenidoEntero = null;

		// Pag 1
		contenidoEntero = pEditor.getText();
		listaPaginas = paginarContenidoEditor(contenidoEntero);

		pEditor.setHighlightCurrentLine(false);

		if (subindice <= listaPaginas.size() - 1) {
			pEditor.setText(listaPaginas.get(subindice));
		}

		pEditor.setHighlightCurrentLine(true);

			if (subindice == listaPaginas.size()) {
				subindice = 0;
			}
			return contenidoEntero;
	}


	/**
	 * @param contenidoEntero
	 * @return
	 */
	public List<String> paginarContenidoEditor(String contenidoEntero) {
		int i;
		List<String> listaPaginas;
		String[] cadContenido = contenidoEntero.split("\n",-1);
		i = 0;
		listaPaginas = new ArrayList<String>();
		String pagina = "";
		for (i=0;i <= cadContenido.length - 1; i++) {

			if ((i != 0) && (i % 35 == 0)) {

				listaPaginas.add(pagina);
				pagina = "";

			} else {
				pagina += cadContenido[i] + System.getProperty("line.separator");

			}

		}
		if (pagina != null) {
			listaPaginas.add(pagina);
		}
		return listaPaginas;
	}


	private void imprimirPaginaSiguiente(Graphics g2) {

			if (!nuevaPagina) {
				subindice --;
			}

			String contenidoTotal = paginarEditor(this, subindice);

			this.paint(g2);
			this.setText(contenidoTotal);
			this.setPosicionCursor(0, posicionCursor + 1);
			subindice ++;




	}


}
