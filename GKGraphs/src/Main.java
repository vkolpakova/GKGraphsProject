import java.util.List;
import java.util.Map;

import Kernel.Graph.PrimeNumberGraph;
import Kernel.GraphConstructor.FieldAutConcreteLieTypeGroupGraphConstructor;
import Kernel.GraphConstructor.GraphAutConcreteLieTypeGroupGraphConstructor;
import Kernel.GraphConstructor.InndiagConcreteLieTypeGroupGraphConstructor;
import Kernel.GraphConstructor.LieTypeGroupGraphConstructor;
import Kernel.Group.LieTypeGroup;
import Kernel.Resolvers.FieldAutLieTypeGroupGraphConstructorResolver;
import Kernel.Resolvers.GraphAutLieTypeGroupGraphConstructorResolver;
import Kernel.Resolvers.InndiagLieTypeGroupGraphConstructorResolver;
import Kernel.Resolvers.LieTypeGroupGraphConstructorResolver;
import Kernel.Resolvers.LieTypeGroupTypeResolver;
import Kernel.Utils.MainLogger;

public class Main {
	
	public static void main(String args[]) {
		System.out.println("Start");
		LieTypeGroup gr = LieTypeGroupTypeResolver.resolve("D_4(5)");
		// построение графа простой группы P Лиева типа
		LieTypeGroupGraphConstructor constr = LieTypeGroupGraphConstructorResolver.resolve(gr);
		PrimeNumberGraph graph = constr.constructGKGraph();
		gr.setGraph(graph);
		MainLogger.info("=====Group=====");
		graph.printConsole();
		// построение графа Inndiag(P)
		InndiagConcreteLieTypeGroupGraphConstructor<?> inndiagConstr = InndiagLieTypeGroupGraphConstructorResolver.resolve(gr);
		PrimeNumberGraph inndiagGraph = inndiagConstr.constructGKGraph();
		MainLogger.info("=====Inndiag=====");
		inndiagGraph.printConsole();
		// построение графов вида Inndiag(P)<f>, f --- полевой автоморфизм P
		FieldAutConcreteLieTypeGroupGraphConstructor<?> fieldConstr = FieldAutLieTypeGroupGraphConstructorResolver.resolve(gr);
		Map<Integer, List<PrimeNumberGraph>> fgrMap = fieldConstr.constructGraphs();
		MainLogger.info("======FieldAut=====");
		for (int x : fgrMap.keySet()) {
			MainLogger.info("Element order = "+Integer.toString(x));
			List<PrimeNumberGraph> fGraphList = fgrMap.get(x);
			for (PrimeNumberGraph fGraph : fGraphList) {
				fGraph.printConsole();
			}
		}
		// построение графов вида Inndiag(P)<g>, g --- графовый автоморфизм P
		GraphAutConcreteLieTypeGroupGraphConstructor<?> graphConstr = GraphAutLieTypeGroupGraphConstructorResolver.resolve(gr);
		Map<Integer, List<PrimeNumberGraph>> ggrMap = graphConstr.constructGraphs();
		MainLogger.info("======GraphAut=====");
		for (int x : ggrMap.keySet()) {
			MainLogger.info("Element order = "+Integer.toString(x));
			List<PrimeNumberGraph> gGraphList = ggrMap.get(x);
			for (PrimeNumberGraph gGraph : gGraphList) {
				gGraph.printConsole();
			}
		}
		
		System.out.println("End");
	}
	 
}