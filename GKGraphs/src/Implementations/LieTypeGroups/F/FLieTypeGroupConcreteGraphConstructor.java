package Implementations.LieTypeGroups.F;

import Kernel.GraphConstructor.Concrete.ConcreteLieTypeGroupGraphConstructor;

public class FLieTypeGroupConcreteGraphConstructor extends ConcreteLieTypeGroupGraphConstructor<FLieTypeGroup> {

	public FLieTypeGroupConcreteGraphConstructor(FLieTypeGroup group) {
		super(group);
		this.cr1 = new FLieTypeGroupTwoOddNonadjacenceVertexesСriterion(group);
		this.cr2 = new FLieTypeGroupWithCharNonadjacenceVertexesСriterion(group);
		this.cr3 = new FLieTypeGroupWithTwoNonadjanceVertexesСriterion(group);
	}
	
}