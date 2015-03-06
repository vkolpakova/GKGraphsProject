package Test.Implementations.GroupGraphConstructor;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.google.common.collect.Lists;

import Kernel.Graph.Edge;
import Kernel.Graph.PrimeNumberGraph;
import Kernel.Graph.SimpleVertex;
import Kernel.Graph.Vertex;
import Test.Implementations.DTypableConcrete;

public class DLieTypeGroup_Test extends AbstractLieTypeGroup_Test implements DTypableConcrete {
	
	private static final String NAME_1 = "D_5(2)";
	
	@Test
	public void testG1() {
		determineGroupWithGraph(NAME_1);
		List<Edge> eList = Lists.newArrayList();
		List<Vertex<?>> vList = computeVList();
		eList.add(new Edge(new SimpleVertex(2), new SimpleVertex(3)));
		eList.add(new Edge(new SimpleVertex(2), new SimpleVertex(5)));
		eList.add(new Edge(new SimpleVertex(2), new SimpleVertex(7)));
		eList.add(new Edge(new SimpleVertex(3), new SimpleVertex(5)));
		eList.add(new Edge(new SimpleVertex(3), new SimpleVertex(7)));
		eList.add(new Edge(new SimpleVertex(3), new SimpleVertex(17)));
		PrimeNumberGraph gr = new PrimeNumberGraph(vList, eList);
		Assert.assertTrue(gr.equals(graph));
	}
	
	@Test
	public void testD_4_4() {
		Assert.assertTrue(super.checkEquality(D_4_4, V_D_4_4, E_D_4_4));
	}
	
	@Test
	public void testD_4_5() {
		Assert.assertTrue(super.checkEquality(D_4_5, V_D_4_5, E_D_4_5));
	}
	
	@Test
	public void testD_4_7() {
		Assert.assertTrue(super.checkEquality(D_4_7, V_D_4_7, E_D_4_7));
	}
	
	@Test
	public void testD_5_2() {
		Assert.assertTrue(super.checkEquality(D_5_2, V_D_5_2, E_D_5_2));
	}
	
}