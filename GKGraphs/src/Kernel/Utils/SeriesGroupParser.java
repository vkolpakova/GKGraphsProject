package Kernel.Utils;

import java.util.List;
import java.util.Map;

import Kernel.Graph.SymbolVertex;
import Kernel.Group.LieTypeGroup.GroupType;

/**
 * Абстрактный класс - парсер строкового представления серии группы. </br>
 * В клссах-потомках определяются все специализированные методы.
 * 
 * @author v.kolpakova
 *
 */
public abstract class SeriesGroupParser {
	
	/**
	 * Метод парсит тип серии групп
	 * @param input --- строковое задание серии
	 * @return groupType
	 */
	public static GroupType parseName(String input) {
		if (input.startsWith("A")) {
			return GroupType.A;
		}
		return null;
	}
	
	/**
	 * Метод парсит лиев ранг серии групп
	 * @param input --- строковое задание серии
	 * @return n --- лиев ранг
	 * @throws Exception
	 */
	public static int parseN(String input) throws Exception {
		int bIndex = input.lastIndexOf(LieTypeGroupNameParser.UNDERLINE) + 1;
		int eIndex = input.indexOf(LieTypeGroupNameParser.LEFT_BRACKET);
		if (bIndex >= 0 && eIndex >= 0) {
			return Integer.parseInt(input.substring(bIndex, eIndex));
		} else {
			throw new Exception("Uncorrect group range");
		}
	}
	
	public class componentsParser {
		
		protected String inputStr;
		
		public componentsParser(String inputStr) {
			super();
			this.inputStr = inputStr;
		}

		/**
		 * Метод парсит компоненты группы (множество их вершин). Переопределяется в потомках.
		 * @param input --- строковое задание серии
		 * @return Map наименование компоненты - множество её вершин
		 */
		public Map<String, List<SymbolVertex>> parseComponents() {
			return null;
		}
	}
	
}