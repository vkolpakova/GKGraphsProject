package Kernel.GraphConstructor.Series;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

import Kernel.Graph.Edge;
import Kernel.Graph.PrimeNumberGraph;
import Kernel.Graph.SymbolVertex;
import Kernel.Graph.Vertex;
import Kernel.Group.Series;
import Kernel.Polynom.IndecomposablePolynom;
import Kernel.Polynom.PolynomConstants;
import Kernel.Polynom.SimplePolynom;
import Kernel.Utils.MainLogger;

/**
 * Конструктор графа Грюнберга --- Кегеля группы Inndiag для группы из серии
 * 
 * @author v.kolpakova
 *
 */
public class InndiagSeriesGraphConstructor extends AutSubgroupSeriesGraphConstructor {
	
	/**
	 * Map для хранения возможных разложений порядков торов. </br>
	 * <b>Ключ: </b> показатель степени n_i в разложении;
	 * <b>Значение:</b> разложение полинома на неприводимые сомножители.
	 */
	protected Map<SimplePolynom, List<IndecomposablePolynom>> partitionsPolynoms;
		
	/**
	 * Список, каждый элемент которого соответсвует максимальному тору. </br>
	 * Для каждого максимального тора хранится спиок множителей в его порядке.
	 */
	protected List<List<SimplePolynom>> maxTorusList;

	public InndiagSeriesGraphConstructor(Series group) {
		super(group);
		this.partitionsPolynoms = Maps.newHashMap();
		this.maxTorusList = Lists.newArrayList();
	}
	
	/**
	 * Метод строит {@value #partitionsPolynoms}. </br>
	 * Переопределяется в потомках.
	 */
	protected void computePartitionsPolynoms() {}
	
	/**
	 * Метод строит {@value #maxTorusList}. </br>
	 * Переопределяется в потомках.
	 */
	protected void computeMaxTorsList() {}
	
