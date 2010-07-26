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
import ikuspro.modelo.InterpreteModelo.LogString;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JSeparator;
import javax.swing.JTextPane;
import javax.swing.KeyStroke;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Document;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class IUVisorTexto extends JTextPane implements MouseListener, Printable {

	/**
	 *
	 */
	private static final long serialVersionUID = -7015615025453542187L;
	private List<JMenuItem> listaJMenuItem;
	private JPopupMenu menu;


	private JMenuItem menuItemCopiar;
	private JMenuItem menuItemSeleccionarTodo;
	private JMenuItem menuItemMostrarLinea;
	protected boolean mostrarLinea;
	protected boolean puedeMostrarLinea;
	private StyledDocument documentSimple;

	protected List<LogString> listaTextoActual;
	protected int lineaActual;

	private int subindice;
	private List<String> listaPaginas;
	private Document documentTmp;
	private int primeraPaginaImprimir;
	private int paginaImprimirActual;

	private static final Logger LOGGER = Logger.getLogger(IUVisorTexto.class
			.getName());
    private static final ResourceBundle mensajes = ResourceBundle.getBundle("ikuspro/gui/Mensajes");

	public IUVisorTexto() {
		LOGGER.setLevel(Level.WARNING);
		LOGGER.info("contruido");
		listaJMenuItem = new ArrayList<JMenuItem>();
		mostrarLinea = true;
		puedeMostrarLinea = true;

		documentSimple = new DefaultStyledDocument();
		subindice = 0;
		this.addMouseListener(this);
		this.setEditable(false);
	}

	public IUVisorTexto(boolean pPuedeMostrarLinea) {
		this();
		puedeMostrarLinea = pPuedeMostrarLinea;
		mostrarLinea = false;

	}

	public JPopupMenu getPopupMenu() {

		if (menu == null) {
			menu = new JPopupMenu();
			JMenuItem menuItem;

			menuItem = new JMenuItem();
			menuItem.setText(mensajes.getString("Copiar"));
			menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));

			menuItem.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent pE) {
					copy();
				}

			});
			menuItemCopiar = menuItem;
			menuItem.setIcon(new ImageIcon(getClass().getResource(ConfiguracionGUI.RUTA_ICONOS_16 + "/iconoCopiar16.png")));
			menu.add(menuItemCopiar);
			menuItem = new JMenuItem();
			menuItem.setText(mensajes.getString("Seleccionar_todo"));
			//menuItem.setIcon(new ImageIcon(getClass().getResource("/iconoSeleccionarTodo.png")));
			menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
			menuItem.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent pE) {
					selectAll();

				}

			});
			menuItemSeleccionarTodo = menuItem;
			menu.add(menuItemSeleccionarTodo);

			menu.add(new JSeparator());

			if (puedeMostrarLinea) {
				menuItem = new JMenuItem();
				menuItem.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent pE) {
						actualizarMenuItemMostrarLinea();
						actualizarDocumento();

					}

				});
				menuItemMostrarLinea = menuItem;
				menuItemMostrarLinea.setText(mensajes.getString("Ocultar_número_de_línea"));
				actualizarDocumento();
				menu.add(menuItemMostrarLinea);
			}
		}

		return menu;

	}

	private void actualizarMenuItemMostrarLinea() {
		if (mostrarLinea) {
			mostrarLinea = false;
			menuItemMostrarLinea.setText(mensajes.getString("Mostrar_número_de_línea"));
		} else {
			mostrarLinea = true;
			menuItemMostrarLinea.setText(mensajes.getString("Ocultar_número_de_línea"));
		}
	}


	public List<JMenuItem> getMenuItems() {
		return listaJMenuItem;
	}

	protected void avanzarAlFinal() {
		this.setCaretPosition(this.getDocument().getLength());
	}


	public void setText(int pLinea, List<LogString> pListaTexto) {
		if (pListaTexto != null) {
			listaTextoActual = new ArrayList<LogString>();
			Iterator<LogString> iterador = pListaTexto.iterator();
			while(iterador.hasNext()) {
				listaTextoActual.add(iterador.next());
			}
		}

		lineaActual = pLinea;
		if (pListaTexto != null && !pListaTexto.isEmpty()) {

			 documentSimple = new DefaultStyledDocument();

			 try {
				 Iterator<LogString> ite = pListaTexto.iterator();
				 LogString ls = null;
				 int i = 1;
				 while(ite.hasNext()) {

					 SimpleAttributeSet attributes = new SimpleAttributeSet();
					 attributes.addAttribute(StyleConstants.CharacterConstants.FontSize, 12);
					 ls = ite.next();

					 boolean esDeLosUltimos = true;
					 for(int j=i; j<= pListaTexto.size() - 1;j++) {
						 if (pListaTexto.get(j).getLinea() != ls.getLinea()) {
							 esDeLosUltimos = false;
							 break;
						 }
					 }

					 if ( esDeLosUltimos && (ls.getLinea() == pListaTexto.get(pListaTexto.size() - 1).getLinea()) && puedeMostrarLinea) {
						 attributes.addAttribute(StyleConstants.CharacterConstants.Bold, Boolean.TRUE);
					 }
					 String pre = "";
					 if (mostrarLinea) {
						 pre = "[" + mensajes.getString("línea_") + " " + ls.getLinea() + "]" + "  ";
					 }

					 documentSimple.insertString(documentSimple.getLength(), pre + ls.getTexto(), attributes);

					 i++;
				 }

			 } catch (BadLocationException badLocationException) {
			      LOGGER.warning(mensajes.getString("Fuera_de_rango"));
			 }

		    super.setDocument(documentSimple);
			this.avanzarAlFinal();
		} else {
			documentSimple = new DefaultStyledDocument();

			 SimpleAttributeSet attributes = new SimpleAttributeSet();
			 try {
				documentSimple.insertString(documentSimple.getLength(), "", attributes);

			} catch (BadLocationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			 super.setDocument(documentSimple);
		}


	}

	private void actualizarDocumento() {
		 setText(lineaActual, listaTextoActual);
	}


	@Override
	public void mouseClicked(MouseEvent pE) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseEntered(MouseEvent pE) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseExited(MouseEvent pE) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent pE) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent pEvento) {
		if (!this.isVacio()) {
			if (pEvento.getButton() == MouseEvent.BUTTON3) {

				getPopupMenu().setLocation(pEvento.getLocationOnScreen());
				if (this.getSelectedText() == null) {
					menuItemCopiar.setEnabled(false);
				} else {
					menuItemCopiar.setEnabled(true);
				}

				getPopupMenu().show(this, pEvento.getX(), pEvento.getY());
			}
		}

	}

	private boolean isVacio() {
		return this.getDocument().getLength() == 0;
	}


	public int print(Graphics g, PageFormat pageFormat, int pageIndex) {

		documentTmp = new DefaultStyledDocument();
		listaPaginas = paginarContenidoEditor(listaTextoActual);
		paginaImprimirActual = pageIndex;

		Graphics2D g2 = (Graphics2D)g;
		g2.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
		boolean wasBuffered = Impresora.getInstance().disableDoubleBuffering(this);

		imprimirPaginaSiguiente(g2);

		Impresora.getInstance().restoreDoubleBuffering(this, wasBuffered);

		return PAGE_EXISTS;

	}

	private String paginarEditor(IUVisorTexto pVisor, int pPaginaActual) {


		listaPaginas = new ArrayList<String>();
		listaPaginas = paginarContenidoEditor(listaTextoActual );
		SimpleAttributeSet attributes = new SimpleAttributeSet();
		 attributes.addAttribute(StyleConstants.CharacterConstants.FontSize, 12);
		try {
			documentTmp.insertString(0, listaPaginas.get(paginaImprimirActual - primeraPaginaImprimir), attributes);
			this.setDocument(documentTmp);
		} catch (BadLocationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

			return null;
}

	/**
	 * @param pListaTextoActual
	 * @return
	 */
	public List<String> paginarContenidoEditor(List<LogString> pListaTextoActual) {
		int i;
		List<String> listaPaginas;

		i = 0;
		listaPaginas = new ArrayList<String>();
		String pagina = "";
		for (i=0;i <= pListaTextoActual.size() - 1; i++) {
			if ((i != 0) && (i % 45 == 0)) {
				String pre = "";
				if (puedeMostrarLinea) {
					pre = "[" + "línea" + " " + pListaTextoActual.get(i).getLinea() + "]" + "  ";
				}
				pagina += pre + pListaTextoActual.get(i).getTexto();
				listaPaginas.add(pagina);
				pagina = "";

			} else {
				String pre = "";
				if (puedeMostrarLinea) {
					pre = "[" + mensajes.getString("línea") + " " + pListaTextoActual.get(i).getLinea() + "]" + "  ";
				}
				pagina += pre + pListaTextoActual.get(i).getTexto();

			}

		}
		if (pagina != null) {
			listaPaginas.add(pagina);
		}
		return listaPaginas;
	}

	private void imprimirPaginaSiguiente(Graphics g2) {

			paginarEditor(this, subindice);
			this.paint(g2);
			this.setDocument(documentSimple);
			this.avanzarAlFinal();
	}

	/**
	 * @return the listaTextoActual
	 */
	public List<LogString> getListaTextoActual() {
		return listaTextoActual;
	}

	public void setPrimeraPaginaImprimir(int pPagina) {
		primeraPaginaImprimir = pPagina;
	}





}
