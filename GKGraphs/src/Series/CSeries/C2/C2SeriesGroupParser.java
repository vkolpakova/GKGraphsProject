package Series.CSeries.C2;

import java.util.List;
import java.util.Map;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import Kernel.Graph.SymbolVertex;
import Kernel.Utils.SeriesGroupParser;

public class C2SeriesGroupParser extends SeriesGroupParser {

	public C2SeriesGroupParser(String input) {
		super(input);
	}
	
	public class C2ComponentsParser extends ComponentsParser {

		public C2ComponentsParser(String inputStr) {
			super(inputStr);
		}
		
		@Override
		public Map<String, List<SymbolVertex>> parseComponents() throws Exception {
			Map<String, List<SymbolVertex>> result = Maps.newHashMap();
			C2SeriesGroupParser parentParser = new C2SeriesGroupParser(inputStr);
			List<SymbolVertex> vList0 = Lists.newArrayList(new SymbolVertex(parentParser.parseP()));
			result.put(C2Series.COMP_0, vList0);
			List<SymbolVertex> vList1 = getVerticesList(C2Series.COMP_1);
			result.put(C2Series.COMP_1, vList1);
			List<SymbolVertex> vList2 = getVerticesList(C2Series.COMP_2);
			result.put(C2Series.COMP_2, vList2);
			List<SymbolVertex> vList3 = getVerticesList(C2Series.COMP_4);
			result.put(C2Series.COMP_4, vList3);
			return result;
		}
		
	}
	
}