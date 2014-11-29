package Test.Implementations;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.google.common.collect.Lists;

import Kernel.Graph.Edge;
import Kernel.Graph.PrimeNumberGraph;
import Kernel.Graph.Vertex;

public class SzLieTypeGroup_Test extends AbstractLieTypeGroup_Test {
	
	private static final String NAME_1 = "Sz(8)";
	private static final String NAME_2 = "Sz(32)";
	
	@Test
	public void testG1() {
		determineGroup(NAME_1);
		List<Edge> eList = Lists.newArrayList();
		List<Vertex<?>> vList = computeVList();
		PrimeNumberGraph gr = new PrimeNumberGraph(vList, eList);
		Assert.assertTrue(gr.equals(graph));
	}
	
	@Test
	public void testG2() {
		determineGroup(NAME_2);
		List<Edge> eList = Lists.newArrayList();
		List<Vertex<?>> vList = computeVList();
		PrimeNumberGraph gr = new PrimeNumberGraph(vList, eList);
		Assert.assertTrue(gr.equals(graph));
	}
	
}