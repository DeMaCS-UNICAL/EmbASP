from languages.asp.AnswerSets import AnswerSets
from parsers.asp.ASPSolversParser import ASPSolversParser

class DLV2AnswerSets(AnswerSets):
    """Represents Dlv2's answersets"""
    
    def __init__(self, out, err=None):
        super(DLV2AnswerSets, self).__init__(out, err)
        
    def _parse(self):
        ASPSolversParser.parseDLV2(self, self._output, True)
