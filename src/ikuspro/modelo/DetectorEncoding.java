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




package ikuspro.modelo;




import java.io.* ;
import java.util.ResourceBundle;
import java.util.logging.Logger;

import org.mozilla.intl.chardet.* ;

/**
 *
 * @author Iván Mosquera Paulo
 *
 *
 * Detecta aproximadamente el codificado de un texto.
 */
public class DetectorEncoding {
	private static final Logger LOGGER = Logger
	.getLogger(DetectorEncoding.class.getName());
    private static final ResourceBundle mensajes = ResourceBundle.getBundle("ikuspro/gui/Mensajes");
	private boolean encontrado = false ;
	private boolean utf8 = false;

	public DetectorEncoding() {
		//
	}

	/**
	 *
	 * @param pInput
	 * @return
	 *
	 * Detecta heurísticamente si un fichero es utf-8
	 */
	public String detectar(InputStream pInput) {

		utf8 = false;
		int lang = nsPSMDetector.ALL;
		nsDetector detector = new nsDetector(lang) ;



		detector.Init(new nsICharsetDetectionObserver() {
			public void Notify(String charset) {
			    encontrado = true ;
			    //System.out.println("CHARSET = " + charset);
			}
	    });


		BufferedInputStream imp = new BufferedInputStream(pInput);


		byte[] buf = new byte[1024] ;
		int len;
		boolean done = false ;
		boolean ascii = true ;

		try {
			while( (len=imp.read(buf,0,buf.length)) != -1) {

				// Check if the stream is only ascii.
				if (ascii)
				    ascii = detector.isAscii(buf,len);

				// DoIt if non-ascii and not done yet.
				if (!ascii && !done)
				    done = detector.DoIt(buf,len, false);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		detector.DataEnd();

		if (ascii) {
		   encontrado = true ;
		}

		if (!encontrado) {
		   String prob[] = detector.getProbableCharsets() ;
		   for(int i=0; i<prob.length; i++) {
			   if (prob[i].equalsIgnoreCase("UTF-8")) {
				   utf8 = true;
			   }
			//System.out.println("Posible charset = " + prob[i]);
		   }

		}

		if (utf8) {
			return "UTF-8";
		} else { // Esto es una suposición pero suele ser válida
			return "ISO-8859-1";
		}
    }



	/**
	 *
	 * @param pCadena
	 * @return
	 *
	 * Detecta si una cadena es utf-8
	 *
	 */
    public String detectar(String pCadena) {
		return detectar(new ByteArrayInputStream(pCadena.getBytes()));
    }


    /**
     *
     * @param pFile
     *
     * Detecta si un fichero es utf-8
     *
     */
    public void detectar(File pFile) {
    	try {
			detectar(new FileInputStream(pFile.getAbsoluteFile()));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }


	/**
	 * @return the uTF8
	 */
	public boolean isUTF8() {
		return utf8;
	}
}
