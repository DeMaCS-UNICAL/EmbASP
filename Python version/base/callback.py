from abc import ABCMeta, abstractmethod


class Callback(object):
    """This interface is used to communicate results of solver invocation to
    the user."""

    __metaclass__ = ABCMeta

    @abstractmethod
    def callback(self, o):
        pass
