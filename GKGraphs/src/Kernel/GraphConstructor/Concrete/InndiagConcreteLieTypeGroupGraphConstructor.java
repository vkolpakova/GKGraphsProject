package Kernel.GraphConstructor.Concrete;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.Lists;

import Kernel.Graph.Edge;
import Kernel.Graph.PrimeNumberGraph;
import Kernel.Graph.SimpleVertex;
import Kernel.Graph.Vertex;
import Kernel.Group.LieTypeGroup;
import Kernel.Utils.ArithmeticUtils;
import Kernel.Utils.MainLogger;

/**
 * Конструктор графа Грюнберга --- Кегеля группы Inndiag для конкретной группы лиева типа
 * 
 * @author v.kolpakova
 *
 */
public abstract class InndiagConcreteLieTypeGroupGraphConstructor<G extends LieTypeGroup> extends AutSubgroupConcreteLieTypeGroupGraphConstructor<LieTypeGroup> {
	
	/**
	 * Коллекция коллекций простых делителей всех возможных порядков максимальных торов группы лиева типа
	 */
	protected List<List<Integer>> torOrdersPartitions;
	
	/**
	 * Добавленные ребра к базовому графу простых чисел группы
	 */
	protected List<Edge> addedEdgesList = Lists.newArrayList();

	public InndiagConcreteLieTypeGroupGraphConstructor(G group) {
		super(group);
	}
	
	@Override
	public PrimeNumberGraph constructGKGraph() {
		if (group.getInInndiagIndex() > 1) {
			// в графе Inndiag как подграф содержится граф группы
			List<Edge> edgesList = new ArrayList<Edge>(groupGraph.getEdgesList());
			List<Vertex<?>> verticesList = computeVerticesList(ArithmeticUtils.getAllPrimeDevisors(this.group.getOrder()));
			this.torOrdersPartitions = computeTorOrdersPartitions();
			for (List<Integer> intList : this.torOrdersPartitions) {
				List<Edge> fullTorEdgesList = getFullTorEdgesList(intList);
				for (Edge edge : fullTorEdgesList) {
					if (!edgesList.contains(edge)) {
						// добавляются полученные в Inndiag ребра
						edgesList.add(edge);
						addedEdgesList.add(edge);
						MainLogger.info("*InndiagConcreteLieTypeGroupGraphConstructor* add {" + edge.getVertexA().getVertex().toString() + ", " 
						+ edge.getVertexB().getVertex().toString() + "}");
					}
				}
			}
			return new PrimeNumberGraph(verticesList, edgesList);
		} else {
			return groupGraph;
		}
	}
	
	/**
	 * Метод строит полный граф (полный массив ребер) на основе данного макс. тора
	 * @param intList
	 * @return коллекция ребер
	 */
	private List<Edge> getFullTorEdgesList(List<Integer> intList) {
		List<Edge> result = new ArrayList<Edge>();
		int intListSize = intList.size();
		for (int i = 0; i < intListSize; i++) {
			for (int j = i + 1; j < intListSize; j++) {
				Edge edge = new Edge(new SimpleVertex(intList.get(i)), new SimpleVertex(intList.get(j)));
				result.add(edge);
			}
		}
		return result;
	}
	
	/**
	 * Метод строит коллекцию вершин графа, состоящую из простых делителей порядка группы
	 * @param primeDevisors
	 * @return
	 */
	private List<Vertex<?>> computeVerticesList(List<Integer> primeDevisors) {
		List<Vertex<?>> vList = Lists.newArrayList();
		for (int i : primeDevisors) {
			vList.add(new SimpleVertex(i));
		}
		return vList;
	}
	
	/**
	 * Получить коллекцию простых делителей всех возможных порядков макс. торов
	 * @return соотв. коллекция
	 */
	protected abstract List<List<Integer>> computeTorOrdersPartitions();
	
	@Override
	protected void computeCentralizationsMap() { } // заглушка абстрактного метода суперкласса
	
	@Override
	public int getOrder() {
		return this.group.getInInndiagIndex();
	}
	
	@Override
	public List<Edge> getAddedEdgesList() {
		return this.addedEdgesList;
	}
	
}