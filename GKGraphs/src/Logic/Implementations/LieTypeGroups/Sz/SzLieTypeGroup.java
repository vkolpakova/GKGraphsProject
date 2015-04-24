package Logic.Implementations.LieTypeGroups.Sz;

import Logic.Kernel.Group.LieTypeGroup;
import Logic.Kernel.Utils.ArithmeticUtils;
import Logic.Kernel.Utils.MainLogger;

/**
 * Реализация конкретной группы типа Sz(q) = 2B2(q), q = 2^(2n+1).
 * 
 * @author v.kolpakova
 *
 */
public class SzLieTypeGroup extends LieTypeGroup {

	public SzLieTypeGroup(String name, int n, int p, int q) {
		super(name, n, p, q);
	}
	
	@Override
	protected void computeGroupType() {
		this.grType = GroupType.Sz;
	}
	
	 @Override
	protected void computeGroupOrder() {
		double m1 = ArithmeticUtils.primeDivMultiplication(Math.pow(q, 2) + 1);
		double m2 = ArithmeticUtils.primeDivMultiplication(q - 1);
		this.order = (long) (p * m1 * m2);
		MainLogger.info("*SzLieTypeGroup* Order = " + Long.toString(order));
	}
	 
	@Override
	public int getFieldAutGroupOrder() {
		return ArithmeticUtils.getPow(this.q, 2);
	}
	
}