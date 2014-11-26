package Implementations.LieTypeGroups.A;

import Kernel.GraphConstructor.FieldAutConcreteLieTypeGroupGraphConstructor;
import Kernel.Group.LieTypeGroup;
import Kernel.Utils.ArithmeticUtils;

public class ALieTypeGroupFieldAutConcreteGraphConstructor extends FieldAutConcreteLieTypeGroupGraphConstructor<ALieTypeGroup> {

	public ALieTypeGroupFieldAutConcreteGraphConstructor(ALieTypeGroup group) {
		super(group);
	}

	@Override
	protected LieTypeGroup computeCentralizer(int x) {
		int m = ArithmeticUtils.getPow(this.group.getQ(), this.group.getP());
		if ((m % x) == 0) {
			return new ALieTypeGroup("*", this.group.getN(), this.group.getP(), (int) Math.pow(this.group.getP(), (m / x)));
		}
		return null;
	}
	
}