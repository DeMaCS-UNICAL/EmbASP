from languages.asp.AnswerSets import AnswerSets
from parsers.asp.ASPDataCollection import ASPDataCollection

class DLV2AnswerSets(AnswerSets):
    """Represents Dlv2's answersets"""
    
    def __init__(self, out, err=None):
        super(DLV2AnswerSets, self).__init__(out, err)
        
    def _parse(self):
        ASPDataCollection.parseDLV2(self, self._output)