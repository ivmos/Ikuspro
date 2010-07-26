/**
 * Ikuspro 1.0
 *
 * Copyright 2010,
 * Ivan Mosquera Paulo (ivanmosp@gmail.com)
 * Mikel Villamañe Girones (mikel.villamane@ehu.es)
 *
 * Licensed under the GNU General Public License (*)
 *
 * (*) Complete information is provided at license.txt
 *
 **/




package ikuspro.main;

import java.util.logging.Level;


public final class ConfiguracionMain {
	public static final String NOMBRE_PROY = "Ikuspro";
	public static final String VERSION = "1.0";
	// Con Level.INFO se usará el estilo Substance, capaz de encontrar ciertos
	// problemas de concurrencia, además, se mostrarán mensajes de debug.
	// Con Level.WARNING se usará el estilo del sistema operativo y no habrá
	// mensajes de debug o casi. Es lo ideal para producción
	public static final Level LOGGER_LEVEL = Level.WARNING;
	public static final String FICHERO_DEFAULT = "Bienvenido.c";

	// Las dos siguientes dependerán del interprete que se este usando
	// por lo que se establecera al cargarlo
	public static int INTERPRETE_INDICE_INICIO_ARRAY;
	public static String INTERPRETE_NOMBRE;
	public static String INTERPRETE_VERSION;
	public static String INTERPRETE_EXTENSIONES;


	public static enum Idioma {
		ESPAÑOL,
		EUSKARA,
		DEFAULT, ENGLISH;
	}
}
