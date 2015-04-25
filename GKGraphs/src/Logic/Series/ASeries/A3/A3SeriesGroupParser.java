package Logic.Series.ASeries.A3;

import java.util.List;
import java.util.Map;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import Logic.Kernel.Graph.SymbolVertex;
import Logic.Series.ASeries.AEpsilonSeriesGroupParser;


public class A3SeriesGroupParser extends AEpsilonSeriesGroupParser {

	public A3SeriesGroupParser(String input) {
		super(input);
	}
	
	public class A3ComponentsParser extends ComponentsParser {

		public A3ComponentsParser(String inputStr) {
			super(inputStr);
		}
		
		@Override
		public Map<String, List<SymbolVertex>> parseComponents() throws Exception {
			Map<String, List<SymbolVertex>> result = Maps.newHashMap();
			A3SeriesGroupParser parentParser = new A3SeriesGroupParser(inputStr);
			List<SymbolVertex> vList0 = Lists.newArrayList(new SymbolVertex(parentParser.parseP()));
			result.put(A3Series.COMP_0, vList0);
			List<SymbolVertex> vList1 = getVerticesList(A3Series.COMP_1);
			result.put(A3Series.COMP_1, vList1);
			List<SymbolVertex> vList2 = getVerticesList(A3Series.COMP_2);
			result.put(A3Series.COMP_2, vList2);
			List<SymbolVertex> vList3 = getVerticesList(A3Series.COMP_3);
			result.put(A3Series.COMP_3, vList3);
			List<SymbolVertex> vList4 = getVerticesList(A3Series.COMP_4);
			result.put(A3Series.COMP_4, vList4);
			return result;
		}
		
	}
	
}