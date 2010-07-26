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



package ikuspro.simulador.graficos.modelo;



import ikuspro.gui.ConfiguracionGUI;
import ikuspro.simulador.IUSimulador;
import ikuspro.simulador.graficos.ColorManager;
import ikuspro.simulador.graficos.vista.IUCelda;

import java.awt.Color;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import nu.xom.Element;

public class Variable extends Rectangulo{

	private static final String MARCA_FIN_ARRAY_CARACTERES = "\\0";
	private String nombre;
	private String tipo;
	private int longitud;
	private boolean referencia = false;
	private Variable objetoReferenciado;
	private List<String> listaValores;
	public static final double DEFAULT_ANCHO = 100.0;
	public static final double DEFAULT_ALTO = 80.0;
	private static final double MARGEN_DCHO = 20.0;
	private static final String INDEFINIDO = "?";
    private static final ResourceBundle mensajes = ResourceBundle.getBundle("ikuspro/gui/Mensajes");
	private int numReferencias = 0; // Numero de referencias apuntando, se va seteando segun se dibuja
	private Color colorReferencia;
	private Map<Variable, Point2D.Float> listaPuntosReferencia = new LinkedHashMap<Variable,Point2D.Float>();
	private Point2D.Float puntoRef;


	public Variable(double pAncho, double pAlto) {
		super(pAncho, pAlto);
		// TODO Auto-generated constructor stub
	}

	public Variable(double pAncho, double pAlto, String pNombre, String pTipo, int pLongitud,
					boolean pReferencia, Variable pObjetoReferenciado, List<String> pListaValores) {
		super(pAncho,pAlto);
		nombre = pNombre;
		tipo = pTipo;
		longitud = pLongitud;
		referencia = pReferencia;
		objetoReferenciado = pObjetoReferenciado;
		listaValores = pListaValores;

	}

	public Variable(Element pElemento) {
		this(DEFAULT_ANCHO, DEFAULT_ALTO);
		nombre = pElemento.getFirstChildElement("nombre").getValue();
		tipo = pElemento.getFirstChildElement("tipo").getValue();
		String valor = null;
		String longitud = null;
		if (pElemento.getFirstChildElement("valor") != null) {
			valor = pElemento.getFirstChildElement("valor").getValue();
		} else if (pElemento.getFirstChildElement("nombreRef") != null) {
			referencia = true;
			objetoReferenciado = IUSimulador.getInstance().buscarVariableRef(
						pElemento.getFirstChildElement("nombreRef").getValue()).getObjetoReferenciado();

			listaValores = getObjetoReferenciadoPrincipal().getListaValores();
			this.longitud = listaValores.size();

		}


		if (pElemento.getFirstChildElement("longitud") != null) {
			longitud = pElemento.getFirstChildElement("longitud").getValue();
		}

		if (longitud == null && !isReferencia()) { // NO es ni un array ni una referencia
			this.longitud = 1;
			listaValores = new ArrayList<String>(this.longitud);
			if ( valor != null) { // Hay valor por defecto
				iniTodoA(valor);
			} else {
				iniTodoA(INDEFINIDO);
			}
		} else if (!isReferencia()) { // ES un array
			this.longitud = Integer.parseInt(longitud);
			listaValores = new ArrayList<String>(this.longitud);
			if ( valor != null ) {
				iniTodoA(valor);
			} else {
				iniTodoA(INDEFINIDO);
			}

			if (this.getAncho() < (this.longitud)*80.0 ) {
				this.setAncho((this.longitud)*(IUCelda.DEFAULT_ANCHO) );
			}
		}
	}

	/**
	 *
	 * @param pValor
	 *
	 * Inicializa todo a pValor
	 */
	private void iniTodoA(String pValor) {
		int i = 0;
		for(i=0;i<=this.longitud - 1 ; i++) {
			listaValores.add(pValor);
		}
	}

	public String getValor() {

		return listaValores.get(0);

	}

	public String getValor(Integer pIndice) {
		return getListaValores().get(pIndice);
	}



	public void setValor(String pValor) {
		String valor = pValor;
		if (valor.equals("END")) {
			valor = MARCA_FIN_ARRAY_CARACTERES;
		}

			listaValores.set(0, valor);

	}

	public void setValor(String pValor, Integer pIndice) {
		String valor = pValor;
		if (pIndice <= this.getObjetoReferenciadoPrincipal().getLongitud() - 1) { // Si pIndice no se sale del maximo...
			if (valor.equals("END")) {
				valor = MARCA_FIN_ARRAY_CARACTERES;
			}

				this.getObjetoReferenciadoPrincipal().getListaValores().set(pIndice, valor);

		} // ... sino se ignora.

	}


	public String getNombre() {
		return nombre;
	}

	public String getTipo() {
		return tipo;
	}

