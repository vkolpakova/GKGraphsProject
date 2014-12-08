package Series._ASeries;

import Kernel.GraphConstructor.Series.SeriesGraphConstructor;
import Series._ASeries.Criterion._ATwoOddNonadjacenceVerticesSeriesСriterion;
import Series._ASeries.Criterion._AWithCharNonadjacenceVertexesSeriesСriterion;
import Series._ASeries.Criterion._AWithTwoNonadjanceVerticesSeriesСriterion;

public class _ASeriesGraphConstructor extends SeriesGraphConstructor {

	public _ASeriesGraphConstructor(_ASeries group) {
		super(group);
		this.cr1 = new _ATwoOddNonadjacenceVerticesSeriesСriterion(this, group);
		this.cr2 = new _AWithCharNonadjacenceVertexesSeriesСriterion(this, group);
		this.cr3 = new _AWithTwoNonadjanceVerticesSeriesСriterion(this, group);
	}
	
}