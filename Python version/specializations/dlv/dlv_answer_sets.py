from languages.asp.answer_sets import AnswerSets
from parsers.asp.ASPSolversParser import ASPSolversParser

class DLVAnswerSets(AnswerSets):
    """Represent an AnswerSet specific for DLV"""

    def __init__(self, out, err=None):
        super(DLVAnswerSets, self).__init__(out, err)

    def _parse(self):
        ASPSolversParser.parse_dlv(self, self._output, True)
