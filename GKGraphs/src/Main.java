import java.util.List;
import java.util.Map;

import Kernel.Graph.PrimeNumberGraph;
import Kernel.GraphConstructor.FieldAutConcreteLieTypeGroupGraphConstructor;
import Kernel.GraphConstructor.GraphAutConcreteLieTypeGroupGraphConstructor;
import Kernel.GraphConstructor.InndiagConcreteLieTypeGroupGraphConstructor;
import Kernel.GraphConstructor.LieTypeGroupGraphConstructor;
import Kernel.GraphConstructor.SeriesGraphConstructor;
import Kernel.Group.LieTypeGroup;
import Kernel.Group.Series;
import Kernel.Resolvers.FieldAutLieTypeGroupGraphConstructorResolver;
import Kernel.Resolvers.GraphAutLieTypeGroupGraphConstructorResolver;
import Kernel.Resolvers.InndiagLieTypeGroupGraphConstructorResolver;
import Kernel.Resolvers.LieTypeGroupGraphConstructorResolver;
import Kernel.Resolvers.LieTypeGroupTypeResolver;
import Kernel.Resolvers.SeriesGraphConstructorResolver;
import Kernel.Resolvers.SeriesResolver;
import Kernel.Utils.MainLogger;

public class Main {
	
	public static void main(String args[]) {
		System.out.println("Start");
		//processConcreteLieTypeGroup();
		processSeries();
		System.out.println("End");
	}
	
	protected static void processConcreteLieTypeGroup() {
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
	}
	
	protected static void processSeries() {
		String seriesStr = "G_2(p),pi(q - 1) = {2, 3}, pi(q + 1) = {u}, pi((q^2 + q + 1) / (3, q - 1)) = {r, s}, pi((q^2 - q + 1) / (3, q + 1)) = {t}";
		// построение графа группы, принадлежащей некоторой серии
		Series series = SeriesResolver.resolve(seriesStr);
		SeriesGraphConstructor constr = SeriesGraphConstructorResolver.resolve(series);
		PrimeNumberGraph grGraph = constr.constructGKGraph();
		grGraph.printConsole();
	}
	 
}
