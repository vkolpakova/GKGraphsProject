package Implementations.LieTypeGroups.B;

import Kernel.Graph.Edge;
import Kernel.GraphConstructor.Сriterion.TwoOddNonadjacenceVertexesСriterion;
import Kernel.Utils.ArithmeticUtils;

public class BLieTypeGroupTwoOddNonadjacenceVertexesСriterion extends TwoOddNonadjacenceVertexesСriterion {
	
	public BLieTypeGroupTwoOddNonadjacenceVertexesСriterion(BLieTypeGroup group) {
		super(group);
	}
	
	@Override
	protected boolean check(Edge edge) {
		int q = ((BLieTypeGroup)this.group).getQ();
		int n = ((BLieTypeGroup)this.group).getN();
		int nuK, nuL;
		// TODO подумать над рефакторингом, чтобы избавиться от приведения типов
		int k = ArithmeticUtils.e(((Integer)edge.getVertexA().getVertex()), q);
		int l = ArithmeticUtils.e(((Integer)edge.getVertexB().getVertex()), q);
		if ((k%2 != 0) && (l%2 != 0)) {
			nuK = ArithmeticUtils.nu(k);
			nuL = ArithmeticUtils.nu(l);
			if (nuK+nuL > n) {
				return condition(nuK, nuL);
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	private boolean condition(int nuK, int nuL) {
		boolean result = false;
		if (nuK <= nuL) {
			result = !checkDivisionIsOddZNumber(nuK, nuL);
		} else {
			result = !checkDivisionIsOddZNumber(nuL, nuK);
		}
		return result;
	}
	
	private boolean checkDivisionIsOddZNumber(int nuK, int nuL) {
		if (nuL%nuK != 0) {
			return false;
		} else {
			return ((nuL/nuK)%2) != 0;
		}
	}
	
}