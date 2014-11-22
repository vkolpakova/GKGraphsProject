package Implementations.LieTypeGroups.D;

import Kernel.GraphConstructor.ConcreteLieTypeGroupGraphConstructor;

public class DLieTypeGroupConcreteGraphConstructor extends ConcreteLieTypeGroupGraphConstructor<DLieTypeGroup> {

	public DLieTypeGroupConcreteGraphConstructor(DLieTypeGroup group) {
		super(group);
		this.cr1 = new DLieTypeGroupTwoOddNonadjacenceVertexesСriterion(group);
		this.cr2 = new DLieTypeGroupWithCharNonadjacenceVertexesСriterion(group);
		this.cr3 = new DLieTypeGroupWithTwoNonadjanceVertexesСriterion(group);
	}
	
}