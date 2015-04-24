package Logic.Series.SzSeries.Criterion;

import Logic.Kernel.Graph.Edge;
import Logic.Kernel.GraphConstructor.Series.SeriesGraphConstructor;
import Logic.Kernel.GraphConstructor.Series.SeriesGraphConstructor.WithCharNonadjacenceVerticesSeriesСriterion;
import Logic.Series.SzSeries.Sz.SzSeries;

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