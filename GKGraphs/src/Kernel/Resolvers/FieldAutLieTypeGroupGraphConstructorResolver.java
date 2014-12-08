package Kernel.Resolvers;

import Implementations.LieTypeGroups.A.ALieTypeGroup;
import Implementations.LieTypeGroups.A.ALieTypeGroupFieldAutConcreteGraphConstructor;
import Implementations.LieTypeGroups.B.BLieTypeGroup;
import Implementations.LieTypeGroups.B.BLieTypeGroupFieldAutConcreteGraphConstructor;
import Implementations.LieTypeGroups.D.DLieTypeGroup;
import Implementations.LieTypeGroups.D.DLieTypeGroupFieldAutConcreteGraphConstructor;
import Implementations.LieTypeGroups.F.FLieTypeGroup;
import Implementations.LieTypeGroups.F.FLieTypeGroupFieldAutConcreteGraphConstructor;
import Implementations.LieTypeGroups.G.GLieTypeGroup;
import Implementations.LieTypeGroups.G.GLieTypeGroupFieldAutConcreteGraphConstructor;
import Implementations.LieTypeGroups.Ri.RiLieTypeGroup;
import Implementations.LieTypeGroups.Ri.RiLieTypeGroupFieldAutConcreteGraphConstructor;
import Implementations.LieTypeGroups.Sz.SzLieTypeGroup;
import Implementations.LieTypeGroups.Sz.SzLieTypeGroupFieldAutConcreteGraphConstructor;
import Implementations.LieTypeGroups._A._ALieTypeGroup;
import Implementations.LieTypeGroups._A._ALieTypeGroupFieldAutConcreteGraphConstructor;
import Implementations.LieTypeGroups._D._DLieTypeGroup;
import Implementations.LieTypeGroups._D._DLieTypeGroupFieldAutConcreteGraphConstructor;
import Implementations.LieTypeGroups.__D.__DLieTypeGroup;
import Implementations.LieTypeGroups.__D.__DLieTypeGroupFieldAutConcreteGraphConstructor;
import Kernel.GraphConstructor.Concrete.FieldAutConcreteLieTypeGroupGraphConstructor;
import Kernel.Group.LieTypeGroup;

/**
 * Класс вычисляет, конкструктор InndiagPhi графа Грюнберга --- Кегеля какого класса вызвать на основе типа группы. </br>
 * <b>ВНИМАНИЕ:</b> перед вызовом убедиться, что вычислено поле {@link #group.graph}
 * 
 * @author v.kolpakova
 *
 */
public class FieldAutLieTypeGroupGraphConstructorResolver {
	
	public static FieldAutConcreteLieTypeGroupGraphConstructor<?> resolve(LieTypeGroup group) {
		FieldAutConcreteLieTypeGroupGraphConstructor<?> constr = null;
		if (group instanceof ALieTypeGroup) {
			constr = new ALieTypeGroupFieldAutConcreteGraphConstructor((ALieTypeGroup) group);
		} else if (group instanceof _ALieTypeGroup) {
			constr = new _ALieTypeGroupFieldAutConcreteGraphConstructor((_ALieTypeGroup) group);
		} else if (group instanceof BLieTypeGroup) {
			constr = new BLieTypeGroupFieldAutConcreteGraphConstructor((BLieTypeGroup) group);
		} else if (group instanceof DLieTypeGroup) {
			constr = new DLieTypeGroupFieldAutConcreteGraphConstructor((DLieTypeGroup) group);
		} else if (group instanceof _DLieTypeGroup) {
			constr = new _DLieTypeGroupFieldAutConcreteGraphConstructor((_DLieTypeGroup) group);
		} else if (group instanceof __DLieTypeGroup) {
			constr = new __DLieTypeGroupFieldAutConcreteGraphConstructor((__DLieTypeGroup) group);
		} else if (group instanceof FLieTypeGroup) {
			constr = new FLieTypeGroupFieldAutConcreteGraphConstructor((FLieTypeGroup)group);
		} else if (group instanceof GLieTypeGroup) {
			constr = new GLieTypeGroupFieldAutConcreteGraphConstructor((GLieTypeGroup) group);
		} else if (group instanceof SzLieTypeGroup) {
			constr = new SzLieTypeGroupFieldAutConcreteGraphConstructor((SzLieTypeGroup) group);
		} else if (group instanceof RiLieTypeGroup) {
			constr = new RiLieTypeGroupFieldAutConcreteGraphConstructor((RiLieTypeGroup) group);
		} 
		return constr;
	}
	
}