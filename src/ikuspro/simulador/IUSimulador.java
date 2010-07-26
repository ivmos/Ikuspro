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



package ikuspro.simulador;


import ikuspro.gui.ConfiguracionGUI;
import ikuspro.gui.IUExportar;
import ikuspro.gui.util.Impresora;
import ikuspro.simulador.graficos.ColorManager;
import ikuspro.simulador.graficos.modelo.Bloque;
import ikuspro.simulador.graficos.modelo.Llamada;
import ikuspro.simulador.graficos.modelo.Variable;
import ikuspro.simulador.graficos.vista.IUBloque;
import ikuspro.simulador.graficos.vista.IULlamada;
import ikuspro.simulador.graficos.vista.IUVariable;
import ikuspro.simulador.graficos.vista.IUVariableCompuesta;
import ikuspro.simulador.graficos.vista.IUVariableSimple;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.Scrollable;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

import org.jdesktop.swingx.SwingXUtilities;








/**
 *
 * @author Iván Mosquera Paulo
 *
 * Este es el componente que hace de lienzo, el dibujo, de la simulación.
 * Cade vez que se repinta se ajusta al modelo y se va redibujando.
 */
public final class IUSimulador extends JPanel implements MouseListener, ActionListener, Printable, Scrollable {



	private static final Dimension SIZE_INICIAL = new Dimension(0, 0);

	private static final double POS_INICIAL_SCROLL = 0.0;

	private static final int INCREMENTO_SCROLL = 50;

	/**
	 *
	 */
	private static final long serialVersionUID = 7189608534173218509L;

	private static IUSimulador instance;

	private List<Bloque> listaBloques;
	private List<Llamada> listaLlamadas;
	private List<Variable> listaVariables;


	private HashMap<Llamada, IULlamada> mapaLlamadas;
	private HashMap<Bloque, IUBloque> mapaBloques;
	private HashMap<Variable, IUVariable> mapaVariables;

	private JButton botonAumentar;
	private JButton botonReducir;
	private JButton botonExportar;

	private JMenuItem botonMenuAumentar;
	private JMenuItem botonMenuReducir;
	private JMenuItem botonMenuExportar;
	private int imprimido = 0;

	private double  zoom;
	public static final double DEFAULT_ZOOM = 1.0;
	private static final double ZOOM_MIN = 0.5;
	private static final double ZOOM_MAX = 1.5;
	private static final double ZOOM_PASO = 0.25;



	private Bloque bloqueArrays;
    private static final ResourceBundle mensajes = ResourceBundle.getBundle("ikuspro/gui/Mensajes");

	private Double posicionScroll ;

	/**
	 *
	 * @author Iván Mosquera Paulo
	 *
	 * Comandos relacionados con el simulador gráfico
	 */
	public static enum comandos {
		AMPLIAR,
		REDUCIR,
		EXPORTAR,
		CAMBIAR_ESTILO;
	}

	private JPopupMenu menu;
	private JMenuItem menuItemAumentar;
	private JMenuItem menuItemReducir;
	private JMenuItem menuItemExportar;
	private JMenuItem menuItemCambiarEstilo;

	private IUSimulador() {
		super();
		this.addMouseListener(this);
		this.zoom = DEFAULT_ZOOM;
		posicionScroll = POS_INICIAL_SCROLL;
		this.setFocusable(true);
		this.setBackground(ColorManager.COLOR_LIENZO);
		this.setDoubleBuffered(true);

		iniciar();
	}

	public void iniciar() {
		this.setPreferredSize(SIZE_INICIAL); // Necesario para que funcione el scroll
		bloqueArrays = null;
		listaBloques = new CopyOnWriteArrayList<Bloque>();
		listaLlamadas = new CopyOnWriteArrayList<Llamada>();
		listaVariables = new CopyOnWriteArrayList<Variable>();
		posicionScroll = POS_INICIAL_SCROLL;
		ColorManager.getInstance().reiniciar();
		this.setBackground(ColorManager.COLOR_LIENZO);

	}

	public void limpiar() {
		iniciar();
		actualizar();


	}


	public synchronized static IUSimulador getInstance() {
		if (instance == null) { instance = new IUSimulador(); }
		return instance;
	}



