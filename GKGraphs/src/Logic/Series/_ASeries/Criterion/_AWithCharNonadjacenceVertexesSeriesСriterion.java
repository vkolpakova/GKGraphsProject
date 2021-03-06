package Logic.Series._ASeries.Criterion;

import Logic.Kernel.Graph.Edge;
import Logic.Kernel.Graph.SymbolVertex;
import Logic.Kernel.GraphConstructor.Series.SeriesGraphConstructor;
import Logic.Kernel.GraphConstructor.Series.SeriesGraphConstructor.WithCharNonadjacenceVerticesSeriesСriterion;
import Logic.Kernel.Utils.ArithmeticUtils;
import Logic.Series._ASeries._ASeries;

public class _AWithCharNonadjacenceVertexesSeriesСriterion extends WithCharNonadjacenceVerticesSeriesСriterion {

	public _AWithCharNonadjacenceVertexesSeriesСriterion(SeriesGraphConstructor seriesGraphConstructor, _ASeries series) {
		seriesGraphConstructor.super(series);
	}
	
	@Override
	protected boolean check(Edge edge) {
		if (super.check(edge)) {
			SymbolVertex r = super.getVertexR((SymbolVertex)edge.getVertexA(), (SymbolVertex)edge.getVertexB());
			return ((condition1(r)) || (condition2(r)));
		} else {
			return false;
		}
	}
	
	protected boolean condition1(SymbolVertex r) {
		return ((!r.getVertex().equals(SymbolVertex.TWO)) && 
				(ArithmeticUtils.nu(this.series.getVertexM(r)) > (this.series.getN() - 1)));
	}
	
	protected boolean condition2(SymbolVertex r) {
		if (this.series.getN() == 2) {
			return ((r.getVertex().equals(SymbolVertex.THREE)) &&
					(_ASeries.CHAR_CRITERION_LIST.contains(((_ASeries)this.series).getVertexCondition(r))));
		} else {
			return false;
		}
	}
	
}