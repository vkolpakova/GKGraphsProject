package Implementations.LieTypeGroups.B;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import Kernel.GraphConstructor.Concrete.InndiagConcreteLieTypeGroupGraphConstructor;
import Kernel.Utils.ArithmeticUtils;

public class BLieTypeGroupInndiagConcreteGraphConstructor extends InndiagConcreteLieTypeGroupGraphConstructor<BLieTypeGroup> {

	public BLieTypeGroupInndiagConcreteGraphConstructor(BLieTypeGroup group) {
		super(group);
	}
	
	@Override
	protected List<List<Integer>> computeTorOrdersPartitions() {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Set<Map<Integer, List<Integer>>> partitions = ArithmeticUtils.getAllPartitionsForAllCombinations(this.group.getN());
		for (Map<Integer, List<Integer>> partition : partitions) {
			int order = 1;
			List<Integer> subN = partition.get(1);
			List<Integer> subL = partition.get(0);
			// FIXME понять, что делать в случае, когда одно из подмнодеств пустое
			if (!subN.isEmpty()) {
				for (int num : subN) {
					order *= Math.pow(this.group.getQ(), num) - 1;
				}
			}
			if (!subL.isEmpty()) {
				for (int num : subL) {
					order *= Math.pow(this.group.getQ(), num) + 1;
				}
			}
			if (order != 1) {
				result.add(ArithmeticUtils.getAllPrimeDevisors(order));
			}
		}
		return result;
	}
	
}