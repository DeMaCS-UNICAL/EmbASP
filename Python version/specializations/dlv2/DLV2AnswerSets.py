from languages.asp.AnswerSets import AnswerSets
from .parser.DLV2ParserVisitorImplementation import DLV2ParserVisitorImplementation

class DLV2AnswerSets(AnswerSets):
    """Represents Dlv2's answersets"""
    
    def __init__(self, out, err=None):
        super(DLV2AnswerSets, self).__init__(out, err)
        
    def _parse(self):
        DLV2ParserVisitorImplementation.parse(self._answersets, self._output)