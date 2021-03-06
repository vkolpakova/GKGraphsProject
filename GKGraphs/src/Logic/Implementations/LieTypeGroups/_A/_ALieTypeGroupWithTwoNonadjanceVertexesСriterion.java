package Logic.Implementations.LieTypeGroups._A;

import Logic.Kernel.Graph.Edge;
import Logic.Kernel.GraphConstructor.Concrete.Сriterion.WithTwoNonadjanceVertexesСriterion;
import Logic.Kernel.Utils.ArithmeticUtils;

public class _ALieTypeGroupWithTwoNonadjanceVertexesСriterion extends WithTwoNonadjanceVertexesСriterion {

	public _ALieTypeGroupWithTwoNonadjanceVertexesСriterion(_ALieTypeGroup group) {
		super(group);
	}
	
	@Override
	protected boolean check(Edge edge) {
		int a = (Integer)edge.getVertexA().getVertex();
		int b = (Integer)edge.getVertexB().getVertex();
		int q = this.ltGroup.getQ();
		int n = this.ltGroup.getN();
		int r, s;
		r = returnR(a, b, q);
		if (r == 0) {
			return false;
		} else if (r == a) {
			s = b;
		} else {
			s = a;
		}
		int nuK = ArithmeticUtils.nu(ArithmeticUtils.e(s, q));
		return checkFirstCondition(nuK, n, r, q) || checkSecondCondition(nuK, n, r, q);
	}
	
	private int returnR(int a, int b, int q) {
		if ((((q + 1) % a) == 0) && (b != this.ltGroup.getP()) && (b != 2)) {
			return a;
		} else if (((q + 1) % b == 0) && (a != this.ltGroup.getP())  && (a != 2)) {
			return b;
		} else {
			return 0;
		}
	}
	
	private boolean checkFirstCondition(int nuK, int n, int r, int q) {
		if (nuK == (n + 1)) {
			int nr = ArithmeticUtils.nPart((n + 1), r);
			int qmodifr = ArithmeticUtils.nPart((q + 1), r);
			return (nr < qmodifr) || ((nr == qmodifr) && (2 < qmodifr));
		} else {
			return false;
		}
		
	}
	
	private boolean checkSecondCondition(int nuK, int n, int r, int q) {
		return (nuK == n) ? (ArithmeticUtils.nPart((q + 1), r) <= ArithmeticUtils.nPart((n + 1), r)) : false;
	}
		
}