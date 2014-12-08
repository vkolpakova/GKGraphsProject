package Series.SzSeries.Criterion;

import Kernel.Graph.Edge;
import Kernel.GraphConstructor.Series.SeriesGraphConstructor;
import Kernel.GraphConstructor.Series.SeriesGraphConstructor.WithTwoNonadjanceVerticesSeriesСriterion;
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