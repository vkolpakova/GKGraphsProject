package Logic.Kernel.Resolvers.Concrete;

import Logic.Implementations.LieTypeGroups.A.ALieTypeGroup;
import Logic.Implementations.LieTypeGroups.A.ALieTypeGroupGraphAutConcreteGraphConstructor;
import Logic.Implementations.LieTypeGroups.B.BLieTypeGroup;
import Logic.Implementations.LieTypeGroups.B.BLieTypeGroupGraphAutConcreteGraphConstructor;
import Logic.Implementations.LieTypeGroups.D.DLieTypeGroup;
import Logic.Implementations.LieTypeGroups.D.DLieTypeGroupGraphAutConcreteGraphConstructor;
import Logic.Implementations.LieTypeGroups.F.FLieTypeGroup;
import Logic.Implementations.LieTypeGroups.F.FLieTypeGroupGraphAutConcreteGraphConstructor;
import Logic.Implementations.LieTypeGroups.G.GLieTypeGroup;
import Logic.Implementations.LieTypeGroups.G.GLieTypeGroupGraphAutConcreteGraphConstructor;
import Logic.Kernel.GraphConstructor.Concrete.GraphAutConcreteLieTypeGroupGraphConstructor;
import Logic.Kernel.GraphConstructor.Concrete.SimpleGraphConcreteLieTypeGroupGraphConstructor;
import Logic.Kernel.Group.LieTypeGroup;

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
		} else if (group instanceof GLieTypeGroup) {
			constr = new GLieTypeGroupGraphAutConcreteGraphConstructor((GLieTypeGroup) group);
		} else {
			constr = new SimpleGraphConcreteLieTypeGroupGraphConstructor(group);
		}
		return constr;
	}
	
}