package Kernel.Resolvers;

import Implementations.LieTypeGroups.A.ALieTypeGroup;
import Implementations.LieTypeGroups.A.ALieTypeGroupInndiagConcreteGraphConstructor;
import Implementations.LieTypeGroups.B.BLieTypeGroup;
import Implementations.LieTypeGroups.B.BLieTypeGroupInndiagConcreteGraphConstructor;
import Implementations.LieTypeGroups._A._ALieTypeGroup;
import Implementations.LieTypeGroups._A._ALieTypeGroupInndiagConcreteGraphConstructor;
import Kernel.GraphConstructor.InndiagConcreteLieTypeGroupGraphConstructor;
import Kernel.Group.LieTypeGroup;

/**
 * Класс вычисляет, конкструктор Inndiag графа Грюнберга --- Кегеля какого класса вызвать на основе типа группы. </br>
 * <b>ВНИМАНИЕ:</b> перед вызовом убедиться, что вычислено поле group.graph
 * 
 * TODO вставить сюда проверку того, что группа имеет неединичный индекс в своей группе Inndiag
 * @author v.kolpakova
 *
 */
public class InndiagLieTypeGroupGraphConstructorResolver{
	
	public static InndiagConcreteLieTypeGroupGraphConstructor<?> resolve(LieTypeGroup group) {
		InndiagConcreteLieTypeGroupGraphConstructor<?> constr = null;
		if (group instanceof ALieTypeGroup) {
			constr = new ALieTypeGroupInndiagConcreteGraphConstructor((ALieTypeGroup)group);
		} else if (group instanceof _ALieTypeGroup) {
			constr = new _ALieTypeGroupInndiagConcreteGraphConstructor((_ALieTypeGroup) group);
		} else if (group instanceof BLieTypeGroup) {
			constr = new BLieTypeGroupInndiagConcreteGraphConstructor((BLieTypeGroup) group);
		}
		return constr;
	}
	
}