from abc import ABCMeta, abstractmethod


class PDDLDataCollection(object):
    __metaclass__ = ABCMeta

    @abstractmethod
    def store_action(self, action):
        pass
