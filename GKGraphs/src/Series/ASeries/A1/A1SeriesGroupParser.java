package Series.ASeries.A1;

import java.util.List;
import java.util.Map;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import Kernel.Graph.SymbolVertex;
import Kernel.Group.Series.Component;
import Series.ASeries.ASeriesGroupParser;

public class A1SeriesGroupParser extends ASeriesGroupParser {
	
	public A1SeriesGroupParser(String input) {
		super(input);
	}

	public static final String EPSILON = "epsilon";

	public class A1ComponentsParser extends ComponentsParser {

		public A1ComponentsParser(String inputStr) {
			super(inputStr);
		}
		
		@Override
		public Map<String, Map<Integer, List<SymbolVertex>>> parseComponents() throws Exception {
			Map<String, Map<Integer, List<SymbolVertex>>> result = Maps.newHashMap();
			A1SeriesGroupParser parentParser = new A1SeriesGroupParser(inputStr);
			// TODO refactoring
			if ((parentParser).parseP().equals(SymbolVertex.TWO)) {
				List<SymbolVertex> verList1 = Lists.newArrayList(new SymbolVertex(SymbolVertex.TWO));
				Map<Integer, List<SymbolVertex>> verMap1 = Maps.newHashMap();
				verMap1.put(0, verList1);
				result.put(Component.PI_1, verMap1);
				List<SymbolVertex> verList2 = getVerticesList(Component.PI_2);
				Map<Integer, List<SymbolVertex>> verMap2 = Maps.newHashMap();
				verMap2.put(1, verList2);
				result.put(Component.PI_2, verMap2);
				List<SymbolVertex> verList3 = getVerticesList(Component.PI_3);
				Map<Integer, List<SymbolVertex>> verMap3 = Maps.newHashMap();
				verMap3.put(2, verList3);
				result.put(Component.PI_3, verMap3);
			} else {
				EpsilonParser eParser = new EpsilonParser(inputStr);
				if (eParser.parseEpsilon().equals(A1Series.EPSILON_PLUS)) {
					List<SymbolVertex> verList1 = getVerticesList(Component.PI_1);
					Map<Integer, List<SymbolVertex>> verMap1 = Maps.newHashMap();
					verMap1.put(1, verList1);
					result.put(Component.PI_1, verMap1);
					List<SymbolVertex> verList2 = Lists.newArrayList(new SymbolVertex(parentParser.parseP()));
					Map<Integer, List<SymbolVertex>> verMap2 = Maps.newHashMap();
					verMap2.put(0, verList2);
					result.put(Component.PI_2, verMap2);
					List<SymbolVertex> verList3 = getVerticesList(Component.PI_3);
					Map<Integer, List<SymbolVertex>> verMap3 = Maps.newHashMap();
					verMap3.put(2, verList3);
					result.put(Component.PI_3, verMap3);
				} else {
					List<SymbolVertex> verList1 = getVerticesList(Component.PI_1);
					Map<Integer, List<SymbolVertex>> verMap1 = Maps.newHashMap();
					verMap1.put(2, verList1);
					result.put(Component.PI_1, verMap1);
					List<SymbolVertex> verList2 = Lists.newArrayList(new SymbolVertex(parentParser.parseP()));
					Map<Integer, List<SymbolVertex>> verMap2 = Maps.newHashMap();
					verMap2.put(0, verList2);
					result.put(Component.PI_2, verMap2);
					List<SymbolVertex> verList3 = getVerticesList(Component.PI_3);
					Map<Integer, List<SymbolVertex>> verMap3 = Maps.newHashMap();
					verMap3.put(1, verList3);
					result.put(Component.PI_3, verMap3);
				}
			}
			return result;
		}
		
	}
	
	public class EpsilonParser {
		
		protected String inputStr;
		
		public EpsilonParser(String inputStr) {
			super();
			this.inputStr = inputStr;
		}
		
		/**
		 * Метод парсит условие на epsilon. </br>
		 * Формат: epsilon=+(-)
		 * @return
		 * @throws Exception
		 */
		public String parseEpsilon() throws Exception {
			int epsIndex = this.inputStr.indexOf(EPSILON);
			if (this.inputStr.indexOf(A1Series.EPSILON_PLUS, epsIndex) >= 0) {
				return A1Series.EPSILON_PLUS;
			} else if (this.inputStr.indexOf(A1Series.EPSILON_MINUS, epsIndex) >= 0) {
				return A1Series.EPSILON_MINUS;
			}
			return "";
		}
		
	}
	
}