package Series.ASeries.A2;

import com.google.common.collect.Lists;

import Kernel.Group.LieTypeGroup.GroupType;
import Series.ASeries.ASeries;

public class A2Series extends ASeries {
	
	public static final String PI_1_COMP = "pi(q(q^2 - 1))";
	public static final String PI_2_COMP = "pi((q^q + q + 1) / (3, q - 1))";

	public A2Series(String name, int n, String p, String m) {
		super(name, n, p, m);
		this.grType = GroupType.A;
		constructComponents();
	}
	
	@Override
	protected void constructComponents() {
		// TODO дополнительно обработать тот факт, что в comp1 еще входит вершина p
		Component comp1 = new Component(2, Lists.newArrayList(), Component.PI_1, PI_1_COMP);
		Component comp2 = new Component(3, Lists.newArrayList(), Component.PI_2, PI_2_COMP);
		this.setComponents(Lists.newArrayList(comp1, comp2));
	}
	
}