from languages.asp.answer_sets import AnswerSets
import re
from languages.asp.answer_set import AnserSet
import traceback


class ClingoAnswerSets(AnswerSets):
    """Represents Clingo's answersets"""

    def __init__(self, out, err=None):
        super(ClingoAnswerSets, self).__init__(out, err)

    def _parse(self):
        """Create new AnswerSet object represents output come from solver execution and add this in _answer_sets field"""
        optimum = "OPTIMUM" in self._output

        if not optimum:
            match = tuple(re.finditer(r"Answer: (\d+)\r?\n(.*)", self._output))
        else:
            match = tuple(re.finditer(
                r"Answer: (\d+)\r?\n(.*)(\r?\nOptimization: (.+))", self._output))

        for m in match:
            try:
                if m.group(1) is None or int(m.group(1)) <= len(self._answer_sets):
                    continue
            except Exception:
                traceback.print_exc()
                break

            matcher_answer_set = tuple(re.finditer(
                r"-?[a-z][A-Za-z0-9_]*(\(.*?\))?", m.group(2)))
            answer_set_list = list()

            for ma in matcher_answer_set:
                answer_set_list.append(ma.group())

            if optimum:
                weight_map = dict()
                try:
                    split = m.group(4).split(" ")
                    level = len(split)
                    for weight in split:
                        weight_map[level] = int(weight)
                        level -= 1
                except Exception:
                    traceback.print_exc()

                self._answer_sets.append(AnserSet(answer_set_list, weight_map))

            else:
                self._answer_sets.append(AnserSet(answer_set_list))
