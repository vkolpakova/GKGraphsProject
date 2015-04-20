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
	
	@Override
	public int getInInndiagIndex() {
		return (this.n == 1) ? ArithmeticUtils.NOD(2, this.q - 1) : ArithmeticUtils.NOD(this.n + 1, this.q - 1);
	}
	
	@Override
	public int getFieldAutGroupOrder() {
		return ArithmeticUtils.getPow(this.q, this.p);
	}
	
	@Override
	public int getGraphAutGroupOrder() {
		return (this.n == 1) ? super.getGraphAutGroupOrder() : 2;
	}
	
}