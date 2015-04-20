package Implementations.LieTypeGroups.A;

import Kernel.Graph.Edge;
import Kernel.GraphConstructor.Concrete.Сriterion.WithCharNonadjacenceVertexesСriterion;
import Kernel.Utils.ArithmeticUtils;

public class ALieTypeGroupWithCharNonadjacenceVertexesСriterion extends WithCharNonadjacenceVertexesСriterion {

	public ALieTypeGroupWithCharNonadjacenceVertexesСriterion(ALieTypeGroup group) {
		super(group);
	}
	
	@Override
	protected boolean check(Edge edge) {
		int a = (Integer)edge.getVertexA().getVertex();
		int b = (Integer)edge.getVertexB().getVertex();
		int p = this.ltGroup.getP();
		if (a == p) {
			return subcheck(b);
		} else if (b == p) {
			return subcheck(a);
		}
		return false;
	}
	
	private boolean subcheck(int r) {
		return ((r != 2) && (ArithmeticUtils.e(r, this.ltGroup.getQ()) > (this.ltGroup.getN() - 1)) ||
				((r == 2) && (this.ltGroup.getN() == 1)) ||
				((r == 3) && (this.ltGroup.getN() == 2) && (ArithmeticUtils.nPart(this.ltGroup.getQ() - 1, 3) == 3))) ;
	}
	
}