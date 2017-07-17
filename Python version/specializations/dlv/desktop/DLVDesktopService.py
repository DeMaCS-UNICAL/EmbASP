from platforms.desktop.DesktopService import DesktopService
from specializations.dlv.DLVAnswerSets import DLVAnswerSets

class DLVDesktopService(DesktopService):
    """Is an extention of DesktopService for DLV's solver"""
    
    def __init__(self, exe_path):
        super(DLVDesktopService, self).__init__(exe_path)
        self._load_from_STDIN_option = "--"
        
    def _getOutput(self, output, error):
        """Return a new DLVAnwerSets from output and error given"""
        return DLVAnswerSets(output, error)