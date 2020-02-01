package it.unical.mat.embasp.specializations.dlv2;

import java.io.File;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import it.unical.mat.embasp.languages.asp.ASPInputProgram;
import it.unical.mat.embasp.languages.asp.ASPMapper;
import it.unical.mat.embasp.languages.asp.AnswerSet;
import it.unical.mat.embasp.platforms.desktop.DesktopHandler;
import it.unical.mat.embasp.specializations.dlv2.desktop.DLV2DesktopService;


class DLV2DesktopServiceTest {

	private static int from, to;
	private static ArrayList<Integer> sortedPath;

	@Test
	void shortestPathTest() {

		try {

			DesktopHandler handler = new DesktopHandler(new DLV2DesktopService(getPath()));

			ASPMapper.getInstance().registerClass(Edge.class);
			ASPMapper.getInstance().registerClass(Path.class);
			ASPMapper.getInstance().registerClass(From.class);
			ASPMapper.getInstance().registerClass(To.class);

			ASPInputProgram input = new ASPInputProgram();

			from = 0;   // source node
			to = 7;     // destination node

			input.addProgram("from(" + from + "). to(" + to + ").");

			input.addFilesPath(".." + File.separator + ".." + File.separator + "test-resources"
					+ File.separator + "asp" + File.separator + "shortestPath");

			for(Edge edge : getEdges()) {
				input.addObjectInput(edge);
			}

			handler.addProgram(input);

			DLV2AnswerSets answerSets = (DLV2AnswerSets) handler.startSync();
			
			Assert.assertNotNull("answerSets is null", answerSets);
			Assert.assertEquals(1, answerSets.getOptimalAnswerSets().size());

			AnswerSet answerSet = answerSets.getOptimalAnswerSets().get(0);

			ArrayList<Path> path = new ArrayList<Path>();  // edges in the shortest path (unsorted)
			int sum = 0;    // total weight of the path

			for(Object obj : answerSet.getAtoms()) {
				if(obj instanceof Path) {
					path.add((Path)obj);
					sum += ((Path)obj).getWeight();
				}
			}

			sortedPath = new ArrayList<Integer>();    // edges in the shorted path (sorted)
			sortedPath.add(from);

			join(from,path,sortedPath);   // sorts the edges	
			print(sortedPath,sum);        // show the result

			ArrayList<Integer> result = getResult();
			for(int i=0; i<sortedPath.size(); i++)
				Assert.assertEquals(sortedPath.get(i), result.get(i));
			Assert.assertEquals(5, sum);

		} catch (Exception e) {
			Assert.fail("Exception " + e.getMessage());
		}

	}

	private static ArrayList<Edge> getEdges() {
		ArrayList<Edge> edges = new ArrayList<Edge>();

		edges.add(new Edge(0,1,1));
		edges.add(new Edge(0,2,4));
		edges.add(new Edge(1,2,2));
		edges.add(new Edge(1,3,4));
		edges.add(new Edge(1,4,1));
		edges.add(new Edge(2,4,4));
		edges.add(new Edge(3,5,6));
		edges.add(new Edge(3,6,1));
		edges.add(new Edge(4,3,1));
		edges.add(new Edge(6,4,5));
		edges.add(new Edge(6,5,9));
		edges.add(new Edge(6,7,1));
		edges.add(new Edge(7,5,2));

		return edges;
	}

	private static ArrayList<Integer> getResult() {
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		result.add(0);
		result.add(1);
		result.add(4);
		result.add(3);
		result.add(6);
		result.add(7);
		
		return result;
	}
	
	private static void join(int from, ArrayList<Path> path, ArrayList<Integer> sortedPath) {
		for(Path p : path) {
			if(p.getFrom() == from) {
				sortedPath.add(p.getTo());
				if(p.getTo() == to) {
					return;
				}
				join(p.getTo(), path, sortedPath);
				return;
			}
		}
	}

	private static void print(ArrayList<Integer> path, int sum) {
		boolean first = true;
		System.out.print("path = ");
		for(int n : path) {
			if(!first)
				System.out.print(" - ");
			else
				first = false;
			System.out.print(n);
		}
		System.out.println("\nsum = " + sum);
	}

	public String getPath() {

		String os = System.getProperty("os.name").toLowerCase();
		String arch = System.getProperty("os.arch");

		StringBuffer path = new StringBuffer();

		path.append(".." + File.separator + ".." + File.separator + "test-resources" + File.separator + "asp"); 
		path.append(File.separator + "executables" + File.separator + "dlv2" + File.separator);

		if(os.indexOf("nux") >= 0)
			if(arch.indexOf("64") >= 0)
				path.append("dlv2.linux.64");
			else
				path.append("dlv2.linux.32");
		else
			if(os.indexOf("win") >= 0)
				if(arch.indexOf("64") >= 0)
					path.append("dlv2.win.64");
				else
					path.append("dlv2.win.32");
			else
				if(os.indexOf("mac") >= 0)
					path.append("dlv2.mac");

		return path.toString();

	}

}
