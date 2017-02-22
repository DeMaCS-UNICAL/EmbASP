package it.unical.mat.embasp.languages.pddl;

import fr.uga.pddl4j.parser.Parser;

public class PDDLMapper {
	// FIXME Probably it's better to create a base class "Mapper"
	// TODO Implement it

	public Object getObject(final String action) {
        final Parser parser = new Parser();
        parser.parse(action);
        final parser.
        Plan
        Problem problem = parser.parse(new File(args[1]));
        final PDDLObject obj = parser.link(domain, problem);
        // Gets the error manager of the pddl parser
        final ErrorManager mgr = parser.getErrorManager();
        // If the parser produces errors we print it and stop
        if (mgr.contains(Message.ERROR))
			mgr.print(Message.ALL);
		else {
            mgr.print(Message.WARNING);
            System.out.println("\nParsing domain \"" + domain.getDomainName()
                        + "\" done successfully ...");
            System.out.println("Parsing problem \"" + problem.getProblemName()
                        + "\" done successfully ...\n");
        }
    }

	return new Action();
}}
