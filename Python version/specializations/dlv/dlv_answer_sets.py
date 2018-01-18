from languages.asp.answer_sets import AnswerSets
from languages.asp.answer_set import AnserSet
import re

class DLVAnswerSets(AnswerSets):
    """Represent an AnswerSet specific for DLV"""
    
    def __init__(self, out, err=None):
        super(DLVAnswerSets, self).__init__(out, err)
        
    def _parse(self):
        """Create new AnswerSet object represents output come from solver execution and add this in _answer_sets field"""
        match = tuple(re.finditer(r"\{(.*)\}", self._output))
        for m in match:
            answerSet = m.group()
            answerSetList = set()
            matcherAnswerSet = tuple(re.finditer(r"(-?[a-z][A-Za-z0-9_]*(\(.+?\))?)(, |\})", answerSet))
            for ma in matcherAnswerSet:
                answerSetList.add(ma.group(1))
            self._answer_sets.append(AnserSet(answerSetList))
