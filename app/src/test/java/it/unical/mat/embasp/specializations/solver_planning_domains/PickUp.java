/**
 *
 */
package it.unical.mat.embasp.specializations.solver_planning_domains;

import it.unical.mat.embasp.languages.Predicate;
import it.unical.mat.embasp.languages.Term;

@Predicate("pick-up")
public class PickUp {

	@Term(0)
	private String block;

	/**
	 *
	 */
	public PickUp() {
	}

	/**
	 * @return the block
	 */
	public String getBlock() {
		return block;
	}

	/**
	 * @param block
	 *            the block to set
	 */
	public void setBlock(final String block) {
		this.block = block;
	}

}
