package Implementations.LieTypeGroups._A;

import java.util.List;

import Kernel.GraphConstructor.InndiagConcreteLieTypeGroupGraphConstructor;
import Kernel.Utils.InndiagUtils;

public class _ALieTypeGroupInndiagConcreteGraphConstructor extends InndiagConcreteLieTypeGroupGraphConstructor<_ALieTypeGroup> {

	public _ALieTypeGroupInndiagConcreteGraphConstructor(_ALieTypeGroup group) {
		super(group);
	}
	
	@Override
	protected List<List<Integer>> computeTorOrdersPartitions() {
		return InndiagUtils.computeTorOrdersPartitionsEpsilonA(this.group, InndiagUtils.MINUS);
	}
	
}