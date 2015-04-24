package Logic.Implementations.LieTypeGroups.Ri;

import java.util.ArrayList;
import java.util.List;

import Logic.Kernel.GraphConstructor.Concrete.FieldAutConcreteLieTypeGroupGraphConstructor;
import Logic.Kernel.Group.LieTypeGroup;
import Logic.Kernel.Group.LieTypeGroup.GroupType;
import Logic.Kernel.Utils.ArithmeticUtils;

public class RiLieTypeGroupFieldAutConcreteGraphConstructor extends FieldAutConcreteLieTypeGroupGraphConstructor<RiLieTypeGroup> {

	public RiLieTypeGroupFieldAutConcreteGraphConstructor(RiLieTypeGroup group) {
		super(group);
	}
	
	@Override
	protected List<LieTypeGroup> computeCentralizer(int x) {
		List<LieTypeGroup> result = new ArrayList<LieTypeGroup>();
		int m = ArithmeticUtils.getPow(this.group.getQ(), this.group.getP());
		if ((m % x) == 0) {
			result.add(new RiLieTypeGroup(GroupType.Ri.name(), 2, 3, (int) Math.pow(3, (m / x))));
		}
		return result;
	}
	
}