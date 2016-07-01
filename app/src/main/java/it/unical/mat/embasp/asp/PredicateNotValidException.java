package it.unical.mat.embasp.asp;

public class PredicateNotValidException extends Exception{

    public PredicateNotValidException(){
        super("Value of predicate is not valid");
    }
}
