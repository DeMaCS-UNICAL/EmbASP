from languages.asp.answer_sets import AnswerSets
from parsers.asp.asp_solvers_parser import ASPSolversParser


class ClingoAnswerSets(AnswerSets):
    """Represents Clingo's answersets."""

    def __init__(self, out, err=None):
        super(ClingoAnswerSets, self).__init__(out, err)

    def _parse(self):
        ASPSolversParser.parse_clingo(self, self._output, True)
