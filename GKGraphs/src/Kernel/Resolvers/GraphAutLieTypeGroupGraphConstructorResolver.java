package Kernel.Resolvers;

import Implementations.LieTypeGroups.A.ALieTypeGroup;
import Implementations.LieTypeGroups.A.ALieTypeGroupGraphAutConcreteGraphConstructor;
import Kernel.GraphConstructor.GraphAutConcreteLieTypeGroupGraphConstructor;
import Kernel.Group.LieTypeGroup;

/**
 * Класс вычисляет, конкструктор InndiagGamma графа Грюнберга --- Кегеля какого класса вызвать на основе типа группы. </br>
 * <b>ВНИМАНИЕ:</b> перед вызовом убедиться, что вычислено поле {@link #group.graph}
 * 
 * @author v.kolpakova
 *
 */
public class GraphAutLieTypeGroupGraphConstructorResolver {
	
	public static GraphAutConcreteLieTypeGroupGraphConstructor<?> resolve(LieTypeGroup group) {
		GraphAutConcreteLieTypeGroupGraphConstructor<?> constr = null;
		if (group instanceof ALieTypeGroup) {
			constr = new ALieTypeGroupGraphAutConcreteGraphConstructor((ALieTypeGroup) group);
		}
		return constr;
	}
	
}