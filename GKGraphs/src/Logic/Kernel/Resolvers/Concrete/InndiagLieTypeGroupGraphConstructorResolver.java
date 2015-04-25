package Logic.Kernel.Resolvers.Concrete;

import Logic.Implementations.LieTypeGroups.A.ALieTypeGroup;
import Logic.Implementations.LieTypeGroups.A.ALieTypeGroupInndiagConcreteGraphConstructor;
import Logic.Implementations.LieTypeGroups.B.BLieTypeGroup;
import Logic.Implementations.LieTypeGroups.B.BLieTypeGroupInndiagConcreteGraphConstructor;
import Logic.Implementations.LieTypeGroups.D.DLieTypeGroup;
import Logic.Implementations.LieTypeGroups.D.DLieTypeGroupInndiagConcreteGraphConstructor;
import Logic.Implementations.LieTypeGroups._A._ALieTypeGroup;
import Logic.Implementations.LieTypeGroups._A._ALieTypeGroupInndiagConcreteGraphConstructor;
import Logic.Implementations.LieTypeGroups._D._DLieTypeGroup;
import Logic.Implementations.LieTypeGroups._D._DLieTypeGroupInndiagConcreteGraphConstructor;
import Logic.Kernel.GraphConstructor.Concrete.InndiagConcreteLieTypeGroupGraphConstructor;
import Logic.Kernel.GraphConstructor.Concrete.SimpleInndiagConcreteLieTypeGroupGraphConstructor;
import Logic.Kernel.Group.LieTypeGroup;

/**
 * Класс вычисляет, конкструктор Inndiag графа Грюнберга --- Кегеля какого класса вызвать на основе типа группы. </br>
 * <b>ВНИМАНИЕ:</b> перед вызовом убедиться, что вычислено поле {@link #group.graph}
 * 
 * @author v.kolpakova
 *
 */
public class InndiagLieTypeGroupGraphConstructorResolver {
	
	public static InndiagConcreteLieTypeGroupGraphConstructor<?> resolve(LieTypeGroup group) {
		InndiagConcreteLieTypeGroupGraphConstructor<?> constr = null;
		if (group instanceof ALieTypeGroup) {
			constr = new ALieTypeGroupInndiagConcreteGraphConstructor((ALieTypeGroup)group);
		} else if (group instanceof _ALieTypeGroup) {
			constr = new _ALieTypeGroupInndiagConcreteGraphConstructor((_ALieTypeGroup) group);
		} else if (group instanceof BLieTypeGroup) {
			constr = new BLieTypeGroupInndiagConcreteGraphConstructor((BLieTypeGroup) group);
		} else if (group instanceof DLieTypeGroup) {
			constr = new DLieTypeGroupInndiagConcreteGraphConstructor((DLieTypeGroup) group);
		} else if (group instanceof _DLieTypeGroup) {
			constr = new _DLieTypeGroupInndiagConcreteGraphConstructor((_DLieTypeGroup)group);
		} else {
			constr = new SimpleInndiagConcreteLieTypeGroupGraphConstructor(group);
		}
		return constr;
	}
	
}