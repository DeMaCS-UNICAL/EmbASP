from languages.asp.ASPMapper import ASPMapper

class AnserSet(object):
    """A collection of data representing a generic Answer Set"""
    
    def __init__(self, value, weightMap=dict()):
        self.__value = value  # Where data of answer set is stored
        self.__weight_map = weightMap  # Where weights of the answer set are stored
        self.__atoms = set()  # Where Answer set's atoms are stored
        
    def getAnswerSet(self):
        """Return the current __value data
        The method return a list of answer sets in a String format
        """
        return self.__value
    
    def getAtoms(self):
        """Return atoms stored in __atoms
        The method return a set of Object filled with atoms data
        """
        if not self.__atoms:
            mapper = ASPMapper.getInstance()
            for atom in self.__value:
                obj = mapper.getObject(atom)
                if (not obj == None):
                    self.__atoms.add(obj)
        return self.__atoms
    
    def getWeights(self):
        """Return the weight_map"""
        return self.__weight_map
    
    def __str__(self):
        """Overload string method"""
        return str(self.__value)
    


