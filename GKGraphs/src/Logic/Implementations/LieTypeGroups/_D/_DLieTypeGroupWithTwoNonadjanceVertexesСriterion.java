package Logic.Implementations.LieTypeGroups._D;

import Logic.Kernel.Graph.Edge;
import Logic.Kernel.GraphConstructor.Concrete.Сriterion.WithTwoNonadjanceVertexesСriterion;
import Logic.Kernel.Utils.CriterionUtils;

public class _DLieTypeGroupWithTwoNonadjanceVertexesСriterion extends WithTwoNonadjanceVertexesСriterion {
	
	public _DLieTypeGroupWithTwoNonadjanceVertexesСriterion(_DLieTypeGroup group) {
		super(group);
	}
	
	@Override
	protected boolean check(Edge edge) {
		return CriterionUtils.epsilonDLieTypeGroupWithTwoNonadjanceVertexesСriterion(this.ltGroup, edge, CriterionUtils.MINUS);
	}
	
}