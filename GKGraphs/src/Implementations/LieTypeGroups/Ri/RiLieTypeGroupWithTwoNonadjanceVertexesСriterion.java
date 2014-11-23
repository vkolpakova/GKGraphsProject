package Implementations.LieTypeGroups.Ri;

import Kernel.Graph.Edge;
import Kernel.GraphConstructor.Сriterion.WithTwoNonadjanceVertexesСriterion;
import Kernel.Utils.ArithmeticUtils;

public class RiLieTypeGroupWithTwoNonadjanceVertexesСriterion extends WithTwoNonadjanceVertexesСriterion {

	public RiLieTypeGroupWithTwoNonadjanceVertexesСriterion(RiLieTypeGroup group) {
		super(group);
	}
	
	@Override
	protected boolean check(Edge edge) {
		int a = (Integer)edge.getVertexA().getVertex();
		int b = (Integer)edge.getVertexB().getVertex();
		int r = super.returnR(a, b);
		if (r != 0) {
			int m3 = ArithmeticUtils.m_iG(3, this.ltGroup.getQ());
			int m4 = ArithmeticUtils.m_iG(4, this.ltGroup.getQ());
			return (((m3 % r) == 0) || ((m4 % r) == 0));
		} else {
			return false;
		}
	}
	
}