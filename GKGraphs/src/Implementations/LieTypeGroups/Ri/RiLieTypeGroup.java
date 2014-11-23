package Implementations.LieTypeGroups.Ri;

import Kernel.Group.LieTypeGroup;
import Kernel.Utils.ArithmeticUtils;
import Kernel.Utils.MainLogger;

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
		int m1 = ArithmeticUtils.primeDivMultiplication((int) (Math.pow(q, 3) + 1));
		int m2 = ArithmeticUtils.primeDivMultiplication(q - 1);
		this.order = p * m1 * m2;
		MainLogger.info("*RiLieTypeGroup* Order = " + Integer.toString(order));
	}
	
}