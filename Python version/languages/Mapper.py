from abc import ABCMeta, abstractmethod
from languages.Predicate import Predicate

class Mapper(object):
    """Base class, contains methods used to transform Objects into InputProgram"""
    __metaclass__ = ABCMeta
    
    def __init__(self):
        self._predicateClass = dict()  # Represents a dict, where are stored a string name of a predicate as a key, and a corresponding Class element
        
    @abstractmethod
    def _getActualString(self, predicate, parametersMap):
        pass
    @abstractmethod
    def _getPredicate(self, string):
        pass
    @abstractmethod
    def _getParameters(self, string):
        pass
    
    def getClass(self, predicate):
        """Returns a string for the given predicate name string"""
        return self._predicateClass.get(predicate)
    
    def __populateObject(self, cl, parameters, obj):
        """Sets a fields of object from set of parameters given, by invoking setters methods of object"""
        for key, value in obj.getTermsType().items():
            if isinstance(value, tuple) and len(value) == 2:
                nameMethod = "set" + value[0][:1].upper() + value[0][1:]
                getattr(obj, nameMethod)(int(parameters[key]))
            else:
                nameMethod = "set" + value[:1].upper() + value[1:]
                getattr(obj, nameMethod)(parameters[key])
                
            
    def getObject(self, string):
        """Returns an Object for the given string
        The parameter string is a string from witch data are extrapolated
        The method return a Object for the given string data
        """
        predicate = self._getPredicate(string)
        if (predicate == None):
            return None
        cl = self.getClass(predicate)
        if(cl == None):
            return None
        parameters = self._getParameters(string)
        if(parameters == None):
            return None
        obj = cl()
        self.__populateObject(cl, parameters, obj)
        return obj
    
    def registerClass(self, cl):
        """Insert an object into _predicateClass
        The method return a string representing pairing key of _predicateClass
        """
        if (not issubclass(cl,Predicate)):
            raise("input class is not subclass of Predicate")
        predicate = cl.getPredicateName()
        if (" " in predicate):
            raise("Value of the object is not valid")
        self._predicateClass[predicate] = cl
        return predicate
    
    def unregisterClass(self, cl):
        """Remove an object from _predicateClass"""
        if(not issubclass(cl, Predicate)):
            raise("input class is not subclass of Predicate")
        predicate = cl.getPredicateName()
        del self._predicateClass[predicate]
        
    
    def getString(self, obj):
        """Returns data for the given Object
        The parameter obj is the Object from witch data are extrapolated
        The method return a string data for the given Object in a String format
        """
        predicate = self.registerClass(obj.__class__)
        parametersMap = dict()
        for key, value in obj.getTermsType().items():
            if isinstance(value, tuple) and len(value) == 2:
                val = getattr(obj, "get" + value[0][:1].upper() + value[0][1:])()
            else:
                val = getattr(obj, "get" + value[:1].upper() + value[1:])()
            parametersMap[key] = val
        return self._getActualString(predicate, parametersMap)
        