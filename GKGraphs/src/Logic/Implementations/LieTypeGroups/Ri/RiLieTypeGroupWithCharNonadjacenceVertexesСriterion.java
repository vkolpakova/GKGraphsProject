package Logic.Implementations.LieTypeGroups.Ri;

import Logic.Kernel.Graph.Edge;
import Logic.Kernel.GraphConstructor.Concrete.Сriterion.WithCharNonadjacenceVertexesСriterion;
import Logic.Kernel.Utils.ArithmeticUtils;

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
			int mk = ArithmeticUtils.m_iG(r, this.ltGroup.getQ());
			return ((mk != 0) && (r != 2));
		} else {
			return false;
		}
	}
	
}