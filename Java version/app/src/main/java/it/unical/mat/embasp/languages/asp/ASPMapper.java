package it.unical.mat.embasp.languages.asp;

import it.unical.mat.embasp.languages.Mapper;
import it.unical.mat.parsers.asp.ASPParser;
import java.util.HashMap;

/**
 * Contains methods used to transform Objects into {@link it.unical.mat.embasp.base.InputProgram}
 */

public class ASPMapper extends Mapper {
	private static ASPMapper mapper;
	
	public static ASPMapper getInstance() {
		if (ASPMapper.mapper == null)
			ASPMapper.mapper = new ASPMapper();
		return ASPMapper.mapper;
	}

	private ASPMapper() {
		super();
	}

	@Override
	protected String getActualString(final String predicate, final HashMap<Integer, Object> parametersMap) throws IllegalTermException {
		if (parametersMap.isEmpty())
			return predicate;

		String atom = predicate + "(";
		for (int i = 0; i < parametersMap.size(); i++) {
			if (i != 0)
				atom += ",";
			final Object objectTerm = parametersMap.get(i);
			if (objectTerm == null)
				throw new IllegalTermException("Wrong term number of predicate " + predicate);
			if (objectTerm instanceof Integer)
				atom += objectTerm + "";
			else if(objectTerm instanceof SymbolicConstant)
				atom += objectTerm.toString() + "";
			else
				atom += "\"" + objectTerm.toString() + "\"";
		}
		atom += ")";
		return atom;

	}

	@Override
	protected String getId(final String atom) {
		final int openBracketIndex = atom.indexOf("(");

		if(openBracketIndex == -1)
			return atom;

		return atom.substring(0, openBracketIndex);
	}
	
	@Override
	protected String[] getParam(final String atom) {
		return ASPParser.parse(atom).getParameters();
	}
}
