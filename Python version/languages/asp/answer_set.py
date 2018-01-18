from languages.asp.asp_mapper import ASPMapper

class AnserSet(object):
    """A collection of data representing a generic Answer Set"""
    
    def __init__(self, value, weightMap=dict()):
        self.__value = value  # Where data of answer set is stored
        self.__weight_map = weightMap  # Where weights of the answer set are stored
        self.__atoms = set()  # Where Answer set's atoms are stored
        
    def get_answer_set(self):
        """Return the current __value data
        The method return a list of answer sets in a String format
        """
        return self.__value
    
    def get_atoms(self):
        """Return atoms stored in __atoms
        The method return a set of Object filled with atoms data
        """
        if not self.__atoms:
            mapper = ASPMapper.get_instance()
            for atom in self.__value:
                obj = mapper.get_object(atom)
                if (not obj == None):
                    self.__atoms.add(obj)
        return self.__atoms
    
    def get_weights(self):
        """Return the weight_map"""
        return self.__weight_map
    
    def __str__(self):
        """Overload string method"""
        return str(self.__value)
    


