from platforms.desktop.desktop_service import DesktopService
from specializations.dlv2.dlv2_answer_sets import DLV2AnswerSets


class DLV2DesktopService(DesktopService):
    """Extention of DesktopService for DLV2."""

    def __init__(self, exe_path):
        super(DLV2DesktopService, self).__init__(exe_path)
        self._load_from_stdin_option = "--"

    def _get_output(self, output, error):
        """Returns a new DLV2AnwerSets from given output and error."""
        return DLV2AnswerSets(output, error)

    def start_async(self, callback, programs, options):
        """Calls start_async method of a superclass."""
        super(DLV2DesktopService, self).start_async(
            callback, programs, options)

    def start_sync(self, programs, options):
        """Calls start_sync method of a superclass and returns its output
        object."""
        return super(DLV2DesktopService, self).start_sync(programs, options)
