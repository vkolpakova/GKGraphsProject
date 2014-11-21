package Kernel.GraphConstructor.Сriterion;

import java.util.List;

import Kernel.Graph.Edge;
import Kernel.Graph.SimpleVertex;
import Kernel.Graph.Vertex;
import Kernel.Group.LieTypeGroup;
import Kernel.Utils.ArithmeticUtils;

/**
 * Критерий несмежности двух нечетных простых чисел, отличных от характеристики в графе Грюнберга --- Кегеля группы Лиева типа.
 * 
 * @author v.kolpakova
 *
 */
public class TwoOddNonadjacenceVertexesСriterion extends AbstractLieTypeGroupCriterion {
	
	public TwoOddNonadjacenceVertexesСriterion(LieTypeGroup group) {
		super(group);
	}
	
	public TwoOddNonadjacenceVertexesСriterion(List<Edge> edgeList, LieTypeGroup group) {
		super(edgeList, group);
	}

	@Override
	protected boolean check(Edge edge) {
		boolean result = true;
		Vertex<?> a = edge.getVertexA();
		Vertex<?> b = edge.getVertexB();
		if (a instanceof SimpleVertex) {
			result = checkSimpleVertex((SimpleVertex)a);
		}
		if (b instanceof SimpleVertex) {
			result = checkSimpleVertex((SimpleVertex)b);
		}
		return result;
	}
	
	protected boolean checkSimpleVertex(SimpleVertex v) {
		int vValue = v.getVertex();
		return (vValue % 2 != 0) && (ArithmeticUtils.isPrimeNumber(vValue) && (vValue != this.ltGroup.getP()));
	}
	
}