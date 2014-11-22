package Implementations.LieTypeGroups.__D;

import Kernel.Graph.Edge;
import Kernel.GraphConstructor.Сriterion.WithTwoNonadjanceVertexesСriterion;
import Kernel.Utils.ArithmeticUtils;

public class __DLieTypeGroupWithTwoNonadjanceVertexesСriterion extends WithTwoNonadjanceVertexesСriterion {

	public __DLieTypeGroupWithTwoNonadjanceVertexesСriterion(__DLieTypeGroup group) {
		super(group);
	}
	
	@Override
	protected boolean check(Edge edge) {
		int a = (int) edge.getVertexA().getVertex();
		int b = (int) edge.getVertexB().getVertex();
		int r = returnR(a, b);
		return (r != 0) ? (ArithmeticUtils.e(r, this.ltGroup.getQ()) == 12) : false;
	}
	
	private int returnR(int a, int b) {
		if ((a != 2) && (b != 2)) {
			return 0;
		} else {
			return (a == 2) ? b : a;
		}
	}
	
}