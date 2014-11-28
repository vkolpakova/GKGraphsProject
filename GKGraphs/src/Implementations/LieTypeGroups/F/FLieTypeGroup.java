package Implementations.LieTypeGroups.F;

import Kernel.Group.LieTypeGroup;
import Kernel.Utils.ArithmeticUtils;
import Kernel.Utils.MainLogger;

/**
 * Реализация конкретной группы типа F_4(q).
 * 
 * @author v.kolpakova
 *
 */
public class FLieTypeGroup extends LieTypeGroup {

	public FLieTypeGroup(String name, int n, int p, int q) {
		super(name, n, p, q);
	}
	
	@Override
	protected void computeGroupType() {
		this.grType = GroupType.F;
	}
	
	@Override
	protected void computeGroupOrder() {
		double m1 = ArithmeticUtils.primeDivMultiplication(Math.pow(q, 12) - 1);
		double m2 = ArithmeticUtils.primeDivMultiplication(Math.pow(q, 8) - 1);
		double m3 = ArithmeticUtils.primeDivMultiplication(Math.pow(q, 6) - 1);
		double m4 = ArithmeticUtils.primeDivMultiplication(Math.pow(q, 2) - 1);
		this.order = (long) (p * m1 * m2 * m3 * m4);
		MainLogger.info("*FLieTypeGroup* Order = " + Long.toString(order));
	}
	
	@Override
	public int getFieldAutGroupOrder() {
		return ArithmeticUtils.getPow(this.q, this.p);
	}
	
}