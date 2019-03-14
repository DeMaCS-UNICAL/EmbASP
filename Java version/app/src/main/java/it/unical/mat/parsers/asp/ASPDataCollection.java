package it.unical.mat.parsers.asp;

public interface ASPDataCollection {
	public void addAnswerSet();
	public void storeAtom(final String atom);
	public void storeCost(final int level, final int weight);
}
