package Implementations.LieTypeGroups.B;

import Kernel.Graph.Edge;
import Kernel.GraphConstructor.Сriterion.WithCharNonadjacenceVertexesСriterion;
import Kernel.Utils.ArithmeticUtils;

public class BLieTypeGroupWithCharNonadjacenceVertexesСriterion extends WithCharNonadjacenceVertexesСriterion {
	
	public BLieTypeGroupWithCharNonadjacenceVertexesСriterion(BLieTypeGroup group) {
		super(group);
	}
	
	@Override
	protected boolean check(Edge edge) {
		int a = (Integer)edge.getVertexA().getVertex();
		int b = (Integer)edge.getVertexB().getVertex();
		int p = ((BLieTypeGroup)this.group).getP();
		int q = ((BLieTypeGroup)this.group).getQ();
		if (a == p) {
			return subcheck(q, b);
		} else if (b == p) {
			return subcheck(q, a);
		}
		return false;
	}
	
	private boolean subcheck(int q, int r) {
		return ArithmeticUtils.nu(ArithmeticUtils.e(r, q)) > ((BLieTypeGroup)this.group).getN()-2;
	}
	
}