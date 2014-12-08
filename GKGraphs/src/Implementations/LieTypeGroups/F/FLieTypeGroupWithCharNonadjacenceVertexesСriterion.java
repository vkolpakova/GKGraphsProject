package Implementations.LieTypeGroups.F;

import Kernel.Graph.Edge;
import Kernel.GraphConstructor.Concrete.Сriterion.WithCharNonadjacenceVertexesСriterion;
import Kernel.Utils.ArithmeticUtils;

public class FLieTypeGroupWithCharNonadjacenceVertexesСriterion extends WithCharNonadjacenceVertexesСriterion {

	public FLieTypeGroupWithCharNonadjacenceVertexesСriterion(FLieTypeGroup group) {
		super(group);
	}
	
	@Override
	protected boolean check(Edge edge) {
		int a = (Integer)edge.getVertexA().getVertex();
		int b = (Integer)edge.getVertexB().getVertex();
		int r = super.returnR(a, b);
		if (r != 0) {
			int k = ArithmeticUtils.e(r, this.ltGroup.getQ());
			return ((k == 8) || (k == 12));
		} else {
			return false;
		}
	}
	
}