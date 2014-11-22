package Implementations.LieTypeGroups._D;

import Kernel.Group.LieTypeGroup;
import Kernel.Utils.MainLogger;

/**
 * Реализация конкретной группы типа 2D_n(q).
 * 
 * @author v.kolpakova
 *
 */
public class _DLieTypeGroup extends LieTypeGroup {
	
	public _DLieTypeGroup(String name, int n, int p, int q) {
		super(name, n, p, q);
	}
	
	@Override
	protected void computeGroupType() {
		this.grType = GroupType._D;
	}
	
	@Override
	protected void computeGroupOrder() {
		// n >= 4
		int multiplier = (int) (this.p * (Math.pow(this.q, this.n) + 1));
		int multiplication = 1;
		for (int i=1; i<this.n; i++) {
			multiplication *= (Math.pow(this.q, 2 * i) - 1);
		}
		this.order = multiplication * multiplier;
		MainLogger.info("*_DLieTypeGroup* Order = " + Integer.toString(order));
	}
	
}