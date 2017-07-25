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
	
    public void walk(List <AnswerSet> answerSets, String dlvOutput) {
        final DLVParser parser = new DLVParser(new CommonTokenStream(new DLVLexer(CharStreams.fromString(dlvOutput))));
        
        ParseTreeWalker.DEFAULT.walk(new DLVParserListenerImplementation(answerSets), parser.output());
    }
}