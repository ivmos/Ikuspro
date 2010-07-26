package ikuspro.interprete.c;

import org.jaxen.VariableContext;

public class Valor <T> {
	private T contenido;

	public Valor() {
		
	}
	
	public Valor(T p) {
		
		contenido = p; 
	}
	
	

	public T get() {
		return contenido;
	}

	public void set(T pContenido) {
		contenido = pContenido;
	}
	
	
	public String toString() {
		String resultado;
		// Hay que tratar los "\0" para que no falle el parser XML 
		if ((contenido instanceof Character) && (((Character) contenido).equals('\0')) ) {
			resultado = "END";
		} else if (contenido instanceof Variable) {
			resultado = ((Variable) contenido).getArrValor().toString();
		} else {
			resultado = get().toString();
			
		}
		return resultado;
	}
}
