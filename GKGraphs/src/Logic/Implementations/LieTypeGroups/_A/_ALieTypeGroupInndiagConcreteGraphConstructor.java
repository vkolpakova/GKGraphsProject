package Logic.Implementations.LieTypeGroups._A;

import java.util.List;

import Logic.Kernel.GraphConstructor.Concrete.InndiagConcreteLieTypeGroupGraphConstructor;
import Logic.Kernel.Utils.InndiagUtils;

public class _ALieTypeGroupInndiagConcreteGraphConstructor extends InndiagConcreteLieTypeGroupGraphConstructor<_ALieTypeGroup> {

	public _ALieTypeGroupInndiagConcreteGraphConstructor(_ALieTypeGroup group) {
		super(group);
	}
	
	@Override
	protected List<List<Integer>> computeTorOrdersPartitions() {
		return InndiagUtils.computeTorOrdersPartitionsEpsilonA(this.group, InndiagUtils.MINUS);
	}
	
}