package Series.ASeries.A2;

import java.util.List;
import java.util.Map;

import com.google.common.collect.Maps;

import Kernel.Graph.SymbolVertex;
import Kernel.Group.Series.Component;
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
			// Учесть, что в одну компоненту могут входить верщины с разными значениями e(v, q)!!!
			Map<String, List<SymbolVertex>> result = Maps.newHashMap();
			List<SymbolVertex> vList1 = getVerticesList(Component.PI_1);
			result.put(Component.PI_1, vList1);
			List<SymbolVertex> vList2 = getVerticesList(Component.PI_2);
			result.put(Component.PI_2, vList2);
			return result;
		}
		
	}
	
}