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



/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * IUAbrir.java
 *
 * Created on 11-abr-2009, 9:59:17
 */

package ikuspro.gui;

import ikuspro.vista.Vista;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Logger;

import javax.swing.JFrame;

/**
 *
 * @author Iván Mosquera Paulo
 */
public class IUAdminFichero {


	private static final Logger LOGGER = Logger.getLogger(IUAdminFichero.class.getName());
    private static final ResourceBundle mensajes = ResourceBundle.getBundle("ikuspro/gui/Mensajes");
    protected javax.swing.JFileChooser jFileChooser;
    private List<FiltroFicheros> listaFiltroFicheros = new ArrayList<FiltroFicheros>();
	private Vista vista;
	private JFrame padre;



    /** Creates new form IUAbrir */
    public IUAdminFichero() {

    }

    public IUAdminFichero(List<FiltroFicheros> pLista) {
    	this();
    	listaFiltroFicheros = pLista;
    	initComponents();
    }

    public IUAdminFichero(Vista pVista) {
		this();
		vista = pVista;

		List<List<String>> listaExtensiones = vista.getInterpreteModelo().getExtensionesFicheroDisponibles();
		Iterator<List<String>> ite = listaExtensiones.iterator();
		while(ite.hasNext()) {
			List<String> extension = ite.next();
			listaFiltroFicheros.add(new FiltroFicheros(extension));
		}
		initComponents();
	}

	public IUAdminFichero(Vista pVista, JFrame parent) {
		this(pVista);
		padre = parent;

	}

	public void iniciar() {
		initComponents();
	}


    @SuppressWarnings("unchecked")

    private void initComponents() {

        jFileChooser = new javax.swing.JFileChooser();


        Iterator<FiltroFicheros> iteradorFiltro = listaFiltroFicheros.iterator();
        while(iteradorFiltro.hasNext()) {
        	jFileChooser.addChoosableFileFilter(iteradorFiltro.next());
        }

    }



	/**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new IUAbrir().setVisible(true);
            }
        });
    }

	public javax.swing.JFileChooser getJFileChooser() {
		return jFileChooser;
	}

	public Vista getVista() {
		return vista;
	}



}
