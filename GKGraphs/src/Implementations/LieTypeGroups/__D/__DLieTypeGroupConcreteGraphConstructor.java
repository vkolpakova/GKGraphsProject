package Implementations.LieTypeGroups.__D;

import Kernel.GraphConstructor.Concrete.ConcreteLieTypeGroupGraphConstructor;


public class __DLieTypeGroupConcreteGraphConstructor extends ConcreteLieTypeGroupGraphConstructor<__DLieTypeGroup> {

	public __DLieTypeGroupConcreteGraphConstructor(__DLieTypeGroup group) {
		super(group);
		this.cr1 = new __DLieTypeGroupTwoOddNonadjacenceVertexesСriterion(group);
		this.cr2 = new __DLieTypeGroupWithCharNonadjacenceVertexesСriterion(group);
		this.cr3 = new __DLieTypeGroupWithTwoNonadjanceVertexesСriterion(group);
	}
	
}