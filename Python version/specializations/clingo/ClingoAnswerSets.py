from languages.asp.AnswerSets import AnswerSets
from .parser.ClingoParserVisitorImplementation import ClingoParserVisitorImplementation

class ClingoAnswerSets(AnswerSets):
    """Represents Clingo's answersets"""
    
    def __init__(self, out, err=None):
        super(ClingoAnswerSets, self).__init__(out, err)
        
    def _parse(self):
        ClingoParserVisitorImplementation.parse(self._answersets, self._output)