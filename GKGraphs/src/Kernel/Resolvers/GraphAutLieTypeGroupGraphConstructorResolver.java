package Kernel.Resolvers;

import Implementations.LieTypeGroups.A.ALieTypeGroup;
import Implementations.LieTypeGroups.A.ALieTypeGroupGraphAutConcreteGraphConstructor;
import Implementations.LieTypeGroups.B.BLieTypeGroup;
import Implementations.LieTypeGroups.B.BLieTypeGroupGraphAutConcreteGraphConstructor;
import Implementations.LieTypeGroups.D.DLieTypeGroup;
import Implementations.LieTypeGroups.D.DLieTypeGroupGraphAutConcreteGraphConstructor;
import Implementations.LieTypeGroups.F.FLieTypeGroup;
import Implementations.LieTypeGroups.F.FLieTypeGroupGraphAutConcreteGraphConstructor;
import Kernel.GraphConstructor.GraphAutConcreteLieTypeGroupGraphConstructor;
import Kernel.GraphConstructor.SimpleGraphConcreteLieTypeGroupGraphConstructor;
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
		} else if (group instanceof BLieTypeGroup) {
			constr = new BLieTypeGroupGraphAutConcreteGraphConstructor((BLieTypeGroup) group);
		} else if (group instanceof DLieTypeGroup) {
			constr = new DLieTypeGroupGraphAutConcreteGraphConstructor((DLieTypeGroup) group);
		} else if (group instanceof FLieTypeGroup) {
			constr = new FLieTypeGroupGraphAutConcreteGraphConstructor((FLieTypeGroup) group);
		} else {
			constr = new SimpleGraphConcreteLieTypeGroupGraphConstructor(group);
		}
		return constr;
	}
	
}