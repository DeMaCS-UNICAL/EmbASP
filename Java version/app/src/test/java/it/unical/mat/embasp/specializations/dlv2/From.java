package it.unical.mat.embasp.specializations.dlv2;

import it.unical.mat.embasp.languages.Id;
import it.unical.mat.embasp.languages.Param;

@Id("from")
public class From {

	@Param(0)
	private int x;
	
	public From() {
		this.x = 0;
	}
	
	public From(int x) {
		this.x = x;
	}
	
	public int getX() {
		return x;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
}
