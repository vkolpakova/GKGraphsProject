package Logic.Implementations.LieTypeGroups._D;

import Logic.Kernel.Graph.Edge;
import Logic.Kernel.GraphConstructor.Concrete.Сriterion.WithCharNonadjacenceVertexesСriterion;
import Logic.Kernel.Utils.CriterionUtils;

public class _DLieTypeGroupWithCharNonadjacenceVertexesСriterion extends WithCharNonadjacenceVertexesСriterion {
	
	public _DLieTypeGroupWithCharNonadjacenceVertexesСriterion(_DLieTypeGroup group) {
		super(group);
	}
	
	@Override
	protected boolean check(Edge edge) {
		int a = (Integer)edge.getVertexA().getVertex();
		int b = (Integer)edge.getVertexB().getVertex();
		int p = this.ltGroup.getP();
		if ((a != p) && (b != p)) {
			return false;
		} else if (a == p) {
			return CriterionUtils.epsilonDLieTypeGroupWithCharNonadjacenceVertexesСriterion(
					b, this.ltGroup.getQ(), this.ltGroup.getN());
		} else {
			return CriterionUtils.epsilonDLieTypeGroupWithCharNonadjacenceVertexesСriterion(
					a, this.ltGroup.getQ(), this.ltGroup.getN());
		}
	}
	
}