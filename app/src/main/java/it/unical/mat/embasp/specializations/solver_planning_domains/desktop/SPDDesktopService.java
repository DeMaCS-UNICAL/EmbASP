package it.unical.mat.embasp.specializations.solver_planning_domains.desktop;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import it.unical.mat.embasp.base.InputProgram;
import it.unical.mat.embasp.base.OptionDescriptor;
import it.unical.mat.embasp.base.Output;
import it.unical.mat.embasp.platforms.desktop.DesktopService;
import it.unical.mat.embasp.specializations.solver_planning_domains.SPDPlan;
import it.unical.mat.embasp.specializations.solver_planning_domains.SPDUtility;

public class SPDDesktopService extends DesktopService {

	private final SPDUtility spdu;

	public SPDDesktopService() {
		super("");
		spdu = new SPDUtility() {
			@Override
			protected String readFile(final String s) throws IOException {

				String everything = "";
				BufferedReader br = null;
				try {
					br = new BufferedReader(new FileReader(s));
					final StringBuilder sb = new StringBuilder();
					String line = br.readLine();

					while (line != null) {
						sb.append(line);
						sb.append(System.lineSeparator());
						line = br.readLine();
					}
					everything = sb.toString();
				} finally {
					if (br != null)
						br.close();
				}
				return everything;
			}
		};
	}

	@Override
	protected Output getOutput(final String output, final String error) {
		return new SPDPlan(output, error);
	}

	@Override
	public Output startSync(final List<InputProgram> programs, final List<OptionDescriptor> options) {

		if (programs.isEmpty())
			return getOutput("", "PDDLInputProgram not defined");

		try {
			return getOutput(spdu.postJsonToURL(spdu.createJson(programs).toString()), "");
		} catch (final Exception e) {
			return getOutput("", "Error : " + e.getMessage());
		}
	}

}
