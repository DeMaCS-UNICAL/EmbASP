package it.unical.mat.embasp.specializations.dlv.desktop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.List;

import it.unical.mat.embasp.base.Callback;
import it.unical.mat.embasp.base.InputProgram;
import it.unical.mat.embasp.base.OptionDescriptor;
import it.unical.mat.embasp.base.Output;
import it.unical.mat.embasp.platforms.desktop.DesktopService;
import it.unical.mat.embasp.specializations.dlv.DLVAnswerSets;

public class DLVDesktopService extends DesktopService{



	public DLVDesktopService(String exe_path) {
		this.exe_path = exe_path;
	}





	@Override
	public Output startSync(List<InputProgram> programs,
			List<OptionDescriptor> options) {

		DLVAnswerSets to_return = null;

		try {


			String option = new String();
			for (OptionDescriptor o :options) {

				option +=o.getOptions();

			}

			String files_paths = new String();
			String final_program = new String();

			for (InputProgram p : programs) {
				final_program += p.getProgram();
				String program_file = p.getFiles();
				if(program_file != null) {
					files_paths += program_file;
				}
			}


			long startTime = System.nanoTime();

			Process dlv_process = Runtime.getRuntime().exec(exe_path+" "+option +files_paths+"--");

			PrintWriter writer = new PrintWriter(dlv_process.getOutputStream());
			writer.println(final_program);
			writer.flush();
			writer.close();

			BufferedReader output_reader = new BufferedReader(new InputStreamReader(dlv_process.getInputStream()));
			String output_line = new String();
			String output = new String();
			try {
				while((output_line = output_reader.readLine()) != null){
					output += output_line;	
				}
			} catch (IOException e) {

				e.printStackTrace();
			}

			long stopTime = System.nanoTime();
			System.out.println("Total time : " + (stopTime - startTime));
			to_return = new DLVAnswerSets(output);
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}


		return to_return;



	}



	@Override
	public void startAsync(final Callback callback, final List<InputProgram> programs,
			final List<OptionDescriptor> options) {

		Thread thread = new Thread(new Runnable() {

			@Override
			public void run() {

				try {


					String option = new String();
					for (OptionDescriptor o :options) {

						option +=o.getOptions();

					}

					String files_paths = new String();
					String final_program = new String();

					for (InputProgram p : programs) {
						final_program += p.getProgram();
						String program_file = p.getFiles();
						if(program_file != null) {
							files_paths += program_file;
						}
					}


					long startTime = System.nanoTime();

					Process dlv_process = Runtime.getRuntime().exec(exe_path+" "+option +files_paths+"--");

					PrintWriter writer = new PrintWriter(dlv_process.getOutputStream());
					writer.println(final_program);
					writer.flush();
					writer.close();

					BufferedReader output_reader = new BufferedReader(new InputStreamReader(dlv_process.getInputStream()));
					String output_line = new String();
					String output = new String();
					try {
						while((output_line = output_reader.readLine()) != null){
							output += output_line;	
						}
					} catch (IOException e) {

						e.printStackTrace();
					}

					long stopTime = System.nanoTime();
					System.out.println("Total time : " + (stopTime - startTime));
					callback.callback(new DLVAnswerSets(output));
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}

			}
		});
		thread.start();



	}
}