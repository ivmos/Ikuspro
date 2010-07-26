package ikuspro.simulador;

import java.util.ResourceBundle;


/**
 * 
 * @author Iván Mosquera Paulo
 *
 * Estructura de datos que sirve como mensaje entre el interprete y el simulador
 */
public class Mensaje {
    private static final ResourceBundle mensajes = ResourceBundle.getBundle("ikuspro/gui/Mensajes");
	private final String sXML;

	public Mensaje(String pSxml) {
		sXML = pSxml;
	}

	public String getSXML() {
		return sXML;
	}

}