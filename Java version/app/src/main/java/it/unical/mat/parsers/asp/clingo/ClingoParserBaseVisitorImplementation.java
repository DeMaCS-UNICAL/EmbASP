package it.unical.mat.parsers.asp.clingo;

import it.unical.mat.parsers.asp.ASPDataCollection;
import org.antlr.v4.runtime.BailErrorStrategy;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ConsoleErrorListener;
import org.antlr.v4.runtime.DefaultErrorStrategy;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.atn.PredictionMode;

public class ClingoParserBaseVisitorImplementation extends ClingoParserBaseVisitor <Void> {
    private final ASPDataCollection answerSets;

    private ClingoParserBaseVisitorImplementation(final ASPDataCollection answerSets) {
        this.answerSets = answerSets;
    }

    @Override
    public Void visitAnswer_set(ClingoParser.Answer_setContext ctx) {
        answerSets.addAnswerSet();
    	
        return visitChildren(ctx);
    }

    @Override
    public Void visitModel(ClingoParser.ModelContext ctx) {
        final String cost = ctx.NEW_LINE().getText().trim();

        if(cost.length() > 1) {
            final String[] tokens = cost.split(" ");
            int levels = tokens.length - 1;

            for(int i = 1; i < tokens.length; i++)
                answerSets.storeCost(levels--, Integer.parseInt(tokens[i]));
        }

        return visitChildren(ctx);
    }

    @Override
    public Void visitPredicate_atom(ClingoParser.Predicate_atomContext ctx) {
        answerSets.storeAtom(ctx.getText());

        return null;
    }

    public static void parse(final ASPDataCollection answerSets, final String atomsList, final boolean two_stageParsing) {
    	final CommonTokenStream tokens = new CommonTokenStream(new ClingoLexer(CharStreams.fromString(atomsList)));
        final ClingoParser parser = new ClingoParser(tokens);
        final ClingoParserBaseVisitorImplementation visitor = new ClingoParserBaseVisitorImplementation(answerSets);
        
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
