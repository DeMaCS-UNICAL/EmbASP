package it.unical.mat.embasp.specializations.solver_planning_domains;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.json.simple.JSONObject;

import it.unical.mat.embasp.base.InputProgram;
import it.unical.mat.embasp.languages.pddl.PDDLException;
import it.unical.mat.embasp.languages.pddl.PDDLInputProgram;

public abstract class SPDUtility {

	private final String solverUrl = "http://solver.planning.domains/solve";

	public SPDUtility() {
	}

	public JSONObject createJson(final List<InputProgram> pddlInputProgram) throws PDDLException {

		String problem = "";
		String domain = "";

		for (final InputProgram ip : pddlInputProgram) {
			if (!(ip instanceof PDDLInputProgram))
				continue;
			final PDDLInputProgram pip = (PDDLInputProgram) ip;
			switch (pip.getProgramsType()) {
				case DOMAIN:
					domain += pip.getPrograms() + pip.getSeparator();
					domain += getFromFile(pip.getFilesPaths(), pip.getSeparator());
					break;
				case PROBLEM:
					problem += pip.getPrograms() + pip.getSeparator();
					problem += getFromFile(pip.getFilesPaths(), pip.getSeparator());
					break;
				default:
					throw new PDDLException("Program type : " + pip.getProgramsType() + " not valid.");
			}
		}

		if (problem.equals(""))
			throw new PDDLException("Problem file not specified");
		if (domain.equals(""))
			throw new PDDLException("Domain file not specified");

		final JSONObject obj = new JSONObject();
		obj.put("problem", problem);
		obj.put("domain", domain);

		return obj;
	}

	private String getFromFile(final List<String> filesPaths, final String separator) {
		final StringBuilder toReturn = new StringBuilder();
		for (final String s : filesPaths)
			try {
				toReturn.append(readFile(s)).append(separator);
			} catch (final IOException e) {
				e.printStackTrace();
			}
		return toReturn.toString();
	}

	public String postJsonToURL(final String json) throws PDDLException {

		String result = "";
		try {
			final URL myurl = new URL(solverUrl);
			final HttpURLConnection con = (HttpURLConnection) myurl.openConnection();
			con.setDoOutput(true);
			con.setDoInput(true);

			con.setRequestProperty("Content-Type", "application/json");
			// con.setRequestProperty("Accept", "application/json,text/plain");
			con.setRequestProperty("Method", "POST");
			final OutputStream os = con.getOutputStream();
			os.write(json.getBytes("UTF-8"));
			os.flush();
			os.close();

			final StringBuilder sb = new StringBuilder();
			final int HttpResult = con.getResponseCode();
			if (HttpResult == HttpURLConnection.HTTP_OK) {
				final BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"));
				String line = null;
				while ((line = br.readLine()) != null)
					sb.append(line + "\n");
				br.close();
				result = sb.toString();
			} else
				throw new PDDLException("HTTP connection error, response code : " + con.getResponseCode() + " response message : " + con.getResponseMessage());
		} catch (final Exception e) {
			throw new PDDLException("Impossible to perform HTTP connection");
		}
		return result;

	}

	protected abstract String readFile(String s) throws IOException;

}
