package Test.Implementations.GroupGraphConstructor;

import java.util.List;

import Test.Helper.CommonTestHelper;
import org.junit.Test;

import com.google.common.collect.Lists;

import Kernel.Graph.Edge;
import Kernel.Graph.PrimeNumberGraph;
import Kernel.Graph.SimpleVertex;
import Kernel.Graph.Vertex;
import Kernel.GraphConstructor.Concrete.LieTypeGroupGraphConstructor;
import Kernel.Group.LieTypeGroup;
import Kernel.Resolvers.Concrete.LieTypeGroupGraphConstructorResolver;
import Kernel.Resolvers.Concrete.LieTypeGroupTypeResolver;
import Kernel.Utils.ArithmeticUtils;
import Kernel.Utils.MainLogger;
import Test.Implementations.Helper.AutLieTypeGroupTestHelper;

public class AbstractLieTypeGroup_Test {

	protected LieTypeGroup group;
	protected PrimeNumberGraph graph;
	
	protected void determineGroupWithGraph(String name) {
		this.group = LieTypeGroupTypeResolver.resolve(name);
		LieTypeGroupGraphConstructor constructor = LieTypeGroupGraphConstructorResolver.resolve(group);
		this.graph = constructor.constructGKGraph();
		this.graph.printConsole();
	}
	
	protected List<Vertex<?>> computeVList() {
		List<Vertex<?>> vList = Lists.newArrayList();
		List<Integer> prDivList = ArithmeticUtils.getAllPrimeDevisors(this.group.getOrder());
		for (int i : prDivList) {
			vList.add(new SimpleVertex(i));
		}
		return vList;
	}
	
	/**
	 * Метод осуществляет проверку, использующуюся в тесте: эквивалентен ли полученный граф тому, что проверяется
	 * @param groupName
	 * @param verticesStr
	 * @param edgesStr
	 * @return
	 */
	protected boolean checkEquality(String groupName, String verticesStr, String edgesStr) {
		determineGroupWithGraph(groupName);
		PrimeNumberGraph gr = getParsedPrimeNumberGraph(verticesStr, edgesStr);
		boolean result = gr.equals(graph);
		if (!result) {
			CommonTestHelper.printDiff(gr, graph);
		}
		return result;
	}
	
	/**
	 * Метод возвращает граф простых чисел по заданному строковому представлению множества вершин и множества ребер
	 * @param verticesStr 	строка вида "a_1,a_2,...,a_n"
	 * @param edgesStr 		строка вида "{a_1,b_1},{a_2,b_2},...,{a_n,b_n}"
	 * @return
	 */
	protected PrimeNumberGraph getParsedPrimeNumberGraph(String verticesStr, String edgesStr) {
		List<Vertex<?>> vertices = getParsedVerticesList(verticesStr);
		List<Edge> edges = getParsedEdgesList(edgesStr);
		return new PrimeNumberGraph(vertices, edges);
	}
	
	/**
	 * Метод возвращает коллекцию пропарсенных вершин. </br>
	 * Формат строки: "a_1,a_2,...,a_n"
	 * @param verticesStr
	 * @return
	 */
	protected List<Vertex<?>> getParsedVerticesList(String verticesStr) {
		return AutLieTypeGroupTestHelper.getParsedVerticesList(verticesStr);
	}
	
	/**
	 * Метод возвращает коллекцию пропарсенных ребер
	 * @param edgesStr
	 * @return
	 */
	protected List<Edge> getParsedEdgesList(String edgesStr) {
		return AutLieTypeGroupTestHelper.getParsedEdgesList(edgesStr);
	}
	
	/**
	 * Метод возвращает коллекцию ребер в строковом формате. </br>
	 * Формат строки: "{a_1,b_1},{a_2,b_2},...,{a_n,b_n}"
	 * @param edgesString
	 * @return коллекция строк вида "вершина_1,вершина_2"
	 */
	protected List<String> parseEdgesList(String edgesString) {
		return CommonTestHelper.parseEdgesList(edgesString);
	}

	private static final String TEST_VERTICES_STRING = "2,107,479,619";
	private static final String TEST_EDGES_STRING = "{2,107},{479,619},{2,619}";
	
	@Test
	public void testPrimeNumberGraphCreator() {
		PrimeNumberGraph graph = getParsedPrimeNumberGraph(TEST_VERTICES_STRING, TEST_EDGES_STRING);
		graph.printConsole();
	}
	
	@Test
	public void testVerticesListCreator() {
		List<Vertex<?>> result = getParsedVerticesList(TEST_VERTICES_STRING);
		for (Vertex<?> v : result) {
			MainLogger.info(v.getVertex().toString());
		}
	}
	
	@Test
	public void testEdgeListCreator() {
		List<Edge> result = getParsedEdgesList(TEST_EDGES_STRING);
		for (Edge edge : result) {
			MainLogger.info(edge.getVertexA().getVertex().toString() + "," + edge.getVertexB().getVertex().toString());
		}
	}
	
	@Test
	public void testEdgesParser() {
		List<String> result = parseEdgesList(TEST_EDGES_STRING);
		for (int i=0; i<result.size(); i++) {
			MainLogger.info(result.get(i));
		}
	}
	
}