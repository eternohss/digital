package br.com.digital.recurso.model;

public enum Type {
	
	MULTIPOLYGON("M"), POINT("P"); 
	
	private final String valor;
	
	Type(String valorOpcao){
        valor = valorOpcao;
    }
    public String getValor(){
        return valor;
    }
    
    public boolean equalsName(String outroTipo)
    {
        return (outroTipo == null)? false : valor.equals(outroTipo);
    }

    public String toString()
    {
        return valor;
    }
}
