package Logic.Implementations.LieTypeGroups._D;

import java.util.ArrayList;
import java.util.List;

import Logic.Kernel.GraphConstructor.Concrete.FieldAutConcreteLieTypeGroupGraphConstructor;
import Logic.Kernel.Group.LieTypeGroup;
import Logic.Kernel.Group.LieTypeGroup.GroupType;
import Logic.Kernel.Utils.ArithmeticUtils;

public class _DLieTypeGroupFieldAutConcreteGraphConstructor extends FieldAutConcreteLieTypeGroupGraphConstructor<_DLieTypeGroup> {

	public _DLieTypeGroupFieldAutConcreteGraphConstructor(_DLieTypeGroup group) {
		super(group);
	}

	@Override
	protected List<LieTypeGroup> computeCentralizer(int x) {
		List<LieTypeGroup> result = new ArrayList<LieTypeGroup>();
		int m = ArithmeticUtils.getPow(this.group.getQ(), this.group.getP());
		if ((m % x) == 0) {
			result.add(new _DLieTypeGroup(GroupType._D.name(), this.group.getN(), this.group.getP(), (int) Math.pow(this.group.getP(), (m / x))));
		}
		return result;
	}
	
}