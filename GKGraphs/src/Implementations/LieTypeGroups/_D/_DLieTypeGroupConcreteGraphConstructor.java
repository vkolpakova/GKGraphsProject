package Implementations.LieTypeGroups._D;

import Kernel.GraphConstructor.Concrete.ConcreteLieTypeGroupGraphConstructor;

public class _DLieTypeGroupConcreteGraphConstructor extends ConcreteLieTypeGroupGraphConstructor<_DLieTypeGroup> {

	public _DLieTypeGroupConcreteGraphConstructor(_DLieTypeGroup group) {
		super(group);
		this.cr1 = new _DLieTypeGroupTwoOddNonadjacenceVertexesСriterion(group);
		this.cr2 = new _DLieTypeGroupWithCharNonadjacenceVertexesСriterion(group);
		this.cr3 = new _DLieTypeGroupWithTwoNonadjanceVertexesСriterion(group);
	}
	
}