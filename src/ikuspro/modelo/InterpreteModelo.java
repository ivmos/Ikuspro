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




import ikuspro.interprete.IInterprete;
import ikuspro.main.ConfiguracionMain;
import ikuspro.simulador.IUSimulador;
import ikuspro.simulador.Simulador;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import nu.xom.Builder;
import nu.xom.Document;
import nu.xom.Element;
import nu.xom.Elements;
import nu.xom.ParsingException;
import nu.xom.ValidityException;




public class InterpreteModelo extends Modelo <InterpreteModeloObserver> {

	private static final String IKUSPRO_INTERPRETE_CONFIG_INTERPRETES_XML = "/ikuspro/interprete/configInterpretes.xml";
	private static final String NODO_XML_EXTENSIONES = "extensiones";
	private static final String PACKAGE_SEPARADOR = ".";
	private static final String NOMBRE_CLASE_INTERPRETE = "Interprete";
	private static final String RUTA_PACKAGE_INTERPRETE = "ikuspro.interprete.";
	private static final Logger LOGGER = Logger.getLogger(InterpreteModelo.class
			.getName());

	private IInterprete interprete;
    private static final ResourceBundle mensajes = ResourceBundle.getBundle("ikuspro/gui/Mensajes");
	private Simulador simulador;
	private boolean nuevaSalidaDisponible = true;
	private String salida = "";
	private boolean nuevoComentarioDisponible = true;
	private String comentario = "";
	private List<LogString> listaComentarios;
	private List<LogString> listaSalida;
	private int linea;
	private int lineaAnterior;
	private ExecutorService exec;
	private List<Element> listaInterpreteDisponibles;
	private boolean ejecutando = false;
	private List<List<String>> listaExtensionesFicheroDisponibles;


	/**
	 *
	 * @author Iván Mosquera Paulo
	 *
	 * Estructura de datos utilizada para ir guardando los comentarios y la salida estandar
	 */
	public class LogString {
		private String texto;
		private Integer linea;
		public LogString() {
			texto = "";
			linea = 0;
		}

		public LogString(int pLinea, String pTexto) {
			linea = pLinea;
			texto = pTexto;
		}

		/**
		 * @return the texto
		 */
		public String getTexto() {
			return texto;
		}

		/**
		 * @return the linea
		 */
		public Integer getLinea() {
			return linea;
		}

	}



	public InterpreteModelo() {
		cargarInterpretes();
	}