	@Override
	public String getComentario() {
		String s = "";
		if (getValor().equals("?")) {
			// FIX: esto es un workaround para el euskara. La solución debería ser hacer como
			// en Variable->getComentario() (uso de expresiones %s)
			// Por falta de tiempo se recurre a este workaround
			if (!ConfiguracionGUI.getInstance().getLocale().getLanguage().equals("eu")) {
				s = mensajes.getString("Declarada_una_nueva_variable_con_nombre_") + " " + getNombre();
			} else {
				s = getNombre() + " " + mensajes.getString("Declarada_una_nueva_variable_con_nombre_").replace("X", "");
			}
		} else {
			s = mensajes.getString("El_valor_de_la_variable_%s_es_ahora_%s") + " ";
			if (isArray()) {
				s = String.format(s, getNombre(), listaValores.toString());
			} else if (isReferencia()) {
				s =  String.format(s, getNombre(), getObjetoReferenciadoPrincipal().getListaValores().toString());
			} else {
				s = String.format(s, getNombre(), getValor());
			}
		}
		return s;
	}

	public boolean isArray() {
			return listaValores.size() > 1;
	}

	/**
	 * @return the longitud
	 */
	public int getLongitud() {
		return longitud;
	}

	/**
	 * @return the listaValores
	 */
	public List<String> getListaValores() {
		return listaValores;
	}

	/**
	 * @return the referencia
	 */
	public final boolean isReferencia() {
		return referencia;
	}


	private Variable buscarObjetoReferenciadoPrincipal(Variable var) {

		if (var.getObjetoReferenciado() != null) {

			return buscarObjetoReferenciadoPrincipal(var.getObjetoReferenciado());
		} else {
			return var;
		}
	}

	/**
	 * @return the objetoReferenciado
	 */
	public Variable getObjetoReferenciadoPrincipal() {
		return buscarObjetoReferenciadoPrincipal(this);
	}



	/**
	 * @param pReferencia the referencia to set
	 */
	public void setReferencia(boolean pReferencia) {
		referencia = pReferencia;
	}

	/**
	 * @param pObjetoReferenciado the objetoReferenciado to set
	 */
	public void setObjetoReferenciado(Variable pObjetoReferenciado) {
		objetoReferenciado = pObjetoReferenciado;
	}

	/**
	 * @param pListaValores the listaValores to set
	 */
	public void setListaValores(List<String> pListaValores) {
		listaValores = pListaValores;
	}

	/**
	 * @param pLongitud the longitud to set
	 */
	public void setLongitud(int pLongitud) {
		longitud = pLongitud;
	}



	public Variable getReferencia() {
		Variable var = null;
		var = new Variable(DEFAULT_ANCHO,DEFAULT_ALTO,nombre,tipo,0,true, this,
				new ArrayList<String>() {{
					add("");
				}});


		return var;
	}

	/**
	 *
	 * @param pVar
	 * @return
	 *
	 * El punto de la referencia si es una variable simple será una esquina mientras
	 * que si es un array se irán repartiendo ciclicamente sobre las uniones.
	 */
	public Point2D.Float getPuntoReferenciaORaddReferencia(Variable pVar) {

		Point2D.Float puntoReferencia = listaPuntosReferencia.get(pVar);
		if (puntoReferencia == null) {
			numReferencias ++;
			// por dar un valor...
			if (!this.getObjetoReferenciadoPrincipal().isArray()) {
				// En variables simples el punto de referencia queda bien en la esquina superior derecha
				puntoReferencia = new Point2D.Float( (float)this.getObjetoReferenciadoPrincipal().getX()
							+ IUCelda.DEFAULT_ANCHO,
						(float) this.getObjetoReferenciadoPrincipal().getY());
			} else {
				puntoReferencia = new Point2D.Float( (float)this.getObjetoReferenciadoPrincipal().getX(),
						(float) this.getObjetoReferenciadoPrincipal().getY());
				listaPuntosReferencia.put(pVar, puntoReferencia);
				Iterator<Point2D.Float> ite = listaPuntosReferencia.values().iterator();
				int i = 0;
				while(ite.hasNext()) {
					if (i > this.getObjetoReferenciadoPrincipal().getLongitud()) {
						i = 0;
					}
					Point2D.Float elemento = ite.next();
					elemento.setLocation( (float) this.getObjetoReferenciadoPrincipal().getX() +
									i * IUCelda.DEFAULT_ANCHO
									, elemento.y)	;

					i++;

				}
			}
		}

		return puntoReferencia;

	}

	public Color getColorReferencia() {
		if (colorReferencia == null) {
			colorReferencia = ColorManager.getInstance().getNuevoColor();
		}
		return colorReferencia;
	}

	/**
	 * @return the objetoReferenciado
	 */
	public Variable getObjetoReferenciado() {
		return objetoReferenciado;
	}

	/**
	 * @param pNumReferencias the numReferencias to set
	 *
	 *
	 */
	public void resetNumReferencias() {
		numReferencias = 0;
		listaPuntosReferencia = new LinkedHashMap<Variable,Point2D.Float>();
	}

	/**
	 * @return the numReferencias
	 */
	public int getNumReferencias() {
		return numReferencias;
	}


	public void calcularPuntoReferencia() {
		Variable objetoReferenciadoPrincipal;
		if(isReferencia()) {
			objetoReferenciadoPrincipal = getObjetoReferenciadoPrincipal();

		puntoRef =
				objetoReferenciadoPrincipal.getPuntoReferenciaORaddReferencia(this)	;
		}

	}

	/**
	 * @return the puntoRef
	 */
	public Point2D.Float getPuntoRef() {
		return puntoRef;
	}





}
