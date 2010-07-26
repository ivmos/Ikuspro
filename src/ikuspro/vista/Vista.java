package ikuspro.vista;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ResourceBundle;
import javax.swing.JFrame;

import ikuspro.modelo.EFileModelo;
import ikuspro.modelo.EFileModeloObserver;
import ikuspro.modelo.InterpreteModelo;
import ikuspro.modelo.InterpreteModeloObserver;

import ikuspro.modelo.Modelo;
import ikuspro.controlador.*;




import ikuspro.gui.IUBarraHerramientas;
import ikuspro.gui.IUEditor;
import ikuspro.gui.IUVentanaPrincipal;



// Usaremos este AppView como clase b�sica, para separar aquí el código relacionado
// con el diseño MVC. El resto lo implementamos en una clase heredada.

public abstract class Vista {
    private static final ResourceBundle mensajes = ResourceBundle.getBundle("ikuspro/gui/Mensajes");
	private EFileModelo efileModelo;
	private Controlador controlador;
	private InterpreteModelo interpreteModelo;
	
	// Aquí irían los componentes, en esta clase no lo haremos, se hereda.
	
	public Vista() {
		
	}
	public Vista(Controlador pAppController, EFileModelo modelo2) {
		this.controlador = pAppController;
		this.efileModelo = modelo2;
		
	}
	
	public Vista(Controlador pAppController, EFileModelo pEfileModelo, InterpreteModelo pInterpreteModelo) {
		this.controlador = pAppController;
		this.efileModelo = pEfileModelo;
		this.interpreteModelo = pInterpreteModelo;
		
	}
	
	
	//Se supone que la vista tiene que delegar las acciones al controlador....
	
		

	
	public EFileModelo getEfileModelo() {
		return efileModelo;
	}
	
	public InterpreteModelo getInterpreteModelo() {
		return interpreteModelo;
	}
	
	public IControlador getControlador() {
		return controlador;
	}
	
	
	
	public abstract void abrirFichero();
	
	public abstract String getContenidoEditor();
	public abstract IUEditor getEditor();
	public abstract void guardarFicheroComo(String pContenido);
	public abstract void deshacerEditor();
	public abstract void seleccionarTodoEditor();
	public abstract void buscarReemplazarEditor();
	
	
	public abstract void rehacerEditor();
	public abstract IUVentanaPrincipal getVentana();
	
	public abstract void mostrarAcercaDe() ;
	public abstract void copiarEditor();
	public abstract void addListener(ActionListener pListener);
	


}
