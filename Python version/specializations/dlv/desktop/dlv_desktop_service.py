from platforms.desktop.desktop_service import DesktopService
from specializations.dlv.dlv_answer_sets import DLVAnswerSets

class DLVDesktopService(DesktopService):
    """Is an extention of DesktopService for DLV's solver"""
    
    def __init__(self, exe_path):
        super(DLVDesktopService, self).__init__(exe_path)
        self._load_from_stdin_option = "--"
        
    def _get_output(self, output, error):
        """Return a new DLVAnwerSets from output and error given"""
        return DLVAnswerSets(output, error)