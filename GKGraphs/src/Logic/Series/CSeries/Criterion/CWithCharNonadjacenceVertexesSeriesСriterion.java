package Logic.Series.CSeries.Criterion;

import Logic.Kernel.Graph.Edge;
import Logic.Kernel.Graph.SymbolVertex;
import Logic.Kernel.GraphConstructor.Series.SeriesGraphConstructor;
import Logic.Kernel.GraphConstructor.Series.SeriesGraphConstructor.WithCharNonadjacenceVerticesSeriesСriterion;
import Logic.Kernel.Utils.ArithmeticUtils;
import Logic.Series.CSeries.C2.C2Series;

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