package it.unical.mat.embasp.specializations.dlv;

import it.unical.mat.embasp.base.OptionDescriptor;

public class DLVFilterOption extends OptionDescriptor {
    public DLVFilterOption(String initial_option) {
        super("-filter="+initial_option);
    }
}
