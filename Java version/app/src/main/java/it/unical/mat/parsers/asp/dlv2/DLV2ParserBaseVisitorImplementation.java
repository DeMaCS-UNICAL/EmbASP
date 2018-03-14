package it.unical.mat.parsers.asp.dlv2;

import it.unical.mat.parsers.asp.ASPDataCollection;
import org.antlr.v4.runtime.BailErrorStrategy;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ConsoleErrorListener;
import org.antlr.v4.runtime.DefaultErrorStrategy;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.atn.PredictionMode;

public class DLV2ParserBaseVisitorImplementation extends DLV2ParserBaseVisitor <Void> {
    private final ASPDataCollection answerSets;
    
    private DLV2ParserBaseVisitorImplementation(final ASPDataCollection answerSets) {
        this.answerSets = answerSets;
    }

    @Override
    public Void visitAnswer_set(DLV2Parser.Answer_setContext ctx) { 
        answerSets.addAnswerSet();
        
        if(ctx.cost() != null && !ctx.cost().isEmpty()) {
        	final String[] firstCost = ctx.cost().COST_LABEL().getText().split(" ")[1].split("@");
        	
        	answerSets.storeCost(Integer.parseInt(firstCost[1]), Integer.parseInt(firstCost[0]));
        }
        
        return visitChildren(ctx);
    }

    @Override
    public Void visitLevel(DLV2Parser.LevelContext ctx) {
    	answerSets.storeCost(Integer.parseInt(ctx.INTEGER(1).getText()), Integer.parseInt(ctx.INTEGER(0).getText()));

        return null;
    }

    @Override
    public Void visitPredicate_atom(DLV2Parser.Predicate_atomContext ctx) {
        answerSets.storeAtom(ctx.getText());

        return null;
    }

    public static void parse(final ASPDataCollection answerSets, final String atomsList, final boolean two_stageParsing) {
    	final CommonTokenStream tokens = new CommonTokenStream(new DLV2Lexer(CharStreams.fromString(atomsList)));
        final DLV2Parser parser = new DLV2Parser(tokens);
        final DLV2ParserBaseVisitorImplementation visitor = new DLV2ParserBaseVisitorImplementation(answerSets);
        
        if(!two_stageParsing) {
        	visitor.visit(parser.output());
        	
        	return;
        }
        
        parser.getInterpreter().setPredictionMode(PredictionMode.SLL); 
        parser.removeErrorListeners();
        parser.setErrorHandler(new BailErrorStrategy());
     
        try {
        	visitor.visit(parser.output());
        } catch (final RuntimeException exception) {
        	if(exception.getClass() == RuntimeException.class && exception.getCause() instanceof RecognitionException) {
        		tokens.seek(0);
        		parser.addErrorListener(ConsoleErrorListener.INSTANCE);
        		parser.setErrorHandler(new DefaultErrorStrategy());
        		parser.getInterpreter().setPredictionMode(PredictionMode.LL); 
                visitor.visit(parser.output());
        	}
        }
    }
}
