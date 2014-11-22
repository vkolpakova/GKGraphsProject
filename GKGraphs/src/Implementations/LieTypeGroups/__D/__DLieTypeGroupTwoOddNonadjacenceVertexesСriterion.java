package Implementations.LieTypeGroups.__D;

import Kernel.Graph.Edge;
import Kernel.GraphConstructor.Сriterion.TwoOddNonadjacenceVertexesСriterion;
import Kernel.Utils.ArithmeticUtils;

public class __DLieTypeGroupTwoOddNonadjacenceVertexesСriterion extends TwoOddNonadjacenceVertexesСriterion {

	public __DLieTypeGroupTwoOddNonadjacenceVertexesСriterion(__DLieTypeGroup group) {
		super(group);
	}
	
	@Override
	protected boolean check(Edge edge) {
		if (super.check(edge)) {
			int r = (int) edge.getVertexA().getVertex();
			int s = (int) edge.getVertexB().getVertex();
			int k = ArithmeticUtils.e(r, this.ltGroup.getQ());
			int l = ArithmeticUtils.e(s, this.ltGroup.getQ());
			return ((((l == 6) && (k == 3)) || ((l == 6) && (l == 3))) || (((l == 12) && (k < l)) || ((k == 12) && (l <k))));
		} else {
			return false;
		}
	}
	
}