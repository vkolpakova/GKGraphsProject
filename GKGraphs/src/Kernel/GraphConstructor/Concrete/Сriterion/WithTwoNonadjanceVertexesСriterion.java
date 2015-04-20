package Kernel.GraphConstructor.Concrete.Сriterion;

import java.util.List;

import Kernel.Graph.Edge;
import Kernel.Group.LieTypeGroup;
import Kernel.Utils.CriterionUtils;

/**
 * Критерий несмежности простого нечетного числа с 2 (в некоторых случаях - с вершиной, удовлетворяющей нек. арифметическому условию)
 *  в графе Грюнберга --- Кегеля группы Лиева типа.
 * 
 * @author v.kolpakova
 *
 */
public class WithTwoNonadjanceVertexesСriterion extends AbstractLieTypeGroupCriterion {

	public WithTwoNonadjanceVertexesСriterion(LieTypeGroup group) {
		super(group);
	}
	
	public WithTwoNonadjanceVertexesСriterion(List<Edge> edgeList, LieTypeGroup group) {
		super(edgeList, group);
	}

	@Override
	protected boolean check(Edge edge) {
		return false;
	}
	
	protected int returnR(int a, int b) {
		return CriterionUtils.returnRWithCondition(a, b, 2);
	}
	
}