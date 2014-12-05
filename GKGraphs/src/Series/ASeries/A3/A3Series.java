package Series.ASeries.A3;

import com.google.common.collect.Lists;

import Kernel.Graph.SymbolVertex;
import Kernel.Polynom.CompoundPolynom;
import Kernel.Polynom.IndecomposablePolynom;
import Kernel.Polynom.PolynomConstants;
import Series.ASeries.ASeries;

/**
 * Реализация серии групп лиева типа вида A_3(q).
 * TODO test
 * @author v.kolpakova
 *
 */
public class A3Series extends ASeries {
	
	public static final String COMP_0 = "{p}";
	public static final String COMP_1 = "pi(q - 1)"; // 1
	public static final String COMP_2 = "pi(q + 1)"; // 2
	public static final String COMP_3 = "pi(q^2 + q + 1)"; //3
	public static final String COMP_4 = "pi(q^2 + 1)"; //4

	public A3Series(String name, int n, String p, String m) {
		super(name, n, p, m);
		constructComponents();
		computeSeriesOrder();
	}
	
	@Override
	protected void constructComponents() {
		Component comp0 = new Component(0, Lists.newArrayList(), COMP_0);
		Component comp1 = new Component(1, Lists.newArrayList(), COMP_1);
		Component comp2 = new Component(2, Lists.newArrayList(), COMP_2);
		Component comp3 = new Component(3, Lists.newArrayList(), COMP_3);
		Component comp4 = new Component(4, Lists.newArrayList(), COMP_4);
		this.setComponents(Lists.newArrayList(comp0, comp1, comp2, comp3, comp4));
	}
	
	@Override
	protected void computeSeriesOrder() {
		IndecomposablePolynom poly1 = null, poly2 = null, poly3 = null, poly4 = null, poly5 = null;
		poly1 = new IndecomposablePolynom(SymbolVertex.P, Lists.newArrayList(SymbolVertex.P));
		poly2 = new IndecomposablePolynom(PolynomConstants.QM1, Lists.newArrayList());
		poly3 = new IndecomposablePolynom(PolynomConstants.QP1, Lists.newArrayList());
		poly4 = new IndecomposablePolynom(PolynomConstants.Q2PQP1, Lists.newArrayList());
		poly5 = new IndecomposablePolynom(PolynomConstants.Q2P1, Lists.newArrayList());
		CompoundPolynom order = new CompoundPolynom(Lists.newArrayList(poly1, poly2, poly3, poly4, poly5));
		setSeriesOrder(order);
	}
	
	@Override
	public void fillSeriesOrderBasedComponents() {
		this.seriesOrder.setDevisorsForMultiplier(PolynomConstants.QM1, this.getSimpleDivisorsOfConcreteComponent(1));
		this.seriesOrder.setDevisorsForMultiplier(PolynomConstants.QP1, this.getSimpleDivisorsOfConcreteComponent(2));
		this.seriesOrder.setDevisorsForMultiplier(PolynomConstants.Q2PQP1, this.getSimpleDivisorsOfConcreteComponent(3));
		this.seriesOrder.setDevisorsForMultiplier(PolynomConstants.Q2P1, this.getSimpleDivisorsOfConcreteComponent(4));
	}
	
}