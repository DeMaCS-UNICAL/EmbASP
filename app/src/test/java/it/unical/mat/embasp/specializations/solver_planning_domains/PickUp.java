/**
 *
 */
package it.unical.mat.embasp.specializations.solver_planning_domains;

import it.unical.mat.embasp.languages.Id;
import it.unical.mat.embasp.languages.Param;

@Id("pick-up")
public class PickUp {

	@Param(0)
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
