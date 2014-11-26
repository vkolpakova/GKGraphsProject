import Kernel.Graph.PrimeNumberGraph;
import Kernel.GraphConstructor.InndiagConcreteLieTypeGroupGraphConstructor;
import Kernel.GraphConstructor.LieTypeGroupGraphConstructor;
import Kernel.Group.LieTypeGroup;
import Kernel.Resolvers.InndiagLieTypeGroupGraphConstructorResolver;
import Kernel.Resolvers.LieTypeGroupGraphConstructorResolver;
import Kernel.Resolvers.LieTypeGroupTypeResolver;
import Kernel.Utils.MainLogger;

public class Main {
	
	public static void main(String args[]) {
		System.out.println("Start");
		LieTypeGroup gr = LieTypeGroupTypeResolver.resolve("B_2(27)");
		LieTypeGroupGraphConstructor constr = LieTypeGroupGraphConstructorResolver.resolve(gr);
		PrimeNumberGraph graph = constr.constructGKGraph();
		gr.setGraph(graph);
		MainLogger.info("==Group==");
		graph.printConsole();
		InndiagConcreteLieTypeGroupGraphConstructor<?> inndiagConstr = InndiagLieTypeGroupGraphConstructorResolver.resolve(gr);
		PrimeNumberGraph inndiagGraph = inndiagConstr.constructGKGraph();
		MainLogger.info("==Inndiag==");
		inndiagGraph.printConsole();
		System.out.println("End");
	}
	 
}