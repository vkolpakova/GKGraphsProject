package Implementations.LieTypeGroups.D;

import Kernel.Graph.Edge;
import Kernel.GraphConstructor.Сriterion.TwoOddNonadjacenceVertexesСriterion;
import Kernel.Utils.ArithmeticUtils;
import Kernel.Utils.CriterionUtils;

public class DLieTypeGroupTwoOddNonadjacenceVertexesСriterion extends TwoOddNonadjacenceVertexesСriterion {

	public DLieTypeGroupTwoOddNonadjacenceVertexesСriterion(DLieTypeGroup group) {
		super(group);
	}
	
	@Override
	protected boolean check(Edge edge) {
		if (super.check(edge)) {
			int a = (Integer)edge.getVertexA().getVertex();
			int b = (Integer)edge.getVertexB().getVertex();
			int aK = ArithmeticUtils.e(a, this.ltGroup.getQ());
			int bL = ArithmeticUtils.e(b, this.ltGroup.getQ());
			int etaaK = ArithmeticUtils.eta(aK);
			int etabL = ArithmeticUtils.eta(bL);
			return (etaaK <= etabL) ? subcheck(aK, bL, etaaK, etabL) : subcheck(bL, aK, etabL, etaaK);
		} else {
			return false;
		}
	}
	
	private boolean subcheck(int k, int l, int etaK, int etaL) {
		return (2*(etaK + etaL) > 2*this.ltGroup.getN() - (1 - Math.pow(-1, k+l))) && 
				(CriterionUtils.thirdCondition(k, l) && !(condition(this.ltGroup.getN(), k, l, etaL, etaK)));
	}
	
	private boolean condition(int n, int k, int l, int etaL, int etaK) {
		boolean eq1 = (n == l);
		boolean eq2 = (l == (2*etaL));
		boolean eq3 = (etaK == etaL);
		boolean eq4 = (etaK == k);
		return eq1 && eq2 && eq3 && eq4;
	}
	
}