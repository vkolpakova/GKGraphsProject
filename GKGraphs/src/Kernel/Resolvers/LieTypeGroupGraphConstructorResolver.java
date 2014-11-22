package Kernel.Resolvers;

import Implementations.LieTypeGroups.A.ALieTypeGroup;
import Implementations.LieTypeGroups.A.ALieTypeGroupConcreteGraphConstructor;
import Implementations.LieTypeGroups.B.BLieTypeGroup;
import Implementations.LieTypeGroups.B.BLieTypeGroupConcreteGraphConstructor;
import Implementations.LieTypeGroups.D.DLieTypeGroup;
import Implementations.LieTypeGroups.D.DLieTypeGroupConcreteGraphConstructor;
import Implementations.LieTypeGroups.F.FLieTypeGroup;
import Implementations.LieTypeGroups.F.FLieTypeGroupConcreteGraphConstructor;
import Implementations.LieTypeGroups.G.GLieTypeGroup;
import Implementations.LieTypeGroups.G.GLieTypeGroupConcreteGraphConstructor;
import Implementations.LieTypeGroups._A._ALieTypeGroup;
import Implementations.LieTypeGroups._A._ALieTypeGroupConcreteGraphConstructor;
import Implementations.LieTypeGroups._D._DLieTypeGroup;
import Implementations.LieTypeGroups._D._DLieTypeGroupConcreteGraphConstructor;
import Implementations.LieTypeGroups.__D.__DLieTypeGroup;
import Implementations.LieTypeGroups.__D.__DLieTypeGroupConcreteGraphConstructor;
import Kernel.GraphConstructor.LieTypeGroupGraphConstructor;
import Kernel.Group.LieTypeGroup;

/**
 * Класс вычисляет, конкструктор графа Грюнберга --- Кегеля какого класса вызвать на основе типа группы.
 * 
 * @author v.kolpakova
 *
 */
public class LieTypeGroupGraphConstructorResolver  {
	
	public static LieTypeGroupGraphConstructor resolve(LieTypeGroup group) {
		LieTypeGroupGraphConstructor constr = null;
		if (group instanceof ALieTypeGroup) {
			constr = new ALieTypeGroupConcreteGraphConstructor((ALieTypeGroup)group);
		} else if (group instanceof BLieTypeGroup) {
			constr = new BLieTypeGroupConcreteGraphConstructor((BLieTypeGroup)group);
		} else if (group instanceof _ALieTypeGroup) {
			constr = new _ALieTypeGroupConcreteGraphConstructor((_ALieTypeGroup)group);
		} else if (group instanceof DLieTypeGroup) {
			constr = new DLieTypeGroupConcreteGraphConstructor((DLieTypeGroup)group);
		} else if (group instanceof _DLieTypeGroup) {
			constr = new _DLieTypeGroupConcreteGraphConstructor((_DLieTypeGroup)group);
		} else if (group instanceof __DLieTypeGroup) {
			constr = new __DLieTypeGroupConcreteGraphConstructor((__DLieTypeGroup)group);
		} else if (group instanceof GLieTypeGroup) {
			constr = new GLieTypeGroupConcreteGraphConstructor((GLieTypeGroup)group);
		} else if (group instanceof FLieTypeGroup) {
			constr = new FLieTypeGroupConcreteGraphConstructor((FLieTypeGroup) group);
		}
		// TODO с появлением новых имплементаций LieTypeGroupGraphConstructor реализовать соотв. логику
		return constr;
	}
	
}