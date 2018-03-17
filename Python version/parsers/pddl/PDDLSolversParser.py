from .solver_planning_domains.SPDGrammarVisitorImplementation import SPDGrammarVisitorImplementation

class PDDLSolversParser(object):
    @staticmethod
    def parseSolverPlanningDomains(actions, spdOutput, two_stageParsing):
        return SPDGrammarVisitorImplementation.parse(actions, spdOutput, two_stageParsing)
