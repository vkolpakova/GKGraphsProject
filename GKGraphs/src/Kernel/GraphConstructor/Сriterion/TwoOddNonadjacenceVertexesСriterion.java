package Kernel.GraphConstructor.Сriterion;

import java.util.List;

import Kernel.Graph.Edge;
import Kernel.Group.AbstractGroup;

public class TwoOddNonadjacenceVertexesСriterion extends AbstractСriterion {

	public TwoOddNonadjacenceVertexesСriterion(AbstractGroup group) {
		super(group);
	}
	
	public TwoOddNonadjacenceVertexesСriterion(List<Edge> edgeList, AbstractGroup group) {
		super(edgeList, group);
	}

	@Override
	protected boolean check(Edge edge) {
		return false;
	}
	
}