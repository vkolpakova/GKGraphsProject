package Logic.Implementations.LieTypeGroups._A;

import Logic.Kernel.GraphConstructor.Concrete.ConcreteLieTypeGroupGraphConstructor;

public class _ALieTypeGroupConcreteGraphConstructor extends ConcreteLieTypeGroupGraphConstructor<_ALieTypeGroup> {

	public _ALieTypeGroupConcreteGraphConstructor(_ALieTypeGroup group) {
		super(group);
		this.cr1 = new _ALieTypeGroupTwoOddNonadjacenceVertexesСriterion(group);
		this.cr2 = new _ALieTypeGroupWithCharNonadjacenceVertexesСriterion(group);
		this.cr3 = new _ALieTypeGroupWithTwoNonadjanceVertexesСriterion(group);
	}
	
}