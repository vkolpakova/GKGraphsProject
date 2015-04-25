package Logic.Implementations.LieTypeGroups.Ri;

import Logic.Kernel.Graph.Edge;
import Logic.Kernel.GraphConstructor.Concrete.Сriterion.TwoOddNonadjacenceVertexesСriterion;
import Logic.Kernel.Group.LieTypeGroup.GroupType;
import Logic.Kernel.Utils.CriterionUtils;

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