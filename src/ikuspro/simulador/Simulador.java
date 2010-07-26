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




package ikuspro.simulador;


import ikuspro.gui.ConfiguracionGUI;
import ikuspro.modelo.InterpreteModelo;
import ikuspro.simulador.graficos.modelo.Bloque;
import ikuspro.simulador.graficos.modelo.Llamada;
import ikuspro.simulador.graficos.modelo.Variable;

import java.io.IOException;
import java.util.ResourceBundle;
import java.util.concurrent.SynchronousQueue;

import nu.xom.Builder;
import nu.xom.Document;
import nu.xom.Element;
import nu.xom.ParsingException;
import nu.xom.ValidityException;


enum Tipo { ENTRADA, SALIDA, LINEA, INI_BLOQUE, FIN_BLOQUE,
			INI_LLAMADA, FIN_LLAMADA, VARIABLE, ASIGNACION,
			CONDICIONAL, LOOP
		   }

/**
 *
 * @author Iván Mosquera Paulo
 * Este es el modelo y quizá controlador de la simulación. Además, se ejecuta como un hilo independiente.
 * Es el encargado de comunicarse y entender lo que le manda el interprete en XML.
 */
public class Simulador implements Runnable {
    private static final ResourceBundle mensajes = ResourceBundle.getBundle("ikuspro/gui/Mensajes");

	private boolean iniciado;
	private boolean terminar;
	private boolean cambiolinea = false;
	private InterpreteModelo interpreteModelo;
	private IUSimulador simuladorVista;

	// Solo puede recibir mensajes de uno en uno
	private SynchronousQueue<Mensaje> bandejaMensaje =
		new SynchronousQueue<Mensaje>();

	public Simulador(InterpreteModelo pInterpreteModelo, IUSimulador pSimuladorVista) {
		iniciado = false;
		terminar = false;
		simuladorVista = pSimuladorVista;
		interpreteModelo = pInterpreteModelo;
		simuladorVista.iniciar();



	}


