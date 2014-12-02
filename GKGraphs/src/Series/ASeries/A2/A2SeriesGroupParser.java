package Series.ASeries.A2;

import java.util.List;
import java.util.Map;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import Kernel.Graph.SymbolVertex;
import Kernel.Group.Series.Component;
import Series.ASeries.ASeriesGroupParser;
import Series.ASeries.A1.A1SeriesGroupParser;

public class A2SeriesGroupParser extends ASeriesGroupParser {

	public A2SeriesGroupParser(String input) {
		super(input);
	}
	
	public class A2ComponentsParser extends ComponentsParser {

		public A2ComponentsParser(String inputStr) {
			super(inputStr);
		}
		
		@Override
		public Map<String, Map<Integer, List<SymbolVertex>>> parseComponents() throws Exception {
			// Учесть, что в одну компоненту могут входить верщины с разными значениями e(v, q)!!!
			Map<String, Map<Integer, List<SymbolVertex>>> result = Maps.newHashMap();
			Map<Integer, List<SymbolVertex>> verMap1 = Maps.newHashMap();
			A1SeriesGroupParser parentParser = new A1SeriesGroupParser(inputStr);
			List<SymbolVertex> pList = Lists.newArrayList(new SymbolVertex(parentParser.parseP()));
			verMap1.put(0, pList);
			List<SymbolVertex> vList1_1 = getVerticesList("pi_1_1");
			verMap1.put(1, vList1_1);
			List<SymbolVertex> vList1_2 = getVerticesList("pi_1_2");
			verMap1.put(2, vList1_2);
			result.put(Component.PI_1, verMap1);
			List<SymbolVertex> vList2 = getVerticesList(Component.PI_2);
			Map<Integer, List<SymbolVertex>> verMap2 = Maps.newHashMap();
			verMap2.put(3, vList2);
			result.put(Component.PI_2, verMap2);
			return result;
		}
		
	}
	
}