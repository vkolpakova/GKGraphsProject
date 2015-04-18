package Kernel.GraphConstructor.Concrete.Helper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.google.common.collect.Lists;

import Kernel.Graph.Edge;
import Kernel.Graph.PrimeNumberGraph;
import Kernel.Graph.SimpleVertex;
import Kernel.Graph.Vertex;
import Kernel.GraphConstructor.Concrete.AutSubgroupConcreteLieTypeGroupGraphConstructor;
import Kernel.Group.LieTypeGroup;
import Kernel.Utils.ArithmeticUtils;
import Kernel.Utils.MainLogger;

/**
 * Хелпер для построения графов Грюнберга --- Кегеля группы, расширенной полевым или графовым автоморфизмом.
 * 
 * @author v.kolpakova
 *
 */
public class PhiAndGammaAutSubgroupHelper {
	
	protected AutSubgroupConcreteLieTypeGroupGraphConstructor<?> constructor;

	public PhiAndGammaAutSubgroupHelper(AutSubgroupConcreteLieTypeGroupGraphConstructor<?> constructor) {
		super();
		this.constructor = constructor;
	}
	
	/**
	 * Метод возвращает граф группы Inndiag*x, где x  --- полевой/графовый автоморфизм простого порядка x
	 * @param x --- порядок полевого автоморфизма (простое число)
	 */
	protected List<PrimeNumberGraph> constructGKGraph(int x) {
		List<PrimeNumberGraph> result = new ArrayList<PrimeNumberGraph>();
		if (constructor.checkNotTrivial()) {
			List<Vertex<?>> verticesList = computeVerticesList(ArithmeticUtils.getAllPrimeDevisors(constructor.getGroup().getOrder()));
			List<Edge> resultEdgesList = new ArrayList<Edge>(constructor.getGroupGraph().getEdgesList());
			List<LieTypeGroup> centralizators = constructor.getCentralizationsMap().get(x);
			for (LieTypeGroup centralizator : centralizators) {
				List<Integer> centrPrimeDivList = ArithmeticUtils.getAllPrimeDevisors(centralizator.getOrder());
				List<Edge> fullCentrEdgesList = getFullCentrEdgesList(x, centrPrimeDivList);
				for (Edge edge : fullCentrEdgesList) {
					if (!constructor.getGroupGraph().getEdgesList().contains(edge)) {
						// добавляются полученные в InndiagPhi ребра
						if (!resultEdgesList.contains(edge)) {
							resultEdgesList.add(edge);
							MainLogger.info("*" + constructor.getClass().getSimpleName() + "* add {" + edge.getVertexA().getVertex().toString() + ", " 
									+ edge.getVertexB().getVertex().toString() + "}; centralizer is " + centralizator.getFullName());
						}
					}
				}
				result.add(new PrimeNumberGraph(verticesList, resultEdgesList));
			}
		} else {
			// в случае, если автоморфизмов соотв. типа нет, возвращаем исходный граф группы
			result.add(constructor.getGroupGraph());
		}
		return result;
	}
	
	/**
	 * Метод возвращает Map с графами Грюнберга --- Кегеля групп вида Inndiag*x,
	 * где x --- полевой/ графовый автоморфизм некоторого простого порядка
	 */
	public Map<Integer, List<PrimeNumberGraph>> constructGraphs() {
		if (constructor.getGraphsMap().isEmpty()) {
			if (constructor.checkNotTrivial()) {
				int autSubgroupOrder = constructor.getOrder();
				List<Integer> primeDivSubgrOrderList = ArithmeticUtils.getAllPrimeDevisors(autSubgroupOrder);
				for (int div : primeDivSubgrOrderList) {
					List<PrimeNumberGraph> graph = constructGKGraph(div);
					constructor.getGraphsMap().put(div, graph);
				}
			} else {
				List<PrimeNumberGraph> result = new ArrayList<PrimeNumberGraph>();
				result.add(constructor.getGroupGraph());
				constructor.getGraphsMap().put(1, result);
			}
 		}
		return constructor.getGraphsMap();
	}
	
	/**
	 * Метод возвращает граф с ребрами вида "простое число n, простое число из коллекции primesList"
	 * @param n --- порядок автоморфизма, простое число
	 * @param primesList --- коллекция простых делителей порядка централизатора
	 */
	protected List<Edge> getFullCentrEdgesList(int n, List<Integer> primesList) {
		List<Edge> result = new ArrayList<Edge>(primesList.size());
		for (int num : primesList) {
			if (num != n) {
				Edge edge = new Edge(new SimpleVertex(n), new SimpleVertex(num));
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
	protected List<Vertex<?>> computeVerticesList(List<Integer> primeDevisors) {
		List<Vertex<?>> vList = Lists.newArrayList();
		for (int i : primeDevisors) {
			vList.add(new SimpleVertex(i));
		}
		return vList;
	}
	
}