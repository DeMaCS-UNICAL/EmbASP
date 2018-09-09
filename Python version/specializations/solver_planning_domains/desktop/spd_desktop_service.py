from platforms.desktop.desktop_service import DesktopService
from languages.pddl.pddl_input_program import PDDLInputProgram
import json
import traceback
import sys
from languages.pddl.pddl_program_type import PDDLProgramType
from specializations.solver_planning_domains.spd_plan import SPDPlan
from languages.pddl.pddl_exception import PDDLException


class SPDDesktopService(DesktopService):
    """Extension of DesktopService for SPD."""

    def __init__(self):
        super(SPDDesktopService, self).__init__("")
        self.__solver_url_resource_name = "solver.planning.domains"
        self.__solver_url_path = "/solve"

    def __create_json(self, pddl_input_program):
        """Returns a json object representing InputProgram."""
        problem = ""
        domain = ""

        for ip in pddl_input_program:
            if not isinstance(ip, PDDLInputProgram):
                continue
            pip = ip
            pType = pip.get_programs_type()

            if pType is PDDLProgramType.DOMAIN:
                domain += str(pip.get_programs()) + str(pip.get_separator())
                domain += self.__get_from_file(pip.get_files_paths(),
                                               pip.get_separator())
            elif pType is PDDLProgramType.PROBLEM:
                problem += str(pip.get_programs()) + str(pip.get_separator())
                problem += self.__get_from_file(pip.get_files_paths(),
                                                pip.get_separator())
            else:
                raise ("Program type : " +
                       pip.get_programs_type() + " not valid.")

        if problem == "":
            raise "Problem file not specified"
        if domain == "":
            raise "Domain file not specified"

        data = {"problem": problem, "domain": domain}

        json_data = json.dumps(data)

        return json_data

    def __get_from_file(self, files_paths, separator):
        """Reads files from given paths and returns their content separated
        by given string separator ."""
        to_return = ""
        for s in files_paths:
            try:
                to_return += self.__read_file(s)
                to_return += separator
            except IOError:
                traceback.print_exc()
        return to_return

    def __post_json_to_url(self, js):
        """Posts a json string given to SPD solver server and returns result."""
        try:
            if sys.version_info < (3, 0):
                import httplib
                connection = httplib.HTTPConnection(
                    self.__solver_url_resource_name)
            else:
                import http.client
                connection = http.client.HTTPConnection(
                    self.__solver_url_resource_name)

            headers = {'Content-type': 'application/json'}

            connection.request('POST', self.__solver_url_path, js, headers)

            response = connection.getresponse()

            if response.status == 200:
                result = response.read().decode()
            else:
                raise PDDLException("HTTP connection error, response code : " + str(
                    response.status) + " response message : " + str(response.reason))
        except:
            raise PDDLException("Impossible to perform HTTP connection")
        finally:
            connection.close()
        return result

    @staticmethod
    def __read_file(s):
        """Reads file from given path and returns its content."""
        everything = ""
        with open(s, 'r') as f:
            try:
                everything = f.read()
            finally:
                f.close()
        return everything

    def _get_output(self, output, error):
        """Returns SPDPlan object from given output and error strings."""
        return SPDPlan(output, error)

    def start_sync(self, programs, options):
        """Return SPDPlan object representing output generated from SPD solver
        server."""
        if not programs:
            return self._get_output("", "PDDLInputProgram not defined")
        try:
            return self._get_output(self.__post_json_to_url(
                str(self.__create_json(programs))), "")
        except Exception as e:
            return self._get_output("", "Error: " + str(e))
