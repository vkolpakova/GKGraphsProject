package Logic.Kernel.Resolvers.Concrete;

import Logic.Implementations.LieTypeGroups.A.ALieTypeGroup;
import Logic.Implementations.LieTypeGroups.A.ALieTypeGroupFieldAutConcreteGraphConstructor;
import Logic.Implementations.LieTypeGroups.B.BLieTypeGroup;
import Logic.Implementations.LieTypeGroups.B.BLieTypeGroupFieldAutConcreteGraphConstructor;
import Logic.Implementations.LieTypeGroups.D.DLieTypeGroup;
import Logic.Implementations.LieTypeGroups.D.DLieTypeGroupFieldAutConcreteGraphConstructor;
import Logic.Implementations.LieTypeGroups.F.FLieTypeGroup;
import Logic.Implementations.LieTypeGroups.F.FLieTypeGroupFieldAutConcreteGraphConstructor;
import Logic.Implementations.LieTypeGroups.G.GLieTypeGroup;
import Logic.Implementations.LieTypeGroups.G.GLieTypeGroupFieldAutConcreteGraphConstructor;
import Logic.Implementations.LieTypeGroups.Ri.RiLieTypeGroup;
import Logic.Implementations.LieTypeGroups.Ri.RiLieTypeGroupFieldAutConcreteGraphConstructor;
import Logic.Implementations.LieTypeGroups.Sz.SzLieTypeGroup;
import Logic.Implementations.LieTypeGroups.Sz.SzLieTypeGroupFieldAutConcreteGraphConstructor;
import Logic.Implementations.LieTypeGroups._A._ALieTypeGroup;
import Logic.Implementations.LieTypeGroups._A._ALieTypeGroupFieldAutConcreteGraphConstructor;
import Logic.Implementations.LieTypeGroups._D._DLieTypeGroup;
import Logic.Implementations.LieTypeGroups._D._DLieTypeGroupFieldAutConcreteGraphConstructor;
import Logic.Implementations.LieTypeGroups.__D.__DLieTypeGroup;
import Logic.Implementations.LieTypeGroups.__D.__DLieTypeGroupFieldAutConcreteGraphConstructor;
import Logic.Kernel.GraphConstructor.Concrete.FieldAutConcreteLieTypeGroupGraphConstructor;
import Logic.Kernel.Group.LieTypeGroup;

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