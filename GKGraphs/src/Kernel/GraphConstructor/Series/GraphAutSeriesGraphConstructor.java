package Kernel.GraphConstructor.Series;

import java.util.List;

import com.google.common.collect.Lists;

import Kernel.Graph.Edge;
import Kernel.Graph.PrimeNumberGraph;
import Kernel.Graph.SymbolVertex;
import Kernel.Group.Series;
import Kernel.Polynom.CompoundPolynom;
import Kernel.Utils.MainLogger;

/**
 * Конструктор графа Грюнберга --- Кегеля расширения группы из серии некоторым графовым автоморфизмом
 * 
 * @author v.kolpakova
 *
 */
public class GraphAutSeriesGraphConstructor extends AutSubgroupSeriesGraphConstructor {

	public GraphAutSeriesGraphConstructor(Series group) {
		super(group);
	}
	
	@Override
	public void constructGKGraph(int autOrder) {
		List<PrimeNumberGraph> resultGraphsList = Lists.newArrayList();
		PrimeNumberGraph originalGraph = new PrimeNumberGraph(this.groupGraph);
		List<CompoundPolynom> polynoms = this.centralizationsMap.get(autOrder);
		for (CompoundPolynom polynom : polynoms) {
			List<String> allPrimeDevisors = polynom.getAllPrimeDevisors();
			List<Edge> maxDegreeEdgeList = constructMaxDegreeVertexEdgesList(autOrder, allPrimeDevisors);
			PrimeNumberGraph additionalGraph = constructAdditionalGraph(originalGraph, maxDegreeEdgeList);
			resultGraphsList.add(additionalGraph);
		}
		this.graphsMap.put(autOrder, resultGraphsList);
	}
	
	/**
	 * Метод строит коллекцию ребер, одна из вершин которой - порядок автоморфизма, вторая - вершина из некоторого списка
	 * @param autOrder - порядок автоморфизма
	 * @param allPrimeDevisors - список вершин, с которыми связывается одна вершина
	 * @return
	 */
	protected List<Edge> constructMaxDegreeVertexEdgesList(int autOrder, List<String> allPrimeDevisors) {
		List<Edge> result = Lists.newArrayList();
		String autOrderStr = Integer.toString(autOrder);
		for (String div : allPrimeDevisors) {
			result.add(new Edge(new SymbolVertex(autOrderStr), new SymbolVertex(div)));
		}
		return result;
	}
	
	/**
	 * Метод строит граф Грюнберга --- Кегеля по принципу: к оригинальному графу добавляются ребра из списка, которыхв нем нет
	 * @param originalGraph
	 * @param edges
	 * @return
	 */
	protected PrimeNumberGraph constructAdditionalGraph(PrimeNumberGraph originalGraph, List<Edge> edges) {
		PrimeNumberGraph resultGraph = new PrimeNumberGraph(originalGraph);
		List<Edge> origEdges = originalGraph.getEdgesList();
		for (Edge edge : edges) {
			if (!origEdges.contains(edge)) {
				MainLogger.info("*GraphAutSeriesGraphConstructor* Add edge {"+
						edge.getVertexA().getVertex().toString()+", "+edge.getVertexB().getVertex().toString()+"}");
				resultGraph.getEdgesList().add(edge);
			}
		}
		return resultGraph;
	}

	@Override
	public List<PrimeNumberGraph> constructGKGraphs() {
		List<Integer> autOrders = Lists.newArrayList(this.centralizationsMap.keySet());
		List<PrimeNumberGraph> resultList = Lists.newArrayList();
		for (int order : autOrders) {
			this.constructGKGraph(order);
			resultList.addAll(this.graphsMap.get(order));
		}
		return resultList;
	}

	@Override
	protected void computeCentralizationsMap() {} // определяется в потомках

	@Override
	public int getOrder() {
		return this.group.getGraphAutOrder();
	}
	
}