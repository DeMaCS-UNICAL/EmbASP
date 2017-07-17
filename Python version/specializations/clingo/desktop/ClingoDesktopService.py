from platforms.desktop.DesktopService import DesktopService
from specializations.clingo.ClingoAnswerSets import ClingoAnswerSets

class ClingoDesktopService(DesktopService):
    """Is an extention of DesktopService for Clingo's solver"""
    
    def __init__(self, exe_path):
        super(ClingoDesktopService, self).__init__(exe_path)
        self._load_from_STDIN_option = "-"
        
    def _getOutput(self, output, error):
        """Return a new ClingoAnwerSets from output and error given"""
        return ClingoAnswerSets(output, error)
    
    def startSync(self, programs, options):
        """Call startSync method of a superclass, and return her output object"""
        return super(ClingoDesktopService, self).startSync(programs, options)
    
    def startAsync(self, callback, programs, options):
        """Call startAsync method of a superclass"""
        super(ClingoDesktopService, self).startAsync(callback, programs, options)