package Test.Implementations;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import Kernel.Graph.Edge;
import Kernel.Graph.PrimeNumberGraph;

public class SzLieTypeGroup_Test extends AbstractLieTypeGroup_Test {
	
	private static final String NAME_1 = "Sz(8)";
	private static final String NAME_2 = "Sz(32)";
	
	@Test
	public void testG1() {
		determineGroup(NAME_1);
		List<Edge> eList = new ArrayList<Edge>();
		PrimeNumberGraph gr = new PrimeNumberGraph(eList);
		Assert.assertTrue(gr.equals(graph));
	}
	
	@Test
	public void testG2() {
		determineGroup(NAME_2);
		List<Edge> eList = new ArrayList<Edge>();
		PrimeNumberGraph gr = new PrimeNumberGraph(eList);
		Assert.assertTrue(gr.equals(graph));
	}
	
}