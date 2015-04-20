package Series.CSeries.C2;

import Kernel.GraphConstructor.Series.SeriesGraphConstructor;
import Series.CSeries.Criterion.CTwoOddNonadjacenceVerticesSeriesСriterion;
import Series.CSeries.Criterion.CWithCharNonadjacenceVertexesSeriesСriterion;
import Series.CSeries.Criterion.CWithTwoNonadjanceVerticesSeriesСriterion;

public class C2SeriesGraphConstructor extends SeriesGraphConstructor {

	public C2SeriesGraphConstructor(C2Series group) {
		super(group);
		this.cr1 = new CTwoOddNonadjacenceVerticesSeriesСriterion(this, group);
		this.cr2 = new CWithCharNonadjacenceVertexesSeriesСriterion(this, group);
		this.cr3 = new CWithTwoNonadjanceVerticesSeriesСriterion(this, group);
	}
	
}