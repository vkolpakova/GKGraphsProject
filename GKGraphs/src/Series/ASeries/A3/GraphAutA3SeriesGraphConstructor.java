package Series.ASeries.A3;

import com.google.common.collect.Lists;

import Kernel.Group.Series;
import Kernel.Polynom.CompoundPolynom;
import Kernel.Polynom.IndecomposablePolynom;
import Kernel.Polynom.PolynomConstants;
import Series.ASeries.GraphAutASeriesGraphConstructor;

public class GraphAutA3SeriesGraphConstructor extends GraphAutASeriesGraphConstructor {

	public GraphAutA3SeriesGraphConstructor(Series group) {
		super(group);
	}

	@Override
	protected CompoundPolynom getBhalf_nOrder() {
		return null;
	}

	@Override
	protected CompoundPolynom getChalf_np1Order() { // q*(q^2 - 1)*(q^4 - 1)
		IndecomposablePolynom poly0 = new IndecomposablePolynom(PolynomConstants.Q, this.group.getSimpleDivisorsOfConcreteComponent(A3Series.COMP_0));
		IndecomposablePolynom poly1 = new IndecomposablePolynom(PolynomConstants.QM1, this.group.getSimpleDivisorsOfConcreteComponent(1));
		IndecomposablePolynom poly2 = new IndecomposablePolynom(PolynomConstants.QP1, this.group.getSimpleDivisorsOfConcreteComponent(2));
		IndecomposablePolynom poly3 = new IndecomposablePolynom(PolynomConstants.Q2P1, this.group.getSimpleDivisorsOfConcreteComponent(4));
		return new CompoundPolynom(Lists.newArrayList(poly0, poly1, poly2, poly3));
	}

	@Override
	protected CompoundPolynom getBhalf_np1Order() { // q*(q^2 - 1)*(q^4 - 1)
		IndecomposablePolynom poly0 = new IndecomposablePolynom(PolynomConstants.Q, this.group.getSimpleDivisorsOfConcreteComponent(A3Series.COMP_0));
		IndecomposablePolynom poly1 = new IndecomposablePolynom(PolynomConstants.QM1, this.group.getSimpleDivisorsOfConcreteComponent(1));
		IndecomposablePolynom poly2 = new IndecomposablePolynom(PolynomConstants.QP1, this.group.getSimpleDivisorsOfConcreteComponent(2));
		IndecomposablePolynom poly3 = new IndecomposablePolynom(PolynomConstants.Q2P1, this.group.getSimpleDivisorsOfConcreteComponent(4));
		return new CompoundPolynom(Lists.newArrayList(poly0, poly1, poly2, poly3));
	}

	@Override
	protected CompoundPolynom getDhalf_np1Order() { // q*(q^4 - 1)
		IndecomposablePolynom poly0 = new IndecomposablePolynom(PolynomConstants.Q, this.group.getSimpleDivisorsOfConcreteComponent(A3Series.COMP_0));
		IndecomposablePolynom poly1 = new IndecomposablePolynom(PolynomConstants.QM1, this.group.getSimpleDivisorsOfConcreteComponent(1));
		IndecomposablePolynom poly2 = new IndecomposablePolynom(PolynomConstants.QP1, this.group.getSimpleDivisorsOfConcreteComponent(2));
		IndecomposablePolynom poly3 = new IndecomposablePolynom(PolynomConstants.Q2P1, this.group.getSimpleDivisorsOfConcreteComponent(4));
		return new CompoundPolynom(Lists.newArrayList(poly0, poly1, poly2, poly3));
	}

	@Override
	protected CompoundPolynom get2Dhalf_np1Order() { // q*(q^4 - 1)
		IndecomposablePolynom poly0 = new IndecomposablePolynom(PolynomConstants.Q, this.group.getSimpleDivisorsOfConcreteComponent(A3Series.COMP_0));
		IndecomposablePolynom poly1 = new IndecomposablePolynom(PolynomConstants.QM1, this.group.getSimpleDivisorsOfConcreteComponent(1));
		IndecomposablePolynom poly2 = new IndecomposablePolynom(PolynomConstants.QP1, this.group.getSimpleDivisorsOfConcreteComponent(2));
		IndecomposablePolynom poly3 = new IndecomposablePolynom(PolynomConstants.Q2P1, this.group.getSimpleDivisorsOfConcreteComponent(4));
		return new CompoundPolynom(Lists.newArrayList(poly0, poly1, poly2, poly3));
	}
	
}