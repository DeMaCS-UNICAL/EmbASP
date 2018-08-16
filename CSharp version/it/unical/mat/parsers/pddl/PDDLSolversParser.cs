using Parsers.PDDL.Solver_Planning_Domains;

namespace Parsers.PDDL
{
    public static class PDDLSolversParser
    {
        public static string ParseSolverPlanningDomains(IPDDLDataCollection actions, string spdOutput, bool two_stageParsing) 
        {
		    return SPDGrammarBaseVisitorImplementation.Parse(actions, spdOutput, two_stageParsing);
	    }
    }
}