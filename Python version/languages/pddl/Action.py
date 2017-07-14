class Action(object):
    """Represent a generic Action"""
    def __init__(self, name):
        self.__name = name
        
    def getName(self):
        """Return the name of Action"""
        return self.__name
    
    def setName(self, name):
        """Sets the name of Action"""
        self.name = name