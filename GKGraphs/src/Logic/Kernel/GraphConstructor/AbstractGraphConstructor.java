package Logic.Kernel.GraphConstructor;

import Logic.Kernel.Graph.PrimeNumberGraph;
import Logic.Kernel.Group.AbstractGroup;

public abstract class AbstractGraphConstructor<G extends AbstractGroup> {
	
	protected G group;
	
	public AbstractGraphConstructor(G group) {
		super();
		this.group = group;
	}
	
	public AbstractGroup getGroup() {
		return group;
	}

	public void setGroup(G group) {
		this.group = group;
	}
	
	public abstract PrimeNumberGraph constructGKGraph();
	
}