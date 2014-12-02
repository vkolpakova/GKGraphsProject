package Series.ASeries;

import java.util.List;
import java.util.Map;

import Kernel.Graph.SymbolVertex;

import com.google.common.collect.Lists;
//import com.google.common.collect.Maps;

/**
 * Класс для генерации групп серии типа A с фиксированными значениями параметров по всем возможным условиям
 * 
 * @author v.kolpakova
 *
 */
public class ASeriesGenerator {
	
	public static List<ASeries> generate(ASeries series) {
		List<ASeries> result = Lists.newArrayList();
		/*List<Map<SymbolVertex, String>> vertexCondMapList = Lists.newArrayList();
		//Map<SymbolVertex, String> vertexCondMap = Maps.newHashMap();
		Component oneComponent = series.getComponentByM(1);
		List<SymbolVertex> oneCompVertices = oneComponent.getVertices();
		if (!oneComponent.getVertices().contains(new SymbolVertex(SymbolVertex.THREE))) {
			for (SymbolVertex vertex : oneCompVertices) {
				// TODO сделать генерацию условий. Учесть, что надо будет отсеивать дубликаты графов
			}
		} */
		return result;
	}
	
	public static ASeries generate(ASeries series, Map<SymbolVertex, String> map) {
		series.constructVerticesCondMap(map);
		return series;
	}
	
}