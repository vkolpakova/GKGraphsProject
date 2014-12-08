package Series.GSeries.Criterion;

import Kernel.Graph.Edge;
import Kernel.Graph.SymbolVertex;
import Kernel.GraphConstructor.Series.SeriesGraphConstructor;
import Kernel.GraphConstructor.Series.SeriesGraphConstructor.WithCharNonadjacenceVerticesSeriesСriterion;
import Series.GSeries.G2.G2Series;

public class GWithCharNonadjacenceVertexesSeriesСriterion extends WithCharNonadjacenceVerticesSeriesСriterion {

	public GWithCharNonadjacenceVertexesSeriesСriterion(SeriesGraphConstructor seriesGraphConstructor, G2Series series) {
		seriesGraphConstructor.super(series);
	}
	
	@Override
	protected boolean check(Edge edge) {
		if (super.check(edge)) {
			SymbolVertex r = super.getVertexR((SymbolVertex)edge.getVertexA(), (SymbolVertex)edge.getVertexB());
			int erq = this.series.getVertexM(r);
			return ((erq == 3) || (erq == 6));
		} else {
			return false;
		}
	}
	
}