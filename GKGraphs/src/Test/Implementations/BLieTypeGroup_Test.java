package Test.Implementations;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.google.common.collect.Lists;

import Kernel.Graph.Edge;
import Kernel.Graph.PrimeNumberGraph;
import Kernel.Graph.SimpleVertex;
import Kernel.Graph.Vertex;

public class BLieTypeGroup_Test extends AbstractLieTypeGroup_Test {
	
	private static final String NAME_1 = "B_2(5)";
	private static final String NAME_2 = "C_2(7)";
	private static final String NAME_3 = "B_4(3)";
	
	@Test
	public void testG1() {
		super.determineGroup(NAME_1);
		List<Edge> eList = Lists.newArrayList();
		List<Vertex<?>> vList = computeVList();
		eList.add(new Edge(new SimpleVertex(2), new SimpleVertex(3)));
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
		eList.add(new Edge(new SimpleVertex(2), new SimpleVertex(7)));
		eList.add(new Edge(new SimpleVertex(3), new SimpleVertex(7)));
		PrimeNumberGraph gr = new PrimeNumberGraph(vList, eList);
		Assert.assertTrue(gr.equals(graph));
	}
	
	@Test
	public void test3() {
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
		PrimeNumberGraph gr = new PrimeNumberGraph(vList, eList);
		Assert.assertTrue(gr.equals(graph));
	}
	
	private static final String C_3_4 		= "C_3(4)";
	private static final String V_C_3_4 	= "2,3,5,7,13,17";
	private static final String E_C_3_4 	= "{2,3},{2,5},{2,17},{3,5},{3,7},{3,13},{3,17},{5,7},{5,13},{5,17}";
	
	@Test
	public void test_C_3_4() {
		// FIXME лишние ребра - {3,13},{5,7}
		Assert.assertTrue(super.checkEquality(C_3_4, V_C_3_4, E_C_3_4));
	}
	
	private static final String C_3_5 		= "C_3(5)";
	private static final String V_C_3_5 	= "2,3,5,7,13,31";
	private static final String E_C_3_5 	= "{2,3},{2,5},{2,13},{2,31},{3,5},{3,7},{3,13},{3,31},{5,13}";
	
	@Test
	public void test_C_3_5() {
		// FIXME лишнее ребро {3,31}
		Assert.assertTrue(super.checkEquality(C_3_5, V_C_3_5, E_C_3_5));
	}
	
	private static final String C_3_7 		= "C_3(7)";
	private static final String V_C_3_7 	= "2,3,5,7,19,43";
	private static final String E_C_3_7 	= "{2,3},{2,5},{2,7},{2,19},{3,5},{3,7},{3,19},{3,43},{5,7}";
	
	@Test
	public void test_C_3_7() {
		// FIXME лишнее ребро {3,43}
		Assert.assertTrue(super.checkEquality(C_3_7, V_C_3_7, E_C_3_7));
	}
	
	private static final String C_4_3 		= "C_4(3)";
	private static final String V_C_4_3 	= "2,3,5,7,13,41";
	private static final String E_C_4_3 	= "{2,3},{2,5},{2,7},{2,13},{3,5},{3,7},{3,13}";
	
	@Test
	public void test_C_4_3() {
		Assert.assertTrue(super.checkEquality(C_4_3, V_C_4_3, E_C_4_3));
	}
	
	private static final String C_2_32 		= "C_2(32)";
	private static final String V_C_2_32 	= "2,3,5,11,31,41";
	private static final String E_C_2_32 	= "{2,3},{2,11},{2,31},{3,11},{3,31},{11,31},{5,41}";
	
	@Test
	public void test_C_2_32() {
		Assert.assertTrue(super.checkEquality(C_2_32, V_C_2_32, E_C_2_32));
	}
	
	private static final String C_2_27 		= "C_2(27)";
	private static final String V_C_2_27 	= "2,3,5,7,13,73";
	private static final String E_C_2_27 	= "{2,3},{2,7},{2,13},{3,7},{3,13},{7,13},{5,73}";
	
	@Test
	public void test_C_2_27() {
		Assert.assertTrue(super.checkEquality(C_2_27, V_C_2_27, E_C_2_27));
	}
	
	private static final String C_2_81 		= "C_2(81)";
	private static final String V_C_2_81 	= "2,3,5,17,41,193";
	private static final String E_C_2_81 	= "{2,3},{2,5},{2,41},{3,5},{3,41},{5,41},{17,193}";
	
	@Test
	public void test_C_2_81() {
		Assert.assertTrue(super.checkEquality(C_2_81, V_C_2_81, E_C_2_81));
	}
	
	private static final String C_2_243 	= "C_2(243)";
	private static final String V_C_2_243 	= "2,3,5,11,61,1181";
	private static final String E_C_2_243 	= "{2,3},{2,11},{2,61},{3,11},{3,61},{11,61},{5,1181}";
	
	@Test
	public void test_C_2_243() {
		Assert.assertTrue(super.checkEquality(C_2_243, V_C_2_243, E_C_2_243));
	}
	
	private static final String C_2_289 	= "C_2(289)";
	private static final String V_C_2_289 	= "2,3,5,17,29,41761";
	private static final String E_C_2_289 	= "{2,3},{2,5},{2,17},{2,29},{3,5},{3,17},{3,29},{5,17},{5,29},{17,29}";
	
	@Test
	public void test_C_2_289() {
		Assert.assertTrue(super.checkEquality(C_2_289, V_C_2_289, E_C_2_289));
	}
	
}