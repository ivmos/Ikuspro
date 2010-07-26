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



package ikuspro.controlador;

import java.io.File;
import java.io.InputStream;

public interface IControlador {




	void abrirFichero();

	void guardarFichero();

	void iniciarSimulacion();

	void guardarFicheroComo();

	void guardarFichero(String contenido);

	void abrirFichero(File pFile);

	void guardarFichero(File pFile, String contenido);

	void salir();

	void deshacerEditor();

	void seleccionarTodoEditor();

	void buscarReemplazarEditor();



	void rehacerEditor();



	void avanzarSimulacion();



	void terminarSimulacion();

	void abrirFichero(InputStream pInputStream, String pNombre);

	void cancelarSimulacion();

	void cambiarIdioma(String pSeleccionarIdioma);




}
