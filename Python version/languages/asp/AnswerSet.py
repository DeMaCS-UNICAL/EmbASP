from languages.asp.ASPMapper import ASPMapper

class AnswerSet(object):
    """A collection of data representing a generic Answer Set"""
    
    def __init__(self, value, weightMap = None):
        if weightMap is None:
            weightMap = dict()
        
        self.__value = value  # Where data of answer set is stored
        self.__weight_map = weightMap  # Where weights of the answer set are stored
        self.__atoms = None  # Where Answer set's atoms are stored
        
    def getAnswerSet(self):
        """Return the current __value data
        The method return a list of answer sets in a String format
        """
        return self.__value
    
    def getAtoms(self):
        """Return atoms stored in __atoms
        The method return a set of Object filled with atoms data
        """
        if self.__atoms is None:
            self.__atoms = set()
            
            for atom in self.__value:
                obj = ASPMapper.getInstance().getObject(atom)
                
                if obj is not None:
                    self.__atoms.add(obj)
            
        return self.__atoms
    
    def getWeights(self):
        """Return the weight_map"""
        return self.__weight_map
    
    def __str__(self):
        """Overload string method"""
        return str(self.__value)
