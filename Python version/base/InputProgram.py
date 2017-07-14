class InputProgram(object):
    """Represents a generic option"""
    
    def __init__(self):
        """Creates a new programs , setting space as default separator"""
        self._programs = ""  # Where programs data is stored
        self.__files_paths = list()  # Where associated files are stored
        self._separator = " "  # Used as separator for programs


    def addObjectInput(self,inputObj):
        raise "Functionality not implemented"

    def addObjectsInput(self, inputObjs):
        for inputObj in inputObjs:
            self.addObjectInput(inputObj)

    def addFilesPath(self, file_path):
        """Add a new file path into __files_paths
        The parameter file_path represents a new file path
        """
        self.__files_paths.append(file_path)


    def addProgram(self, new_instruction):
        """Adds a new instruction directly into _programs
        The parameter new_instruction rapresents a new programs instruction
        """
        if(self._programs == None):
            self._programs = new_instruction
        else:
            self._programs += self._separator + new_instruction

    def clearFilesPaths(self):
        """After this method, __files_paths will be empty"""
        del self.__files_paths[:]

    def clearPrograms(self):
        """After this method, _programs will be empty"""
        self._programs = None

    def clearAll(self):
        """After this method, both __files_paths and _programs will be empty"""
        self.clearFilesPaths()
        self.clearPrograms()

    def getFilesPaths(self):
        """Returns the __files_paths list"""
        return self.__files_paths

    def getPrograms(self):
        """Returns data stored in _programs"""
        return self._programs

    def getSeparator(self):
        """Separator the _separator character"""
        return self._separator

    def getStringOfFilesPaths(self):
        """Returns string concatenating files paths"""
        to_return=""
        for paths in self.__files_paths:
            if(len(paths) != 0):
                to_return += paths + " "
        return to_return

    def setPrograms(self, programs):
        """Sets _programs value to the new given one
        The parameter programs, rapresents new value
        """
        self._programs = programs

    def setSeparator(self, separator):
        """Set programs separator to current value
        The parameter separator is used as new separator
        """
        self._separator = separator


