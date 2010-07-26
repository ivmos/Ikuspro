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



package ikuspro.simulador.graficos.vista;



import ikuspro.simulador.graficos.ColorManager;
import ikuspro.simulador.graficos.modelo.Bloque;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;
import java.util.ResourceBundle;

public class IUBloque extends RoundRectangle2D.Double {

	/**
	 *
	 */
	private static final long serialVersionUID = -1832112302373159868L;

	private static final double ANCHO_ARCO = 25.0;
	private static final double ALTO_ARCO = 25.0;
    private static final ResourceBundle mensajes = ResourceBundle.getBundle("ikuspro/gui/Mensajes");
	private Color color;
	private boolean dibujar;


	public IUBloque(double pX, double pY, double pAncho, double pAlto, double pAnchoArco, double  pAltoArco, Color pColor) {
		super(pX, pY, pAncho, pAlto, pAnchoArco, pAltoArco);
		color = pColor;
		dibujar = true;
	}



	public IUBloque(double pX, double pY, double pAncho, double pAlto) {
		this(pX, pY, pAncho, pAlto, ANCHO_ARCO, ALTO_ARCO, ColorManager.COLOR_BLOQUE_PRINCIPAL);
		dibujar = true;
	}





	public IUBloque(Bloque pV) {
		this(pV.getX(), pV.getY(), pV.getAncho(), pV.getAlto());

		// A continuacion una excepcion para que en las llamadas el primer bloque no se dibuje
		// y queden asi al mismo nivel las variables del cuerpo con los parametros formales,
		// para que quede parecido a lo que se ve en main.

		// solo dibujamos el bloque principal de todos.
		if (pV.getPadre() != null) {
			dibujar = false;
		} else {
			dibujar = true;
		}
	}

	public Color getColor() {
		return color;
	}

	 public void dibujar(Graphics2D pen) {
		 if (dibujar) {
	      pen.setPaint(this.getColor());
	      pen.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
	                           RenderingHints.VALUE_ANTIALIAS_ON);
	      pen.setStroke(new BasicStroke(4.0f));
	      pen.draw(this);
		 }
	 }










}
