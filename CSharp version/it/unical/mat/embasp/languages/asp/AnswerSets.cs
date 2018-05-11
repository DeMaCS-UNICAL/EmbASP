using System.Collections.Generic;
using System.Collections.ObjectModel;

namespace it.unical.mat.embasp.languages.asp
{
	using Output = it.unical.mat.embasp.@base.Output;

	public abstract class AnswerSets : Output
	{
		protected internal IList<AnswerSet> answersets;

		public AnswerSets(string @out) : base(@out) { }

		public AnswerSets(string @out, string err) : base(@out, err) { }

    public override object Clone() => base.Clone();

    public virtual IList<AnswerSet> Answersets
		{
			get
			{
				if (answersets == null)
				{
					answersets = new List<AnswerSet>();
					Parse();
				}
        return new ReadOnlyCollection<AnswerSet>(answersets);
			}
		}

    public virtual string AnswerSetsString => output;
  }
}