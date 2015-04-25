package Logic.Implementations.LieTypeGroups.Sz;

import Logic.Kernel.Graph.Edge;
import Logic.Kernel.GraphConstructor.Concrete.Сriterion.WithCharNonadjacenceVertexesСriterion;

public class SzLieTypeGroupWithCharNonadjacenceVertexesСriterion extends WithCharNonadjacenceVertexesСriterion {

	public SzLieTypeGroupWithCharNonadjacenceVertexesСriterion(SzLieTypeGroup group) {
		super(group);
	}
	
	@Override
	protected boolean check(Edge edge) {
		// 2 - всегда измолированная вершина
		return true;
	}
	
}