from base.service import Service
from abc import abstractmethod
from base.option_descriptor import OptionDescriptor
from base.input_program import InputProgram
from base.output import Output
import subprocess
import time
from threading import Thread


class DesktopService(Service):
    """Specialization for a desktop platform."""

    def __init__(self, exe_path):
        self._exe_path = exe_path  # Stores solver's executable path
        # Stores option string in order to enable solver to read from standard input
        self._load_from_stdin_option = None

    def get_exe_path(self):
        """Return execution path of DesktopService."""
        return self._exe_path

    @abstractmethod
    def _get_output(self, output, error):
        pass

    def set_exe_path(self, exe_path):
        """Set _exe_path to a new path.

        The parameter exe_path is a string representing the path for the
        new solver.
        """
        self._exe_path = exe_path

    def start_async(self, callback, programs, options):
        """Start a new process for the _exe_path and starts solving
        asyncronously."""
        class MyThread(Thread):
            def __init__(self, start_sync):
                Thread.__init__(self)
                self.start_sync = start_sync

            def run(self):
                callback.callback(self.start_sync(programs, options))

        th = MyThread(self.start_sync)
        th.start()

    def start_sync(self, programs, options):
        """Start a new process for the _exe_path and starts solving
        syncronously."""
        option = ""
        for o in options:
            if o is not None:
                option += o.get_options()
                option += o.get_separator()
            else:
                print("Warning : wrong " +
                      str(OptionDescriptor().__class__.__name__))
                
        files_paths = list()
        final_program = ""
        for p in programs:
            if p is not None:
                final_program += p.get_programs()
                for path in p.get_files_paths():
                    if len(path) != 0:
                        files_paths.append(path)
            else:
                print("Warning : wrong " +
                      str(InputProgram().__class__.__name__))

        if self._exe_path is None:
            return Output("", "Error: executable not found")

        exep = str(self._exe_path)
        opt = str(option)

        lis = list()
        lis.append(exep)
        if opt != "":
            lis.append(opt)
        for path in files_paths:
            lis.append(path)
        if self._load_from_stdin_option != "" and final_program != "":
            lis.append(self._load_from_stdin_option)

        print(exep + " ", end='')
        if opt != "":
            print(opt + " ", end='')
        for path in files_paths:
            print(path + " ", end='')
        if final_program != "":
            print(self._load_from_stdin_option)
        else:
            print()
            
        start = int(time.time() * 1e+9)

        proc = subprocess.Popen(
            lis,
            universal_newlines=True,
            stdout=subprocess.PIPE,
            stderr=subprocess.PIPE,
            stdin=subprocess.PIPE,
        )

        output, error = proc.communicate(final_program)

        end = int(time.time() * 1e+9)

        print("Total time : " + str(end - start))
        print("")

        return self._get_output(output, error)
