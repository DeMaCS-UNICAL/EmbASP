using it.unical.mat.parsers.pddl;

namespace it.unical.mat.embasp.specializations.solver_planning_domains
{
    using Plan = it.unical.mat.embasp.languages.pddl.Plan;

    public class SPDPlan : Plan
    {
        public SPDPlan(string plan, string error) : base(plan, error) { }

        protected internal override void Parse()
        {
            if (!string.IsNullOrEmpty(errors) || string.IsNullOrEmpty(output))
                return;

            errors += PDDLSolversParser.ParseSolverPlanningDomains(this, output, true);
        }
    }
}