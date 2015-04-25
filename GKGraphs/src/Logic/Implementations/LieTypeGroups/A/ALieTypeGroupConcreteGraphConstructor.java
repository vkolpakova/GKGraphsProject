package Logic.Implementations.LieTypeGroups.A;

import Logic.Kernel.GraphConstructor.Concrete.ConcreteLieTypeGroupGraphConstructor;

public class ALieTypeGroupConcreteGraphConstructor extends ConcreteLieTypeGroupGraphConstructor<ALieTypeGroup> {
	
	// TODO подумать, может для таких групп имеет смысл хранить вместо List-а с ребрами Map
	// с числовыми характеристиками вершин (чтобы не вычислять их для каждого критерия, например, значение ф-ии e)

	public ALieTypeGroupConcreteGraphConstructor(ALieTypeGroup group) {
		super(group);
		this.cr1 = new ALieTypeGroupTwoOddNonadjacenceVertexesСriterion(group);
		this.cr2 = new ALieTypeGroupWithCharNonadjacenceVertexesСriterion(group);
		this.cr3 = new ALieTypeGroupWithTwoNonadjanceVertexesСriterion(group);
	}
	
}