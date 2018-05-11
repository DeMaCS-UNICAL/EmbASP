namespace it.unical.mat.embasp.specializations.solver_planning_domains
{
  using Newtonsoft.Json.Linq;
  using System;
  using Action = it.unical.mat.embasp.languages.pddl.Action;
	using Plan = it.unical.mat.embasp.languages.pddl.Plan;

	public class SPDPlan : Plan
	{
		public SPDPlan(string plan, string error) : base(plan, error) { }

		protected internal override void Parse()
		{
			if (errors != "" || output == "")
				return;
			
      JObject obj;
			try
			{
        obj =
				obj = (JObject) JObject.Parse(output);
				string status = (string) obj["status"];
				if (status.Contains("ok"))
				{
					JArray arrayPlan = (JArray)((JObject) obj["result"])["plan"];
					for (int i = 0; i < arrayPlan.Count; i++)
						actionSequence.Add(new Action(((JObject) arrayPlan[i])["name"].ToString()));
				}
				else
				{
					object resultObj = obj["result"];
					errors += resultObj is JObject ? " " + (string)((JObject) resultObj)["error"] : resultObj.ToString();
				}
			}
      catch (Exception e)
			{
				errors += " ParseException : " + e.Message;
			}
		}
	}
}