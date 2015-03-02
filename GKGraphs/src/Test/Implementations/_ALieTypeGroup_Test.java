package Test.Implementations;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.google.common.collect.Lists;

import Kernel.Graph.Edge;
import Kernel.Graph.PrimeNumberGraph;
import Kernel.Graph.SimpleVertex;
import Kernel.Graph.Vertex;

public class _ALieTypeGroup_Test extends AbstractLieTypeGroup_Test {
	
	private static final String NAME_1 = "_A_2(4)";
	private static final String NAME_2 = "_A_2(9)";
	private static final String NAME_3 = "_A_4(5)";
	
	@Test
	public void testG1() {
		super.determineGroup(NAME_1);
		List<Edge> eList = Lists.newArrayList();
		List<Vertex<?>> vList = computeVList();
		eList.add(new Edge(new SimpleVertex(2), new SimpleVertex(5)));
		eList.add(new Edge(new SimpleVertex(3), new SimpleVertex(5)));
		PrimeNumberGraph gr = new PrimeNumberGraph(vList, eList);
		Assert.assertTrue(gr.equals(graph));
	}
	
	@Test
	public void testG2() {
		super.determineGroup(NAME_2);
		List<Edge> eList = Lists.newArrayList();
		List<Vertex<?>> vList = computeVList();
		eList.add(new Edge(new SimpleVertex(2), new SimpleVertex(3)));
		eList.add(new Edge(new SimpleVertex(2), new SimpleVertex(5)));
		eList.add(new Edge(new SimpleVertex(3), new SimpleVertex(5)));
		PrimeNumberGraph gr = new PrimeNumberGraph(vList, eList);
		Assert.assertTrue(gr.equals(graph));
	}
	
	@Test
	public void testG3() {
		super.determineGroup(NAME_3);
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
		PrimeNumberGraph gr = new PrimeNumberGraph(vList, eList);
		Assert.assertTrue(gr.equals(graph));
	}
	
	private static final String _A_4_4 		= "_A_4(4)";
	private static final String V__A_4_4 	= "2,3,5,13,17,41";
	private static final String E__A_4_4 	= "{2,3},{2,5},{2,13},{3,5},{3,13},{3,17},{5,13}";
	
	@Test
	public void test__A_4_4() {
		Assert.assertTrue(super.checkEquality(_A_4_4, V__A_4_4, E__A_4_4));
	}
	
	private static final String _A_4_5 		= "_A_4(5)";
	private static final String V__A_4_5 	= "2,3,5,7,13,521";
	private static final String E__A_4_5 	= "{2,3},{2,5},{2,7},{2,13},{3,5},{3,7},{3,13},{5,7}";
	
	@Test
	public void test__A_4_5() {
		Assert.assertTrue(super.checkEquality(_A_4_5, V__A_4_5, E__A_4_5));
	}
	
	private static final String _A_4_9 		= "_A_4(9)";
	private static final String V__A_4_9 	= "2,3,5,41,73,1181";
	private static final String E__A_4_9 	= "{2,3},{2,5},{2,41},{2,73},{3,5},{3,73},{5,73}";
	
	@Test
	public void test__A_4_9() {
		Assert.assertTrue(super.checkEquality(_A_4_9, V__A_4_9, E__A_4_9));
	}
	
	private static final String _A_5_3 		= "_A_5(3)";
	private static final String V__A_5_3 	= "2,3,5,7,13,61";
	private static final String E__A_5_3 	= "{2,3},{2,5},{2,7},{2,13},{3,5},{3,7},{3,13},{7,13}";
	
	@Test
	public void test__A_5_3() {
		// FIXME неудача -  лишнее ребро ({3,13})
		Assert.assertTrue(super.checkEquality(_A_5_3, V__A_5_3, E__A_5_3));
	}
	
}