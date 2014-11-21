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
		if (super.check(edge)) {
			int q = this.ltGroup.getQ();
			int n = this.ltGroup.getN();
			int etaK, etaL;
			// TODO подумать над рефакторингом, чтобы избавиться от приведения типов
			int k = ArithmeticUtils.e(((Integer)edge.getVertexA().getVertex()), q);
			int l = ArithmeticUtils.e(((Integer)edge.getVertexB().getVertex()), q);
			if ((k % 2 != 0) && (l % 2 != 0)) {
				etaK = ArithmeticUtils.eta(k);
				etaL = ArithmeticUtils.eta(l);
				if (etaK+etaL > n) {
					return condition(etaK, etaL);
				} else {
					return false;
				}
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	private boolean condition(int etaK, int etaL) {
		boolean result = false;
		if (etaK <= etaL) {
			result = !checkDivisionIsOddZNumber(etaK, etaL);
		} else {
			result = !checkDivisionIsOddZNumber(etaL, etaK);
		}
		return result;
	}
	
	private boolean checkDivisionIsOddZNumber(int etaK, int etaL) {
		if (etaL % etaK != 0) {
			return false;
		} else {
			return ((etaL / etaK) % 2) != 0;
		}
	}
	
}