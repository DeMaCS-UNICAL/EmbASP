package it.unical.mat.embasp.specializations.SolverPlanningDomains;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


import org.json.simple.JSONObject;

import it.unical.mat.embasp.languages.pddl.PDDLInputProgram;

public class SolverPlanningDomainsUtility {
	
	
	static String getFileAsString(String s) throws Exception {
		String everything = "";
		BufferedReader br = new BufferedReader(new FileReader(s));
		try {
			StringBuilder sb = new StringBuilder();
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

	private final String solverUrl ="http://solver.planning.domains/solve";
	
	public SolverPlanningDomainsUtility() {}

	public String postJsonToURL(String json) throws MalformedURLException, IOException, PDDLException {
	     
		String result="";
        URL myurl = new URL(solverUrl);
        HttpURLConnection con = (HttpURLConnection)myurl.openConnection();
        con.setDoOutput(true);
        con.setDoInput(true);
 
        con.setRequestProperty("Content-Type", "application/json");
//        con.setRequestProperty("Accept", "application/json,text/plain");
        con.setRequestProperty("Method", "POST");
        OutputStream os = con.getOutputStream();
        os.write(json.toString().getBytes("UTF-8"));
        os.flush();
        os.close();
 
        StringBuilder sb = new StringBuilder();  
        int HttpResult =con.getResponseCode();
        if(HttpResult ==HttpURLConnection.HTTP_OK){
	        BufferedReader br = new BufferedReader(new   InputStreamReader(con.getInputStream(),"utf-8"));  
	        String line = null;
	        while ((line = br.readLine()) != null) {  
	        	sb.append(line + "\n");  
	        }
	        br.close(); 
	        result=sb.toString();
        }else{
        	throw new PDDLException("HTTP connection error, response code : "+con.getResponseCode()+" response message : "+con.getResponseMessage());
        }  
        return result;
 
    }

	
	public JSONObject createJson(final PDDLInputProgram pddlInputProgram) throws PDDLException{
		String problem=pddlInputProgram.getPDDLProblemString();
		String domain=pddlInputProgram.getPDDLDomainString();
		
		if(problem==""){
			String problemFile=pddlInputProgram.getPDDLProblemFile();
			if(problemFile=="")
				throw new PDDLException("Problem file not specified");
			try {
				problem=getFileAsString(problemFile);
			} catch (Exception e) {
				throw new PDDLException("Problem file : " + problemFile+" not found.");
			}
		}
		if(domain==""){
			String domainFile=pddlInputProgram.getPDDLDomainFile();
			if(domainFile=="")
				throw new PDDLException("Domain file not specified");
			try {
				problem=getFileAsString(domainFile);
			} catch (Exception e) {
				throw new PDDLException("Domain file : " + domainFile+" not found.");
			}
		}
		JSONObject obj = new JSONObject();
		obj.put("problem", problem);
		obj.put("domain", domain);
		
		return obj;
	}
	

}
