package Implementations.LieTypeGroups.__D;

import Kernel.Graph.Edge;
import Kernel.GraphConstructor.Concrete.Сriterion.WithTwoNonadjanceVertexesСriterion;
import Kernel.Utils.ArithmeticUtils;

public class __DLieTypeGroupWithTwoNonadjanceVertexesСriterion extends WithTwoNonadjanceVertexesСriterion {

	public __DLieTypeGroupWithTwoNonadjanceVertexesСriterion(__DLieTypeGroup group) {
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