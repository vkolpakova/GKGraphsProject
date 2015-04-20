package Implementations.LieTypeGroups.D;

import java.util.ArrayList;
import java.util.List;

import Implementations.LieTypeGroups.B.BLieTypeGroup;
import Implementations.LieTypeGroups.G.GLieTypeGroup;
import Kernel.GraphConstructor.Concrete.GraphAutConcreteLieTypeGroupGraphConstructor;
import Kernel.Group.LieTypeGroup;
import Kernel.Group.LieTypeGroup.GroupType;

public class DLieTypeGroupGraphAutConcreteGraphConstructor extends GraphAutConcreteLieTypeGroupGraphConstructor<DLieTypeGroup> {

	public DLieTypeGroupGraphAutConcreteGraphConstructor(DLieTypeGroup group) {
		super(group);
	}

	@Override
	protected List<LieTypeGroup> computeCentralizer(int x) {
		List<LieTypeGroup> result = new ArrayList<LieTypeGroup>();
		if (x == 2) {
			result.add(new BLieTypeGroup(GroupType.B.name(), this.group.getN() - 1, this.group.getP(), this.group.getQ()));
		} else if (x == 3) {
			result.add(new GLieTypeGroup(GroupType.G.name(), 2, this.group.getP(), this.group.getQ()));
		}
		return result;
	}
	
}