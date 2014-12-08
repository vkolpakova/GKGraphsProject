package Implementations.LieTypeGroups.Ri;

import Kernel.GraphConstructor.Concrete.ConcreteLieTypeGroupGraphConstructor;

public class RiLieTypeGroupConcreteGraphConstructor extends ConcreteLieTypeGroupGraphConstructor<RiLieTypeGroup> {

	public RiLieTypeGroupConcreteGraphConstructor(RiLieTypeGroup group) {
		super(group);
		this.cr1 = new RiLieTypeGroupTwoOddNonadjacenceVertexesСriterion(group);
		this.cr2 = new RiLieTypeGroupWithCharNonadjacenceVertexesСriterion(group);
		this.cr3 = new RiLieTypeGroupWithTwoNonadjanceVertexesСriterion(group);
	}
	
}