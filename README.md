# EmbASP

_EmbASP_ is a framework for the integration of Logic Programming in external systems for generic applications, conceived in order to help developers at designing and implementing complex reasoning tasks by means of logic-based solvers on different platforms.

We currently provide implementations of _EmbASP_ in three different programming languages: [Java](https://www.java.com), [Python](https://www.python.org), and [C#](https://docs.microsoft.com/en-us/dotnet/csharp/)).
_EmbASP_ also contains ready-made libraries for embedding several logic-based solvers: 

- ASP (Answer Set Programming)
   - [DLV](http://www.dlvsystem.com/dlv)
   - [DLV2](https://www.mat.unical.it/DLV2)
   - [clingo](https://potassco.org/clingo) 
   - [DLVHEX](http://www.kr.tuwien.ac.at/research/systems/dlvhex/)
- PDDL (Planning Domain Definition Language) 
   - [Solver.Planning.Domains](http://solver.planning.domains)
- Datalog
   - [I-DLV](https://github.com/DeMaCS-UNICAL/I-DLV)

Note that DLV, DLV2 and Solver.Planning.Domains can also be used on Android.

The framework has been designed to be easily extensible and adaptable to different solvers and platforms.
Solvers can be invoked in different ways: via REST API as for Solver.Planning.Domains, native binary execution as for most of the "desktop solvers", library invocation as in the Android solvers, or any other way that can be implemented using the OOP paradigm.

## Quick Guides

### User Guide

The [latest stable version](https://github.com/DeMaCS-UNICAL/EmbASP/releases/latest) can be dowloaded from the [Releases page](https://github.com/DeMaCS-UNICAL/EmbASP/releases) on GitHub.
A JAR file, a wheel file and a DLL file are available for the Desktop platform, while for the Android platform a AAR file has been released.

### Developer Guide

This repository can be downloaded using [Git](https://git-scm.com/). The implementations are stored in 3 different repositories, the [Java version](https://github.com/DeMaCS-UNICAL/EmbASP-Java), the [Python version](https://github.com/DeMaCS-UNICAL/EmbASP-Python) and the [C# version](https://github.com/DeMaCS-UNICAL/EmbASP-CSharp), and are included in this repository through [Git submodule](https://git-scm.com/book/it/v2/Git-Tools-Submodules). The whole project can be downloaded running the following command:

`git clone --recurse-submodules https://github.com/DeMaCS-UNICAL/EmbASP.git`

To ensure that the submodules are updated to their latest version, the following commands can be run:

`cd EmbASP`

`git submodule update --remote`

or, having a git version > 2.23, downloading the whole project through this command :

`git clone --recurse-submodules --remote-submodules https://github.com/DeMaCS-UNICAL/EmbASP.git`

## How to cite EmbASP


[<img src="https://magentaorg.com/wp-content/uploads/2019/05/cropped-Pink-Square@20x-250x250.png" alt title="Journal Article" width="12" height="12" />](https://dblp.org/rec/journals/ngc/CalimeriFGPZ19) [<img src="https://dblp.org/img/paper.dark.hollow.16x16.png" alt title="Download Article" />](https://doi.org/10.1007/s00354-018-0046-2) [<img src="https://dblp.org/img/download.dark.hollow.16x16.png" alt title="Export Citation" />](https://dblp.org/rec/bibtex/journals/ngc/CalimeriFGPZ19) [Francesco Calimeri, Davide Fuscà, Stefano Germano, Simona Perri, Jessica Zangari: Fostering the Use of Declarative Formalisms for Real-World Applications: The EmbASP Framework. New Generation Comput. 37(1): 29-65 (2019)](https://dblp.org/rec/journals/ngc/CalimeriFGPZ19)




[<img src="https://www.americasfinestlabels.com/includes/work/image_cache/bacf5e49815c98b8fc5f347cabf7a54b.thumb.jpg" alt title="Conference Paper" width="12" height="12" />](https://dblp.org/rec/conf/ruleml/CalimeriGIPPZ18) [<img src="https://dblp.org/img/paper.dark.hollow.16x16.png" alt title="Download Paper" />](https://doi.org/10.1007/978-3-319-99906-7_23) [<img src="https://dblp.org/img/download.dark.hollow.16x16.png" alt title="Export Citation" />](https://dblp.org/rec/bibtex/conf/ruleml/CalimeriGIPPZ18) [Francesco Calimeri, Stefano Germano, Giovambattista Ianni, Francesco Pacenza, Simona Perri, Jessica Zangari: Integrating Rule-Based AI Tools into Mainstream Game Development. RuleML+RR 2018: 310-317](https://dblp.org/rec/conf/ruleml/CalimeriGIPPZ18)

## Contacts
For further information, visit https://www.mat.unical.it/calimeri/projects/embasp
