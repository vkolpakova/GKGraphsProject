package Series.ASeries.A1;

import java.util.List;
import java.util.Map;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import Kernel.Graph.SymbolVertex;
import Kernel.Group.LieTypeGroup.GroupType;
import Series.ASeries.ASeries;

/**
 * Реализация серии групп лиева типа вида A_1(q).
 * TODO test
 * @author v.kolpakova
 *
 */
public class A1Series extends ASeries {
	
	public static final String P_EVEN_COMP_1 = SymbolVertex.LEFT_BRACE + SymbolVertex.TWO + SymbolVertex.RIGHT_BRACE;
	public static final String P_EVEN_COMP_2 = "pi(q - 1)";
	public static final String P_EVEN_COMP_3 = "pi(q + 1)";
	
	public static final String P_ODD_COMP_1 = "pi(q - epsilon1)";
	public static final String P_ODD_COMP_2 = SymbolVertex.LEFT_BRACE + SymbolVertex.P + SymbolVertex.RIGHT_BRACE;
	public static final String P_ODD_COMP_3 = "pi((q + epsilon1) / 2)";
	
	public static final String EPSILON_PLUS = "+";
	public static final String EPSILON_MINUS = "-";
	
	/**
	 * q = epsilon(mod 4), epsilon = {+, -}. </br>
	 * Использовать константы {@value #EPSILON_PLUS}, {@value #EPSILON_MINUS}
	 */
	protected String epsilon = "";
	
	public A1Series(String name, int n, String epsilon) {
		super(name, n);
		this.grType = GroupType.A;
		this.epsilon = epsilon;
		constructComponents(); // можно вызывать только после определения epsilon
	}
	
	public A1Series(String name, int n, String p, String m, String epsilon) {
		super(name, n, p, m);
		this.grType = GroupType.A;
		this.epsilon = epsilon;
		constructComponents(); // можно вызывать только после определения epsilon
	}
	
	public String getEpsilon() {
		return epsilon;
	}

	public void setEpsilon(String epsilon) {
		this.epsilon = epsilon;
	}

	@Override
	protected void constructComponents() {
		Component comp1 = null, comp2 = null, comp3 = null;
		if (this.p.equals(SymbolVertex.TWO)) {
			// TODO refactoring
			Map<Integer, List<SymbolVertex>> map = Maps.newHashMap();
			map.put(0,  Lists.newArrayList());
			comp1 = new Component(map, Component.PI_1, P_EVEN_COMP_1);
			map = Maps.newHashMap();
			map.put(1,  Lists.newArrayList());
			comp2 = new Component(map, Component.PI_2, P_EVEN_COMP_2);
			map = Maps.newHashMap();
			map.put(2,  Lists.newArrayList());
			comp3 = new Component(map, Component.PI_3, P_EVEN_COMP_3);
		} else if (this.epsilon.equals(EPSILON_PLUS)) {
			Map<Integer, List<SymbolVertex>> map = Maps.newHashMap();
			map.put(1,  Lists.newArrayList());
			comp1 = new Component(map, Component.PI_1, P_ODD_COMP_1);
			map = Maps.newHashMap();
			map.put(0,  Lists.newArrayList());
			comp2 = new Component(map, Component.PI_2, P_ODD_COMP_2);
			map = Maps.newHashMap();
			map.put(2,  Lists.newArrayList());
			comp3 = new Component(map, Component.PI_3, P_ODD_COMP_3);
		} else if (this.epsilon.equals(EPSILON_MINUS)) {
			Map<Integer, List<SymbolVertex>> map = Maps.newHashMap();
			map.put(2,  Lists.newArrayList());
			comp1 = new Component(map, Component.PI_1, P_ODD_COMP_1);
			map = Maps.newHashMap();
			map.put(0,  Lists.newArrayList());
			comp2 = new Component(map, Component.PI_2, P_ODD_COMP_2);
			map = Maps.newHashMap();
			map.put(1,  Lists.newArrayList());
			comp3 = new Component(map, Component.PI_3, P_ODD_COMP_3);
		}
		this.setComponents(Lists.newArrayList(comp1, comp2, comp3));
	}
	
}