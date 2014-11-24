package Test.Implementations;

import Kernel.Graph.PrimeNumberGraph;
import Kernel.GraphConstructor.LieTypeGroupGraphConstructor;
import Kernel.Group.LieTypeGroup;
import Kernel.Resolvers.LieTypeGroupGraphConstructorResolver;
import Kernel.Resolvers.LieTypeGroupTypeResolver;

public class AbstractLieTypeGroup_Test {
	
	protected LieTypeGroup group;
	protected PrimeNumberGraph graph;
	
	protected void determineGroup(String name) {
		this.group = LieTypeGroupTypeResolver.resolve(name);
		LieTypeGroupGraphConstructor constr = LieTypeGroupGraphConstructorResolver.resolve(group);
		this.graph = constr.constructGKGraph();
		this.graph.printConsole();
	}
	
}