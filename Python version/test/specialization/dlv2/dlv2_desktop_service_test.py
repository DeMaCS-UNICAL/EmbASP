import unittest
from shortest_path.Edge import Edge
from platforms.desktop.desktop_handler import DesktopHandler
from specializations.dlv2.desktop.dlv2_desktop_service import DLV2DesktopService
from shortest_path.Path import Path
from languages.asp.asp_mapper import ASPMapper
from languages.asp.asp_input_program import ASPInputProgram
from base.output import Output
import sys
import os
import platform

class DLV2DesktopServiceTest(unittest.TestCase):

    def getPath(self):
        path = os.path.join("..", "..", "..", "..", "test-resources", "asp", "executables", "dlv2")
        
        if sys.platform.startswith("win32"):
            if platform.machine().endswith('64'):
                path = os.path.join(path, "dlv2.win.64")
            else:
                path = os.path.join(path, "dlv2.win.32")
        else:
            if sys.platform.startswith("linux"):
                if platform.machine().endswith('64'):
                    path = os.path.join(path, "dlv2.linux.64")
                else:
                    path = os.path.join(path, "dlv2.linux.32")
            else:
                if sys.platform.startswith("darwin"):
                    path = os.path.join(path, "dlv2.mac")
        return path


    def getEdges(self):
        edges = []
    
        edges.append(Edge(0,1,1))
        edges.append(Edge(0,2,4))
        edges.append(Edge(1,2,2))
        edges.append(Edge(1,3,4))
        edges.append(Edge(1,4,1))
        edges.append(Edge(2,4,4))
        edges.append(Edge(3,5,6))
        edges.append(Edge(3,6,1))
        edges.append(Edge(4,3,1))
        edges.append(Edge(6,4,5))
        edges.append(Edge(6,5,9))
        edges.append(Edge(6,7,1))
        edges.append(Edge(7,5,2))
    
        return edges

    def join(self, source, path, sortedPath):
        for p in path :
            if(int(p.get_source()) == int(source)) :
                sortedPath.append(p.get_destination())
                if(int(p.get_destination()) == self.destination) :
                    return
                self.join(p.get_destination(), path, sortedPath)
                return

    def show(self,path, sum_):
        first = True
        print("path = ", end='')
        for n in path :
            if not first :
                print(" - ", end='')
            else :
                first = False
            print(n, end='')
        print("\nsum = " + str(sum_))

    def test_shortest_path(self):
        try:
            handler = DesktopHandler(DLV2DesktopService(self.getPath()))

            ASPMapper.get_instance().register_class(Edge)
            ASPMapper.get_instance().register_class(Path)

            inputProgram = ASPInputProgram()

            self.source = 0   # source node
            self.destination = 7   # destination node
    
            rules = "source(" + str(self.source) + "). destination(" + str(self.destination) + ")."
            rules += "path(X,Y,W) | notPath(X,Y,W) :- source(X), edge(X,Y,W)."
            rules += "path(X,Y,W) | notPath(X,Y,W) :- path(_,X,_), edge(X,Y,W), not to(X)."
            rules += "visited(X) :- path(_,X,_)."
            rules += ":- destination(X), not visited(X)."
            rules += ":~ path(X,Y,W). [W@1 ,X,Y]"

            inputProgram.add_program(rules)
            inputProgram.add_objects_input(self.getEdges())

            handler.add_program(inputProgram)
    
            answerSets = handler.start_sync()
            
            self.assertIsNotNone(answerSets)
            self.assertTrue(isinstance(answerSets, Output),"Error, result object is not Output")
            self.assertIsNone(answerSets.get_errors(), "Found error:\n" + str(answerSets.get_errors()))
            self.assertTrue(len(answerSets.get_optimal_answer_sets()) != 0)
            
            answerSet = answerSets.get_optimal_answer_sets()[0]
    
            path = []   # edges in the shortest path (unsorted)
            sum_ = 0   # total weight of the path
    
            for obj in answerSet.get_atoms():
                if isinstance(obj, Path):
                    path.append(obj)
                    sum_ += int(obj.get_weight())

            sortedPath = []   # edges in the shortest path (sorted)
            sortedPath.append(self.source)
    
            self.join(self.source, path, sortedPath)   # sorts the edges
            self.show(sortedPath, sum_)    # shows the path
            
        except Exception as e:
            print(str(e))
        
if __name__ == "__main__":
    unittest.main()