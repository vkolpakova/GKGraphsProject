package Series.CSeries.Criterion;

import Kernel.Graph.Edge;
import Kernel.Graph.SymbolVertex;
import Kernel.GraphConstructor.SeriesGraphConstructor;
import Kernel.GraphConstructor.SeriesGraphConstructor.WithCharNonadjacenceVerticesSeriesСriterion;
import Kernel.Utils.ArithmeticUtils;
import Series.CSeries.C2.C2Series;

public class CWithCharNonadjacenceVertexesSeriesСriterion extends WithCharNonadjacenceVerticesSeriesСriterion {

	public CWithCharNonadjacenceVertexesSeriesСriterion(SeriesGraphConstructor seriesGraphConstructor, C2Series series) {
		seriesGraphConstructor.super(series);
	}
	
	@Override
	protected boolean check(Edge edge) {
		if (super.check(edge)) {
			SymbolVertex r = super.getVertexR((SymbolVertex)edge.getVertexA(), (SymbolVertex)edge.getVertexB());
			int etaR = ArithmeticUtils.eta(this.series.getVertexM(r));
			return (etaR > (this.series.getN() - 1));
		} else {
			return false;
		}
	}
	
}