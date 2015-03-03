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
		// FIXME лишнее ребро ({3,13})
		Assert.assertTrue(super.checkEquality(_A_5_3, V__A_5_3, E__A_5_3));
	}
	
	private static final String _A_6_2 		= "_A_6(2)";
	private static final String V__A_6_2 	= "2,3,5,7,11,43";
	private static final String E__A_6_2 	= "{2,3},{2,5},{2,7},{2,11},{3,5},{3,7},{3,11},{5,7}";
	
	@Test
	public void test__A_6_2() {
		// FIXME лишнее ребро ({2,7},{5,7})
		Assert.assertTrue(super.checkEquality(_A_6_2, V__A_6_2, E__A_6_2));
	}
	
	private static final String _A_2_512 	= "_A_2(512)";
	private static final String V__A_2_512 	= "2,3,7,19,73,87211";
	private static final String E__A_2_512 	= "{2,3},{2,19},{3,7},{3,19},{3,73},{7,19},{7,73},{19,73}";
	
	@Test
	public void test__A_2_512() {
		Assert.assertTrue(super.checkEquality(_A_2_512, V__A_2_512, E__A_2_512));
	}
	
	private static final String _A_2_27 	= "_A_2(27)";
	private static final String V__A_2_27 	= "2,3,7,13,19,37";
	private static final String E__A_2_27 	= "{2,3},{2,7},{2,13},{3,7},{7,13},{19,37}";
	
	@Test
	public void test__A_2_27() {
		Assert.assertTrue(super.checkEquality(_A_2_27, V__A_2_27, E__A_2_27));
	}
	
	private static final String _A_2_125 	= "_A_2(125)";
	private static final String V__A_2_125 	= "2,3,5,7,31,5167";
	private static final String E__A_2_125 	= "{2,3},{2,5},{2,7},{2,31},{3,5},{3,7},{3,31},{5,7},{7,31}}";
	
	@Test
	public void test__A_2_125() {
		Assert.assertTrue(super.checkEquality(_A_2_125, V__A_2_125, E__A_2_125));
	}
	
	private static final String _A_2_625 	= "_A_2(625)";
	private static final String V__A_2_625 	= "2,3,5,13,313,390001";
	private static final String E__A_2_625 	= "{2,3},{2,5},{2,13},{2,313},{3,13},{3,313},{5,313},{13,313}";
	
	@Test
	public void test__A_2_625() {
		Assert.assertTrue(super.checkEquality(_A_2_625, V__A_2_625, E__A_2_625));
	}
	
	private static final String _A_2_49 	= "_A_2(49)";
	private static final String V__A_2_49 	= "2,3,5,7,13,181";
	private static final String E__A_2_49 	= "{2,3},{2,5},{2,7},{3,5},{5,7},{13,181}";
	
	@Test
	public void test__A_2_49() {
		Assert.assertTrue(super.checkEquality(_A_2_49, V__A_2_49, E__A_2_49));
	}
	
	private static final String _A_2_343 	= "_A_2(343)";
	private static final String V__A_2_343 	= "2,3,7,19,43,117307";
	private static final String E__A_2_343 	= "{2,3},{2,7},{2,19},{2,43},{3,19},{3,43},{7,43},{19,43}";
	
	@Test
	public void test__A_2_343() {
		Assert.assertTrue(super.checkEquality(_A_2_343, V__A_2_343, E__A_2_343));
	}
	
	private static final String _A_2_289 	= "_A_2(289)";
	private static final String V__A_2_289 	= "2,3,5,17,29,83233";
	private static final String E__A_2_289 	= "{2,3},{2,5},{2,17},{2,29},{3,5},{3,29},{5,17},{5,29},{17,29}";
	
	@Test
	public void test__A_2_289() {
		Assert.assertTrue(super.checkEquality(_A_2_289, V__A_2_289, E__A_2_289));
	}
	
	private static final String _A_3_8 		= "_A_3(8)";
	private static final String V__A_3_8 	= "2,3,5,7,13,19";
	private static final String E__A_3_8 	= "{2,3},{2,13},{3,7},{3,19},{5,7},{5,13},{7,13}";
	
	@Test
	public void test__A_3_8() {
		// FIXME неуспех - вместо ребра {2,13} - {2,7}
		Assert.assertTrue(super.checkEquality(_A_3_8, V__A_3_8, E__A_3_8));
	}
	
	private static final String _A_3_16 	= "_A_3(16)";
	private static final String V__A_3_16 	= "2,3,5,17,241,257";
	private static final String E__A_3_16 	= "{2,3},{2,5},{2,17},{3,5},{3,5},{3,257},{5,17},{5,257},{17,241}";
	
	@Test
	public void test__A_3_16() {
		Assert.assertTrue(super.checkEquality(_A_3_16, V__A_3_16, E__A_3_16));
	}
	
	private static final String _A_3_25 	= "_A_3(25)";
	private static final String V__A_3_25 	= "2,3,5,13,313,601";
	private static final String E__A_3_25 	= "{2,3},{2,5},{2,13},{2,313},{3,5},{3,13},{3,313},{5,13},{13,601}";
	
	@Test
	public void test__A_3_25() {
		Assert.assertTrue(super.checkEquality(_A_3_25, V__A_3_25, E__A_3_25));
	}
	
}