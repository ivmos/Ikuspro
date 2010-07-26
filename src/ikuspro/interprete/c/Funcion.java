package ikuspro.interprete.c;

import java.util.List;

import org.antlr.runtime.tree.CommonTree;



public final class Funcion {
	private List<ParametroFuncion> listaParametros;
	private CommonTree arbol;
	private String nombre;
	private String tipoRetorno;
	private Integer indiceFlujo;
	
	public Funcion(String pNombre, String pTipoRetorno, List<ParametroFuncion> pListaParametros, CommonTree pArbol, Integer pIndiceFlujo) {
		//System.out.println("La funcion " + pNombre + "es de tipo " + pTipoRetorno);
		setNombre(pNombre);
		setTipoRetorno(pTipoRetorno);
		setListaParametros(pListaParametros);
		setArbol(pArbol);
		setIndiceFlujo(pIndiceFlujo);
	}

	public List<ParametroFuncion> getListaParametros() {
		return listaParametros;
	}

	public void setListaParametros(List<ParametroFuncion> pListaParametros) {
		listaParametros = pListaParametros;
	}

	public CommonTree getArbol() {
		return arbol;
	}

	public void setArbol(CommonTree pArbol) {
		arbol = pArbol;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String pNombre) {
		nombre = pNombre;
	}

	public String getTipoRetorno() {
		return tipoRetorno;
	}

	public void setTipoRetorno(String pTipoRetorno) {
		tipoRetorno = pTipoRetorno;
	}

	public Integer getIndiceFlujo() {
		return indiceFlujo;
	}

	public void setIndiceFlujo(Integer pIndiceFlujo) {
		indiceFlujo = pIndiceFlujo;
	}
}
