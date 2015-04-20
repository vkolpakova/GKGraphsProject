package Implementations.LieTypeGroups.A;

import java.util.List;

import Kernel.GraphConstructor.Concrete.InndiagConcreteLieTypeGroupGraphConstructor;
import Kernel.Utils.InndiagUtils;

public class ALieTypeGroupInndiagConcreteGraphConstructor extends InndiagConcreteLieTypeGroupGraphConstructor<ALieTypeGroup> {

	public ALieTypeGroupInndiagConcreteGraphConstructor(ALieTypeGroup group) {
		super(group);
	}

	@Override
	protected List<List<Integer>> computeTorOrdersPartitions() {
		return InndiagUtils.computeTorOrdersPartitionsEpsilonA(this.group, InndiagUtils.PLUS);
	}
	
}