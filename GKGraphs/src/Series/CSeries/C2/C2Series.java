package Series.CSeries.C2;

import java.util.List;

import com.google.common.collect.Lists;

import Kernel.Graph.SymbolVertex;
import Kernel.Group.Series;
import Kernel.Group.LieTypeGroup.GroupType;
import Kernel.Polynom.CompoundPolynom;
import Kernel.Polynom.IndecomposablePolynom;
import Kernel.Polynom.PolynomConstants;
import Kernel.Utils.SeriesGroupParser;

/**
 * Реализация серии групп лиева типа вида C_2(q).
 * TODO test
 * @author v.kolpakova
 *
 */
public class C2Series extends Series {
	
	public static final String COMP_0 = "{p}";
	public static final String COMP_1 = "pi(q - 1)";
	public static final String COMP_2 = "pi(q + 1)";
	public static final String COMP_4 = "pi(q^2 + 1)";

	public C2Series(String name, int n, String p, String m) {
		super(name, n, p, m);
		this.grType = GroupType.C;
		constructComponents();
		computeSeriesOrder();
	}
	
	@Override
	protected void constructComponents() {
		Component comp0 = null, comp1 = null, comp2 = null, comp3 = null; 
		comp0 = new Component(0, Lists.newArrayList(new SymbolVertex(SymbolVertex.P)), COMP_0);
		comp1 = new Component(1, Lists.newArrayList(), COMP_1);
		comp2 = new Component(2, Lists.newArrayList(), COMP_2);
		comp3 = new Component(4, Lists.newArrayList(), COMP_4);
		this.setComponents(Lists.newArrayList(comp0, comp1, comp2, comp3));
	}
	
	@Override
	protected void computeSeriesOrder() {
		IndecomposablePolynom poly1 = null, poly2 = null, poly3 = null, poly4 = null;
		if (this.p.equals(SymbolVertex.TWO)) {
			poly1 = new IndecomposablePolynom(SymbolVertex.TWO, Lists.newArrayList(SymbolVertex.TWO));
		} else {
			poly1 = new IndecomposablePolynom(SymbolVertex.P, Lists.newArrayList(SymbolVertex.P));
		}
		poly2 = new IndecomposablePolynom(PolynomConstants.QM1, Lists.newArrayList());
		poly3 = new IndecomposablePolynom(PolynomConstants.QP1, Lists.newArrayList());
		poly4 = new IndecomposablePolynom(PolynomConstants.Q2P1, Lists.newArrayList());
		CompoundPolynom order = new CompoundPolynom(Lists.newArrayList(poly1, poly2, poly3, poly4));
		setSeriesOrder(order);
	}
	
	@Override
	public void fillSeriesOrderBasedComponents() {
		this.seriesOrder.setDevisorsForMultiplier(PolynomConstants.QM1, this.getSimpleDivisorsOfConcreteComponent(1));
		this.seriesOrder.setDevisorsForMultiplier(PolynomConstants.QP1, this.getSimpleDivisorsOfConcreteComponent(2));
		this.seriesOrder.setDevisorsForMultiplier(PolynomConstants.Q2P1, this.getSimpleDivisorsOfConcreteComponent(4));
	}
	
	@Override
	public int getOutdiagOrder() {
		Component comp = this.getComponentByM(1); // q - 1
		if (comp.checkContainsVertex(SymbolVertex.TWO)) {
			return 2;
		} else {
			return 1;
		}
	}
	
	@Override
	public int getFieldAutOrder() {
		int multIndex = m.indexOf(SeriesGroupParser.MULTIPLICATION);
		int res = 1;
		if (multIndex > 0) {
			List<Integer> multsNum = Lists.newArrayList();
			String[] mults  = m.split(SeriesGroupParser.MULTIPLICATION);
			for (String mult : mults) {
				try {
					int num = Integer.parseInt(mult);
					multsNum.add(num);
				} catch (NumberFormatException e) {}
			}
			for (int n : multsNum) {
				res *= n;
			}
		}
		return res;
	}
	
	@Override
	public int getGraphAutOrder() {
		return 1;
	}
	
}