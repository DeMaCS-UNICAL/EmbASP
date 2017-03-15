package it.unical.mat.embasp.languages.asp;


import java.util.HashMap;

import it.unical.mat.embasp.languages.Mapper;

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
		if(parametersMap.isEmpty())
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
			else
				atom += "\"" + objectTerm.toString() + "\"";
		}
		atom += ")";
		return atom;

	}

	@Override
	protected String[] getParameters(final String string) {
		int start=string.indexOf("(")+1;
		int end=string.lastIndexOf(")");
		// FIXME Not work with "a("asd,"). fix the split
		return (start==0 || end==-1 || end<start)
				?new String[0]
				:string.substring(start , end).split(",");
	}

	@Override
	protected String getPredicate(final String string) throws IllegalArgumentException {

		final int indexOf = string.indexOf("(");

		if (indexOf == -1) // Arity 0
			return string;

		return string.substring(0, string.indexOf("("));

	}

}
