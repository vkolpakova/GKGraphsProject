package Implementations.LieTypeGroups.A;

import java.util.ArrayList;
import java.util.List;

import Implementations.LieTypeGroups.B.BLieTypeGroup;
import Implementations.LieTypeGroups.D.DLieTypeGroup;
import Implementations.LieTypeGroups._D._DLieTypeGroup;
import Kernel.GraphConstructor.GraphAutConcreteLieTypeGroupGraphConstructor;
import Kernel.Group.LieTypeGroup;

public class ALieTypeGroupGraphAutConcreteGraphConstructor extends GraphAutConcreteLieTypeGroupGraphConstructor<ALieTypeGroup> {

	public ALieTypeGroupGraphAutConcreteGraphConstructor(ALieTypeGroup group) {
		super(group);
	}

	@Override
	protected List<LieTypeGroup> computeCentralizer(int x) {
		List<LieTypeGroup> result = new ArrayList<LieTypeGroup>();
		int n = this.group.getN();
		if ((n % 2)== 0) {
			result.add(new BLieTypeGroup("*", n / 2, this.group.getP(), this.group.getQ()));
		} else {
			if (this.group.getP() == 2) {
				result.add(new BLieTypeGroup("*", (n + 1) / 2, this.group.getP(), this.group.getQ()));
			} else {
				result.add(new BLieTypeGroup("*", (n + 1) / 2, this.group.getP(), this.group.getQ()));
				result.add(new DLieTypeGroup("*", (n + 1) / 2, this.group.getP(), this.group.getQ()));
				result.add(new _DLieTypeGroup("*", (n + 1) / 2, this.group.getP(), this.group.getQ()));
			}
		}
		return result;
	}
	
}