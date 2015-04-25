package Logic.Implementations.LieTypeGroups.D;

import java.util.List;

import Logic.Kernel.GraphConstructor.Concrete.InndiagConcreteLieTypeGroupGraphConstructor;
import Logic.Kernel.Utils.InndiagUtils;

public class DLieTypeGroupInndiagConcreteGraphConstructor extends InndiagConcreteLieTypeGroupGraphConstructor<DLieTypeGroup> {

	public DLieTypeGroupInndiagConcreteGraphConstructor(DLieTypeGroup group) {
		super(group);
	}
	
	@Override
	protected List<List<Integer>> computeTorOrdersPartitions() {
		return InndiagUtils.computeTorOrdersPartitionsEpsilonD(this.group, InndiagUtils.PLUS);
	}
	
}