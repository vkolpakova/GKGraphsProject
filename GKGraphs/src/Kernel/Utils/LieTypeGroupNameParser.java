package Kernel.Utils;

import java.util.List;

import Kernel.Group.LieTypeGroup.GroupType;

/**
 * Парсер, определяющий по введенному обозначению группы Лиева типа её данные - тип, ранг, характеристику и порядок поля. </br>
 * Формат ввода: Тип_n(q).
 * 
 * TODO при использовании вставить логгирование
 * 
 * @author v.kolpakova
 *
 */
public class LieTypeGroupNameParser  {
	
	private static final String UNDERLINE = "_";
	private static final String LEFT_BRACKET = "(";
	private static final String RIGHT_BRACKET = ")";
	
	public static GroupType computeGroupType(String name) throws Exception {
		if (name.startsWith(GroupType.A.name())) {
			return GroupType.A;
		} else if (name.startsWith(GroupType._A.name())) {
			return GroupType._A;
		} else if (name.startsWith(GroupType.B.name())) {
			return GroupType.B;
		} else if (name.startsWith(GroupType.C.name())) {
			return GroupType.C;
		} else if (name.startsWith(GroupType.D.name())) {
			return GroupType.D;
		} else if (name.startsWith(GroupType._D.name())) {
			return GroupType._D;
		} else if (name.startsWith(GroupType.__D.name())) {
			return GroupType.__D;
		} else if (name.startsWith(GroupType.G.name())) {
			return GroupType.G;
		} else if (name.startsWith(GroupType.F.name())) {
			return GroupType.F;
		} else if (name.startsWith(GroupType.E6.name())) {
			return GroupType.E6;
		} else if (name.startsWith(GroupType.E7.name())) {
			return GroupType.E7;
		} else if (name.startsWith(GroupType.E8.name())) {
			return GroupType.E8;
		} else {
			throw new Exception("Uncorrect group type");
		}
	}
	
	public static int computeN(String name) throws Exception {
		// обозначение может начинаться с _ или __
		int bIndex = name.lastIndexOf(UNDERLINE) + 1;
		int eIndex = name.indexOf(LEFT_BRACKET);
		if (bIndex >= 0 && eIndex >= 0) {
			return Integer.parseInt(name.substring(bIndex, eIndex));
		} else {
			throw new Exception("Uncorrect group range");
		}
	}
	
	public static int computeQ(String name) throws Exception {
		int bIndex = name.indexOf(LEFT_BRACKET) + 1;
		int eIndex = name.indexOf(RIGHT_BRACKET);
		if (bIndex >= 0 && eIndex >= 0) {
			return Integer.parseInt(name.substring(bIndex, eIndex));
		} else {
			throw new Exception("Uncorrect field order");
		}
	}
	
	public static int computeP(String name) throws Exception {
		int q = computeQ(name);
		List<Integer> pList = ArithmeticUtils.getAllPrimeDevisors(q);
		if (pList.size() == 1) {
			return pList.get(0);
		} else {
			throw new Exception("Uncorrect field characteristic");
		}
	}
	
}