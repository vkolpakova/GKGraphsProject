package Series.ASeries;

import java.util.List;
import java.util.Map;

import Kernel.Graph.SymbolVertex;
import Kernel.Utils.SeriesGroupParser;

public abstract class ASeriesGroupParser extends SeriesGroupParser {
	
	public class conditionsParser {
		
		protected String inputStr;
		
		public conditionsParser(String inputStr) {
			super();
			this.inputStr = inputStr;
		}

		/**
		 * Метод парсит условия для вершин первой компоненты. Переопределяется в потомках.
		 * @param input --- строковое задание серии
		 * @return Map вершина - условие
		 */
		public Map<String, List<SymbolVertex>> parseConditions() {
			return null;
		}
	}
	
}