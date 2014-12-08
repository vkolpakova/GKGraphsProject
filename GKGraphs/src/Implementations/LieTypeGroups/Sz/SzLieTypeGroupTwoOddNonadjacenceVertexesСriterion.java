package Implementations.LieTypeGroups.Sz;

import Kernel.Graph.Edge;
import Kernel.GraphConstructor.Concrete.Сriterion.TwoOddNonadjacenceVertexesСriterion;
import Kernel.Group.LieTypeGroup.GroupType;
import Kernel.Utils.CriterionUtils;

public class SzLieTypeGroupTwoOddNonadjacenceVertexesСriterion extends TwoOddNonadjacenceVertexesСriterion {

	public SzLieTypeGroupTwoOddNonadjacenceVertexesСriterion(SzLieTypeGroup group) {
		super(group);
	}
	
	@Override
	protected boolean check(Edge edge) {
		return (super.check(edge)) 
				? CriterionUtils.SzRiLieTypeGroupTwoOddNonadjacenceVertexesСriterion(edge, GroupType.Sz, this.ltGroup.getQ())
				: false;
	}
	
}