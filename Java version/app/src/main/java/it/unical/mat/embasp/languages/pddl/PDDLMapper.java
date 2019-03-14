package it.unical.mat.embasp.languages.pddl;

import it.unical.mat.embasp.languages.Mapper;
import it.unical.mat.embasp.languages.asp.IllegalTermException;
import it.unical.mat.parsers.pddl.PDDLParser;
import java.util.HashMap;

public class PDDLMapper extends Mapper {
	private static PDDLMapper mapper;
	
	public static PDDLMapper getInstance() {
		if (PDDLMapper.mapper == null)
			PDDLMapper.mapper = new PDDLMapper();
		return PDDLMapper.mapper;
	}

	private PDDLMapper() {
		super();
	}

	@Override
	protected String getActualString(final String predicate, final HashMap<Integer, Object> parametersMap) throws IllegalTermException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String getId(final String action) {
		final int openBracketIndex = action.indexOf("(");

		if(openBracketIndex != 0)
			throw new IllegalArgumentException("Wrong format");

		return action.substring(1, action.indexOf(" "));
	}

	@Override
	protected String[] getParam(final String action) {
		return PDDLParser.parse(action).getParameters();
	}
}
