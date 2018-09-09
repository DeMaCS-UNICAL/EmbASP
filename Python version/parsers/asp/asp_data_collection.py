from abc import ABCMeta, abstractmethod


class ASPDataCollection(object):
    __metaclass__ = ABCMeta

    @abstractmethod
    def add_answer_set(self):
        pass

    @abstractmethod
    def store_atom(self, atom):
        pass

    @abstractmethod
    def store_cost(self, level, weight):
        pass
