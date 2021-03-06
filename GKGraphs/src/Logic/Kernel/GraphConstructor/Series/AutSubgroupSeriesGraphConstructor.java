package Logic.Kernel.GraphConstructor.Series;

import java.util.List;
import java.util.Map;

import com.google.common.collect.Maps;

import Logic.Kernel.Graph.PrimeNumberGraph;
import Logic.Kernel.GraphConstructor.AbstractGraphConstructor;
import Logic.Kernel.Group.Series;
import Logic.Kernel.Polynom.CompoundPolynom;

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
	 * Метод возвращает некоторое множество графов Грюнберга --- Кегеля, если это требуется
	 * (т.е. использовать метод constructGKGraph для потсроения единичного графа, а в этом методе возвращать все множество,
	 * пройдя по некоторому циклу)
	 * TODO переделать - возвращать Map для того, чтобы можно было также выводить порядки соотв. автоморфизмов
	 */
	public abstract List<PrimeNumberGraph> constructGKGraphs();
	
	/**
	 * Метод сторит граф Грюнберга --- Кегеля расширения группы некоторым автоморфизмом заданного порядка.
	 * @param autOrder - порядок автоморфизма
	 */
	public abstract void constructGKGraph(int autOrder);
	
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
	
	@Override
	public PrimeNumberGraph constructGKGraph() {
		// заглушка
		return null;
	}
	
}