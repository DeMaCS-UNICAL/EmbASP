package it.unical.mat.parsers.asp;

import it.unical.mat.parsers.asp.clingo.ClingoParserBaseVisitorImplementation;
import it.unical.mat.parsers.asp.dlv.DLVParserBaseVisitorImplementation;
import it.unical.mat.parsers.asp.dlv2.DLV2ParserBaseVisitorImplementation;
import it.unical.mat.parsers.asp.dlvhex.DLVHEXParserBaseVisitorImplementation;

public final class ASPSolversParser {
	private ASPSolversParser() {
		
	}
	
	public static void parseClingo(final ASPDataCollection answerSets, final String atomsList, final boolean two_stageParsing) {
		ClingoParserBaseVisitorImplementation.parse(answerSets, atomsList, two_stageParsing);
	}
	
	public static void parseDLV(final ASPDataCollection answerSets, final String atomsList, final boolean two_stageParsing) {
    	DLVParserBaseVisitorImplementation.parse(answerSets, atomsList, two_stageParsing);
	}
    
    public static void parseDLV2(final ASPDataCollection answerSets, final String atomsList, final boolean two_stageParsing) {
    	DLV2ParserBaseVisitorImplementation.parse(answerSets, atomsList, two_stageParsing);
    }
    
    public static void parseDLVHEX(final ASPDataCollection answerSets, final String atomsList, final boolean two_stageParsing) {
    	DLVHEXParserBaseVisitorImplementation.parse(answerSets, atomsList, two_stageParsing);
    }
}
