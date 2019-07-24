from base.handler import Handler


class DesktopHandler(Handler):
    """Handler specialization for desktop platforms."""

    def __init__(self, service):
        super(DesktopHandler, self).__init__()
        self.__service = service

    def start_async(self, c, program_index=None, option_index=None):
        """Specialization of superclass start_async method.

        Starts ASP solving asynchronously a subset of data and
        options for a desktop platform.
        """
        input_programs = self._collect_programs(program_index)
        input_options = self._collect_options(option_index)
        self.__service.start_async(c, input_programs, input_options)

    def start_sync(self, program_index=None, option_index=None):
        """Specialization of superclass start_sync method.

        Starts ASP solving synchronously a subset of data and options
        for a desktop platform.
        """
        input_programs = self._collect_programs(program_index)
        input_options = self._collect_options(option_index)
        return self.__service.start_sync(input_programs, input_options)
