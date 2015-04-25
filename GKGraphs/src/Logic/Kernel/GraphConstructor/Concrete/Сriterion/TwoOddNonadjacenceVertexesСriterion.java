package Logic.Kernel.GraphConstructor.Concrete.Сriterion;

import java.util.List;

import Logic.Kernel.Graph.Edge;
import Logic.Kernel.Graph.SimpleVertex;
import Logic.Kernel.Graph.Vertex;
import Logic.Kernel.Group.LieTypeGroup;
import Logic.Kernel.Utils.ArithmeticUtils;

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
		boolean result1 = true;
		boolean result2 = true;
		Vertex<?> a = edge.getVertexA();
		Vertex<?> b = edge.getVertexB();
		if (a instanceof SimpleVertex) {
			result1 = checkSimpleVertex((SimpleVertex)a);
		}
		if (b instanceof SimpleVertex) {
			result2 = checkSimpleVertex((SimpleVertex)b);
		}
		return (result1 && result2);
	}
	
	protected boolean checkSimpleVertex(SimpleVertex v) {
		int vValue = v.getVertex();
		return ((vValue != 2) && (ArithmeticUtils.isPrimeNumber(vValue)) && (vValue != this.ltGroup.getP()));
	}
	
}