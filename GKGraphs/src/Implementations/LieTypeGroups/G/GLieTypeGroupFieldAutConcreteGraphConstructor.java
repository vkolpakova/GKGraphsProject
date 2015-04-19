package Implementations.LieTypeGroups.G;

import java.util.ArrayList;
import java.util.List;

import Kernel.GraphConstructor.Concrete.FieldAutConcreteLieTypeGroupGraphConstructor;
import Kernel.Group.LieTypeGroup;
import Kernel.Group.LieTypeGroup.GroupType;
import Kernel.Utils.ArithmeticUtils;

public class GLieTypeGroupFieldAutConcreteGraphConstructor extends FieldAutConcreteLieTypeGroupGraphConstructor<GLieTypeGroup> {

	public GLieTypeGroupFieldAutConcreteGraphConstructor(GLieTypeGroup group) {
		super(group);
	}

	@Override
	protected List<LieTypeGroup> computeCentralizer(int x) {
		List<LieTypeGroup> result = new ArrayList<LieTypeGroup>();
		int m = ArithmeticUtils.getPow(this.group.getQ(), this.group.getP());
		if ((m % x) == 0) {
			result.add(new GLieTypeGroup(GroupType.G.name(), 2, this.group.getP(), (int) Math.pow(this.group.getP(), (m / x))));
		}
		return result;
	}
	
}