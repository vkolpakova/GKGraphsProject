package Logic.Kernel.GraphConstructor.Series;

import java.util.List;

import com.google.common.collect.Lists;

import Logic.Kernel.Graph.Edge;
import Logic.Kernel.Graph.PrimeNumberGraph;
import Logic.Kernel.Graph.SymbolVertex;
import Logic.Kernel.Graph.Vertex;
import Logic.Kernel.GraphConstructor.AbstractGraphConstructor;
import Logic.Kernel.GraphConstructor.Concrete.Сriterion.AbstractSeriesCriterion;
import Logic.Kernel.Group.Series;

/**
 * Конструктор графа Грюнберга --- Кегеля группы лиева типа бесконечной серии
 * 
 * @author v.kolpakova
 *
 */
public abstract class SeriesGraphConstructor extends AbstractGraphConstructor<Series> {
	
	protected Series series;
	
	/**
	 * Критерий несмежности двух нечетных простых чисел
	 */
	protected TwoOddNonadjacenceVerticesSeriesСriterion cr1;
	
	/**
	 * Критерий несмежности нечетного простого числа с характеристикой поля
	 */
	protected WithCharNonadjacenceVerticesSeriesСriterion cr2;
	
	/**
	 * Критерий несмежности нечетного простого числа с числом 2 (или другим, удовл. некоторому условию)
	 */
	protected WithTwoNonadjanceVerticesSeriesСriterion cr3;

	public SeriesGraphConstructor(Series group) {
		super(group);
		series = group;
	}
	
	public SeriesGraphConstructor(Series group, TwoOddNonadjacenceVerticesSeriesСriterion cr1,
			WithCharNonadjacenceVerticesSeriesСriterion cr2, WithTwoNonadjanceVerticesSeriesСriterion cr3) {
		super(group);
		series = group;
		this.cr1 = cr1;
		this.cr2 = cr2;
		this.cr3 = cr3;
	}
	
	@Override
	public PrimeNumberGraph constructGKGraph() {
		List<Vertex<?>> verticesList = this.series.getAllVerticesList();
		List<Edge> fullEdgeList = getFullEdgesList();
		List<Edge> step1List = twoOddNonadjacenceVertexes(fullEdgeList);
		List<Edge> step2List = withCharNonadjacenceVertexes(step1List);
		List<Edge> step3List = withTwoNonadjanceVertexes(step2List);
		return new PrimeNumberGraph(verticesList, step3List);
	}
	
	/**
	 * Метод удаляет все пары нечетных простых чисел, не являющиеся ребром
	 * @param inputList
	 */
	protected List<Edge> twoOddNonadjacenceVertexes(List<Edge> inputList) {
		this.cr1.setEdgeList(inputList);
		return cr1.checkAll();
	}
	
	/**
	 * Метод удаляет все пары "простое нечетное число --- характеристика поля", не являющиеся ребром
	 * @param inputList
	 */
	protected List<Edge> withCharNonadjacenceVertexes(List<Edge> inputList) {
		this.cr2.setEdgeList(inputList);
		return cr2.checkAll();
	}
	
	/**
	 * Метод удаляет все пары "простое нечетное число --- 2", не являющиеся ребром
	 * @param inputList
	 */
	protected List<Edge> withTwoNonadjanceVertexes(List<Edge> inputList) {
		this.cr3.setEdgeList(inputList);
		return cr3.checkAll();
	}
	
	private List<Edge> getFullEdgesList() {
		List<Edge> resultList = Lists.newArrayList();
		List<Vertex<?>> allVertices = this.series.getAllVerticesList();
		for (int i=0; i < allVertices.size(); i++) {
			for (int j=i+1; j < allVertices.size(); j++) {
				String iVertex = (String) allVertices.get(i).getVertex();
				String jVertex = (String) allVertices.get(j).getVertex();
				if (!iVertex.equals(jVertex)) {
					Edge newEdge = new Edge(new SymbolVertex((String) allVertices.get(i).getVertex()),
							new SymbolVertex((String) allVertices.get(j).getVertex()));
					if (!resultList.contains(newEdge)) {
						// проверку приходится делать, поскольку в соотв. set-е все равно появляются дубли
						resultList.add(newEdge);
					}
				}
			}
		}
		return resultList;
	}
	
	/**
	 * Критерий несмежности двух нечетных простых чисел, отличных от характеристики в графе Грюнберга --- Кегеля 
	 * группы Лиева типа из бесконечной серии
	 */
	public class TwoOddNonadjacenceVerticesSeriesСriterion extends AbstractSeriesCriterion {

		public TwoOddNonadjacenceVerticesSeriesСriterion(Series series) {
			super(series);
		}

		@Override
		protected boolean check(Edge edge) {
			boolean result1, result2;
			SymbolVertex a = (SymbolVertex) edge.getVertexA();
			SymbolVertex b = (SymbolVertex) edge.getVertexB();
			result1 = checkSimpleVertex(a);
			result2 = checkSimpleVertex(b);
			return (result1 && result2);
		}
		
		private boolean checkSimpleVertex(SymbolVertex v) {
			String value = v.getVertex();
			return ((!value.equals(SymbolVertex.TWO)) && (!value.equals(this.series.getP())));
		}
		
	}
	
	/**
	 * Критерий несмежности простого нечетного числа с характеристикой в графе Грюнберга --- Кегеля 
	 * группы Лиева типа из бесконечной серии
	 */
	public class WithCharNonadjacenceVerticesSeriesСriterion extends AbstractSeriesCriterion {

		public WithCharNonadjacenceVerticesSeriesСriterion(Series series) {
			super(series);
		}

		@Override
		protected boolean check(Edge edge) {
			SymbolVertex a = (SymbolVertex) edge.getVertexA();
			SymbolVertex b = (SymbolVertex) edge.getVertexB();
			return ((a.getVertex().equals(this.series.getP())) ||
					(b.getVertex().equals(this.series.getP())));
		}
		
		protected SymbolVertex getVertexR(SymbolVertex a, SymbolVertex b) {
			return (a.getVertex().equals(this.series.getP())) ? b : a;
		}
		
	}
	
	/**
	 * Критерий несмежности простого нечетного числа с 2 (в некоторых случаях - с вершиной, удовлетворяющей нек. арифметическому условию)
	 *  в графе Грюнберга --- Кегеля группы Лиева типа из бесконечной серии
	 */
	public class WithTwoNonadjanceVerticesSeriesСriterion extends AbstractSeriesCriterion {

		public WithTwoNonadjanceVerticesSeriesСriterion(Series series) {
			super(series);
		}

		@Override
		protected boolean check(Edge edge) {
			return false;
		}
		
	}
	
}