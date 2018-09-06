using it.unical.mat.parsers.pddl.solver_planning_domains;

namespace it.unical.mat.parsers.pddl
{
    public static class PDDLSolversParser
    {
        public static string ParseSolverPlanningDomains(IPDDLDataCollection actions, string spdOutput, bool two_stageParsing)
        {
            return SPDGrammarBaseVisitorImplementation.Parse(actions, spdOutput, two_stageParsing);
        }
    }
}