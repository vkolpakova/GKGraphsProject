package Test.Implementations.FieldAutGraphConstructor;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import Kernel.Graph.Edge;
import Kernel.Graph.PrimeNumberGraph;
import Kernel.Graph.Vertex;
import Kernel.GraphConstructor.Concrete.FieldAutConcreteLieTypeGroupGraphConstructor;
import Kernel.Resolvers.Concrete.FieldAutLieTypeGroupGraphConstructorResolver;
import Kernel.Resolvers.Concrete.LieTypeGroupTypeResolver;
import Kernel.Utils.MainLogger;
import Test.Implementations.GroupGraphConstructor.AbstractLieTypeGroup_Test;

public class AbstractFieldAutLieTypeGroup_Test extends AbstractLieTypeGroup_Test {
	
	protected static final String FIELD_AUT_EDJES_DELIM = "#";
	
	protected Map<Integer, List<PrimeNumberGraph>> graphsMap = Maps.newHashMap();
	
	@Override
	protected void determineGroupWithGraph(String name) {
		this.group = LieTypeGroupTypeResolver.resolve(name);
		FieldAutConcreteLieTypeGroupGraphConstructor<?> constructor = FieldAutLieTypeGroupGraphConstructorResolver.resolve(group);
		this.graphsMap = constructor.constructGraphs();
		for (List<PrimeNumberGraph> grList : this.graphsMap.values()) {
			for (PrimeNumberGraph gr : grList) {
				gr.printConsole();
			}
		}
		if (graphsMap.size() == 1 && graphsMap.containsKey(1) && graphsMap.get(1).get(0).equals(group.getGraph())) {
			MainLogger.info("Полевые автоморфизмы отсутствуют.");
		}
	}
	
	/**
	 * Метод проверяет равенство графов простых чисел расширений конкретных групп полевыми автоморфизмами
	 * @param groupName		--- наименование группы
	 * @param verticesStr	--- список вершин ГПЧ
	 * @param edgesStrs		--- строки "порядок полевого авт. + список ребер ГПЧ"
	 * @return true, если совпадают, false иначе
	 */
	protected boolean checkEqualities(String groupName, String verticesStr, String ... edgesStrs) {
		determineGroupWithGraph(groupName);
		Map<Integer, List<PrimeNumberGraph>> parsedGraphsMap = getParsedPrimeNumberGraphs(verticesStr, edgesStrs);
		if (parsedGraphsMap.keySet().size() == 1 && parsedGraphsMap.keySet().contains(1)) {
			return parsedGraphsMap.get(1).get(0).equals(group.getGraph());
		} else {
			return checkEqualsOfGraphsMap(this.graphsMap, parsedGraphsMap);
		}
	}
	
	/**
	 * Метод проверяет равенство двух Map - вычисленного и пропарсенного
	 * @param origMap --- проверяемый Map
	 * @param compMap --- вычисленный Map
	 * @return true, если совпадают, false иначе
	 */
	private boolean checkEqualsOfGraphsMap(Map<Integer, List<PrimeNumberGraph>> origMap, Map<Integer, List<PrimeNumberGraph>> compMap) {
		Set<Integer> origSet = origMap.keySet();
		Set<Integer> compSet = compMap.keySet();
		if (!origSet.equals(compSet)) {
			printDiffOfFieldAutOrders(origSet, compSet);
			return false;
		} else {
			for (int key : origSet) {
				List<PrimeNumberGraph> graphsList = origMap.get(key);
				List<PrimeNumberGraph> parsedGraphList = compMap.get(key);
				if (!((graphsList.size() == parsedGraphList.size()) && (graphsList.containsAll(parsedGraphList)))) {
					printDiffOfFieldAutGraphs(parsedGraphList, graphsList, key);
					return false;
				}
			}
		}
		return true;
	}
	
	/**
	 * Метод печатает в лог ошибки в случае несовпадения двух Set-ов с порядками полевых автоморфизмов 
	 * @param origSet --- проверяемый результат
	 * @param compSet --- вычисленный результат
	 */
	private void printDiffOfFieldAutOrders(Set<Integer> origSet, Set<Integer> compSet) {
		for (Integer o : origSet) {
			if (!compSet.contains(o)) {
				MainLogger.info("Проверяемый результат содержит лишний полевой автоморфизм порядка " + o);
			}
		}
		for (Integer o : compSet) {
			if (!origSet.contains(o)) {
				MainLogger.info("Проверяемый результат не содержит полевой автоморфизм порядка " + o);
			}
		}
	}
	
	/**
	 * Метод печатает в лог ошибки в случае несовпадения двух List-ов с ГПЧ расширений полевыми автоморфизмами 
	 * @param origList --- проверяемый результат
	 * @param compList --- вычисленный результат
	 */
	private void printDiffOfFieldAutGraphs(List<PrimeNumberGraph> origList, List<PrimeNumberGraph> compList, Integer order) {
		MainLogger.info("====Результаты вычислений для пол. автоморфизма порядка " + order + "====");
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
	 * ипорядка соотв. полевого автоморфизма
	 * @param verticesStr 	строка вида "a_1,a_2,...,a_n"
	 * @param edgesStr 		строка вида "m#{a_1,b_1},{a_2,b_2},...,{a_n,b_n}", где m - порядок полевого автоморфизма
	 * @return
	 */
	protected Map<Integer, List<PrimeNumberGraph>> getParsedPrimeNumberGraphs(String verticesStr, String ... edgesStr) {
		Map<Integer, List<PrimeNumberGraph>> result = Maps.newHashMap();
		List<Vertex<?>> vertices = getParsedVerticesList(verticesStr);
		for (String eStr : edgesStr) {
			Integer fieldAutOrder = getParsedFieldAutOrder(eStr);
			List<Edge> edgesList = getParsedEdjesList(eStr);
			PrimeNumberGraph currentGraph = new PrimeNumberGraph(vertices, edgesList);
			if (!result.containsKey(fieldAutOrder)) {
				result.put(fieldAutOrder, Lists.newArrayList(currentGraph));
			} else {
				List<PrimeNumberGraph> currentGraphList = result.get(fieldAutOrder);
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
	private int getParsedFieldAutOrder(String input) {
		int index = input.indexOf(FIELD_AUT_EDJES_DELIM);
		return index > 0 ? Integer.parseInt(input.substring(0, index)) : 1;
	}
	
	@Override
	protected List<String> parseEdgesList(String input) {
		int index = input.indexOf(FIELD_AUT_EDJES_DELIM);
		String edgesString = index > 0 ? input.substring(index + 1) : input;
		return super.parseEdgesList(edgesString);
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
	public void getParsedFieldAutOrder_test() {
		MainLogger.info(Integer.toString(getParsedFieldAutOrder(TEST_STR_1_1)));
		MainLogger.info(Integer.toString(getParsedFieldAutOrder(TEST_STR_2_1)));
		MainLogger.info(Integer.toString(getParsedFieldAutOrder(TEST_STR_3_1)));
	}
	
	@Test
	public void getParsedPrimeNumberGraph_test() {
		Map<Integer, List<PrimeNumberGraph>> result = getParsedPrimeNumberGraphs(VERTICES_STR, TEST_STR_1_1, TEST_STR_2_1, TEST_STR_3_1);
		for (Integer order : result.keySet()) {
			MainLogger.info("Порядок полевого автоморфизма: " + Integer.toString(order));
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