package Implementations.LieTypeGroups.F;

import java.util.ArrayList;
import java.util.List;

import Kernel.GraphConstructor.FieldAutConcreteLieTypeGroupGraphConstructor;
import Kernel.Group.LieTypeGroup;
import Kernel.Utils.ArithmeticUtils;

public class FLieTypeGroupFieldAutConcreteGraphConstructor extends FieldAutConcreteLieTypeGroupGraphConstructor<FLieTypeGroup> {

	public FLieTypeGroupFieldAutConcreteGraphConstructor(FLieTypeGroup group) {
		super(group);
	}
	
	@Override
	protected List<LieTypeGroup> computeCentralizer(int x) {
		List<LieTypeGroup> result = new ArrayList<LieTypeGroup>();
		int m = ArithmeticUtils.getPow(this.group.getQ(), this.group.getP());
		if ((m % x) == 0) {
			result.add(new FLieTypeGroup("*", 4, this.group.getP(), (int) Math.pow(this.group.getP(), (m / x))));
		}
		return result;
	}
	
}