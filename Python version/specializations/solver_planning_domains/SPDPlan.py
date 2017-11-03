from languages.pddl.Plan import Plan
from specializations.solver_planning_domains.parser.SPDGrammarVisitorImplementation import SPDGrammarVisitorImplementation

class SPDPlan(Plan):
    """Represent a solution to a SPD problem"""
    
    def __init__(self, plan, error):
        super(SPDPlan, self).__init__(plan, error)
        
    def _parse(self):
        if self._errors or not self._output:
            return

        self._errors += SPDGrammarVisitorImplementation.parse(self._actionSequence, self._output)
