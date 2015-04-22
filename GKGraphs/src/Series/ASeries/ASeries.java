package Series.ASeries;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import Kernel.Graph.SymbolVertex;
import Kernel.Group.Series;
import Kernel.Utils.ArithmeticUtils;
import Kernel.Utils.SeriesGroupParser;

/**
 * Реализация серии групп лиева типа вида A_n(q). </br>
 * Конкретные серии (для фиксированного n) реализуются в классах-потомках.
 * 
 * @author v.kolpakova
 */
public class ASeries extends Series {
		
	public static final String EMPTY_STRING = "";
	public static final String ELSE = "else";
	
	public static final String CONDITION3_1_1 = "n_3 <= (q - 1)_3 = 3";
	public static final String CONDITION3_1_2 = "n_3 > (q - 1)_3 = 3";
	public static final String CONDITION3_2_1 = "n_3 <= (q - 1)_3 > 3"; // (q - 1)_3 > 3
	public static final String CONDITION3_2_2 = "n_3 > (q - 1)_3 > 3";  // (q - 1)_3 > 3
	public static final String CONDITION3_2_3 = "n_3 > (q - 1)_3 = 1";  // (q - 1)_3 = 1
	
	public static final String CONDITIONR_1 = "n_r < (q - 1)_r";
	public static final String CONDITIONR_2 = "n_r = (q - 1)_r > 2";
	public static final String CONDITIONR_3 = "(q - 1)_r <= n_r";
	
	public static final List<String> CHAR_CRITERION_LIST = Lists.newArrayList(CONDITION3_1_1, CONDITION3_1_2);
	public static final List<String> TWO_CRITERION_LIST_1 = Lists.newArrayList(CONDITIONR_1, CONDITIONR_2, CONDITION3_1_1, CONDITION3_2_1);
	public static final List<String> TWO_CRITERION_LIST_2 = Lists.newArrayList(CONDITIONR_3, CONDITION3_2_3);
	
	public static final List<String> ALL_3_CONDITIONS = Lists.newArrayList(CONDITION3_1_1, CONDITION3_1_2, CONDITION3_2_1, CONDITION3_2_2, CONDITION3_2_3, ELSE);
	public static final List<String> ALL_R_CONDITIONS = Lists.newArrayList(CONDITIONR_1, CONDITIONR_2, CONDITIONR_3, ELSE);
	
	/**
	 * Коллекция вершина --- условие
	 */
	protected Map<SymbolVertex, String> verticesCondMap;
	
	public ASeries(String name, int n) {
		super(name, n);
		this.verticesCondMap = Maps.newHashMap();
	}
	
	public ASeries(String name, int n, String p, String m) {
		super(name, n, p, m);
		this.verticesCondMap = Maps.newHashMap();
	}
	
	public ASeries(ASeries series) {
		super(series.name, series.n);
		this.components = series.components;
		this.graph = series.graph;
		this.grType = series.grType;
		this.m = series.m;
		this.order = series.order;
		this.p = series.p;
		this.seriesOrder = series.seriesOrder;
		this.symbolPrimeDivisorsList = series.symbolPrimeDivisorsList;
		this.symbolPrimeDivisorsList = series.symbolPrimeDivisorsList;
		this.verticesCondMap = series.verticesCondMap;
	}
	
	public Map<SymbolVertex, String> getVerticesCondMap() {
		return verticesCondMap;
	}

	public void setVerticesCondMap(Map<SymbolVertex, String> verticesCondMap) {
		this.verticesCondMap = verticesCondMap;
	}
	
	/**
	 * Метод возвращет условие на конкретную вершину
	 * @param v
	 * @return
	 */
	public String getVertexCondition(SymbolVertex v) {
		//return this.verticesCondMap.get(v);
		Set<SymbolVertex> verticesSet = this.verticesCondMap.keySet();
		for (SymbolVertex vertex : verticesSet) {
			if (vertex.getVertex().equals(v.getVertex()))  {
				return this.verticesCondMap.get(vertex);
			}
		}
		return null;
	}
	
	/**
	 * Метод задает конкретной вершине конкретное условие
	 * @param condition
	 * @param vertex
	 */
	public void setVertexCondition(String condition, SymbolVertex vertex) {
		this.verticesCondMap.replace(vertex, condition);
	}

	/**
	 * Метод строит verticesCondMap на основе заданной 1-й компоненты с условиями
	 * @param oneComponentMap
	 */
	public void constructVerticesCondMap(Map<SymbolVertex, String> oneComponentMap) {
		List<SymbolVertex> vertices = Lists.newArrayList();
		Component oneComponent = null;
		for (Component component : this.components) {
			vertices.addAll(component.getVertices());
			if (component.getM() == 1) {
				oneComponent = component;
			}
		}
		for (SymbolVertex vertex : vertices) {
			if (!oneComponent.getVertices().contains(vertex)) {
				verticesCondMap.put(vertex, EMPTY_STRING);
			}
		}
		verticesCondMap.putAll(computeObviousRConditions(oneComponentMap));
	}

	/**
	 * Дополнительная логика для заполнения очевидных условий для первой компоненты. <br/>
	 * Переопределяется в потомках, т.к. в значительной степени зависит от {@link #n}
	 * @param oneComponentConditionsMap --- условия для первой компоненты, полученные на входе
	 * @return условия для первой компоненты, дополненные очевидными, не вошедшими в строку, которую парсили
	 */
	protected Map<SymbolVertex, String> computeObviousRConditions(Map<SymbolVertex, String> oneComponentConditionsMap) {
		return oneComponentConditionsMap;
	}
	
	@Override
	public int getOutdiagOrder() {
		Component qm1Comp = this.getComponentByM(1);
		List<Integer> nSimpleDivisors = ArithmeticUtils.getAllPrimeDevisors(this.n + 1);
		for (int div : nSimpleDivisors) {
			if (!qm1Comp.getVertices().contains(new SymbolVertex(Integer.toString(div)))) {
				// TODO понять, как обрабатывать случай когда n = 4 и q - 1 и подобные
				return 1;
			}
		}
		return this.n;
	}
	
	@Override
	public int getIntegerPartFieldAutOrder() {
		int multIndex = m.indexOf(SeriesGroupParser.MULTIPLICATION);
		int res = 1;
		if (multIndex > 0) {
			List<Integer> multsNum = Lists.newArrayList();
			String[] mults  = m.split(SeriesGroupParser.MULTIPLICATION);
			for (String mult : mults) {
				try {
					int num = Integer.parseInt(mult);
					multsNum.add(num);
				} catch (NumberFormatException e) {}
			}
			for (int n : multsNum) {
				res *= n;
			}
		}
		return res;
	}
	
	@Override
	public int getGraphAutOrder() {
		return (this.n == 1) ? 1 : 2;
	}
	
}