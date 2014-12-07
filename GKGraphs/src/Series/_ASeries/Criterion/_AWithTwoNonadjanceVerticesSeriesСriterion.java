package Series._ASeries.Criterion;

import Kernel.Graph.Edge;
import Kernel.GraphConstructor.SeriesGraphConstructor;
import Kernel.GraphConstructor.SeriesGraphConstructor.WithTwoNonadjanceVerticesSeriesСriterion;
import Series._ASeries._ASeries;

public class _AWithTwoNonadjanceVerticesSeriesСriterion extends WithTwoNonadjanceVerticesSeriesСriterion {

	public _AWithTwoNonadjanceVerticesSeriesСriterion(SeriesGraphConstructor seriesGraphConstructor, _ASeries series) {
		seriesGraphConstructor.super(series);
	}
	
	@Override
	protected boolean check(Edge edge) {
		return super.check(edge);
	}
	
}