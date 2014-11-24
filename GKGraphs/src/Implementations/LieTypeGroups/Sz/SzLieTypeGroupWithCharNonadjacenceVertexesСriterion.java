package Implementations.LieTypeGroups.Sz;

import Kernel.Graph.Edge;
import Kernel.GraphConstructor.Сriterion.WithCharNonadjacenceVertexesСriterion;

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