package Logic.Series.GSeries.G2;

import Logic.Kernel.GraphConstructor.Series.SeriesGraphConstructor;
import Logic.Series.GSeries.Criterion.GTwoOddNonadjacenceVerticesSeriesСriterion;
import Logic.Series.GSeries.Criterion.GWithCharNonadjacenceVertexesSeriesСriterion;
import Logic.Series.GSeries.Criterion.GWithTwoNonadjanceVerticesSeriesСriterion;

public class G2SeriesGraphConstructor extends SeriesGraphConstructor {

	public G2SeriesGraphConstructor(G2Series group) {
		super(group);
		this.cr1 = new GTwoOddNonadjacenceVerticesSeriesСriterion(this, group);
		this.cr2 = new GWithCharNonadjacenceVertexesSeriesСriterion(this, group);
		this.cr3 = new GWithTwoNonadjanceVerticesSeriesСriterion(this, group);
	}
	
}