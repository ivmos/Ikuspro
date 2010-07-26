package ikuspro.interprete.c;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Variable{
	private String nombre;
	private String tipo;
	private boolean inicializado;
	
	// Tenemos una variable para posible tipo de contenido, ¿podría haberse hecho de otra forma mejor?
	// Seguro, pero así se ha quedado porque funciona, está muy probado y no merece la pena refactorizarlo.
	private Integer iValor;
	private List<Integer> arrIValor ;
	private String sValor;
	private List<String> arrSValor ;
	private Character cValor;
	private List<Character> arrCValor; 
	private Double dValor;
	private List<Double> arrDValor ;
	private boolean array;
	private boolean referencia;
	private int longitudMAX;

	
										 
	
	
	private int num;
	
	public Variable(String pNombre, String pTipo, int pNum) {
		nombre = pNombre;
		tipo = pTipo;
		num = pNum;
		array = false;
	}
	
	public Variable(String pNombre, String pTipo, boolean pEsReferencia) {
		nombre = pNombre;
		tipo = pTipo;
		array = false;
		referencia = pEsReferencia;
		
		
	}
	
	public Variable(String pNombre, String pTipo, int pNum, int pLongitud) {
		this(pNombre, pTipo, pNum);
		array = true;
		inicializar(pLongitud);
		longitudMAX = pLongitud;
		
	}
	
	public void inicializar(int pLongitud) {
		if (tipo.equals("int")) {
			arrIValor =  new ArrayList<Integer>(pLongitud);
		} else if 
			(tipo.equals("float")) {
			arrDValor = new ArrayList<Double>(pLongitud);
		} else if 
			(tipo.equals("char")) {
			arrCValor = new ArrayList<Character>(pLongitud);
		} else if
			(tipo.equals("string")) {
			arrSValor = new ArrayList<String>(pLongitud);
			
		}
	}
	
	/**
	 * Lo utiliza gets() por ejemplo
	 * Hay que limpiar con "clear()", no vale hacer nuevas instancias porque 
	 * hay que tener en cuenta la posible variable referenciada.
	 */
	public void reinicializar() {
		if (tipo.equals("int")) {
			arrIValor.clear();
		} else if 
			(tipo.equals("float")) {
			arrDValor.clear();
		} else if 
			(tipo.equals("char")) {
			arrCValor.clear();
		} else if
			(tipo.equals("string")) {
			arrSValor.clear();
			
		}
	
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String pNombre) {
		nombre = pNombre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String pTipo) {
		tipo = pTipo;
	}

	public boolean isInicializado() {
		return inicializado;
	}

	public void setInicializado(boolean pInicializado) {
		inicializado = pInicializado;
	}

	public Integer getIValor() {
		return iValor;
	}

	public void setIValor(Integer pValor) {
		iValor = pValor;
	}

	public String getSValor() {
		return sValor;
	}

	public void setSValor(String pValor) {
		sValor = pValor;
	}

	public char getCValor() {
		return cValor;
	}

	public void setCValor(char pValor) {
		cValor = pValor;
	}
	
	public <T> void setValor(Valor<T> pValor) {
		if (pValor.get() instanceof String && !referencia) {
			setSValor((String) pValor.get());
		} else if 
			(pValor.get() instanceof Integer && !referencia) {
			setIValor((Integer) pValor.get());
		} else if 
			(pValor.get() instanceof Double && !referencia) {
			setDValor((Double) pValor.get());
			
		} else if 
			(pValor.get() instanceof Character && !referencia) {
 			setCValor((Character) pValor.get());
		} else if
			(pValor.get() instanceof Variable) { // Para las referencias solo pueda entrar por aqui,
												 // Es decir, solo acepta variables como argumento.
				Variable v = ((Variable) pValor.get());
				
					arrCValor = v.getArrCValor();
					arrDValor = v.getArrDValor();
					arrIValor = v.getArrIValor();
					arrSValor = v.getArrSValor();
					longitudMAX = v.getLongitudMAX();
					
					iValor = v.getIValor();
					tipo = v.getTipo();
				
					
				
			
		} else if 
			(pValor.get() instanceof Integer) { // Es un entero y esto es una referencia...
				// Se esta intentando introducir a mano la direccion de la referencia
				// Lo simulamos, sumandole 4400 para que parezca una memoria
				// Los punteros a entero con esto funcionaran algo mas
				setIValor((Integer) pValor.get() + 4400);
		}
		
		
	}
	
	public <T> void setValor(Valor<T> pValor, int pIndice) {
		
		if (pValor.get() instanceof String) {
			// Si el indice esta fuera del rango, lo anadimos al final.
			if (arrSValor.size() < pIndice + 1) {
				arrSValor.add((String) pValor.get());
				
			}
			arrSValor.set(pIndice, (String) pValor.get());
		} else if 
			(pValor.get() instanceof Integer) {
			
			// Si el indice esta fuera del rango, lo anadimos al final.
			
			if (arrIValor.size() < pIndice + 1) {
				arrIValor.add((Integer) pValor.get());
				
			}
			arrIValor.set(pIndice, (Integer) pValor.get());
		} else if 
			(pValor.get() instanceof Double) {
			
			// Si el indice esta fuera del rango, lo anadimos al final.
			if (arrDValor.size() < pIndice + 1) {
				arrDValor.add((Double) pValor.get());
				
			}
			arrDValor.set(pIndice, (Double) pValor.get());
			
		} else if 
			(pValor.get() instanceof Character) {
			
			// Si el indice esta fuera del rango, lo anadimos al final.
			if (arrCValor.size() < pIndice + 1) {
				arrCValor.add((Character) pValor.get());
				
			}
			arrCValor.set(pIndice, (Character) pValor.get());
		}
		
		
	}
	
	public Double getDValor() {
		return dValor;
	}
	
	private void setDValor(Double pDouble) {
		dValor = pDouble;
		
	}


	public Valor getValor() {
		Valor valor = null;
		
		if (isArray() || referencia) {
			valor = new Valor<Variable>(this);
		} else {
			if (tipo.equals("int")) {
				valor = new Valor<Integer>(getIValor());
			} else if 
				(tipo.equals("float")) {
				valor = new Valor<Double>(getDValor());
			} else if 
				(tipo.equals("char")) {
				
				valor = new Valor<Character>(getCValor());
			} else if
				(tipo.equals("string")) {
				valor = new Valor<String>(getSValor());
				
			}
		}
		return valor;
	}
	
	
	
	public Valor getValor(int pIndice) {
		Valor valor = null;
		try {
			if (tipo.equals("int")) {
				valor = new Valor<Integer>(arrIValor.get(pIndice));
			} else if 
				(tipo.equals("float")) {
				valor = new Valor<Double>(arrDValor.get(pIndice));
			} else if 
				(tipo.equals("char")) {
				valor = new Valor<Character>(arrCValor.get(pIndice));
			} else if
				(tipo.equals("string")) {
				valor = new Valor<String>(arrSValor.get(pIndice));
				
			}
		} catch(IndexOutOfBoundsException e) {
			System.out.println("ERROR: Se ha salido del rango del array. Se permite continuar ya que C es más flexible");
			e.printStackTrace();
			if (tipo.equals("char")) { // Para arrays de caracteres devolvemos el ultimo que será \0 seguramente
				valor = new Valor<Character>(arrCValor.get(arrCValor.size() - 1));
			} else if // Para arrays de enteros damos un valor "seguro", esperando que no importe ya que habrá otra condición que se habrá percatado del fuera de rango.
				(tipo.equals("int")) {
				valor = new Valor<Integer>(Integer.MAX_VALUE);
				
			}
		}
		return valor;
	}

	/**
	 * @return the array
	 */
	public boolean isArray() {
		return array || getArrValor() != null;
	}

	/**
	 * @param pArray the array to set
	 */
	public void setArray(boolean pArray) {
		array = pArray;
	}

	/**
	 * @return the arrIValor
	 */
	public List<Integer> getArrIValor() {
		return arrIValor;
	}

	/**
	 * @return the arrSValor
	 */
	public List<String> getArrSValor() {
		return arrSValor;
	}

	/**
	 * @return the arrCValor
	 */
	public List<Character> getArrCValor() {
		return arrCValor;
	}

	/**
	 * @return the arrDValor
	 */
	public List<Double> getArrDValor() {
		return arrDValor;
	}
	
	public List<?> getArrValor() {
		List lista = null;
		if (tipo.equals("int")) {
			lista = arrIValor;
		} else if 
			(tipo.equals("float")) {
			lista = arrDValor;
		} else if 
			(tipo.equals("char")) {
			lista = arrCValor;
		} else if
			(tipo.equals("string")) {
			lista = arrSValor;
			
		}
		return lista;
	}
	
	/**
	 * 
	 * @return una representacion en String limpio de la lista.
	 */
	public String getStrArrValor() {
		
		String resultado = "";
		List listaResul = new ArrayList();
		List lista = getArrValor();
		if (tipo.equals("char")) {
			Iterator ite = lista.iterator();
			while(ite.hasNext()) {
				Character elemento = (Character) ite.next();
				if (!elemento.equals('\0')) { // Filtramos el END
					listaResul.add(elemento);
				} else {
					break; // En cuanto encontremos un '\0' no se mete más
				}
			}
		} else {
			listaResul = lista;
		}
		
		// Construimos manualmente el String porque no nos gusta el formato de toString con
		// corchetes y tal.
		Iterator ite = listaResul.iterator();
		while(ite.hasNext()) {
			resultado += ite.next().toString();
		}
		
		return resultado;
		
	}

	/**
	 * @return the longitudMAX
	 */
	public int getLongitudMAX() {
		return longitudMAX;
	}

	/**
	 * @return the longitud
	 */
	public int getLongitud() {

		int resultado = 0;
		if (isArray()) {
			resultado = getArrValor().size();
			if (tipo.equals("char")) { // Si es un array de chars...
				if (resultado > 0) {
					Iterator<Character> ite = getArrCValor().iterator();
					int longitudString = 0;
					while(ite.hasNext()) {
						Character elemento = ite.next();
						if (elemento.equals('\0')) {
							break;
						} else {
							longitudString++;
						}
					}
					resultado = longitudString;
//					if (getArrCValor().get(resultado - 1).equals('\0')) { // Y lo ultimo que se ha insertado es END...
//						resultado--; // .. en realidad la longitud es menor.
//					}
				}
			}
		} else {
			resultado = 1;
		}
		
		return resultado;
	}
		

	/**
	 * @param pReferencia the referencia to set
	 */
	public void setReferencia(boolean pReferencia) {
		referencia = pReferencia;
	}


	
	
}