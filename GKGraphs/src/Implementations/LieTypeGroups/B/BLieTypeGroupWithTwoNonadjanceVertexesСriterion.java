package Implementations.LieTypeGroups.B;

import Kernel.Graph.Edge;
import Kernel.GraphConstructor.Сriterion.WithTwoNonadjanceVertexesСriterion;
import Kernel.Utils.ArithmeticUtils;

public class BLieTypeGroupWithTwoNonadjanceVertexesСriterion extends WithTwoNonadjanceVertexesСriterion {

	public BLieTypeGroupWithTwoNonadjanceVertexesСriterion(BLieTypeGroup group) {
		super(group);
	}
	
	@Override
	protected boolean check(Edge edge) {
		int a = (Integer)edge.getVertexA().getVertex();
		int b = (Integer)edge.getVertexB().getVertex();
		int p = this.ltGroup.getP();
		if (((a == p) || (b == p)) || ((a != 2) && (b != 2))) {
			return false;
		} else {
			int q = this.ltGroup.getQ();
			int n = this.ltGroup.getN();
			int r = (a == 2) ? b : a;
			int k = ArithmeticUtils.e(r, q);
			if (ArithmeticUtils.eta(k) == n) {
				return subcheck(n, k, q);
			} else {
				return false;
			}
		}
	}
	
	private boolean subcheck(int n, int k, int q) {
		return (n % 2 != 0) ? (k == (3 - ArithmeticUtils.e(2, q)) * n) : (k == 2 * n);
	}
	
}