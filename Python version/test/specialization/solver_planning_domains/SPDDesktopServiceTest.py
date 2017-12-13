import unittest
import os
from platforms.desktop.DesktopHandler import DesktopHandler
from specializations.solver_planning_domains.desktop.SPDDesktopService import SPDDesktopService
from languages.pddl.PDDLInputProgram import PDDLInputProgram
from languages.pddl.PDDLProgramType import PDDLProgramType
from languages.pddl.PDDLMapper import PDDLMapper
from test.specialization.solver_planning_domains.MyCallback import MyCallback
import time
from test.specialization.solver_planning_domains.PickUp import PickUp



class SPDDesktopServiceTest(unittest.TestCase):

   
    def core(self, results_sizes, base_path):
        
        print("Testing " + str(len(results_sizes)) + " files for " + base_path)
        
        for i in range(1, len(results_sizes) + 1):
            try:
                plan = None
                
                handler = DesktopHandler(SPDDesktopService())
                
                inputProgramDomain = PDDLInputProgram(PDDLProgramType.DOMAIN)
                
                inputProgramDomain.addFilesPath(base_path + "domain.pddl")
                
                inputProgramProblem = PDDLInputProgram(PDDLProgramType.PROBLEM)
                
                if i < 10:
                    problem = base_path + "p" + "0" + str(i) + ".pddl"
                else:
                    problem = base_path + "p" + str(i) + ".pddl"
                    
                self.assertTrue(os.path.isfile(problem) , "File not found: " + problem)
                
                inputProgramProblem.addFilesPath(problem)
                
                handler.addProgram(inputProgramDomain)

                handler.addProgram(inputProgramProblem)
                
                PDDLMapper.getInstance().registerClass(PickUp)
                
                self.assertIsNone(plan)
                
                mc = MyCallback()
  
                handler.startAsync(mc)
                
                mc.await()
                
                plan = mc.getOutput()
                
                self.assertIsNotNone(plan)
                
                tmp=""
                for action in plan.getActions():
                    tmp = tmp + action.getName() + "," 
                print(tmp)
                
                if results_sizes[i - 1] != 0:
                    self.assertTrue(not plan.getErrors(), "Found error in the Plan " + problem + "\n" + plan.getErrors())
                
                self.assertEqual(results_sizes[i - 1], len(plan.getActions()))
                
                for obj in plan.getActionsObjects():
                    if isinstance(obj, PickUp):
                        print(obj.getBlock())
                        
                time.sleep(0.5)
            
            except Exception as e:
                self.fail("Exception " + str(e))
            
    def test_blocksworld(self):
        results_sizes = (6, 10, 6, 12, 10, 16, 12, 10, 20, 20, 24, 22, 18, 24, 16, 34, 28, 26, 42, 36, 36, 32, 46, 34, 40, 34, 58, 50, 44, 38, 46, 58, 66, 56, 56)
        base_path = os.path.join("..", "..", "resources", "pddl", "blocksworld", "")
        self.core(results_sizes, base_path)
          
    def test_depots(self):
        results_sizes = (11, 16, 44, 36, 122, 64, 33, 56, 83, 25, 74, 133, 30, 52, 0, 36, 54, 103, 56, 146, 55, 0)
        base_path = os.path.join("..", "..", "resources", "pddl", "depots", "")
        self.core(results_sizes, base_path)
          
    def test_logistics(self):
        results_sizes = (24, 27, 15, 34, 19, 10, 30, 14, 33, 34, 58, 58, 48, 68, 46, 49, 74, 55, 0, 84, 69, 117, 134, 102, 109, 127, 141, 128)
        base_path = os.path.join("..", "..", "resources", "pddl", "logistics", "")
        self.core(results_sizes, base_path)
        
    def test_gripper(self):
        results_sizes = (15, 23, 31, 39, 47, 55, 63, 71, 79, 87, 95, 103, 111, 119, 127, 135, 143, 151, 159, 167)
        base_path = os.path.join("..", "..", "resources", "pddl", "gripper", "")
        self.core(results_sizes, base_path)

if __name__ == '__main__':
    unittest.main()