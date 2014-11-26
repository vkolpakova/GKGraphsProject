package Kernel.Resolvers;

import Implementations.LieTypeGroups.A.ALieTypeGroup;
import Implementations.LieTypeGroups.A.ALieTypeGroupInndiagConcreteGraphConstructor;
import Implementations.LieTypeGroups.B.BLieTypeGroup;
import Implementations.LieTypeGroups.B.BLieTypeGroupInndiagConcreteGraphConstructor;
import Implementations.LieTypeGroups.D.DLieTypeGroup;
import Implementations.LieTypeGroups.D.DLieTypeGroupInndiagConcreteGraphConstructor;
import Implementations.LieTypeGroups._A._ALieTypeGroup;
import Implementations.LieTypeGroups._A._ALieTypeGroupInndiagConcreteGraphConstructor;
import Implementations.LieTypeGroups._D._DLieTypeGroup;
import Implementations.LieTypeGroups._D._DLieTypeGroupInndiagConcreteGraphConstructor;
import Kernel.GraphConstructor.InndiagConcreteLieTypeGroupGraphConstructor;
import Kernel.Group.LieTypeGroup;

/**
 * Класс вычисляет, конкструктор Inndiag графа Грюнберга --- Кегеля какого класса вызвать на основе типа группы. </br>
 * <b>ВНИМАНИЕ:</b> перед вызовом убедиться, что вычислено поле {@link #group.graph}
 * TODO обработать случаи, когда Inndiag совп. с группой (нет диаганальных автоморфизмов)
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
		}
		return constr;
	}
	
}