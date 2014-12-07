package Series.SzSeries.Sz;

import com.google.common.collect.Lists;

import Kernel.Graph.SymbolVertex;
import Kernel.Group.LieTypeGroup.GroupType;
import Kernel.Group.Series;
import Kernel.Polynom.CompoundPolynom;
import Kernel.Polynom.IndecomposablePolynom;
import Kernel.Polynom.PolynomConstants;

/**
 * Реализация серии групп лиева типа вида Sz(q).
 * TODO test
 * @author v.kolpakova
 *
 */
public class SzSeries extends Series {
	
	public static final String COMP_0 	= "{2}";
	public static final String COMP_1 	= "pi(q - 1)";
	public static final String COMP_4_1 = "pi(q - sqrt(2q) + 1)";
	public static final String COMP_4_2 = "pi(q + sqrt(2q) + 1)";

	public SzSeries(String name, int n, String p, String m) {
		super(name, n, p, m);
		this.grType = GroupType.Sz;
		constructComponents();
		computeSeriesOrder();
	}
	
	@Override
	protected void constructComponents() {
		Component comp0 = null, comp1 = null,comp4_1 = null, comp4_2 = null;
		comp0 = new Component(0, Lists.newArrayList(new SymbolVertex(SymbolVertex.TWO)), COMP_0);
		comp1 = new Component(1, Lists.newArrayList(), COMP_1);
		comp4_1 = new Component(4, Lists.newArrayList(), COMP_4_1);
		comp4_2 = new Component(4, Lists.newArrayList(), COMP_4_2);
		this.setComponents(Lists.newArrayList(comp0, comp1, comp4_1, comp4_2));
	}
	
	@Override
	protected void computeSeriesOrder() {
		IndecomposablePolynom poly1 = null, poly2 = null, poly3 = null, poly4 = null;
		poly1 = new IndecomposablePolynom(SymbolVertex.P, Lists.newArrayList(SymbolVertex.P));
		poly2 = new IndecomposablePolynom(PolynomConstants.QM1, Lists.newArrayList());
		poly3 = new IndecomposablePolynom(PolynomConstants.QMSQRT2QP1, Lists.newArrayList());
		poly4 = new IndecomposablePolynom(PolynomConstants.QPSQRT2QP1, Lists.newArrayList());
		CompoundPolynom order = new CompoundPolynom(Lists.newArrayList(poly1, poly2, poly3, poly4));
		setSeriesOrder(order);
	}
	
	@Override
	public void fillSeriesOrderBasedComponents() {
		this.seriesOrder.setDevisorsForMultiplier(PolynomConstants.QM1, this.getSimpleDivisorsOfConcreteComponent(1));
		this.seriesOrder.setDevisorsForMultiplier(PolynomConstants.QMSQRT2QP1, this.getSimpleDivisorsOfConcreteComponent(SzSeries.COMP_4_1));
		this.seriesOrder.setDevisorsForMultiplier(PolynomConstants.QPSQRT2QP1, this.getSimpleDivisorsOfConcreteComponent(SzSeries.COMP_4_2));
	}
	
}