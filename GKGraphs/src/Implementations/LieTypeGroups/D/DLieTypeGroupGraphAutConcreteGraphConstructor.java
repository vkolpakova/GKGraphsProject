package Implementations.LieTypeGroups.D;

import java.util.ArrayList;
import java.util.List;

import Implementations.LieTypeGroups.B.BLieTypeGroup;
import Implementations.LieTypeGroups.G.GLieTypeGroup;
import Kernel.GraphConstructor.GraphAutConcreteLieTypeGroupGraphConstructor;
import Kernel.Group.LieTypeGroup;

public class DLieTypeGroupGraphAutConcreteGraphConstructor extends GraphAutConcreteLieTypeGroupGraphConstructor<DLieTypeGroup> {

	public DLieTypeGroupGraphAutConcreteGraphConstructor(DLieTypeGroup group) {
		super(group);
	}

	@Override
	protected List<LieTypeGroup> computeCentralizer(int x) {
		List<LieTypeGroup> result = new ArrayList<LieTypeGroup>();
		if (x == 2) {
			result.add(new BLieTypeGroup("*", this.group.getN() - 1, this.group.getP(), this.group.getQ()));
		} else if (x == 3) {
			result.add(new GLieTypeGroup("*", 2, this.group.getP(), this.group.getQ()));
		}
		return result;
	}
	
}