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

public class Rectangulo extends Elemento {
    private static final ResourceBundle mensajes = ResourceBundle.getBundle("ikuspro/gui/Mensajes");
	private double ancho;


	public Rectangulo() {

	}
	public Rectangulo(double pAncho, double pAlto) {
		super();
		ancho = pAncho;
		alto = pAlto;
	}

	private double alto;

	public double getAncho() {
		return ancho;
	}
	public void setAncho(double pAncho) {
		ancho = pAncho;
	}
	public double getAlto() {
		return alto;
	}
	public void setAlto(double pAlto) {
		alto = pAlto;
	}
	@Override
	public String getComentario() {
		// TODO Auto-generated method stub
		return null;
	}


}
