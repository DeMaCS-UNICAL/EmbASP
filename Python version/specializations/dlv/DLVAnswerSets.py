from languages.asp.AnswerSets import AnswerSets
from parsers.asp.ASPDataCollection import ASPDataCollection

class DLVAnswerSets(AnswerSets):
    """Represent an AnswerSet specific for DLV"""
    
    def __init__(self, out, err=None):
        super(DLVAnswerSets, self).__init__(out, err)
        
    def _parse(self):
        ASPDataCollection.parseDLV(self, self._output)