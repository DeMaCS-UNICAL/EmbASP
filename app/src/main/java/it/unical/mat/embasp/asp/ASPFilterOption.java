package it.unical.mat.embasp.asp;

import it.unical.mat.embasp.base.OptionDescriptor;

public class ASPFilterOption extends OptionDescriptor {
    public ASPFilterOption(String initial_option) {
        super("-filter="+initial_option);
    }
}
