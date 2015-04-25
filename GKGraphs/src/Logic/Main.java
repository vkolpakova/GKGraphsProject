package Logic;

import java.util.List;
import java.util.Map;

import Logic.Kernel.Graph.PrimeNumberGraph;
import Logic.Kernel.GraphConstructor.Concrete.FieldAutConcreteLieTypeGroupGraphConstructor;
import Logic.Kernel.GraphConstructor.Concrete.GraphAutConcreteLieTypeGroupGraphConstructor;
import Logic.Kernel.GraphConstructor.Concrete.InndiagConcreteLieTypeGroupGraphConstructor;
import Logic.Kernel.GraphConstructor.Concrete.LieTypeGroupGraphConstructor;
import Logic.Kernel.GraphConstructor.Series.GraphAutSeriesGraphConstructor;
import Logic.Kernel.GraphConstructor.Series.InndiagSeriesGraphConstructor;
import Logic.Kernel.GraphConstructor.Series.SeriesGraphConstructor;
import Logic.Kernel.Group.LieTypeGroup;
import Logic.Kernel.Group.Series;
import Logic.Kernel.Resolvers.Concrete.FieldAutLieTypeGroupGraphConstructorResolver;
import Logic.Kernel.Resolvers.Concrete.GraphAutLieTypeGroupGraphConstructorResolver;
import Logic.Kernel.Resolvers.Concrete.InndiagLieTypeGroupGraphConstructorResolver;
import Logic.Kernel.Resolvers.Concrete.LieTypeGroupGraphConstructorResolver;
import Logic.Kernel.Resolvers.Concrete.LieTypeGroupTypeResolver;
import Logic.Kernel.Resolvers.Series.GraphSeriesGraphConstructorResolver;
import Logic.Kernel.Resolvers.Series.InndiagSeriesGraphConstructorResolver;
import Logic.Kernel.Resolvers.Series.SeriesGraphConstructorResolver;
import Logic.Kernel.Resolvers.Series.SeriesResolver;
import Logic.Kernel.Utils.MainLogger;

public class Main {
	
	public static void main(String args[]) {
		System.out.println("Start");
		//processConcreteLieTypeGroup();
		processSeries();
		System.out.println("End");
	}
	
	/**
	 * Метод производит построение графов для конкретной группы Лиева типа
	 */
	protected static void processConcreteLieTypeGroup() {
		LieTypeGroup gr = LieTypeGroupTypeResolver.resolve("A_5(3)");
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
	
	/**
	 * Метод производит построение графов для некоторой серии групп Лиева типа
	 */
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
