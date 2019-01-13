from abc import ABCMeta, abstractmethod


class Service(object):
    """Contains generic methods for ASP Solver execution."""

    __metaclass__ = ABCMeta

    @abstractmethod
    def start_async(self, callback, programs, options):
        """Starts ASP solving asynchronously on a subset of data and options.

        The parameter callback is an interface used to interact with
        user. The parameter programs represents a list of InputProgram
        used as data. The parameter options is a list of
        OptionDescriptor used as options.
        """
        pass

    @abstractmethod
    def start_sync(self, programs, options):
        """Starts ASP solving synchronously on a subset of data and options.

        The parameter programs is a list of InputProgram used as data.
        The parameter options is a list of OptionDescriptor used as
        options. The method return an Output element filled with
        results.
        """
        pass
