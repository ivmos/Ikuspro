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

import ikuspro.simulador.graficos.modelo.Variable;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;
import java.util.ResourceBundle;

public abstract class IUVariable {

	private static final float DEFAULT_REFERENCIA_ALPHA = 0.7f;
	/**
	 *
	 */
	protected String nombre;
	protected float x;
	protected float y;
	protected static final float SEPARACION = 3.0f;
    private static final ResourceBundle mensajes = ResourceBundle.getBundle("ikuspro/gui/Mensajes");
	protected Variable variableModelo;

	public IUVariable() {
		super();
	}

	public abstract void dibujar(Graphics2D pen);

	protected void dibujarFlechaRecta( Graphics2D g, Point2D.Float pA, Point2D.Float pB )
	{
		int x = (int)pA.x;
		int y = (int)pA.y;
		int xx = (int)pB.x;
		int yy = (int)pB.y;
	    float anchoFlecha = 10.0f ;
	    float theta = 0.423f ;
	    int[] puntosX = new int[3] ;
	    int[] puntosY = new int[3] ;
	    float[] vecLine = new float[2] ;
	    float[] vecLeft = new float[2] ;
	    float longitud;
	    float th;
	    float ta;
	    float baseX, baseY ;

	    puntosX[0] = xx ;
	    puntosY[0] = yy ;

	    // Construir vector
	    vecLine[0] = (float)puntosX[ 0 ] - x ;
	    vecLine[1] = (float)puntosY[ 0 ] - y ;

	    // Construir la base
	    vecLeft[0] = -vecLine[ 1 ] ;
	    vecLeft[1] = vecLine[ 0 ] ;

	    // Configurar longitudes
	    longitud = (float)Math.sqrt( vecLine[0] * vecLine[0] + vecLine[1] * vecLine[1] ) ;
	    th = anchoFlecha / ( 2.0f * longitud ) ;
	    ta = anchoFlecha / ( 2.0f * ( (float)Math.tan( theta ) / 2.0f ) * longitud ) ;

	    // Encontrar la base de la flecha
	    baseX = ( (float)puntosX[ 0 ] - ta * vecLine[0]);
	    baseY = ( (float)puntosY[ 0 ] - ta * vecLine[1]);

	    // Contruir los puntos a los lados de la flecha
	    puntosX[ 1 ] = (int)( baseX + th * vecLeft[0] );
	    puntosY[ 1 ] = (int)( baseY + th * vecLeft[1] );
	    puntosX[ 2 ] = (int)( baseX - th * vecLeft[0] );
	    puntosY[ 2 ] = (int)( baseY - th * vecLeft[1] );
	    g.setColor(Color.GREEN.darker());
	    g.drawLine( x, y, (int)baseX, (int)baseY ) ;
	    g.fillPolygon( puntosX, puntosY, 3 ) ;
	 }


	 private AlphaComposite makeComposite(float alpha) {
		    int type = AlphaComposite.SRC_OVER;
		    return(AlphaComposite.getInstance(type, alpha));
	 }


	protected void dibujarFlechaCurva( Graphics2D g, Point2D.Float pA, Point2D.Float pB ) {

		g.setColor(variableModelo.getObjetoReferenciadoPrincipal().getColorReferencia());
		GeneralPath path = new GeneralPath();
        float p1x = pA.x, p1y = pA.y;   // P1
        float p2x = pB.x, p2y = pB.y;  // P2


        // Arriba a abajo
        float cx = pA.x - 180;
        float cy = pA.y + (pB.y - pA.y)/2;
        float arrSize = 10;          // Tamaño de los segmentos de la flecha

        float adjSize = (float)(arrSize/Math.sqrt(2));
        float ex = p2x - cx;
        float ey = p2y - cy;
        float abs_e = (float)Math.sqrt(ex*ex + ey*ey);
        ex /= abs_e;
        ey /= abs_e;

        path.moveTo(p1x, p1y);
        path.quadTo(cx, cy, p2x, p2y);
        path.lineTo(p2x + (ey-ex)*adjSize, p2y - (ex + ey)*adjSize);
        path.moveTo(p2x, p2y);
        path.lineTo(p2x - (ey + ex)*adjSize, p2y + (ex - ey)*adjSize);
        g.setComposite(makeComposite(DEFAULT_REFERENCIA_ALPHA));

        g.draw(path);
	}

}
