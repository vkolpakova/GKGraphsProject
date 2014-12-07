package Series.SzSeries.Criterion;

import Kernel.Graph.Edge;
import Kernel.GraphConstructor.SeriesGraphConstructor;
import Kernel.GraphConstructor.SeriesGraphConstructor.WithCharNonadjacenceVerticesSeriesСriterion;
import Series.SzSeries.Sz.SzSeries;

public class SzWithCharNonadjacenceVertexesSeriesСriterion extends WithCharNonadjacenceVerticesSeriesСriterion {

	public SzWithCharNonadjacenceVertexesSeriesСriterion(SeriesGraphConstructor seriesGraphConstructor, SzSeries series) {
		seriesGraphConstructor.super(series);
	}
	
	@Override
	protected boolean check(Edge edge) {
		if (super.check(edge)) {
			// {2} --- компонента из одной вершины (всегда)
			return true;
		} else {
			return false;
		}
	}
	
}