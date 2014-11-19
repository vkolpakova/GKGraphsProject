package Kernel.GraphConstructor;

import java.util.ArrayList;
import java.util.List;

import Kernel.Graph.Edge;
import Kernel.Graph.PrimeNumberGraph;
import Kernel.Graph.SimpleVertex;
import Kernel.Group.LieTypeGroup;
import Kernel.Utils.ArithmeticUtils;

public class ConcreteLieTypeGroupGraphConstructor<G extends LieTypeGroup> extends LieTypeGroupGraphConstructor {

	public ConcreteLieTypeGroupGraphConstructor(G group) {
		super(group);
	}
	
	@Override
	public PrimeNumberGraph constructGKGraph() {
		int order = this.group.getOrder();
		List<Integer> primeDevisors = ArithmeticUtils.getAllPrimeDevisors(order);
		List<Edge> fullEdgeList = getFullEdgesList(primeDevisors);
		twoOddNonadjacenceVertexes(fullEdgeList);
		withCharNonadjacenceVertexes(fullEdgeList);
		withTwoNonadjanceVertexes(fullEdgeList);
		return new PrimeNumberGraph(fullEdgeList);
	}

	private final List<Edge> getFullEdgesList(List<Integer> allPrimeDevisorsList) {
		List<Edge> resultList = new ArrayList<Edge>();
		int allPrimeDevisorsListSize = allPrimeDevisorsList.size();
		Integer[] allPrimeDevisorsArray = allPrimeDevisorsList.toArray(new Integer[allPrimeDevisorsListSize]);
		for (int i=0; i < allPrimeDevisorsListSize; i++) {
			for (int j=i+1; j < allPrimeDevisorsListSize; j++) {
				Edge newEdge = new Edge(new SimpleVertex(allPrimeDevisorsArray[i]), 
						new SimpleVertex(allPrimeDevisorsArray[j]));
				resultList.add(newEdge);
			}
		}
		return resultList;
	}
	
}