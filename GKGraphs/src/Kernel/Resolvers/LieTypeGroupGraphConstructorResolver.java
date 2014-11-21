package Kernel.Resolvers;

import Implementations.LieTypeGroups.A.ALieTypeGroup;
import Implementations.LieTypeGroups.A.ALieTypeGroupConcreteGraphConstructor;
import Implementations.LieTypeGroups.B.BLieTypeGroup;
import Implementations.LieTypeGroups.B.BLieTypeGroupConcreteGraphConstructor;
import Kernel.GraphConstructor.LieTypeGroupGraphConstructor;
import Kernel.Group.LieTypeGroup;

public class LieTypeGroupGraphConstructorResolver  {
	
	public static LieTypeGroupGraphConstructor resolve(LieTypeGroup group) {
		LieTypeGroupGraphConstructor constr = null;
		if (group instanceof ALieTypeGroup) {
			constr = new ALieTypeGroupConcreteGraphConstructor((ALieTypeGroup)group);
		} else if (group instanceof BLieTypeGroup) {
			constr = new BLieTypeGroupConcreteGraphConstructor((BLieTypeGroup)group);
		}
		// TODO с появлением новых имплементаций LieTypeGroupGraphConstructor реализовать соотв. логику
		return constr;
	}
	
}