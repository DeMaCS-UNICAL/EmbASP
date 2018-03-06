from languages.asp.AnswerSets import AnswerSets
from parsers.asp.ASPDataCollection import ASPDataCollection

class DLVHEXAnswerSets(AnswerSets):
    def __init__(self, output, errors = None):
        super(DLVHEXAnswerSets, self).__init__(output, errors)
        
    def _parse(self):
        ASPDataCollection.parseDLVHEX(self, self._output)
