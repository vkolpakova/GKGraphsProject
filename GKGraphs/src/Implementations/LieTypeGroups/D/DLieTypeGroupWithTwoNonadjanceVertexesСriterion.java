package Implementations.LieTypeGroups.D;

import Kernel.Graph.Edge;
import Kernel.GraphConstructor.Concrete.Сriterion.WithTwoNonadjanceVertexesСriterion;
import Kernel.Utils.CriterionUtils;

public class DLieTypeGroupWithTwoNonadjanceVertexesСriterion extends WithTwoNonadjanceVertexesСriterion {

	public DLieTypeGroupWithTwoNonadjanceVertexesСriterion(DLieTypeGroup group) {
		super(group);
	}
	
	@Override
	protected boolean check(Edge edge) {
		return CriterionUtils.epsilonDLieTypeGroupWithTwoNonadjanceVertexesСriterion(this.ltGroup, edge, CriterionUtils.PLUS);
	}
	
}