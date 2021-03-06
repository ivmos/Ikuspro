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



/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * IUConfigurarImpresion.java
 *
 * Created on 14-ago-2009, 18:32:12
 */

package ikuspro.gui;

import java.awt.Dimension;
import java.awt.Toolkit;

import ikuspro.controlador.Controlador;
import java.util.ResourceBundle;

/**
 *
 * @author ktulur
 */
public class IUConfigurarImpresion extends javax.swing.JDialog {
    private static final ResourceBundle mensajes = ResourceBundle.getBundle("ikuspro/gui/Mensajes");



	 private javax.swing.JButton botonAceptar;
	 private javax.swing.JButton botonCancelar;
	 private javax.swing.JButton botonConfig;
	 private javax.swing.JCheckBox cComentarios;
	 private javax.swing.JCheckBox cEditor;
	 private javax.swing.JCheckBox cEstandar;
	 private javax.swing.JCheckBox cSimulacion;
	 private javax.swing.JLabel label;
	 private javax.swing.JPanel panelInferior;
	 private javax.swing.JPanel panelSuperior;
	private Controlador controlador;

    /** Creates new form IUConfigurarImpresion */
    public IUConfigurarImpresion(java.awt.Frame parent, boolean modal, Controlador pControlador) {
        super(parent, modal);
        controlador = pControlador;
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    private void initComponents() {

    	setTitle(mensajes.getString("Configurar_Impresión"));
        panelInferior = new javax.swing.JPanel();
        botonConfig = new javax.swing.JButton();
        botonAceptar = new javax.swing.JButton();
        botonCancelar = new javax.swing.JButton();
        panelSuperior = new javax.swing.JPanel();
        label = new javax.swing.JLabel();
        cSimulacion = new javax.swing.JCheckBox();
        cEditor = new javax.swing.JCheckBox();
        cEstandar = new javax.swing.JCheckBox();
        cComentarios = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        botonConfig.setText(mensajes.getString("Configurar_página..."));
        botonConfig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                controlador.configurarPagina();
            }
        });
        panelInferior.add(botonConfig);

        botonAceptar.setText(mensajes.getString("Aceptar"));
        botonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	cComentarios.setSelected(false);
            	cEditor.setSelected(false);
            	cEstandar.setSelected(false);
            	cSimulacion.setSelected(false);
            	IUConfigurarImpresion.this.dispose();
            }
        });
        panelInferior.add(botonAceptar);

        botonCancelar.setText(mensajes.getString("Cancelar"));
        botonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IUConfigurarImpresion.this.dispose();
            }
        });
        panelInferior.add(botonCancelar);

        getContentPane().add(panelInferior, java.awt.BorderLayout.CENTER);

        panelSuperior.setLayout(new javax.swing.BoxLayout(panelSuperior, javax.swing.BoxLayout.Y_AXIS));

        label.setText(mensajes.getString("Seleccione_los_elementos_que_desea_imprimir:"));
        panelSuperior.add(label);

        cSimulacion.setText(mensajes.getString("Simulación."));
        cSimulacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cSimulacionActionPerformed(evt);
            }
        });
        panelSuperior.add(cSimulacion);

        cEditor.setText(mensajes.getString("Contenido_del_editor."));
        panelSuperior.add(cEditor);

        cEstandar.setText(mensajes.getString("Salida_estándar."));
        panelSuperior.add(cEstandar);

        cComentarios.setText(mensajes.getString("Comentarios."));
        panelSuperior.add(cComentarios);

        getContentPane().add(panelSuperior, java.awt.BorderLayout.PAGE_START);

        this.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
                IUConfigurarImpresion.this.dispose();
            }
        });
        centrar();
        pack();
    }

    private void cSimulacionActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
}

    private void botonAceptarActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
}

    private void botonConfigActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
}

    private void botonCancelarActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
    }



	/**
	 * @return the cComentarios
	 */
	public javax.swing.JCheckBox getCComentarios() {
		return cComentarios;
	}

	/**
	 * @return the cEditor
	 */
	public javax.swing.JCheckBox getCEditor() {
		return cEditor;
	}

	/**
	 * @return the cEstandar
	 */
	public javax.swing.JCheckBox getCEstandar() {
		return cEstandar;
	}

	/**
	 * @return the cSimulacion
	 */
	public javax.swing.JCheckBox getCSimulacion() {
		return cSimulacion;
	}

	 private final void centrar() {
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			Dimension frameSize = getSize();
			int x = (screenSize.width - frameSize.width) / 2;
			int y = (screenSize.height - frameSize.height) / 2;
			setLocation(x, y);
		}


}
