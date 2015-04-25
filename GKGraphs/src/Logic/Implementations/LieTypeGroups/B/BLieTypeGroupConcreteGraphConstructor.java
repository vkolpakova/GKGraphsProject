package Logic.Implementations.LieTypeGroups.B;

import Logic.Kernel.GraphConstructor.Concrete.ConcreteLieTypeGroupGraphConstructor;

public class BLieTypeGroupConcreteGraphConstructor extends ConcreteLieTypeGroupGraphConstructor<BLieTypeGroup> {
	
	public BLieTypeGroupConcreteGraphConstructor(BLieTypeGroup group) {
		super(group);
		this.cr1 = new BLieTypeGroupTwoOddNonadjacenceVertexesСriterion(group);
		this.cr2 = new BLieTypeGroupWithCharNonadjacenceVertexesСriterion(group);
		this.cr3 = new BLieTypeGroupWithTwoNonadjanceVertexesСriterion(group);
	}
	
}