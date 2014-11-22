package Implementations.LieTypeGroups.G;

import Kernel.Graph.Edge;
import Kernel.GraphConstructor.Сriterion.WithTwoNonadjanceVertexesСriterion;
import Kernel.Utils.ArithmeticUtils;

public class GLieTypeGroupWithTwoNonadjanceVertexesСriterion extends WithTwoNonadjanceVertexesСriterion {

	public GLieTypeGroupWithTwoNonadjanceVertexesСriterion(GLieTypeGroup group) {
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
		if ((a != 2) && (b != 2)) {
			return 0;
		} else {
			return (a == 2) ? b : a;
		}
	}
	
}