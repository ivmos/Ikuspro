package ikuspro.modelo;



import ikuspro.gui.ConfiguracionGUI;
import ikuspro.main.ConfiguracionMain;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ResourceBundle;
import java.util.logging.Logger;




public class EFileModelo extends Modelo <EFileModeloObserver> {
	
	private static final Logger LOGGER = Logger.getLogger(EFileModelo.class
			.getName());
    private static final ResourceBundle mensajes = ResourceBundle.getBundle("ikuspro/gui/Mensajes");
	private EFile file;
	
	

	public EFileModelo() {
		LOGGER.setLevel(ConfiguracionMain.LOGGER_LEVEL);
		LOGGER.info("");
		file = new EFile(new File(ConfiguracionMain.FICHERO_DEFAULT));
	}
	
	public EFileModelo(String pNombre) {
		LOGGER.setLevel(ConfiguracionMain.LOGGER_LEVEL);
		LOGGER.info("");
		file = new EFile(new File(pNombre));	
	}

	public void reiniciar(String pNombre) {
		LOGGER.info("");
		file = new EFile(new File(pNombre));
		notificarModeloObservers();
	}

	public EFile getEfile() {
		LOGGER.info("");
		return file;
	}

	public void setFile(File pFile) {
		LOGGER.info("");
		file = new EFile(pFile);
		System.out.println("Vamos a leer");
		file.leer();
		System.out.println("Vamos a notificar");
		notificarModeloObservers();	
	}


	public String getStrFile() {
		LOGGER.info("");
		return file.getContenido();
		
	}
	
	public String getFileName() {
		String resultado = file.getNombre();
		if (resultado.equals("") || resultado == null) {
			resultado = "Sin título ";
		}
		return resultado;
	}
	
	public boolean existe() {
		LOGGER.info("");
		if (file.getFile() == null) {
			return false;
		} else {
			return file.getFile().exists();
		}
	}
	
	public String getAbsolutFileName() {
		LOGGER.info("");
		String salida = "";
		try {
			if (file.getFile() != null) {
			 salida = file.getFile().getCanonicalPath();
			} else {
				salida = ConfiguracionMain.FICHERO_DEFAULT;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return salida;
	}
	
	public String getExtFile() {
		LOGGER.info("");
		String resultado = "";
		if (file != null) {
			resultado = file.getExtension();
		}
		return resultado;
	}


	public void setFile(String pContenido) {
		LOGGER.info("");
		file.escribir(pContenido);
		
	}

	public void setFile(InputStream pInputStream, String pNombre) {
		LOGGER.info("");
		file = new EFile(pInputStream, pNombre);
		
		notificarModeloObservers();
		LOGGER.info("notificados");	
	}
	

}
