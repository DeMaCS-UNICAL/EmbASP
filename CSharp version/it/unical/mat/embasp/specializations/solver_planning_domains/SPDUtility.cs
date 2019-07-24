using it.unical.mat.embasp.languages.pddl;
using System;
using System.Collections.Generic;
using System.IO;
using System.Net;
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

        private static string Escape(string escapable)
        {
            StringBuilder builder = new StringBuilder();

            for (int i = 0; i < escapable.Length; i++)
            {
                char character = escapable[i];

                switch (character)
                {
                    case '"': builder.Append("\\\""); break;
                    case '\\': builder.Append("\\\\"); break;
                    case '\b': builder.Append("\\b"); break;
                    case '\f': builder.Append("\\f"); break;
                    case '\n': builder.Append("\\n"); break;
                    case '\r': builder.Append("\\r"); break;
                    case '\t': builder.Append("\\t"); break;
                    case '/': builder.Append("\\/"); break;
                    default:
                        if (((character >= '\u0000') && (character <= '\u001F')) || ((character >= '\u007F') && (character <= '\u009F')) || ((character >= '\u2000') && (character <= '\u20FF')))
                        {
                            string characterHexCode = Convert.ToInt32(character).ToString("X");

                            builder.Append("\\u");

                            for (int k = 0; k < (4 - characterHexCode.Length); k++)
                                builder.Append("0");

                            builder.Append(characterHexCode.ToUpper());
                        }
                        else
                            builder.Append(character);
                        break;
                }
            }

            return builder.ToString();
        }

        public virtual string CreateJson(IList<InputProgram> pddlInputProgram)
        {
            string problem = "";
            string domain = "";

            foreach (InputProgram ip in pddlInputProgram)
            {
                if (!(ip is PDDLInputProgram))
                    continue;

                PDDLInputProgram pip = (PDDLInputProgram)ip;
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

            return "{\"problem\":\"" + Escape(problem) + "\", \"domain\":\"" + Escape(domain) + "\"}"; ;
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