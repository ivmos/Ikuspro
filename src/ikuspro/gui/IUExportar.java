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

public class IUExportar extends IUAdminFichero {

	private static final Logger LOGGER = Logger
			.getLogger(IUExportar.class.getName());
	private File resultado;

	private static final String DEFAULT_FILENAME = "ikuspro.jpg";
    private static final ResourceBundle mensajes = ResourceBundle.getBundle("ikuspro/gui/Mensajes");

	public IUExportar() {

		initComponents();
		jFileChooser.setDialogTitle(mensajes.getString("Exportar"));

		configurar();
	}

	private void initComponents() {

        jFileChooser = new javax.swing.JFileChooser();

    }

	private void configurar() {
		// S�lo ficheros
        getJFileChooser().setFileSelectionMode(JFileChooser.FILES_ONLY);
        getJFileChooser().setSelectedFile(new File(DEFAULT_FILENAME));

        //pack();
        int returnVal = getJFileChooser().showSaveDialog(null);
        if(returnVal == JFileChooser.APPROVE_OPTION) {
                resultado = getJFileChooser().getSelectedFile();
        }

	}

	public File getResultado() {
		return resultado;
	}
}
