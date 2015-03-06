package Test.Implementations.GroupGraphConstructor;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.google.common.collect.Lists;

import Kernel.Graph.Edge;
import Kernel.Graph.PrimeNumberGraph;
import Kernel.Graph.SimpleVertex;
import Kernel.Graph.Vertex;
import Test.Implementations.BTypableConcrete;

public class BLieTypeGroup_Test extends AbstractLieTypeGroup_Test implements BTypableConcrete {
	
	private static final String NAME_1 = "B_2(5)";
	private static final String NAME_2 = "C_2(7)";
	private static final String NAME_3 = "B_4(3)";
	
	@Test
	public void testG1() {
		super.determineGroupWithGraph(NAME_1);
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
		super.determineGroupWithGraph(NAME_2);
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
		super.determineGroupWithGraph(NAME_3);
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
	
	@Test
	public void test_C_3_4() {
		Assert.assertTrue(super.checkEquality(C_3_4, V_C_3_4, E_C_3_4));
	}
	
	@Test
	public void test_C_3_5() {
		Assert.assertTrue(super.checkEquality(C_3_5, V_C_3_5, E_C_3_5));
	}
	
	@Test
	public void test_C_3_7() {
		Assert.assertTrue(super.checkEquality(C_3_7, V_C_3_7, E_C_3_7));
	}
	
	@Test
	public void test_C_4_3() {
		Assert.assertTrue(super.checkEquality(C_4_3, V_C_4_3, E_C_4_3));
	}
	
	@Test
	public void test_C_2_32() {
		Assert.assertTrue(super.checkEquality(C_2_32, V_C_2_32, E_C_2_32));
	}
	
	@Test
	public void test_C_2_27() {
		Assert.assertTrue(super.checkEquality(C_2_27, V_C_2_27, E_C_2_27));
	}
	
	@Test
	public void test_C_2_81() {
		Assert.assertTrue(super.checkEquality(C_2_81, V_C_2_81, E_C_2_81));
	}
	
	@Test
	public void test_C_2_243() {
		Assert.assertTrue(super.checkEquality(C_2_243, V_C_2_243, E_C_2_243));
	}
	
	@Test
	public void test_C_2_289() {
		Assert.assertTrue(super.checkEquality(C_2_289, V_C_2_289, E_C_2_289));
	}
	
}