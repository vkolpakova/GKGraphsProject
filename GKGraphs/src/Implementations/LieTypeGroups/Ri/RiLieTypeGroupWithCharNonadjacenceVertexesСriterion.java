package Implementations.LieTypeGroups.Ri;

import Kernel.Graph.Edge;
import Kernel.GraphConstructor.Сriterion.WithCharNonadjacenceVertexesСriterion;
import Kernel.Utils.ArithmeticUtils;

public class RiLieTypeGroupWithCharNonadjacenceVertexesСriterion extends WithCharNonadjacenceVertexesСriterion {

	public RiLieTypeGroupWithCharNonadjacenceVertexesСriterion(RiLieTypeGroup group) {
		super(group);
	}
	
	@Override
	protected boolean check(Edge edge) {
		int a = (Integer)edge.getVertexA().getVertex();
		int b = (Integer)edge.getVertexB().getVertex();
		int r = super.returnR(a, b);
		if (r != 0) {
			int k = ArithmeticUtils.e(r, this.ltGroup.getQ());
			int mk = ArithmeticUtils.m_iG(k, this.ltGroup.getQ());
			return (((mk % r) == 0) && (r != 2));
		} else {
			return false;
		}
	}
	
}