	/**
	 * Asocia el modelo con la vista
	 */
	public void actualizar() {
		 // Usamos un swingworker para no recargar el hilo EDT con las operaciones
		 final SwingWorker worker = new SwingWorker() {

			@Override
			protected Object doInBackground() throws Exception {

				//System.out.println("Liandola parda en el EDT " + SwingUtilities.isEventDispatchThread());
				asociarLlamadasIU();
				asociarVariablesIU();
				asociarBloquesIU();
				calcularReferencias();
				quitarVariablesResiduales();
				ajustarLienzoYmaxScroll();
				return true;
			}

			/* (non-Javadoc)
			 * @see javax.swing.SwingWorker#done()
			 */
			@Override
			protected void done() {
				super.done();
				repaint();
				revalidate();
				//setSize(IUSimulador.this.getPreferredSize());
			}

	        };
	        worker.execute();






	}

	/**
	 * Asocia los modelos de las llamadas con las vistas
	 */
	private void asociarLlamadasIU() {
		mapaLlamadas = new HashMap<Llamada, IULlamada>();
		Iterator<Llamada> itl = listaLlamadas.iterator();
		while (itl.hasNext()){
			Llamada l = itl.next();
			mapaLlamadas.put(l, new IULlamada(l));
		}
	}

	/**
	 * Asocia los modelos de los bloques con las vistas de los mismos
	 */
	private void asociarBloquesIU() {
		mapaBloques = new HashMap<Bloque, IUBloque>();
		Iterator<Bloque> itb = listaBloques.iterator();
		while (itb.hasNext()){
			Bloque b = itb.next();
			mapaBloques.put(b, new IUBloque(b));
		}
		getBloqueArrays().setNumElementos(0);
		colocarBloqueAlFinal(getBloqueArrays());

		Iterator<Variable> itv = listaVariables.iterator();
		while (itv.hasNext()){
			Variable v = itv.next();
			if (v.isArray()) {
				colocarBloqueAlFinal(getBloqueArrays());

				getBloqueArrays().add(v,true);
				v.resetNumReferencias();
				mapaVariables.put(v, new IUVariableCompuesta(v));
			} else {

			}
		}
		mapaBloques.put(getBloqueArrays(), new IUBloque(getBloqueArrays()));
	}


	/**
	 * Ajusta el lienzo al tamaño ideal y la zona que debería mostrar un scroll según los bloques actuales
	 */
	private void ajustarLienzoYmaxScroll() {
		Iterator<Bloque> ite = listaBloques.iterator();
		int margen = 50;
		posicionScroll = 0.0;
		double maxAncho = 0.0;
		double maxAlto = 0.0;
		while(ite.hasNext()) {
			Bloque b = ite.next();
			if (b.isPrincipal()) {
				if ( zoom * (b.getX()+ b.getAncho() + margen) > maxAncho) {
					maxAncho = zoom * (b.getX() + b.getAncho() + margen);
					if (b != getBloqueArrays()) {
						posicionScroll = maxAncho;
					}
				}
				if ( zoom * (b.getY() + b.getAlto() + margen) > maxAlto) {
					maxAlto = zoom * (b.getY() + b.getAlto() + margen);
				}
			}
		}

		this.setPreferredSize(new Dimension((int)maxAncho,(int)maxAlto));
	}

	/**
	 * Asocia los modelos de las variables con las vistas correspondientes
	 */
	private void asociarVariablesIU() {
		mapaVariables = new HashMap<Variable, IUVariable>();
		Iterator<Variable> itv = listaVariables.iterator();
		while (itv.hasNext()){
			Variable v = itv.next();
			if (!v.isArray()) {
				mapaVariables.put(v, new IUVariableSimple(v));
			}
		}
	}

