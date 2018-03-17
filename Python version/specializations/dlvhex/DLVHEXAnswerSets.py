from languages.asp.AnswerSets import AnswerSets
from parsers.asp.ASPSolversParser import ASPSolversParser

class DLVHEXAnswerSets(AnswerSets):
    def __init__(self, output, errors = None):
        super(DLVHEXAnswerSets, self).__init__(output, errors)
        
    def _parse(self):
        ASPSolversParser.parseDLVHEX(self, self._output, True)
