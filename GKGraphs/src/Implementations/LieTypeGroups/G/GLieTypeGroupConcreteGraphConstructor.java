package Implementations.LieTypeGroups.G;

import Kernel.GraphConstructor.Concrete.ConcreteLieTypeGroupGraphConstructor;

public class GLieTypeGroupConcreteGraphConstructor extends ConcreteLieTypeGroupGraphConstructor<GLieTypeGroup> {

	public GLieTypeGroupConcreteGraphConstructor(GLieTypeGroup group) {
		super(group);
		this.cr1 = new GLieTypeGroupTwoOddNonadjacenceVertexesСriterion(group);
		this.cr2 = new GLieTypeGroupWithCharNonadjacenceVertexesСriterion(group);
		this.cr3 = new GLieTypeGroupWithTwoNonadjanceVertexesСriterion(group);
	}
	
}