using System;
using System.Collections.Generic;

namespace it.unical.mat.embasp.languages.asp
{

	using InputProgram = it.unical.mat.embasp.@base.InputProgram;

	public class ASPInputProgram : InputProgram
	{

		public ASPInputProgram() : base()
		{
		}
		
    public ASPInputProgram(object inputObj) : base(inputObj)
		{
		}

		public ASPInputProgram(string initial_program) : base(initial_program)
		{
		}

		public override void addObjectInput(object inputObj)
		{
      //Console.WriteLine("Obj -> {0}", inputObj.ToString());
			addProgram(ASPMapper.Instance.getString(inputObj) + ".");
		}

		public override void addObjectsInput(ISet<object> inputObjs)
		{
			foreach (Object inputObj in inputObjs)
			{
				addObjectInput(inputObj);
			}
		}
	}

}