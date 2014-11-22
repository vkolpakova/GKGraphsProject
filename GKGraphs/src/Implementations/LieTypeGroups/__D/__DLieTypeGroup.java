package Implementations.LieTypeGroups.__D;

import Kernel.Group.LieTypeGroup;
import Kernel.Utils.ArithmeticUtils;
import Kernel.Utils.MainLogger;

/**
 * Реализация конкретной группы типа 3D_4(q).
 * 
 * @author v.kolpakova
 *
 */
public class __DLieTypeGroup extends LieTypeGroup {

	public __DLieTypeGroup(String name, int n, int p, int q) {
		super(name, n, p, q);
	}
	
	@Override
	protected void computeGroupType() {
		this.grType = GroupType.__D;
	}
	
	@Override
	protected void computeGroupOrder() {
		int m1 = (int) (Math.pow(q, 8) + Math.pow(q, 4) + 1);
		m1 = ArithmeticUtils.primeDivMultiplication(m1);
		int m2 = (int) (Math.pow(q, 6) - 1);
		m2 = ArithmeticUtils.primeDivMultiplication(m2);
		int m3 = (int) (Math.pow(q, 2) - 1);
		m3 = ArithmeticUtils.primeDivMultiplication(m3);
		this.order = p * m1 * m2 * m3;
		MainLogger.info("*__DLieTypeGroup* Order = " + Integer.toString(order));
	}
	
}