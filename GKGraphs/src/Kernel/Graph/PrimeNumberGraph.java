package Kernel.Graph;

import java.util.ArrayList;
import java.util.List;

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
	
}