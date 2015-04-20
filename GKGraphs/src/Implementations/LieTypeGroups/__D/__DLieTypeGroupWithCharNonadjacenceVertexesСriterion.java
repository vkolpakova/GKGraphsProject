package Implementations.LieTypeGroups.__D;

import Kernel.Graph.Edge;
import Kernel.GraphConstructor.Concrete.Сriterion.WithCharNonadjacenceVertexesСriterion;
import Kernel.Utils.ArithmeticUtils;

public class __DLieTypeGroupWithCharNonadjacenceVertexesСriterion extends WithCharNonadjacenceVertexesСriterion {

	public __DLieTypeGroupWithCharNonadjacenceVertexesСriterion(__DLieTypeGroup group) {
		super(group);
	}
	
	@Override
	protected boolean check(Edge edge) {
		Integer a = (Integer) edge.getVertexA().getVertex();
		Integer b = (Integer) edge.getVertexB().getVertex();
		int r = super.returnR(a, b);
		return (r != 0) ? (ArithmeticUtils.e(r, this.ltGroup.getQ()) == 12) : false;
	}
	
}