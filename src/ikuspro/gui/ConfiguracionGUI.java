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



package ikuspro.gui;

import ikuspro.main.Ikuspro;

import java.awt.Image;
import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.prefs.Preferences;

import javax.swing.ImageIcon;

/**
 *
 * @author Ivan Mosquera Paulo
 *
 *
 */
public final class ConfiguracionGUI {

	public static final String RUTA_ICONOS_16 = "/iconos/16";
	public static final String RUTA_ICONOS_22 = "/iconos/22";
	public static final String RUTA_ICONOS_12 = "/iconos/12";
	public static final String RUTA_ICONOS_32 = "/iconos/32";
	public static final boolean PERMITIDO_CONFIGURAR_IDIOMA = true;
	public static final String FILE_MANUAL_AYUDA = "manual_ikuspro.pdf";
	public static final String FILE_EXPORTAR = "ikuspro.jpg";
	private static ConfiguracionGUI instance;
    private static final ResourceBundle mensajes = ResourceBundle.getBundle("ikuspro/gui/Mensajes");

	private File ultimoFicheroAbierto = null;
	private Locale locale;

	private ConfiguracionGUI() {
		super();
		ultimoFicheroAbierto = null;
		locale = Locale.getDefault();
		cargar();
	}

	public static synchronized ConfiguracionGUI getInstance() {
		if (instance == null) { instance = new ConfiguracionGUI(); }
		return instance;
	}

	private void cargar() {
		Preferences prefs = Preferences.userNodeForPackage(Ikuspro.class);
		String ultimoFicheroAbiertoStr = prefs.get("ultimoFicheroAbierto", null);
		if (ultimoFicheroAbiertoStr != null) {
			ultimoFicheroAbierto = new File(ultimoFicheroAbiertoStr);
		}
		String localeStr = prefs.get("LOCALE", null);
		if (localeStr != null) {
			String[] localeStrArr = localeStr.split("_");
			if (!localeStr.equals("DEFAULT")) {
				locale = new Locale(localeStrArr[0],localeStrArr[1].toUpperCase());
			} else {
				locale = Locale.getDefault();
			}
		} else {
			locale = Locale.getDefault();
		}

	}

	public void guardar() {
		Preferences prefs = Preferences.userNodeForPackage(Ikuspro.class);
		if (ultimoFicheroAbierto != null) {
			prefs.put("ultimoFicheroAbierto", ultimoFicheroAbierto.getAbsolutePath());
		}

		if (locale != null) {
			prefs.put("LOCALE",locale.toString());
		} else {
			prefs.put("LOCALE", "DEFAULT");
		}

	}

	/**
	 * @return the ultimoFicheroAbierto
	 */
	public File getUltimoFicheroAbierto() {
		return ultimoFicheroAbierto;
	}

	/**
	 * @param pUltimoFicheroAbierto the ultimoFicheroAbierto to set
	 */
	public void setUltimoFicheroAbierto(File pUltimoFicheroAbierto) {
		ultimoFicheroAbierto = pUltimoFicheroAbierto;
	}

	/**
	 * @param pLocale the locale to set
	 */
	public void setLocale(Locale pLocale) {

		locale = pLocale;

	}

	/**
	 * @return the locale
	 */
	public Locale getLocale() {
		return locale;
	}

	/**
	 * @return
	 */
	public Image getIconoIkuspro() {
		return (new ImageIcon(getClass().getResource("/ikusproLogo.png"))).getImage();
	}

}
