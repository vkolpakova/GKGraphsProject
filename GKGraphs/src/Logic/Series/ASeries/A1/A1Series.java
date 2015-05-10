package Logic.Series.ASeries.A1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.google.common.collect.Lists;

import Logic.Kernel.Graph.SymbolVertex;
import Logic.Kernel.Group.LieTypeGroup.GroupType;
import Logic.Kernel.Polynom.CompoundPolynom;
import Logic.Kernel.Polynom.IndecomposablePolynom;
import Logic.Kernel.Polynom.PolynomConstants;
import Logic.Series.ASeries.ASeries;

/**
 * Реализация серии групп лиева типа вида A_1(q).
 * TODO test
 * @author v.kolpakova
 *
 */
public class A1Series extends ASeries {
	
	public static final String P_EVEN_COMP_0 = SymbolVertex.LEFT_BRACE + SymbolVertex.TWO + SymbolVertex.RIGHT_BRACE;
	public static final String P_EVEN_COMP_1 = "pi(q - 1)";
	public static final String P_EVEN_COMP_2 = "pi(q + 1)";
	
	public static final String P_ODD_COMP_1 = "pi(q - epsilon1)";
	public static final String P_ODD_COMP_0 = SymbolVertex.LEFT_BRACE + SymbolVertex.P + SymbolVertex.RIGHT_BRACE;
	public static final String P_ODD_COMP_2 = "pi((q + epsilon1) / 2)";
	
	public static final String EPSILON_PLUS = "+";
	public static final String EPSILON_MINUS = "-";
	
	/**
	 * q = epsilon(mod 4), epsilon = {+, -}. </br>
	 * Использовать константы {@value #EPSILON_PLUS}, {@value #EPSILON_MINUS}
	 */
	protected String epsilon = EMPTY_STRING;
	
	public A1Series(String name, int n, String p, String m, String epsilon) {
		super(name, n, p, m);
		this.grType = GroupType.A;
		this.epsilon = epsilon;
		constructComponents(); // можно вызывать только после определения epsilon
		computeSeriesOrder();
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
			comp1 = new Component(0, new ArrayList<SymbolVertex>(), P_EVEN_COMP_0);
			comp2 = new Component(1, new ArrayList<SymbolVertex>(), P_EVEN_COMP_1);
			comp3 = new Component(2, new ArrayList<SymbolVertex>(), P_EVEN_COMP_2);
		} else if (this.epsilon.equals(EPSILON_PLUS)) {
			comp1 = new Component(1, new ArrayList<SymbolVertex>(), P_ODD_COMP_1);
			comp2 = new Component(0, new ArrayList<SymbolVertex>(), P_ODD_COMP_0);
			comp3 = new Component(2, new ArrayList<SymbolVertex>(), P_ODD_COMP_2);
		} else if (this.epsilon.equals(EPSILON_MINUS)) {
			comp1 = new Component(2, new ArrayList<SymbolVertex>(), P_ODD_COMP_1);
			comp2 = new Component(0, new ArrayList<SymbolVertex>(), P_ODD_COMP_0);
			comp3 = new Component(1, new ArrayList<SymbolVertex>(), P_ODD_COMP_2);
		}
		this.setComponents(Lists.newArrayList(comp1, comp2, comp3));
	}
	
	@Override
	protected void computeSeriesOrder() {
		IndecomposablePolynom poly1, poly2, poly3;
		if (this.p.equals(SymbolVertex.TWO)) {
			poly1 = new IndecomposablePolynom(SymbolVertex.TWO, Lists.newArrayList(SymbolVertex.TWO));
			poly2 = new IndecomposablePolynom(PolynomConstants.QM1, Lists.<String>newArrayList());
			poly3 = new IndecomposablePolynom(PolynomConstants.QP1, Lists.<String>newArrayList());
		} else {
			poly1 = new IndecomposablePolynom(PolynomConstants.QME1, Lists.<String>newArrayList());
			poly2 = new IndecomposablePolynom(PolynomConstants.QPE1, Lists.<String>newArrayList());
			poly3 = new IndecomposablePolynom(SymbolVertex.P, Lists.newArrayList(SymbolVertex.P));
		} 
		CompoundPolynom order = new CompoundPolynom(Lists.newArrayList(poly1, poly2, poly3));
		setSeriesOrder(order);
	}
	
	@Override
	public void fillSeriesOrderBasedComponents() {
		if (this.p.equals(SymbolVertex.TWO)) {
			this.seriesOrder.setDevisorsForMultiplier(PolynomConstants.QM1, this.getSimpleDivisorsOfConcreteComponent(1));
			this.seriesOrder.setDevisorsForMultiplier(PolynomConstants.QP1, this.getSimpleDivisorsOfConcreteComponent(2));
		} else if (this.epsilon.equals(EPSILON_PLUS)) {
			this.seriesOrder.setDevisorsForMultiplier(PolynomConstants.QME1, this.getSimpleDivisorsOfConcreteComponent(1));
			// необходимо добавить 2ку, которой нет в исходной компоненте
			List<String> sdList = Lists.newArrayList(SymbolVertex.TWO);
			sdList.addAll(this.getSimpleDivisorsOfConcreteComponent(2));
			this.seriesOrder.setDevisorsForMultiplier(PolynomConstants.QPE1, sdList);
		} else if (this.epsilon.equals(EPSILON_MINUS)) {
			// необходимо добавить 2ку, которой нет в исходной компоненте
			List<String> sdList = Lists.newArrayList(SymbolVertex.TWO);
			sdList.addAll(this.getSimpleDivisorsOfConcreteComponent(1));
			this.seriesOrder.setDevisorsForMultiplier(PolynomConstants.QM1, sdList);
			this.seriesOrder.setDevisorsForMultiplier(PolynomConstants.QP1, this.getSimpleDivisorsOfConcreteComponent(2));
		}
	}

	@Override
	protected Map<SymbolVertex, String> computeObviousRConditions(Map<SymbolVertex, String> oneComponentConditionsMap) {
		for (SymbolVertex vertex : oneComponentConditionsMap.keySet()) {
			if (!vertex.getVertex().equals(SymbolVertex.TWO) && oneComponentConditionsMap.get(vertex).isEmpty()) {
				// очевидно, для любой вершины справедливо условие "1 = 2_r = n_r < (q - 1)_r > 2"
				oneComponentConditionsMap.put(vertex, CONDITION_R_1);
			} else if (vertex.getVertex().equals(SymbolVertex.TWO)) {
				if (this.getVertexComponentName(vertex).equals(this.P_ODD_COMP_1)) {
					oneComponentConditionsMap.put(vertex, CONDITION_R_1);
				} else {
					oneComponentConditionsMap.put(vertex, CONDITION_R_3);
				}
			}
		}
		return oneComponentConditionsMap;
	}

}