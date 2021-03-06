package Logic.Series.GSeries.G2;

import java.util.List;

import com.google.common.collect.Lists;

import Logic.Kernel.Graph.SymbolVertex;
import Logic.Kernel.Group.Series;
import Logic.Kernel.Group.LieTypeGroup.GroupType;
import Logic.Kernel.Polynom.CompoundPolynom;
import Logic.Kernel.Polynom.IndecomposablePolynom;
import Logic.Kernel.Polynom.PolynomConstants;
import Logic.Kernel.Utils.SeriesGroupParser;

/**
 * Реализация серии групп лиева типа вида G_2(q).
 * TODO test
 * @author v.kolpakova
 *
 */
public class G2Series extends Series {
	
	public static final String COMP_0 = "{p}";
	public static final String COMP_1 = "pi(q - 1)";
	public static final String COMP_2 = "pi(q + 1)";
	public static final String COMP_3 = "pi((q^2 + q + 1) / (3, q - 1))";
	public static final String COMP_6 = "pi((q^2 - q + 1) / (3, q + 1))";

	public G2Series(String name, int n, String p, String m) {
		super(name, n, p, m);
		this.grType = GroupType.G;
		constructComponents();
		computeSeriesOrder();
	}
	
	@Override
	protected void constructComponents() {
		Component comp0 = null, comp1 = null, comp2 = null, comp3 = null, comp4 = null; 
		comp0 = new Component(0, Lists.newArrayList(new SymbolVertex(SymbolVertex.P)), COMP_0);
		comp1 = new Component(1, Lists.<SymbolVertex>newArrayList(), COMP_1);
		comp2 = new Component(2, Lists.<SymbolVertex>newArrayList(), COMP_2);
		comp3 = new Component(3, Lists.<SymbolVertex>newArrayList(), COMP_3);
		comp4 = new Component(6, Lists.<SymbolVertex>newArrayList(), COMP_6);
		this.setComponents(Lists.newArrayList(comp0, comp1, comp2, comp3, comp4));
	}
	
	@Override
	protected void computeSeriesOrder() {
		IndecomposablePolynom poly1 = null, poly2 = null, poly3 = null, poly4 = null, poly5 = null;
		if (this.p.equals(SymbolVertex.TWO)) {
			poly1 = new IndecomposablePolynom(SymbolVertex.TWO, Lists.newArrayList(SymbolVertex.TWO));
		} else {
			poly1 = new IndecomposablePolynom(SymbolVertex.P, Lists.newArrayList(SymbolVertex.P));
		}
		poly2 = new IndecomposablePolynom(PolynomConstants.QM1, Lists.<String>newArrayList());
		poly3 = new IndecomposablePolynom(PolynomConstants.QP1, Lists.<String>newArrayList());
		poly4 = new IndecomposablePolynom(PolynomConstants.Q2MQP1, Lists.<String>newArrayList());
		poly5 = new IndecomposablePolynom(PolynomConstants.Q2PQP1, Lists.<String>newArrayList());
		CompoundPolynom order = new CompoundPolynom(Lists.newArrayList(poly1, poly2, poly3, poly4, poly5));
		setSeriesOrder(order);
	}
	
	@Override
	public void fillSeriesOrderBasedComponents() {
		this.seriesOrder.setDevisorsForMultiplier(PolynomConstants.QM1, this.getSimpleDivisorsOfConcreteComponent(1));
		this.seriesOrder.setDevisorsForMultiplier(PolynomConstants.QP1, this.getSimpleDivisorsOfConcreteComponent(2));
		if (this.getComponentByM(1).getAllVerticesStringForm().contains(SymbolVertex.THREE)) {
			// необходимо добавить 3ку, которой нет в исходной компоненте
			List<String> sdList = Lists.newArrayList(SymbolVertex.THREE);
			sdList.addAll(this.getSimpleDivisorsOfConcreteComponent(3));
			this.seriesOrder.setDevisorsForMultiplier(PolynomConstants.Q2PQP1, sdList);
		} else {
			this.seriesOrder.setDevisorsForMultiplier(PolynomConstants.Q2PQP1, this.getSimpleDivisorsOfConcreteComponent(3));
		}
		if (this.getComponentByM(2).getAllVerticesStringForm().contains(SymbolVertex.THREE)) {
			// необходимо добавить 3ку, которой нет в исходной компоненте
			List<String> sdList = Lists.newArrayList(SymbolVertex.THREE);
			sdList.addAll(this.getSimpleDivisorsOfConcreteComponent(6));
			this.seriesOrder.setDevisorsForMultiplier(PolynomConstants.Q2MQP1, sdList);
		} else {
			this.seriesOrder.setDevisorsForMultiplier(PolynomConstants.Q2MQP1, this.getSimpleDivisorsOfConcreteComponent(6));
		}
	}
	
	@Override
	public int getOutdiagOrder() {
		return 1;
	}
	
	@Override
	public int getIntegerPartFieldAutOrder() {
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
		return (this.getP().equals(SymbolVertex.THREE) ? 2 : 1);
	}
	
}