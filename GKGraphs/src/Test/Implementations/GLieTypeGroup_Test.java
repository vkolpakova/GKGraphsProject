package Test.Implementations;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import Kernel.Graph.Edge;
import Kernel.Graph.PrimeNumberGraph;
import Kernel.Graph.SimpleVertex;

public class GLieTypeGroup_Test extends AbstractLieTypeGroup_Test {
	
	private static final String NAME_1 = "G_2(9)";
	private static final String NAME_2 = "G_2(17)";
	
	@Test
	public void testG1() {
		super.determineGroup(NAME_1);
		List<Edge> eList = new ArrayList<Edge>();
		eList.add(new Edge(new SimpleVertex(2), new SimpleVertex(3)));
		eList.add(new Edge(new SimpleVertex(2), new SimpleVertex(5)));
		eList.add(new Edge(new SimpleVertex(3), new SimpleVertex(5)));
		eList.add(new Edge(new SimpleVertex(7), new SimpleVertex(13)));
		PrimeNumberGraph gr = new PrimeNumberGraph(eList);
		Assert.assertTrue(gr.equals(graph));
	}
	
	@Test
	public void testG2() {
		super.determineGroup(NAME_2);
		List<Edge> eList = new ArrayList<Edge>();
		eList.add(new Edge(new SimpleVertex(2), new SimpleVertex(3)));
		eList.add(new Edge(new SimpleVertex(2), new SimpleVertex(17)));
		eList.add(new Edge(new SimpleVertex(3), new SimpleVertex(7)));
		eList.add(new Edge(new SimpleVertex(3), new SimpleVertex(13)));
		eList.add(new Edge(new SimpleVertex(3), new SimpleVertex(17)));
		eList.add(new Edge(new SimpleVertex(7), new SimpleVertex(13)));
		PrimeNumberGraph gr = new PrimeNumberGraph(eList);
		Assert.assertTrue(gr.equals(graph));
	}
	
}