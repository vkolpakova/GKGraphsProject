package Logic.Implementations.LieTypeGroups.F;

import java.util.List;

import Logic.Kernel.GraphConstructor.Concrete.GraphAutConcreteLieTypeGroupGraphConstructor;
import Logic.Kernel.Group.LieTypeGroup;

public class FLieTypeGroupGraphAutConcreteGraphConstructor extends GraphAutConcreteLieTypeGroupGraphConstructor<FLieTypeGroup> {

	public FLieTypeGroupGraphAutConcreteGraphConstructor(FLieTypeGroup group) {
		super(group);
	}

	@Override
	protected List<LieTypeGroup> computeCentralizer(int x) {
		// FIXME разобраться со случаем p = 2
		return null;
	}
	
}