package Kernel.Utils;

import java.util.List;
import java.util.Map;

import com.google.common.collect.Lists;

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
	
	public static final String SEPARATOR = ", "; // TODO убрать зашивку на пробел (заменить на любое кол-во пробелов справа и слева)
	public static final String INVOLUTION = "^";
	
	private String input;
	
	public SeriesGroupParser(String input) {
		super();
		this.input = input;
	}
	
	/**
	 * Метод парсит тип серии групп
	 * @param input --- строковое задание серии
	 * @return groupType
	 */
	public GroupType parseName() {
		if (this.input.startsWith("A")) {
			return GroupType.A;
		}
		return null;
	}
	
	/**
	 * Метод парсит лиев ранг серии групп
	 * @return n --- лиев ранг
	 * @throws Exception
	 */
	public int parseN() throws Exception {
		int bIndex = this.input.lastIndexOf(LieTypeGroupNameParser.UNDERLINE) + 1;
		int eIndex = this.input.indexOf(LieTypeGroupNameParser.LEFT_BRACKET);
		if (bIndex >= 0 && eIndex >= 0) {
			return Integer.parseInt(this.input.substring(bIndex, eIndex));
		} else {
			throw new Exception("Uncorrect group range");
		}
	}
	
	/**
	 * Метод парсит q серии групп
	 * @return q
	 * @throws Exception
	 */
	public String parseQ() throws Exception {
		int bIndex = this.input.indexOf(LieTypeGroupNameParser.LEFT_BRACKET) + 1;
		int eIndex = this.input.indexOf(LieTypeGroupNameParser.RIGHT_BRACKET);
		if (bIndex >= 0 && eIndex >= 0) {
			return this.input.substring(bIndex, eIndex);
		} else {
			throw new Exception("Uncorrect field order");
		}
	}
	
	/**
	 * Метод парсит p серии групп
	 * @return p
	 * @throws Exception
	 */
	public String parseP() throws Exception {
		String q = parseQ();
		if (q.contains(INVOLUTION)) {
			return q.substring(0, q.indexOf(INVOLUTION));
		} else {
			return q;
		}
	}
	
	/**
	 * Метод парсит m серии групп,где q = p^m
	 * @return m
	 * @throws Exception
	 */
	public String parseM() throws Exception {
		String q = parseQ();
		if (q.contains(INVOLUTION)) {
			return q.substring(q.indexOf(INVOLUTION) + 1, q.indexOf(INVOLUTION) + q.length());
		} else {
			return q;
		}
	}
	
	public class ComponentsParser {
		
		protected String inputStr;
		
		public ComponentsParser(String inputStr) {
			super();
			this.inputStr = inputStr;
		}

		/**
		 * Метод парсит компоненты группы (множество их вершин). Переопределяется в потомках.
		 * @param input --- строковое задание серии
		 * @return Map наименование компоненты - множество её вершин
		 */
		public Map<String, List<SymbolVertex>> parseComponents() throws Exception {
			return null;
		}
		
		/**
		 * Метод строит коллекцию вершин по строке вида pi_i = {v1, v2, v3, ...}
		 * @param componentName --- обозначение компоненты
		 * @return
		 */
		protected List<SymbolVertex> getVerticesList(String componentName) {
			List<SymbolVertex> result = Lists.newArrayList();
			int piIndex = this.inputStr.indexOf(componentName);
			int startIndex = this.inputStr.indexOf(LieTypeGroupNameParser.LEFT_BRACE, piIndex) + 1;
			int endIndex = this.inputStr.indexOf(LieTypeGroupNameParser.RIGHT_BRACE, piIndex);
			String compStr = this.inputStr.substring(startIndex, endIndex);
			String[] verticesArray = compStr.split(SEPARATOR);
			for (String vStr : verticesArray) {
				SymbolVertex vertex = new SymbolVertex(vStr);
				result.add(vertex);
			}
			return result;
		}
		
	}
	
}