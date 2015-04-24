package Logic.Series.SzSeries.Criterion;

import Logic.Kernel.Graph.Edge;
import Logic.Kernel.Graph.SymbolVertex;
import Logic.Kernel.GraphConstructor.Series.SeriesGraphConstructor;
import Logic.Kernel.GraphConstructor.Series.SeriesGraphConstructor.TwoOddNonadjacenceVerticesSeriesСriterion;
import Logic.Series.SzSeries.Sz.SzSeries;

public class SzTwoOddNonadjacenceVerticesSeriesСriterion extends TwoOddNonadjacenceVerticesSeriesСriterion {

	public SzTwoOddNonadjacenceVerticesSeriesСriterion(SeriesGraphConstructor seriesGraphConstructor, SzSeries series) {
		seriesGraphConstructor.super(series);
	}
	
	@Override
	protected boolean check(Edge edge) {
		if (super.check(edge)) {
			SymbolVertex a = (SymbolVertex) edge.getVertexA(), b = (SymbolVertex) edge.getVertexB();
			String aCompName = this.series.getVertexComponentName(a), bCompName = this.series.getVertexComponentName(b);
			return (!aCompName.equals(bCompName));
		} else {
			return false;
		}
	}
	
}