package Series.ASeries.A2;

import com.google.common.collect.Lists;

import Kernel.Group.Series;
import Kernel.Polynom.CompoundPolynom;
import Kernel.Polynom.IndecomposablePolynom;
import Kernel.Polynom.PolynomConstants;
import Series.ASeries.GraphAutASeriesGraphConstructor;

public class GraphAutA2SeriesGraphConstructor extends GraphAutASeriesGraphConstructor {

	public GraphAutA2SeriesGraphConstructor(Series group) {
		super(group);
	}

	@Override
	protected CompoundPolynom getBhalf_nOrder() { // q*(q^2 - 1)
		IndecomposablePolynom poly0 = new IndecomposablePolynom(PolynomConstants.Q, this.group.getSimpleDivisorsOfConcreteComponent(A2Series.COMP_0));
		IndecomposablePolynom poly1 = new IndecomposablePolynom(PolynomConstants.QM1, this.group.getSimpleDivisorsOfConcreteComponent(1));
		IndecomposablePolynom poly2 = new IndecomposablePolynom(PolynomConstants.QP1, this.group.getSimpleDivisorsOfConcreteComponent(2));
		return new CompoundPolynom(Lists.newArrayList(poly0, poly1, poly2));
	}

	@Override
	protected CompoundPolynom getChalf_np1Order() {
		return null;
	}

	@Override
	protected CompoundPolynom getBhalf_np1Order() {
		return null;
	}

	@Override
	protected CompoundPolynom getDhalf_np1Order() {
		return null;
	}

	@Override
	protected CompoundPolynom get2Dhalf_np1Order() {
		return null;
	}
	
}
