package Logic.Test.Implementations.InndiagGraphConstructor;

import Logic.Kernel.GraphConstructor.Concrete.InndiagConcreteLieTypeGroupGraphConstructor;
import Logic.Kernel.Resolvers.Concrete.InndiagLieTypeGroupGraphConstructorResolver;
import Logic.Kernel.Resolvers.Concrete.LieTypeGroupTypeResolver;
import Logic.Test.Implementations.GroupGraphConstructor.AbstractLieTypeGroup_Test;

public class AbstractInndiagLieTypeGroup_Test extends AbstractLieTypeGroup_Test {
	
	@Override
	protected void determineGroupWithGraph(String name) {
		this.group = LieTypeGroupTypeResolver.resolve(name);
		InndiagConcreteLieTypeGroupGraphConstructor<?> constructor = InndiagLieTypeGroupGraphConstructorResolver.resolve(group);
		this.graph = constructor.constructGKGraph();
		this.graph.printConsole();
	}
	
}