from abc import ABCMeta, abstractmethod
from languages.predicate import Predicate
from languages.asp.symbolic_constant import SymbolicConstant


class Mapper(object):
    """Base class, contains methods used to transform Objects into
    InputProgram."""
    __metaclass__ = ABCMeta

    def __init__(self):
        self._objects = None
        self._parser = None
        # Represents a dict, where are stored a string name of a predicate as a
        # key and the corresponding Class element
        self._predicate_class = dict()

    @abstractmethod
    def _get_actual_string(self, predicate, parameters_map):
        pass

    @abstractmethod
    def _get_id(self):
        pass

    @abstractmethod
    def _get_param(self):
        pass

    def get_class(self, predicate):
        """Returns a string for the given predicate name string."""
        return self._predicate_class.get(predicate)

    @staticmethod
    def __populate_object(parameters, obj):
        """Sets a fields of object from set of parameters given, by invoking
        setters methods of the object."""
        for key, value in obj.get_terms_type().items():
            if isinstance(value, tuple) and len(value) == 2:
                name_method = "set_" + value[0]
                if value[1] is int:
                    getattr(obj, name_method)(int(parameters[key]))
                elif value[1] is SymbolicConstant:
                    getattr(obj, name_method)(
                        SymbolicConstant(parameters[key]))
            else:
                name_method = "set_" + value
                getattr(obj, name_method)(parameters[key])

    def get_object(self, atom):
        """Returns an Object for the given string.

        The parameter string is a string from which data are
        extrapolated. The method return a Object for the given string
        data.
        """
        predicate = self._get_id(atom)

        if predicate is None:
            return None

        cl = self.get_class(predicate)

        if cl is None:
            return None

        parameters = self._get_param(atom)

        if parameters is None:
            return None

        obj = cl()

        self.__populate_object(parameters, obj)

        return obj

    def register_class(self, cl):
        """Insert an object into _predicate_class.

        The method return a string representing pairing key of
        _predicate_class.
        """
        if not issubclass(cl, Predicate):
            raise "input class is not subclass of Predicate"
        predicate = cl.get_predicate_name()
        if " " in predicate:
            raise "Value of the object is not valid"
        self._predicate_class[predicate] = cl
        return predicate

    def unregister_class(self, cl):
        """Remove an object from _predicate_class."""
        if not issubclass(cl, Predicate):
            raise "input class is not subclass of Predicate"
        predicate = cl.get_predicate_name()
        del self._predicate_class[predicate]

    def get_string(self, obj):
        """Returns data for the given Object.

        The parameter obj is the Object from which data are
        extrapolated. The method return a string data for the given
        Object in a String format.
        """
        predicate = self.register_class(obj.__class__)

        parameters_map = dict()
        for key, value in obj.get_terms_type().items():
            if isinstance(value, tuple) and len(value) == 2:
                val = getattr(obj, "get_" + value[0])()
            else:
                val = getattr(obj, "get_" + value)()

            parameters_map[key] = val
        return self._get_actual_string(predicate, parameters_map)
