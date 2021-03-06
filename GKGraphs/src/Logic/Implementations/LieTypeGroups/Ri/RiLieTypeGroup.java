package Logic.Implementations.LieTypeGroups.Ri;

import Logic.Kernel.Group.LieTypeGroup;
import Logic.Kernel.Utils.ArithmeticUtils;
import Logic.Kernel.Utils.MainLogger;

/**
 * Реализация конкретной группы типа Ri(q) = 2G2(q), q = 3^(2n+1).
 * 
 * @author v.kolpakova
 *
 */
public class RiLieTypeGroup extends LieTypeGroup {

	public RiLieTypeGroup(String name, int n, int p, int q) {
		super(name, n, p, q);
	}
	
	@Override
	protected void computeGroupType() {
		this.grType = GroupType.Ri;
	}
	
	@Override
	protected void computeGroupOrder() {
		double m1 = ArithmeticUtils.primeDivMultiplication(Math.pow(q, 3) + 1);
		double m2 = ArithmeticUtils.primeDivMultiplication(q - 1);
		this.order = (long) (p * m1 * m2);
		MainLogger.info("*RiLieTypeGroup* Order = " + Long.toString(order));
	}
	
	@Override
	public int getFieldAutGroupOrder() {
		return ArithmeticUtils.getPow(this.q, 3);
	}
	
}