package Logic.Series._ASeries.Criterion;

import Logic.Kernel.Graph.Edge;
import Logic.Kernel.Graph.SymbolVertex;
import Logic.Kernel.GraphConstructor.Series.SeriesGraphConstructor;
import Logic.Kernel.GraphConstructor.Series.SeriesGraphConstructor.TwoOddNonadjacenceVerticesSeriesСriterion;
import Logic.Kernel.Utils.ArithmeticUtils;
import Logic.Series._ASeries._ASeries;

public class _ATwoOddNonadjacenceVerticesSeriesСriterion extends TwoOddNonadjacenceVerticesSeriesСriterion {

	public _ATwoOddNonadjacenceVerticesSeriesСriterion(SeriesGraphConstructor seriesGraphConstructor, _ASeries series) {
		seriesGraphConstructor.super(series);
	}
	
	@Override
	protected boolean check(Edge edge) {
		if (super.check(edge)) {
			SymbolVertex a = (SymbolVertex) edge.getVertexA(), b = (SymbolVertex) edge.getVertexB();
			int nuA = ArithmeticUtils.nu(this.series.getVertexM(a)), nuB = ArithmeticUtils.nu(this.series.getVertexM(b));
			if (((nuA > 1) && (nuB > 1)) && ((nuA + nuB) > (this.series.getN() + 1))) {
				return (nuA > nuB) ? ((nuA % nuB) != 0) : ((nuB % nuA) != 0);
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
}