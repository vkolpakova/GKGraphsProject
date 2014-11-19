package Implementations.LieTypeGroups.A;

import Kernel.Graph.Edge;
import Kernel.GraphConstructor.Сriterion.WithCharNonadjacenceVertexesСriterion;
import Kernel.Utils.ArithmeticUtils;

public class ALieTypeGroupWithCharNonadjacenceVertexesСriterion extends WithCharNonadjacenceVertexesСriterion {

	public ALieTypeGroupWithCharNonadjacenceVertexesСriterion(ALieTypeGroup group) {
		super(group);
	}
	
	@Override
	protected boolean check(Edge edge) {
		int a = (Integer)edge.getVertexA().getVertex();
		int b = (Integer)edge.getVertexB().getVertex();
		int p = ((ALieTypeGroup)this.group).getP();
		if (a == p) {
			return subcheck(a, b);
		} else if (b == p) {
			return subcheck(b, a);
		}
		return false;
	}
	
	private boolean subcheck(int p, int r) {
		return (r != 2) && 
				(ArithmeticUtils.e(r, ((ALieTypeGroup)this.group).getQ()) > ((ALieTypeGroup)this.group).getN());
	}
	
}