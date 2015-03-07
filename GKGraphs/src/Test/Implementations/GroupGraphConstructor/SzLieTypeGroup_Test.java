package Test.Implementations.GroupGraphConstructor;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.google.common.collect.Lists;

import Kernel.Graph.Edge;
import Kernel.Graph.PrimeNumberGraph;
import Kernel.Graph.Vertex;
import Test.Implementations.SzTypableConcrete;

public class SzLieTypeGroup_Test extends AbstractLieTypeGroup_Test implements SzTypableConcrete {
	
	private static final String NAME_1 = "Sz(8)";
	private static final String NAME_2 = "Sz(32)";
	
	@Test
	public void testG1() {
		determineGroupWithGraph(NAME_1);
		List<Edge> eList = Lists.newArrayList();
		List<Vertex<?>> vList = computeVList();
		PrimeNumberGraph gr = new PrimeNumberGraph(vList, eList);
		Assert.assertTrue(gr.equals(graph));
	}
	
	@Test
	public void testG2() {
		determineGroupWithGraph(NAME_2);
		List<Edge> eList = Lists.newArrayList();
		List<Vertex<?>> vList = computeVList();
		PrimeNumberGraph gr = new PrimeNumberGraph(vList, eList);
		Assert.assertTrue(gr.equals(graph));
	}
	
	@Test
	public void testSz_8() {
		Assert.assertTrue(super.checkEquality(SZ_8, V_SZ_8, E_SZ_8));
	}
	
	@Test
	public void testSz_32() {
		Assert.assertTrue(super.checkEquality(SZ_32, V_SZ_32, E_SZ_32));
	}
	
}