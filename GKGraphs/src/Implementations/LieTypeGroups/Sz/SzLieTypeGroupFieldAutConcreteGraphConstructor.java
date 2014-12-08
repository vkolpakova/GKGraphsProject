package Implementations.LieTypeGroups.Sz;

import java.util.ArrayList;
import java.util.List;

import Kernel.GraphConstructor.Concrete.FieldAutConcreteLieTypeGroupGraphConstructor;
import Kernel.Group.LieTypeGroup;
import Kernel.Utils.ArithmeticUtils;

public class SzLieTypeGroupFieldAutConcreteGraphConstructor extends FieldAutConcreteLieTypeGroupGraphConstructor<SzLieTypeGroup> {

	public SzLieTypeGroupFieldAutConcreteGraphConstructor(SzLieTypeGroup group) {
		super(group);
	}

	@Override
	protected List<LieTypeGroup> computeCentralizer(int x) {
		List<LieTypeGroup> result = new ArrayList<LieTypeGroup>();
		int m = ArithmeticUtils.getPow(this.group.getQ(), this.group.getP());
		if ((m % x) == 0) {
			result.add(new SzLieTypeGroup("*", 2, 2, (int) Math.pow(2, (m / x))));
		}
		return result;
	}
	
}