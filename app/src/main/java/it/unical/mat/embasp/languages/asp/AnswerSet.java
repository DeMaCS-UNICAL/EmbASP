package it.unical.mat.embasp.languages.asp;

import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * A collection of data representing a generic Answer Set
 *
 * @see HashMap
 * @see List
 */

public class AnswerSet {

	/** where data of answer set is stored */
	private final List<String> value;
	/** where weights of the answer set are stored */
	private final Map<Integer, Integer> weight_map;
	/** where Answer set's atoms are stored */
	private Set<Object> atoms;

	public AnswerSet(final List<String> output) {
		value = output;
		weight_map = new HashMap<>();
	}

	public AnswerSet(final List<String> value, final Map<Integer, Integer> weightMap) {
		this.value = value;
		weight_map = weightMap;
	}

	/**
	 * Return the current {@link #value} data
	 *
	 * @return a list of answer sets in a String format
	 */
	public List<String> getAnswerSet() {
		return Collections.unmodifiableList(value);
	}

	/**
	 * Return atoms stored in {@link #atoms}
	 *
	 * @return a set of Object filled with atoms data
	 */
	public Set<Object> getAtoms() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException,
			InstantiationException {
		if (atoms == null) {
			atoms = new HashSet<>();
			final ASPMapper mapper = ASPMapper.getInstance();
			for (final String atom : value) {
				final Object obj = mapper.getObject(atom);
				if (obj != null)
					atoms.add(obj);
			}
		}

		return atoms;
	}

	public Map<Integer, Integer> getLevelWeight() {
		return weight_map;
	}

	/**
	 * @return the weight_map
	 */
	public Map<Integer, Integer> getWeights() {
		return Collections.unmodifiableMap(weight_map);
	}

	@Override
	public String toString() {
		return value.toString();
	}
}
