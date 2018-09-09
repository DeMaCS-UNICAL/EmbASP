from platforms.desktop.DesktopService import DesktopService
from specializations.dlvhex.DLVHEXAnswerSets import DLVHEXAnswerSets


class DLVHEXDesktopService(DesktopService):
    def __init__(self, exe_path):
        super(DLVHEXDesktopService, self).__init__(exe_path)

        self._load_from_STDIN_option = "--"

    def _getOutput(self, output, error):
        return DLVHEXAnswerSets(output, error)
