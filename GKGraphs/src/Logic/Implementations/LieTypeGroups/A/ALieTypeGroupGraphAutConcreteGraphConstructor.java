package Logic.Implementations.LieTypeGroups.A;

import java.util.ArrayList;
import java.util.List;

import Logic.Implementations.LieTypeGroups.B.BLieTypeGroup;
import Logic.Implementations.LieTypeGroups.D.DLieTypeGroup;
import Logic.Implementations.LieTypeGroups._D._DLieTypeGroup;
import Logic.Kernel.GraphConstructor.Concrete.GraphAutConcreteLieTypeGroupGraphConstructor;
import Logic.Kernel.Group.LieTypeGroup;
import Logic.Kernel.Group.LieTypeGroup.GroupType;

public class ALieTypeGroupGraphAutConcreteGraphConstructor extends GraphAutConcreteLieTypeGroupGraphConstructor<ALieTypeGroup> {

	public ALieTypeGroupGraphAutConcreteGraphConstructor(ALieTypeGroup group) {
		super(group);
	}

	@Override
	protected List<LieTypeGroup> computeCentralizer(int x) {
		List<LieTypeGroup> result = new ArrayList<LieTypeGroup>();
		int n = this.group.getN();
		if ((n % 2)== 0) {
			result.add(new BLieTypeGroup(GroupType.B.name(), n / 2, this.group.getP(), this.group.getQ()));
		} else {
			if (this.group.getP() == 2) {
				result.add(new BLieTypeGroup(GroupType.B.name(), (n + 1) / 2, this.group.getP(), this.group.getQ()));
			} else {
				result.add(new BLieTypeGroup(GroupType.B.name(), (n + 1) / 2, this.group.getP(), this.group.getQ()));
				result.add(new DLieTypeGroup(GroupType.D.name(), (n + 1) / 2, this.group.getP(), this.group.getQ()));
				result.add(new _DLieTypeGroup(GroupType._D.name(), (n + 1) / 2, this.group.getP(), this.group.getQ()));
			}
		}
		return result;
	}
	
}