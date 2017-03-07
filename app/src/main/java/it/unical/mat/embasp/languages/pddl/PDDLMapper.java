package it.unical.mat.embasp.languages.pddl;

import it.unical.mat.embasp.languages.Mapper;

public class PDDLMapper extends Mapper {

	private static PDDLMapper mapper;

	public static PDDLMapper getInstance() {
		if (PDDLMapper.mapper == null)
			PDDLMapper.mapper = new PDDLMapper();
		return PDDLMapper.mapper;
	}

	private PDDLMapper() {
	}

	@Override
	protected String[] getParameters(final String string) {
		// FIXME I assume that there are spaces only between terms
		return string.substring(string.indexOf(" ") + 1, string.lastIndexOf(")")).split(" ");
	}

	@Override
	protected String getPredicate(final String string) throws IllegalArgumentException {
		// I assume that the string is like (zoom plane1 city4 city1 fl4 fl3 fl2)

		final int initialB = string.indexOf("(");

		if (initialB != 0)
			throw new IllegalArgumentException("Wrong format");

		return string.substring(1, string.indexOf(" "));
	}

}
