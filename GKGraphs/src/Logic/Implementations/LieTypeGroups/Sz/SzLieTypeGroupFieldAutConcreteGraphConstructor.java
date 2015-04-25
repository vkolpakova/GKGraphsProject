package Logic.Implementations.LieTypeGroups.Sz;

import java.util.ArrayList;
import java.util.List;

import Logic.Kernel.GraphConstructor.Concrete.FieldAutConcreteLieTypeGroupGraphConstructor;
import Logic.Kernel.Group.LieTypeGroup;
import Logic.Kernel.Group.LieTypeGroup.GroupType;
import Logic.Kernel.Utils.ArithmeticUtils;

public class SzLieTypeGroupFieldAutConcreteGraphConstructor extends FieldAutConcreteLieTypeGroupGraphConstructor<SzLieTypeGroup> {

	public SzLieTypeGroupFieldAutConcreteGraphConstructor(SzLieTypeGroup group) {
		super(group);
	}

	@Override
	protected List<LieTypeGroup> computeCentralizer(int x) {
		List<LieTypeGroup> result = new ArrayList<LieTypeGroup>();
		int m = ArithmeticUtils.getPow(this.group.getQ(), this.group.getP());
		if ((m % x) == 0) {
			result.add(new SzLieTypeGroup(GroupType.Sz.name(), 2, 2, (int) Math.pow(2, (m / x))));
		}
		return result;
	}
	
}