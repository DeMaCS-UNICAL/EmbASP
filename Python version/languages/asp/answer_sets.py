from base.output import Output

class AnswerSets(Output):
    """A collection of AnswerSet"""
    
    def __init__(self, out, err=None):
        super(AnswerSets, self).__init__(out, err)
        self._answer_sets = None  # Where Answer Sets are stored
        
    def get_answer_sets(self):
        """Return a set of AnswerSet"""
        if(self._answer_sets == None):
            self._answer_sets = list()
            self._parse()
        return self._answer_sets
        
    def get_answer_sets_string(self):
        """Return a string which contains all AnswerSet"""
        return self._output

