package Logic.Series.CSeries.C2;

import Logic.Kernel.GraphConstructor.Series.SeriesGraphConstructor;
import Logic.Series.CSeries.Criterion.CTwoOddNonadjacenceVerticesSeriesСriterion;
import Logic.Series.CSeries.Criterion.CWithCharNonadjacenceVertexesSeriesСriterion;
import Logic.Series.CSeries.Criterion.CWithTwoNonadjanceVerticesSeriesСriterion;

public class C2SeriesGraphConstructor extends SeriesGraphConstructor {

	public C2SeriesGraphConstructor(C2Series group) {
		super(group);
		this.cr1 = new CTwoOddNonadjacenceVerticesSeriesСriterion(this, group);
		this.cr2 = new CWithCharNonadjacenceVertexesSeriesСriterion(this, group);
		this.cr3 = new CWithTwoNonadjanceVerticesSeriesСriterion(this, group);
	}
	
}