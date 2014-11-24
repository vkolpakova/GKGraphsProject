package Implementations.LieTypeGroups._D;

import Kernel.Graph.Edge;
import Kernel.GraphConstructor.Сriterion.TwoOddNonadjacenceVertexesСriterion;
import Kernel.Utils.ArithmeticUtils;
import Kernel.Utils.CriterionUtils;

public class _DLieTypeGroupTwoOddNonadjacenceVertexesСriterion extends TwoOddNonadjacenceVertexesСriterion {

	public _DLieTypeGroupTwoOddNonadjacenceVertexesСriterion(_DLieTypeGroup group) {
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
		return (2*(etaK + etaL) > 2*this.ltGroup.getN() - (1 + Math.pow(-1, k+l))) && 
				(CriterionUtils.thirdCondition(k, l));
	}
	
}