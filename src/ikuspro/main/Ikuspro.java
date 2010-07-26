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



import java.awt.SplashScreen;
import java.io.File;
import java.security.Policy;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileSystemView;

import sun.applet.AppletPanel;

import ikuspro.controlador.Controlador;
import ikuspro.controlador.IControlador;
import ikuspro.gui.ConfiguracionGUI;

import ikuspro.modelo.EFileModelo;
import ikuspro.modelo.InterpreteModelo;


/**
 *
 * @author Iván Mosquera Paulo
 *
 *
 * Clase principal de Ikuspro, aquí empieza todo :-)
 * Ojo! todo codificado en UTF-8 como tiene que ser.
 */
public class Ikuspro {
	private static final Logger LOGGER = Logger.getLogger(Ikuspro.class
			.getName());

	private static final String DEFAULT_FILENAME = "Bienvenido.c";
	private static final long MLLS_ESPERA_SPLASH = 3000;

	// Inicio como aplicacion escritorio.
	public static void main(String args[]) {
		//System.setSecurityManager(null); // Util para JWS
		//com.sun.security.auth.PolicyFile.setPolicy(null);
		Policy.setPolicy(null);
		if (ConfiguracionGUI.getInstance().getLocale() != null) {
			Locale.setDefault(ConfiguracionGUI.getInstance().getLocale());
		}
		LOGGER.setLevel(Level.WARNING);
		// Ajustes para integración con MacOSX
		System.setProperty("apple.laf.useScreenMenuBar", "false"); // Ojo, existe bug en MacOSX sobre esto.
																  // Por eso mejor lo dejamos en false por ahora
		System.setProperty("com.apple.mrj.application.apple.menu.about.name",
					ConfiguracionMain.NOMBRE_PROY);

		//
		controlarSplashScreen();


		final EFileModelo efileModelo = new EFileModelo();
		final InterpreteModelo interpreteModelo = new InterpreteModelo();
		IControlador controlador = new Controlador(efileModelo,interpreteModelo);


	}

	private static void controlarSplashScreen() {

			try { // ... un poco para asegurarnos de que se ve el splashscreen
				Thread.currentThread().sleep(MLLS_ESPERA_SPLASH);

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}

}

