package ikuspro.interprete.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.antlr.runtime.*;
import org.antlr.runtime.tree.CommonTree;


public class TablaSimbolos {
	private static final Logger LOGGER = Logger.getLogger(Interprete.class.getName());
	
	
	private Map<String, Funcion> listaFunciones = new TreeMap<String, Funcion>(); 
	private List<TreeMap<String, Variable>> listaAmbitos;
	private List<List<TreeMap<String,Variable>>> listaEjecuciones ; 
	private int maxNumVar = 0;
	private int maxNumEtiq = 0;
	private Map<String, Variable> listaGlobales = new TreeMap<String, Variable>();
	
	public TablaSimbolos() {
		LOGGER.setLevel(Level.WARNING);
		listaAmbitos = null;
		listaEjecuciones = new ArrayList<List<TreeMap<String,Variable>>>();
		
		
	}
	
	public void reinicializar() {
		
		listaAmbitos = null;
		listaEjecuciones = new ArrayList<List<TreeMap<String,Variable>>>();
		
	}
	
	private void incMaxNumVar() {
		maxNumVar++;
	}
	
	private void incMaxNumEtiq() {
		maxNumEtiq++;
	}
	
	
	
	public int siguienteEtiqueta() {
		incMaxNumVar();
		return getMaxNumVar();
	}
	
	public int siguienteVariable() {
		incMaxNumEtiq();
		return getMaxNumEtiq();
	}
	
	public void declararFuncion(String pNombre, String pTipoRetorno, List<ParametroFuncion> pListaParametros, 
								CommonTree pArbol, Integer pIndiceFlujo) {
		LOGGER.info("Declarar funcion" + pNombre + " " + pTipoRetorno);
		
		listaFunciones.put(pNombre, new Funcion(pNombre, pTipoRetorno, pListaParametros, pArbol, pIndiceFlujo));
		
	}
	
	public void iniciarEjecucion() {
		listaAmbitos = new ArrayList<TreeMap<String,Variable>>();
		listaAmbitos.add(new TreeMap<String, Variable>());
		listaEjecuciones.add(listaAmbitos);
	}
	
	
	public Funcion buscarFuncion(String pNombre) {
		Funcion funcion = listaFunciones.get(pNombre);
		
		return funcion;
	}
	
	public void iniciarEjecucion(String pNombre) {
		LOGGER.info("iniciarEjecucion " + pNombre);
		iniciarEjecucion();
		Funcion funcion = buscarFuncion(pNombre);
		iniciarEjecucion();
		Iterator<ParametroFuncion> iterador = funcion.getListaParametros().iterator();
		while(iterador.hasNext()) {
			ParametroFuncion paramFuncion = iterador.next();
			declararVariable(paramFuncion.getNombre(),paramFuncion.getTipo());
		}
	}
	

	public void iniciarEjecucion(Funcion pFuncion, List<ParametroFuncion> pListaParam, Interprete pInterprete) {
		iniciarEjecucion();
	
		
		//Deberian coincidir en número y orden
		Iterator<ParametroFuncion> iteradorParamFormalesFuncion = pFuncion.getListaParametros().iterator();
		Iterator<ParametroFuncion> iteradorParamActualesFuncion = pListaParam.iterator();
		while(iteradorParamFormalesFuncion.hasNext()) {
			ParametroFuncion paramFormalFuncion = iteradorParamFormalesFuncion.next();
			ParametroFuncion paramActualFuncion = iteradorParamActualesFuncion.next();
			
			
			declararVariable(paramFormalFuncion.getNombre(),paramFormalFuncion.getTipo());
			
			setValor(paramFormalFuncion.getNombre(),paramActualFuncion.getValor());
			getVariable(paramFormalFuncion.getNombre()).setReferencia(paramFormalFuncion.isReferencia());
			paramActualFuncion.setReferencia(paramFormalFuncion.isReferencia());
			
			if (pInterprete != null) {
				if (paramFormalFuncion.isReferencia()) {
					pInterprete.enviar("<variable><nombre>" + paramFormalFuncion.getNombre() + "</nombre><nombreRef>" + ((Variable) paramActualFuncion.getValor().get()).getNombre() + "</nombreRef><tipo>" + paramFormalFuncion.getTipo() + "</tipo></variable>");
				} else {
					
					pInterprete.enviar("<variable><nombre>" + paramFormalFuncion.getNombre() + "</nombre><tipo>" + paramFormalFuncion.getTipo() + "</tipo><valor>" + paramActualFuncion.getValor() + "</valor></variable>");
				}
			}
		}
	}
	
