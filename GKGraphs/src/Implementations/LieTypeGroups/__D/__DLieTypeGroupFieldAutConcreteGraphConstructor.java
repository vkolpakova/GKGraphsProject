package Implementations.LieTypeGroups.__D;

import java.util.ArrayList;
import java.util.List;

import Implementations.LieTypeGroups.G.GLieTypeGroup;
import Kernel.GraphConstructor.Concrete.FieldAutConcreteLieTypeGroupGraphConstructor;
import Kernel.Group.LieTypeGroup;
import Kernel.Group.LieTypeGroup.GroupType;
import Kernel.Utils.ArithmeticUtils;

public class __DLieTypeGroupFieldAutConcreteGraphConstructor extends FieldAutConcreteLieTypeGroupGraphConstructor<__DLieTypeGroup> {

	public __DLieTypeGroupFieldAutConcreteGraphConstructor(__DLieTypeGroup group) {
		super(group);
	}

	@Override
	protected List<LieTypeGroup> computeCentralizer(int x) {
		List<LieTypeGroup> result = new ArrayList<LieTypeGroup>();
		if (ArithmeticUtils.getPow(this.group.getQ(), this.group.getP()) % x == 0) {
			result.add(new __DLieTypeGroup(GroupType.__D.name(), this.group.getN(), this.group.getP(), (int) Math.pow(this.group.getP(), this.group.getP() / x ))); 
		} else if (x == 3) {
			result.add(new GLieTypeGroup(GroupType.G.name(), 2, this.group.getP(), this.group.getQ()));
		}
		return result;
	}
	
}