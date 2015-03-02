package Test.Implementations;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.google.common.collect.Lists;

import Kernel.Graph.Edge;
import Kernel.Graph.PrimeNumberGraph;
import Kernel.Graph.SimpleVertex;
import Kernel.Graph.Vertex;

public class ALieTypeGroup_Test extends AbstractLieTypeGroup_Test {
	
	private static final String NAME_1 = "A_2(3)";
	private static final String NAME_2 = "A_2(17)";
	private static final String NAME_3 = "A_1(1024)";
	
	@Test
	public void testG1() {
		super.determineGroup(NAME_1);
		List<Edge> eList = Lists.newArrayList();
		List<Vertex<?>> vList = computeVList();
		eList.add(new Edge(new SimpleVertex(2), new SimpleVertex(3)));
		PrimeNumberGraph gr = new PrimeNumberGraph(vList, eList);
		Assert.assertTrue(gr.equals(graph));
	}
	
	@Test
	public void testG2() {
		super.determineGroup(NAME_2);
		List<Edge> eList = Lists.newArrayList();
		List<Vertex<?>> vList = computeVList();
		eList.add(new Edge(new SimpleVertex(2), new SimpleVertex(3)));
		eList.add(new Edge(new SimpleVertex(2), new SimpleVertex(17)));
		PrimeNumberGraph gr = new PrimeNumberGraph(vList, eList);
		Assert.assertTrue(gr.equals(graph));
	}
	
	@Test
	public void testG3() {
		super.determineGroup(NAME_3);
		List<Edge> eList = Lists.newArrayList();
		List<Vertex<?>> vList = computeVList();
		eList.add(new Edge(new SimpleVertex(3), new SimpleVertex(11)));
		eList.add(new Edge(new SimpleVertex(3), new SimpleVertex(31)));
		eList.add(new Edge(new SimpleVertex(5), new SimpleVertex(41)));
		eList.add(new Edge(new SimpleVertex(11), new SimpleVertex(31)));
		PrimeNumberGraph gr = new PrimeNumberGraph(vList, eList);
		Assert.assertTrue(gr.equals(graph));
	}
	
	private static final String A_4_7 = "A_4(7)";
	private static final String V_A_4_7 = "2,3,5,7,19,2801";
	private static final String E_A_4_7 = "{2,3},{2,5},{2,7},{2,19},{3,5},{3,7},{3,19},{7,19}";
	
	@Test
	public void testA_4_7() {
		super.determineGroup(A_4_7);
		PrimeNumberGraph gr = super.getParsedPrimeNumberGraph(V_A_4_7, E_A_4_7);
		Assert.assertTrue(gr.equals(graph));
	}
	
	private static final String A_5_3 = "A_5(3)";
	private static final String V_A_5_3 = "2,3,5,7,11,13";
	private static final String E_A_5_3 = "{2,3},{2,5},{2,13},{3,13},{7,13}";
	
	@Test
	public void testA_5_3() {
		// FIXME неудача
		Assert.assertTrue(super.checkEquality(A_5_3, V_A_5_3, E_A_5_3));
	}
	
	private static final String A_6_2 = "A_6(2)";
	private static final String V_A_6_2 = "2,3,5,7,31,127";
	private static final String E_A_6_2 = "{2,3},{2,5},{2,7},{2,31},{3,5},{3,7},{3,31},{5,7}";
	
	@Test
	public void testA_6_2() {
		Assert.assertTrue(super.checkEquality(A_6_2, V_A_6_2, E_A_6_2));
	}
	
	private static final String A_1_1024 = "A_1(1024)";
	private static final String V_A_1_1024 = "2,3,5,11,31,41";
	private static final String E_A_1_1024 = "{3,11},{3,31},{5,41},{11,31}";
	
	@Test
	public void testA_2_1024() {
		Assert.assertTrue(super.checkEquality(A_1_1024, V_A_1_1024, E_A_1_1024));
	}
	
	private static final String A_1_65536 = "A_1(65536)";
	private static final String V_A_1_65536 = "2,3,5,17,257,65537";
	private static final String E_A_1_65536 = "{3,5},{3,17},{3,257},{5,17},{5,257},{17,257}";
	
	@Test
	public void testA_2_65536() {
		// FIXME неудача (выход за границы int порядка группы)
		Assert.assertTrue(super.checkEquality(A_1_65536, V_A_1_65536, E_A_1_65536));
	}
	
	private static final String A_1_729 = "A_1(729)";
	private static final String V_A_1_729 = "2,3,5,7,13,73";
	private static final String E_A_1_729 = "{2,7},{2,13},{5,73},{7,13}";
	
	@Test
	public void testA_2_729() {
		Assert.assertTrue(super.checkEquality(A_1_729, V_A_1_729, E_A_1_729));
	}
	
