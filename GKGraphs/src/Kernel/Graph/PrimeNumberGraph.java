package Kernel.Graph;

import java.util.ArrayList;
import java.util.List;

import Kernel.Utils.MainLogger;

/**
 * Класс, представляющий собой объект графа Грюнберга --- Кегеля некоторой конечной группы
 * TODO подумать над реализацией: хранить не только ребра, но и вершины (м.б. изолированными)
 * @author v.kolpakova
 *
 */
public class PrimeNumberGraph {

	private List<Edge> edgesList;
	
	public PrimeNumberGraph() {
		super();
		this.edgesList = new ArrayList<Edge>();
	}
	
	public PrimeNumberGraph(List<Edge> edgesList) {
		super();
		this.edgesList = edgesList;
	}

	public List<Edge> getEdgesList() {
		return edgesList;
	}

	public void setEdgesList(List<Edge> edgesList) {
		this.edgesList = edgesList;
	}
	
	public void printConsole() {
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
			List<Edge> otherEdgeList = otherGraph.getEdgesList();
			for (int i=0; i<edgesList.size(); i++) {
				if (!edgesList.get(i).equals(otherEdgeList.get(i))) {
					return false;
				}
			}
			return true;
		} else {
			return false;
		}
		
	}
	
}