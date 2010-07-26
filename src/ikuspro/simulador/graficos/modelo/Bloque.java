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

import java.util.ResourceBundle;
import nu.xom.Element;

public class Bloque extends Rectangulo {

	public static final double DEFAULT_ANCHO = Variable.DEFAULT_ANCHO ;
	public static final double DEFAULT_ALTO = Variable.DEFAULT_ALTO ;
	public static final double MARGEN = 20.0;
    private static final ResourceBundle mensajes = ResourceBundle.getBundle("ikuspro/gui/Mensajes");
	private Bloque padre;
	private boolean vacio;
	private int numElementos;


	public Bloque(double pAncho, double pAlto) {
		super(pAncho, pAlto);
		vacio = true;
		numElementos = 0;

	}

	public Bloque(Element pElemento) {
		this(DEFAULT_ANCHO, DEFAULT_ALTO);
	}

	/**
	 *
	 * @param pRectangulo
	 * @param pPrimario
	 *
	 * Añade un rectangulo al bloque, que puede ser una variable u otra variable.
	 */
	public void add(Rectangulo pRectangulo, boolean pPrimario) {

		// Si el Rectanuglo es una Variable ya no va a estar vacio
		if (pRectangulo instanceof Variable) {
			vacio = false;
		}
		// Si es este es un bloque primario hay que indentar el Rectangulo
		// pero hay una excepcion para el primer bloque de cada bloque.

		// Se hace esta excepcion ya que en las llamadas queda raro que las variables
		// declaradas dentro del bloque se les ponga en un bloque distinto al de los
		// parametros formales. No es eso lo que se ve en main, y por ello para ser
		// coherentes usamos esta excepcion.
		// Ademas, haremos invisible ese bloque pero eso en la vista claro esta .
		if (pPrimario) {
			if (	!(pRectangulo instanceof Bloque) || // Si no es un bloque OR...
				( (pRectangulo instanceof Bloque) 	// Es un bloque
						&& // AND ...
					((Bloque) pRectangulo).getPadre() != this) )  // No estamos en su padre.
			{

				pRectangulo.setX(this.getX() + MARGEN);
			} else {
				pRectangulo.setX(this.getX());
			}
		}

		if (pPrimario) {
				if (pRectangulo instanceof Variable) { // Si este bloque es primario y el Rectangulo es Variable
					pRectangulo.setY(this.getY() + Variable.DEFAULT_ALTO * numElementos + MARGEN);
				} else {
					pRectangulo.setY(this.getY() + Variable.DEFAULT_ALTO * numElementos );
				}
		}

		double diferenciaAlto = (pRectangulo.getY() + pRectangulo.getAlto()) - (this.getY() + this.getAlto());
		if (diferenciaAlto >= 0) {
			this.setAlto(this.getAlto() + diferenciaAlto + MARGEN);
			//this.setAlto(this.getAlto() + diferenciaAlto);
		}


		double diferenciaAncho = (MARGEN + pRectangulo.getX() + pRectangulo.getAncho()) - (this.getX() + this.getAncho());
		if (diferenciaAncho >= 0 ) {
			this.setAncho(this.getAncho() + diferenciaAncho + MARGEN );
			//this.setAncho(this.getAncho() + diferenciaAncho );
		}

		if (padre != null) {
				padre.add(this, false);
		}

		numElementos ++;
	}

	/**
	 *
	 * @param pBloque
	 *
	 * Elimina un bloque contenido en este bloque
	 */
	public void del(Bloque pBloque) {
		// Por ahora evitamos disminuir tamaño ya que es confuso para el usuario
		//this.setAlto(this.getAlto() - pBloque.getAlto() - MARGEN);
		//this.setAncho(this.getAncho() - MARGEN);
		numElementos -= pBloque.getNumElementos();
		numElementos --;
		if (padre != null) {
			padre.del(pBloque);
		}
		if (numElementos == 0) { // Si no hay ningun elemento
			vacio = true;
		} else if((numElementos == 1) && (padre != null)) { // Si hay un elemento pero es su padre bloque
			vacio = true;
		}
	}

	/**
	 *
	 * @param pPadre
	 *
	 * Establece el bloque que contiene a este bloque
	 */
	public void setPadre(Bloque pPadre) {
		padre = pPadre;
	}

	/**
	 *
	 * @return el bloque que contiene a este bloque inmediatamente (no indirectamente)
	 */
	public Bloque getPadre() {
		return padre;
	}

	/**
	 *
	 * @param pRect
	 * @return TRUE si este bloque contiene geométricamente a el rectangulo
	 */
	public boolean contiene(Rectangulo pRect) {

		return  ((pRect.getY() > this.getY()) && (pRect.getY()  < this.getY() + this.getAlto())
				&& (pRect.getX() > this.getX()) && (pRect.getX()  < this.getX() + this.getAncho()) );
	}

	/**
	 *
	 * @return TRUE si no tiene elementos
	 */
	public boolean isVacio() {
		return vacio;
	}



	@Override
	/**
	 * Devuelve el comentario correspondiente a este bloque.
	 */
	public String getComentario() {
		String s = "";
//		if (isVacio()) {
//			if (getPadre() == null) {
//				// Quitado a peticion de Mikel
//				//s = "Dentro del cuerpo principal de la funcion.";
//			} else {
//				//s = "Nuevo ambito de alcance local.";
//			}
//		} else {
//			if (getPadre() == null) {
//				//Quitado a peticion de Mikel
//				//s = "Terminado cuerpo principal de la funcion";
//			} else {
//				// Quitado a peticion de mikel
//				//s = "Terminado ambito.";
//			}
//		}
		return s;
	}

	/**
	 *
	 * @return número de elementos conteidos
	 */
	public int getNumElementos() {
		return numElementos;
	}

	/**
	 * @param pNumElementos the numElementos to set
	 */
	public void setNumElementos(int pNumElementos) {
		numElementos = pNumElementos;
	}

	/**
	 *
	 * @return TRUE si no tiene padre
	 */
	public boolean isPrincipal() {
		return getPadre() == null;
	}

}
