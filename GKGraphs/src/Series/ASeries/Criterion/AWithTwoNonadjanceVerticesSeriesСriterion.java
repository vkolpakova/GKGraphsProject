package Series.ASeries.Criterion;

import java.util.List;

import com.google.common.base.Predicate;

import Kernel.Graph.Edge;
import Kernel.Graph.SymbolVertex;
import Kernel.GraphConstructor.SeriesGraphConstructor;
import Kernel.GraphConstructor.SeriesGraphConstructor.WithTwoNonadjanceVerticesSeriesСriterion;
import Series.ASeries.ASeries;

public class AWithTwoNonadjanceVerticesSeriesСriterion extends WithTwoNonadjanceVerticesSeriesСriterion {

	public AWithTwoNonadjanceVerticesSeriesСriterion(SeriesGraphConstructor seriesGraphConstructor, ASeries series) {
		seriesGraphConstructor.super(series);
	}
	
	@Override
	protected boolean check(Edge edge) {
		SymbolVertex a = (SymbolVertex) edge.getVertexA();
		SymbolVertex b = (SymbolVertex) edge.getVertexB();
		if (checkEdge(a, b)) {
			SymbolVertex r = getR(a, b);
			SymbolVertex s = getS(a, b);
			int sM = this.series.getVertexM(s);
			int n = this.series.getN() + 1;
			boolean cond1 = ((sM == n) && (ASeries.TWO_CRITERION_LIST_1.contains(((ASeries)this.series).getVertexCondition(r))));
			boolean cond2 = ((sM == (n - 1)) && (ASeries.TWO_CRITERION_LIST_2.contains(((ASeries)this.series).getVertexCondition(r))));
			return (cond1 || cond2);
		} else {
			return false;
		}
	}
	
	protected boolean checkEdge(SymbolVertex a, SymbolVertex b) {
		List<SymbolVertex> oneCompVertecies = this.series.getComponentByM(1).getVertices();
		if (!((oneCompVertecies.contains(a)) || (oneCompVertecies.contains(b)))) {
			return false;
		}
		String p = this.series.getP();
		Predicate<SymbolVertex> notTwoOrPPredicate = new Predicate<SymbolVertex>() {

			@Override
			public boolean apply(SymbolVertex paramT) {
				return ((!(paramT.getVertex().equals(p))) && (!(paramT.getVertex().equals(SymbolVertex.TWO))));
			}
			
		};
		if (!((notTwoOrPPredicate.apply(a)) || (notTwoOrPPredicate.apply(b)))) {
			return false;
		}
		return true;
	}
	
	protected SymbolVertex getR(SymbolVertex a, SymbolVertex b) {
		return (this.series.getVertexM(a) == 1) ? a : b;
	}
	
	protected SymbolVertex getS(SymbolVertex a, SymbolVertex b) {
		return (this.series.getVertexM(a) == 1) ? b : a;
	}
	
}