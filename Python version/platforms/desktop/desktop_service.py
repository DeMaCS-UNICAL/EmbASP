from base.service import Service
from abc import abstractmethod
from base.option_descriptor import OptionDescriptor
from base.input_program import InputProgram
from base.output import Output
import subprocess
import time
from threading import Thread

class DesktopService(Service):
    """Is a specialization for a Desktop platform"""
    
    def __init__(self, exe_path):
        self._exe_path = exe_path  # Stores solver's executable path
        _load_from_STDIN_option = None  # Stores option string for enable solver to read from standard input
        
    def getExePath(self):
        """Return a execution path of DesktopService"""
        return self._exe_path
    
    @abstractmethod
    def _get_output(self, output, error):
        pass
    
    def setExePath(self, exe_path):
        """Set _exe_path to a new path
        The parameter exe_path is a string representing the path for the new solver
        """
        self._exe_path = exe_path
    
    def start_async(self, callback, programs, options):
        """Start a new process for the _exe_path and starts solving in Asyncronously way"""
        class myThread(Thread):
            def __init__(self, start_sync):
                Thread.__init__(self)
                self.start_sync = start_sync
            def run(self):
                callback.callback(self.start_sync(programs, options))
                 
        th = myThread(self.start_sync)
        th.start()
        
    def start_sync(self, programs, options):
        """Start a new process for the _exe_path and starts solving in Syncronously way"""
        option = ""
        for o in options:
            if(o != None):
                option += o.get_options()
                option += o.get_separator()
            else:
                print("Warning : wrong " + str(OptionDescriptor().__class__.__name__))
        files_paths = ""
        final_program = ""
        for p in programs:
            if (p != None):
                final_program += p.get_programs()
                program_file = p.get_string_of_files_paths()
                if (program_file != None):
                    files_paths += program_file
            else:
                print("Warning : wrong " + str(InputProgram().__class__.__name__))
                
        if (self._exe_path == None):
            return Output("", "Error: executable not found");
        
        exep = str(self._exe_path)
        
        opt = str(option)
        
        lis = list()
        lis.append(exep)
        if opt != "":
            lis.append(opt)
        lis.append(files_paths[:-1])
        if self._load_from_stdin_option != "":
            lis.append(self._load_from_stdin_option)
        
        print(exep + " " + opt + " " + files_paths + self._load_from_stdin_option)
        
        start = int(time.time()*1e+9)
        
        proc = subprocess.Popen(lis, universal_newlines=True, stdout=subprocess.PIPE, stdin=subprocess.PIPE, )
        
        output, error = proc.communicate(final_program)
        
        end = int(time.time()*1e+9)
        
        print("Total time : " + str(end - start))
        print("")
        
        return self._get_output(output, error)
        