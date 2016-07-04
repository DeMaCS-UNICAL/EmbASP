package it.unical.mat.embasp.base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 *    A collection of {@link InputProgram} and {@link OptionDescriptor}.
 *    The subclasses have to implement {@link #startAsync(Callback, List, List)} and {@link #startSync(List, List)} methods.
 *    Each instance inside {@link #programs} and {@link #options} are represented by an integer (id) , respectively.
 *    @see ArrayList
 *    @see HashMap
 *    @see List
 *    @see Map
 */

public abstract class Handler {
	/** @param programs is where {@link InputProgram} elements are stored.*/
	protected Map<Integer, InputProgram> programs;
	/** @param option is where {@link OptionDescriptor} elements are stored*/
	protected Map<Integer, OptionDescriptor> options;

	public Handler() {
		programs = new HashMap<>();
		options = new HashMap<>();
	}

	/**Add a new element inside {@link #programs} set.
	 * @param program is the {@link InputProgram} instance added to the collection.
	 * @return the id associate to the new added {@link InputProgram} instance.
	 */

	public int addProgram(InputProgram program) {

		int last_index = programs.size();
		int current_value = last_index;
		programs.put(last_index++, program);
		return current_value;
	}

	/**
	 * Add a new element inside {@link #options} set.
	 * @param o is the new {@link OptionDescriptor} instance
	 * @return the id associate to the new added {@link OptionDescriptor} instance*/

	public int addOption(OptionDescriptor o) {

		int last_index = options.size();
		int current_value = last_index;
		options.put(last_index++, o);
		return current_value;
	}

	/** Removes the element associate within the given id from {@link #programs} set.
	 * @param program_id the id associate within an element*/

	public void removeProgram(int program_id) {

		programs.remove(program_id);
	}

	/** Removes every occurrence of a specified {@link InputProgram} element from {@link #programs} set.
	 * @param p element to be removed
	 * @result true if one or more elements are removed , false otherwise*/

	public boolean removeProgram(InputProgram p) {

		boolean result = false;
		for (Map.Entry<Integer, InputProgram> entry : programs.entrySet()) {
			if (entry.getValue().equals(p)) {
				programs.remove(entry.getKey());
				result = true;
			}
		}
		return result;
	}

	/** Removes the element associate within the given id from {@link #options} set.
	 * @param option_id the id associate within an element*/
	public void removeOption(int option_id) {

		options.remove(option_id);

	}

	/** Removes every occurrence of a specified {@link OptionDescriptor} element from {@link #options} set.
	 * @param o element to be removed
	 * @result true if one or more elements are removed , false otherwise*/
	public boolean removeOption(OptionDescriptor o) {

		boolean result = false;
		for (Map.Entry<Integer, OptionDescriptor> entry : options.entrySet()) {
			if (entry.getValue().equals(o)) {
				options.remove(entry.getKey());
				result = true;
			}
		}

		return result;

	}

	/**Removes all of the elements from {@link #programs} and {@link #options}.Both of the collections will be empty after this method returns*/
	public void removeAll() {

		programs.clear();
		options.clear();

	}

	/**Returns the specified {@link InputProgram} element
	 * @param key the id
	 * @return {@link InputProgram} element associate with the given key */
	public InputProgram getInputProgram(int key) {
		return programs.get(key);
	}


	/**Returns the specified {@link OptionDescriptor} element
	 * @param key the id
	 * @return {@link OptionDescriptor} element associate with the given key */
	public OptionDescriptor getOptionDescriptor(int key){
		return options.get(key);
	}

	/**@see #startSync(List, List)*/
	public Output startSync() {

		return startSync((List<Integer>) null, (List<Integer>) null);
	}


	/**This method have to be implemented by subclasses to execute solver in a synchronous way, if no parameters are given
	 * the entire sets of programs and option are used
	 * @see Service*/
	public Output startSync(List<Integer> program_index, List<Integer> option_index) {
		return null;
	}


	/** @see Service*/
	public void startAsync(Callback c) {
		startAsync(c, (List<Integer>) null, (List<Integer>) null);
	}

	/**This method have to be implemented by subclasses to execute solver in a asynchronous way, if no parameters are given
	 * the entire sets of programs and option are used
	 */
	public void startAsync(Callback c, List<Integer> program_index, List<Integer> option_index) {
	}


	protected List<InputProgram> collect_programs(List<Integer> program_index) {

		List<InputProgram> input_programs = new ArrayList<InputProgram>();

		if (program_index == null) {

			for (Map.Entry<Integer, InputProgram> program : this.programs.entrySet()) {
				input_programs.add(this.programs.get(program.getKey()));
			}

		} else {
			for (int index : program_index) {
				input_programs.add(this.programs.get(index));

			}
		}
		return input_programs;
	}


	protected List<OptionDescriptor> collect_options(List<Integer> option_index) {
		List<OptionDescriptor> input_option = new ArrayList<OptionDescriptor>();

		if (option_index == null) {

			for (Map.Entry<Integer, OptionDescriptor> option : this.options.entrySet()) {
				input_option.add(this.options.get(option.getKey()));
			}

		} else {

			for (int index : option_index) {
				input_option.add(this.options.get(index));
			}

		}
		return input_option;
	}
}

