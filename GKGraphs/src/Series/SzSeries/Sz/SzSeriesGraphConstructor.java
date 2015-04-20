package Series.SzSeries.Sz;

import Kernel.GraphConstructor.Series.SeriesGraphConstructor;
import Series.SzSeries.Criterion.SzTwoOddNonadjacenceVerticesSeriesСriterion;
import Series.SzSeries.Criterion.SzWithCharNonadjacenceVertexesSeriesСriterion;
import Series.SzSeries.Criterion.SzWithTwoNonadjanceVerticesSeriesСriterion;

public class SzSeriesGraphConstructor extends SeriesGraphConstructor {

	public SzSeriesGraphConstructor(SzSeries group) {
		super(group);
		this.cr1 = new SzTwoOddNonadjacenceVerticesSeriesСriterion(this, group);
		this.cr2 = new SzWithCharNonadjacenceVertexesSeriesСriterion(this, group);
		this.cr3 = new SzWithTwoNonadjanceVerticesSeriesСriterion(this, group);
	}
	
}