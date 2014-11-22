package Implementations.LieTypeGroups.D;

import Kernel.Group.LieTypeGroup;

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
		int multiplicator = (int) (this.p * (Math.pow(this.q, this.n) - 1));
		int multiplication = 1;
		for (int i=1; i<this.n; i++) {
			multiplication *= Math.pow(this.q, 2 * i) - 1;
		}
		this.order = multiplicator * multiplication;
	}
	
}