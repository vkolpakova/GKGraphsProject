package Implementations.LieTypeGroups.D;

import Kernel.Group.LieTypeGroup;
import Kernel.Utils.ArithmeticUtils;
import Kernel.Utils.MainLogger;

/**
 * Реализация конкретной группы типа D_n(q).
 * 
 * @author v.kolpakova
 *
 */
public class DLieTypeGroup extends LieTypeGroup {

	public DLieTypeGroup(String name, int n, int p, int q) {
		super(name, n, p, q);
	}
	
	@Override
	protected void computeGroupType() {
		this.grType = GroupType.D;
	}
	
	@Override
	protected void computeGroupOrder() {
		double multiplicator = this.p * ArithmeticUtils.primeDivMultiplication(Math.pow(this.q, this.n) - 1);
		double multiplication = 1;
		for (int i=1; i<this.n; i++) {
			multiplication *= ArithmeticUtils.primeDivMultiplication(Math.pow(this.q, 2 * i) - 1);
		}
		this.order = (long) (multiplicator * multiplication);
		MainLogger.info("*DLieTypeGroup* Order = " + Long.toString(order));
	}
	
}