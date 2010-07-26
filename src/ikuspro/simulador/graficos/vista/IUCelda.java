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



package ikuspro.simulador.graficos.vista;

import ikuspro.simulador.graficos.ColorManager;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;
import java.awt.geom.Rectangle2D;
import java.util.ResourceBundle;

public class IUCelda extends Rectangle2D.Double {

	public static final float DEFAULT_ANCHO_BORDE = 3.0f;
	private static final long serialVersionUID = -1832112302373159868L;
	public static final float DEFAULT_ANCHO = 80.0f;
	public static final float DEFAULT_ALTO = 30.0f;
    private static final ResourceBundle mensajes = ResourceBundle.getBundle("ikuspro/gui/Mensajes");

	private Color color;
	private String contenido = "?";

	public IUCelda() {
		super(0.0f, 0.0f, 80.0f, 30.0f);
		color = Color.BLACK;

	}

	public IUCelda(float pX, float pY) {
		super(pX,pY, 80.0f, 30.0f);
		color = ColorManager.COLOR_CELDA;
	}

	public Color getColor() {
		return color;
	}

	 public void dibujar(Graphics2D pen) {
	      pen.setPaint(this.getColor());
	      pen.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
	                           RenderingHints.VALUE_ANTIALIAS_ON);
	      pen.setStroke(new BasicStroke(DEFAULT_ANCHO_BORDE));
	      pen.draw(this);

	      FontRenderContext frc = pen.getFontRenderContext();
	      Dimension tamanyo = new Dimension(80,30);
	      TextLayout tl;
	      Font f;

	      f = new Font("Arial", Font.PLAIN, 20);
	      String contenidoMostrado = contenido;
	      // Si contiene un punto y mide 3 o más lo mismo es un float y hay que redondear ya
	      // que el interprete suele mandar muchos decimales
	      if (contenidoMostrado.contains(".") && contenidoMostrado.length() >= 3 ) {
	    	  java.lang.Double doubleContenido = java.lang.Double.parseDouble(contenidoMostrado);
	    	  doubleContenido = redondear(doubleContenido, 2); // A dos decimales
	    	  contenidoMostrado = doubleContenido.toString();
	      }
	      tl = new TextLayout(contenidoMostrado, f, frc);

	     // pen.setColor(Color.pink);

	      tl.draw(pen, (float) this.x + (float)(tamanyo.width - tl.getBounds().getWidth())/2,


	    		  (float) this.y + 22.0f);
	      //pen.setColor(Color.RED);
	      //pen.drawArc((int)x, (int)y, (int)elipse.getDiametro(), (int)elipse.getDiametro(), 0, 360);

	 }

	 private double redondear(double nD, int nDec)
	 {
	   return Math.round(nD*Math.pow(10,nDec))/Math.pow(10,nDec);
	 }


	public void setContenido(String pContenido) {
		contenido = pContenido;
	}
}
