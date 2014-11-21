package Implementations.LieTypeGroups._A;

import Kernel.Group.LieTypeGroup;
import Kernel.Utils.MainLogger;

/**
 * Реализация конкретной группы типа 2A_n(q).
 * 
 * @author v.kolpakova
 *
 */
public class _ALieTypeGroup extends LieTypeGroup {
	
	public _ALieTypeGroup(String name, int n, int p, int q) {
		super(name, n, p, q);
	}
	
	@Override
	protected void computeGroupType() {
		this.setGrType(GroupType._A);
	}
	
	@Override
	protected void computeGroupOrder() {
		// int qPower = (int) (0.5 * this.n * (n+1));
		// int multiplicator = (int) Math.pow(q, qPower);
		int multiplication = 1;
		for (int i=1; i<=n; i++) {
			multiplication *= Math.pow(q, i + 1) - Math.pow(-1, i + 1);
		}
		this.order = p * multiplication;
		MainLogger.info("*_ALieTypeGroup* Order = " + Integer.toString(order));
	}
	
}