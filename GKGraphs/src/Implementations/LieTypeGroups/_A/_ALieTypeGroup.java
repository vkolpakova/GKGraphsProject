package Implementations.LieTypeGroups._A;

import Kernel.Group.LieTypeGroup;
import Kernel.Utils.ArithmeticUtils;
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
		double multiplication = 1;
		for (int i=1; i<=n; i++) {
			multiplication *= ArithmeticUtils.primeDivMultiplication(Math.pow(q, i + 1) - Math.pow(-1, i + 1));
		}
		this.order = (long) (p * multiplication);
		MainLogger.info("*_ALieTypeGroup* Order = " + Long.toString(order));
	}
	
	@Override
	public int getInInndiagIndex() {
		return ArithmeticUtils.NOD(this.n + 1, this.q + 1);
	}
	
}