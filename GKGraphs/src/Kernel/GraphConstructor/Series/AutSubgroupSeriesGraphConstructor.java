package Kernel.GraphConstructor.Series;

import java.util.List;
import java.util.Map;

import com.google.common.collect.Maps;

import Kernel.Graph.PrimeNumberGraph;
import Kernel.GraphConstructor.AbstractGraphConstructor;
import Kernel.Group.Series;
import Kernel.Polynom.CompoundPolynom;

/**
 * Абстрактный класс конструктора графа Грюнберга --- Кегеля подгруппы автоморфизмов для группы из некоторой серии
 * 
 * @author v.kolpakova
 *
 */
public abstract class AutSubgroupSeriesGraphConstructor extends AbstractGraphConstructor<Series> {
	
	/**
	 * Граф Грюнберга --- Кегеля группы из серии
	 */
	protected PrimeNumberGraph groupGraph;
	
	/**
	 * Map для хранения информации по централизаторам полевых/графовых автоморфизмов. </br>
	 * <b>Ключ:</b> порядок автоморфизма; </br>
	 * <b>Значение:</b> полином(ы), соответствующий порядку группы, которой изоморфен централизатор этого автоморфизма.
	 */
	protected Map<Integer, List<CompoundPolynom>> centralizationsMap;
	
	/**
	 * Map для хранения информации по графам группы серии, расширенной некоторым полевым/графовым автоморфизмом. </br>
	 * <b>Ключ:</b> порядок автоморфизма; </br>
	 * <b>Значение:</b> граф(ы) группы, расширенной автоморфизмом.
	 */
	protected Map<Integer, List<PrimeNumberGraph>> graphsMap;

	public AutSubgroupSeriesGraphConstructor(Series group) {
		super(group);
		this.groupGraph = group.getGraph();
		this.centralizationsMap = Maps.newHashMap();
		this.graphsMap = Maps.newHashMap();
		computeCentralizationsMap();
	}

	public PrimeNumberGraph getGroupGraph() {
		return groupGraph;
	}

	public void setGroupGraph(PrimeNumberGraph groupGraph) {
		this.groupGraph = groupGraph;
	}

	public Map<Integer, List<CompoundPolynom>> getCentralizationsMap() {
		return centralizationsMap;
	}

	public void setCentralizationsMap(
			Map<Integer, List<CompoundPolynom>> centralizationsMap) {
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