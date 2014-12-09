package Test.Implementations;

import java.util.List;

import com.google.common.collect.Lists;

import Kernel.Graph.PrimeNumberGraph;
import Kernel.Graph.SimpleVertex;
import Kernel.Graph.Vertex;
import Kernel.GraphConstructor.Concrete.LieTypeGroupGraphConstructor;
import Kernel.Group.LieTypeGroup;
import Kernel.Resolvers.Concrete.LieTypeGroupGraphConstructorResolver;
import Kernel.Resolvers.Concrete.LieTypeGroupTypeResolver;
import Kernel.Utils.ArithmeticUtils;

public class AbstractLieTypeGroup_Test {
	
	protected LieTypeGroup group;
	protected PrimeNumberGraph graph;
	
	protected void determineGroup(String name) {
		this.group = LieTypeGroupTypeResolver.resolve(name);
		LieTypeGroupGraphConstructor constr = LieTypeGroupGraphConstructorResolver.resolve(group);
		this.graph = constr.constructGKGraph();
		this.graph.printConsole();
	}
	
	protected List<Vertex<?>> computeVList() {
		List<Vertex<?>> vList = Lists.newArrayList();
		List<Integer> prDivList = ArithmeticUtils.getAllPrimeDevisors(this.group.getOrder());
		for (int i : prDivList) {
			vList.add(new SimpleVertex(i));
		}
		return vList;
	}
	
}