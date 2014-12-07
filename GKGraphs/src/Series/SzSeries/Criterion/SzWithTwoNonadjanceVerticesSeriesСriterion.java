package Series.SzSeries.Criterion;

import Kernel.Graph.Edge;
import Kernel.GraphConstructor.SeriesGraphConstructor;
import Kernel.GraphConstructor.SeriesGraphConstructor.WithTwoNonadjanceVerticesSeriesСriterion;
import Series.SzSeries.Sz.SzSeries;

public class SzWithTwoNonadjanceVerticesSeriesСriterion extends WithTwoNonadjanceVerticesSeriesСriterion {

	public SzWithTwoNonadjanceVerticesSeriesСriterion(SeriesGraphConstructor seriesGraphConstructor, SzSeries series) {
		seriesGraphConstructor.super(series);
	}
	
	@Override
	protected boolean check(Edge edge) {
		// все ребра с 2 будут удалены ранее, т.к. p = 2.
		return false;
	}
	
}