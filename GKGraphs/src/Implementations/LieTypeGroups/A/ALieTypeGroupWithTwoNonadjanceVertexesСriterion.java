package Implementations.LieTypeGroups.A;

import Kernel.Graph.Edge;
import Kernel.GraphConstructor.Сriterion.WithTwoNonadjanceVertexesСriterion;
import Kernel.Utils.ArithmeticUtils;

public class ALieTypeGroupWithTwoNonadjanceVertexesСriterion extends WithTwoNonadjanceVertexesСriterion {

	public ALieTypeGroupWithTwoNonadjanceVertexesСriterion(ALieTypeGroup group) {
		super(group);
	}
	
	@Override
	protected boolean check(Edge edge) {
		int a = (Integer)edge.getVertexA().getVertex();
		int b = (Integer)edge.getVertexB().getVertex();
		int q = this.ltGroup.getQ();
		int k_a = ArithmeticUtils.e(a, q);
		int k_b = ArithmeticUtils.e(b, q);
		if ((k_a == 1) && (b != 2) && (b != this.ltGroup.getP())) {
			return subcheck(a, k_b);
		} else if (k_b == 1 && (a != 2) && (a != this.ltGroup.getP())) {
			return subcheck(b, k_a);
		} else {
			return false;
		}
		
	}
	
	private boolean subcheck(int r, int k) {
		int n = this.ltGroup.getN() + 1;
		int q_modif = this.ltGroup.getQ() - 1;
		if (k == n) {
			int rPartN = ArithmeticUtils.nPart(n, r);
			int rPartQModif = ArithmeticUtils.nPart(q_modif, r);
			if (rPartN < rPartQModif) {
				return true;
			} else if ((rPartN == rPartQModif) && (2 < rPartQModif)) {
				return true;
			} else {
				return false;
			}
		} else if (k == (n - 1)) {
			int rPartN = ArithmeticUtils.nPart(n, r);
			int rPartQModif = ArithmeticUtils.nPart(q_modif, r);
			return (rPartQModif <= rPartN) ? true : false;
		} else {
			return false;
		}
	}
	
}