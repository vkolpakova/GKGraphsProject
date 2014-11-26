import java.util.Map;

import Kernel.Graph.PrimeNumberGraph;
import Kernel.GraphConstructor.FieldAutConcreteLieTypeGroupGraphConstructor;
import Kernel.GraphConstructor.InndiagConcreteLieTypeGroupGraphConstructor;
import Kernel.GraphConstructor.LieTypeGroupGraphConstructor;
import Kernel.Group.LieTypeGroup;
import Kernel.Resolvers.FieldAutLieTypeGroupGraphConstructorResolver;
import Kernel.Resolvers.InndiagLieTypeGroupGraphConstructorResolver;
import Kernel.Resolvers.LieTypeGroupGraphConstructorResolver;
import Kernel.Resolvers.LieTypeGroupTypeResolver;
import Kernel.Utils.MainLogger;

public class Main {
	
	public static void main(String args[]) {
		System.out.println("Start");
		LieTypeGroup gr = LieTypeGroupTypeResolver.resolve("A_1(1024)");
		LieTypeGroupGraphConstructor constr = LieTypeGroupGraphConstructorResolver.resolve(gr);
		PrimeNumberGraph graph = constr.constructGKGraph();
		gr.setGraph(graph);
		MainLogger.info("=====Group=====");
		graph.printConsole();
		InndiagConcreteLieTypeGroupGraphConstructor<?> inndiagConstr = InndiagLieTypeGroupGraphConstructorResolver.resolve(gr);
		PrimeNumberGraph inndiagGraph = inndiagConstr.constructGKGraph();
		MainLogger.info("=====Inndiag=====");
		inndiagGraph.printConsole();
		FieldAutConcreteLieTypeGroupGraphConstructor<?> fieldConstr = FieldAutLieTypeGroupGraphConstructorResolver.resolve(gr);
		Map<Integer, PrimeNumberGraph> grMap = fieldConstr.constructGraphs();
		MainLogger.info("======FieldAut=====");
		for (int x : grMap.keySet()) {
			MainLogger.info("Element order = "+Integer.toString(x));
			PrimeNumberGraph fGraph = grMap.get(x);
			fGraph.printConsole();
		}
		System.out.println("End");
	}
	 
}