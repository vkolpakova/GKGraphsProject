package Logic.Series.GSeries.G2;

import java.util.List;
import java.util.Map;

import com.google.common.collect.Lists;

import Logic.Kernel.Graph.SymbolVertex;
import Logic.Kernel.Utils.SeriesGroupParser;

public class G2SeriesGroupParser extends SeriesGroupParser {

	public G2SeriesGroupParser(String input) {
		super(input);
	}
	
	public class G2ComponentsParser extends ComponentsParser {

		public G2ComponentsParser(String inputStr) {
			super(inputStr);
		}
		
		@Override
		public Map<String, List<SymbolVertex>> parseComponents() throws Exception {
			List<String> compNames = Lists.newArrayList(G2Series.COMP_1, G2Series.COMP_2, G2Series.COMP_3, G2Series.COMP_6);
			Map<String, List<SymbolVertex>> result = super.getComponentsMap(compNames);
			G2SeriesGroupParser parentParser = new G2SeriesGroupParser(inputStr);
			List<SymbolVertex> vList0 = Lists.newArrayList(new SymbolVertex(parentParser.parseP()));
			result.put(G2Series.COMP_0, vList0);
			return result;
		}
		
	}
	
}