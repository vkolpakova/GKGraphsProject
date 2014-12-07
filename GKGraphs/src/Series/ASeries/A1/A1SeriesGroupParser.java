package Series.ASeries.A1;

import java.util.List;
import java.util.Map;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import Kernel.Graph.SymbolVertex;
import Series.ASeries.AEpsilonSeriesGroupParser;

public class A1SeriesGroupParser extends AEpsilonSeriesGroupParser {
	
	public A1SeriesGroupParser(String input) {
		super(input);
	}

	public static final String EPSILON = "epsilon";

	public class A1ComponentsParser extends ComponentsParser {

		public A1ComponentsParser(String inputStr) {
			super(inputStr);
		}
		
		@Override
		public Map<String, List<SymbolVertex>> parseComponents() throws Exception {
			Map<String, List<SymbolVertex>> result = Maps.newHashMap();
			A1SeriesGroupParser parentParser = new A1SeriesGroupParser(inputStr);
			if ((parentParser).parseP().equals(SymbolVertex.TWO)) {
				List<SymbolVertex> verList1 = Lists.newArrayList(new SymbolVertex(SymbolVertex.TWO));
				result.put(A1Series.P_EVEN_COMP_0, verList1);
				List<SymbolVertex> verList2 = getVerticesList(A1Series.P_EVEN_COMP_1);
				result.put(A1Series.P_EVEN_COMP_1, verList2);
				List<SymbolVertex> verList3 = getVerticesList(A1Series.P_EVEN_COMP_2);
				result.put(A1Series.P_EVEN_COMP_2, verList3);
			} else if ((new EpsilonParser(inputStr)).parseEpsilon().equals(A1Series.EPSILON_PLUS)) {
				List<SymbolVertex> verList1 = getVerticesList(A1Series.P_ODD_COMP_1);
				result.put(A1Series.P_ODD_COMP_1, verList1);
				List<SymbolVertex> verList2 = Lists.newArrayList(new SymbolVertex(parentParser.parseP()));
				result.put(A1Series.P_ODD_COMP_0, verList2);
				List<SymbolVertex> verList3 = getVerticesList(A1Series.P_ODD_COMP_2);
				result.put(A1Series.P_ODD_COMP_2, verList3);
			} else if ((new EpsilonParser(inputStr)).parseEpsilon().equals(A1Series.EPSILON_PLUS)) {
				List<SymbolVertex> verList1 = getVerticesList(A1Series.P_ODD_COMP_2);
				result.put(A1Series.P_ODD_COMP_2, verList1);
				List<SymbolVertex> verList2 = Lists.newArrayList(new SymbolVertex(parentParser.parseP()));
				result.put(A1Series.P_ODD_COMP_0, verList2);
				List<SymbolVertex> verList3 = getVerticesList(A1Series.P_ODD_COMP_1);
				result.put(A1Series.P_ODD_COMP_1, verList3);
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