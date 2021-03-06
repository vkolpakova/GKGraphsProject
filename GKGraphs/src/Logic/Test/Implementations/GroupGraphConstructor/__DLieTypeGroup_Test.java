package Logic.Test.Implementations.GroupGraphConstructor;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.google.common.collect.Lists;

import Logic.Kernel.Graph.Edge;
import Logic.Kernel.Graph.PrimeNumberGraph;
import Logic.Kernel.Graph.SimpleVertex;
import Logic.Kernel.Graph.Vertex;
import Logic.Test.Implementations.__DTypableConcrete;

public class __DLieTypeGroup_Test extends AbstractLieTypeGroup_Test implements __DTypableConcrete {
	
	private static final String NAME_1 = "__D_4(2)";
	private static final String NAME_2 = "__D_4(4)";
	private static final String NAME_3 = "__D_4(5)";
	
	@Test
	public void testG1() {
		super.determineGroupWithGraph(NAME_1);
		List<Edge> eList = Lists.newArrayList();
		List<Vertex<?>> vList = computeVList();
		eList.add(new Edge(new SimpleVertex(2), new SimpleVertex(3)));
		eList.add(new Edge(new SimpleVertex(2), new SimpleVertex(7)));
		eList.add(new Edge(new SimpleVertex(3), new SimpleVertex(7)));
		PrimeNumberGraph gr = new PrimeNumberGraph(vList, eList);
		Assert.assertTrue(gr.equals(graph));
	}
	
	@Test
	public void testG2() {
		super.determineGroupWithGraph(NAME_2);
		List<Edge> eList = Lists.newArrayList();
		List<Vertex<?>> vList = computeVList();
		eList.add(new Edge(new SimpleVertex(2), new SimpleVertex(3)));
		eList.add(new Edge(new SimpleVertex(2), new SimpleVertex(5)));
		eList.add(new Edge(new SimpleVertex(2), new SimpleVertex(7)));
		eList.add(new Edge(new SimpleVertex(2), new SimpleVertex(13)));
		eList.add(new Edge(new SimpleVertex(3), new SimpleVertex(5)));
		eList.add(new Edge(new SimpleVertex(3), new SimpleVertex(7)));
		eList.add(new Edge(new SimpleVertex(3), new SimpleVertex(13)));
		eList.add(new Edge(new SimpleVertex(5), new SimpleVertex(7)));
		eList.add(new Edge(new SimpleVertex(5), new SimpleVertex(13)));
		PrimeNumberGraph gr = new PrimeNumberGraph(vList, eList);
		Assert.assertTrue(gr.equals(graph));
	}
	
	@Test
	public void testG3() {
		super.determineGroupWithGraph(NAME_3);
		List<Edge> eList = Lists.newArrayList();
		List<Vertex<?>> vList = computeVList();
		eList.add(new Edge(new SimpleVertex(2), new SimpleVertex(3)));
		eList.add(new Edge(new SimpleVertex(2), new SimpleVertex(5)));
		eList.add(new Edge(new SimpleVertex(2), new SimpleVertex(7)));
		eList.add(new Edge(new SimpleVertex(2), new SimpleVertex(31)));
		eList.add(new Edge(new SimpleVertex(3), new SimpleVertex(5)));
		eList.add(new Edge(new SimpleVertex(3), new SimpleVertex(7)));
		eList.add(new Edge(new SimpleVertex(3), new SimpleVertex(31)));
		eList.add(new Edge(new SimpleVertex(5), new SimpleVertex(7)));
		eList.add(new Edge(new SimpleVertex(5), new SimpleVertex(31)));
		PrimeNumberGraph gr = new PrimeNumberGraph(vList, eList);
		Assert.assertTrue(gr.equals(graph));
	}
	
	@Test
	public void test__D_4_4() {
		Assert.assertTrue(super.checkEquality(__D_4_4, V___D_4_4, E___D_4_4));
	}
	
	@Test
	public void test__D_4_5() {
		Assert.assertTrue(super.checkEquality(__D_4_5, V___D_4_5, E___D_4_5));
	}
	
}