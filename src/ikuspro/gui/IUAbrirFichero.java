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

import java.io.File;
import java.util.ResourceBundle;
import java.util.logging.Logger;

import javax.swing.JFileChooser;

import ikuspro.vista.Vista;

public class IUAbrirFichero extends IUAdminFichero {

	private static final Logger LOGGER = Logger.getLogger(IUAbrirFichero.class
			.getName());
    private static final ResourceBundle mensajes = ResourceBundle.getBundle("ikuspro/gui/Mensajes");

	public IUAbrirFichero(Vista pVista) {
		super(pVista);

		configurar();
	}

	private void configurar() {

		// Si es posible se elige la ultima ruta utilizada
		if (ConfiguracionGUI.getInstance().getUltimoFicheroAbierto() != null) {
			getJFileChooser().setSelectedFile(ConfiguracionGUI.getInstance().getUltimoFicheroAbierto());
		}
		// Solo ficheros
        getJFileChooser().setFileSelectionMode(JFileChooser.FILES_ONLY);

        //pack();
        final int returnVal = getJFileChooser().showOpenDialog(null);
        if(returnVal == JFileChooser.APPROVE_OPTION) {
        		File ficheroElegido = getJFileChooser().getSelectedFile();
        		ConfiguracionGUI.getInstance().setUltimoFicheroAbierto(ficheroElegido);
        		getVista().getControlador().abrirFichero(ficheroElegido);
        }


	}
}
