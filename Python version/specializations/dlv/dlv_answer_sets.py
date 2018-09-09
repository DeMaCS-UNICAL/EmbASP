from languages.asp.answer_sets import AnswerSets
from parsers.asp.asp_solvers_parser import ASPSolversParser


class DLVAnswerSets(AnswerSets):
    """Represents an AnswerSet for DLV."""

    def __init__(self, out, err=None):
        super(DLVAnswerSets, self).__init__(out, err)

    def _parse(self):
        ASPSolversParser.parse_dlv(self, self._output, True)
