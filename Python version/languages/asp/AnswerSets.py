from .AnswerSet import AnserSet
from abc import ABCMeta
from base.Output import Output
from parsers.asp.ASPDataCollection import ASPDataCollection

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
        
    def getAnswerSetsString(self):
        """Return a string which contains all AnswerSet"""
        return self._output

    def addAnswerSet(self):
        self._answersets.append(AnserSet([]))
    
    def storeAtom(self, result):
        self._answersets[-1].getAnswerSet().append(result)
    
    def storeCost(self, level, weight):
        self._answersets[-1].getWeights()[level] = weight