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

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import java.util.ResourceBundle;
import javax.swing.SwingUtilities;

/**
 *
 * @author Iván Mosquera Paulo
 *
 * @param <L>
 *
 * Modelo MVC genérico.
 */

public class Modelo <L extends ModeloObserver>
{
    private static final ResourceBundle mensajes = ResourceBundle.getBundle("ikuspro/gui/Mensajes");
  private final List <L> listaObservadores;

  public Modelo()
  {
    this.listaObservadores = new ArrayList <L>();
  }

  public void anyadirModeloObserver (final L observer)
  {
    if (! this.listaObservadores.contains (observer)) {
      this.listaObservadores.add (observer);
      notificarModeloObserver(observer);
    }
  }

  public void quitarModeloObserver (final L observer)
  {
    this.listaObservadores.remove (observer);
  }

  protected void notificarModeloObservers ()
  {
    for (final L observer : this.listaObservadores) {
      notificarModeloObserver (observer);
    }
  }

  protected synchronized void notificarModeloObserver (final L observer)
  {
	  final Modelo modelo = this;

	  SwingUtilities.invokeLater(new Runnable() {
		  public void run() { observer.actualizar(modelo); }
	  });



  }

  protected class Propiedad <T>
  {
    private T value;

    public Propiedad (final T pValorInicial)
    {
      this.value = pValorInicial;
    }

    public void setValor (final T valor)
    {
      this.value = valor;
      notificarModeloObservers();
    }

    public T getValor ()
    {
      return this.value;
    }
  }
}