	/**
	 * Lee el xml de interpretes y anota los activos
	 */
	private void cargarInterpretes() {
		URL url = getClass().getResource(IKUSPRO_INTERPRETE_CONFIG_INTERPRETES_XML);
		listaInterpreteDisponibles = new ArrayList<Element>();
		Document doc = null;

		try {
			InputStreamReader ins = new InputStreamReader(url.openStream());
			BufferedReader bufferedReader = new BufferedReader(ins);
			doc = new Builder().build(bufferedReader);
		} catch (ValidityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParsingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Element elemento = doc.getRootElement();

		for (int i=0;i<= elemento.getChildElements().size() - 1; i++) {
			Element interprete = elemento.getChildElements().get(i);
			if (interprete.getFirstChildElement("activado").getValue().equals("TRUE")) {
				System.out.println("El interprete de la posicion " + i + " esta activado");
				listaInterpreteDisponibles.add(interprete);
			}
		}
	}



	public void ejecutar(EFile pFile) {

		salida = "";
		comentario = "";
		listaComentarios = new ArrayList<LogString>();
		listaSalida = new ArrayList<LogString>();
		nuevaSalidaDisponible = true;
		nuevoComentarioDisponible = true;
		linea = 0;
		lineaAnterior = 0;
		notificarModeloObservers();
		setEjecutando(true);

		try {
			if (simulador != null) { // Desenchufamos el anterior hilo simulador
				simulador.desconectar();
			}
			if (exec!= null) { //Limpiamos los anteriores hilos
				exec.shutdownNow();
			}
			exec = Executors.newFixedThreadPool(2);
			simulador = new Simulador(this,IUSimulador.getInstance());

			Class<IInterprete> claseInterprete = obtenerInterpreteCuyaExtension(pFile.getExtension());
			// Usamos reflection
			ConfiguracionMain.INTERPRETE_INDICE_INICIO_ARRAY = interprete.INDICE_INICIO_ARRAY;
			ConfiguracionMain.INTERPRETE_EXTENSIONES = interprete.EXTENSIONES;
			ConfiguracionMain.INTERPRETE_NOMBRE = interprete.NOMBRE;
			ConfiguracionMain.INTERPRETE_VERSION = interprete.VERSION;
			interprete = obtenerInstanciaInterprete(claseInterprete);
			interprete.setFichero(pFile);
			simulador.setIniciado(true);
			exec.execute(interprete);
			exec.execute(simulador);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		notificarModeloObservers();


	}



	/**
	 * @param claseInterprete
	 * @throws NoSuchMethodException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	private IInterprete obtenerInstanciaInterprete(Class<IInterprete> claseInterprete)
			throws NoSuchMethodException, InstantiationException,
			IllegalAccessException, InvocationTargetException {
		Constructor<IInterprete> constructorInterprete = claseInterprete.getConstructor(Simulador.class);
		return constructorInterprete.newInstance(simulador);
	}



	private Class<IInterprete> obtenerInterpreteCuyaExtension(String pExtension) {

		Class<IInterprete> claseInterprete = null;
		try {
			claseInterprete = (Class<IInterprete>) Class.forName(RUTA_PACKAGE_INTERPRETE +
							obtenerRutaInterpreteCuyaExtension(pExtension) + PACKAGE_SEPARADOR + NOMBRE_CLASE_INTERPRETE);
		} catch (ClassNotFoundException e) {
			final String mensaje;
			if (pExtension == null) {
				mensaje = mensajes.getString("Necesita_guardar_el_fichero_con_una_extension_");
			} else {
				mensaje=mensajes.getString("No_hay_interprete_disponible_para_la_extension") + " " + pExtension;
			}
			SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					JOptionPane.showMessageDialog(null,
							mensaje, "Error", JOptionPane.ERROR_MESSAGE );

				}
			});
			e.printStackTrace();
		}

		return claseInterprete;
	}

	private String obtenerRutaInterpreteCuyaExtension(String pExtension) {
		String resultado = null;
		Iterator<Element> ite = listaInterpreteDisponibles.iterator();
		while(ite.hasNext()) {
			Element interprete = ite.next();
			Element extensiones = interprete.getFirstChildElement(NODO_XML_EXTENSIONES);
			Elements listaExtensiones = extensiones.getChildElements();
			boolean encontrado = false;
			for (int i=0; i<=listaExtensiones.size() - 1; i++) {
				if (listaExtensiones.get(i).getValue().equals(pExtension)) {
					encontrado = true;
					break;
				}
			}
			if (encontrado) {
				resultado = interprete.getFirstChildElement("carpeta").getValue();
				break;
			}
		}
		return resultado;
	}

	/**
	 *
	 * @return las extensiones soportadas por los interpretes activados (disponibles)
	 */
	public List<List<String>> getExtensionesFicheroDisponibles() {
		if (listaExtensionesFicheroDisponibles == null) {
			List<List<String>> resultado = new ArrayList<List<String>>();
			Iterator<Element> ite = listaInterpreteDisponibles.iterator();
			while(ite.hasNext()) {
				Element interprete = ite.next();
				Element extensiones = interprete.getFirstChildElement(NODO_XML_EXTENSIONES);
				Elements listaExtensiones = extensiones.getChildElements();
				resultado.add(new ArrayList<String>());
				for (int i=0; i<=listaExtensiones.size() - 1; i++) {
					resultado.get(resultado.size() - 1).add(listaExtensiones.get(i).getValue());
				}
			}
			listaExtensionesFicheroDisponibles = resultado;
		}
		return listaExtensionesFicheroDisponibles;
	}


	public String getSalida() {
		return salida;
	}

	public boolean isSimuladorIniciado() {
		return simulador.isIniciado();
	}

	/**
	 * Avanza la simulación
	 */
	public void siguiente() {
		synchronized (simulador) {
			simulador.notify();
		}
	}

	/**
	 * Avanza la simulacion automaticamente hasta el final.
	 */
	public void terminar() {
		simulador.setTerminar(true);
	}

	/**
	 * Cancela la simulacion.
	 */
	public void cancelar() {
		if (exec != null) {
			simulador.setIniciado(false);
			simulador.desconectar();

			exec.shutdownNow();
		}

		setEjecutando(false);
	}



	public void setLinea(final int pLinea) {
		if (linea != pLinea) {
			actualizarVista();
			lineaAnterior = linea;
			linea = pLinea;
		}


	}



	/**
	 *
	 */
	public void actualizarVista() {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {

				if ( (simulador == null) || (!simulador.isTerminar())) {

					IUSimulador.getInstance().actualizar();
					//IUSimulador.getInstance().repaint();
				}
					notificarModeloObservers();

			}
			});
	}

