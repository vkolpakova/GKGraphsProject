package Test.Implementations.GroupGraphConstructor;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.google.common.collect.Lists;

import Kernel.Graph.Edge;
import Kernel.Graph.PrimeNumberGraph;
import Kernel.Graph.SimpleVertex;
import Kernel.Graph.Vertex;

public class DLieTypeGroup_Test extends AbstractLieTypeGroup_Test {
	
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
	
	private static final String D_4_4 = "D_4(4)";
	private static final String V_D_4_4 = "2,3,5,7,13,17";
	private static final String E_D_4_4 = "{2,3},{2,5},{2,17},{3,5},{3,7},{3,17},{5,7},{5,13},{5,17}";
	
	@Test
	public void testD_4_4() {
		// FIXME лишнее ребро {5,7}
		Assert.assertTrue(super.checkEquality(D_4_4, V_D_4_4, E_D_4_4));
	}
	
	private static final String D_4_5 = "D_4(5)";
	private static final String V_D_4_5 = "2,3,5,7,13,31";
	private static final String E_D_4_5 = "{2,3},{2,5},{2,13},{3,5},{3,7},{3,13},{3,31},{5,13}";
	
	@Test
	public void testD_4_5() {
		// FIXME лишнее ребро {3,31}, не хватает ребра {2,31}
		Assert.assertTrue(super.checkEquality(D_4_5, V_D_4_5, E_D_4_5));
	}
	
	private static final String D_4_7 = "D_4(7)";
	private static final String V_D_4_7 = "2,3,5,7,19,43";
	private static final String E_D_4_7 = "{2,3},{2,5},{2,7},{3,5},{3,7},{3,19},{3,43},{5,7}";
	
	@Test
	public void testD_4_7() {
		// FIXME лишнее ребро {3,43}, не хватает ребра {2,19}
		Assert.assertTrue(super.checkEquality(D_4_7, V_D_4_7, E_D_4_7));
	}
	
	private static final String D_5_2 = "D_5(2)";
	private static final String V_D_5_2 = "2,3,5,7,17,31";
	private static final String E_D_5_2 = "{2,3},{2,5},{2,7},{3,5},{3,7},{3,17}";
	
	@Test
	public void testD_5_2() {
		Assert.assertTrue(super.checkEquality(D_5_2, V_D_5_2, E_D_5_2));
	}
	
}