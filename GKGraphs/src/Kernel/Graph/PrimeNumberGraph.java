package Kernel.Graph;

import java.util.ArrayList;
import java.util.List;

import Kernel.Utils.MainLogger;

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
	
}