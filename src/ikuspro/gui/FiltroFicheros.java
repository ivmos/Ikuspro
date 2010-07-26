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
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Logger;

import javax.swing.filechooser.FileFilter;





public class FiltroFicheros extends FileFilter{

	   private static final Logger LOGGER = Logger.getLogger(FiltroFicheros.class
			.getName());
    private static final ResourceBundle mensajes = ResourceBundle.getBundle("ikuspro/gui/Mensajes");

	   // descripcion y extension aceptada por el filtro
	   private String descripcion;


	   private List<String> listaExtensiones;
	   // contructor a partir de la descripvi�n y la extensi�n aceptada
	   public FiltroFicheros(String descripcion, String extension){
	      if(descripcion == null || extension ==null){
	         //
	      }
	      this.descripcion = descripcion;

	   }



	   public FiltroFicheros(List<String> pListaExtensiones) {
		   listaExtensiones = pListaExtensiones;
	   }

	   // Implementacion del FileFilter
	   public boolean accept(File file){
		   boolean resultado = false;
		   if(file.isDirectory()) {
			   return true;
		   }


		   String nombreFichero = file.getName().toLowerCase();
		   Iterator<String> ite = listaExtensiones.iterator();
		   while(ite.hasNext()) {
			   if (nombreFichero.endsWith(ite.next())) {
				   resultado = true;
				   break;
			   }
		   }
		   return resultado;

	   }


		@Override
		public String getDescription() {
			String resultado = descripcion;
			if (resultado == null || resultado.equals("")) {
				resultado = mensajes.getString("Fichero_") + " " + listaExtensiones.get(0).toUpperCase();
			}
			return resultado;
		}
}
