package Implementations.LieTypeGroups.B;

import Kernel.Graph.Edge;
import Kernel.GraphConstructor.Concrete.Сriterion.WithCharNonadjacenceVertexesСriterion;
import Kernel.Utils.ArithmeticUtils;

public class BLieTypeGroupWithCharNonadjacenceVertexesСriterion extends WithCharNonadjacenceVertexesСriterion {
	
	public BLieTypeGroupWithCharNonadjacenceVertexesСriterion(BLieTypeGroup group) {
		super(group);
	}
	
	@Override
	protected boolean check(Edge edge) {
		int a = (Integer)edge.getVertexA().getVertex();
		int b = (Integer)edge.getVertexB().getVertex();
		int p = this.ltGroup.getP();
		int q = this.ltGroup.getQ();
		if ((a == p) && (b != 2)) {
			return subcheck(q, b);
		} else if ((b == p) && (a != 2)) {
			return subcheck(q, a);
		}
		return false;
	}
	
	private boolean subcheck(int q, int r) {
		return (ArithmeticUtils.eta(ArithmeticUtils.e(r, q)) > (this.ltGroup.getN() - 1));
	}
	
}