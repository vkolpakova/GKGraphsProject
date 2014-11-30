package Series.ASeries;

import Kernel.GraphConstructor.SeriesGraphConstructor;
import Series.ASeries.Criterion.ATwoOddNonadjacenceVerticesSeriesСriterion;
import Series.ASeries.Criterion.AWithCharNonadjacenceVertexesSeriesСriterion;
import Series.ASeries.Criterion.AWithTwoNonadjanceVerticesSeriesСriterion;

public class ASeriesGraphConstructor extends SeriesGraphConstructor {

	public ASeriesGraphConstructor(ASeries group) {
		super(group); // FIXME возможна проблема в конструкторе при передаче null
		this.cr1 = new ATwoOddNonadjacenceVerticesSeriesСriterion(null, group);
		this.cr2 = new AWithCharNonadjacenceVertexesSeriesСriterion(null, group);
		this.cr3 = new AWithTwoNonadjanceVerticesSeriesСriterion(null, group);
	}
	
}