package ikuspro.modelo;

import ikuspro.main.ConfiguracionMain;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ResourceBundle;
import java.util.logging.Logger;

/**
 * 
 * @author Iván Mosquera Paulo
 *
 * Encapsula un File y proporciona operaciones útiles relacionadas con el mismo.
 */
public class EFile{
	
	private static final Logger LOGGER = Logger
			.getLogger(EFile.class.getName());
	private File fichero = null;
	private String contenido = "";
	private String encoding;
	private String nombre = "";
	
	/**
	 * 
	 * @param pFichero
	 * 
	 * Contruye un EFile a partir de un File
	 */
	public EFile(File pFichero) {
		LOGGER.setLevel(ConfiguracionMain.LOGGER_LEVEL);
		fichero = pFichero;
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 
	 * @param pInputStream
	 * @param pNombre
	 * 
	 * Útil cuando se cargan desde Class.forName
	 */
	public EFile(InputStream pInputStream, String pNombre) {
		LOGGER.info("En constructor compuesto");
		BufferedInputStream b = new BufferedInputStream(pInputStream);

		
		BufferedReader reader = null;
		try {
			// Se asume que es UTF-8
			reader = new BufferedReader(new InputStreamReader(pInputStream,"UTF-8"));
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		StringBuilder sb = new StringBuilder();
		
		String line = null;
		try {
			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				pInputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	
		
		contenido = sb.toString();
		nombre = pNombre;
		
		actualizarEncoding(getContenido());
		
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 4933780112363521533L;
    private static final ResourceBundle mensajes = ResourceBundle.getBundle("ikuspro/gui/Mensajes");
	
	/**
	 * 
	 * @return la extension del fichero actual.
	 * 
	 */
	public String getExtension() {
        String extension = null;
        String cadena = "";
        if (fichero != null) {
        	cadena = fichero.getName();
        } else {
        	cadena = nombre;
        }
        int i = cadena.lastIndexOf('.');

        if (i > 0 &&  i < cadena.length() - 1) {
            extension = cadena.substring(i+1).toLowerCase();
        }
        LOGGER.info(extension);
        return extension;
    }
	
	
	/**
	 * 
	 * @return el fichero encapsulado
	 */
	public File getFile() {
		return fichero;
	}


	/**
	 * Lee el fichero del disco
	 */
	public void leer() {
		
		LOGGER.info("Me voy a leer");
		try {
			//FileReader fr = new FileReader(fichero);
			FileInputStream fr = null;
			actualizarEncoding();
			//if (encoding.equalsIgnoreCase("UTF-8")) {
				fr = new FileInputStream(fichero);
				
			InputStreamReader isr = null;
			if (encoding.equalsIgnoreCase("UTF-8")) {
				try {
					isr = new InputStreamReader(fr,"UTF-8");
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			} else {
				try {
					isr = new InputStreamReader(fr,"ISO-8859-1");
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			BufferedReader br = new BufferedReader(isr);

			String linea;
			 try { // La cosa parece que va bien
				contenido = "";
				while((linea=br.readLine())!=null)
				        contenido += linea + "\n";
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			
			try {
				fichero.createNewFile();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				
			}	
		}
		nombre = fichero.getName();
		
	}

	/**
	 * detecta la codificación del fichero
	 */
	private void actualizarEncoding() {
		LOGGER.info("");
		DetectorEncoding d = new DetectorEncoding();
		d.detectar(fichero);
		if (d.isUTF8()) {
			encoding = "UTF-8";
		} else {
			encoding = "ISO-8859-1";
		}
		
	}
	
	private void actualizarEncoding(String pContenido) {
		
		DetectorEncoding d = new DetectorEncoding();
		d.detectar(pContenido);
		if (d.isUTF8()) {
			encoding = "UTF-8";
		} else {
			encoding = "ISO-8859-1";
		}
	}


	/**
	 * 
	 * @param pContenido
	 * 
	 * Escribe el contenido al disco
	 */
	public void escribir(String pContenido) {
		try {
			FileWriter fwFichero = new FileWriter(fichero);
			BufferedWriter bw = new BufferedWriter(fwFichero);
			PrintWriter pw = new java.io.PrintWriter(bw);

			pw.print(pContenido);
			pw.close();
			contenido = pContenido;
		}  catch(java.io.IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void escribir() {
		escribir(contenido);
	}


	public String getContenido() {
		LOGGER.info(contenido);
		return contenido;
	}
	
	public void setContenido(String pString) {
		contenido = pString;
	}



	/**
	 * @return the encoding
	 */
	public String getEncoding() {
		
		return encoding;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	

}
