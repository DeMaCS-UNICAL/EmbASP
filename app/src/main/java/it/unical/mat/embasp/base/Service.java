package it.unical.mat.embasp.base;

import java.util.List;

/**
 * Contains generic methods for ASP Solver execution .
 *
 * @see List
 */
public interface Service {

	/**
	 * Starts ASP solving Asyncronously on a subset of data and options.
	 *
	 * @param programs
	 *            a list of {@link InputProgram} used as data.
	 * @param options
	 *            a list of {@link OptionDescriptor} used as options.
	 * @param callback
	 *            interface used to interact with user
	 * @see Callback
	 */

	public void startAsync(Callback callback, List<InputProgram> programs, List<OptionDescriptor> options);

	/**
	 * Starts ASP solving Syncronously on a subset of data and options.
	 *
	 * @param programs
	 *            a list of {@link InputProgram} used as data.
	 * @param options
	 *            a list of {@link OptionDescriptor} used as options.
	 * @return {@link Output} element filled with results
	 */

	public Output startSync(List<InputProgram> programs, List<OptionDescriptor> options);

}
