package Implementations.LieTypeGroups.G;

import Kernel.Graph.Edge;
import Kernel.GraphConstructor.Сriterion.WithCharNonadjacenceVertexesСriterion;
import Kernel.Utils.ArithmeticUtils;

public class GLieTypeGroupWithCharNonadjacenceVertexesСriterion extends WithCharNonadjacenceVertexesСriterion {

	public GLieTypeGroupWithCharNonadjacenceVertexesСriterion(GLieTypeGroup group) {
		super(group);
	}
	
	@Override
	protected boolean check(Edge edge) {
		int a = (Integer)edge.getVertexA().getVertex();
		int b = (Integer)edge.getVertexB().getVertex();
		int r = returnR(a, b);
		int k = ArithmeticUtils.e(r, this.ltGroup.getQ());
		return ((k == 3) || (k == 6));
	}
	
	// TODO вынести метод в суперкласс или утилиты
	private int returnR(int a, int b) {
		if ((a != this.ltGroup.getP()) && (b != this.ltGroup.getP())) {
			return 0;
		} else {
			return (a == this.ltGroup.getP()) ? b : a;
		}
	}
	
}