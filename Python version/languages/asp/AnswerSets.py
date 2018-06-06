from .AnswerSet import AnswerSet
from abc import ABCMeta
from base.Output import Output
from parsers.asp.ASPDataCollection import ASPDataCollection
import sys

class AnswerSets(Output, ASPDataCollection):
    """A collection of AnswerSet"""

    __metaclass__ = ABCMeta

    def __init__(self, out, err=None):
        super(AnswerSets, self).__init__(out, err)
        self._answersets = None  # Where Answer Sets are stored
        
    def getAnswerSets(self):
        """Return a set of AnswerSet"""
        if(self._answersets == None):
            self._answersets = list()
            self._parse()
        return self._answersets
    
    def get_optimal_answer_sets(self):
        answer_sets = self.getAnswerSets()
        levels = 0
        optimal_answer_sets = []
        
        for answer_set in answer_sets:
            max_level = max(answer_set.getWeights().keys())
            
            if levels < max_level:
                levels = max_level
        
        for level in range(levels, 0, -1):
            minimum_cost = sys.maxsize
            
            for answer_set in answer_sets:
                cost = int(answer_set.getWeights().get(level, 0))
                
                if cost < minimum_cost:
                    optimal_answer_sets.clear()
                    
                    minimum_cost = cost
                
                if cost == minimum_cost:
                    optimal_answer_sets.append(answer_set)
                
            answer_sets = list(optimal_answer_sets)
                
        return optimal_answer_sets
    
    def getAnswerSetsString(self):
        """Return a string which contains all AnswerSet"""
        return self._output

    def addAnswerSet(self):
        self._answersets.append(AnswerSet([], {}))
    
    def storeAtom(self, result):
        self._answersets[-1].getAnswerSet().append(result)
    
    def storeCost(self, level, weight):
        self._answersets[-1].getWeights()[level] = weight