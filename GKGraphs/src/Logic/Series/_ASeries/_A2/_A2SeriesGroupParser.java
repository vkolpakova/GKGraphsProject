package Logic.Series._ASeries._A2;

import java.util.List;
import java.util.Map;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import Logic.Kernel.Graph.SymbolVertex;
import Logic.Series.ASeries.AEpsilonSeriesGroupParser;

public class _A2SeriesGroupParser extends AEpsilonSeriesGroupParser {

	public _A2SeriesGroupParser(String input) {
		super(input);
	}
	
	public class _A2ComponentsParser extends ComponentsParser {

		public _A2ComponentsParser(String inputStr) {
			super(inputStr);
		}
		
		@Override
		public Map<String, List<SymbolVertex>> parseComponents() throws Exception {
			Map<String, List<SymbolVertex>> result = Maps.newHashMap();
			_A2SeriesGroupParser parentParser = new _A2SeriesGroupParser(inputStr);
			List<SymbolVertex> vList0 = Lists.newArrayList(new SymbolVertex(parentParser.parseP()));
			result.put(_A2Series.COMP_0, vList0);
			List<String> compNames = Lists.newArrayList(_A2Series.COMP_1, _A2Series.COMP_2, _A2Series.COMP_6);
			result.putAll(super.getComponentsMap(compNames));
			return result;
		}
		
	}
	
}