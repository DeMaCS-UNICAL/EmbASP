from base.output import Output
from languages.pddl.pddl_mapper import PDDLMapper
from abc import ABCMeta

class Plan(Output):
    """A simplified solution to a PDDL problem"""
    
    __metaclass__ = ABCMeta
    
    def __init__(self, plan, error):
        super(Plan, self).__init__(plan, error)
        self._action_sequence = None
        self.__actions_objects = None
        
    def get_actions(self):
        """Return a set of Actions"""
        if self._action_sequence == None:
            self._action_sequence = list()
            self._parse()
        return self._action_sequence
    
    def get_actions_objects(self):
        """Return a set of Objects represents Actions"""
        if self.__actions_objects == None:
            self.__actions_objects = list()
            mapper = PDDLMapper.get_instance()
            for a in self.get_actions():
                obj = mapper.get_object(a.get_name())
                if obj != None:
                    self.__actions_objects.append(obj)
        return self.__actions_objects