package Test.Implementations.InndiagGraphConstructor;

import Kernel.GraphConstructor.Concrete.InndiagConcreteLieTypeGroupGraphConstructor;
import Kernel.Resolvers.Concrete.InndiagLieTypeGroupGraphConstructorResolver;
import Kernel.Resolvers.Concrete.LieTypeGroupTypeResolver;
import Test.Implementations.GroupGraphConstructor.AbstractLieTypeGroup_Test;

public class AbstractInndiagLieTypeGroup_Test extends AbstractLieTypeGroup_Test {
	
	@Override
	protected void determineGroupWithGraph(String name) {
		this.group = LieTypeGroupTypeResolver.resolve(name);
		InndiagConcreteLieTypeGroupGraphConstructor<?> constructor = InndiagLieTypeGroupGraphConstructorResolver.resolve(group);
		this.graph = constructor.constructGKGraph();
		this.graph.printConsole();
	}
	
}