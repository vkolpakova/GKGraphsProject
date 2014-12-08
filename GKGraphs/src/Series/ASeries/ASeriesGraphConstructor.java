package Series.ASeries;

import Kernel.GraphConstructor.Series.SeriesGraphConstructor;
import Series.ASeries.Criterion.ATwoOddNonadjacenceVerticesSeriesСriterion;
import Series.ASeries.Criterion.AWithCharNonadjacenceVertexesSeriesСriterion;
import Series.ASeries.Criterion.AWithTwoNonadjanceVerticesSeriesСriterion;

public class ASeriesGraphConstructor extends SeriesGraphConstructor {

	public ASeriesGraphConstructor(ASeries group) {
		super(group);
		this.cr1 = new ATwoOddNonadjacenceVerticesSeriesСriterion(this, group);
		this.cr2 = new AWithCharNonadjacenceVertexesSeriesСriterion(this, group);
		this.cr3 = new AWithTwoNonadjanceVerticesSeriesСriterion(this, group);
	}
	
}