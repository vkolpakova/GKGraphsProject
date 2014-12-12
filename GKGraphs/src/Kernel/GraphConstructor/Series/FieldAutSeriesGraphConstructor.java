package Kernel.GraphConstructor.Series;

import java.util.List;

import Kernel.Graph.PrimeNumberGraph;
import Kernel.Group.Series;

public class FieldAutSeriesGraphConstructor extends AutSubgroupSeriesGraphConstructor {

	public FieldAutSeriesGraphConstructor(Series group) {
		super(group);
	}

	@Override
	protected void computeCentralizationsMap() { } // реализуется в потомках

	@Override
	public int getOrder() {
		return this.group.getIntegerPartFieldAutOrder();
	}

	@Override
	public void constructGKGraph(int autOrder) {}

	@Override
	public List<PrimeNumberGraph> constructGKGraphs() {
		return null;
	}
	
}