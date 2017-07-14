from platforms.desktop.DesktopService import DesktopService
from languages.pddl.PDDLInputProgram import PDDLInputProgram
import json
import traceback
import sys    
from languages.pddl.PDDLProgramType import PDDLProgramType
from specializations.solver_planning_domains.SPDPlan import SPDPlan
from languages.pddl.PDDLException import PDDLException

class SPDDesktopService(DesktopService):
    """Is an extention of DesktopService for SPDD's solver"""
    
    def __init__(self):
        super(SPDDesktopService, self).__init__("")
        self.__solverUrlResourceName = "solver.planning.domains"
        self.__solverUrlPath = "/solve"
        
    def __createJson(self, pddlInputProgram):
        """Return a json object represents InputProgram"""
        problem = ""
        domain = ""
        
        for ip in pddlInputProgram:
            if not isinstance(ip, PDDLInputProgram):
                continue
            pip = ip
            pType = pip.getProgramsType()
            
            if pType is PDDLProgramType.DOMAIN:
                domain += str(pip.getPrograms()) + str(pip.getSeparator())
                domain += self.__getFromFile(pip.getFilesPaths(), pip.getSeparator())
            elif pType is PDDLProgramType.PROBLEM:
                problem += str(pip.getPrograms()) + str(pip.getSeparator())
                problem += self.__getFromFile(pip.getFilesPaths(), pip.getSeparator())
            else:
                raise ("Program type : " + pip.getProgramsType() + " not valid.")
        
        if problem == "":
            raise ("Problem file not specified")
        if domain == "":
            raise("Domain file not specified")
        
        data = {}
        data["problem"] = problem
        data["domain"] = domain
        
        json_data = json.dumps(data)        

        return json_data
        
                
    def __getFromFile(self, filesPaths, separator):
        """Read file from list of path given and return their content, separate by separator string given"""
        toReturn = ""
        for s in filesPaths:
            try:
                toReturn += self.__readFile(s)
                toReturn += separator
            except IOError:
                traceback.print_exc()
        return toReturn
    
    
    def __postJsonToURL(self, js):
        """Post a json string given to SPD solver server and return result"""
        result = ""
        try:
            if sys.version_info < (3,0):
                import httplib
                connection = httplib.HTTPConnection(self.__solverUrlResourceName)
            else:
                import http.client
                connection = http.client.HTTPConnection(self.__solverUrlResourceName)
            
            headers = {'Content-type': 'application/json'}
            
            connection.request('POST', self.__solverUrlPath, js, headers)
            
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
    
    def __readFile(self, s):
        """Reand file from path given and return her content"""
        everything = ""
        with open(s, 'r') as f:
            try:
                everything = f.read()
            finally:
                f.close()
        return everything
           
    def _getOutput(self, output, error):
        """Return SPDPlan object from output and error strings given"""
        return SPDPlan(output, error)
    
    def startSync(self, programs, options):
        """Return SPDPlan object represent output generated from SPD solver server"""
        if not programs:
            return self._getOutput("", "PDDLInputProgram not defined")
        try:
            return self._getOutput(self.__postJsonToURL(str(self.__createJson(programs))), "")
        except Exception as e:
            return self._getOutput("", "Error: " + str(e))
        
        
        
