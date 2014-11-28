package Kernel.GraphConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Kernel.Graph.Edge;
import Kernel.Graph.PrimeNumberGraph;
import Kernel.Graph.SimpleVertex;
import Kernel.Group.LieTypeGroup;
import Kernel.Utils.ArithmeticUtils;
import Kernel.Utils.MainLogger;

/**
 * Конструктор графа Грюнберга --- Кегеля группы InndiagPhi для конкретной группы лиева типа
 * 
 * @author v.kolpakova
 *
 */
public abstract class FieldAutConcreteLieTypeGroupGraphConstructor<G extends LieTypeGroup> extends AutSubgroupConcreteLieTypeGroupGraphConstructor<LieTypeGroup> {
	
	public FieldAutConcreteLieTypeGroupGraphConstructor(LieTypeGroup group) {
		super(group);
		this.centralizationsMap = new HashMap<Integer, List<LieTypeGroup>>();
		this.graphsMap= new HashMap<Integer, List<PrimeNumberGraph>>();
		computeCentralizationsMap();
	}
	
	@Override
	protected void computeCentralizationsMap() {
		List<Integer> fieldGroupOrderPrimeDivList = ArithmeticUtils.getAllPrimeDevisors(this.group.getFieldAutGroupOrder());
		for (int x : fieldGroupOrderPrimeDivList) {
			List<LieTypeGroup> centralizer = computeCentralizer(x);
			this.centralizationsMap.put(x, centralizer);
		}
	}
	
	/**
	 * Метод возвращает централизатор полевого автоморфизма порядка x
	 * @param x --- порядок полевого автоморфизма
	 * @return
	 */
	protected abstract List<LieTypeGroup> computeCentralizer(int x);

	/**
	 * Метод возвращает граф группы Inndiag*f, где f  --- полевой автоморфизм простого порядка x
	 * @param x --- порядок полевого автоморфизма (простое число)
	 * @return
	 */
	public List<PrimeNumberGraph> constructGKGraph(int x) {
		List<PrimeNumberGraph> result = new ArrayList<PrimeNumberGraph>();
		int phiOrder = this.group.getFieldAutGroupOrder();
		if (phiOrder != 1) {
			List<Edge> resultEdgesList = new ArrayList<Edge>(this.groupGraph.getEdgesList());
			List<LieTypeGroup> centralizators = centralizationsMap.get(x);
			for (LieTypeGroup centralizator : centralizators) {
				List<Integer> centrPrimeDivList = ArithmeticUtils.getAllPrimeDevisors(centralizator.getOrder());
				List<Edge> fullCentrEdgesList = getFullCentrEdgesList(x, centrPrimeDivList);
				for (Edge edge : fullCentrEdgesList) {
					if (!this.groupGraph.getEdgesList().contains(edge)) {
						// доюавляются полученные в InndiagPhi ребра
						resultEdgesList.add(edge);
						MainLogger.info("*FieldAutConcreteLieTypeGroupGraphConstructor* add {" + edge.getVertexA().getVertex().toString() + ", " 
								+ edge.getVertexB().getVertex().toString() + "}");
					}
				}
				result.add(new PrimeNumberGraph(resultEdgesList));
			}
		} else {
			// в случае, если полевых автоморфизмов нет, возвращаем исходный граф группы
			result.add(this.groupGraph);
		}
		return result;
	}
	
	/**
	 * Метод возвращает Map с графами Грюнберга --- Кегеля групп вида Inndiag*f,
	 * где f --- полевой автоморфизм некоторого простого порядка
	 * @return
	 */
	public Map<Integer, List<PrimeNumberGraph>> constructGraphs() {
		if (this.graphsMap.isEmpty()) {
			int phiOrder = this.group.getFieldAutGroupOrder();
			if (phiOrder != 1) {
				List<Integer> primeDivPhiOrderList = ArithmeticUtils.getAllPrimeDevisors(phiOrder);
				for (int div : primeDivPhiOrderList) {
					List<PrimeNumberGraph> graph = constructGKGraph(div);
					this.graphsMap.put(div, graph);
				}
			}
 		}
		return this.graphsMap;
	}
	
	private List<Edge> getFullCentrEdgesList(int n, List<Integer> primesList) {
		List<Edge> result = new ArrayList<Edge>(primesList.size());
		for (int num : primesList) {
			if (num != n) {
				Edge edge = new Edge(new SimpleVertex(n), new SimpleVertex(num));
				result.add(edge);
			}
		}
		return result;
	}

	@Override
	public PrimeNumberGraph constructGKGraph() {
		return null;
	}
	
}