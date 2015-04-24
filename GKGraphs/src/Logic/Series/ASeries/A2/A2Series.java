package Logic.Series.ASeries.A2;

import java.util.List;
import java.util.Map;

import com.google.common.collect.Lists;

import Logic.Kernel.Graph.SymbolVertex;
import Logic.Kernel.Group.LieTypeGroup.GroupType;
import Logic.Kernel.Polynom.CompoundPolynom;
import Logic.Kernel.Polynom.IndecomposablePolynom;
import Logic.Kernel.Polynom.PolynomConstants;
import Logic.Kernel.Utils.MainLogger;
import Logic.Series.ASeries.ASeries;

/**
 * Реализация серии групп лиева типа вида A_2(q).
 * TODO test, override computeObviousRConditions
 * @author v.kolpakova
 *
 */
public class A2Series extends ASeries {
	
	public static final String COMP_0 = "{p}";
	public static final String COMP_1 = "pi(q - 1)";
	public static final String COMP_2 = "pi(q + 1)";
	public static final String COMP_3 = "pi((q^2 + q + 1) / (3, q - 1))";

	public A2Series(String name, int n, String p, String m) {
		super(name, n, p, m);
		this.grType = GroupType.A;
		constructComponents();
		computeSeriesOrder();
	}
	
	@Override
	protected void constructComponents() {
		Component comp1 = new Component(0, Lists.<SymbolVertex>newArrayList(), COMP_0);
		Component comp2 = new Component(1, Lists.<SymbolVertex>newArrayList(), COMP_1);
		Component comp3 = new Component(2, Lists.<SymbolVertex>newArrayList(), COMP_2);
		Component comp4 = new Component(3, Lists.<SymbolVertex>newArrayList(), COMP_3);
		this.setComponents(Lists.newArrayList(comp1, comp2, comp3, comp4));
	}
	
	@Override
	protected void computeSeriesOrder() {
		IndecomposablePolynom poly1 = null, poly2 = null, poly3 = null, poly4 = null;
		poly1 = new IndecomposablePolynom(SymbolVertex.P, Lists.newArrayList(SymbolVertex.P));
		poly2 = new IndecomposablePolynom(PolynomConstants.QM1, Lists.<String>newArrayList());
		poly3 = new IndecomposablePolynom(PolynomConstants.QP1, Lists.<String>newArrayList());
		poly4 = new IndecomposablePolynom(PolynomConstants.Q2PQP1, Lists.<String>newArrayList());
		CompoundPolynom order = new CompoundPolynom(Lists.newArrayList(poly1, poly2, poly3, poly4));
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
	}
	
	@Override
	public void constructVerticesCondMap(Map<SymbolVertex, String> oneComponentMap) {
		//  часть условий, которые и так очевидны, имеет смысла заполнять по умолчанию
		if (oneComponentMap.isEmpty()) {
			MainLogger.info("Add defolt conditions");
			Component oneComp = this.getComponentByM(1);
			for (SymbolVertex ver : oneComp.getVertices()) {
				if (!ver.getVertex().equals(SymbolVertex.THREE)) {
					// выполнение условия очевидно
					this.verticesCondMap.put(ver, ASeries.CONDITION_R_1);
				}
			}
		} else {
			super.constructVerticesCondMap(oneComponentMap);
		}
	}
	
}