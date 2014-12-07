package Series.SzSeries.Sz;

import java.util.List;
import java.util.Map;

import com.google.common.collect.Lists;

import Kernel.Graph.SymbolVertex;
import Kernel.Utils.SeriesGroupParser;

public class SzSeriesGroupParser extends SeriesGroupParser {

	public SzSeriesGroupParser(String input) {
		super(input);
	}
	
	public class SzComponentsParser extends ComponentsParser {

		public SzComponentsParser(String inputStr) {
			super(inputStr);
		}
		
		@Override
		public Map<String, List<SymbolVertex>> parseComponents() throws Exception {
			List<String> compNames = Lists.newArrayList(SzSeries.COMP_1, SzSeries.COMP_4_1, SzSeries.COMP_4_2);
			return super.getComponentsMap(compNames);
		}
		
	}
	
}