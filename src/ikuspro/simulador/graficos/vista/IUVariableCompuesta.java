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



import ikuspro.main.ConfiguracionMain;
import ikuspro.simulador.graficos.ColorManager;
import ikuspro.simulador.graficos.modelo.Variable;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;

public class IUVariableCompuesta extends IUVariable {

	private List<IUCelda> listaIuCelda;
	private static final long serialVersionUID = 7960778113315827137L;
    private static final ResourceBundle mensajes = ResourceBundle.getBundle("ikuspro/gui/Mensajes");


	public IUVariableCompuesta() {
		listaIuCelda = new ArrayList<IUCelda>();
		x = 0;
		y = 0;
		listaIuCelda.add(new IUCelda());
		listaIuCelda.get(0).x = 0;
		listaIuCelda.get(0).y = 0;
	}
	public IUVariableCompuesta(Variable pV) {
		//this();
		listaIuCelda = new ArrayList<IUCelda>(pV.getLongitud());
		nombre = pV.getNombre();
		nombre += ":" + pV.getTipo();
		x = (float) pV.getX();
		y = (float) pV.getY();
		listaIuCelda.add(new IUCelda(x, y + IUCelda.DEFAULT_ALTO / 2 + SEPARACION));
		listaIuCelda.get(0).setContenido(pV.getValor());
		int longitud = pV.getLongitud();
		int i;
		for (i=1; i<=longitud - 1; i++) {
			listaIuCelda.add(new IUCelda((float) listaIuCelda.get(i-1).x + IUCelda.DEFAULT_ANCHO, (float) listaIuCelda.get(i-1).y ));
			listaIuCelda.get(i).setContenido(pV.getValor(i));
		}



	}

	public void dibujar(Graphics2D pen) {
		// El indice de inicio del array depende del interprete en cuestion
		Integer i = ConfiguracionMain.INTERPRETE_INDICE_INICIO_ARRAY;
		pen.setColor(ColorManager.COLOR_NOMBRE_VARIABLE);
		pen.setFont(new Font("Arial", Font.PLAIN, 18));
		//pen.drawString(nombre, x, y); // Mejor no ponemos nombre porque vamos a usar referencias
	    Iterator<IUCelda> ite = listaIuCelda.iterator();

	    while(ite.hasNext()) {
	    	IUCelda elemento = ite.next();
	    	pen.setFont(new Font("Arial", Font.PLAIN, 14));
	    	pen.drawString(i.toString(), (float) elemento.getX() + IUCelda.DEFAULT_ANCHO / 2 - IUCelda.DEFAULT_ANCHO_BORDE, (float) elemento.getY() - SEPARACION);
	    	elemento.dibujar(pen);
	    	i++;
	    }

//	    if (puntoRef != null) { // Si hay objeto referenciado
//	    	dibujarLineaRef(pen);
//	    }

	}
	public void dibujasLineaReferencia(Graphics2D pen) {

		//// No se ha implementado referencias desde compuestas

	}




	public Point2D.Float getPrimeraCeldaPoint2D() {
		return new Point2D.Float((float) listaIuCelda.get(0).x, (float) listaIuCelda.get(0).y);
	}



}
