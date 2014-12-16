import java.util.List;
import java.util.Map;

import Kernel.Graph.PrimeNumberGraph;
import Kernel.GraphConstructor.Concrete.FieldAutConcreteLieTypeGroupGraphConstructor;
import Kernel.GraphConstructor.Concrete.GraphAutConcreteLieTypeGroupGraphConstructor;
import Kernel.GraphConstructor.Concrete.InndiagConcreteLieTypeGroupGraphConstructor;
import Kernel.GraphConstructor.Concrete.LieTypeGroupGraphConstructor;
import Kernel.GraphConstructor.Series.GraphAutSeriesGraphConstructor;
import Kernel.GraphConstructor.Series.InndiagSeriesGraphConstructor;
import Kernel.GraphConstructor.Series.SeriesGraphConstructor;
import Kernel.Group.LieTypeGroup;
import Kernel.Group.Series;
import Kernel.Resolvers.Concrete.FieldAutLieTypeGroupGraphConstructorResolver;
import Kernel.Resolvers.Concrete.GraphAutLieTypeGroupGraphConstructorResolver;
import Kernel.Resolvers.Concrete.InndiagLieTypeGroupGraphConstructorResolver;
import Kernel.Resolvers.Concrete.LieTypeGroupGraphConstructorResolver;
import Kernel.Resolvers.Concrete.LieTypeGroupTypeResolver;
import Kernel.Resolvers.Series.GraphSeriesGraphConstructorResolver;
import Kernel.Resolvers.Series.InndiagSeriesGraphConstructorResolver;
import Kernel.Resolvers.Series.SeriesGraphConstructorResolver;
import Kernel.Resolvers.Series.SeriesResolver;
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
		gr.setGraph(graph); // Это важно!!! Используется при построении расширений автоморфизмами
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
		String seriesStr = "A_2(p),pi(q - 1) = {2, r, s}, pi(q + 1) = {2, 3}, pi((q^2 + q + 1) / (3, q - 1)) = {u}";
		// построение графа группы, принадлежащей некоторой серии
		Series series = SeriesResolver.resolve(seriesStr);
		SeriesGraphConstructor constr = SeriesGraphConstructorResolver.resolve(series);
		PrimeNumberGraph grGraph = constr.constructGKGraph();
		series.setGraph(grGraph); // Это важно!!! Используется при построении расширений автоморфизмами
		MainLogger.info("=====Group=====");
		grGraph.printConsole();
		// построение графа Inndiag(P)
		InndiagSeriesGraphConstructor inndiagConstr = InndiagSeriesGraphConstructorResolver.resolve(series);
		List<PrimeNumberGraph> inndiagGraphs = inndiagConstr.constructGKGraphs();
		for (PrimeNumberGraph inndiagGraph : inndiagGraphs) {
			MainLogger.info("=====Inndiag=====");
			inndiagGraph.printConsole();
		}
		// построение графов вида Inndiag(P)<g>, g --- графовый автоморфизм P
		GraphAutSeriesGraphConstructor graphConstr = GraphSeriesGraphConstructorResolver.resolve(series);
		List<PrimeNumberGraph> graphGraphs = graphConstr.constructGKGraphs();
		for (PrimeNumberGraph graphGraph : graphGraphs) {
			MainLogger.info("======GraphAut=====");
			graphGraph.printConsole();
		}
	}
	 
}
