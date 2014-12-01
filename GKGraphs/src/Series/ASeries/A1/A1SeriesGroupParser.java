package Series.ASeries.A1;

import java.util.List;
import java.util.Map;

import Kernel.Graph.SymbolVertex;
import Series.ASeries.ASeriesGroupParser;

public class A1SeriesGroupParser extends ASeriesGroupParser {

	public class A1ComponentsParser extends componentsParser {

		public A1ComponentsParser(String inputStr) {
			super(inputStr);
		}
		
		@Override
		public Map<String, List<SymbolVertex>> parseComponents() {
			return super.parseComponents();
		}
		
	}
	
	public class A1ConditionsParser extends conditionsParser {

		public A1ConditionsParser(String inputStr) {
			super(inputStr);
		}
		
		@Override
		public Map<String, List<SymbolVertex>> parseConditions() {
			return super.parseConditions();
		}
		
	}
	
}