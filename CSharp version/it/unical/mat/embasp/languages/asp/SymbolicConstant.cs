using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EmbASP.it.unical.mat.embasp.languages.asp {
  class SymbolicConstant {
    private string value;
    public SymbolicConstant() { }
    
    public SymbolicConstant(string value) {
      this.Value = value;
    }

    public string Value { get => value; set => this.value = value; }

    public override string ToString() {
      return Value;
    }
  }
}
