package Series.ASeries.Criterion;

import Kernel.Graph.Edge;
import Kernel.Graph.SymbolVertex;
import Kernel.GraphConstructor.SeriesGraphConstructor;
import Kernel.GraphConstructor.SeriesGraphConstructor.TwoOddNonadjacenceVerticesSeriesСriterion;
import Series.ASeries.ASeries;

public class ATwoOddNonadjacenceVerticesSeriesСriterion extends TwoOddNonadjacenceVerticesSeriesСriterion {

	public ATwoOddNonadjacenceVerticesSeriesСriterion(SeriesGraphConstructor seriesGraphConstructor, ASeries series) {
		seriesGraphConstructor.super(series);
	}
	
	@Override
	protected boolean check(Edge edge) {
		if (super.check(edge)) {
			SymbolVertex a = (SymbolVertex) edge.getVertexA();
			SymbolVertex b = (SymbolVertex) edge.getVertexB();
			int aM = this.series.getVertexM(a);
			int bM = this.series.getVertexM(b);
			if ((condition(aM, bM)) && ((aM + bM) > (this.series.getN() + 1))) {
				return (aM >= bM) ? ((aM % bM) != 0) : ((bM % aM) != 0);
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	protected boolean condition(int aM, int bM) {
		return ((aM > 1) && (bM > 1));
	}
	
}