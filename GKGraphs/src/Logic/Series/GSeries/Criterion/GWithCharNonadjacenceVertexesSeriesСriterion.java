package Logic.Series.GSeries.Criterion;

import Logic.Kernel.Graph.Edge;
import Logic.Kernel.Graph.SymbolVertex;
import Logic.Kernel.GraphConstructor.Series.SeriesGraphConstructor;
import Logic.Kernel.GraphConstructor.Series.SeriesGraphConstructor.WithCharNonadjacenceVerticesSeriesСriterion;
import Logic.Series.GSeries.G2.G2Series;

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