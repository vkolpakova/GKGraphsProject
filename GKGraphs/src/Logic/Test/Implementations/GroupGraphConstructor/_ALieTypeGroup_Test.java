package Logic.Test.Implementations.GroupGraphConstructor;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.google.common.collect.Lists;

import Logic.Kernel.Graph.Edge;
import Logic.Kernel.Graph.PrimeNumberGraph;
import Logic.Kernel.Graph.SimpleVertex;
import Logic.Kernel.Graph.Vertex;
import Logic.Test.Implementations._ATypableConcrete;

public class _ALieTypeGroup_Test extends AbstractLieTypeGroup_Test implements _ATypableConcrete {
	
	private static final String NAME_1 = "_A_2(4)";
	private static final String NAME_2 = "_A_2(9)";
	private static final String NAME_3 = "_A_4(5)";
	
	@Test
	public void testG1() {
		super.determineGroupWithGraph(NAME_1);
		List<Edge> eList = Lists.newArrayList();
		List<Vertex<?>> vList = computeVList();
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
		eList.add(new Edge(new SimpleVertex(2), new SimpleVertex(5)));
		eList.add(new Edge(new SimpleVertex(3), new SimpleVertex(5)));
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
		eList.add(new Edge(new SimpleVertex(2), new SimpleVertex(13)));
		eList.add(new Edge(new SimpleVertex(3), new SimpleVertex(5)));
		eList.add(new Edge(new SimpleVertex(3), new SimpleVertex(7)));
		eList.add(new Edge(new SimpleVertex(3), new SimpleVertex(13)));
		eList.add(new Edge(new SimpleVertex(5), new SimpleVertex(7)));
		PrimeNumberGraph gr = new PrimeNumberGraph(vList, eList);
		Assert.assertTrue(gr.equals(graph));
	}
	
	@Test
	public void test__A_4_4() {
		Assert.assertTrue(super.checkEquality(_A_4_4, V__A_4_4, E__A_4_4));
	}
	
	@Test
	public void test__A_4_5() {
		Assert.assertTrue(super.checkEquality(_A_4_5, V__A_4_5, E__A_4_5));
	}
	
	@Test
	public void test__A_4_9() {
		Assert.assertTrue(super.checkEquality(_A_4_9, V__A_4_9, E__A_4_9));
	}
	
	@Test
	public void test__A_5_3() {
		Assert.assertTrue(super.checkEquality(_A_5_3, V__A_5_3, E__A_5_3));
	}
	
	@Test
	public void test__A_6_2() {
		Assert.assertTrue(super.checkEquality(_A_6_2, V__A_6_2, E__A_6_2));
	}
	
	@Test
	public void test__A_2_512() {
		Assert.assertTrue(super.checkEquality(_A_2_512, V__A_2_512, E__A_2_512));
	}
	
	@Test
	public void test__A_2_27() {
		Assert.assertTrue(super.checkEquality(_A_2_27, V__A_2_27, E__A_2_27));
	}
	
	@Test
	public void test__A_2_125() {
		Assert.assertTrue(super.checkEquality(_A_2_125, V__A_2_125, E__A_2_125));
	}
	
	@Test
	public void test__A_2_625() {
		Assert.assertTrue(super.checkEquality(_A_2_625, V__A_2_625, E__A_2_625));
	}
	
	@Test
	public void test__A_2_49() {
		Assert.assertTrue(super.checkEquality(_A_2_49, V__A_2_49, E__A_2_49));
	}
	
	@Test
	public void test__A_2_343() {
		Assert.assertTrue(super.checkEquality(_A_2_343, V__A_2_343, E__A_2_343));
	}
	
	@Test
	public void test__A_2_289() {
		Assert.assertTrue(super.checkEquality(_A_2_289, V__A_2_289, E__A_2_289));
	}
	
	@Test
	public void test__A_3_8() {
		Assert.assertTrue(super.checkEquality(_A_3_8, V__A_3_8, E__A_3_8));
	}
	
	@Test
	public void test__A_3_16() {
		Assert.assertTrue(super.checkEquality(_A_3_16, V__A_3_16, E__A_3_16));
	}
	
	@Test
	public void test__A_3_25() {
		Assert.assertTrue(super.checkEquality(_A_3_25, V__A_3_25, E__A_3_25));
	}
	
}