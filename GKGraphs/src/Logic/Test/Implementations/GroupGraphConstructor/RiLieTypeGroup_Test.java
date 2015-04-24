package Logic.Test.Implementations.GroupGraphConstructor;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.google.common.collect.Lists;

import Logic.Kernel.Graph.Edge;
import Logic.Kernel.Graph.PrimeNumberGraph;
import Logic.Kernel.Graph.SimpleVertex;
import Logic.Kernel.Graph.Vertex;
import Logic.Test.Implementations.RiTypableConcrete;

public class RiLieTypeGroup_Test extends AbstractLieTypeGroup_Test implements RiTypableConcrete {
	
	private static final String NAME_1 = "Ri(27)";
	
	@Test
	public void testG1() {
		determineGroupWithGraph(NAME_1);
		List<Edge> eList = Lists.newArrayList();
		List<Vertex<?>> vList = computeVList();
		eList.add(new Edge(new SimpleVertex(2), new SimpleVertex(3)));
		eList.add(new Edge(new SimpleVertex(2), new SimpleVertex(7)));
		eList.add(new Edge(new SimpleVertex(2), new SimpleVertex(13)));
		PrimeNumberGraph gr = new PrimeNumberGraph(vList, eList);
		Assert.assertTrue(gr.equals(graph));
	}
	
	@Test
	public void testRi_27() {
		Assert.assertTrue(super.checkEquality(RI_27, V_RI_27, E_RI_27));
	}
	
}