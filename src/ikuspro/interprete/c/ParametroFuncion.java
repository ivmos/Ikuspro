package ikuspro.interprete.c;

public final class ParametroFuncion {
	private String nombre;
	private String tipo;
	
	private int num;
	private boolean array = false; 
	private boolean referencia = false; 
	private Variable variable;
	private Integer iValor;
	private String sValor;
	private char cValor;
	private Double dValor;
	
	public ParametroFuncion(String pNombre, String pTipo) {
		setNombre(pNombre);
		setTipo(pTipo);
		array = false;
	}
	
	
	public ParametroFuncion(String pNombre, String pTipo, boolean pEsArray) {
		this(pNombre, pTipo);
		array = pEsArray;
		referencia = pEsArray;
	}
	
	public ParametroFuncion(String pNombre, String pTipo, int pNumero) {
		this(pNombre, pTipo);
		setNum(pNumero);
	}
	
	public ParametroFuncion(ParametroFuncion pParametro, int pNumero) {
		this(pParametro.getNombre(), pParametro.getTipo());
		setNum(pNumero);
	}
	
	public ParametroFuncion(String pNombre, Valor pValor) {
		setNombre(pNombre);
		setValor(pValor);
	}
	
	// Paso de parámetros por valor
	public ParametroFuncion(Valor<?> pValor) {
		if (pValor.get() instanceof Variable) {
			//array = true;
			referencia = true;
		} else {
		setNombre("VALOR");
		}
		setValor(pValor);
	}
	
	//Paso de parámetros por referencia
	public ParametroFuncion(Valor<?> pValor, boolean esReferencia) {
		this(pValor);
		referencia = esReferencia;
	}
	
	public <T> void setValor(Valor<T> pValor) {
		
		if (pValor.get() instanceof String) {
			tipo = "string";
			setSValor((String) pValor.get());
		} else if 
			(pValor.get() instanceof Integer) {
			tipo = "int";
			setIValor((Integer) pValor.get());
		} else if 
			(pValor.get() instanceof Double) {
			tipo = "float";
			setDValor((Double) pValor.get());
			
		} else if
			(pValor.get() instanceof Character) {
			tipo = "char";
			setCValor((Character) pValor.get());
		} else if
			(pValor.get() instanceof Variable) {
			tipo = "referencia";
			variable = (Variable) pValor.get();
		}
		
	}
	
	public Valor<?> getValor() {
		Valor<?> valor = null;
		if (tipo == "int") {
			valor = new Valor<Integer>(getIValor());
		} else if 
			(tipo == "float") {
			valor = new Valor<Double>(getDValor());
		} else if 
			(tipo == "char") {
			valor = new Valor<Character>(getCValor());
		} else if
			(referencia) {
			valor = new Valor<Variable>(variable);
		} 
		return valor;
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

	public Double getDValor() {
		return dValor;
	}
	
	private void setDValor(Double pDouble) {
		dValor = pDouble;
		
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

	public int getNum() {
		return num;
	}

	public void setNum(int pNum) {
		num = pNum;
	}

	/**
	 * @return the referencia
	 */
	public boolean isReferencia() {
		return referencia;
	}


	/**
	 * @param pReferencia the referencia to set
	 */
	public void setReferencia(boolean pReferencia) {
		referencia = pReferencia;
	}
}
