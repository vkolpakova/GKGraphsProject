package Implementations.LieTypeGroups.D;

import Kernel.Graph.Edge;
import Kernel.GraphConstructor.Concrete.Сriterion.WithCharNonadjacenceVertexesСriterion;
import Kernel.Utils.CriterionUtils;

public class DLieTypeGroupWithCharNonadjacenceVertexesСriterion extends WithCharNonadjacenceVertexesСriterion {

	public DLieTypeGroupWithCharNonadjacenceVertexesСriterion(DLieTypeGroup group) {
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