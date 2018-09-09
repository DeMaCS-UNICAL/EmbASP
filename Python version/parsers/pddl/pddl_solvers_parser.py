from parsers.pddl.solver_planning_domains import spd_grammar_visitor_implementation


class PDDLSolversParser(object):
    @staticmethod
    def parse_solver_planning_domains(actions, spdOutput, two_stageParsing):
        return spd_grammar_visitor_implementation.parse(
            actions, spdOutput, two_stageParsing)
