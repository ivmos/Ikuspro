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
import ikuspro.simulador.graficos.modelo.Variable;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.util.ResourceBundle;

public class IUVariableSimple extends IUVariable {

	private IUCelda iuCelda;
	private static final long serialVersionUID = 7960778113315827137L;
    private static final ResourceBundle mensajes = ResourceBundle.getBundle("ikuspro/gui/Mensajes");

	public IUVariableSimple() {
		iuCelda = new IUCelda();
		x = 0;
		y = 0;
		iuCelda.x = 0;
		iuCelda.y = 0;
	}
	public IUVariableSimple(Variable pV) {

		nombre = pV.getNombre();
		nombre += ":" + pV.getTipo();
		x = (float) pV.getX();
		y = (float) pV.getY();
		iuCelda = new IUCelda(x, y + SEPARACION );

		String valor;
		valor = pV.getValor();
		if (pV.isReferencia()) { // Si es una referencia..
			iuCelda.setContenido(" "); // Ponemos en la celda un indicador que lo refleje.
		} else {
			iuCelda.setContenido(valor);
		}

//		if (pV.isReferencia()) {
//			puntoRef = new Point2D.Float(
//						(float) pV.getObjetoReferenciadoPrincipal().getX() + (float) IUCelda.DEFAULT_ANCHO / 2,
//						(float) pV.getObjetoReferenciadoPrincipal().getY() )	;
//		}

		variableModelo = pV;
	}


	public void dibujar(Graphics2D pen) {
		pen.setColor(ColorManager.COLOR_NOMBRE_VARIABLE);
		pen.setFont(new Font("Arial", Font.PLAIN, 18));
		pen.drawString(nombre, x, y);

	    iuCelda.dibujar(pen);

	}


	public Point2D.Float getCentroCelda() {
		return new Point2D.Float((float) iuCelda.x + (float) iuCelda.width / 2.0f,
								(float) iuCelda.y + (float) iuCelda.height / 2.0f);
	}





	public void dibujarLineaReferencia(Graphics2D pen) {
		if (variableModelo.getPuntoRef() != null) { // Si esto es un puntero/referencia
			dibujarFlechaCurva(pen, getCentroCelda(), variableModelo.getPuntoRef());
		}


	}
}
