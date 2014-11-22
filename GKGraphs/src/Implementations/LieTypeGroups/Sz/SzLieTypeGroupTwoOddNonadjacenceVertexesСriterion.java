package Implementations.LieTypeGroups.Sz;

import Kernel.Graph.Edge;
import Kernel.GraphConstructor.Сriterion.TwoOddNonadjacenceVertexesСriterion;
import Kernel.Utils.ArithmeticUtils;

public class SzLieTypeGroupTwoOddNonadjacenceVertexesСriterion extends TwoOddNonadjacenceVertexesСriterion {

	public SzLieTypeGroupTwoOddNonadjacenceVertexesСriterion(SzLieTypeGroup group) {
		super(group);
	}
	
	@Override
	protected boolean check(Edge edge) {
		if (super.check(edge)) {
			int a = (Integer)edge.getVertexA().getVertex();
			int b = (Integer)edge.getVertexB().getVertex();
			int aE = ArithmeticUtils.e(a, this.ltGroup.getQ());
			int bE = ArithmeticUtils.e(b, this.ltGroup.getQ());
			int r = (aE <= bE) ? a : b;
			int s = (aE <= bE) ? b : a;
			int k = (aE <= bE) ? aE : bE;
			int l = (aE <= bE) ? bE : aE;
			int mk = ArithmeticUtils.m_iB(k, this.ltGroup.getQ());
			int ml = ArithmeticUtils.m_iB(l, this.ltGroup.getQ());
			return (((mk % r) == 0) && ((ml % s) == 0) && (k != l));
		} else {
			return false;
		}
	}
	
}