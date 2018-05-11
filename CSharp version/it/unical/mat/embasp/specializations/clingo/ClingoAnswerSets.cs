using System;
using System.Collections.Generic;
using System.Text.RegularExpressions;

namespace it.unical.mat.embasp.specializations.clingo
{
	using AnswerSet = it.unical.mat.embasp.languages.asp.AnswerSet;
	using AnswerSets = it.unical.mat.embasp.languages.asp.AnswerSets;

	public class ClingoAnswerSets : AnswerSets
	{
		public ClingoAnswerSets(string answersets) : base(answersets) { }
		
    public ClingoAnswerSets(string @out, string err) : base(@out, err) { }

		protected internal override void Parse()
		{
			bool optimum = output.Contains("OPTIMUM");
      string pattern = !optimum ? ("Answer: (\\d+)\\r?\\n(.*)") : ("Answer: (\\d+)\\r?\\n(.*)(\\r?\\nOptimization: (.+))");

      Regex regex = new Regex(@pattern);
      Match matcher = regex.Match(output);
      
			while (matcher.Success)
			{
				try
				{
					if (matcher.Groups[1].Value == null || int.Parse(matcher.Groups[1].Value) <= answersets.Count)
						continue;
				}
				catch (System.FormatException e1)
				{
					Console.WriteLine(e1.ToString());
					Console.Write(e1.StackTrace);
					break;
				}

        string patternAnswerSet = ("-?[a-z][A-Za-z0-9_]*(\\(.*?\\))?");
        Regex regexAnswerSet = new Regex(patternAnswerSet);
        Match matcherAnswerSet = regexAnswerSet.Match(matcher.Groups[2].Value);
        IList<string> answerSetList = new List<string>();

				while (matcherAnswerSet.Success)
				{
					answerSetList.Add(matcherAnswerSet.Value);
          matcherAnswerSet = matcherAnswerSet.NextMatch();
        }

				if (optimum)
				{
					IDictionary<int, int> weightMap = new Dictionary<int, int>();
					try
					{
						string[] split = matcher.Groups[4].Value.Split(' ');
						int level = split.Length;
						foreach (String weight in split)
							weightMap[level--] = int.Parse(weight);
					}
					catch (System.FormatException e)
					{
						Console.WriteLine(e.ToString());
						Console.Write(e.StackTrace);
					}
					answersets.Add(new AnswerSet(answerSetList, weightMap));
				}
				else
					answersets.Add(new AnswerSet(answerSetList));

        matcher = matcher.NextMatch();
      }
		}
	}
}