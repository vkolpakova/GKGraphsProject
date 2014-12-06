package Series.GSeries.Criterion;

import Kernel.Graph.Edge;
import Kernel.Graph.SymbolVertex;
import Kernel.GraphConstructor.SeriesGraphConstructor;
import Kernel.GraphConstructor.SeriesGraphConstructor.TwoOddNonadjacenceVerticesSeriesСriterion;
import Series.GSeries.G2.G2Series;

public class GTwoOddNonadjacenceVerticesSeriesСriterion extends TwoOddNonadjacenceVerticesSeriesСriterion {

	public GTwoOddNonadjacenceVerticesSeriesСriterion(SeriesGraphConstructor seriesGraphConstructor, G2Series series) {
		seriesGraphConstructor.super(series);
	}
	
	@Override
	protected boolean check(Edge edge) {
		if (super.check(edge)) {
			SymbolVertex a = (SymbolVertex) edge.getVertexA(), b = (SymbolVertex) edge.getVertexB();
			int eA = this.series.getVertexM(a), eB = this.series.getVertexM(b);
			SymbolVertex r = (eA <= eB) ? a : b;
			SymbolVertex s = (r.equals(a)) ? b : a;
			return ((condition1(r, s)) || (condition2(r, s)));
		} else {
			return false;
		}
	}
	
	protected boolean condition1(SymbolVertex r, SymbolVertex s) {
		int esq = this.series.getVertexM(s);
		return (!r.getVertex().equals(SymbolVertex.THREE) && ((esq == 3) || (esq == 6)));
	}
	
	protected boolean condition2(SymbolVertex r, SymbolVertex s) { // k = erq
		int k = this.series.getVertexM(r);
		int l = this.series.getVertexM(s);
		return ((r.getVertex().equals(SymbolVertex.THREE)) && (l == (9 - 3 * k)));
	}
	
}