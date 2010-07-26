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

public class IUGuardarComoFichero extends IUAdminFichero {

	private static final Logger LOGGER = Logger
			.getLogger(IUGuardarComoFichero.class.getName());
    private static final ResourceBundle mensajes = ResourceBundle.getBundle("ikuspro/gui/Mensajes");
	String contenido;

	public IUGuardarComoFichero(Vista pVista, String pContenido) {
		super(pVista);
		contenido = pContenido;
		configurar();
	}

	private void configurar() {
		// Sólo ficheros
        getJFileChooser().setFileSelectionMode(JFileChooser.FILES_ONLY);
        getJFileChooser().setSelectedFile(new File("Nuevo.c"));

        //pack();
        int returnVal = getJFileChooser().showSaveDialog(null);
        if(returnVal == JFileChooser.APPROVE_OPTION) {

                getVista().getControlador().guardarFichero(getJFileChooser().getSelectedFile(), contenido);
        }


	}
}
