package it.unical.mat.embasp.specializations.dlv;

import it.unical.mat.embasp.languages.asp.AnswerSets;
import it.unical.mat.embasp.specializations.dlv.parser.DLVParseTreeWalker;

public class DLVAnswerSets extends AnswerSets {
	/** Represent an AnswerSet specific for DLV */

	public DLVAnswerSets(final String answerSets) {
		super(answerSets);
	}

	public DLVAnswerSets(final String out, final String err) {
		super(out, err);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void parse() {
		/*Se ho capito bene, output dovrebbe rappresentare l'output di dlv
		  e answersets dovrebbe rappresentare la lista degli answer set 
		  (quelli racchiusi tra {})*/
		DLVParseTreeWalker.getInstance().walk(answersets, output);
		/*Quando viene invocato questo metodo, l'output viene diviso
		  in base agli answer set, viene creato un oggetto di tipo
		  it.unical.mat.embasp.languages.asp.AnswerSet, nella lista
		  value di quest'ultimo vengono aggiunti i predicati e i pesi
		  (se presenti) e, infine, l'oggetto it.unical.mat.embasp.languages.asp.AnswerSet
		  viene aggiunto ad answersets.*/
	}
}
