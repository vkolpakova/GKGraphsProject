package Logic.Series.ASeries;

import Logic.Kernel.GraphConstructor.Series.SeriesGraphConstructor;
import Logic.Series.ASeries.Criterion.ATwoOddNonadjacenceVerticesSeriesСriterion;
import Logic.Series.ASeries.Criterion.AWithCharNonadjacenceVertexesSeriesСriterion;
import Logic.Series.ASeries.Criterion.AWithTwoNonadjanceVerticesSeriesСriterion;

public class ASeriesGraphConstructor extends SeriesGraphConstructor {

	public ASeriesGraphConstructor(ASeries group) {
		super(group);
		this.cr1 = new ATwoOddNonadjacenceVerticesSeriesСriterion(this, group);
		this.cr2 = new AWithCharNonadjacenceVertexesSeriesСriterion(this, group);
		this.cr3 = new AWithTwoNonadjanceVerticesSeriesСriterion(this, group);
	}
	
}