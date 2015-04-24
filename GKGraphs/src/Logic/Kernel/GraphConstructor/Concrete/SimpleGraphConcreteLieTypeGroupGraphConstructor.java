package Logic.Kernel.GraphConstructor.Concrete;

import java.util.List;

import Logic.Kernel.Group.LieTypeGroup;

/**
 * Легковестный конструктор графа Грюнберга --- Кегеля группы InndiagGamma для конкретной группы лиева типа,
 * не имеющей графовых автоморфизмов
 * 
 * @author v.kolpakova
 *
 */
public class SimpleGraphConcreteLieTypeGroupGraphConstructor extends GraphAutConcreteLieTypeGroupGraphConstructor<LieTypeGroup> {

	public SimpleGraphConcreteLieTypeGroupGraphConstructor(LieTypeGroup group) {
		super(group);
	}

	@Override
	protected List<LieTypeGroup> computeCentralizer(int x) {
		return null;
	}
	
}