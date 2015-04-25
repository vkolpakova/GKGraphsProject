package Logic.Implementations.LieTypeGroups._D;

import java.util.List;

import Logic.Kernel.GraphConstructor.Concrete.InndiagConcreteLieTypeGroupGraphConstructor;
import Logic.Kernel.Utils.InndiagUtils;

public class _DLieTypeGroupInndiagConcreteGraphConstructor extends InndiagConcreteLieTypeGroupGraphConstructor<_DLieTypeGroup> {

	public _DLieTypeGroupInndiagConcreteGraphConstructor(_DLieTypeGroup group) {
		super(group);
	}

	@Override
	protected List<List<Integer>> computeTorOrdersPartitions() {
		return InndiagUtils.computeTorOrdersPartitionsEpsilonD(this.group, InndiagUtils.MINUS);
	}
	
}