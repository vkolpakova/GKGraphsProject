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
import Series.ASeries.ASeriesGroupParser;

/**
 * Резолвер для групп, входящих в бесконечную серию. </br>
 * По строке определенного формата разврешает, конструктор какого класса и с камими парамтерами вызвать (+ исполнение некоторой логики).
 *
 * @author v.kolpakova
 */
public class SeriesResolver {
	
	public static Series resolve(String inputStr) {
		SeriesGroupParser seriesParser = new SeriesGroupParser(inputStr);
		GroupType type = seriesParser.parseName();
		try {
			int n = seriesParser.parseN();
			String m = seriesParser.parseM();
			String p = seriesParser.parseP();
			if (type == GroupType.A) {
				ASeriesGroupParser aSeriesGroupParser = new ASeriesGroupParser(inputStr);
				Map<SymbolVertex, String> firstComponentConditionMap = (aSeriesGroupParser.new ConditionsParser(inputStr)).parseConditions();
				if (n == 1) {
					A1SeriesGroupParser a1SeriesGroupParser = new A1SeriesGroupParser(inputStr);
					Map<String, List<SymbolVertex>> components = (a1SeriesGroupParser.new A1ComponentsParser(inputStr)).parseComponents();
					String epsilon = (a1SeriesGroupParser.new EpsilonParser(inputStr)).parseEpsilon();
					// TODO сделать нормальное вычисление наименования
					A1Series a1Series =  new A1Series("*", n, p, m, epsilon);
					// просиходит заполнение уже созданных компонент вершинами, сгруппированными по компонентам
					a1Series.setVerticesForAllComponent(components);
					// происходит заполнение условий для вершин первых компонент
					a1Series.constructVerticesCondMap(firstComponentConditionMap);
					return a1Series;
				} else if (n == 2) {
					A2SeriesGroupParser a2SeriesGroupParser = new A2SeriesGroupParser(inputStr);
					Map<String, List<SymbolVertex>> components = a2SeriesGroupParser.new A2ComponentsParser(inputStr).parseComponents();
					A2Series a2Series = new A2Series("*", n, p, m);
					a2Series.setVerticesForAllComponent(components);
					a2Series.constructVerticesCondMap(firstComponentConditionMap);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}