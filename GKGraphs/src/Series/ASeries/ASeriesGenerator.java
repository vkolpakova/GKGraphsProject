package Series.ASeries;

import java.util.List;
import java.util.Map;

import Kernel.Graph.SymbolVertex;
import Kernel.Group.Series.Component;

import com.google.common.collect.Lists;
//import com.google.common.collect.Maps;

/**
 * Класс для генерации групп серии типа A с фиксированными значениями параметров по всем возможным условиям
 * 
 * @author v.kolpakova
 *
 */
public class ASeriesGenerator {
	
	@SuppressWarnings("unused")
	public static List<ASeries> generate(ASeries series) {
		List<ASeries> result = Lists.newArrayList();
		List<Map<SymbolVertex, String>> vertexCondMapList = Lists.newArrayList();
		//Map<SymbolVertex, String> vertexCondMap = Maps.newHashMap();
		Component oneComponent = series.getComponentByM(1);
		List<SymbolVertex> oneCompVertices = oneComponent.getVertices();
		for (SymbolVertex vertex : oneCompVertices) {
			String vertexCondition = series.getVertexCondition(vertex);
			if (vertexCondition.equals(AEpsilonSeriesGroupParser.ConditionsParser.ALL_CONDITIONS)) {
				if (!vertex.getVertex().equals(SymbolVertex.THREE)) {
					result.addAll(generateAllASeriesForNotThreeVertex(vertex, series));
				} else {
					result.addAll(generateAllASeriesForThreeVertex(vertex, series));
				}
			}
		}
		return result;
	}
	
	protected static List<ASeries> generateASeriesByConditions(SymbolVertex vertex, ASeries series, List<String> allConditionsList) {
		List<ASeries> result = Lists.newArrayListWithCapacity(allConditionsList.size());
		for (String condition : allConditionsList) {
			ASeries generatedSeries = new ASeries(series);
			generatedSeries.setVertexCondition(condition, vertex);
		}
		return result;
	}
	
	/**
	 * Метод строит коллекицю групп, удовлетворяющих одному из всех возможных условий на вершину, не равную 3
	 * @param vert
	 * @return
	 */
	protected static List<ASeries> generateAllASeriesForNotThreeVertex(SymbolVertex vert, ASeries origSeries) {
		return generateASeriesByConditions(vert, origSeries, ASeries.ALL_R_CONDITIONS);
	}
	
	/**
	 * Метод строит коллекцию групп, удовлетворяющих одному из возможных услоий на вершину 3
	 * @return
	 */
	protected static List<ASeries> generateAllASeriesForThreeVertex(SymbolVertex vert, ASeries origSeries) {
		return generateASeriesByConditions(vert, origSeries, ASeries.ALL_3_CONDITIONS);
	}
	
	public static ASeries generate(ASeries series, Map<SymbolVertex, String> map) {
		series.constructVerticesCondMap(map);
		return series;
	}
	
}