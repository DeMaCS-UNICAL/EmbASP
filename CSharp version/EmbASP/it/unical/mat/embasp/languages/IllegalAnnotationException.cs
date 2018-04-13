using System;

namespace it.unical.mat.embasp.languages
{
	public class IllegalAnnotationException : Exception
	{

		/// 
		private const long serialVersionUID = 1L;

		public IllegalAnnotationException() : base("bad annotation")
		{
		}

	}

}