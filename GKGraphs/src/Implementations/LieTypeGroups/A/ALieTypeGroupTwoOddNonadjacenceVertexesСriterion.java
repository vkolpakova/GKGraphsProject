package Implementations.LieTypeGroups.A;

import Kernel.Graph.Edge;
import Kernel.GraphConstructor.Сriterion.TwoOddNonadjacenceVertexesСriterion;
import Kernel.Utils.ArithmeticUtils;

public class ALieTypeGroupTwoOddNonadjacenceVertexesСriterion extends TwoOddNonadjacenceVertexesСriterion {

	public ALieTypeGroupTwoOddNonadjacenceVertexesСriterion(ALieTypeGroup group) {
		super(group);
	}
	
	@Override
	protected boolean check(Edge edge) {
		int q = ((ALieTypeGroup)this.group).getQ();
		// TODO подумать над рефакторингом, чтобы избавиться от приведения типов
		int k = ArithmeticUtils.e(((Integer)edge.getVertexA().getVertex()), q);
		int l = ArithmeticUtils.e(((Integer)edge.getVertexB().getVertex()), q);
		if ((k%2 != 0) && (l%2 != 0)) {
			if (k <= l) {
				return (k+l > ((ALieTypeGroup)this.group).getN() + 1) && (k % l != 0);
			} else {
				return (k+l > ((ALieTypeGroup)this.group).getN() + 1) && (l % k != 0);
			}
		} else {
			return false;
		}
	}
	
}