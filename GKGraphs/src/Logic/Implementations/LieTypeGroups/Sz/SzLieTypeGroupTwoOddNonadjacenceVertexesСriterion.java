package Logic.Implementations.LieTypeGroups.Sz;

import Logic.Kernel.Graph.Edge;
import Logic.Kernel.GraphConstructor.Concrete.Сriterion.TwoOddNonadjacenceVertexesСriterion;
import Logic.Kernel.Group.LieTypeGroup.GroupType;
import Logic.Kernel.Utils.CriterionUtils;

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