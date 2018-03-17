from abc import ABCMeta, abstractmethod

class PDDLDataCollection(object):
    __metaclass__ = ABCMeta
    
    @abstractmethod
    def storeAction(self, action):
        pass
