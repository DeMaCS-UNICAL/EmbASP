package it.unical.mat.embasp.languages.asp;

public class SymbolicConstant {
	
	private String value;
	
	public SymbolicConstant() {
		value = "";
	}
	
	public SymbolicConstant(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}

}
