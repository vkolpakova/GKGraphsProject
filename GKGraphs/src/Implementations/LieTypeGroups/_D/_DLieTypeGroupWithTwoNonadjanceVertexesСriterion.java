package Implementations.LieTypeGroups._D;

import Kernel.Graph.Edge;
import Kernel.GraphConstructor.Сriterion.WithTwoNonadjanceVertexesСriterion;
import Kernel.Utils.CriterionUtils;

public class _DLieTypeGroupWithTwoNonadjanceVertexesСriterion extends WithTwoNonadjanceVertexesСriterion {
	
	public _DLieTypeGroupWithTwoNonadjanceVertexesСriterion(_DLieTypeGroup group) {
		super(group);
	}
	
	@Override
	protected boolean check(Edge edge) {
		return CriterionUtils.epsilonDLieTypeGroupWithTwoNonadjanceVertexesСriterion(this.ltGroup, edge, CriterionUtils.MINUS);
	}
	
}