package Series.CSeries.Criterion;

import Kernel.Graph.Edge;
import Kernel.Graph.SymbolVertex;
import Kernel.GraphConstructor.Series.SeriesGraphConstructor;
import Kernel.GraphConstructor.Series.SeriesGraphConstructor.TwoOddNonadjacenceVerticesSeriesСriterion;
import Kernel.Utils.ArithmeticUtils;
import Kernel.Utils.CriterionUtils;
import Series.CSeries.C2.C2Series;

public class CTwoOddNonadjacenceVerticesSeriesСriterion extends TwoOddNonadjacenceVerticesSeriesСriterion {

	public CTwoOddNonadjacenceVerticesSeriesСriterion(SeriesGraphConstructor seriesGraphConstructor, C2Series series) {
		seriesGraphConstructor.super(series);
	}
	
	@Override
	protected boolean check(Edge edge) {
		if (super.check(edge)) {
			SymbolVertex a = (SymbolVertex) edge.getVertexA();
			SymbolVertex b = (SymbolVertex) edge.getVertexB();
			int aM = this.series.getVertexM(a);
			int bM = this.series.getVertexM(b);
			int etaA = ArithmeticUtils.eta(aM);
			int etaB = ArithmeticUtils.eta(bM);
			return (((etaA == etaB) && (aM != bM)) || CriterionUtils.thirdCondition(aM, bM, etaA, etaB, this.series.getN()));
		} else {
			return false;
		}
	}
	
}