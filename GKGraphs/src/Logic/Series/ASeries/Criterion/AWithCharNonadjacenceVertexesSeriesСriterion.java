package Logic.Series.ASeries.Criterion;

import Logic.Kernel.Graph.Edge;
import Logic.Kernel.Graph.SymbolVertex;
import Logic.Kernel.GraphConstructor.Series.SeriesGraphConstructor;
import Logic.Kernel.GraphConstructor.Series.SeriesGraphConstructor.WithCharNonadjacenceVerticesSeriesСriterion;

import Logic.Series.ASeries.ASeries;

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
					((this.series.getN() == 2) && (r.getVertex().equals(SymbolVertex.THREE)) &&
							(ASeries.CHAR_CRITERION_LIST.contains(((ASeries)this.series).getVerticesCondMap().get(new SymbolVertex(SymbolVertex.THREE)))));
		} // TODO проверить, что поиск по ключу будет производиться корректно (т.к. используется новый экземпляр SymbolVertex)
		return false;
	}
	
}