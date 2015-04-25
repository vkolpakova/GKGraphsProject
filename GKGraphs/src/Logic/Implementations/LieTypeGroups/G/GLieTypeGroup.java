package Logic.Implementations.LieTypeGroups.G;

import Logic.Kernel.Group.LieTypeGroup;
import Logic.Kernel.Utils.ArithmeticUtils;
import Logic.Kernel.Utils.MainLogger;

/**
 * Реализация конкретной группы типа G_2(q).
 * 
 * @author v.kolpakova
 *
 */
public class GLieTypeGroup extends LieTypeGroup {

	public GLieTypeGroup(String name, int n, int p, int q) {
		super(name, n, p, q);
	}
	
	@Override
	protected void computeGroupType() {
		this.grType = GroupType.G;
	}
	
	@Override
	protected void computeGroupOrder() {
		double m1 = ArithmeticUtils.primeDivMultiplication(Math.pow(q, 6) - 1);
		double m2 = ArithmeticUtils.primeDivMultiplication(Math.pow(q, 2) - 1);
		this.order = (long) (this.p * m1 * m2);
		MainLogger.info("*GLieTypeGroup* Order = " + Long.toString(order));
	}
	
	@Override
	public int getFieldAutGroupOrder() {
		return ArithmeticUtils.getPow(this.q, this.p);
	}
	
	@Override
	public int getGraphAutGroupOrder() {
		return (this.p == 3) ? 2 : super.getGraphAutGroupOrder();
	}
	
}