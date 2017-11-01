from languages.asp.AnswerSets import AnswerSets
from .parser.DLVParserVisitorImplementation import DLVParserVisitorImplementation

class DLVAnswerSets(AnswerSets):
    """Represent an AnswerSet specific for DLV"""
    
    def __init__(self, out, err=None):
        super(DLVAnswerSets, self).__init__(out, err)
        
    def _parse(self):
        DLVParserVisitorImplementation.parse(self._answersets, self._output)