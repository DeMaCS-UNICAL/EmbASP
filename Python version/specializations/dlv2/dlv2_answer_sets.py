from languages.asp.answer_sets import AnswerSets
from parsers.asp.asp_solvers_parser import ASPSolversParser


class DLV2AnswerSets(AnswerSets):
    """Represents Dlv2's answersets."""

    def __init__(self, out, err=None):
        super(DLV2AnswerSets, self).__init__(out, err)

    def _parse(self):
        ASPSolversParser.parse_dlv2(self, self._output, True)
