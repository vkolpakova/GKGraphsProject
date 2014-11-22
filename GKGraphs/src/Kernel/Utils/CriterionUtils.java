package Kernel.Utils;

import Kernel.Graph.Edge;
import Kernel.Group.LieTypeGroup;

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
	 * Метод определяет, удовлетворяют ли две вершины условию (3)
	 * @param etaK
	 * @param etaL
	 * @param n
	 * @return
	 */
	public static boolean thirdCondition(int etaK, int etaL, int n) {
		if (etaK + etaL > n) {
			return condition(etaK, etaL);
		} else {
			return false;
		}
	}
	
	private static boolean condition(int etaK, int etaL) {
		boolean result = false;
		if (etaK <= etaL) {
			result = !checkDivisionIsOddZNumber(etaK, etaL);
		} else {
			result = !checkDivisionIsOddZNumber(etaL, etaK);
		}
		return result;
	}
	
	private static boolean checkDivisionIsOddZNumber(int etaK, int etaL) {
		if (etaL % etaK != 0) {
			return false;
		} else {
			return ((etaL / etaK) % 2) != 0;
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
		if (((a != 2) && (b != 2)) || (a == epsilonDGroup.getP()) || (b == epsilonDGroup.getP())) {
			return false;
		} else {
			int r = returnR(a, b);
			int k = ArithmeticUtils.e(r, epsilonDGroup.getQ());
			int etaK = ArithmeticUtils.eta(k);
			boolean cond1, cond2, cond3, cond4;
			if (epsilon.equals(PLUS)) {
				int num = (int) (Math.pow(epsilonDGroup.getQ(), epsilonDGroup.getN()) - 1);
				cond1 = (etaK == epsilonDGroup.getN()) && 
						(ArithmeticUtils.NOD(4, num) == ArithmeticUtils.nPart(num, 2));
				int e2q = ArithmeticUtils.e(2, epsilonDGroup.getQ());
				cond2 = (etaK == k) && (k == epsilonDGroup.getN() - 1) && ((epsilonDGroup.getN() % 2) == 0) && (e2q == 2);
				cond3 = (etaK == (k / 2)) && (etaK == (epsilonDGroup.getN() - 1)) && (e2q == 1);
				return cond1 || cond2 || cond3;
			} else if (epsilon.equals(MINUS)) {
				int num = (int) (Math.pow(epsilonDGroup.getQ(), epsilonDGroup.getN()) + 1);
				cond1 = (etaK == epsilonDGroup.getN()) && 
						(ArithmeticUtils.NOD(4, num) == ArithmeticUtils.nPart(num, 2));
				int e2q = ArithmeticUtils.e(2, epsilonDGroup.getQ());
				cond4 = (etaK == (k / 2)) && (etaK == (epsilonDGroup.getN() - 1)) && (e2q == 2);
				return cond1 || cond4;
			}
		}
		return false;
	}
	
	private static int returnR(int a, int b) {
		return (a != 2) ? a : b;
	}
	
}