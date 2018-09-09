from platforms.desktop.desktop_service import DesktopService
from specializations.dlv.dlv_answer_sets import DLVAnswerSets


class DLVDesktopService(DesktopService):
    """Extention of DesktopService for DLV."""

    def __init__(self, exe_path):
        super(DLVDesktopService, self).__init__(exe_path)
        self._load_from_stdin_option = "--"

    def _get_output(self, output, error):
        """Returns a new DLVAnwerSets from given output and error."""
        return DLVAnswerSets(output, error)
