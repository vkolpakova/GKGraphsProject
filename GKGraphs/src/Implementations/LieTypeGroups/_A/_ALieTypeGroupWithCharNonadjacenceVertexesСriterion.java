package Implementations.LieTypeGroups._A;

import Kernel.Graph.Edge;
import Kernel.GraphConstructor.Concrete.Сriterion.WithCharNonadjacenceVertexesСriterion;
import Kernel.Utils.ArithmeticUtils;

public class _ALieTypeGroupWithCharNonadjacenceVertexesСriterion extends WithCharNonadjacenceVertexesСriterion {

	public _ALieTypeGroupWithCharNonadjacenceVertexesСriterion(_ALieTypeGroup group) {
		super(group);
	}
	
	@Override
	protected boolean check(Edge edge) {
		int a = (Integer)edge.getVertexA().getVertex();
		int b = (Integer)edge.getVertexB().getVertex();
		int p = this.ltGroup.getP();
		int q = this.ltGroup.getQ();
		int n = this.ltGroup.getN();
		if ((a != p) && (b != p)) {
			return false;
		} else if (a == p) {
			return subcheck(b, q, n);
		} else {
			return subcheck(a, q, n);
		}
	}
	
	private boolean subcheck(int r, int q, int n) {
		if (r != 2) {
			return ((ArithmeticUtils.nu(ArithmeticUtils.e(r, q)) > (n - 1)) || 
					((r == 3) && (n == 2) && (ArithmeticUtils.nPart(q + 1, 3) == 3)));
		} else {
			return false;
		}
	}
	
}