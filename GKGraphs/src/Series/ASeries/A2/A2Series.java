package Series.ASeries.A2;

import com.google.common.collect.Lists;

import Kernel.Group.LieTypeGroup.GroupType;
import Series.ASeries.ASeries;

public class A2Series extends ASeries {
	
	public static final String COMP_0 = "{p}";
	public static final String COMP_1 = "pi(q - 1)";
	public static final String COMP_2 = "pi(q + 1)";
	public static final String COMP_3 = "pi((q^2 + q + 1) / (3, q - 1))";

	public A2Series(String name, int n, String p, String m) {
		super(name, n, p, m);
		this.grType = GroupType.A;
		constructComponents();
	}
	
	@Override
	protected void constructComponents() {
		Component comp1 = new Component(0, Lists.newArrayList(), COMP_0);
		Component comp2 = new Component(1, Lists.newArrayList(), COMP_1);
		Component comp3 = new Component(2, Lists.newArrayList(), COMP_2);
		Component comp4 = new Component(3, Lists.newArrayList(), COMP_3);
		this.setComponents(Lists.newArrayList(comp1, comp2, comp3, comp4));
	}
	
}