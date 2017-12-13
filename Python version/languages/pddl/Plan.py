from base.Output import Output
from languages.pddl.PDDLMapper import PDDLMapper
from abc import ABCMeta

class Plan(Output):
    """A simplified solution to a PDDL problem"""
    
    __metaclass__ = ABCMeta
    
    def __init__(self, plan, error):
        super(Plan, self).__init__(plan, error)
        self._actionSequence = None
        self.__actionsObjects = None
        
    def getActions(self):
        """Return a set of Actions"""
        if self._actionSequence == None:
            self._actionSequence = list()
            self._parse()
        return self._actionSequence
    
    def getActionsObjects(self):
        """Return a list of objects representing Actions"""
        if self.__actionsObjects is None:
            atomsList = ""
            
            for action in self._actionSequence:
                atomsList += action.getName() + '\n'
            
            self.__actionsObjects = PDDLMapper.getInstance().getObjects(atomsList)
            
        return self.__actionsObjects