package Implementations.LieTypeGroups.A;

import Kernel.Group.LieTypeGroup;
import Kernel.Utils.ArithmeticUtils;
import Kernel.Utils.MainLogger;

/**
 * Реализация конкретной группы типа A_n(q).
 * 
 * @author v.kolpakova
 *
 */
public class ALieTypeGroup extends LieTypeGroup {

	public ALieTypeGroup(String name, int n, int p, int q) {
		super(name, n, p, q);
	}
	
	@Override
	protected void computeGroupType() {
		this.setGrType(GroupType.A);
	}
	
	@Override
	protected void computeGroupOrder() {
		double multiplication = 1;
		for (int i=1; i<=n; i++) {
			multiplication *= ArithmeticUtils.primeDivMultiplication(Math.pow(q, i + 1) - 1);
		}
		this.order = (long) (p * multiplication);
		MainLogger.info("*ALieTypeGroup* Order = " + Long.toString(order));
	}
	
}