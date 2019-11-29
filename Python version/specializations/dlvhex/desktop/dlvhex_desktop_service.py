from platforms.desktop.desktop_service import DesktopService
from specializations.dlvhex.dlvhex_answer_sets import DLVHEXAnswerSets


class DLVHEXDesktopService(DesktopService):
    def __init__(self, exe_path):
        super(DLVHEXDesktopService, self).__init__(exe_path)

        self._load_from_stdin_option = "--"

    def _getOutput(self, output, error):
        return DLVHEXAnswerSets(output, error)
