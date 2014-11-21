package Kernel.Resolvers;

import Implementations.LieTypeGroups.A.ALieTypeGroup;
import Implementations.LieTypeGroups.A.ALieTypeGroupConcreteGraphConstructor;
import Implementations.LieTypeGroups.B.BLieTypeGroup;
import Implementations.LieTypeGroups.B.BLieTypeGroupConcreteGraphConstructor;
import Implementations.LieTypeGroups._A._ALieTypeGroup;
import Implementations.LieTypeGroups._A._ALieTypeGroupConcreteGraphConstructor;
import Kernel.GraphConstructor.LieTypeGroupGraphConstructor;
import Kernel.Group.LieTypeGroup;

public class LieTypeGroupGraphConstructorResolver  {
	
	public static LieTypeGroupGraphConstructor resolve(LieTypeGroup group) {
		LieTypeGroupGraphConstructor constr = null;
		if (group instanceof ALieTypeGroup) {
			constr = new ALieTypeGroupConcreteGraphConstructor((ALieTypeGroup)group);
		} else if (group instanceof BLieTypeGroup) {
			constr = new BLieTypeGroupConcreteGraphConstructor((BLieTypeGroup)group);
		} else if (group instanceof _ALieTypeGroup) {
			constr = new _ALieTypeGroupConcreteGraphConstructor((_ALieTypeGroup)group);
		}
		// TODO с появлением новых имплементаций LieTypeGroupGraphConstructor реализовать соотв. логику
		return constr;
	}
	
}