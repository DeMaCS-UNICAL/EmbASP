package it.unical.mat.embasp.specializations.dlv2;

import it.unical.mat.embasp.languages.Id;
import it.unical.mat.embasp.languages.Param;

@Id("path")
public class Path {

	@Param(0)
	private int from;
	
	@Param(1)
	private int to;
	
	@Param(2)
	private int weight;
	
	public Path() {
		this.from = 0;
		this.to = 0;
		this.weight = 0;
	}
	
	public Path(int from, int to, int weight) {
		this.from = from;
		this.to = to;
		this.weight = weight;
	}

	public int getFrom() {
		return from;
	}

	public void setFrom(int from) {
		this.from = from;
	}

	public int getTo() {
		return to;
	}

	public void setTo(int to) {
		this.to = to;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "path(" + from + "," + to + "," + weight + ").";
	}
	
}
