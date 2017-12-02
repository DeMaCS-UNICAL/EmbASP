from languages.asp.AnswerSets import AnswerSets
from .parser.DLVHEXParserVisitorImplementation import DLVHEXParserVisitorImplementation

class DLVHEXAnswerSets(AnswerSets):
    def __init__(self, output, errors = None):
        super(DLVHEXAnswerSets, self).__init__(output, errors)
        
    def _parse(self):
        DLVHEXParserVisitorImplementation.parse(self._answersets, self._output)
