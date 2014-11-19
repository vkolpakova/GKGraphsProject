package Kernel.GraphConstructor.Сriterion;

import java.util.List;

import Kernel.Graph.Edge;
import Kernel.Group.AbstractGroup;

public class WithTwoNonadjanceVertexesСriterion extends AbstractСriterion {

	public WithTwoNonadjanceVertexesСriterion(AbstractGroup group) {
		super(group);
	}
	
	public WithTwoNonadjanceVertexesСriterion(List<Edge> edgeList, AbstractGroup group) {
		super(edgeList, group);
	}

	@Override
	protected boolean check(Edge edge) {
		return false;
	}
	
}