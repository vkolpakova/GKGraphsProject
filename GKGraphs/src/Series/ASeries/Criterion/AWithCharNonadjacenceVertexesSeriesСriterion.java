package Series.ASeries.Criterion;

import Kernel.Graph.Edge;
import Kernel.Graph.SymbolVertex;
import Kernel.GraphConstructor.SeriesGraphConstructor;
import Kernel.GraphConstructor.SeriesGraphConstructor.WithCharNonadjacenceVerticesSeriesСriterion;

import Series.ASeries.ASeries;

public class AWithCharNonadjacenceVertexesSeriesСriterion extends WithCharNonadjacenceVerticesSeriesСriterion {

	public AWithCharNonadjacenceVertexesSeriesСriterion(SeriesGraphConstructor seriesGraphConstructor, ASeries series) {
		seriesGraphConstructor.super(series);
	}
	
	@Override
	protected boolean check(Edge edge) {
		if (super.check(edge)) {
			SymbolVertex r = super.getVertexR((SymbolVertex)edge.getVertexA(), (SymbolVertex)edge.getVertexB());
			return (series.getVertexM(r) > (this.series.getN() - 1)) ||
					((this.series.getN() == 1) && (r.getVertex().equals(SymbolVertex.TWO))) ||
					((this.series.getN() == 3) && (r.getVertex().equals(SymbolVertex.THREE)) && 
							(ASeries.CHAR_CRITERION_LIST.contains(((ASeries)this.series).getVerticesCondMap().get(new SymbolVertex(SymbolVertex.THREE)))));
		} // TODO проверить, что поиск по ключу будет производиться корректно (т.к. используется новый экземпляр SymbolVertex)
		return false;
	}
	
}