package Logic.Kernel.GraphConstructor.Series;

import java.util.List;

import com.google.common.collect.Lists;

import Logic.Kernel.Graph.PrimeNumberGraph;
import Logic.Kernel.Group.Series;

public class SimpleInndiagSeriesGraphConstructor extends InndiagSeriesGraphConstructor {

	public SimpleInndiagSeriesGraphConstructor(Series group) {
		super(group);
	}
	
	@Override
	public List<PrimeNumberGraph> constructGKGraphs() {
		return Lists.newArrayList(this.groupGraph);
	}
	
}