	@Override
	public synchronized void run() {
		Thread.currentThread().setName(Thread.currentThread().getName() + " simulador");

		while(iniciado) {

			try {

					Mensaje msg = bandejaMensaje.take();
					Document doc = null;

					try {
						//System.out.println("recibido : " + msg.getSXML());

						doc = new Builder().build(new java.io.StringBufferInputStream(msg.getSXML()));

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
					Tipo tipo = Enum.valueOf(Tipo.class, elemento.getLocalName().toUpperCase());

					switch(tipo) {

						case SALIDA:	tratarSalida(elemento);
										break;

						case ENTRADA:	tratarEntrada(elemento);
										break;

						case LINEA:		tratarLinea(elemento);
										break;
						case INI_BLOQUE:	tratarBloque(elemento,true);
											break;

						case FIN_BLOQUE:	tratarBloque(elemento, false);
											break;

						case INI_LLAMADA:	tratarLlamada(elemento,true);
											break;
						case FIN_LLAMADA:	tratarLlamada(elemento,false);
											break;
						case VARIABLE:	tratarVariable(elemento);
										break;
						case ASIGNACION:
										tratarAsignacion(elemento);
										break;
						case CONDICIONAL:
										tratarCondicional(elemento);
										break;
						case LOOP:
										tratarBucle(elemento);
										break;
					}




			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


		}
			tratarLinea(interpreteModelo.getLinea() + 1);
			simuladorVista.actualizar();


	}


	private void tratarCondicional(Element pElemento) {
		String rama = "";
		if (pElemento.getFirstChildElement("linea") != null) {
			tratarLinea(Integer.parseInt(pElemento.getFirstChildElement("linea").getValue()));
		}
		if (pElemento.getFirstChildElement("ramaElegida") != null) {
			rama = pElemento.getFirstChildElement("ramaElegida").getValue();
		}
		String comentario;
		comentario = mensajes.getString("Condicional:_") + " ";
		if (rama.equals("PRINCIPAL")) {
			comentario += mensajes.getString("como_la_condición_ha_sido_TRUE_se_seguirá_por_la_rama_PRINCIPAL.");
		} else if (rama.equals("ELSE")) {
			comentario += mensajes.getString("como_la_condición_ha_sido_FALSE_se_seguirá_por_la_rama_ELSE.");
		} else if (rama.equals("")) {
			comentario += mensajes.getString("como_la_condición_ha_sido_FALSE_no_se_entrará_en_su_ámbito.");
		}
		interpreteModelo.addComentario(comentario + System.getProperty("line.separator"));
	}


	private void tratarBucle(Element pElemento) {
		String sigue = "";
		if (pElemento.getFirstChildElement("linea") != null) {
			tratarLinea(Integer.parseInt(pElemento.getFirstChildElement("linea").getValue()));
		}
		if (pElemento.getFirstChildElement("sigue") != null) {
			sigue = pElemento.getFirstChildElement("sigue").getValue();
		}
		String comentario;
		comentario = mensajes.getString("Bucle:_") + " ";
		if (sigue.equals("TRUE")) {
			comentario += mensajes.getString("como_la_condición_ha_sido_TRUE_se_ejecutará_el_cuerpo_del_bucle.");
		} else  {
			comentario += mensajes.getString("como_la_condición_ha_sido_FALSE_se_saldrá_del_bucle.");
		}
		interpreteModelo.addComentario(comentario + System.getProperty("line.separator"));
	}

	private void tratarAsignacion(Element pElemento) {
		Variable v = null;
		tratarLinea(Integer.parseInt(pElemento.getFirstChildElement("linea").getValue()));
		Integer indice = null;

		if (pElemento.getFirstChildElement("indice") != null) {
			indice = Integer.parseInt(pElemento.getFirstChildElement("indice").getValue());
		}
		if (indice == null && pElemento.getFirstChildElement("valor") != null) {
			v = simuladorVista.asignar(pElemento.getFirstChildElement("nombre").getValue(),
					pElemento.getFirstChildElement("valor").getValue());
		} else if (pElemento.getFirstChildElement("valor") != null){
			v = simuladorVista.asignar(pElemento.getFirstChildElement("nombre").getValue(),
					pElemento.getFirstChildElement("valor").getValue(), indice);
		}

		if (pElemento.getFirstChildElement("nombreRef") != null) {
			v = simuladorVista.asignar(pElemento.getFirstChildElement("nombre").getValue(),
					pElemento.getFirstChildElement("nombreRef").getValue());
			v.setReferencia(true);
			Variable objetoReferenciado = simuladorVista.buscarVariableRef(
						pElemento.getFirstChildElement("nombreRef").getValue());
			v.setObjetoReferenciado(objetoReferenciado);
			v.setListaValores(objetoReferenciado.getListaValores());
			v.setLongitud(objetoReferenciado.getLongitud());

			v.setAncho(objetoReferenciado.getAncho());
		}


		if ((pElemento.getFirstChildElement("comentario") == null)
				||
			(pElemento.getFirstChildElement("comentario").getValue().equals("TRUE"))) {
			interpreteModelo.addComentario(v.getComentario() + System.getProperty("line.separator"));
		}

	}


	private void tratarVariable(Element pElemento) {
		Variable v = null;

		if (pElemento.getFirstChildElement("linea") != null) {
			tratarLinea(Integer.parseInt(pElemento.getFirstChildElement("linea").getValue()));
		}
		simuladorVista.addVariable(v = new Variable(pElemento));
		interpreteModelo.addComentario(v.getComentario() + System.getProperty("line.separator"));

	}




	private void tratarLlamada(Element pElemento, boolean pInicio) {
		if (pInicio) {
			Llamada l = null;
			tratarLinea(Integer.parseInt(pElemento.getFirstChildElement("linea").getValue()));
			simuladorVista.addLlamada(l = new Llamada(pElemento));
			interpreteModelo.addComentario(l.getComentario() + System.getProperty("line.separator"));
		} else {
				// FIX: esto es un workaround para el euskara. La solución debería ser hacer como
				// en Variable->getComentario() (uso de expresiones %s)
				// Por falta de tiempo se recurre a este workaround
				String comentario;
				if (!ConfiguracionGUI.getInstance().getLocale().getLanguage().equals("eu")) {
					comentario =  mensajes.getString("La_llamada_a_la_función_") + " " +
										simuladorVista.getListaLlamadas().get(
												simuladorVista.getListaLlamadas().size() - 1)
												.getNombre();
				} else {
					comentario =  simuladorVista.getListaLlamadas().get(
							simuladorVista.getListaLlamadas().size() - 1)
							.getNombre() + " " + mensajes.getString("La_llamada_a_la_función_").replace("X", "");

				}
			if (pElemento.getFirstChildElement(mensajes.getString("retorno")) != null) {
				if (!ConfiguracionGUI.getInstance().getLocale().getLanguage().equals("eu")) {
					comentario += " " + mensajes.getString("_ha_terminado_devolviendo_") + " "+ pElemento.getFirstChildElement("retorno").getValue()
								+ ".";
				} else {
					comentario += pElemento.getFirstChildElement("retorno").getValue().replace("X","") + " " + mensajes.getString("_ha_terminado_devolviendo_");

				}
			} else {
				comentario += " " + mensajes.getString("_ha_terminado.");
			}
			interpreteModelo.addComentario(comentario + System.getProperty("line.separator"));
			//System.out.println("añadido comentario");

			simuladorVista.delLlamada();

		}
	}


	private void tratarBloque(Element pElemento, boolean pInicio) {
		if (pInicio) {
			Bloque b = null;
			if (pElemento.getFirstChildElement("linea") != null) {
				tratarLinea(Integer.parseInt(pElemento.getFirstChildElement("linea").getValue()));
			}
			simuladorVista.addBloque(b = new Bloque(pElemento));
			// Para los bloques no comentamos lo dejamos como algo interno al igual
			// que no los dibujamos.
			//interpreteModelo.addComentario(b.getComentario() + System.getProperty("line.separator"));
		} else {

			if (pElemento.getFirstChildElement("linea") != null) {
				tratarLinea(Integer.parseInt(pElemento.getFirstChildElement("linea").getValue()));
			} else {
				// ESto es un workaround necesario ya que tal y como hice el interprete no puedo
				// saber la linea en que termina un bloque. Estaria bien corregir esto e incluir un token
				// de fin de bloque de modo que podamos evitar esto

				tratarLinea(interpreteModelo.getLinea() + 1);


			}
			simuladorVista.delBloque();

		}

	}


	private void tratarSalida(Element pElemento) {
		if ( pElemento.getFirstChildElement("linea") != null) {
			tratarLinea(Integer.parseInt(pElemento.getFirstChildElement("linea").getValue()));
		}

		interpreteModelo.addSalida(
				pElemento.getFirstChildElement("texto").getValue().replace("\\n",System.getProperty("line.separator"))
				);

	}

	private void tratarEntrada(Element pElemento) {
		if ( pElemento.getFirstChildElement("linea") != null) {
			tratarLinea(Integer.parseInt(pElemento.getFirstChildElement("linea").getValue()));
		}

	}

	private void tratarLinea(Element pElemento) {
		Integer linea = Integer.parseInt(pElemento.getFirstChildElement("num").getValue());


		tratarLinea(linea);

	}

	private void tratarLinea(Integer pLinea) {
		if ( !pLinea.equals(interpreteModelo.getLinea())){
			cambiolinea = true;
			interpreteModelo.setLinea(pLinea);
			pausar();
		}
	}


	/**
	 *
	 */
	private void pausar() {

		if (!isTerminar() && cambiolinea ) {
			cambiolinea = false;
			try {
				this.wait(); // Esto hace que se pare la simulación, se saldrá de este estado
							// bloqueado en siguiente()
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}


	public void entregar(Mensaje pMensaje) throws InterruptedException {
		bandejaMensaje.put(pMensaje);
	}

	public void setIniciado(boolean iniciado) {
		this.iniciado = iniciado;

		if (interpreteModelo != null) {
			interpreteModelo.setEjecutando(iniciado);
		}


	}

	public boolean isIniciado() {
		return iniciado;
	}


	public InterpreteModelo getInterpreteModelo() {
		return interpreteModelo;
	}


	public void setTerminar(boolean pB) {
		terminar = pB;
		// Lo siguiente es un workaround
		// Sin esto a veces Terminar no dibuja.

		simuladorVista.actualizar();
		//simuladorVista.repaint();


	}


	public boolean isTerminar() {
		return terminar;
	}


	public void desconectar() {
		simuladorVista = null;
		interpreteModelo = null;
	}


}
