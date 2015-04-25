package Logic.Kernel.Resolvers.Series;

import java.util.List;
import java.util.Map;

import Logic.Kernel.Graph.SymbolVertex;
import Logic.Kernel.Group.LieTypeGroup.GroupType;
import Logic.Kernel.Group.Series;
import Logic.Kernel.Utils.SeriesGroupParser;
import Logic.Series.ASeries.A1.A1Series;
import Logic.Series.ASeries.A1.A1SeriesGroupParser;
import Logic.Series.ASeries.A2.A2Series;
import Logic.Series.ASeries.A2.A2SeriesGroupParser;
import Logic.Series.ASeries.A3.A3Series;
import Logic.Series.ASeries.A3.A3SeriesGroupParser;
import Logic.Series.ASeries.ASeries;
import Logic.Series.ASeries.AEpsilonSeriesGroupParser;
import Logic.Series.CSeries.C2.C2Series;
import Logic.Series.CSeries.C2.C2SeriesGroupParser;
import Logic.Series.GSeries.G2.G2Series;
import Logic.Series.GSeries.G2.G2SeriesGroupParser;
import Logic.Series.SzSeries.Sz.SzSeries;
import Logic.Series.SzSeries.Sz.SzSeriesGroupParser;
import Logic.Series._ASeries._ASeries;
import Logic.Series._ASeries._A2._A2Series;
import Logic.Series._ASeries._A2._A2SeriesGroupParser;
import Logic.Series._ASeries._A3._A3Series;
import Logic.Series._ASeries._A3._A3SeriesGroupParser;

/**
 * Резолвер для групп, входящих в бесконечную серию. </br>
 * По строке определенного формата разрешает, конструктор какого класса и с камими парамтерами вызвать 
 * (+ исполнение некоторой логики).
 *
 * @author v.kolpakova
 */
public class SeriesResolver {
	
	protected static final String UNDERLINE = "_";
	protected static final String LEFT_BACKED = "(";
	protected static final String RICH_BACKED = ")";
	
