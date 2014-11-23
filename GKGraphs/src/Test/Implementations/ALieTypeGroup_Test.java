package Test.Implementations;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import Kernel.Graph.Edge;
import Kernel.Graph.PrimeNumberGraph;
import Kernel.Graph.SimpleVertex;

public class ALieTypeGroup_Test extends AbstractLieTypeGroup_Test {
	
	private static final String NAME_1 = "A_2(3)";
	private static final String NAME_2 = "A_2(17)";
	private static final String NAME_3 = "A_1(1024)";
	
	@Test
	public void testG1() {
		super.determineGroup(NAME_1);
		List<Edge> eList = new ArrayList<Edge>();
		eList.add(new Edge(new SimpleVertex(2), new SimpleVertex(3)));
		PrimeNumberGraph gr = new PrimeNumberGraph(eList);
		Assert.assertTrue(gr.equals(graph));
	}
	
	@Test
	public void testG2() {
		super.determineGroup(NAME_2);
		List<Edge> eList = new ArrayList<Edge>();
		eList.add(new Edge(new SimpleVertex(2), new SimpleVertex(3)));
		eList.add(new Edge(new SimpleVertex(2), new SimpleVertex(17)));
		PrimeNumberGraph gr = new PrimeNumberGraph(eList);
		Assert.assertTrue(gr.equals(graph));
	}
	
	@Test
	public void testG3() {
		super.determineGroup(NAME_3);
		List<Edge> eList = new ArrayList<Edge>();
		eList.add(new Edge(new SimpleVertex(3), new SimpleVertex(11)));
		eList.add(new Edge(new SimpleVertex(3), new SimpleVertex(31)));
		eList.add(new Edge(new SimpleVertex(5), new SimpleVertex(41)));
		eList.add(new Edge(new SimpleVertex(11), new SimpleVertex(31)));
		PrimeNumberGraph gr = new PrimeNumberGraph(eList);
		Assert.assertTrue(gr.equals(graph));
	}
	
}