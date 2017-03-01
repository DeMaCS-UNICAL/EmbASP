package it.unical.mat.embasp.platforms.desktop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.List;

import it.unical.mat.embasp.base.Callback;
import it.unical.mat.embasp.base.InputProgram;
import it.unical.mat.embasp.base.OptionDescriptor;
import it.unical.mat.embasp.base.Output;
import it.unical.mat.embasp.base.Service;

/**
 * is a specialization for a Desktop platform
 *
 * @see Service
 */

public abstract class DesktopService implements Service {
	/** Stores solver's executable path */
	protected String exe_path;
	protected String load_from_STDIN_option;

	public DesktopService(final String exe_path) {
		this.exe_path = exe_path;
	}

	public String getExePath() {
		return exe_path;
	}

	abstract protected Output getOutput(String output, String error);

	/**
	 * set {@link #exe_path} to a new path*
	 *
	 * @param exe_path
	 *            a string representing the path for the new solver
	 */
	public void setExePath(final String exe_path) {
		this.exe_path = exe_path;
	}

	/**
	 * Start a new process for the {@link #exe_path} and starts solving
	 *
	 * @see it.unical.mat.embasp.base.Service#startAsync(Callback, List, List)
	 */
	@Override
	public void startAsync(final Callback callback, final List<InputProgram> programs, final List<OptionDescriptor> options) {

		new Thread() {
			@Override
			public void run() {
				callback.callback(startSync(programs, options));
			}
		}.start();

	}

	/**
	 * Start a new process for the {@link #exe_path} and starts solving
	 *
	 * @see it.unical.mat.embasp.base.Service#startSync(List, List)
	 */
	@Override
	public Output startSync(final List<InputProgram> programs, final List<OptionDescriptor> options) {

		String option = new String();
		for (final OptionDescriptor o : options)
			option += o.getOptions()+" ";

		String files_paths = new String();
		String final_program = new String();

		for (final InputProgram p : programs) {
			final_program += p.getPrograms();
			final String program_file = p.getFilesPaths();
			if (program_file != null)
				files_paths += program_file;
		}

		final StringBuffer solverOutput = new StringBuffer();
		final StringBuffer solverError = new StringBuffer();

		try {

			final long startTime = System.nanoTime();

			final Process solver_process = Runtime.getRuntime().exec(exe_path + " " + option + files_paths + load_from_STDIN_option);

			new Thread() {
				@Override
				public void run() {
					try {

						final BufferedReader bufferedReaderOutput = new BufferedReader(new InputStreamReader(solver_process.getInputStream()));

						// Read output of the solver and store in solverOutput
						String currentLine;
						while ((currentLine = bufferedReaderOutput.readLine()) != null)
							solverOutput.append(currentLine + "\n");

					} catch (final IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			}.start();

			new Thread() {
				@Override
				public void run() {
					try {

						final BufferedReader bufferedReaderError = new BufferedReader(new InputStreamReader(solver_process.getErrorStream()));

						String currentErrLine;
						while ((currentErrLine = bufferedReaderError.readLine()) != null)
							solverError.append(currentErrLine + "\n");

					} catch (final IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			}.start();

			final PrintWriter writer = new PrintWriter(solver_process.getOutputStream());
			writer.println(final_program);
			if (writer != null)
				writer.close();

			solver_process.waitFor();

			final long stopTime = System.nanoTime();
			System.err.println("Total time : " + (stopTime - startTime));

			return getOutput(solverOutput.toString(), solverError.toString());

		} catch (final IOException e2) {
			e2.printStackTrace();
		} catch (final InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Output() {
		};

	}

}
