package Test.Implementations.Helper;

import java.util.List;
import java.util.Map;
import java.util.Set;

import Test.Helper.CommonTestHelper;
import org.junit.Assert;
import org.junit.Test;

import Kernel.Graph.Edge;
import Kernel.Graph.PrimeNumberGraph;
import Kernel.Graph.Vertex;
import Kernel.Group.LieTypeGroup;
import Kernel.Utils.MainLogger;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class GraphAndFieldAutLieTypeGroupTestHelper {
	
	protected static final String GRAPH_OR_FIELD_AUT_EDGES_DELIM = "#";
		
	/**
	 * Метод проверяет равенство графов простых чисел расширений конкретных групп графовыми/полевыми автоморфизмами
	 * @param groupName		--- наименование группы
	 * @param verticesStr	--- список вершин ГПЧ
	 * @param edgesStrs		--- строки "порядок графового/полевого авт. + список ребер ГПЧ"
	 * @return true, если совпадают, false иначе
	 */
	public static boolean checkEqualities(LieTypeGroup group, Map<Integer, List<PrimeNumberGraph>> graphsMap, String verticesStr, String ... edgesStrs) {
		Map<Integer, List<PrimeNumberGraph>> parsedGraphsMap = getParsedPrimeNumberGraphs(verticesStr, edgesStrs);
		if (parsedGraphsMap.keySet().size() == 1 && parsedGraphsMap.keySet().contains(1)) {
			return parsedGraphsMap.get(1).get(0).equals(group.getGraph());
		} else {
			return checkEqualsOfGraphsMap(graphsMap, parsedGraphsMap);
		}
	}
	
	/**
	 * Метод проверяет равенство двух Map - вычисленного и пропарсенного
	 * @param origMap --- проверяемый Map
	 * @param compMap --- вычисленный Map
	 * @return true, если совпадают, false иначе
	 */
	private static boolean checkEqualsOfGraphsMap(Map<Integer, List<PrimeNumberGraph>> origMap, Map<Integer, List<PrimeNumberGraph>> compMap) {
		Set<Integer> origSet = origMap.keySet();
		Set<Integer> compSet = compMap.keySet();
		if (!origSet.equals(compSet)) {
			printDiffOfGraphOrFieldAutOrders(origSet, compSet);
			return false;
		} else {
			for (int key : origSet) {
				List<PrimeNumberGraph> graphsList = origMap.get(key);
				List<PrimeNumberGraph> parsedGraphList = compMap.get(key);
				if (!((graphsList.size() == parsedGraphList.size()) && (graphsList.containsAll(parsedGraphList)))) {
					printDiffOfGraphOrFieldAutGraphs(parsedGraphList, graphsList, key);
					return false;
				}
			}
		}
		return true;
	}
	
	/**
	 * Метод печатает в лог ошибки в случае несовпадения двух Set-ов с порядками графовых/полевых автоморфизмов 
	 * @param origSet --- проверяемый результат
	 * @param compSet --- вычисленный результат
	 */
	private static void printDiffOfGraphOrFieldAutOrders(Set<Integer> origSet, Set<Integer> compSet) {
		for (Integer o : origSet) {
			if (!compSet.contains(o)) {
				MainLogger.info("Проверяемый результат содержит лишний графовый/полевой автоморфизм порядка " + o);
			}
		}
		for (Integer o : compSet) {
			if (!origSet.contains(o)) {
				MainLogger.info("Проверяемый результат не содержит графовый/полевой автоморфизм порядка " + o);
			}
		}
	}
	
	/**
	 * Метод печатает в лог ошибки в случае несовпадения двух List-ов с ГПЧ расширений полевыми автоморфизмами 
	 * @param origList --- проверяемый результат
	 * @param compList --- вычисленный результат
	 */
	private static void printDiffOfGraphOrFieldAutGraphs(List<PrimeNumberGraph> origList, List<PrimeNumberGraph> compList, Integer order) {
		MainLogger.info("====Результаты вычислений для гр./пол. автоморфизма порядка " + order + "====");
		for (PrimeNumberGraph gr : compList) {
			MainLogger.info("Граф № " + (compList.indexOf(gr) + 1));
			gr.printConsole();
		}
		for (PrimeNumberGraph gr : origList) {
			if (!compList.contains(gr)) {
				MainLogger.info("ОШИБКА! Следующий проверяемый граф не совпадает ни с одним вычисленным.");
				gr.printConsole();
			}
		}
		for (PrimeNumberGraph gr : compList) {
			if (!origList.contains(gr)) {
				MainLogger.info("ОШИБКА! Следующий вычисленный граф не совпадает ни с одним проверяемым.");
				gr.printConsole();
			}
		}
	}
		
	/**
	 * Метод возвращает коллекцию графов простых чисел по заданному строковому представлению множества вершин, множества ребер
	 * и порядка соотв. графового/полевого автоморфизма
	 * @param verticesStr 	строка вида "a_1,a_2,...,a_n"
	 * @param edgesStr 		строка вида "m#{a_1,b_1},{a_2,b_2},...,{a_n,b_n}", где m - порядок графового/полевого автоморфизма
	 * @return
	 */
	protected static Map<Integer, List<PrimeNumberGraph>> getParsedPrimeNumberGraphs(String verticesStr, String ... edgesStr) {
		Map<Integer, List<PrimeNumberGraph>> result = Maps.newHashMap();
		List<Vertex<?>> vertices = AutLieTypeGroupTestHelper.getParsedVerticesList(verticesStr);
		for (String eStr : edgesStr) {
			Integer autOrder = getParsedGraphOrFieldAutOrder(eStr);
			List<Edge> edgesList = getParsedEdjesList(eStr);
			PrimeNumberGraph currentGraph = new PrimeNumberGraph(vertices, edgesList);
			if (!result.containsKey(autOrder)) {
				result.put(autOrder, Lists.newArrayList(currentGraph));
			} else {
				List<PrimeNumberGraph> currentGraphList = result.get(autOrder);
				currentGraphList.add(currentGraph);
			}
		}
		return result;
	}
	
	/**
	 * Метод возвращает порядок полевого автоморфизма
	 * @param input
	 * @return
	 */
	private static int getParsedGraphOrFieldAutOrder(String input) {
		int index = input.indexOf(GRAPH_OR_FIELD_AUT_EDGES_DELIM);
		return index > 0 ? Integer.parseInt(input.substring(0, index)) : 1;
	}
	
	public static List<String> parseEdgesList(String input) {
		int index = input.indexOf(GRAPH_OR_FIELD_AUT_EDGES_DELIM);
		String edgesString = index > 0 ? input.substring(index + 1) : input;
		return CommonTestHelper.parseEdgesList(edgesString);
	}
	
	/**
	 * Метод возвращает коллекцию пропарсенных ребер
	 * @param edgesStr
	 * @return
	 */
	public static List<Edge> getParsedEdjesList(String edgesStr) {
		List<String> edgesListStr = parseEdgesList(edgesStr);
		return AutLieTypeGroupTestHelper.constructEdgesList(edgesListStr);
	}
	
	private static final String VERTICES_STR = "2,3,5,7,17,41,43,73,521";
	
	private static final String TEST_STR_1_1 = "2#{2,3},{5,7},{17,41}";
	private static final String TEST_STR_2_1 = "3#{2,5},{5,17},{17,43}";
	private static final String TEST_STR_3_1 = "3#{3,73},{5,521}";
	
	private static final String TEST_STR_1_2 = "3#{3,73},{5,521}";
	private static final String TEST_STR_2_2 = "2#{2,3},{5,7},{17,41}";
	private static final String TEST_STR_3_2 = "3#{2,5},{5,17},{17,43}";
	
	private static final String TEST_STR_1_3 = "3#{3,73},{5,521}";
	private static final String TEST_STR_2_3 = "2#{2,3},{5,7},{17,41}";
	
	private static final String TEST_STR_1_4 = "3#{3,73},{5,521}";
	private static final String TEST_STR_2_4 = "2#{2,3},{5,7},{17,41}";
	private static final String TEST_STR_3_4 = "3#{2,5},{5,17},{17,43}";
	private static final String TEST_STR_4_4 = "5#{2,5},{5,17},{17,43}";
	
	private static final String TEST_STR_1_5 = "3#{3,73},{5,521}";
	private static final String TEST_STR_2_5 = "2#{2,3},{5,7},{17,41}";
	private static final String TEST_STR_3_5 = "3#{2,5},{5,17},{17,7}";
	
	@Test
	public void getParsedGraphOrFieldAutOrder_test() {
		MainLogger.info(Integer.toString(getParsedGraphOrFieldAutOrder(TEST_STR_1_1)));
		MainLogger.info(Integer.toString(getParsedGraphOrFieldAutOrder(TEST_STR_2_1)));
		MainLogger.info(Integer.toString(getParsedGraphOrFieldAutOrder(TEST_STR_3_1)));
	}
	
	@Test
	public void getParsedPrimeNumberGraph_test() {
		Map<Integer, List<PrimeNumberGraph>> result = getParsedPrimeNumberGraphs(VERTICES_STR, TEST_STR_1_1, TEST_STR_2_1, TEST_STR_3_1);
		for (Integer order : result.keySet()) {
			MainLogger.info("Порядок графового/полевого автоморфизма: " + Integer.toString(order));
			List<PrimeNumberGraph> graphList = result.get(order);
			for (PrimeNumberGraph gr : graphList) {
				MainLogger.info("Граф № " + (graphList.indexOf(gr) + 1));
				gr.printConsole();
			}
		}
	}
	
	@Test
	public void checkEqualsOfGraphsMap_test() {
		Map<Integer, List<PrimeNumberGraph>> result_1 = getParsedPrimeNumberGraphs(VERTICES_STR, TEST_STR_1_1, TEST_STR_2_1, TEST_STR_3_1);
		Map<Integer, List<PrimeNumberGraph>> result_2 = getParsedPrimeNumberGraphs(VERTICES_STR, TEST_STR_1_2, TEST_STR_2_2, TEST_STR_3_2);
		Assert.assertTrue(checkEqualsOfGraphsMap(result_1, result_2));
	}
	
	@Test
	public void checkNonEqualsOfGraphsMap_test_1() {
		Map<Integer, List<PrimeNumberGraph>> result_1 = getParsedPrimeNumberGraphs(VERTICES_STR, TEST_STR_1_1, TEST_STR_2_1, TEST_STR_3_1);
		Map<Integer, List<PrimeNumberGraph>> result_2 = getParsedPrimeNumberGraphs(VERTICES_STR, TEST_STR_1_3, TEST_STR_2_3);
		Assert.assertFalse(checkEqualsOfGraphsMap(result_1, result_2));
	}
	
	@Test
	public void checkNonEqualsOfGraphsMap_test_2() {
		Map<Integer, List<PrimeNumberGraph>> result_1 = getParsedPrimeNumberGraphs(VERTICES_STR, TEST_STR_1_1, TEST_STR_2_1, TEST_STR_3_1);
		Map<Integer, List<PrimeNumberGraph>> result_2 = getParsedPrimeNumberGraphs(VERTICES_STR, TEST_STR_1_4, TEST_STR_2_4, TEST_STR_3_4, TEST_STR_4_4);
		Assert.assertFalse(checkEqualsOfGraphsMap(result_1, result_2));
	}
	
	@Test
	public void checkNonEqualsOfGraphsMap_test_3() {
		Map<Integer, List<PrimeNumberGraph>> result_1 = getParsedPrimeNumberGraphs(VERTICES_STR, TEST_STR_1_1, TEST_STR_2_1, TEST_STR_3_1);
		Map<Integer, List<PrimeNumberGraph>> result_2 = getParsedPrimeNumberGraphs(VERTICES_STR, TEST_STR_1_5, TEST_STR_2_5, TEST_STR_3_5);
		Assert.assertFalse(checkEqualsOfGraphsMap(result_1, result_2));
	}
	
}