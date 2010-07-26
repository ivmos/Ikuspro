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
import ikuspro.simulador.graficos.modelo.Llamada;

import java.awt.Font;
import java.awt.Graphics2D;
import java.util.ResourceBundle;

public class IULlamada {

	private final String nombre;
	private double x;
	private double y;

	public IULlamada(double pX, double pY, String pNombre) {
		x = pX;
		y = pY;
		nombre = pNombre;
	}

	public IULlamada(Llamada pL) {
		this(pL.getX(), pL.getY(), pL.getNombre());
	}

	/**
	 *
	 */
	private static final long serialVersionUID = -3430634942705509573L;
    private static final ResourceBundle mensajes = ResourceBundle.getBundle("ikuspro/gui/Mensajes");

	public void dibujar(Graphics2D pen) {

		pen.setColor(ColorManager.COLOR_NOMBRE_LLAMADA);
		pen.setFont(new Font("Arial", Font.BOLD, 24));
		pen.drawString(nombre , (float) (this.getX() + Llamada.MARGEN_IZDA_BLOQUE), (float) (this.getY() + 25.0));
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

}
