package Logic.Implementations.LieTypeGroups.B;

import java.util.List;

import Logic.Kernel.GraphConstructor.Concrete.GraphAutConcreteLieTypeGroupGraphConstructor;
import Logic.Kernel.Group.LieTypeGroup;

public class BLieTypeGroupGraphAutConcreteGraphConstructor extends GraphAutConcreteLieTypeGroupGraphConstructor<BLieTypeGroup> {

	public BLieTypeGroupGraphAutConcreteGraphConstructor(BLieTypeGroup group) {
		super(group);
	}

	@Override
	protected List<LieTypeGroup> computeCentralizer(int x) {
		// FIXME разобраться со случаем p = 2
		return null;
	}
	
}