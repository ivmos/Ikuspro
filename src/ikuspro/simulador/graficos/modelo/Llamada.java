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

import java.util.ResourceBundle;
import nu.xom.Element;

public class Llamada extends Elemento {

	public static final double MARGEN_SUP_BLOQUE = 40.0;
	public static final double MARGEN_IZDA_BLOQUE = 50.0;
    private static final ResourceBundle mensajes = ResourceBundle.getBundle("ikuspro/gui/Mensajes");
	private String nombre = "";
	private Bloque bloque;

	private Llamada(String pNombre) {
		nombre = pNombre;
	}

	public Llamada(Element pElemento) {
		this( pElemento.getFirstChildElement("nombre").getValue() );
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String pNombre) {
		nombre = pNombre;
	}



	public Bloque getBloque() {
		return bloque;
	}

	public void setBloque(Bloque pBloque) {
		bloque = pBloque;
		bloque.setX(this.getX() + MARGEN_IZDA_BLOQUE);
		bloque.setY(this.getY() + MARGEN_SUP_BLOQUE);
	}

	@Override
	public String getComentario() {
		String s;
		// FIX: esto es un workaround para el euskara. La solución debería ser hacer como
		// en Variable->getComentario() (uso de expresiones %s)
		// Por falta de tiempo se recurre a este workaround
		if (!ConfiguracionGUI.getInstance().getLocale().getLanguage().equals("eu")) {
			s = mensajes.getString("Nueva_llamada_a_la_funcion_") + " " + getNombre();
		} else {
			// En euskara delante
			s = getNombre() +  mensajes.getString("Nueva_llamada_a_la_funcion_").replace("X", "");
		}
		return s;
	}

}
