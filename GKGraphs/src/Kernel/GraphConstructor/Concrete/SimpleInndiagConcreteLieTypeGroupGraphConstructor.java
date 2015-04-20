package Kernel.GraphConstructor.Concrete;

import java.util.List;

import Kernel.Group.LieTypeGroup;

/**
 * Легковестный конструктор графа Грюнберга --- Кегеля группы Inndiag для конкретной группы лиева типа,
 * не имеющей диаганальных автоморфизмов
 * 
 * @author v.kolpakova
 *
 */
public class SimpleInndiagConcreteLieTypeGroupGraphConstructor extends InndiagConcreteLieTypeGroupGraphConstructor<LieTypeGroup> {

	public SimpleInndiagConcreteLieTypeGroupGraphConstructor(LieTypeGroup group) {
		super(group);
	}

	@Override
	protected List<List<Integer>> computeTorOrdersPartitions() {
		return null;
	}
	
}