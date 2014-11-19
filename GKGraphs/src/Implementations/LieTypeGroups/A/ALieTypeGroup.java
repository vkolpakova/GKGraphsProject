package Implementations.LieTypeGroups.A;

import Kernel.Group.LieTypeGroup;

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
		int qPower = (int) (0.5 * this.n * (n+1));
		int multiplicator = (int) Math.pow(q, qPower);
		int multiplication = 1;
		for (int i=1; i<=n; i++) {
			multiplication *= Math.pow(q, i+1) - 1;
		}
		this.order = multiplicator * multiplication;
	}
	
}