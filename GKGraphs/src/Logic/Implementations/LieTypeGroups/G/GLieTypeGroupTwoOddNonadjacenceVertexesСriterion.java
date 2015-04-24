package Logic.Implementations.LieTypeGroups.G;

import Logic.Kernel.Graph.Edge;
import Logic.Kernel.GraphConstructor.Concrete.Сriterion.TwoOddNonadjacenceVertexesСriterion;
import Logic.Kernel.Utils.ArithmeticUtils;

public class GLieTypeGroupTwoOddNonadjacenceVertexesСriterion extends TwoOddNonadjacenceVertexesСriterion {

	public GLieTypeGroupTwoOddNonadjacenceVertexesСriterion(GLieTypeGroup group) {
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
			//int s = (aE <= bE) ? b : a;
			int k = (aE <= bE) ? aE : bE;
			int l = (aE <= bE) ? bE : aE;
			return ((k != l) && (((r != 3) && ((l == 3) || (l == 6))) || ((r == 3) && (l == (9 - 3 * k)))));
		} else {
			return false;
		}
	}
	
}