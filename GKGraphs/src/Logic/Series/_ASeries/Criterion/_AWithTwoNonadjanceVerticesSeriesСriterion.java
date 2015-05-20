package Logic.Series._ASeries.Criterion;

import Logic.Kernel.Graph.Edge;
import Logic.Kernel.Graph.SymbolVertex;
import Logic.Kernel.GraphConstructor.Series.SeriesGraphConstructor;
import Logic.Kernel.GraphConstructor.Series.SeriesGraphConstructor.WithTwoNonadjanceVerticesSeriesСriterion;
import Logic.Kernel.Utils.ArithmeticUtils;
import Logic.Series._ASeries._ASeries;

import java.util.List;

public class _AWithTwoNonadjanceVerticesSeriesСriterion extends WithTwoNonadjanceVerticesSeriesСriterion {

	public _AWithTwoNonadjanceVerticesSeriesСriterion(SeriesGraphConstructor seriesGraphConstructor, _ASeries series) {
		seriesGraphConstructor.super(series);
	}
	
	@Override
	protected boolean check(Edge edge) {
		SymbolVertex a = (SymbolVertex)edge.getVertexA(), b = (SymbolVertex)edge.getVertexB();
		if (isRExist(a, b)) {
			SymbolVertex r = returnR(a, b), s = (a.equals(r)) ? b : a;
			if (checkS(s)) {
				String vertexCondition = ((_ASeries)this.series).getVertexCondition(r);
				boolean cond1 = _ASeries.TWO_CRITERION_LIST_1.contains(vertexCondition) &&
						(ArithmeticUtils.nu(this.series.getVertexM(s)) == (this.series.getN() + 1));
				boolean cond2 = _ASeries.TWO_CRITERION_LIST_2.contains(vertexCondition) &&
						(ArithmeticUtils.nu(this.series.getVertexM(s)) == (this.series.getN()));
				return (cond1 || cond2);
				
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	protected boolean isRExist(SymbolVertex a, SymbolVertex b) {
		int mA = this.series.getVertexM(a), mB = this.series.getVertexM(b);
		return ((mA == 2) || (mB == 2));
	}
	
	protected boolean checkS(SymbolVertex s) {
		return ((!s.getVertex().equals(SymbolVertex.TWO)) && (!s.getVertex().equals(this.series.getP())));
	}
	
	protected SymbolVertex returnR(SymbolVertex a, SymbolVertex b) {
		return (this.series.getVertexM(a) == 2) ? a : b; 
	}
	
}