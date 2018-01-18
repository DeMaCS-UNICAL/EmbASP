from languages.pddl.plan import Plan
import json
from languages.pddl.action import Action

class SPDPlan(Plan):
    """Represent a solution to a SPD problem"""
    
    def __init__(self, plan, error):
        super(SPDPlan, self).__init__(plan, error)
        
    def _parse(self):
        """Create new Action objects represents output given in a json forms and add this in _action_sequence field"""
        if self._errors != "" or self._output=="":
            return
        try:
            parsed_json = json.loads(self._output)
            status = parsed_json["status"]
            if "ok" in status:
                arrayPlan = parsed_json["result"]["plan"]
                for x in arrayPlan:
                    self._action_sequence.append(Action(x["name"]))
            else:
                self._errors += " " + str(parsed_json["result"])
                
        except ValueError as e:
            self._errors += "ParseException: " + e
    
