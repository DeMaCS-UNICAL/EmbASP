using it.unical.mat.embasp.languages.pddl;
using Newtonsoft.Json.Linq;
using System;
using System.Collections.Generic;
using System.IO;
using System.Net;
using System.Security.Policy;
using System.Text;

namespace it.unical.mat.embasp.specializations.solver_planning_domains
{
	using InputProgram = it.unical.mat.embasp.@base.InputProgram;
	using PDDLException = it.unical.mat.embasp.languages.pddl.PDDLException;
	using PDDLInputProgram = it.unical.mat.embasp.languages.pddl.PDDLInputProgram;

	public abstract class SPDUtility
	{
		private readonly string solverUrl = "http://solver.planning.domains/solve";

		public SPDUtility() { }

		public virtual JObject CreateJson(IList<InputProgram> pddlInputProgram)
		{
			string problem = "";
			string domain = "";

			foreach (InputProgram ip in pddlInputProgram)
			{
				if (!(ip is PDDLInputProgram))
					continue;
			
        PDDLInputProgram pip = (PDDLInputProgram) ip;
				switch (pip.ProgramsType)
				{
					case PDDLProgramType.DOMAIN:
						domain += pip.Programs + pip.Separator;
						domain += GetFromFile(pip.FilesPaths, pip.Separator);
						break;
					case PDDLProgramType.PROBLEM:
						problem += pip.Programs + pip.Separator;
						problem += GetFromFile(pip.FilesPaths, pip.Separator);
						break;
					default:
						throw new PDDLException("Program type : " + pip.ProgramsType + " not valid.");
				}
			}

			if (problem.Equals(""))
				throw new PDDLException("Problem file not specified");
			if (domain.Equals(""))
				throw new PDDLException("Domain file not specified");

			JObject obj = new JObject();
			obj.Add("problem", problem);
			obj.Add("domain", domain);

			return obj;
		}

		private string GetFromFile(IList<string> filesPaths, string separator)
		{
			StringBuilder toReturn = new StringBuilder();
			foreach (String s in filesPaths)
			{
				try
				{
					toReturn.Append(ReadFile(s)).Append(separator);
				}
				catch (IOException e)
				{
					Console.WriteLine(e.ToString());
					Console.Write(e.StackTrace);
				}
			}
			return toReturn.ToString();
		}

		public virtual string PostJsonToURL(string json)
		{
			string result = "";
			try
			{
        System.Uri myUri = new Uri(solverUrl);
        HttpWebRequest httpRequest = (HttpWebRequest)WebRequest.Create(myUri);

        //If this line is decommented an exception is thrown (option not allowed)
        //httpRequest.AllowReadStreamBuffering = false;
        httpRequest.AllowWriteStreamBuffering = true;

        httpRequest.ContentType = "application/json";
        //httpRequest.Accept = "application/json,text/plain";

        httpRequest.Method = "POST";

        Stream os = httpRequest.GetRequestStream();
        UTF8Encoding encoding = new UTF8Encoding();
        byte[] json_bytes = encoding.GetBytes(json);
        os.Write(json_bytes, 0, json_bytes.Length);
				os.Flush();
				os.Close();

				StringBuilder sb = new StringBuilder();
        HttpWebResponse httpResponse = (HttpWebResponse)httpRequest.GetResponse();
        
				if (httpResponse.StatusCode == HttpStatusCode.OK)
				{
					StreamReader br = new StreamReader(httpResponse.GetResponseStream(), Encoding.UTF8);
					string line = null;
					
          while (!((line = br.ReadLine()) is null))
						sb.Append(line + "\n");
					
          br.Close();
					result = sb.ToString();
				}
				else
				{
					throw new PDDLException("HTTP connection error, response code : " + httpResponse.StatusCode + " response message : " + new StreamReader(httpResponse.GetResponseStream()).ReadToEnd());
				}
			}
			catch (Exception e)
			{
				throw new PDDLException("Impossible to perform HTTP connection: " + e.Message);
			}
			return result;
		}

		protected internal abstract string ReadFile(string s);
	}
}