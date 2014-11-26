package Kernel.GraphConstructor;

import Kernel.Graph.PrimeNumberGraph;
import Kernel.Group.LieTypeGroup;

/**
 * Конструктор графа Грюнберга --- Кегеля подгруппы автоморфизмов для конкретной группы лиева типа
 * 
 * @author v.kolpakova
 *
 */
public abstract class AutSubgroupConcreteLieTypeGroupGraphConstructor<G extends LieTypeGroup> extends AbstractGraphConstructor<LieTypeGroup> {

	/**
	 * Граф Грюнберга --- Кегеля конкретной группы лиева типа
	 */
	protected PrimeNumberGraph groupGraph; 
	
	public AutSubgroupConcreteLieTypeGroupGraphConstructor(G group) {
		super(group);
		this.groupGraph = group.getGraph();
	}
	
}