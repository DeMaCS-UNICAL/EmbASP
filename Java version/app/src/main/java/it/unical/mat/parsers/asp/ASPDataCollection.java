package it.unical.mat.parsers.asp;

import it.unical.mat.parsers.asp.clingo.ClingoParserBaseVisitorImplementation;
import it.unical.mat.parsers.asp.dlv.DLVParserBaseVisitorImplementation;
import it.unical.mat.parsers.asp.dlv2.DLV2ParserBaseVisitorImplementation;
import it.unical.mat.parsers.asp.dlvhex.DLVHEXParserBaseVisitorImplementation;

public interface ASPDataCollection {
	public void addAnswerSet();
	public void storeAtom(final String atom);
	public void storeCost(final int level, final int weight);
	
	public static void parseClingo(final ASPDataCollection answerSets, final String atomsList) {
		ClingoParserBaseVisitorImplementation.parse(answerSets, atomsList);
	}
	
    public static void parseDLV(final ASPDataCollection answerSets, final String atomsList) {
    	DLVParserBaseVisitorImplementation.parse(answerSets, atomsList);
	}
    
    public static void parseDLV2(final ASPDataCollection answerSets, final String atomsList) {
    	DLV2ParserBaseVisitorImplementation.parse(answerSets, atomsList);
    }
    
    public static void parseDLVHEX(final ASPDataCollection answerSets, final String atomsList) {
    	DLVHEXParserBaseVisitorImplementation.parse(answerSets, atomsList);
    }
}
