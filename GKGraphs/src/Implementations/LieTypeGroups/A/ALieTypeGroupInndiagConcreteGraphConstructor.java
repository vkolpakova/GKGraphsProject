package Implementations.LieTypeGroups.A;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import Kernel.GraphConstructor.InndiagConcreteLieTypeGroupGraphConstructor;
import Kernel.Utils.ArithmeticUtils;

public class ALieTypeGroupInndiagConcreteGraphConstructor extends InndiagConcreteLieTypeGroupGraphConstructor<ALieTypeGroup> {

	public ALieTypeGroupInndiagConcreteGraphConstructor(ALieTypeGroup group) {
		super(group);
	}

	@Override
	protected List<List<Integer>> computeTorOrdersPartitions() {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		int n = this.group.getN() + 1;
		List<List<Integer>> nPartitions = ArithmeticUtils.partition(n);
		for (List<Integer> list : nPartitions) {
			//Set<Integer> intSet = new HashSet<Integer>(list);
			Set<Integer> primeDivSet = new HashSet<Integer>();
			double mult = 1;
			for (int num : list) {
				mult *= Math.pow(this.group.getQ(), num) - 1;
			}
			mult /= (this.group.getQ() - 1);
			primeDivSet.addAll(ArithmeticUtils.getAllPrimeDevisors(mult));
			List<Integer> primeDivList = new ArrayList<Integer>(primeDivSet);
			result.add(primeDivList);
		}
		return result;
	}
	
}