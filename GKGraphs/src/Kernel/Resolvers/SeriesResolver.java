package Kernel.Resolvers;

import java.util.List;
import java.util.Map;

import Kernel.Graph.SymbolVertex;
import Kernel.Group.LieTypeGroup.GroupType;
import Kernel.Group.Series;
import Kernel.Utils.SeriesGroupParser;
import Series.ASeries.A1.A1Series;
import Series.ASeries.A1.A1SeriesGroupParser;
import Series.ASeries.A2.A2Series;
import Series.ASeries.A2.A2SeriesGroupParser;
import Series.ASeries.A3.A3Series;
import Series.ASeries.A3.A3SeriesGroupParser;
import Series.ASeries.ASeries;
import Series.ASeries.ASeriesGroupParser;
import Series.CSeries.C2.C2Series;
import Series.CSeries.C2.C2SeriesGroupParser;

/**
 * Резолвер для групп, входящих в бесконечную серию. </br>
 * По строке определенного формата разрешает, конструктор какого класса и с камими парамтерами вызвать 
 * (+ исполнение некоторой логики).
 *
 * @author v.kolpakova
 */
public class SeriesResolver {
	
	protected static final String UNDERLINE = "_";
	protected static final String LEFT_BRACKED = "(";
	protected static final String RIGTH_BRACKED = ")";
	
	public static Series resolve(String inputStr) {
		SeriesGroupParser seriesParser = new SeriesGroupParser(inputStr);
		GroupType type = seriesParser.parseName();
		try {
			int n = seriesParser.parseN();
			String m = seriesParser.parseM();
			String p = seriesParser.parseP();
			String groupName = computeSeriesName(type, n, seriesParser.parseQ());
			if (type == GroupType.A) {
				ASeriesGroupParser aSeriesGroupParser = new ASeriesGroupParser(inputStr);
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
			} else if (type == GroupType.C) {
				C2SeriesGroupParser c2SeriesGroupParser = new C2SeriesGroupParser(inputStr);
				Map<String, List<SymbolVertex>> components = c2SeriesGroupParser.new C2ComponentsParser(inputStr).parseComponents();
				C2Series c2Series = new C2Series(groupName, n, p, m);
				c2Series.setVerticesForAllComponent(components);
				c2Series.fillSeriesOrderBasedComponents();
				return c2Series;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	protected static void completeASeriesComponentFilling(ASeries aSeries, Map<String, List<SymbolVertex>> components, Map<SymbolVertex, String> firstComponentConditionMap) {
		// просиходит заполнение уже созданных компонент вершинами, сгруппированными по компонентам
		aSeries.setVerticesForAllComponent(components);
		// происходит заполнение условий для вершин первой компоненты
		aSeries.constructVerticesCondMap(firstComponentConditionMap);
		// происходит заполнение простых делителей простых сомножителей порядка
		aSeries.fillSeriesOrderBasedComponents();
	}
	
	protected static String computeSeriesName(GroupType type, int n, String q) {
		return type.name() + UNDERLINE + LEFT_BRACKED + q + RIGTH_BRACKED;
	}
	
}