from base.Output import Output

class AnswerSets(Output):
    """A collection of AnswerSet"""
    
    def __init__(self, out, err=None):
        super(AnswerSets, self).__init__(out, err)
        self._answersets = None  # Where Answer Sets are stored
        
    def getAnswerSets(self):
        """Return a set of AnswerSet"""
        if(self._answersets == None):
            self._answersets = list()
            self._parse()
        return self._answersets
        
    def getAnswerSetsString(self):
        """Return a string which contains all AnswerSet"""
        return self._output

