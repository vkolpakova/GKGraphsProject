package Series._ASeries;

import java.util.List;
import java.util.Map;

import com.google.common.collect.Lists;

import Kernel.Graph.SymbolVertex;
import Kernel.Group.Series;

/**
 * Реализация серии групп лиева типа вида PSU_n(q). </br>
 * Конкретные серии (для фиксированного n) реализуются в классах-потомках.
 * 
 * @author v.kolpakova
 */
public class _ASeries extends Series {
	
	public static final String EMPTY_STRING = "";
	public static final String ELSE = "else";
	
	public static final String CONDITION3_1_1 = "n_3 <= (q + 1)_3 = 3";
	public static final String CONDITION3_1_2 = "n_3 > (q + 1)_3 = 3";
	public static final String CONDITION3_2_1 = "n_3 <= (q + 1)_3 > 3"; // (q + 1)_3 > 3
	public static final String CONDITION3_2_2 = "n_3 > (q + 1)_3 > 3";  // (q + 1)_3 > 3
	public static final String CONDITION3_2_3 = "n_3 > (q + 1)_3 = 1";  // (q + 1)_3 = 1
	
	public static final String CONDITIONR_1 = "n_r < (q + 1)_r";
	public static final String CONDITIONR_2 = "n_r = (q + 1)_r > 2";
	public static final String CONDITIONR_3 = "(q + 1)_r <= n_r";
	
	public static final List<String> CHAR_CRITERION_LIST = Lists.newArrayList(CONDITION3_1_1, CONDITION3_1_2);
	public static final List<String> TWO_CRITERION_LIST_1 = Lists.newArrayList(CONDITIONR_1, CONDITIONR_2, CONDITION3_1_1, CONDITION3_2_1);
	public static final List<String> TWO_CRITERION_LIST_2 = Lists.newArrayList(CONDITIONR_3, CONDITION3_2_3);
	
	public static final List<String> ALL_3_CONDITIONS = Lists.newArrayList(CONDITION3_1_1, CONDITION3_1_2, CONDITION3_2_1, CONDITION3_2_2, CONDITION3_2_3, ELSE);
	public static final List<String> ALL_R_CONDITIONS = Lists.newArrayList(CONDITIONR_1, CONDITIONR_2, CONDITIONR_3, ELSE);
	
	/**
	 * Коллекция вершина --- условие
	 */
	protected Map<SymbolVertex, String> verticesCondMap;

	public _ASeries(String name, int n, String p, String m) {
		super(name, n, p, m);
	}
	
	public Map<SymbolVertex, String> getVerticesCondMap() {
		return verticesCondMap;
	}

	public void setVerticesCondMap(Map<SymbolVertex, String> verticesCondMap) {
		this.verticesCondMap = verticesCondMap;
	}
	
	public String getVertexCondition(SymbolVertex v) {
		return this.verticesCondMap.get(v);
	}

	/**
	 * Метод строит verticesCondMap на основе заданной 2-й компоненты (соотв. q+1) с условиями
	 * @param oneComponentMap
	 */
	public void constructVerticesCondMap(Map<SymbolVertex, String> oneComponentMap) {
		List<SymbolVertex> vertices = Lists.newArrayList();
		Component oneComponent = null;
		for (Component component : this.components) {
			vertices.addAll(component.getVertices());
			if (component.getM() == 2) {
				oneComponent = component;
			}
		}
		for (SymbolVertex vertex : vertices) {
			if (!oneComponent.getVertices().contains(vertex)) {
				verticesCondMap.put(vertex, EMPTY_STRING);
			}
		}
		verticesCondMap.putAll(oneComponentMap);
	}
	
}