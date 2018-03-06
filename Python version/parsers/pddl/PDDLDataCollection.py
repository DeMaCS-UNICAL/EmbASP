from .solver_planning_domains.SPDGrammarVisitorImplementation import SPDGrammarVisitorImplementation
from abc import ABCMeta, abstractmethod

class PDDLDataCollection(object):
    __metaclass__ = ABCMeta
    
    @abstractmethod
    def storeAction(self, action):
        pass
    
    @staticmethod
    def parseSolverPlanningDomains(actions, spdOutput):
        return SPDGrammarVisitorImplementation.parse(actions, spdOutput)
    