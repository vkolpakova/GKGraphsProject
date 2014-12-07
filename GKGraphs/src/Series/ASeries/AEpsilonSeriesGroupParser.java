package Series.ASeries;

import java.util.Map;

import com.google.common.collect.Maps;

import Kernel.Graph.SymbolVertex;
import Kernel.Utils.LieTypeGroupNameParser;
import Kernel.Utils.SeriesGroupParser;

/**
 * Абстрактный класс парсеров для серий типа An(q) и Un(q)
 * 
 * @author v.kolpakova
 *
 */
public class AEpsilonSeriesGroupParser extends SeriesGroupParser {
	

	public AEpsilonSeriesGroupParser(String input) {
		super(input);
	}

	public class ConditionsParser {
		
		public static final String CONDITIONS = "conditions";
		public static final String V_AND_C_SEPARATOR = ":"; // символ-разделитель между вершиной и её ограничением
		public static final String V_SEPARATOR = ";"; // символ-разделитель между различными вершинами
		
		protected String inputStr;
		
		public ConditionsParser(String inputStr) {
			super();
			this.inputStr = inputStr;
		}

		/**
		 * Метод парсит условия для вершин первой(второй) компоненты. Переопределяется в потомках.
		 * @param input --- строковое задание серии
		 * @return Map вершина - условие
		 */
		public Map<SymbolVertex, String> parseConditions() throws Exception {
			Map<SymbolVertex, String> result = Maps.newHashMap();
			int startCondStr = this.inputStr.indexOf(CONDITIONS);
			if (startCondStr >= 0) {
				int startInd = this.inputStr.indexOf(LieTypeGroupNameParser.LEFT_BRACE, startCondStr) + 1;
				int endInd = this.inputStr.indexOf(LieTypeGroupNameParser.RIGHT_BRACE, startCondStr);
				String conditionsStr = inputStr.substring(startInd, endInd);
				String[] units = conditionsStr.split(V_SEPARATOR);
				for (String unit : units) {
					String[] values = unit.split(V_AND_C_SEPARATOR);
					result.put(new SymbolVertex(values[0]), values[1]);
				}
			}
			return result;
		}
				
	}
	
}