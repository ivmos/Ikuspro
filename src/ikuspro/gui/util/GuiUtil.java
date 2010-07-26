package ikuspro.gui.util;

import ikuspro.main.ConfiguracionMain;

import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.jvnet.substance.skin.SubstanceOfficeSilver2007LookAndFeel;

public class GuiUtil {
	private static final Logger LOGGER = Logger.getLogger(GuiUtil.class
			.getName());
    private static final ResourceBundle mensajes = ResourceBundle.getBundle("ikuspro/gui/Mensajes");
	public static void setNativeLookAndFeel() {
		
		if (ConfiguracionMain.LOGGER_LEVEL.equals(Level.INFO)) {
			try {
				UIManager.setLookAndFeel(new SubstanceOfficeSilver2007LookAndFeel());
			} catch (UnsupportedLookAndFeelException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
		    try {
		        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); 
		    } catch(Exception e) {
		      LOGGER.info("Error setting native LAF: " + e);
		    }
		}
	    
	}
	

	public static void setJavaLookAndFeel() {
	    try {
	      UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
	    } catch(Exception e) {
	      LOGGER.info("Error setting Java LAF: " + e);
	    }
	}

	   
	public static void setMotifLookAndFeel() {
	    try {
	      UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
	    } catch(Exception e) {
	      LOGGER.info("Error setting Motif LAF: " + e);
	    }
	}

}
