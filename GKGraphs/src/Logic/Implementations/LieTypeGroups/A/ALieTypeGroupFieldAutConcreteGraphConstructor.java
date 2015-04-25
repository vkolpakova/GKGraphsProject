package Logic.Implementations.LieTypeGroups.A;

import java.util.ArrayList;
import java.util.List;

import Logic.Kernel.GraphConstructor.Concrete.FieldAutConcreteLieTypeGroupGraphConstructor;
import Logic.Kernel.Group.LieTypeGroup;
import Logic.Kernel.Group.LieTypeGroup.GroupType;
import Logic.Kernel.Utils.ArithmeticUtils;

public class ALieTypeGroupFieldAutConcreteGraphConstructor extends FieldAutConcreteLieTypeGroupGraphConstructor<ALieTypeGroup> {

	public ALieTypeGroupFieldAutConcreteGraphConstructor(ALieTypeGroup group) {
		super(group);
	}

	@Override
	protected List<LieTypeGroup> computeCentralizer(int x) {
		List<LieTypeGroup> result = new ArrayList<LieTypeGroup>();
		int m = ArithmeticUtils.getPow(this.group.getQ(), this.group.getP());
		if ((m % x) == 0) {
			result.add(new ALieTypeGroup(GroupType.A.name(), this.group.getN(), this.group.getP(), (int) Math.pow(this.group.getP(), (m / x))));
		}
		return result;
	}
	
}