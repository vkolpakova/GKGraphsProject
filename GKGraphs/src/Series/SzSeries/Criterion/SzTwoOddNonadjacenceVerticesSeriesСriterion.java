package Series.SzSeries.Criterion;

import Kernel.Graph.Edge;
import Kernel.Graph.SymbolVertex;
import Kernel.GraphConstructor.SeriesGraphConstructor;
import Kernel.GraphConstructor.SeriesGraphConstructor.TwoOddNonadjacenceVerticesSeriesСriterion;
import Series.SzSeries.Sz.SzSeries;

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