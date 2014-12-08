package Kernel.GraphConstructor.Series;

import Kernel.Graph.PrimeNumberGraph;
import Kernel.Group.Series;

public class InndiagSeriesGraphConstructor extends AutSubgroupSeriesGraphConstructor {

	public InndiagSeriesGraphConstructor(Series group) {
		super(group);
	}

	@Override
	protected void computeCentralizationsMap() {
		
	}

	@Override
	public int getOrder() {
		return 0;
	}

	@Override
	public PrimeNumberGraph constructGKGraph() {
		return null;
	}
	
}