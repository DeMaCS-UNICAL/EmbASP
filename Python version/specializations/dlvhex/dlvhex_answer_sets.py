from languages.asp.answer_sets import AnswerSets
from parsers.asp.asp_solvers_parser import ASPSolversParser


class DLVHEXAnswerSets(AnswerSets):
    def __init__(self, output, errors=None):
        super(DLVHEXAnswerSets, self).__init__(output, errors)

    def _parse(self):
        ASPSolversParser.parse_dlvhex(self, self._output, True)
