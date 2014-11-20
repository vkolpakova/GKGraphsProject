package Kernel.Utils;

import Implementations.LieTypeGroups.A.ALieTypeGroup;
import Implementations.LieTypeGroups.A.ALieTypeGroupConcreteGraphConstructor;
import Kernel.GraphConstructor.LieTypeGroupGraphConstructor;
import Kernel.Group.LieTypeGroup;

public class LieTypeGroupGraphConstructorResolver  {
	
	public static LieTypeGroupGraphConstructor resolve(LieTypeGroup group) {
		LieTypeGroupGraphConstructor constr = null;
		if (group instanceof ALieTypeGroup) {
			constr = new ALieTypeGroupConcreteGraphConstructor((ALieTypeGroup)group);
		}
		// TODO с появлением новых имплементаций LieTypeGroupGraphConstructor реализовать соотв. логику
		return constr;
	}
	
}