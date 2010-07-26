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

import java.awt.Color;
import java.awt.Point;
import java.util.ResourceBundle;

public abstract class Elemento {
    private static final ResourceBundle mensajes = ResourceBundle.getBundle("ikuspro/gui/Mensajes");
	private double x;
	private double y;
	private Color color;


	public Elemento() {
		x = 0.0;
		y = 0.0;
		color = Color.BLACK;

	}

	public Elemento(double pX, double pY, Color pColor, String pComentario) {
		this();
		x = pX;
		y = pY;
		color = pColor;

	}

	public Elemento(Point pCentro, Color pColor, String pComentario) {
		this();
		x = pCentro.getX();
		y = pCentro.getY();
		color = pColor;

	}

	public double getX() {
		return x;
	}

	public void setX(double pX) {
		x = pX;
	}

	public double getY() {
		return y;
	}

	public void setY(double pY) {
		y = pY;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color pColor) {
		color = pColor;
	}

	public abstract String getComentario();


}
