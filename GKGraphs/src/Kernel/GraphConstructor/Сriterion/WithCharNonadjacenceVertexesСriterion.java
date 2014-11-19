package Kernel.GraphConstructor.Сriterion;

import java.util.List;

import Kernel.Graph.Edge;
import Kernel.Group.AbstractGroup;

public class WithCharNonadjacenceVertexesСriterion extends AbstractСriterion {

	public WithCharNonadjacenceVertexesСriterion(AbstractGroup group) {
		super(group);
	}
	
	public WithCharNonadjacenceVertexesСriterion(List<Edge> edgeList, AbstractGroup group) {
		super(edgeList, group);
	}

	@Override
	protected boolean check(Edge edge) {
		return false;
	}
	
}