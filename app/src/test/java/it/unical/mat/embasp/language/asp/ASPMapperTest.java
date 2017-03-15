/**
 *
 */
package it.unical.mat.embasp.language.asp;

import java.lang.reflect.InvocationTargetException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import it.unical.mat.embasp.languages.IllegalAnnotationException;
import it.unical.mat.embasp.languages.ObjectNotValidException;
import it.unical.mat.embasp.languages.asp.ASPMapper;
import it.unical.mat.embasp.languages.asp.IllegalTermException;
import it.unical.mat.embasp.specializations.dlv.Cell;

public class ASPMapperTest {

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

		final ASPMapper instance = ASPMapper.getInstance();

		try {

			instance.registerClass(Cell.class);

			final Object object = instance.getObject("cell(1,2,5)");

			Assert.assertTrue(object instanceof Cell);

			Assert.assertEquals(1, ((Cell) object).getRow());
			Assert.assertEquals(2, ((Cell) object).getColumn());
			Assert.assertEquals(5, ((Cell) object).getValue());

			Assert.assertEquals("cell(1,2,5)", instance.getString(object));

			instance.unregisterClass(Cell.class);
			
			final Object nullObject = instance.getObject("cell(1,2,5)");
			
			Assert.assertNull(nullObject);
			
			instance.registerClass(Arity0.class);
			
			final Object object1= instance.getObject("a");
			
			Assert.assertNotNull(object1);
			Assert.assertTrue(object1 instanceof Arity0);
			Assert.assertEquals("a", instance.getString(object1));

		} catch (ObjectNotValidException | IllegalAnnotationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException | InstantiationException | IllegalTermException e) {
			Assert.fail(e.getMessage());
		}

	}

}
