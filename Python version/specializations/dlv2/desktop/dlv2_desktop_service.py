from platforms.desktop.desktop_service import DesktopService
from base.option_descriptor import OptionDescriptor
from specializations.dlv2.dlv2_answer_sets import DLV2AnswerSets

class DLV2DesktopService(DesktopService):
    """Is an extention of DesktopService for DLV2's solver"""
    
    def __init__(self, exe_path):
        super(DLV2DesktopService, self).__init__(exe_path)
        self._load_from_stdin_option = "--"
        self.competition_output_option = OptionDescriptor("--competition-output")
        
    def _get_output(self, output, error):
        """Return a new DLV2AnwerSets from output and error given"""
        return DLV2AnswerSets(output, error)
    
    def start_async(self, callback, programs, options):
        """Call start_async method of a superclass"""
        super(DLV2DesktopService, self).start_async(callback, programs, options)
        
    def start_sync(self, programs, options):
        """Call start_sync method of a superclass, and return her output object"""
        options.append(self.competition_output_option)
        return super(DLV2DesktopService, self).start_sync(programs, options)