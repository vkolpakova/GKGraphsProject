package Logic.Series._ASeries;

import Logic.Kernel.GraphConstructor.Series.SeriesGraphConstructor;
import Logic.Series._ASeries.Criterion._ATwoOddNonadjacenceVerticesSeriesСriterion;
import Logic.Series._ASeries.Criterion._AWithCharNonadjacenceVertexesSeriesСriterion;
import Logic.Series._ASeries.Criterion._AWithTwoNonadjanceVerticesSeriesСriterion;

public class _ASeriesGraphConstructor extends SeriesGraphConstructor {

	public _ASeriesGraphConstructor(_ASeries group) {
		super(group);
		this.cr1 = new _ATwoOddNonadjacenceVerticesSeriesСriterion(this, group);
		this.cr2 = new _AWithCharNonadjacenceVertexesSeriesСriterion(this, group);
		this.cr3 = new _AWithTwoNonadjanceVerticesSeriesСriterion(this, group);
	}
	
}