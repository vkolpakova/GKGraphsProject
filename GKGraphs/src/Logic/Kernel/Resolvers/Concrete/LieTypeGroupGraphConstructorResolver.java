package Logic.Kernel.Resolvers.Concrete;

import Logic.Implementations.LieTypeGroups.A.ALieTypeGroup;
import Logic.Implementations.LieTypeGroups.A.ALieTypeGroupConcreteGraphConstructor;
import Logic.Implementations.LieTypeGroups.B.BLieTypeGroup;
import Logic.Implementations.LieTypeGroups.B.BLieTypeGroupConcreteGraphConstructor;
import Logic.Implementations.LieTypeGroups.D.DLieTypeGroup;
import Logic.Implementations.LieTypeGroups.D.DLieTypeGroupConcreteGraphConstructor;
import Logic.Implementations.LieTypeGroups.F.FLieTypeGroup;
import Logic.Implementations.LieTypeGroups.F.FLieTypeGroupConcreteGraphConstructor;
import Logic.Implementations.LieTypeGroups.G.GLieTypeGroup;
import Logic.Implementations.LieTypeGroups.G.GLieTypeGroupConcreteGraphConstructor;
import Logic.Implementations.LieTypeGroups.Ri.RiLieTypeGroup;
import Logic.Implementations.LieTypeGroups.Ri.RiLieTypeGroupConcreteGraphConstructor;
import Logic.Implementations.LieTypeGroups.Sz.SzLieTypeGroup;
import Logic.Implementations.LieTypeGroups.Sz.SzLieTypeGroupConcreteGraphConstructor;
import Logic.Implementations.LieTypeGroups._A._ALieTypeGroup;
import Logic.Implementations.LieTypeGroups._A._ALieTypeGroupConcreteGraphConstructor;
import Logic.Implementations.LieTypeGroups._D._DLieTypeGroup;
import Logic.Implementations.LieTypeGroups._D._DLieTypeGroupConcreteGraphConstructor;
import Logic.Implementations.LieTypeGroups.__D.__DLieTypeGroup;
import Logic.Implementations.LieTypeGroups.__D.__DLieTypeGroupConcreteGraphConstructor;
import Logic.Kernel.GraphConstructor.Concrete.LieTypeGroupGraphConstructor;
import Logic.Kernel.Group.LieTypeGroup;

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
		} else if (group instanceof SzLieTypeGroup) {
			constr = new SzLieTypeGroupConcreteGraphConstructor((SzLieTypeGroup) group);
		} else if (group instanceof RiLieTypeGroup) {
			constr = new RiLieTypeGroupConcreteGraphConstructor((RiLieTypeGroup) group);
		}
		return constr;
	}
	
}