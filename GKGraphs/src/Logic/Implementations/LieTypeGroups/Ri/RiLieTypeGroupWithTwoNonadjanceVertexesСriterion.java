package Logic.Implementations.LieTypeGroups.Ri;

import Logic.Kernel.Graph.Edge;
import Logic.Kernel.GraphConstructor.Concrete.Сriterion.WithTwoNonadjanceVertexesСriterion;
import Logic.Kernel.Utils.ArithmeticUtils;

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
			int mr = ArithmeticUtils.m_iG(r, this.ltGroup.getQ());
			return ((mr == 3) || (mr == 4));
		} else {
			return false;
		}
	}
	
}