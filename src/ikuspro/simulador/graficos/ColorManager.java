package ikuspro.simulador.graficos;
import java.awt.Color;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Set;

/**
 * 
 * @author Iván Mosquera Paulo
 * Estructura de datos con información y operaciones de los colores usados en la simulación gráfica.
 */
public final class ColorManager {
	public static Color COLOR_BLOQUE_PRINCIPAL = Color.RED;
	public static Color COLOR_CELDA = Color.BLACK;
	public static Color COLOR_NOMBRE_VARIABLE = Color.BLACK;
	public static Color COLOR_NOMBRE_LLAMADA = Color.BLUE;
	public static Color COLOR_LIENZO = Color.WHITE;
	
	private static ColorManager instance;
	private Set<Color> listaColoresUtilizados; 
	private List<Color> listaColoresDisponibles; 
	
	private int indiceColor;
	
	
	public static enum Estilo {
		DEFAULT,
		VERDENEGRO,
		BLANCONEGRO,
		OPUESTO;
	}
    private static final ResourceBundle mensajes = ResourceBundle.getBundle("ikuspro/gui/Mensajes");
	
	public synchronized static ColorManager getInstance() {
		if (instance == null) {
			instance = new ColorManager();
		}
		return instance;
	}
	
	public static void setEstilo(String pEstilo) {
		Estilo estilo = Estilo.valueOf(pEstilo);
		switch(estilo) {
			case DEFAULT:
				COLOR_BLOQUE_PRINCIPAL = Color.RED;
				COLOR_CELDA = Color.BLACK;
				COLOR_NOMBRE_VARIABLE = Color.BLACK;
				COLOR_NOMBRE_LLAMADA = Color.BLUE;
				COLOR_LIENZO = Color.WHITE;
				break;
			case VERDENEGRO:
				COLOR_BLOQUE_PRINCIPAL = Color.GREEN.brighter();
				COLOR_CELDA = Color.GREEN.brighter();
				COLOR_NOMBRE_VARIABLE = Color.GREEN.brighter();
				COLOR_NOMBRE_LLAMADA = Color.GREEN.brighter();
				COLOR_LIENZO = Color.BLACK;
				break;
			case OPUESTO:
				COLOR_BLOQUE_PRINCIPAL = Color.RED;
				COLOR_CELDA = Color.WHITE;
				COLOR_NOMBRE_VARIABLE = Color.WHITE;
				COLOR_NOMBRE_LLAMADA = Color.BLUE;
				COLOR_LIENZO = Color.BLACK;
				break;

		}
	}
	
	private ColorManager() {
		iniciar();
	}
	
	private void iniciar() {
		iniciarPaletaColores();		
	}

	/**
	 * 
	 */
	private void iniciarPaletaColores() {
		indiceColor = 0;
		listaColoresUtilizados = new LinkedHashSet<Color>();
		listaColoresUtilizados.add(Color.BLACK); // Nunca se permite el negro como aleatorio
		listaColoresUtilizados.add(COLOR_BLOQUE_PRINCIPAL);
		listaColoresDisponibles = new ArrayList<Color>() {{
			add(Color.CYAN);
			add(Color.GREEN);
			add(Color.MAGENTA);
			add(Color.ORANGE);
			add(Color.PINK);
			add(Color.YELLOW);
			add(Color.LIGHT_GRAY);
		}};
	}
	

	

	
	public void reiniciar() {
		iniciar();
	}
	
	public Color getNuevoColor() {
		
		Color color = listaColoresDisponibles.get(indiceColor);
		if (indiceColor >= listaColoresDisponibles.size() - 1) {
			indiceColor = 0; // A partir de ahora se repetirán colores
		} else {
			indiceColor++;
		}
		return color;
	}
}
