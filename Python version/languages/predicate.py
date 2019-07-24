from abc import ABCMeta


class Predicate(object):
    """This class have to be implemented by subclasses in order to 
	represent a predicate."""

    __metaclass__ = ABCMeta

    def __init__(self, terms):
        index = 0
        # Dict where positional id and set of terms are stored
        self.__map_terms_type = dict()
        for val in terms:
            if isinstance(val, tuple) and len(terms) > 1 and len(val) > 2:
                raise Exception("Bad definition of term")
            self.__map_terms_type[index] = val
            index += 1

    @classmethod
    def get_predicate_name(cls):
        """Return a string representing the name of a predicate."""
        return cls.predicate_name

    def get_terms_type(self):
        """Return a __map_terms_type dict."""
        return self.__map_terms_type