	public static Series resolve(String inputStr) {
		SeriesGroupParser seriesParser = new SeriesGroupParser(inputStr);
		GroupType type = seriesParser.parseName();
		try {
			int n = seriesParser.parseN();
			String m = seriesParser.parseM();
			String p = seriesParser.parseP();
			String groupName = computeSeriesName(type, n, seriesParser.parseQ());
			if (type == GroupType.A) {
				AEpsilonSeriesGroupParser aSeriesGroupParser = new AEpsilonSeriesGroupParser(inputStr);
				Map<SymbolVertex, String> firstComponentConditionMap = (aSeriesGroupParser.new ConditionsParser(inputStr)).parseConditions();
				if (n == 1) {
					A1SeriesGroupParser a1SeriesGroupParser = new A1SeriesGroupParser(inputStr);
					Map<String, List<SymbolVertex>> components = (a1SeriesGroupParser.new A1ComponentsParser(inputStr)).parseComponents();
					String epsilon = (a1SeriesGroupParser.new EpsilonParser(inputStr)).parseEpsilon();
					// TODO сделать нормальное вычисление наименования
					A1Series a1Series =  new A1Series(groupName, n, p, m, epsilon);
					completeASeriesComponentFilling(a1Series, components, firstComponentConditionMap);
					return a1Series;
				} else if (n == 2) {
					A2SeriesGroupParser a2SeriesGroupParser = new A2SeriesGroupParser(inputStr);
					Map<String, List<SymbolVertex>> components = a2SeriesGroupParser.new A2ComponentsParser(inputStr).parseComponents();
					A2Series a2Series = new A2Series(groupName, n, p, m);
					completeASeriesComponentFilling(a2Series, components, firstComponentConditionMap);
					return a2Series;
				} else if (n == 3) {
					A3SeriesGroupParser a3SeriesGroupParser = new A3SeriesGroupParser(inputStr);
					Map<String, List<SymbolVertex>> components = a3SeriesGroupParser.new A3ComponentsParser(inputStr).parseComponents();
					A3Series a3Series = new A3Series(groupName, n, p, m);
					completeASeriesComponentFilling(a3Series, components, firstComponentConditionMap);
					return a3Series;
				}
			} else if (type == GroupType._A) {
				AEpsilonSeriesGroupParser aSeriesGroupParser = new AEpsilonSeriesGroupParser(inputStr);
				Map<SymbolVertex, String> firstComponentConditionMap = (aSeriesGroupParser.new ConditionsParser(inputStr)).parseConditions();
				if (n == 2) {
					_A2SeriesGroupParser _a2SeriesGroupParser = new _A2SeriesGroupParser(inputStr);
					Map<String, List<SymbolVertex>> components = _a2SeriesGroupParser.new _A2ComponentsParser(inputStr).parseComponents();
					_A2Series _a2Series = new _A2Series(groupName, n, p, m);
					complete_ASeriesComponentFilling(_a2Series, components, firstComponentConditionMap);
					return _a2Series;
				} else if (n == 3) {
					_A3SeriesGroupParser _a3SeriesGroupParser = new _A3SeriesGroupParser(inputStr);
					Map<String, List<SymbolVertex>> components = _a3SeriesGroupParser.new _A3ComponentsParser(inputStr).parseComponents();
					_A3Series _a3Series = new _A3Series(groupName, n, p, m);
					complete_ASeriesComponentFilling(_a3Series, components, firstComponentConditionMap);
					return _a3Series;
				}
			} else if (type == GroupType.C) {
				C2SeriesGroupParser c2SeriesGroupParser = new C2SeriesGroupParser(inputStr);
				Map<String, List<SymbolVertex>> components = c2SeriesGroupParser.new C2ComponentsParser(inputStr).parseComponents();
				C2Series c2Series = new C2Series(groupName, n, p, m);
				c2Series.setVerticesForAllComponent(components);
				c2Series.fillSeriesOrderBasedComponents();
				return c2Series;
			} else if (type == GroupType.G) {
				G2SeriesGroupParser g2SeriesGroupParser = new G2SeriesGroupParser(inputStr);
				Map<String, List<SymbolVertex>> components = g2SeriesGroupParser.new G2ComponentsParser(inputStr).parseComponents();
				G2Series g2Series = new G2Series(groupName, n, p, m);
				g2Series.setVerticesForAllComponent(components);
				g2Series.fillSeriesOrderBasedComponents();
				return g2Series;
			} else if (type == GroupType.Sz) {
				SzSeriesGroupParser szSeriesGroupParser = new SzSeriesGroupParser(inputStr);
				Map<String, List<SymbolVertex>> components = szSeriesGroupParser.new SzComponentsParser(inputStr).parseComponents();
				SzSeries szSeries = new SzSeries(groupName, n, p, m);
				szSeries.setVerticesForAllComponent(components);
				szSeries.fillSeriesOrderBasedComponents();
				return szSeries;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	protected static void completeASeriesComponentFilling(ASeries aSeries, Map<String, List<SymbolVertex>> components, Map<SymbolVertex, String> firstComponentConditionMap) {
		// просиходит заполнение уже созданных компонент вершинами, сгруппированными по компонентам
		aSeries.setVerticesForAllComponent(components);
		if (firstComponentConditionMap.isEmpty()) {
			fillEmptyFirstComponentConditionsMapASeries(firstComponentConditionMap, aSeries);
		}
		// происходит заполнение условий для вершин первой компоненты
		aSeries.constructVerticesCondMap(firstComponentConditionMap);
		// происходит заполнение простых делителей простых сомножителей порядка
		aSeries.fillSeriesOrderBasedComponents();
	}
	
	protected static void complete_ASeriesComponentFilling(_ASeries _aSeries, Map<String, List<SymbolVertex>> components, Map<SymbolVertex, String> firstComponentConditionMap) {
		// просиходит заполнение уже созданных компонент вершинами, сгруппированными по компонентам
		_aSeries.setVerticesForAllComponent(components);
		// происходит заполнение условий для вершин первой компоненты
		_aSeries.constructVerticesCondMap(firstComponentConditionMap);
		// происходит заполнение простых делителей простых сомножителей порядка
		_aSeries.fillSeriesOrderBasedComponents();
	}

	private static Map<SymbolVertex, String> fillEmptyFirstComponentConditionsMapASeries(Map<SymbolVertex, String> emptyConditionsMap, ASeries aSeries) {
		for (SymbolVertex vertex : aSeries.getComponentByM(1).getVertices()) {
			emptyConditionsMap.put(vertex, ASeries.EMPTY_STRING);
		}
		return emptyConditionsMap;
	}
	
	protected static String computeSeriesName(GroupType type, int n, String q) {
		return type.name() + UNDERLINE + LEFT_BACKED + q + RICH_BACKED;
	}
	
}