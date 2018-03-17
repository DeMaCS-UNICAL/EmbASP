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
