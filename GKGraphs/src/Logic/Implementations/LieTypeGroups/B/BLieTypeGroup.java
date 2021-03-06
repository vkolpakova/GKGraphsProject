package Logic.Implementations.LieTypeGroups.B;

import Logic.Kernel.Group.LieTypeGroup;
import Logic.Kernel.Utils.ArithmeticUtils;
import Logic.Kernel.Utils.MainLogger;

/**
 * Реализация конкретной группы типа B_n(q) или C_n(q)
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
		double mult = 1;
		for (int i=1; i<=n; i++) {
			mult *= ArithmeticUtils.primeDivMultiplication(Math.pow(q, 2 * i) - 1);
		}
		order = (long) (p * mult);
		MainLogger.info("*BLieTypeGroup* Order = " + Long.toString(order));
	}
	
	@Override
	public int getInInndiagIndex() {
		return ArithmeticUtils.NOD(2, this.q - 1);
	}
	
	@Override
	public int getFieldAutGroupOrder() {
		return ArithmeticUtils.getPow(this.q, this.p);
	}
	
	@Override
	public int getGraphAutGroupOrder() {
		return ((this.n == 2) && (this.p == 2)) ? 2 : super.getGraphAutGroupOrder();
	}
	
}