	private static final String A_1_6561 = "A_1(6561)";
	private static final String V_A_1_6561 = "2,3,5,17,41,193";
	private static final String E_A_1_6561 = "{2,5},{2,41},{5,41},{17,193}";
	
	@Test
	public void testA_2_6561() {
		Assert.assertTrue(super.checkEquality(A_1_6561, V_A_1_6561, E_A_1_6561));
	}
	
	private static final String A_1_3125 = "A_1(3125)";
	private static final String V_A_1_3125 = "2,3,5,11,71,521";
	private static final String E_A_1_3125 = "{2,11},{2,71},{3,521},{11,71}";
	
	@Test
	public void testA_2_3125() {
		Assert.assertTrue(super.checkEquality(A_1_3125, V_A_1_3125, E_A_1_3125));
	}
	
	private static final String A_1_83521 = "A_1(83521)";
	private static final String V_A_1_83521 = "2,3,5,17,29,41761";
	private static final String E_A_1_83521 = "{2,3},{2,5},{2,29},{3,5},{3,29},{5,29}";
	
	@Test
	public void testA_2_83521() {
		Assert.assertTrue(super.checkEquality(A_1_83521, V_A_1_83521, E_A_1_83521));
	}
	
	private static final String A_2_16 = "A_2(16)";
	private static final String V_A_2_16 = "2,3,5,7,13,17";
	private static final String E_A_2_16 = "{2,3},{2,5},{3,5},{5,17},{7,13}";
	
	@Test
	public void testA_2_16() {
		// FIXME неуспех (1 лишнее ребро {2,3})
		Assert.assertTrue(super.checkEquality(A_2_16, V_A_2_16, E_A_2_16));
	}
	
	private static final String A_2_128 = "A_2(128)";
	private static final String V_A_2_128 = "2,3,7,43,127,337";
	private static final String E_A_2_128 = "{2,127},{3,43},{3,127},{7,337},{43,127}";
	
	@Test
	public void testA_2_128() {
		Assert.assertTrue(super.checkEquality(A_2_128, V_A_2_128, E_A_2_128));
	}
	
	private static final String A_2_512 = "A_2(512)";
	private static final String V_A_2_512 = "2,3,7,19,73,262657";
	private static final String E_A_2_512 = "{2,7},{2,73},{3,7},{3,19},{3,73},{7,19},{7,73},{19,73}";
	
	@Test
	public void testA_2_512() {
		Assert.assertTrue(super.checkEquality(A_2_512, V_A_2_512, E_A_2_512));
	}
	
	private static final String A_2_25 = "A_2(25)";
	private static final String V_A_2_25 = "2,3,5,7,13,31";
	private static final String E_A_2_25 = "{2,3},{2,5},{2,13},{3,5},{5,13},{7,31}";
	
	@Test
	public void testA_2_25() {
		// FIXME неудача (лишние ребра {3,5},{5,13})
		Assert.assertTrue(super.checkEquality(A_2_25, V_A_2_25, E_A_2_25));
	}
	
	private static final String A_2_49 = "A_2(49)";
	private static final String V_A_2_49 = "2,3,5,7,19,43";
	private static final String E_A_2_49 = "{2,3},{2,5},{2,7},{3,7},{5,7},{19,43}";
	
	@Test
	public void testA_2_49() {
		// FIXME неудача (лишние ребра {3,7},{5,7})
		Assert.assertTrue(super.checkEquality(A_2_49, V_A_2_49, E_A_2_49));
	}
	
	private static final String A_3_8 = "A_3(8)";
	private static final String V_A_3_8 = "2,3,5,7,13,73";
	private static final String E_A_3_8 = "{2,3},{2,7},{3,5},{3,7},{3,13},{5,13},{7,73}";
	
	@Test
	public void testA_3_8() {
		Assert.assertTrue(super.checkEquality(A_3_8, V_A_3_8, E_A_3_8));
	}
	
	private static final String A_3_9 = "A_3(9)";
	private static final String V_A_3_9 = "2,3,5,7,13,41";
	private static final String E_A_3_9 = "{2,3},{2,5},{2,7},{2,13},{3,5},{7,13},{5,41}";
	
	@Test
	public void testA_3_9() {
		Assert.assertTrue(super.checkEquality(A_3_9, V_A_3_9, E_A_3_9));
	}
	
	private static final String A_3_17 = "A_3(17)";
	private static final String V_A_3_17 = "2,3,5,17,29,307";
	private static final String E_A_3_17 = "{2,3},{2,17},{2,307},{3,5},{3,17},{3,29},{5,29}";
	
	@Test
	public void testA_3_17() {
		Assert.assertTrue(super.checkEquality(A_3_17, V_A_3_17, E_A_3_17));
	}
	
}