package Logic.Kernel.GraphConstructor.Concrete.Сriterion;

import java.util.List;

import Logic.Kernel.Graph.Edge;
import Logic.Kernel.Group.LieTypeGroup;
import Logic.Kernel.Utils.CriterionUtils;

/**
 * Критерий несмежности простого нечетного числа с характеристикой в графе Грюнберга --- Кегеля группы Лиева типа.
 * 
 * @author v.kolpakova
 *
 */
public class WithCharNonadjacenceVertexesСriterion extends AbstractLieTypeGroupCriterion {
	
	// TODO возможно, имеет смысл вынести проверку равенства одной из вершин характеристике сюда

	public WithCharNonadjacenceVertexesСriterion(LieTypeGroup group) {
		super(group);
	}
	
	public WithCharNonadjacenceVertexesСriterion(List<Edge> edgeList, LieTypeGroup group) {
		super(edgeList, group);
	}

	@Override
	protected boolean check(Edge edge) {
		return false;
	}
	
	protected int returnR(int a, int b) {
		return CriterionUtils.returnRWithCondition(a, b, this.ltGroup.getP());
	}
	
}