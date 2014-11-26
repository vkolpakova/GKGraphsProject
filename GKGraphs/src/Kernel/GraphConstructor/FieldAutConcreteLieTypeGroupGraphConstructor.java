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

	/**
	 * Коллекция Map для хранения полевых автоморфизмов и их централизаторов. </br>
	 * <b>Ключ:</b> порядок автоморфизма (простое число); </br>
	 * <b>Значение:</b> группа лиева типа, которой изоморфен централизатор соотв. автоморфизма.
	 */
	protected Map<Integer, LieTypeGroup> centralizationsMap;
	
	/**
	 * Коллекция Map для хранения полевых автоморфизмов и графов Грюнберга --- Кегеля подгрупп вида Pf </br>
	 * <b>Ключ:</b> порядок автоморфизма (простое число); </br>
	 * <b>Значение:</b> граф соотв. подгруппы в Aut
	 */
	protected Map<Integer, PrimeNumberGraph> graphsMap;
	
	public FieldAutConcreteLieTypeGroupGraphConstructor(LieTypeGroup group) {
		super(group);
		this.centralizationsMap = new HashMap<Integer, LieTypeGroup>();
		this.graphsMap= new HashMap<Integer, PrimeNumberGraph>();
		computeCentralizationsMap();
	}
	
	protected void computeCentralizationsMap() {
		List<Integer> fieldGroupOrderPrimeDivList = ArithmeticUtils.getAllPrimeDevisors(this.group.getFieldAutGroupOrder());
		for (int x : fieldGroupOrderPrimeDivList) {
			LieTypeGroup centralizer = computeCentralizer(x);
			this.centralizationsMap.put(x, centralizer);
		}
	}
	
	/**
	 * Метод возвращает централизатор полевого автоморфизма порядка x
	 * @param x --- порядок полевого автоморфизма
	 * @return
	 */
	protected abstract LieTypeGroup computeCentralizer(int x);

	/**
	 * Метод возвращает граф группы Inndiag*f, где f  --- полевой автоморфизм простого порядка x
	 * @param x --- порядок полевого автоморфизма (простое число)
	 * @return
	 */
	public PrimeNumberGraph constructGKGraph(int x) {
		int phiOrder = this.group.getFieldAutGroupOrder();
		if (phiOrder != 1) {
			List<Edge> resultEdgesList = new ArrayList<Edge>(this.groupGraph.getEdgesList());
			LieTypeGroup centralizator = centralizationsMap.get(x);
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
			return new PrimeNumberGraph(resultEdgesList);
		} else {
			return this.groupGraph;
		}
	}
	
	/**
	 * Метод возвращает Map с графами Грюнберга --- Кегеля групп вида Inndiag*f,
	 * где f --- полевой автоморфизм некоторого простого порядка
	 * @return
	 */
	public Map<Integer, PrimeNumberGraph> constructGraphs() {
		if (this.graphsMap.isEmpty()) {
			int phiOrder = this.group.getFieldAutGroupOrder();
			if (phiOrder != 1) {
				List<Integer> primeDivPhiOrderList = ArithmeticUtils.getAllPrimeDevisors(phiOrder);
				for (int div : primeDivPhiOrderList) {
					PrimeNumberGraph graph = constructGKGraph(div);
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