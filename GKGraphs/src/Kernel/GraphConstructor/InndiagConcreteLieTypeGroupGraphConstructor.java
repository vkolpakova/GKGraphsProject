package Kernel.GraphConstructor;

import java.util.ArrayList;
import java.util.List;

import Kernel.Graph.Edge;
import Kernel.Graph.PrimeNumberGraph;
import Kernel.Graph.SimpleVertex;
import Kernel.Group.LieTypeGroup;
import Kernel.Utils.MainLogger;

/**
 * Конструктор графа Грюнберга --- Кегеля группы Inndiag для конкретной группы лиева типа
 * 
 * @author v.kolpakova
 *
 */
public abstract class InndiagConcreteLieTypeGroupGraphConstructor<G extends LieTypeGroup> extends AbstractGraphConstructor<LieTypeGroup> {
	
	/**
	 * Граф Грюнберга --- Кегеля конкретной группы лиева типа
	 */
	protected PrimeNumberGraph groupGraph;
	
	/**
	 * Коллекция коллекций простых делителей всех возможных порядков максимальных торов группы лиева типа
	 */
	protected List<List<Integer>> torOrdersPartitions;

	public InndiagConcreteLieTypeGroupGraphConstructor(G group) {
		super(group);
		this.groupGraph = group.getGraph();
	}
	
	@Override
	public PrimeNumberGraph constructGKGraph() {
		// в графе Inndiag как подграф содержится граф группы
		List<Edge> edgesList = groupGraph.getEdgesList();
		this.torOrdersPartitions = computeTorOrdersPartitions();
		for (List<Integer> intList : this.torOrdersPartitions) {
			List<Edge> fullTorEdgesList = getFullTorEdgesList(intList);
			for (Edge edge : fullTorEdgesList) {
				if (!edgesList.contains(edge)) {
					// добавляются полученные в Inndiag ребра
					edgesList.add(edge);
					MainLogger.info("*InndiagConcreteLieTypeGroupGraphConstructor* add {" + edge.getVertexA().getVertex().toString() + ", " 
					+ edge.getVertexB().getVertex().toString() + "}");
				}
			}
		}
		// FIXME ВНИМАНИЕ! нарушается лексико-графический порядок (тесты)
		return new PrimeNumberGraph(edgesList);
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
	 * Получить коллекцию простых делителей всех возможных порядков макс. торов
	 * @return соотв. коллекция
	 */
	protected abstract List<List<Integer>> computeTorOrdersPartitions();
	
}