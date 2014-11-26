package Implementations.LieTypeGroups.D;

import java.util.List;

import Kernel.GraphConstructor.InndiagConcreteLieTypeGroupGraphConstructor;
import Kernel.Utils.InndiagUtils;

public class DLieTypeGroupInndiagConcreteGraphConstructor extends InndiagConcreteLieTypeGroupGraphConstructor<DLieTypeGroup> {

	public DLieTypeGroupInndiagConcreteGraphConstructor(DLieTypeGroup group) {
		super(group);
	}
	
	@Override
	protected List<List<Integer>> computeTorOrdersPartitions() {
		return InndiagUtils.computeTorOrdersPartitionsEpsilonD(this.group, InndiagUtils.PLUS);
	}
	
}