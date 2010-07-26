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

import java.util.ResourceBundle;
import java.util.logging.Logger;

import javax.swing.JLabel;
import javax.swing.border.BevelBorder;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.text.BadLocationException;

import org.jdesktop.swingx.JXStatusBar;

public class IUbarraEstado extends JXStatusBar implements CaretListener{
	private static final Logger LOGGER = Logger.getLogger(IUbarraEstado.class.getName());
    private static final ResourceBundle mensajes = ResourceBundle.getBundle("ikuspro/gui/Mensajes");
	private javax.swing.JLabel jLabelEstado;

	private IUVentanaPrincipal principal;

    public IUbarraEstado(IUVentanaPrincipal pVentana){
    	 setLayout(new java.awt.BorderLayout());

    	 principal = pVentana;
    	 jLabelEstado = new JLabel();
         add(jLabelEstado, java.awt.BorderLayout.SOUTH);

         setBorder(new BevelBorder(BevelBorder.LOWERED));
    }

	@Override
	public void caretUpdate(CaretEvent pEvent) {

			try {
				jLabelEstado.setText(String.valueOf(principal.getEditor().getLineOfOffset(pEvent.getDot()) + 1));

			} catch (BadLocationException e) {

				e.printStackTrace();
			}



	}

}
