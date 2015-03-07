package Test.Implementations.GroupGraphConstructor;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.google.common.collect.Lists;

import Kernel.Graph.Edge;
import Kernel.Graph.PrimeNumberGraph;
import Kernel.Graph.SimpleVertex;
import Kernel.Graph.Vertex;
import Test.Implementations.GTypableConcrete;

public class GLieTypeGroup_Test extends AbstractLieTypeGroup_Test implements GTypableConcrete {
	
	private static final String NAME_1 = "G_2(9)";
	private static final String NAME_2 = "G_2(17)";
	
	@Test
	public void testG1() {
		super.determineGroupWithGraph(NAME_1);
		List<Edge> eList = Lists.newArrayList();
		List<Vertex<?>> vList = computeVList();
		eList.add(new Edge(new SimpleVertex(2), new SimpleVertex(3)));
		eList.add(new Edge(new SimpleVertex(2), new SimpleVertex(5)));
		eList.add(new Edge(new SimpleVertex(3), new SimpleVertex(5)));
		eList.add(new Edge(new SimpleVertex(7), new SimpleVertex(13)));
		PrimeNumberGraph gr = new PrimeNumberGraph(vList, eList);
		Assert.assertTrue(gr.equals(graph));
	}
	
	@Test
	public void testG2() {
		super.determineGroupWithGraph(NAME_2);
		List<Edge> eList = Lists.newArrayList();
		List<Vertex<?>> vList = computeVList();
		eList.add(new Edge(new SimpleVertex(2), new SimpleVertex(3)));
		eList.add(new Edge(new SimpleVertex(2), new SimpleVertex(17)));
		eList.add(new Edge(new SimpleVertex(3), new SimpleVertex(7)));
		eList.add(new Edge(new SimpleVertex(3), new SimpleVertex(13)));
		eList.add(new Edge(new SimpleVertex(3), new SimpleVertex(17)));
		eList.add(new Edge(new SimpleVertex(7), new SimpleVertex(13)));
		PrimeNumberGraph gr = new PrimeNumberGraph(vList, eList);
		Assert.assertTrue(gr.equals(graph));
	}
	
	@Test
	public void testG_2_9() {
		Assert.assertTrue(super.checkEquality(G_2_9, V_G_2_9, E_G_2_9));
	}
	
	@Test
	public void testG_2_17() {
		Assert.assertTrue(super.checkEquality(G_2_17, V_G_2_17, E_G_2_17));
	}
	
}