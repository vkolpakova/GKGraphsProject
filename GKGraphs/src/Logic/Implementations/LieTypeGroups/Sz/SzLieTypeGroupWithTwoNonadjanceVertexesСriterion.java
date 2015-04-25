package Logic.Implementations.LieTypeGroups.Sz;

import Logic.Kernel.Graph.Edge;
import Logic.Kernel.GraphConstructor.Concrete.Сriterion.WithTwoNonadjanceVertexesСriterion;

public class SzLieTypeGroupWithTwoNonadjanceVertexesСriterion extends WithTwoNonadjanceVertexesСriterion {

	public SzLieTypeGroupWithTwoNonadjanceVertexesСriterion(SzLieTypeGroup group) {
		super(group);
	}
	
	@Override
	protected boolean check(Edge edge) {
		// 2 - характеристика поля
		return false;
	}
	
}