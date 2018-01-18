from abc import ABCMeta, abstractmethod
from languages.predicate import Predicate

class Mapper(object):
    """Base class, contains methods used to transform Objects into InputProgram"""
    __metaclass__ = ABCMeta
    
    def __init__(self):
        self._predicate_class = dict()  # Represents a dict, where are stored a string name of a predicate as a key, and a corresponding Class element
        
    @abstractmethod
    def _get_actual_string(self, predicate, parametersMap):
        pass
    @abstractmethod
    def _get_predicate(self, string):
        pass
    @abstractmethod
    def _get_parameters(self, string):
        pass
    
    def get_class(self, predicate):
        """Returns a string for the given predicate name string"""
        return self._predicate_class.get(predicate)
    
    def __populate_object(self, cl, parameters, obj):
        """Sets a fields of object from set of parameters given, by invoking setters methods of object"""
        for key, value in obj.get_terms_type().items():
            if isinstance(value, tuple) and len(value) == 2:
                nameMethod = "set_" + value[0]
                getattr(obj, nameMethod)(int(parameters[key]))
            else:
                nameMethod = "set_" + value
                getattr(obj, nameMethod)(parameters[key])
                
            
    def get_object(self, string):
        """Returns an Object for the given string
        The parameter string is a string from witch data are extrapolated
        The method return a Object for the given string data
        """
        predicate = self._get_predicate(string)
        if (predicate == None):
            return None
        cl = self.get_class(predicate)
        if(cl == None):
            return None
        parameters = self._get_parameters(string)
        if(parameters == None):
            return None
        obj = cl()
        self.__populate_object(cl, parameters, obj)
        return obj
    
    def register_class(self, cl):
        """Insert an object into _predicate_class
        The method return a string representing pairing key of _predicate_class
        """
        if (not issubclass(cl,Predicate)):
            raise("input class is not subclass of Predicate")
        predicate = cl.get_predicate_name()
        if (" " in predicate):
            raise("Value of the object is not valid")
        self._predicate_class[predicate] = cl
        return predicate
    
    def unregister_class(self, cl):
        """Remove an object from _predicate_class"""
        if(not issubclass(cl, Predicate)):
            raise("input class is not subclass of Predicate")
        predicate = cl.get_predicate_name()
        del self._predicate_class[predicate]
        
    
    def get_string(self, obj):
        """Returns data for the given Object
        The parameter obj is the Object from witch data are extrapolated
        The method return a string data for the given Object in a String format
        """
        predicate = self.register_class(obj.__class__)
        parametersMap = dict()
        for key, value in obj.get_terms_type().items():
            if isinstance(value, tuple) and len(value) == 2:
                val = getattr(obj, "get_" + value[0])()
            else:
                val = getattr(obj, "get_" + value)()
            parametersMap[key] = val
        return self._get_actual_string(predicate, parametersMap)
        