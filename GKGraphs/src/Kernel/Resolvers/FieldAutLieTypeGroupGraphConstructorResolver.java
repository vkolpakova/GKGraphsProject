package Kernel.Resolvers;

import Implementations.LieTypeGroups.A.ALieTypeGroup;
import Implementations.LieTypeGroups.A.ALieTypeGroupFieldAutConcreteGraphConstructor;
import Kernel.GraphConstructor.FieldAutConcreteLieTypeGroupGraphConstructor;
import Kernel.Group.LieTypeGroup;

/**
 * Класс вычисляет, конкструктор InndiagPhi графа Грюнберга --- Кегеля какого класса вызвать на основе типа группы. </br>
 * <b>ВНИМАНИЕ:</b> перед вызовом убедиться, что вычислено поле {@link #group.graph}
 * TODO обработать случаи, когда Phi --- тривиальная группа (нет полевых автоморфизмов)
 * @author v.kolpakova
 *
 */
public class FieldAutLieTypeGroupGraphConstructorResolver {
	
	public static FieldAutConcreteLieTypeGroupGraphConstructor<?> resolve(LieTypeGroup group) {
		FieldAutConcreteLieTypeGroupGraphConstructor<?> constr = null;
		if (group instanceof ALieTypeGroup) {
			constr = new ALieTypeGroupFieldAutConcreteGraphConstructor((ALieTypeGroup) group);
		}
		return constr;
	}
	
}