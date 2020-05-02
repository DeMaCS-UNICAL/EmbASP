from .answer_set import AnswerSet
from abc import ABCMeta
from base.output import Output
from parsers.asp.asp_data_collection import ASPDataCollection
import sys


class AnswerSets(Output, ASPDataCollection):
    """A collection of AnswerSet."""
    __metaclass__ = ABCMeta

    def __init__(self, out, err=None):
        super(AnswerSets, self).__init__(out, err)
        self._answer_sets = None  # Where Answer Sets are stored

    def get_answer_sets(self):
        """Return a set of AnswerSet."""
        if self._answer_sets is None:
            self._answer_sets = list()
            self._parse()
        return self._answer_sets

    def get_optimal_answer_sets(self):
        answer_sets = self.get_answer_sets()
        levels = 0
        optimal_answer_sets = []

        for answer_set in answer_sets:
            max_level = max(answer_set.get_weights().keys())

            if levels < max_level:
                levels = max_level

        for level in range(levels, 0, -1):
            minimum_cost = sys.maxsize

            for answer_set in answer_sets:
                cost = answer_set.get_weights().get(level, 0)

                if cost < minimum_cost:
                    optimal_answer_sets.clear()

                    minimum_cost = cost

                if cost == minimum_cost:
                    optimal_answer_sets.append(answer_set)

            answer_sets = list(optimal_answer_sets)

        return optimal_answer_sets

    def get_answer_sets_string(self):
        """Return a string which contains every AnswerSet."""
        return self._output

    def add_answer_set(self):
        self._answer_sets.append(AnswerSet([], {}))

    def store_atom(self, result):
        self._answer_sets[-1].get_answer_set().append(result)

    def store_cost(self, level, weight):
        self._answer_sets[-1].get_weights()[int(level)] = int(weight)