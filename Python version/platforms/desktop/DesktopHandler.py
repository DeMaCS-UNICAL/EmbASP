from base.Handler import Handler

class DesktopHandler(Handler):
    """Is a Handler specialization for a Desktop platform"""
    
    def __init__(self, service):
        super(DesktopHandler, self).__init__()
        self.__service = service
        
    def startAsync(self, c, program_index=None, option_index=None):
        """Specialization of superclass startAsync method
        Starts ASP solving Asyncronously on a subset of data and options for a Desktop platform
        """
        input_programs = self._collect_programs(program_index)
        input_options = self._collect_options(option_index)
        self.__service.startAsync(c, input_programs, input_options)
        
    def startSync(self, program_index=None, option_index=None):
        """Specialization of superclass startSync method
        Starts ASP solving Asyncronously on a subset of data and options for a Desktop platform
        """
        input_programs = self._collect_programs(program_index)
        input_options = self._collect_options(option_index)
        return self.__service.startSync(input_programs, input_options)
        
    