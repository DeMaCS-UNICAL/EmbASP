using System;

namespace it.unical.mat.embasp.languages.asp
{
	public class IllegalTermException : Exception
	{

		private const long serialVersionUID = 1L;

		public IllegalTermException(string msg) : base(msg)
		{
		}

	}

}