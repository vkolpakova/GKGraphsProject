package Kernel.GraphConstructor.Series;

import java.util.List;

import com.google.common.collect.Lists;

import Kernel.Graph.PrimeNumberGraph;
import Kernel.Group.Series;

public class SimpleInndiagSeriesGraphConstructor extends InndiagSeriesGraphConstructor {

	public SimpleInndiagSeriesGraphConstructor(Series group) {
		super(group);
	}
	
	@Override
	public List<PrimeNumberGraph> constructGKGraphs() {
		return Lists.newArrayList(this.groupGraph);
	}
	
}