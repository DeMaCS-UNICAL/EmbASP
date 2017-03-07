/**
 *
 */
package it.unical.mat.embasp.specializations.dlv;

import java.io.File;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import it.unical.mat.embasp.base.Handler;
import it.unical.mat.embasp.base.InputProgram;
import it.unical.mat.embasp.languages.asp.ASPInputProgram;
import it.unical.mat.embasp.languages.asp.AnswerSet;
import it.unical.mat.embasp.languages.asp.AnswerSets;
import it.unical.mat.embasp.platforms.desktop.DesktopHandler;
import it.unical.mat.embasp.specializations.dlv.desktop.DLVDesktopService;

public class DLVDesktopServiceTest {

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

	/** Countdown latch */
	private final CountDownLatch lock = new CountDownLatch(1);

	private final int N = 9;

	private final int[][] sudokuMatrix = { { 1, 0, 0, 0, 0, 7, 0, 9, 0 }, { 0, 3, 0, 0, 2, 0, 0, 0, 8 }, { 0, 0, 9, 6, 0, 0, 5, 0, 0 },
			{ 0, 0, 5, 3, 0, 0, 9, 0, 0 }, { 0, 1, 0, 0, 8, 0, 0, 0, 2 }, { 6, 0, 0, 0, 0, 4, 0, 0, 0 }, { 3, 0, 0, 0, 0, 0, 0, 1, 0 },
			{ 0, 4, 1, 0, 0, 0, 0, 0, 7 }, { 0, 0, 7, 0, 0, 0, 3, 0, 0 } };

	private AnswerSets answerSets;

	/**
	 * Taken from https://github.com/DeMaCS-UNICAL/LoIDE
	 *
	 * @return
	 */
	public String getPath() {

		final String OS = System.getProperty("os.name").toLowerCase();
		final StringBuffer path = new StringBuffer();

		path.append("app" + File.separator + "src" + File.separator + "test" + File.separator + "resources" + File.separator + "asp" + File.separator
				+ "executables");
		path.append(File.separator);
		path.append("dlv");
		path.append(File.separator);

		if (OS.indexOf("win") >= 0)
			path.append("dlv.mingw.exe");
		else
			if (OS.indexOf("mac") >= 0)
				path.append("dlv.i386-apple-darwin.bin");
			else
				if (OS.indexOf("nux") >= 0) {
					final String arch = System.getProperty("os.arch");
					if (arch.equals("x86_64"))
						path.append("dlv.x86-64-linux-elf-static.bin");
					else
						path.append("dlv.i386-linux-elf-static.bin");
				}

		System.out.println("Full path: " + path.toString()); // debug string

		return path.toString();

	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void sudokuTest() {
		try {

			final Handler handler = new DesktopHandler(new DLVDesktopService(getPath()));

			final InputProgram inputProgram = new ASPInputProgram();
			for (int i = 0; i < N; i++)
				for (int j = 0; j < N; j++)
					if (sudokuMatrix[i][j] != 0)
						inputProgram.addObjectInput(new Cell(i, j, sudokuMatrix[i][j]));

			inputProgram.addFilesPath("app" + File.separator + "src" + File.separator + "test" + File.separator + "resources" + File.separator + "asp"
					+ File.separator + "sudoku");

			handler.addProgram(inputProgram);

			handler.startAsync(o -> {

				if (!(o instanceof AnswerSets))
					return;

				answerSets = (AnswerSets) o;

				lock.countDown();

			});

			lock.await(50000, TimeUnit.MILLISECONDS);

			Assert.assertNotNull(answerSets);

			Assert.assertTrue("Found error in the Plan\n" + answerSets.getErrors(), answerSets.getErrors().isEmpty());

			if (answerSets.getAnswersets().size() == 0)
				return;
			final AnswerSet as = answerSets.getAnswersets().get(0);
			for (final Object obj : as.getAtoms()) {
				final Cell cell = (Cell) obj;
				sudokuMatrix[cell.getRow()][cell.getColumn()] = cell.getValue();
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(sudokuMatrix[i][j] + " ");
					if (sudokuMatrix[i][j] == 0)
						Assert.fail("Number not valid");
				}
				System.out.println();
			}
		} catch (final Exception e) {
			Assert.fail("Exception " + e.getMessage());
		}

	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

}
