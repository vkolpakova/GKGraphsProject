package Logic.Implementations.LieTypeGroups._A;

import Logic.Kernel.Graph.Edge;
import Logic.Kernel.GraphConstructor.Concrete.Сriterion.TwoOddNonadjacenceVertexesСriterion;
import Logic.Kernel.Utils.ArithmeticUtils;

public class _ALieTypeGroupTwoOddNonadjacenceVertexesСriterion extends TwoOddNonadjacenceVertexesСriterion {
	
	public _ALieTypeGroupTwoOddNonadjacenceVertexesСriterion(_ALieTypeGroup group) {
		super(group);
	}
	
	@Override
	protected boolean check(Edge edge) {
		if (super.check(edge)) {
			int r = (Integer)edge.getVertexA().getVertex();
			int s = (Integer)edge.getVertexB().getVertex();
			int k = ArithmeticUtils.e(r, this.ltGroup.getQ());
			int l = ArithmeticUtils.e(s, this.ltGroup.getQ());
			int nuK = ArithmeticUtils.nu(k);
			int nuL = ArithmeticUtils.nu(l);
			if ((2 <= nuK) && (nuK <= nuL) && ((nuK + nuL) > (this.ltGroup.getN() + 1))) {
				return (nuL % nuK != 0);
			} else if ((2 <= nuL) && (nuL <= nuK) && ((nuK + nuL) > (this.ltGroup.getN() + 1))) {
				return (nuK % nuL != 0);
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
}