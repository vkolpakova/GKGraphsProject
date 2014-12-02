package Series.ASeries.A2;

import java.util.List;
import java.util.Map;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import Kernel.Graph.SymbolVertex;
import Kernel.Group.LieTypeGroup.GroupType;
import Series.ASeries.ASeries;

public class A2Series extends ASeries {
	
	public static final String PI_1_COMP = "pi(q(q^2 - 1))";
	public static final String PI_1_1 = "pi(q - 1)";
	public static final String PI_1_2 = "pi(q + 1)";
	public static final String PI_2_COMP = "pi((q^q + q + 1) / (3, q - 1))";

	public A2Series(String name, int n, String p, String m) {
		super(name, n, p, m);
		this.grType = GroupType.A;
		constructComponents();
	}
	
	@Override
	protected void constructComponents() {
		Map<Integer, List<SymbolVertex>> map = Maps.newHashMap();
		map.put(0, Lists.newArrayList());
		map.put(1, Lists.newArrayList());
		map.put(2, Lists.newArrayList());
		Component comp1 = new Component(map, Component.PI_1, PI_1_COMP);
		map = Maps.newHashMap();
		map.put(3, Lists.newArrayList());
		Component comp2 = new Component(map, Component.PI_2, PI_2_COMP);
		this.setComponents(Lists.newArrayList(comp1, comp2));
	}
	
}