package Test.Implementations;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import Kernel.Graph.Edge;
import Kernel.Graph.PrimeNumberGraph;
import Kernel.Graph.SimpleVertex;

public class RiLieTypeGroup_Test extends AbstractLieTypeGroup_Test {
	
	private static final String NAME_1 = "Ri(27)";
	
	@Test
	public void testG1() {
		determineGroup(NAME_1);
		List<Edge> eList = new ArrayList<Edge>();
		eList.add(new Edge(new SimpleVertex(2), new SimpleVertex(3)));
		eList.add(new Edge(new SimpleVertex(2), new SimpleVertex(7)));
		eList.add(new Edge(new SimpleVertex(2), new SimpleVertex(13)));
		PrimeNumberGraph gr = new PrimeNumberGraph(eList);
		Assert.assertTrue(gr.equals(graph));
	}
	
}