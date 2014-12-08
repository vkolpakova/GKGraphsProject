package Series.CSeries.Criterion;

import Kernel.Graph.Edge;
import Kernel.Graph.SymbolVertex;
import Kernel.GraphConstructor.Series.SeriesGraphConstructor;
import Kernel.GraphConstructor.Series.SeriesGraphConstructor.WithTwoNonadjanceVerticesSeriesСriterion;
import Kernel.Utils.ArithmeticUtils;
import Series.CSeries.C2.C2Series;

public class CWithTwoNonadjanceVerticesSeriesСriterion extends WithTwoNonadjanceVerticesSeriesСriterion {

	public CWithTwoNonadjanceVerticesSeriesСriterion(SeriesGraphConstructor seriesGraphConstructor, C2Series series) {
		seriesGraphConstructor.super(series);
	}
	
	@Override
	protected boolean check(Edge edge) {
		SymbolVertex r = getVertexR(edge);
		if (r != null) {
			int k = this.series.getVertexM(r);
			return (condition1(k) || condition2(k));
		} else {
			return false;
		}
	}
	
	protected SymbolVertex getVertexR(Edge edge) {
		SymbolVertex r = null;
		SymbolVertex a = (SymbolVertex) edge.getVertexA(), b = (SymbolVertex) edge.getVertexB();
		if (checkVertices(a, b) || checkVertices(b, a)) {
			r = (a.getVertex().equals(SymbolVertex.TWO)) ? b :  a; 
		}
		return r;
	}
	
	protected boolean checkVertices(SymbolVertex a, SymbolVertex b) {
		return ((a.getVertex().equals(SymbolVertex.TWO)) && (!b.getVertex().equals(this.series.getP())));
	}
	
	protected boolean condition1(int k) {
		int e2q = (this.series.getP().equals(SymbolVertex.TWO)) ? 0 : 1;
		return (((this.series.getN() % 2) != 0) && (k == ((3 - ArithmeticUtils.e(2, e2q)) * this.series.getN())));
	}
	
	protected boolean condition2(int k) {
		return (((this.series.getN() % 2) == 0) && (k == (2 * this.series.getN())));
	}
	
}