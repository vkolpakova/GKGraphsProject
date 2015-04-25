package Logic.Implementations.LieTypeGroups.__D;

import Logic.Kernel.Graph.Edge;
import Logic.Kernel.GraphConstructor.Concrete.Сriterion.TwoOddNonadjacenceVertexesСriterion;
import Logic.Kernel.Utils.ArithmeticUtils;

public class __DLieTypeGroupTwoOddNonadjacenceVertexesСriterion extends TwoOddNonadjacenceVertexesСriterion {

	public __DLieTypeGroupTwoOddNonadjacenceVertexesСriterion(__DLieTypeGroup group) {
		super(group);
	}
	
	@Override
	protected boolean check(Edge edge) {
		if (super.check(edge)) {
			Integer r = (Integer) edge.getVertexA().getVertex();
			Integer s = (Integer) edge.getVertexB().getVertex();
			int k = ArithmeticUtils.e(r, this.ltGroup.getQ());
			int l = ArithmeticUtils.e(s, this.ltGroup.getQ());
			return ((((l == 6) && (k == 3)) || ((k == 6) && (l == 3))) || (((l == 12) && (k < l)) || ((k == 12) && (l <k))));
		} else {
			return false;
		}
	}
	
}