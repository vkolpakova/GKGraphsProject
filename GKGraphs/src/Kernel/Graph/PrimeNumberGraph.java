package Kernel.Graph;

import java.util.List;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;

import Kernel.Utils.MainLogger;

/**
 * Класс, представляющий собой объект графа Грюнберга --- Кегеля некоторой конечной группы
 * 
 * @author v.kolpakova
 *
 */
public class PrimeNumberGraph {
	
	/**
	 * Вершины графа
	 */
	private List<Vertex<?>> verticesList;

	/**
	 * Ребра графа
	 */
	private List<Edge> edgesList;
	
	public PrimeNumberGraph() {
		super();
		this.verticesList = Lists.newArrayList();
		this.edgesList = Lists.newArrayList();
	}
	
	public PrimeNumberGraph(List<Vertex<?>> verticesList, List<Edge> edgesList) {
		super();
		this.verticesList = verticesList;
		this.edgesList = edgesList;
	}
	
	public PrimeNumberGraph(PrimeNumberGraph graph) {
		super();
		this.verticesList = graph.verticesList;
		this.edgesList = graph.edgesList;
	}

	public List<Vertex<?>> getVerticesList() {
		return verticesList;
	}

	public void setVerticesList(List<Vertex<?>> verticesList) {
		this.verticesList = verticesList;
	}

	public List<Edge> getEdgesList() {
		return edgesList;
	}

	public void setEdgesList(List<Edge> edgesList) {
		this.edgesList = edgesList;
	}
	
	public void printConsole() {
		String vertices = "{";
		List<String> verticesStrList = Lists.newArrayListWithCapacity(verticesList.size());
		for (Vertex<?> v : verticesList) {
			verticesStrList.add(v.getVertex().toString());
		}
		vertices = vertices.concat(Joiner.on(", ").join(verticesStrList));
		vertices = vertices.concat("}");
		MainLogger.info("*PrimeNumberGraph* Vertices: " + vertices);
		for (Edge edge : edgesList) {
			String vertexA = edge.getVertexA().getVertex().toString();
			String vertexB = edge.getVertexB().getVertex().toString();
			MainLogger.info("*PrimeNumberGraph* " + "Vertex A = " + vertexA + "; Vertex B = " + vertexB);
		}
	}
	
	@Override
	public boolean equals(Object paramObject) {
		if (paramObject instanceof PrimeNumberGraph) {
			PrimeNumberGraph otherGraph = (PrimeNumberGraph) paramObject;
			List<Vertex<?>> otherVerticesList = otherGraph.getVerticesList();
			List<Edge> otherEdgeList = otherGraph.getEdgesList();
			return ((isEqualsIgnoreOrder(this.verticesList, otherVerticesList)) && 
					(isEqualsIgnoreOrder(this.edgesList, otherEdgeList)));
		} else {
			return false;
		}
	}
	
	private boolean isEqualsIgnoreOrder(List<?> list1, List<?> list2) {
		boolean result = true;
		if (list1.size() != list2.size()) {
			result = false;
		} else {
			for (Object obj : list1) {
				if (!list2.contains(obj)) {
					result = false;
				}
			}
		}
		return result;
	}
	
}