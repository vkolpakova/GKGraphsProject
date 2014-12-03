package Series.ASeries.A2;

import java.util.List;
import java.util.Map;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import Kernel.Graph.SymbolVertex;
import Series.ASeries.ASeriesGroupParser;

public class A2SeriesGroupParser extends ASeriesGroupParser {

	public A2SeriesGroupParser(String input) {
		super(input);
	}
	
	public class A2ComponentsParser extends ComponentsParser {

		public A2ComponentsParser(String inputStr) {
			super(inputStr);
		}
		
		@Override
		public Map<String, List<SymbolVertex>> parseComponents() throws Exception {
			Map<String, List<SymbolVertex>> result = Maps.newHashMap();
			A2SeriesGroupParser parentParser = new A2SeriesGroupParser(inputStr);
			List<SymbolVertex> vList0 = Lists.newArrayList(new SymbolVertex(parentParser.parseP()));
			result.put(A2Series.COMP_0, vList0);
			List<SymbolVertex> vList1 = getVerticesList(A2Series.COMP_1);
			result.put(A2Series.COMP_1, vList1);
			List<SymbolVertex> vList2 = getVerticesList(A2Series.COMP_2);
			result.put(A2Series.COMP_2, vList2);
			List<SymbolVertex> vList3 = getVerticesList(A2Series.COMP_3);
			result.put(A2Series.COMP_3, vList3);
			return result;
		}
		
	}
	
}