package ikuspro.gui.util;

import java.awt.Component;
import java.awt.print.PageFormat;
import java.awt.print.PrinterJob;
import java.util.List;
import java.util.ResourceBundle;

import javax.swing.JComponent;

public final class Impresora
 {
	
	PageFormat formatoPagina;
	private int numPaginasPrevistas;
	private static Impresora instance;
    private static final ResourceBundle mensajes = ResourceBundle.getBundle("ikuspro/gui/Mensajes");

	public synchronized static Impresora getInstance() {
		if (instance == null) {
			instance = new Impresora();
		}
		return instance;
	}
	private Impresora() {

	}
	
	



	
	
		
		
	
	public boolean disableDoubleBuffering(Component c) {
		if (c instanceof JComponent == false) return false;
			JComponent jc = (JComponent)c;
			boolean wasBuffered = jc.isDoubleBuffered();
			jc.setDoubleBuffered(false);
			return wasBuffered;
	}
	
	public void restoreDoubleBuffering(Component c, boolean wasBuffered) {
		if (c instanceof JComponent)
			((JComponent)c).setDoubleBuffered(wasBuffered);
	}
	/**
	 * @return the formatoPagina
	 */
	public PageFormat getFormatoPagina() {
		if (formatoPagina == null) {
			PrinterJob pj = PrinterJob.getPrinterJob();
			formatoPagina = pj.defaultPage();
		}
		return formatoPagina;
	}
	/**
	 * @param pFormatoPagina the formatoPagina to set
	 */
	public void setFormatoPagina(PageFormat pFormatoPagina) {
		formatoPagina = pFormatoPagina;
	}
	/**
	 * @return the numPaginasPrevistas
	 */
	public int getNumPaginasPrevistas() {
		return numPaginasPrevistas;
	}
}