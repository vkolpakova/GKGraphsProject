package Series.ASeries.A1;

import java.util.List;
import java.util.Map;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import Kernel.Graph.SymbolVertex;
import Kernel.Group.Series.Component;
import Kernel.Utils.SeriesGroupParser;
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
		public Map<String, List<SymbolVertex>> parseComponents() throws Exception {
			Map<String, List<SymbolVertex>> result = Maps.newHashMap();
			A1SeriesGroupParser parentParser = new A1SeriesGroupParser(inputStr);
			if ((parentParser).parseP().equals(SymbolVertex.TWO)) {
				List<SymbolVertex> verList1 = Lists.newArrayList(new SymbolVertex(SymbolVertex.TWO));
				result.put(Component.PI_1, verList1);
				List<SymbolVertex> verList2 = getVerticesList(Component.PI_2);
				result.put(Component.PI_2, verList2);
				List<SymbolVertex> verList3 = getVerticesList(Component.PI_3);
				result.put(Component.PI_3, verList3);
			} else {
				List<SymbolVertex> verList1 = getVerticesList(Component.PI_1);
				result.put(Component.PI_1, verList1);
				List<SymbolVertex> verList2 = Lists.newArrayList(new SymbolVertex(parentParser.parseP()));
				result.put(Component.PI_2, verList2);
				List<SymbolVertex> verList3 = getVerticesList(Component.PI_3);
				result.put(Component.PI_3, verList3);
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