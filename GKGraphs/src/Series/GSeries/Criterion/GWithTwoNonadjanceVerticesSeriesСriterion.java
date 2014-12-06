package Series.GSeries.Criterion;

import Kernel.Graph.Edge;
import Kernel.Graph.SymbolVertex;
import Kernel.GraphConstructor.SeriesGraphConstructor;
import Kernel.GraphConstructor.SeriesGraphConstructor.WithTwoNonadjanceVerticesSeriesСriterion;
import Series.GSeries.G2.G2Series;

public class GWithTwoNonadjanceVerticesSeriesСriterion extends WithTwoNonadjanceVerticesSeriesСriterion {

	public GWithTwoNonadjanceVerticesSeriesСriterion(SeriesGraphConstructor seriesGraphConstructor, G2Series series) {
		seriesGraphConstructor.super(series);
	}
	
	@Override
	protected boolean check(Edge edge) {
		SymbolVertex a = (SymbolVertex) edge.getVertexA(), b = (SymbolVertex) edge.getVertexB();
		if ((!a.getVertex().equals(SymbolVertex.TWO)) && (!b.getVertex().equals(SymbolVertex.TWO))) {
			return false;
		} else {
			SymbolVertex r = (a.getVertex().equals(SymbolVertex.TWO)) ? b : a;
			int erq = this.series.getVertexM(r);
			return ((erq == 3) || (erq == 6));
		}
	}
	
}