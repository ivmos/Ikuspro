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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JToolBar;

import org.fife.ui.rtextarea.SearchEngine;

public class IUBarraBuscar extends JToolBar{
    private static final ResourceBundle mensajes = ResourceBundle.getBundle("ikuspro/gui/Mensajes");
	public IUBarraBuscar barraBuscarReemplazar;

	public IUBarraBuscar(final IUVentanaPrincipal pVentanaPrincipal) {

		barraBuscarReemplazar = this;
		JLabel labelBuscar = new JLabel(mensajes.getString("Encontrar:"));
		barraBuscarReemplazar.add(labelBuscar);
		final JTextField campoBuscar = new JTextField(30);
		barraBuscarReemplazar.add(campoBuscar);
		JButton buscarSiguiente = new JButton(mensajes.getString("Siguiente"), new ImageIcon(getClass().getResource(ConfiguracionGUI.RUTA_ICONOS_16 + "/iconoIrAbajo16.png")));
		barraBuscarReemplazar.add(buscarSiguiente);

		final JCheckBox caseSens = new JCheckBox(mensajes.getString("Coincidencia_mayúsculas/minúsculas"));
		final IUEditor contenidoEditor = pVentanaPrincipal.getEditor();
	    buscarSiguiente.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent event) {
	    		 String text = campoBuscar.getText();
	             if (text.length() == 0) {
	                return;
	             }
	             boolean forward = true;
	             boolean matchCase = caseSens.isSelected();
	             boolean palabraCompleta = false;

	             boolean regex = false;
	             boolean encontrado = SearchEngine.find(contenidoEditor, text, forward,
	                   matchCase, palabraCompleta, regex);
	             if (!encontrado) {
	                JOptionPane.showMessageDialog(null, mensajes.getString("Texto_no_encontrado"));
	             }

	    	}
	    });
		JButton buscarAnterior = new JButton(mensajes.getString("Anterior"),new ImageIcon(getClass().getResource(ConfiguracionGUI.RUTA_ICONOS_16 + "/iconoIrArriba16.png")));
		barraBuscarReemplazar.add(buscarAnterior);
		buscarAnterior.addActionListener(new ActionListener() {


			public void actionPerformed(ActionEvent event) {
				String text = campoBuscar.getText();
	             if (text.length() == 0) {
	                return;
	             }
	             boolean forward = false;
	             boolean matchCase = caseSens.isSelected();
	             boolean palabraCompleta = false;

	             boolean regex = false;
	             boolean encontrado = SearchEngine.find(contenidoEditor, text, forward,
	                   matchCase, palabraCompleta, regex);
	             if (!encontrado) {
	                JOptionPane.showMessageDialog(null, mensajes.getString("Texto_no_encontrado"), mensajes.getString("Aviso"),JOptionPane.INFORMATION_MESSAGE);
	             }

			}

		});
		barraBuscarReemplazar.add(buscarAnterior);


	    barraBuscarReemplazar.add(caseSens);
	    JButton botonCerrar = new JButton(new ImageIcon(getClass().getResource(ConfiguracionGUI.RUTA_ICONOS_16 + "/iconoCerrar.png")));
	    botonCerrar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent event) {
        		pVentanaPrincipal.getBarraEstado().remove(barraBuscarReemplazar);
        		pVentanaPrincipal.pack();
        	}
        });
	    barraBuscarReemplazar.add(botonCerrar);

	}
}
