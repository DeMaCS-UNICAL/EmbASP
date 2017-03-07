/**
 *
 */
package it.unical.mat.embasp.language.pddl;

import java.lang.reflect.InvocationTargetException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import it.unical.mat.embasp.languages.IllegalAnnotationException;
import it.unical.mat.embasp.languages.ObjectNotValidException;
import it.unical.mat.embasp.languages.pddl.PDDLMapper;
import it.unical.mat.embasp.specializations.solver_planning_domains.PickUp;

public class PDDLMapperTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {

		final PDDLMapper instance = PDDLMapper.getInstance();

		try {

			instance.registerClass(PickUp.class);

			final Object object = instance.getObject("(pick-up b)");

			Assert.assertTrue(object instanceof PickUp);

			Assert.assertEquals("b", ((PickUp) object).getBlock());

		} catch (ObjectNotValidException | IllegalAnnotationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException | InstantiationException e) {
			Assert.fail(e.getMessage());
		}

	}

}