	public void iniciarEjecucion(Funcion pFuncion) {
		LOGGER.info("Iniciando ejecucion");
		iniciarEjecucion(pFuncion, new ArrayList<ParametroFuncion>(),null);
	}
	
	public void finalizarEjecucion() {
		listaEjecuciones.remove(listaEjecuciones.size() - 1);
		if (listaEjecuciones.size() > 0) {
			listaAmbitos = listaEjecuciones.get(listaEjecuciones.size() - 1);
		}
	}
	
	private Map<String,Variable> getVariables() {
		Map<String,Variable> variables = new TreeMap<String, Variable>();
		if(listaAmbitos == null) {
			//System.out.println("ES UNA VARIABLE GLOBAL");
			variables = listaGlobales;
		} else {
			variables = listaAmbitos.get(listaAmbitos.size() - 1);
		}
		return variables;
	}
	
	public void declararVariable(String pNombre, String pTipo) {
		Map<String,Variable> variables = getVariables();
		Variable variable = variables.get(pNombre);
		//TODO Quiza habria que comprobar si variable es null
		if (variable == null) {
			variables.put(pNombre, new Variable(pNombre, pTipo, siguienteVariable()));
			LOGGER.info("PUT: " + pNombre + " " + pTipo);
		}	
	}
	
	public void declararVariable(String pNombre, String pTipo, int pLongitud) {
		Map<String,Variable> variables = getVariables();
		Variable variable = variables.get(pNombre);
		//TODO Quiza habria que comprobar si variable es null
		if (variable == null) {
			variables.put(pNombre, new Variable(pNombre, pTipo, siguienteVariable(), pLongitud));
			LOGGER.info("PUT: " + pNombre + " " + pTipo);
		}	
	}
	
	// Constructor general valido para referencias tambien
	public void declararVariable(String pNombre, String pTipo, boolean esReferencia) {
		if (esReferencia) {
			Map<String,Variable> variables = getVariables();
			Variable variable = variables.get(pNombre);
			//TODO Quiza habria que comprobar si variable es null
			if (variable == null) {
				variables.put(pNombre, new Variable(pNombre, pTipo, true));
				LOGGER.info("PUT: " + pNombre + " " + pTipo);
			}	
		} else {
			declararVariable(pNombre, pTipo);
		}
	
	}
	
	public void entrar()  {
		listaAmbitos.add(new TreeMap<String, Variable>());
	}
	
	public void salir() {
		listaAmbitos.remove(listaAmbitos.size() - 1);
	}
	
	public <T> void setValor(String pNombre, Valor<T> pValor) {
		Variable variable = getVariable(pNombre);
		if (variable != null) {
			variable.setValor(pValor);
		}
	}
	
	public <T> void setValor(String pNombre, Valor<T> pValor, int pIndice) {
		Variable variable = getVariable(pNombre);
		if (variable != null) {
			variable.setValor(pValor,pIndice);
		}
	}
	
	public Valor getValor(String pNombre) {
		Variable variable = getVariable(pNombre);
		LOGGER.info("VARIABLE ES NULL? " + (variable == null));
		return variable.getValor();
	}
	
	public String getTipo(String pNombre) {
		Variable variable = getVariable(pNombre);
		return variable.getTipo();
	}
	
	public Variable getVariable(String pNombre) {
		Variable variable = null;
		LOGGER.info("listaAmbitos es NULL?" + (listaAmbitos == null));
		if(listaAmbitos != null) {
			Iterator<TreeMap<String,Variable>> iterador = listaAmbitos.iterator();
			boolean encontrado = false;
			while(iterador.hasNext() && !encontrado) {
				TreeMap<String, Variable> variables = iterador.next();
				variable = variables.get(pNombre);
				if (variable != null) {
					encontrado = true;
				}
			}
			
		}
		//Ahora buscamos en globales
		Variable variableGlobal = listaGlobales.get(pNombre);
		if (variableGlobal != null) {
			LOGGER.info(pNombre + "es una variable global con valor actual " + variableGlobal.getIValor());
			variable = variableGlobal;
		}
		if (variable == null) {
			//System.out.println("ERROR: Variable " + pNombre + " no declarada.");
		}
		return variable;
	}
	
	
	//Accesos

	public int getMaxNumVar() {
		return maxNumVar;
	}

	public void setMaxNumVar(int maxNumVar) {
		this.maxNumVar = maxNumVar;
	}

	public int getMaxNumEtiq() {
		return maxNumEtiq;
	}

	public void setMaxNumEtiq(int maxNumEtiq) {
		this.maxNumEtiq = maxNumEtiq;
	}
	
	public Funcion getFuncion(String pNombre) {
		Funcion funcion = listaFunciones.get(pNombre);
		// TODO COmprobar null
		return funcion;
	}
}
