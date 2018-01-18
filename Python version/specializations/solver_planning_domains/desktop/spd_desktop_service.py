from platforms.desktop.desktop_service import DesktopService
from languages.pddl.pddl_input_program import PDDLInputProgram
import json
import traceback
import sys    
from languages.pddl.pddl_program_type import PDDLProgramType
from specializations.solver_planning_domains.spd_plan import SPDPlan
from languages.pddl.pddl_exception import PDDLException

class SPDDesktopService(DesktopService):
    """Is an extention of DesktopService for SPDD's solver"""
    
    def __init__(self):
        super(SPDDesktopService, self).__init__("")
        self.__solver_url_resource_name = "solver.planning.domains"
        self.__solver_url_path = "/solve"
        
    def __create_json(self, pddlInputProgram):
        """Return a json object represents InputProgram"""
        problem = ""
        domain = ""
        
        for ip in pddlInputProgram:
            if not isinstance(ip, PDDLInputProgram):
                continue
            pip = ip
            pType = pip.get_programs_type()
            
            if pType is PDDLProgramType.DOMAIN:
                domain += str(pip.get_programs()) + str(pip.get_separator())
                domain += self.__get_from_file(pip.get_files_paths(), pip.get_separator())
            elif pType is PDDLProgramType.PROBLEM:
                problem += str(pip.get_programs()) + str(pip.get_separator())
                problem += self.__get_from_file(pip.get_files_paths(), pip.get_separator())
            else:
                raise ("Program type : " + pip.get_programs_type() + " not valid.")
        
        if problem == "":
            raise ("Problem file not specified")
        if domain == "":
            raise("Domain file not specified")
        
        data = {}
        data["problem"] = problem
        data["domain"] = domain
        
        json_data = json.dumps(data)        

        return json_data
        
                
    def __get_from_file(self, filesPaths, separator):
        """Read file from list of path given and return their content, separate by separator string given"""
        toReturn = ""
        for s in filesPaths:
            try:
                toReturn += self.__read_file(s)
                toReturn += separator
            except IOError:
                traceback.print_exc()
        return toReturn
    
    
    def __post_json_to_url(self, js):
        """Post a json string given to SPD solver server and return result"""
        result = ""
        try:
            if sys.version_info < (3,0):
                import httplib
                connection = httplib.HTTPConnection(self.__solver_url_resource_name)
            else:
                import http.client
                connection = http.client.HTTPConnection(self.__solver_url_resource_name)
            
            headers = {'Content-type': 'application/json'}
            
            connection.request('POST', self.__solver_url_path, js, headers)
            
            response = connection.getresponse()
            
            if response.status == 200:
                result = response.read().decode()
            else:
                raise PDDLException("HTTP connection error, response code : " + str(response.status) + " response message : " + str(response.reason))
        except:
            raise PDDLException("Impossible to perform HTTP connection")
        finally:
            connection.close()
        return result
    
    def __read_file(self, s):
        """Reand file from path given and return her content"""
        everything = ""
        with open(s, 'r') as f:
            try:
                everything = f.read()
            finally:
                f.close()
        return everything
           
    def _get_output(self, output, error):
        """Return SPDPlan object from output and error strings given"""
        return SPDPlan(output, error)
    
    def start_sync(self, programs, options):
        """Return SPDPlan object represent output generated from SPD solver server"""
        if not programs:
            return self._get_output("", "PDDLInputProgram not defined")
        try:
            return self._get_output(self.__post_json_to_url(str(self.__create_json(programs))), "")
        except Exception as e:
            return self._get_output("", "Error: " + str(e))
        
        
        
