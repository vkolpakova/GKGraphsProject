package Implementations.LieTypeGroups.B;

import Kernel.Group.LieTypeGroup;

/**
 * Реализация конкретной группы типа B_n(q).
 * 
 * @author v.kolpakova
 *
 */
public class BLieTypeGroup extends LieTypeGroup {

	public BLieTypeGroup(String name, int n, int p, int q) {
		super(name, n, p, q);
	}
	
	@Override
	protected void computeGroupType() {
		this.grType = GroupType.B;
	}
	
	@Override
	protected void computeGroupOrder() {
		int qPow = (int) Math.pow(q, n*n);
		int mult = 1;
		for (int i=1; i<=n; i++) {
			mult *= Math.pow(q, 2*i) - 1;
		}
		order = qPow * mult;
	}
	
}