package ikuspro.interprete;

import ikuspro.modelo.EFile;
import ikuspro.modelo.InterpreteModelo;

/**
 * 
 * @author Iván Mosquera Paulo
 * 
 * Esta interfaz define lo que Ikuspro necesita que 
 */
public interface IInterprete extends Runnable{
	
	
	// Cada interprete debe definir esta información
	int INDICE_INICIO_ARRAY = 0; // Ej: en ada es 1, en C es 0.
	String EXTENSIONES = ""; // Ej: "c cpp" o "ada"
	String NOMBRE = null; // Ej: universidad_departamento_asinatura_lenguaje euiti-bi_LSI_P1_ADA
	String VERSION = null; // Ej: 0.1.0.0
	// // // //

	public abstract void ejecutar(EFile pFile) throws Exception;

	public abstract void setFichero(EFile pFile);
	

	
}