	public int getLinea() {
		return linea;
	}

	public void setSalida(String pSalida) {
		salida = pSalida;

	}

	public void addSalida(String pSalida) {
		listaSalida.add(new LogString(getLinea(), pSalida));
		setNuevaSalidaDisponible(true);
	}



	public void setEjecutando(boolean ejecutando) {
		this.ejecutando = ejecutando;

		if (exec != null && !ejecutando) {
			// Esto no es muy limpio pero es la forma más rápida de evitar que se queden hilos de simulador
			// colgados.
			// En realidad el problema es que al diseñar el mecanismo de concurrencia interprete-simulador
			// no pensé en la terminación, de modo que ahora tengo que andar con chapuzas.
			// Lo ideal es que tanto el hilo como el interprete terminen de forma natural ya sea
			// por haber leído un flag o porque han hecho todas sus tareas.

			exec.shutdownNow();
		}
		notificarModeloObservers();
	}



	public boolean isEjecutando() {
		return ejecutando;
	}



	public String getComentario() {
		return comentario;
	}



	public void setComentario(String pComentario) {
		comentario = pComentario;
	}

	public void addComentario(String pComentario) {
		// Si es distinto del último comentario (en número y texto)...
		// A veces el interprete manda el mismo comentarios dos veces y filtramos aquí que es más fácil
		// Por ejemplo "La llamada a funcion main a terminado" es típica.
		if (listaComentarios.size() > 0) {
			LogString ultimoComentario = listaComentarios.get(listaComentarios.size() - 1);
			//if ( ( ! ultimoComentario.getTexto().equals(pComentario))
			//		&& (ultimoComentario.getLinea() != getLinea()) )  {
				listaComentarios.add(new LogString(getLinea(),pComentario));
				setNuevoComentarioDisponible(true);
			//} else {
			//	System.out.println("El comentario está repetido");
			//}
		} else {
			listaComentarios.add(new LogString(getLinea(),pComentario));
			setNuevoComentarioDisponible(true);

		}


	}





	/**
	 * @return the nuevaSalidaDisponible
	 */
	public boolean isNuevaSalidaDisponible() {
		return nuevaSalidaDisponible;
	}



	/**
	 * @param pNuevaSalidaDisponible the nuevaSalidaDisponible to set
	 */
	public void setNuevaSalidaDisponible(boolean pNuevaSalidaDisponible) {
		nuevaSalidaDisponible = pNuevaSalidaDisponible;
	}



	public void setNuevoComentarioDisponible(boolean nuevoComentarioDisponible) {
		this.nuevoComentarioDisponible = nuevoComentarioDisponible;
	}



	public boolean isNuevoComentarioDisponible() {
		return nuevoComentarioDisponible;
	}



	/**
	 * @return the listaComentarios
	 */
	public List<LogString> getListaComentarios() {
		return listaComentarios;
	}



	/**
	 * @return the listaSalida
	 */
	public List<LogString> getListaSalida() {
		return listaSalida;
	}



	public int getLineaAnterior() {
		return lineaAnterior;
	}

	public boolean interpretandoSinParar() {
		boolean resultado = false;
		if (simulador != null) {
			resultado = simulador.isTerminar();
		}
		return resultado;
	}




}
