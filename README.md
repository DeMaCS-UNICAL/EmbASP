# EmbASP

EmbASP is a framework for the integration of Logic Programming in external systems for generic applications, conceived in order to help developers at designing and implementing complex reasoning tasks by means of logic-based solvers on different platforms.

We currently provide 3 implementations (in [Java](https://www.java.com), in [Python](https://www.python.org) and in [C#](https://docs.microsoft.com/dotnet/csharp/language-reference/) ) and ready-made libraries for the embedding of the _ASP (Answer Set Programming)_ solvers [DLV](http://www.dlvsystem.com/dlv), [clingo](https://potassco.org/clingo) and [DLV2](https://www.mat.unical.it/DLV2) and the _PDDL (Planning Domain Definition Language)_ cloud solver [Solver.Planning.Domains](http://solver.planning.domains) (SPD) on the Desktop platform and of DLV, DLV2 and SPD on the Mobile (Android™) one (available only for the Java version). The Java version requires the antlr4 library.

The framework has been designed to be easily extensible and adaptable to different solvers and platforms. Solvers can be invoked in different modes; for instance, SPD is invoked via a remote connection, while for the other, binaries are effectively embedded and natively executed.

# Contacts
For further information, visit https://www.mat.unical.it/calimeri/projects/embasp
