package Series._ASeries._A3;

import java.util.List;
import java.util.Map;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import Kernel.Graph.SymbolVertex;
import Series.ASeries.AEpsilonSeriesGroupParser;

public class _A3SeriesGroupParser extends AEpsilonSeriesGroupParser {

	public _A3SeriesGroupParser(String input) {
		super(input);
	}
	
	public class _A3ComponentsParser extends ComponentsParser {

		public _A3ComponentsParser(String inputStr) {
			super(inputStr);
		}
		
		@Override
		public Map<String, List<SymbolVertex>> parseComponents() throws Exception {
			Map<String, List<SymbolVertex>> result = Maps.newHashMap();
			_A3SeriesGroupParser parentParser = new _A3SeriesGroupParser(inputStr);
			List<SymbolVertex> vList0 = Lists.newArrayList(new SymbolVertex(parentParser.parseP()));
			result.put(_A3Series.COMP_0, vList0);
			List<String> compNames = Lists.newArrayList(_A3Series.COMP_1, _A3Series.COMP_2, _A3Series.COMP_4, _A3Series.COMP_6);
			result.putAll(super.getComponentsMap(compNames));
			return result;
		}
		
	}
	
}