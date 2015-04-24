package Logic.Series.CSeries.Criterion;

import Logic.Kernel.Graph.Edge;
import Logic.Kernel.Graph.SymbolVertex;
import Logic.Kernel.GraphConstructor.Series.SeriesGraphConstructor;
import Logic.Kernel.GraphConstructor.Series.SeriesGraphConstructor.TwoOddNonadjacenceVerticesSeriesСriterion;
import Logic.Kernel.Utils.ArithmeticUtils;
import Logic.Kernel.Utils.CriterionUtils;
import Logic.Series.CSeries.C2.C2Series;

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