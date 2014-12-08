package Kernel.GraphConstructor.Concrete;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Kernel.Graph.PrimeNumberGraph;
import Kernel.GraphConstructor.AbstractGraphConstructor;
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
	
	/**
	 * Коллекция Map для хранения полевых/графовых автоморфизмов и их централизаторов. </br>
	 * <b>Ключ:</b> порядок автоморфизма (простое число); </br>
	 * <b>Значение:</b> группы лиева типа, которым изоморфен централизатор соотв. автоморфизма.
	 */
	protected Map<Integer, List<LieTypeGroup>> centralizationsMap;
	
	/**
	 * Коллекция Map для хранения полевых/графовых автоморфизмов и графов Грюнберга --- Кегеля подгрупп вида Pf </br>
	 * <b>Ключ:</b> порядок автоморфизма (простое число); </br>
	 * <b>Значение:</b> граф соотв. подгруппы в Aut
	 */
	protected Map<Integer, List<PrimeNumberGraph>> graphsMap;
	
	public AutSubgroupConcreteLieTypeGroupGraphConstructor(G group) {
		super(group);
		this.groupGraph = group.getGraph();
		this.centralizationsMap = new HashMap<Integer, List<LieTypeGroup>>();
		this.graphsMap= new HashMap<Integer, List<PrimeNumberGraph>>();
		computeCentralizationsMap();
	}
	
	public PrimeNumberGraph getGroupGraph() {
		return groupGraph;
	}

	public void setGroupGraph(PrimeNumberGraph groupGraph) {
		this.groupGraph = groupGraph;
	}

	public Map<Integer, List<LieTypeGroup>> getCentralizationsMap() {
		return centralizationsMap;
	}

	public void setCentralizationsMap(Map<Integer, List<LieTypeGroup>> centralizationsMap) {
		this.centralizationsMap = centralizationsMap;
	}

	public Map<Integer, List<PrimeNumberGraph>> getGraphsMap() {
		return graphsMap;
	}

	public void setGraphsMap(Map<Integer, List<PrimeNumberGraph>> graphsMap) {
		this.graphsMap = graphsMap;
	}

	/**
	 * В методе происходит заполнение поля {@link #centralizationsMap}
	 */
	protected abstract void computeCentralizationsMap();
	
	/**
	 * Метод возвращает порядок соотв. подгруппы группы автоморфизмов
	 */
	public abstract int getOrder();
	
	/**
	 * Метод осуществляет проверку, является ли соотв. подгруппа группы автоморфизмов тривиальной
	 */
	public boolean checkNotTrivial() {
		return (getOrder() != 1);
	}
	
}