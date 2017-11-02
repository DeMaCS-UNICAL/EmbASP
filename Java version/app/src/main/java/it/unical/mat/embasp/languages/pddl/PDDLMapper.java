package it.unical.mat.embasp.languages.pddl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import it.unical.mat.embasp.languages.Mapper;
import it.unical.mat.embasp.languages.asp.IllegalTermException;
import it.unical.mat.embasp.languages.pddl.parser.PDDLGrammarBaseVisitorImplementation;

public class PDDLMapper extends Mapper {

	private static PDDLMapper mapper;
	private PDDLGrammarBaseVisitorImplementation parser;
	
	public static PDDLMapper getInstance() {
		if (PDDLMapper.mapper == null)
			PDDLMapper.mapper = new PDDLMapper();
		return PDDLMapper.mapper;
	}

	private PDDLMapper() {
		super();
	}

	@Override
	protected List<Object> getCollectionImplementation() {
		return new ArrayList <> ();
	}

	@Override
	protected String getActualString(final String predicate, final HashMap<Integer, Object> parametersMap) throws IllegalTermException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void buildParseTree(String atomsList) {
		parser = new PDDLGrammarBaseVisitorImplementation(atomsList);
	}

	@Override
	protected String getId() {
		return parser.getIdentifier();
	}

	@Override
	protected String[] getParam() {
		return parser.getParameters();
	}
}
