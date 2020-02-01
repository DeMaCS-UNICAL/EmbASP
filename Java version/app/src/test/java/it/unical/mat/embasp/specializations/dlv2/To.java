package it.unical.mat.embasp.specializations.dlv2;

import it.unical.mat.embasp.languages.Id;
import it.unical.mat.embasp.languages.Param;

@Id("to")
public class To {

	@Param(0)
	private int x;
	
	public To() {
		this.x = 0;
	}
	
	public To(int x) {
		this.x = x;
	}
	
	public int getX() {
		return x;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
}
