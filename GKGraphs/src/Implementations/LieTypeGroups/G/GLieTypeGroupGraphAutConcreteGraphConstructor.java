package Implementations.LieTypeGroups.G;

import java.util.List;

import Kernel.GraphConstructor.Concrete.GraphAutConcreteLieTypeGroupGraphConstructor;
import Kernel.Group.LieTypeGroup;

public class GLieTypeGroupGraphAutConcreteGraphConstructor extends GraphAutConcreteLieTypeGroupGraphConstructor<GLieTypeGroup> {

	public GLieTypeGroupGraphAutConcreteGraphConstructor(GLieTypeGroup group) {
		super(group);
	}

	@Override
	protected List<LieTypeGroup> computeCentralizer(int x) {
		// FIXME разобраться со случаем p = 3
		return null;
	}
	
}