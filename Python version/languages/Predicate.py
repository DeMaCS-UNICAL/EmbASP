from abc import ABCMeta

class Predicate(object):
    """This class have to be implemented by subclasses want it represent a predicate"""
    __metaclass__ = ABCMeta
    
    def __init__(self, terms):
        index = 0
        self.__mapTermsType = dict()  # Dict where positional id and set of terms string name and optionally int type are stored
        for val in terms:
            if isinstance(val, tuple) and len(terms) > 1 and len(val) > 2:
                raise Exception("Bad definition of term")
            self.__mapTermsType[index] = val
            index += 1
    
    @classmethod
    def getPredicateName(cls):
        """Return a string representing the name of a predicate"""
        return cls.predicateName
    
    def getTermsType(self):
        """Return a __mapTermsType dict"""
        return self.__mapTermsType
    