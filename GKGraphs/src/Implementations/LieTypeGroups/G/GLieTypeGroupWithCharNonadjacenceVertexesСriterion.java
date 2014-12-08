package Implementations.LieTypeGroups.G;

import Kernel.Graph.Edge;
import Kernel.GraphConstructor.Concrete.Сriterion.WithCharNonadjacenceVertexesСriterion;
import Kernel.Utils.ArithmeticUtils;

public class GLieTypeGroupWithCharNonadjacenceVertexesСriterion extends WithCharNonadjacenceVertexesСriterion {

	public GLieTypeGroupWithCharNonadjacenceVertexesСriterion(GLieTypeGroup group) {
		super(group);
	}
	
	@Override
	protected boolean check(Edge edge) {
		int a = (Integer)edge.getVertexA().getVertex();
		int b = (Integer)edge.getVertexB().getVertex();
		int r = super.returnR(a, b);
		if (r != 0) {
			int k = ArithmeticUtils.e(r, this.ltGroup.getQ());
			return ((k == 3) || (k == 6));
		} else {
			return false;
		}
	}
	
}