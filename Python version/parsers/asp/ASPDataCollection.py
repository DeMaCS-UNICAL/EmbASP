from .clingo.ClingoParserVisitorImplementation import ClingoParserVisitorImplementation
from .dlv.DLVParserVisitorImplementation import DLVParserVisitorImplementation
from .dlv2.DLV2ParserVisitorImplementation import DLV2ParserVisitorImplementation
from .dlvhex.DLVHEXParserVisitorImplementation import DLVHEXParserVisitorImplementation
from abc import ABCMeta, abstractmethod

class ASPDataCollection(object):
    __metaclass__ = ABCMeta
    
    @abstractmethod
    def addAnswerSet(self):
        pass
    
    @abstractmethod
    def storeAtom(self, atom):
        pass
    
    @abstractmethod
    def storeCost(self, level, weight):
        pass
    
    @staticmethod
    def parseClingo(answerSets, atomsList):
        ClingoParserVisitorImplementation.parse(answerSets, atomsList)
    
    @staticmethod
    def parseDLV(answerSets, atomsList):
        DLVParserVisitorImplementation.parse(answerSets, atomsList)
    
    @staticmethod
    def parseDLV2(answerSets, atomsList):
        DLV2ParserVisitorImplementation.parse(answerSets, atomsList)
    
    @staticmethod
    def parseDLVHEX(answerSets, atomsList):
        DLVHEXParserVisitorImplementation.parse(answerSets, atomsList)
