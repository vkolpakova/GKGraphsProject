package Kernel.GraphConstructor;

import Kernel.Group.LieTypeGroup;

/**
 * Конструктор графа Грюнберга --- Кегеля группы Inndiag, расширенной подгруппой, порожденной некоторым графовым автоморфизмом группы лиева типа
 * 
 * @author v.kolpakova
 *
 */
public abstract class GraphAutConcreteLieTypeGroupGraphConstructor<G extends LieTypeGroup> extends AutSubgroupConcreteLieTypeGroupGraphConstructor<LieTypeGroup> {

	public GraphAutConcreteLieTypeGroupGraphConstructor(LieTypeGroup group) {
		super(group);
	}

}