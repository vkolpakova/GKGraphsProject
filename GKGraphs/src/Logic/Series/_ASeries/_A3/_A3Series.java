package Logic.Series._ASeries._A3;

import com.google.common.collect.Lists;

import Logic.Kernel.Graph.SymbolVertex;
import Logic.Kernel.Group.LieTypeGroup.GroupType;
import Logic.Kernel.Polynom.CompoundPolynom;
import Logic.Kernel.Polynom.IndecomposablePolynom;
import Logic.Kernel.Polynom.PolynomConstants;
import Logic.Series._ASeries._ASeries;

/**
 * Реализация серии групп лиева типа вида _A_3(q).
 * TODO test
 * @author v.kolpakova
 */
public class _A3Series extends _ASeries {
	
	public static final String COMP_0 = "{p}";
	public static final String COMP_1 = "pi(q - 1)"; // 1
	public static final String COMP_2 = "pi(q + 1)"; // 2
	public static final String COMP_6 = "pi(q^2 - q + 1)"; //3
	public static final String COMP_4 = "pi(q^2 + 1)"; //4

	public _A3Series(String name, int n, String p, String m) {
		super(name, n, p, m);
		this.grType = GroupType._A;
		constructComponents();
		computeSeriesOrder();
	}
	
	@Override
	protected void constructComponents() {
		Component comp0 = new Component(0, Lists.<SymbolVertex>newArrayList(), COMP_0);
		Component comp1 = new Component(1, Lists.<SymbolVertex>newArrayList(), COMP_1);
		Component comp2 = new Component(2, Lists.<SymbolVertex>newArrayList(), COMP_2);
		Component comp3 = new Component(6, Lists.<SymbolVertex>newArrayList(), COMP_6);
		Component comp4 = new Component(4, Lists.<SymbolVertex>newArrayList(), COMP_4);
		this.setComponents(Lists.newArrayList(comp0, comp1, comp2, comp3, comp4));
	}
	
	@Override
	protected void computeSeriesOrder() {
		IndecomposablePolynom poly1 = null, poly2 = null, poly3 = null, poly4 = null, poly5 = null;
		poly1 = new IndecomposablePolynom(SymbolVertex.P, Lists.newArrayList(SymbolVertex.P));
		poly2 = new IndecomposablePolynom(PolynomConstants.QM1, Lists.<String>newArrayList());
		poly3 = new IndecomposablePolynom(PolynomConstants.QP1, Lists.<String>newArrayList());
		poly4 = new IndecomposablePolynom(PolynomConstants.Q2MQP1, Lists.<String>newArrayList());
		poly5 = new IndecomposablePolynom(PolynomConstants.Q2P1, Lists.<String>newArrayList());
		CompoundPolynom order = new CompoundPolynom(Lists.newArrayList(poly1, poly2, poly3, poly4, poly5));
		setSeriesOrder(order);
	}
	
	@Override
	public void fillSeriesOrderBasedComponents() {
		this.seriesOrder.setDevisorsForMultiplier(PolynomConstants.QM1, this.getSimpleDivisorsOfConcreteComponent(1));
		this.seriesOrder.setDevisorsForMultiplier(PolynomConstants.QP1, this.getSimpleDivisorsOfConcreteComponent(2));
		this.seriesOrder.setDevisorsForMultiplier(PolynomConstants.Q2MQP1, this.getSimpleDivisorsOfConcreteComponent(6));
		this.seriesOrder.setDevisorsForMultiplier(PolynomConstants.Q2P1, this.getSimpleDivisorsOfConcreteComponent(4));
	}
	
}