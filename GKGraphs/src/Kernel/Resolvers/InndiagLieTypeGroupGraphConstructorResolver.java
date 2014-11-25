package Kernel.Resolvers;

import Implementations.LieTypeGroups.A.ALieTypeGroup;
import Implementations.LieTypeGroups.A.ALieTypeGroupInndiagConcreteGraphConstructor;
import Kernel.GraphConstructor.InndiagConcreteLieTypeGroupGraphConstructor;
import Kernel.Group.LieTypeGroup;

/**
 * Класс вычисляет, конкструктор Inndiag графа Грюнберга --- Кегеля какого класса вызвать на основе типа группы. </br>
 * <b>ВНИМАНИЕ:</b> перед вызовом убедиться, что вычислено поле group.graph
 * 
 * @author v.kolpakova
 *
 */
public class InndiagLieTypeGroupGraphConstructorResolver{
	
	public static InndiagConcreteLieTypeGroupGraphConstructor<?> resolve(LieTypeGroup group) {
		InndiagConcreteLieTypeGroupGraphConstructor<?> constr = null;
		if (group instanceof ALieTypeGroup) {
			constr = new ALieTypeGroupInndiagConcreteGraphConstructor((ALieTypeGroup)group);
		}
		return constr;
	}
	
}