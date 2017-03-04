package it.unical.mat.embasp.specializations.solver_planning_domains;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.simple.JSONObject;

import it.unical.mat.embasp.languages.pddl.PDDLException;
import it.unical.mat.embasp.languages.pddl.PDDLInputProgram;

public class SolverPlanningDomainsUtility {

	static String getFileAsString(final String s) throws Exception {
		String everything = "";
		final BufferedReader br = new BufferedReader(new FileReader(s));
		try {
			final StringBuilder sb = new StringBuilder();
			String line = br.readLine();

			while (line != null) {
				sb.append(line);
				sb.append(System.lineSeparator());
				line = br.readLine();
			}
			everything = sb.toString();
		} finally {
			br.close();
		}
		return everything;
	}

	private final String solverUrl = "http://solver.planning.domains/solve";

	public SolverPlanningDomainsUtility() {
	}

	public JSONObject createJson(final PDDLInputProgram pddlInputProgram) throws PDDLException {
		String problem = pddlInputProgram.getPDDLProblemString();
		String domain = pddlInputProgram.getPDDLDomainString();
		if (problem == "") {
			final String problemFile = pddlInputProgram.getPDDLProblemFile();
			if (problemFile == "")
				throw new PDDLException("Problem file not specified");
			try {
				problem = SolverPlanningDomainsUtility.getFileAsString(problemFile);
			} catch (final Exception e) {
				throw new PDDLException("Problem file : " + problemFile + " not found.");
			}
		}
		if (domain == "") {
			final String domainFile = pddlInputProgram.getPDDLDomainFile();
			if (domainFile == "")
				throw new PDDLException("Domain file not specified");
			try {
				domain = SolverPlanningDomainsUtility.getFileAsString(domainFile);
			} catch (final Exception e) {
				throw new PDDLException("Domain file : " + domainFile + " not found.");
			}
		}
		final JSONObject obj = new JSONObject();
		obj.put("problem", problem);
		obj.put("domain", domain);

		return obj;
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

}