	/**
	 * Método principal de dibujado
	 */
	public void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);

		Graphics2D pen = (Graphics2D) graphics;

		AffineTransform at = new AffineTransform();
		at.scale(zoom, zoom);
		pen.transform(at);

		redibujarLlamadas(pen);
		redibujarBloques(pen);
		redibujarVariables(pen);
		redibujarReferencias(pen);

	}



	private void redibujarBloques(Graphics2D pPen) {
		Iterator<Bloque> itb = listaBloques.iterator();
		while(itb.hasNext()) {
			Bloque b = itb.next();
			IUBloque iub = mapaBloques.get(b);

			if (iub != null && !b.isVacio()) {
				iub.dibujar(pPen);
			}
		}

	}

	private void redibujarVariables(Graphics2D pPen) {
		Iterator<Variable> itv = listaVariables.iterator();
		while(itv.hasNext()) {
			Variable v = itv.next();
			IUVariable iuv = mapaVariables.get(v);
			if (iuv != null ) {
				iuv.dibujar(pPen);
			}
		}

	}

	private void redibujarReferencias(Graphics2D pPen) {
		Iterator<Variable> itv;

		itv = listaVariables.iterator();
		while(itv.hasNext()) {
			Variable v = itv.next();
			IUVariable iuv = mapaVariables.get(v);
			if (iuv != null && iuv instanceof IUVariableSimple) {
				((IUVariableSimple)iuv).dibujarLineaReferencia(pPen);
			}
		}

	}

	/**
	 *
	 */
	private void calcularReferencias() {

		Iterator<Variable> itv = listaVariables.iterator();

		while(itv.hasNext()) {
			Variable v = itv.next();
			if (v.isReferencia()) {
				v.calcularPuntoReferencia();
			}
		}
	}

	/**
	 *
	 */
	private void quitarVariablesResiduales() {
		Iterator<Variable> itv;
		// Ahora quitamos aquellas variables compuestas (arrays) que no tengan referencias porque
		// son residuales. A estas alturas todas deberían tener alguna referencia y si no es porque
		// son arrays ya no utilizados. Graficamente seria confuso mantenerlos

		itv = listaVariables.iterator();
		while(itv.hasNext()) {
			Variable v = itv.next();
			if (v.isArray() && v.getNumReferencias() == 0) {
				listaVariables.remove(v);
				// Ahora hay una variable menos en el array bloque
				getBloqueArrays().setNumElementos(getBloqueArrays().getNumElementos() - 1);
			}
		}
	}

	private void redibujarLlamadas(Graphics2D pPen) {
		Iterator<Llamada> itl = listaLlamadas.iterator();
		while(itl.hasNext()) {
			Llamada l = itl.next();
			IULlamada iul = mapaLlamadas.get(l);
			if (iul != null) {
				iul.dibujar(pPen);
			}
		}

	}

	/**
	 * @param pBloque
	 */
	private void colocarBloqueAlFinal(Bloque pBloque) {
		Iterator<Bloque> ite = listaBloques.iterator();
		double max = 0;
		while(ite.hasNext()) {
			Bloque b = ite.next();
			double valor = b.getY() + b.getAlto() ;
			if (valor > max && b != pBloque) {
				max = valor;
			}
		}
		pBloque.setY(max + Bloque.MARGEN);
		pBloque.setX(Llamada.MARGEN_IZDA_BLOQUE);
	}

	public void addBloque(Bloque pBloque) {

		Llamada ultima = listaLlamadas.get(listaLlamadas.size() - 1);
		if (ultima.getBloque() == null) {
			ultima.setBloque(pBloque);
		} else {
			Bloque ultimo = listaBloques.get(listaBloques.size() - 1);
			pBloque.setPadre(ultimo);
			ultimo.add(pBloque,true);
		}

		listaBloques.add(pBloque);

	}

	public void addBloqueSolo(Bloque pBloque) {
		listaBloques.add(pBloque);
	}

	/**
	 *
	 * @param pLlamada
	 *
	 * Añade una llamada
	 */
	public void addLlamada(Llamada pLlamada) {
		if (listaLlamadas.size() > 0) {
			Llamada llamada = listaLlamadas.get(listaLlamadas.size() - 1);
			pLlamada.setX(llamada.getBloque().getX() + llamada.getBloque().getAncho() + 60.0);
		}

		listaLlamadas.add(pLlamada);
	}

	public void addVariable(Variable pVariable) {
		Bloque ultimo = listaBloques.get(listaBloques.size() - 1);
		if (pVariable.isArray()) {
			Variable referencia = pVariable.getReferencia();
			listaVariables.add(referencia);
			ultimo.add(referencia, true);
		} else {
			ultimo.add(pVariable,true);
			listaVariables.add(pVariable);
		}
		Iterator<Variable> ite = listaVariables.iterator();
		boolean encontrado = false;
		while(ite.hasNext() && !encontrado) {
			if (ite.next().getListaValores() == pVariable.getListaValores()) {
				encontrado = true;
				break;
			}
		}
		if (!encontrado) {
			listaVariables.add(pVariable);
		}
	}

	/**
	 *
	 * @param pNombre
	 * @param pValor
	 * @return la variable recién asignada
	 *
	 * Asigna un valor a una variable
	 */
	public Variable asignar(String pNombre, String pValor) {
		int ultimaVar = listaVariables.size() - 1;
		int i;
		for(i=ultimaVar; i>=0; i--) {
			if (listaVariables.get(i).getNombre().equals(pNombre)) {
				listaVariables.get(i).setValor(pValor);
				break;
			}
		}
		return listaVariables.get(i);
	}

	/**
	 *
	 * @param pNombre
	 * @param pValor
	 * @param pIndice
	 * @return la variable recién asignada
	 *
	 * Asigna un valor a una variable en una posición concreta (array)
	 */
	public Variable asignar(String pNombre, String pValor, Integer pIndice) {

		int ultimaVar = listaVariables.size() - 1;
		int i;
		for(i=ultimaVar; i>=0; i--) {
			if (listaVariables.get(i).getNombre().equals(pNombre)) {
				listaVariables.get(i).setValor(pValor,pIndice);
				break;
			}
		}
		return listaVariables.get(i);

	}


	/**
	 *
	 * @param pNombre
	 * @return
	 *
	 * Permite buscar la ultima Variable de nombre pNombre.
	 */
	public Variable buscarVariableRef(String pNombre) {
		int ultimo = listaVariables.size() - 1;
		Variable resultado = null;
		for(int i=ultimo;i>=0;i--) {
			if (listaVariables.get(i).getNombre().equals(pNombre)) {
				resultado = listaVariables.get(i);
			}
		}
		return resultado;
	}

	/**
	 * Elimina una llamada
	 */
	public void delLlamada() {
		if (listaLlamadas.size() > 1) {
			Llamada llamada = listaLlamadas.get(listaLlamadas.size() - 1);
			listaLlamadas.remove(llamada);
		}
	}

	/**
	 * Elimina un bloque
	 */
	public void delBloque() {
		// El bloque principal de la funcion principal no se elimina.
		Bloque bloque = listaBloques.get(listaBloques.size() - 1);
		if (bloque == getBloqueArrays() && listaBloques.size() >= 2) {
			bloque = listaBloques.get(listaBloques.size() - 2);
		}
		if (listaBloques.size() > 2) {

			int i= 0;
			while(i<=listaVariables.size() - 1) {
				Variable var = listaVariables.get(i);
				if (bloque.contiene(var)) {
					listaVariables.remove(var);
				} else {
					i++;
				}
			}

			if (bloque.getPadre() != null) {
				bloque.getPadre().del(bloque);
			}
			listaBloques.remove(listaBloques.size() - 1);
		}
	}


	/**
	 *
	 * @return TRUE si el simulador gráfico está vacío
	 */
	public boolean isVacio() {
		return listaBloques.isEmpty() && listaLlamadas.isEmpty() && listaVariables.isEmpty();
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
		if (!this.isVacio()) {
			if (pEvento.getButton() == MouseEvent.BUTTON3) {
				getPopupMenu().setLocation(pEvento.getLocationOnScreen());


				getPopupMenu().show(this, pEvento.getX(), pEvento.getY());
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent pEvent) {

		String comando = pEvent.getActionCommand();
		if (comando.equals(comandos.AMPLIAR.toString())) {
			aumentarZoom();

		} else if (comando.equals(comandos.REDUCIR.toString())) {
			reducirZoom();


		} else if (comando.equals(comandos.EXPORTAR.toString())) {
			exportar();
		} else if (comando.equals(comandos.CAMBIAR_ESTILO.toString())) {
			cambiarEstilo();
		}

		actualizarBotonesZoom();


	}


	private void cambiarEstilo() {
		String mensaje = mensajes.getString("Seleccione_un_estilo_gráfico_para_la_simulación:_");
		JComboBox combo = new JComboBox() {{
			addItem(ColorManager.Estilo.DEFAULT.toString());
			addItem(ColorManager.Estilo.OPUESTO.toString());
			addItem(ColorManager.Estilo.VERDENEGRO.toString());

		}};

		Object[] params = {mensaje, combo};
		int n = JOptionPane.showConfirmDialog(null, params, mensajes.getString("Cambiar_estilo"), JOptionPane.OK_CANCEL_OPTION);
		if (n == JOptionPane.OK_OPTION) {
			ColorManager.setEstilo(combo.getSelectedItem().toString());
			IUSimulador.getInstance().actualizar();
			//IUSimulador.getInstance().repaint();
			// Actualizar el lienzo al nuevo color.
			IUSimulador.getInstance().setBackground(ColorManager.COLOR_LIENZO);
		}
	}

	/**
	 * Exporta una imágen de la simulación gráfica actual
	 */
	private void exportar() {
		BufferedImage imagen = new BufferedImage(this.getWidth(),this.getHeight(),BufferedImage.TYPE_INT_RGB);
		Graphics g = imagen.getGraphics();
		Graphics2D pen = (Graphics2D) g;
		this.paint(pen);

		IUExportar iuExportar = new IUExportar();
		File resultado = iuExportar.getResultado();

		if (resultado != null) {
			try {
				ImageIO.write(imagen,"jpg",new File(resultado.getPath()));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {

		}



	}

	/**
	 * aumenta un paso el zoom
	 */
	public void aumentarZoom() {
		zoom += ZOOM_PASO;
		this.repaint();
		actualizarBotonesZoom();

	}

	/**
	 * disminuye un paso el zoom
	 */
	public void reducirZoom() {
		zoom -= ZOOM_PASO;
		this.repaint();
		actualizarBotonesZoom();
	}

	public void mostrarBotones() {
		getMenuItemAumentar().setEnabled(true);
		getMenuItemReducir().setEnabled(true);
		getMenuItemExportar().setEnabled(true);
		botonAumentar.setEnabled(true);
		botonReducir.setEnabled(true);
		botonExportar.setEnabled(true);
		botonMenuAumentar.setEnabled(true);
		botonMenuReducir.setEnabled(true);
		botonMenuExportar.setEnabled(true);
	}

	public JPopupMenu getPopupMenu() {
		if (menu == null) {
			menu = new JPopupMenu();
			menu.add(getMenuItemAumentar());
			menu.add(getMenuItemReducir());
			menu.addSeparator();
			menu.add(getMenuItemExportar());
			menu.add(getMenuItemCambiarEstilo());

		}
			return menu;
	}

	private JMenuItem getMenuItemExportar() {
		if (menuItemExportar == null) {
			menuItemExportar = new JMenuItem(mensajes.getString("Exportar"),new ImageIcon(getClass().getResource(ConfiguracionGUI.RUTA_ICONOS_16 + "/iconoExportar16.png")));
			menuItemExportar.addActionListener(this);
			menuItemExportar.setActionCommand(comandos.EXPORTAR.toString());
			menuItemExportar.setEnabled(false);
		}
		return menuItemExportar;
	}

	private JMenuItem getMenuItemCambiarEstilo() {
		if (menuItemCambiarEstilo == null) {
			menuItemCambiarEstilo = new JMenuItem(mensajes.getString("Cambiar_estilo"));
			menuItemCambiarEstilo.addActionListener(this);
			menuItemCambiarEstilo.setActionCommand(comandos.CAMBIAR_ESTILO.toString());

		}
		return menuItemCambiarEstilo;
	}

	private JMenuItem getMenuItemReducir() {
		if (menuItemReducir == null) {
			menuItemReducir = new JMenuItem(mensajes.getString("Reducir"),new ImageIcon(getClass().getResource(ConfiguracionGUI.RUTA_ICONOS_16 + "/iconoReducir16.png")));
			menuItemReducir.addActionListener(this);
			menuItemReducir.setActionCommand(comandos.REDUCIR.toString());
			menuItemReducir.setEnabled(false);
		}
		return menuItemReducir;
	}

	private JMenuItem getMenuItemAumentar() {
		if (menuItemAumentar == null) {
			menuItemAumentar = new JMenuItem(mensajes.getString("Aumentar"),new ImageIcon(getClass().getResource(ConfiguracionGUI.RUTA_ICONOS_16 + "/iconoAumentar16.png")));
			menuItemAumentar.addActionListener(this);
			menuItemAumentar.setActionCommand(comandos.AMPLIAR.toString());
			menuItemAumentar.setEnabled(false);
		}
		return menuItemAumentar;
	}

	public Bloque getBloqueArrays() {
		if (bloqueArrays == null) {
			bloqueArrays = new Bloque(Bloque.DEFAULT_ANCHO,Bloque.DEFAULT_ALTO);
			addBloqueSolo(bloqueArrays);
		}
		return bloqueArrays;
	}

	/**
	 *
	 */
	public void actualizarBotonesZoom() {
		if (zoom >= ZOOM_MAX) {
			menuItemAumentar.setEnabled(false);
			botonAumentar.setEnabled(false);
			botonMenuAumentar.setEnabled(false);
			menuItemReducir.setEnabled(true);
			botonReducir.setEnabled(true);
			botonMenuReducir.setEnabled(true);

		} else if (zoom <= ZOOM_MIN) {
			menuItemReducir.setEnabled(false);
			botonReducir.setEnabled(false);
			botonMenuReducir.setEnabled(false);
			menuItemAumentar.setEnabled(true);
			botonAumentar.setEnabled(true);
			botonMenuAumentar.setEnabled(true);
		} else {
			menuItemAumentar.setEnabled(true);
			botonAumentar.setEnabled(true);
			botonMenuAumentar.setEnabled(true);
			botonReducir.setEnabled(true);
			botonMenuReducir.setEnabled(true);
			menuItemReducir.setEnabled(true);
		}
	}

	/**
	 * @param pBotonAumentar the botonAumentar to set
	 */
	public void setBotonAumentar(JButton pBotonAumentar) {
		botonAumentar = pBotonAumentar;
	}

	/**
	 * @param pBotonReducir the botonReducir to set
	 */
	public void setBotonReducir(JButton pBotonReducir) {
		botonReducir = pBotonReducir;
	}

	/**
	 * @param pBotonExportar the botonExportar to set
	 */
	public void setBotonExportar(JButton pBotonExportar) {
		botonExportar = pBotonExportar;
	}

	/**
	 * @param pBotonMenuAumentar the botonMenuAumentar to set
	 */
	public void setBotonMenuAumentar(JMenuItem pBotonMenuAumentar) {
		botonMenuAumentar = pBotonMenuAumentar;
	}

	/**
	 * @param pBotonMenuReducir the botonMenuReducir to set
	 */
	public void setBotonMenuReducir(JMenuItem pBotonMenuReducir) {
		botonMenuReducir = pBotonMenuReducir;
	}

	/**
	 * @param pBotonMenuExportar the botonMenuExportar to set
	 */
	public void setBotonMenuExportar(JMenuItem pBotonMenuExportar) {
		botonMenuExportar = pBotonMenuExportar;
	}

	/**
	 * @param pZoom the zoom to set
	 */
	public void setZoom(double pZoom) {
		zoom = pZoom;
	}

	/**
	 * @return the zoom
	 */
	public double getZoom() {
		return zoom;
	}

	@Override
	public int print(Graphics g, PageFormat pageFormat, int pageIndex)
			throws PrinterException {

			Graphics2D g2 = (Graphics2D)g;
			g2.translate(Impresora.getInstance().getFormatoPagina().getImageableX(),
					Impresora.getInstance().getFormatoPagina().getImageableY());

			boolean wasBuffered = Impresora.getInstance().disableDoubleBuffering(this);
			Double zoom_anterior = ajustarZoomImprimir();
			this.paint(g2);
			setZoom(zoom_anterior);
			Impresora.getInstance().restoreDoubleBuffering(this, wasBuffered);
			imprimido++;

			return Printable.PAGE_EXISTS;
	}


	private Double ajustarZoomImprimir() {
		Double zoom_anterior = getZoom();
		// Para simulador siempre ponemos el folio apaisado
		float ancho = 210.0f;
		float alto = 297.0f;

		if ((getWidth() < ancho) && (getHeight() < alto) ) { // 1. Si no sobrepasa, orientacion normal
			// Se queda tal cual
		} else { // ... si es grande se baja el zoom
			setZoom(0.5);
		}

		return zoom_anterior;

	}

	/**
	 * @return the listaLlamadas
	 */
	public List<Llamada> getListaLlamadas() {
		return listaLlamadas;
	}

	/**
	 * @return the posicionScroll
	 */
	public Double getPosicionScroll() {
		return posicionScroll;
	}

	@Override
	public Dimension getPreferredScrollableViewportSize() {
		return getPreferredSize();
	}

	@Override
	public int getScrollableBlockIncrement(Rectangle pArg0, int pArg1, int pArg2) {
		return INCREMENTO_SCROLL;
	}

	@Override
	public boolean getScrollableTracksViewportHeight() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getScrollableTracksViewportWidth() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getScrollableUnitIncrement(Rectangle pArg0, int pArg1, int pArg2) {
		return INCREMENTO_SCROLL;
	}



}
