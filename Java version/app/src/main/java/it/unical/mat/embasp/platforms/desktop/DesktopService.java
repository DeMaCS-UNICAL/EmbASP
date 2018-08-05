package it.unical.mat.embasp.platforms.desktop;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
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
			if (o != null) {
				option += o.getOptions();
				option += o.getSeparator();
			} else
				System.err.println("Warning : wrong " + OptionDescriptor.class.getName());

		String files_paths = new String();
		String final_program = new String();

		for (final InputProgram p : programs)
			if (p != null) {
				final_program += p.getPrograms();
				for(final String program_file: p.getFilesPaths()){
					File f = new File(program_file);
					if(f.exists() && !f.isDirectory()) { 
						files_paths += program_file;
						files_paths += " ";
					}
					else
						System.err.println("Warning : the file " + f.getAbsolutePath() + " does not exists.");
				}
			} else
				System.err.println("Warning : wrong " + InputProgram.class.getName());

		final StringBuffer solverOutput = new StringBuffer();
		final StringBuffer solverError = new StringBuffer();

		try {

			final long startTime = System.nanoTime();
			
			File tmpFile = null;

			final StringBuffer stringBuffer = new StringBuffer();
			if (exe_path == null)
				return new Output("", "Error: executable not found");
			stringBuffer.append(exe_path).append(" ").append(option).append(" ").append(files_paths);
			if (!final_program.isEmpty()){
				tmpFile=writeToFile("tmp", final_program);
				stringBuffer.append(" ").append(tmpFile.getAbsolutePath());
			}

			System.err.println(stringBuffer.toString());
			final Process solver_process = Runtime.getRuntime().exec(stringBuffer.toString());

			Thread threadOutput=new Thread() {
				@Override
				public void run() {
					try {

						final BufferedReader bufferedReaderOutput = new BufferedReader(new InputStreamReader(solver_process.getInputStream()));

						// Read output of the solver and store in solverOutput
						String currentLine;
						while ((currentLine = bufferedReaderOutput.readLine()) != null)
							solverOutput.append(currentLine + "\n");
					} catch (final IOException e) {
						e.printStackTrace();
					}

				}
			};
			threadOutput.start();
			threadOutput.join();
			
			Thread threadError = new Thread() {
				@Override
				public void run() {
					try {

						final BufferedReader bufferedReaderError = new BufferedReader(new InputStreamReader(solver_process.getErrorStream()));

						String currentErrLine;
						while ((currentErrLine = bufferedReaderError.readLine()) != null)
							solverError.append(currentErrLine + "\n");

					} catch (final IOException e) {
						e.printStackTrace();
					}

				}
			};
			threadError.start();
			threadError.join();
			
			final PrintWriter writer = new PrintWriter(solver_process.getOutputStream());
			writer.println(final_program);
			if (writer != null)
				writer.close();

			solver_process.waitFor();

			final long stopTime = System.nanoTime();
			System.err.println("Total time : " + (stopTime - startTime));
			
			if(tmpFile!=null) tmpFile.delete();
			
			return getOutput(solverOutput.toString(), solverError.toString());

		} catch (final IOException e2) {
			e2.printStackTrace();
		} catch (final InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return getOutput("", "");

	}
	
	protected File writeToFile(String pFilename, String sb) throws IOException {
	    File tempDir = new File(System.getProperty("java.io.tmpdir"));
	    File tempFile = File.createTempFile(pFilename, ".tmp", tempDir);
	    FileWriter fileWriter = new FileWriter(tempFile, true);
	    BufferedWriter bw = new BufferedWriter(fileWriter);
	    bw.write(sb);
	    bw.close();
	    return tempFile;
	}

}
