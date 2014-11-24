package Kernel.Utils;

import Kernel.Graph.Edge;
import Kernel.Group.LieTypeGroup;
import Kernel.Group.LieTypeGroup.GroupType;

/**
 * Класс утилитарных методов для критериев несмежности двух вершин в графе Грюнберга --- Кегеля группы Лиева типа
 * 
 * @author v.kolpakova
 *
 */
public class CriterionUtils {
	
	public static final String PLUS = "+";
	public static final String MINUS = "-";
	
	/**
	 * Метод определяет, удовлетворяют ли две вершины условию (3) + доп. условия
	 * @param k
	 * @param l
	 * @param etaK
	 * @param etaL
	 * @param n
	 * @return
	 */
	public static boolean thirdCondition(int k, int l, int etaK, int etaL, int n) {
		if (etaK + etaL > n) {
			return thirdCondition(k, l);
		} else {
			return false;
		}
	}
	
	/**
	 * Метод определяет, удовлетворяют ли две вершины условию (3)
	 * @param etaK
	 * @param etaL
	 * @return
	 */
	public static boolean thirdCondition(int etaK, int etaL) {
		boolean result = false;
		if (etaL <= etaK) {
			result = !checkDivisionIsOddZNumber(etaK, etaL);
		} else {
			result = !checkDivisionIsOddZNumber(etaL, etaK);
		}
		return result;
	}
	
	private static boolean checkDivisionIsOddZNumber(int etaK, int etaL) {
		if (etaK % etaL != 0) {
			return false;
		} else {
			return (((etaK / etaL) % 2) != 0);
		}
	}
	
	/**
	 * Критерий несмежности простого числа r с характеристикой поля в графе Грюнберга --- Кегеля
	 * группы типа Depsilon_n(q), epsilon = +/- 1.
	 * @param r
	 * @param q
	 * @param n
	 * @return
	 */
	public static boolean epsilonDLieTypeGroupWithCharNonadjacenceVertexesСriterion(int r, int q, int n) {
		int eta = ArithmeticUtils.eta(ArithmeticUtils.e(r, q));
		return (eta > n - 2);
	}
	
	/**
	 * Критерий несмежности простого числа, отличного от характеристики, с 2 в графе Грюнберга --- Кегеля
	 * группы типа Depsilon_n(q), epsilon = +/- 1.
	 * @param epsilonDGroup
	 * @param edge
	 * @param epsilon
	 * @return
	 */
	public static boolean epsilonDLieTypeGroupWithTwoNonadjanceVertexesСriterion(LieTypeGroup epsilonDGroup, Edge edge, String epsilon) {
		int a = (Integer)edge.getVertexA().getVertex();
		int b = (Integer)edge.getVertexB().getVertex();
		if (((a != 2) && (b != 2)) || (epsilonDGroup.getP() == 2) || (a == epsilonDGroup.getP()) || b == epsilonDGroup.getP()) {
			return false;
		} else {
			int r = returnRWithCondition(a, b, 2);
			int k = ArithmeticUtils.e(r, epsilonDGroup.getQ());
			int etaK = ArithmeticUtils.eta(k);
			boolean cond1, cond2, cond3, cond4;
			if (epsilon.equals(PLUS)) {
				int num = (int) (Math.pow(epsilonDGroup.getQ(), epsilonDGroup.getN()) - 1);
				cond1 = (etaK == epsilonDGroup.getN()) && 
						(ArithmeticUtils.NOD(4, num) == ArithmeticUtils.nPart(num, 2));
				int e2q = ArithmeticUtils.e(2, epsilonDGroup.getQ());
				cond2 = (etaK == k) && (k == epsilonDGroup.getN() - 1) && ((epsilonDGroup.getN() % 2) == 0) && (e2q == 2);
				cond3 = ((k % 2) == 0) && (etaK == (k / 2)) && (etaK == (epsilonDGroup.getN() - 1)) && (e2q == 1);
				return cond1 || cond2 || cond3;
			} else if (epsilon.equals(MINUS)) {
				int num = (int) (Math.pow(epsilonDGroup.getQ(), epsilonDGroup.getN()) + 1);
				cond1 = (etaK == epsilonDGroup.getN()) && 
						(ArithmeticUtils.NOD(4, num) == ArithmeticUtils.nPart(num, 2));
				int e2q = ArithmeticUtils.e(2, epsilonDGroup.getQ());
				cond4 = ((k % 2) == 0) && (etaK == (k / 2)) && (etaK == (epsilonDGroup.getN() - 1)) && (e2q == 2);
				return cond1 || cond4;
			}
		}
		return false;
	}
	
	/**
	 * На входе дана пара чисел a и b, одно из которых равно cond. </br>
	 * Метод возвращает число из пары, отличное от cond, и 0, если оба числа не равны cond.
	 * @param a
	 * @param b
	 * @param cond
	 * @return
	 */
	public static int returnRWithCondition(int a, int b, int cond) {
		if ((a != cond) && (b != cond)) {
			return 0;
		} else {
			return (a == cond) ? b : a;
		}
	}
	
	/**
	 * Критерий несмежности двух нечетных простых чисел в графе Грюнберга --- Кегеля группы типа Sz или Ri
	 * @param edge
	 * @param type
	 * @param q
	 * @return
	 */
	public static boolean SzRiLieTypeGroupTwoOddNonadjacenceVertexesСriterion(Edge edge, GroupType type, int q) {
		int a = (Integer)edge.getVertexA().getVertex();
		int b = (Integer)edge.getVertexB().getVertex();
		int aE = ArithmeticUtils.e(a, q);
		int bE = ArithmeticUtils.e(b, q);
		int r = (aE <= bE) ? a : b;
		int s = (aE <= bE) ? b : a;
		int k = (aE <= bE) ? aE : bE;
		int l = (aE <= bE) ? bE : aE;
		int mk = (type == GroupType.Ri) ? ArithmeticUtils.m_iG(k, q) : ArithmeticUtils.m_iB(k, q) ;
		int ml = (type == GroupType.Ri) ? ArithmeticUtils.m_iG(l, q) : ArithmeticUtils.m_iB(l, q) ;
		return (((mk % r) == 0) && ((ml % s) == 0) && (k != l));
	}
	
}