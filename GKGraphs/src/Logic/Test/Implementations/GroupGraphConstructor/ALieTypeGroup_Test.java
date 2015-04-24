package Logic.Test.Implementations.GroupGraphConstructor;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.google.common.collect.Lists;

import Logic.Kernel.Graph.Edge;
import Logic.Kernel.Graph.PrimeNumberGraph;
import Logic.Kernel.Graph.SimpleVertex;
import Logic.Kernel.Graph.Vertex;
import Logic.Test.Implementations.ATypableConcrete;

public class ALieTypeGroup_Test extends AbstractLieTypeGroup_Test implements ATypableConcrete {
	
	private static final String NAME_1 = "A_2(3)";
	private static final String NAME_2 = "A_2(17)";
	private static final String NAME_3 = "A_1(1024)";
	
	@Test
	public void testG1() {
		super.determineGroupWithGraph(NAME_1);
		List<Edge> eList = Lists.newArrayList();
		List<Vertex<?>> vList = computeVList();
		eList.add(new Edge(new SimpleVertex(2), new SimpleVertex(3)));
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
		PrimeNumberGraph gr = new PrimeNumberGraph(vList, eList);
		Assert.assertTrue(gr.equals(graph));
	}
	
	@Test
	public void testG3() {
		super.determineGroupWithGraph(NAME_3);
		List<Edge> eList = Lists.newArrayList();
		List<Vertex<?>> vList = computeVList();
		eList.add(new Edge(new SimpleVertex(3), new SimpleVertex(11)));
		eList.add(new Edge(new SimpleVertex(3), new SimpleVertex(31)));
		eList.add(new Edge(new SimpleVertex(5), new SimpleVertex(41)));
		eList.add(new Edge(new SimpleVertex(11), new SimpleVertex(31)));
		PrimeNumberGraph gr = new PrimeNumberGraph(vList, eList);
		Assert.assertTrue(gr.equals(graph));
	}
	
	@Test
	public void testA_4_7() {
		super.determineGroupWithGraph(A_4_7);
		PrimeNumberGraph gr = super.getParsedPrimeNumberGraph(V_A_4_7, E_A_4_7);
		Assert.assertTrue(gr.equals(graph));
	}
	
	// =================================6-PRIMES=GROUPS=================================
	
	@Test
	public void testA_5_3() {
		Assert.assertTrue(super.checkEquality(A_5_3, V_A_5_3, E_A_5_3));
	}
	
	@Test
	public void testA_6_2() {
		Assert.assertTrue(super.checkEquality(A_6_2, V_A_6_2, E_A_6_2));
	}
	
	@Test
	public void testA_2_1024() {
		Assert.assertTrue(super.checkEquality(A_1_1024, V_A_1_1024, E_A_1_1024));
	}
	
	@Test
	public void testA_2_65536() {
		// FIXME неудача (выход за границы int порядка группы)
		//Assert.assertTrue(super.checkEquality(A_1_65536, V_A_1_65536, E_A_1_65536));
	}
	
	@Test
	public void testA_2_729() {
		Assert.assertTrue(super.checkEquality(A_1_729, V_A_1_729, E_A_1_729));
	}
	
	@Test
	public void testA_2_14641() {
		Assert.assertTrue(super.checkEquality(A_1_14641, V_A_1_14641, E_A_1_14641));
	}
	
	@Test
	public void testA_2_6561() {
		Assert.assertTrue(super.checkEquality(A_1_6561, V_A_1_6561, E_A_1_6561));
	}
	
	@Test
	public void testA_2_3125() {
		Assert.assertTrue(super.checkEquality(A_1_3125, V_A_1_3125, E_A_1_3125));
	}
	
	@Test
	public void testA_2_4913() {
		Assert.assertTrue(super.checkEquality(A_1_4913, V_A_1_4913, E_A_1_4913));
	}
	
	@Test
	public void testA_2_83521() {
		Assert.assertTrue(super.checkEquality(A_1_83521, V_A_1_83521, E_A_1_83521));
	}
	
	@Test
	public void testA_2_16() {
		Assert.assertTrue(super.checkEquality(A_2_16, V_A_2_16, E_A_2_16));
	}
	
	@Test
	public void testA_2_128() {
		Assert.assertTrue(super.checkEquality(A_2_128, V_A_2_128, E_A_2_128));
	}
	
	@Test
	public void testA_2_512() {
		Assert.assertTrue(super.checkEquality(A_2_512, V_A_2_512, E_A_2_512));
	}
	
	@Test
	public void testA_2_25() {
		Assert.assertTrue(super.checkEquality(A_2_25, V_A_2_25, E_A_2_25));
	}
	
	@Test
	public void testA_2_49() {
		Assert.assertTrue(super.checkEquality(A_2_49, V_A_2_49, E_A_2_49));
	}
	
	@Test
	public void testA_3_8() {
		Assert.assertTrue(super.checkEquality(A_3_8, V_A_3_8, E_A_3_8));
	}
	
	@Test
	public void testA_3_9() {
		Assert.assertTrue(super.checkEquality(A_3_9, V_A_3_9, E_A_3_9));
	}
	
	@Test
	public void testA_3_17() {
		Assert.assertTrue(super.checkEquality(A_3_17, V_A_3_17, E_A_3_17));
	}
	
}