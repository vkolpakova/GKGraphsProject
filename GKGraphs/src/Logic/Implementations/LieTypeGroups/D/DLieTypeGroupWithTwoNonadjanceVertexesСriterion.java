package Logic.Implementations.LieTypeGroups.D;

import Logic.Kernel.Graph.Edge;
import Logic.Kernel.GraphConstructor.Concrete.Сriterion.WithTwoNonadjanceVertexesСriterion;
import Logic.Kernel.Utils.CriterionUtils;

public class DLieTypeGroupWithTwoNonadjanceVertexesСriterion extends WithTwoNonadjanceVertexesСriterion {

	public DLieTypeGroupWithTwoNonadjanceVertexesСriterion(DLieTypeGroup group) {
		super(group);
	}
	
	@Override
	protected boolean check(Edge edge) {
		return CriterionUtils.epsilonDLieTypeGroupWithTwoNonadjanceVertexesСriterion(this.ltGroup, edge, CriterionUtils.PLUS);
	}
	
}