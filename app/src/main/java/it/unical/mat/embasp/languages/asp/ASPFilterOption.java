package it.unical.mat.embasp.asp;

import it.unical.mat.embasp.base.OptionDescriptor;

/** Generic filter option for ASP solver */

public abstract class ASPFilterOption extends OptionDescriptor {
	public ASPFilterOption() {
		super("-filter=");
	}
}
