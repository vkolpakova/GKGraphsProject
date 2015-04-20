package Implementations.LieTypeGroups._A;

import java.util.ArrayList;
import java.util.List;

import Implementations.LieTypeGroups.B.BLieTypeGroup;
import Implementations.LieTypeGroups.D.DLieTypeGroup;
import Implementations.LieTypeGroups._D._DLieTypeGroup;
import Kernel.GraphConstructor.Concrete.FieldAutConcreteLieTypeGroupGraphConstructor;
import Kernel.Group.LieTypeGroup;
import Kernel.Group.LieTypeGroup.GroupType;
import Kernel.Utils.ArithmeticUtils;

public class _ALieTypeGroupFieldAutConcreteGraphConstructor extends FieldAutConcreteLieTypeGroupGraphConstructor<_ALieTypeGroup> {

	public _ALieTypeGroupFieldAutConcreteGraphConstructor(_ALieTypeGroup group) {
		super(group);
	}

	@Override
	protected List<LieTypeGroup> computeCentralizer(int x) {
		List<LieTypeGroup> result = new ArrayList<LieTypeGroup>();
		if (x > 2) {
			int pow = ArithmeticUtils.getPow(this.group.getQ(), this.group.getP());
			result.add(new _ALieTypeGroup(GroupType._A.name(), this.group.getN(), this.group.getP(), (int) Math.pow(this.group.getP(), (pow / x))));
		} else if ((x == 2) && ((this.group.getN() % 2) == 0)) {
			result.add(new BLieTypeGroup(GroupType.B.name(), this.group.getN() / 2, this.group.getP(), this.group.getQ()));
		} else if ((x == this.group.getP()) && (x == 2) && ((this.group.getN() % 2) != 0)) {
			result.add(new BLieTypeGroup(GroupType.B.name(), (this.group.getN() + 1) / 2, this.group.getP(), this.group.getQ()));
		} else if ((x == 2) && ((this.group.getN() % 2) != 0) && (this.group.getP() > 2)) {
			int newN = (this.group.getN() + 1) / 2;
			result.add(new BLieTypeGroup(GroupType.B.name(), newN, this.group.getP(), this.group.getQ()));
			result.add(new DLieTypeGroup(GroupType.D.name(), newN, this.group.getP(), this.group.getQ()));
			result.add(new _DLieTypeGroup(GroupType._D.name(), newN, this.group.getP(), this.group.getQ()));
		}
		return result;
	}
	
}