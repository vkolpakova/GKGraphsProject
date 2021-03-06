package Logic.Implementations.LieTypeGroups.B;

import Logic.Kernel.Graph.Edge;
import Logic.Kernel.GraphConstructor.Concrete.Сriterion.TwoOddNonadjacenceVertexesСriterion;
import Logic.Kernel.Utils.ArithmeticUtils;
import Logic.Kernel.Utils.CriterionUtils;

public class BLieTypeGroupTwoOddNonadjacenceVertexesСriterion extends TwoOddNonadjacenceVertexesСriterion {
	
	public BLieTypeGroupTwoOddNonadjacenceVertexesСriterion(BLieTypeGroup group) {
		super(group);
	}
	
	@Override
	protected boolean check(Edge edge) {
		if (super.check(edge)) {
			int q = this.ltGroup.getQ();
			int n = this.ltGroup.getN();
			int etaK, etaL;
			// TODO подумать над рефакторингом, чтобы избавиться от приведения типов
			int k = ArithmeticUtils.e(((Integer)edge.getVertexA().getVertex()), q);
			int l = ArithmeticUtils.e(((Integer)edge.getVertexB().getVertex()), q);
			etaK = ArithmeticUtils.eta(k);
			etaL = ArithmeticUtils.eta(l);
			return CriterionUtils.thirdCondition(k, l, etaK, etaL, n);
		} else {
			return false;
		}
	}
	
}