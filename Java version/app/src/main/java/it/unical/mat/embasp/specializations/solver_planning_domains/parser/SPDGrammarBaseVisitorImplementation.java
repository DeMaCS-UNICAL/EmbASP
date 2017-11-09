package it.unical.mat.embasp.specializations.solver_planning_domains.parser;

import java.util.List;
import it.unical.mat.embasp.languages.pddl.Action;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

public class SPDGrammarBaseVisitorImplementation extends SPDGrammarBaseVisitor <Void> {
	private static final int OK_STATUS = 1;
    private static final int ERROR_STATUS = -1;
    private int status;
    private final List <Action> actions;
    private String errors = "";

    private SPDGrammarBaseVisitorImplementation(final List <Action> actions) {
        this.actions = actions;
    }

    @Override
    public Void visitPair(SPDGrammarParser.PairContext ctx) {
        final SPDGrammarParser.ValueContext valueContext = ctx.value();
        final String string = ctx.STRING().getText();

        if(status == 0 && string.equalsIgnoreCase("\"status\""))
            status = valueContext.getText().equalsIgnoreCase("\"ok\"") ? OK_STATUS : ERROR_STATUS;
        else if(status == ERROR_STATUS) {
            if(string.equalsIgnoreCase("\"result\"")) {
                if(valueContext instanceof SPDGrammarParser.ArrayValueContext || valueContext instanceof SPDGrammarParser.ObjectValueContext)
                    return visitChildren(ctx);
                else
                    errors += trim(valueContext.getText());
            } else if(string.equalsIgnoreCase("\"error\""))
                errors += trim(valueContext.getText());
        } else if(status == OK_STATUS) {
            if(string.equalsIgnoreCase("\"name\""))
                actions.add(new Action(trim(valueContext.getText())));
            else if(string.equalsIgnoreCase("\"plan\"") || string.equalsIgnoreCase("\"result\""))
                return visitChildren(ctx);
        }

        return null;
    }

    private static String trim(final String string) {
        final int stringLength = string.length();

        return (string.charAt(0) == '"' && string.charAt(stringLength - 1) == '"') ? string.substring(1, stringLength - 1) : string;
    }
    
    private static String unescape(final String string) {
        final StringBuilder stringBuilder = new StringBuilder(string.length());

        for(int index = 0; index < string.length(); index++) {
            char character = string.charAt(index);

            if(character == '\\') {
                final char nextChar = (index == string.length() - 1) ? '\\' : string.charAt(index + 1);

                if(nextChar >= '0' && nextChar <= '7') {
                    String code = "" + nextChar;
                    index++;

                    if(index < string.length() - 1 && string.charAt(index + 1) >= '0' && string.charAt(index + 1) <= '7') {
                        code += string.charAt(index++ + 1);

                        if(index < string.length() - 1 && string.charAt(index + 1) >= '0' && string.charAt(index + 1) <= '7')
                            code += string.charAt(index++ + 1);
                    }

                    stringBuilder.append((char)Integer.parseInt(code, 8));

                    continue;
                }

                switch(nextChar) {
                    case '\\': character = '\\'; break;
                    case 'b': character = '\b'; break;
                    case 'f': character = '\f'; break;
                    case 'n': character = '\n'; break;
                    case 'r': character = '\r'; break;
                    case 't': character = '\t'; break;
                    case '\"': character = '\"'; break;
                    case '\'': character = '\''; break;
                    case 'u':
                        if(index >= string.length() - 5) {
                            character = 'u';

                            break;
                        }

                        int code = Integer.parseInt("" + string.charAt(index + 2) + string.charAt(index + 3) + string.charAt(index + 4) + string.charAt(index + 5), 16);

                        stringBuilder.append(Character.toChars(code));

                        index += 5;

                        continue;
                }

                index++;
            }

            stringBuilder.append(character);
        }

        return stringBuilder.toString();
    }

    public static String parse(final List <Action> actions, final String spdOutput) {
        final SPDGrammarBaseVisitorImplementation parser = new SPDGrammarBaseVisitorImplementation(actions);

        parser.visit(new SPDGrammarParser(new CommonTokenStream(new SPDGrammarLexer(CharStreams.fromString(spdOutput)))).json());

        return parser.errors;
    }
}