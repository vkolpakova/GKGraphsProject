package Implementations.LieTypeGroups.__D;

import Kernel.Graph.Edge;
import Kernel.GraphConstructor.Сriterion.WithCharNonadjacenceVertexesСriterion;
import Kernel.Utils.ArithmeticUtils;

public class __DLieTypeGroupWithCharNonadjacenceVertexesСriterion extends WithCharNonadjacenceVertexesСriterion {

	public __DLieTypeGroupWithCharNonadjacenceVertexesСriterion(__DLieTypeGroup group) {
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
		if ((a != this.ltGroup.getP()) && (b != this.ltGroup.getP())) {
			return 0;
		} else {
			return (a == this.ltGroup.getP()) ? b : a;
		}
	}
	
}