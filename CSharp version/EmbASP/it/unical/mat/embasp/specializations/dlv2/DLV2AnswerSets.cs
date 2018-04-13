using System;
using System.Collections.Generic;
using System.Text.RegularExpressions;

namespace it.unical.mat.embasp.specializations.dlv2
{

	using AnswerSet = it.unical.mat.embasp.languages.asp.AnswerSet;
	using AnswerSets = it.unical.mat.embasp.languages.asp.AnswerSets;

	public class DLV2AnswerSets : AnswerSets
	{

		public DLV2AnswerSets(string answersets) : base(answersets)
		{
		}

		public DLV2AnswerSets(string @out, string err) : base(@out, err)
		{
		}

		protected internal override void parse()
		{
			bool optimum = output.Contains("OPTIMUM");
			string pattern = !optimum ? ("ANSWER\\r?\\n(.*)") : ("ANSWER\\r?\\n(.*)(\\r?\\nCOST (.+)\\r?\\nOPTIMUM)");

      Regex regex = new Regex(@pattern);
      Match matcher = regex.Match(output);

      while (matcher.Success)
			{

				string patternAnswerSet = ("-?[a-z][A-Za-z0-9_]*(\\(.*?\\))?");
        Regex regexAnswerSet = new Regex(patternAnswerSet);
				Match matcherAnswerSet = regexAnswerSet.Match(matcher.Groups[1].Value);
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
            string[] split = matcher.Groups[3].Value.Split(' '); //GroupNameFromNumber(3).Split(' ');
						foreach (String weightLevel in split)
						{
							string[] weightLevelArray = weightLevel.Split('@');
							weightMap[int.Parse(weightLevelArray[1])] = int.Parse(weightLevelArray[0]);
						}
					}
					catch (System.FormatException e)
					{
						Console.WriteLine(e.ToString());
						Console.Write(e.StackTrace);
					}

					answersets.Add(new AnswerSet(answerSetList, weightMap));

				}
				else
				{
					answersets.Add(new AnswerSet(answerSetList));
				}

        matcher = matcher.NextMatch();
      }

		}

	}

}