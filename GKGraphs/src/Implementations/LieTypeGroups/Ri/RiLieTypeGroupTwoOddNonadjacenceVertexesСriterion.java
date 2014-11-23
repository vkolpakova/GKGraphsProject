package Implementations.LieTypeGroups.Ri;

import Kernel.Graph.Edge;
import Kernel.GraphConstructor.Сriterion.TwoOddNonadjacenceVertexesСriterion;
import Kernel.Group.LieTypeGroup.GroupType;
import Kernel.Utils.CriterionUtils;

public class RiLieTypeGroupTwoOddNonadjacenceVertexesСriterion extends TwoOddNonadjacenceVertexesСriterion {

	public RiLieTypeGroupTwoOddNonadjacenceVertexesСriterion(RiLieTypeGroup group) {
		super(group);
	}
	
	@Override
	protected boolean check(Edge edge) {
		return (super.check(edge)) 
				? CriterionUtils.SzRiLieTypeGroupTwoOddNonadjacenceVertexesСriterion(edge, GroupType.Ri, this.ltGroup.getQ())
				: false;
	}
	
}