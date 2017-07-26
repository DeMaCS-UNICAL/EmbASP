package it.unical.mat.embasp.specializations.dlv.parser;

import java.util.List;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import it.unical.mat.embasp.languages.asp.AnswerSet;

public class DLVParseTreeWalker {
	private static DLVParseTreeWalker instance;
	
	private DLVParseTreeWalker() {
		
	}
	
	public static DLVParseTreeWalker getInstance() {
		if(instance == null)
			instance = new DLVParseTreeWalker();
		
		return instance;
	}
	
	/**
	 * Walks the parse tree and stores the answer sets found 
	 * by the parser.
	 *
	 * @param answerSets  the list to store the answer sets in
	 * @param dlvOutput  the output of the DLV solver
	 */
    public void walk(final List <AnswerSet> answerSets, final String dlvOutput) {
    	ParseTreeWalker.DEFAULT.walk(new DLVParserListenerImplementation(answerSets), new DLVParser(new CommonTokenStream(new DLVLexer(CharStreams.fromString(dlvOutput)))).output());
    }
}