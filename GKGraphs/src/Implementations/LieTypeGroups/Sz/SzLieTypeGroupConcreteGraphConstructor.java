package Implementations.LieTypeGroups.Sz;

import Kernel.GraphConstructor.Concrete.ConcreteLieTypeGroupGraphConstructor;

public class SzLieTypeGroupConcreteGraphConstructor extends ConcreteLieTypeGroupGraphConstructor<SzLieTypeGroup> {

	public SzLieTypeGroupConcreteGraphConstructor(SzLieTypeGroup group) {
		super(group);
		this.cr1 = new SzLieTypeGroupTwoOddNonadjacenceVertexesСriterion(group);
		this.cr2 = new SzLieTypeGroupWithCharNonadjacenceVertexesСriterion(group);
		this.cr3 = new SzLieTypeGroupWithTwoNonadjanceVertexesСriterion(group);
	}
	
}