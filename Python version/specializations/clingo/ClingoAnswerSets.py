from languages.asp.AnswerSets import AnswerSets
from parsers.asp.ASPDataCollection import ASPDataCollection

class ClingoAnswerSets(AnswerSets):
    """Represents Clingo's answersets"""
    
    def __init__(self, out, err=None):
        super(ClingoAnswerSets, self).__init__(out, err)
        
    def _parse(self):
        ASPDataCollection.parseClingo(self, self._output)