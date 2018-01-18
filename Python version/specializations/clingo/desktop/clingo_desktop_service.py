from platforms.desktop.desktop_service import DesktopService
from specializations.clingo.clingo_answer_sets import ClingoAnswerSets

class ClingoDesktopService(DesktopService):
    """Is an extention of DesktopService for Clingo's solver"""
    
    def __init__(self, exe_path):
        super(ClingoDesktopService, self).__init__(exe_path)
        self._load_from_stdin_option = "-"
        
    def _get_output(self, output, error):
        """Return a new ClingoAnwerSets from output and error given"""
        return ClingoAnswerSets(output, error)
    
    def start_sync(self, programs, options):
        """Call start_sync method of a superclass, and return her output object"""
        return super(ClingoDesktopService, self).start_sync(programs, options)
    
    def start_async(self, callback, programs, options):
        """Call start_async method of a superclass"""
        super(ClingoDesktopService, self).start_async(callback, programs, options)