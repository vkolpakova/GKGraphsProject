package Implementations.LieTypeGroups.F;

import Kernel.Graph.Edge;
import Kernel.GraphConstructor.Concrete.Сriterion.TwoOddNonadjacenceVertexesСriterion;
import Kernel.Utils.ArithmeticUtils;

public class FLieTypeGroupTwoOddNonadjacenceVertexesСriterion extends TwoOddNonadjacenceVertexesСriterion {

	public FLieTypeGroupTwoOddNonadjacenceVertexesСriterion(FLieTypeGroup group) {
		super(group);
	}
	
	@Override
	protected boolean check(Edge edge) {
		if (super.check(edge)) {
			int a = (Integer)edge.getVertexA().getVertex();
			int b = (Integer)edge.getVertexB().getVertex();
			int aE = ArithmeticUtils.e(a, this.ltGroup.getQ());
			int bE = ArithmeticUtils.e(b, this.ltGroup.getQ());
			//int r = (aE <= bE) ? a : b;
			//int s = (aE <= bE) ? b : a;
			int k = (aE <= bE) ? aE : bE;
			int l = (aE <= bE) ? bE : aE;
			return (((l == 8) || (l == 12)) || (((k == 3) || (k == 4)) && (l == 6)) || ((k == 3) && (l == 4)));
		} else {
			return false;
		}
	}
	
}