from languages.asp.answer_sets import AnswerSets
import re
from languages.asp.answer_set import AnserSet
import traceback


class DLV2AnswerSets(AnswerSets):
    """Represents Dlv2's answersets"""

    def __init__(self, out, err=None):
        super(DLV2AnswerSets, self).__init__(out, err)

    def _parse(self):
        """Create new AnswerSet object represents output come from solver execution and add this in _answer_sets field"""
        optimum = "OPTIMUM" in self._output

        if not optimum:
            match = tuple(re.finditer(r"ANSWER\r?\n(.*)", self._output))
        else:
            match = tuple(re.finditer(
                r"ANSWER\r?\n(.*)(\r?\nCOST (.+)\r?\nOPTIMUM)", self._output))

        for m in match:
            matcher_answer_set = tuple(re.finditer(
                r"-?[a-z][A-Za-z0-9_]*(\(.*?\))?", m.group(1)))
            answer_set_list = list()

            for ma in matcher_answer_set:
                answer_set_list.append(ma.group())

            if optimum:
                weight_map = dict()
                try:
                    split = m.group(3).split(" ")
                    for weightLevel in split:
                        weight_level_array = weightLevel.split("@")
                        weight_map[weight_level_array[1]] = weight_level_array[0]
                except Exception:
                    traceback.print_exc()

                self._answer_sets.append(AnserSet(answer_set_list, weight_map))

            else:
                self._answer_sets.append(AnserSet(answer_set_list))