	/**
	 * Метод по сути является резолвером для построения небольших полиномов, реализующих {@link SimplePolynom}
	 * @param poly
	 * @return
	 */
	protected List<IndecomposablePolynom> getPolynomCompose(SimplePolynom poly) {
		List<IndecomposablePolynom> result = Lists.newArrayList();
		int n = poly.getN();
		String epsilon = poly.getEpsilon();
		if (epsilon.equals(SimplePolynom.MINUS)) {
			if (n == 1) {
				result.add(new IndecomposablePolynom(this.group.getSeriesOrder().getMultiplierByDescr(PolynomConstants.QM1)));
			} else if (n == 2) {
				result.add(new IndecomposablePolynom(this.group.getSeriesOrder().getMultiplierByDescr(PolynomConstants.QP1)));
				result.add(new IndecomposablePolynom(this.group.getSeriesOrder().getMultiplierByDescr(PolynomConstants.QM1)));
			} else if (n == 3) {
				result.add(new IndecomposablePolynom(this.group.getSeriesOrder().getMultiplierByDescr(PolynomConstants.QM1)));
				result.add(new IndecomposablePolynom(this.group.getSeriesOrder().getMultiplierByDescr(PolynomConstants.Q2PQP1)));
			} else if (n == 4) {
				result.add(new IndecomposablePolynom(this.group.getSeriesOrder().getMultiplierByDescr(PolynomConstants.QP1)));
				result.add(new IndecomposablePolynom(this.group.getSeriesOrder().getMultiplierByDescr(PolynomConstants.QM1)));
				result.add(new IndecomposablePolynom(this.group.getSeriesOrder().getMultiplierByDescr(PolynomConstants.Q2P1)));
			}
		} else {
			if (n == 1) {
				result.add(new IndecomposablePolynom(this.group.getSeriesOrder().getMultiplierByDescr(PolynomConstants.QP1)));
			} else if (n == 2) {
				result.add(new IndecomposablePolynom(this.group.getSeriesOrder().getMultiplierByDescr(PolynomConstants.Q2P1)));
			} else if (n == 3) {
				result.add(new IndecomposablePolynom(this.group.getSeriesOrder().getMultiplierByDescr(PolynomConstants.QP1)));
				result.add(new IndecomposablePolynom(this.group.getSeriesOrder().getMultiplierByDescr(PolynomConstants.Q2MQP1)));
			} else if (n == 4) {
				try {
					throw new Exception("Недопустимое значение в качестве неприводимого полинома");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}		
		return result;
	}

	@Override
	protected void computeCentralizationsMap() {} // заглушка

	@Override
	public int getOrder() {
		return this.group.getOutdiagOrder();
	}
	
	@Override
	public void constructGKGraph(int autOrder) { // Заглушка
	}
	
	@Override
	public List<PrimeNumberGraph> constructGKGraphs() {
		computePartitionsPolynoms();
		computeMaxTorsList();
		List<PrimeNumberGraph> result = Lists.newArrayList();
		for (List<SimplePolynom> torus : maxTorusList) {
			result.add(constructTorusGKGraph(torus));
		}
		return result;
	}
	
	/**
	 * Метод строит граф Грюнберга --- Кегеля для некоторого максимального тора
	 * @param torus
	 * @return
	 */
	protected PrimeNumberGraph constructTorusGKGraph(List<SimplePolynom> torus) {
		PrimeNumberGraph originalGoupGraph = this.groupGraph;
		if (this.checkNotTrivial()) {
			Set<SymbolVertex> allVertices = getAllVerticesOfTorus(torus);
			PrimeNumberGraph torusGraph = constructFullGraph(allVertices);
			return constructAdditionalGraph(originalGoupGraph, torusGraph);
		} else {
			return originalGoupGraph;
		}
	}
	
	/**
	 * Метод возвращает все врешины, являющиеся простыми делителями порядка некоторого максимального тора
	 * @param polynom
	 * @return
	 */
	protected Set<SymbolVertex> getAllVerticesOfTorus(List<SimplePolynom> torus) {
		Set<SymbolVertex> result = Sets.newHashSet();
		for (SimplePolynom poly : torus) {
			result.addAll(getAllVerticesOfSimplePolynom(poly));
		}
		return result;
	}
	
	/**
	 * Метод возвращает все врешины, являющиеся простыми делителями некоторого SimplePolynom-а
	 * @param polynom
	 * @return
	 */
	protected Set<SymbolVertex> getAllVerticesOfSimplePolynom(SimplePolynom polynom) {
		Set<SymbolVertex> result = Sets.newHashSet();
		Set<IndecomposablePolynom> polys = Sets.newHashSet(partitionsPolynoms.get(polynom));		
		for (IndecomposablePolynom poly : polys) {
			List<String> verNames = this.group.getSeriesOrder().getMultiplierByDescr(poly.getDescription()).getSimpleDevisors();
			for (String verName : verNames) {
				result.add(new SymbolVertex(verName));
			}
		}
		return result;
	}
	
	/**
	 * Метод строит полный граф (т.е. все вершины связаны) максимального тора.
	 * @param vertices
	 * @return
	 */
	protected PrimeNumberGraph constructFullGraph(Set<SymbolVertex> vertices) {
		List<Edge> allEdges = Lists.newArrayList();
		List<SymbolVertex> verIter = Lists.newArrayList(vertices);
		for (int i = 0; i < vertices.size(); i ++) {
			for (int j = i + 1; j < vertices.size(); j ++) {
				Edge edge = new Edge(verIter.get(i), verIter.get(j));
				allEdges.add(edge);
			}
		}
		return new PrimeNumberGraph(Lists.newArrayList(vertices), allEdges);
	}
	
	/**
	 * Метод строит новый граф из старого (origGraph) добавлением недостающих ребер из нового графа
	 * @param origGraph
	 * @param newGraph
	 * @return
	 */
	protected PrimeNumberGraph constructAdditionalGraph(PrimeNumberGraph origGraph, PrimeNumberGraph newGraph) {
		List<Vertex<?>> verList = origGraph.getVerticesList();
		List<Edge> edgeList = Lists.newArrayList(origGraph.getEdgesList());
		List<Edge> additionalEdgeList = newGraph.getEdgesList();
		for (Edge newEdge : additionalEdgeList) {
			if (!origGraph.getEdgesList().contains(newEdge)) {
				MainLogger.info("*InndiagSeriesGraphConstructor* Add edge : {" + 
			newEdge.getVertexA().getVertex().toString() + ", " + newEdge.getVertexB().getVertex().toString() + "}");
				edgeList.add(newEdge);
			}
		}
		return new PrimeNumberGraph(verList, edgeList);
	}
	
	/**
	 * Метод возвращает полином с нужными параметрами из {@value #partitionsPolynoms}
	 * @param n
	 * @param epsilon
	 * @return
	 */
	protected SimplePolynom getSimplePolynomByParams(int n, String epsilon) {
		Set<SimplePolynom> polySet = partitionsPolynoms.keySet();
		for (SimplePolynom poly: polySet) {
			if ((poly.getN() == n) && (poly.getEpsilon().equals(epsilon))) {
				return poly;
			}
		}
		return null;
	}
	
}