package Kernel.Resolvers;

import java.util.List;
import java.util.Map;

import Kernel.Graph.SymbolVertex;
import Kernel.Group.LieTypeGroup.GroupType;
import Kernel.Group.Series;
import Kernel.Utils.SeriesGroupParser;
import Series.ASeries.A1.A1Series;
import Series.ASeries.A1.A1SeriesGroupParser.A1ComponentsParser;
import Series.ASeries.A1.A1SeriesGroupParser.EpsilonParser;
import Series.ASeries.ASeriesGroupParser.ConditionsParser;


public class SeriesResolver {
	
	/*public Series resolve(String inputStr) {
		GroupType type = SeriesGroupParser.parseName(inputStr);
		try {
			int n = SeriesGroupParser.parseN(inputStr);
			String m = SeriesGroupParser.parseM(inputStr);
			String p = SeriesGroupParser.parseP(inputStr);
			if (type == GroupType.A) {
				Map<SymbolVertex, String> conditionsMap = (new ConditionsParser(inputStr)).parseConditions();
				if (n == 1) {
					Map<String, List<SymbolVertex>> components = (new A1ComponentsParser(inputStr)).parseComponents();
					String epsilon = (new EpsilonParser(inputStr)).parseEpsilon();
					return new A1Series("*", n, p, m, epsilon);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}*/
	
}