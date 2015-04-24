package Logic.Kernel.FullInfoCollector;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import Logic.Kernel.Graph.Edge;
import Logic.Kernel.Graph.PrimeNumberGraph;
import Logic.Kernel.GraphConstructor.Concrete.FieldAutConcreteLieTypeGroupGraphConstructor;
import Logic.Kernel.GraphConstructor.Concrete.GraphAutConcreteLieTypeGroupGraphConstructor;
import Logic.Kernel.GraphConstructor.Concrete.InndiagConcreteLieTypeGroupGraphConstructor;
import Logic.Kernel.GraphConstructor.Concrete.LieTypeGroupGraphConstructor;
import Logic.Kernel.Group.LieTypeGroup;
import Logic.Kernel.Resolvers.Concrete.FieldAutLieTypeGroupGraphConstructorResolver;
import Logic.Kernel.Resolvers.Concrete.GraphAutLieTypeGroupGraphConstructorResolver;
import Logic.Kernel.Resolvers.Concrete.InndiagLieTypeGroupGraphConstructorResolver;
import Logic.Kernel.Resolvers.Concrete.LieTypeGroupGraphConstructorResolver;
import Logic.Kernel.Resolvers.Concrete.LieTypeGroupTypeResolver;
import Logic.Kernel.Utils.MainLogger;

/**
 * Класс, предоставляющий полный отчет о графах конкретной группы, всех видах расширений и группы всех её автоморфизмах.
 * На входе - только обозначение конкретной группы.
 * 
 * @author v.kolpakova
 *
 */
public class ConcreteFullInfoCollector {
	
	protected static final String EMPTY_STRING = "";
	protected static final String CURRENT_GROUP_NAME = "A_2(512)";
	
	/**
	 * Метод производит построение графов для конкретной группы Лиева типа
	 */
	protected void processConcreteLieTypeGroup(String groupName) {
		MainLogger.loggerOff();
		LieTypeGroup gr = LieTypeGroupTypeResolver.resolve(groupName);
		Set<Edge> addedEdges = Sets.newHashSet();
		GraphsStringRepresentation representation = new GraphsStringRepresentation();
		representation.setGroupName(groupName);
		
		// построение графа простой группы P Лиева типа
		LieTypeGroupGraphConstructor constr = LieTypeGroupGraphConstructorResolver.resolve(gr);
		PrimeNumberGraph graph = constr.constructGKGraph();
		representation.setGroupGraphRepr(graph.getCompactGraphRepresentation());
		
		// построение графа Inndiag(P)
		InndiagConcreteLieTypeGroupGraphConstructor<?> inndiagConstr = InndiagLieTypeGroupGraphConstructorResolver.resolve(gr);
		PrimeNumberGraph inndiagGraph = inndiagConstr.constructGKGraph();
		addedEdges.addAll(inndiagConstr.getAddedEdgesList());
		representation.setInndiagGraphRepr(inndiagGraph.getCompactGraphRepresentation());
		
		// построение графов вида Inndiag(P)<f>, f --- полевой автоморфизм P
		FieldAutConcreteLieTypeGroupGraphConstructor<?> fieldConstr = FieldAutLieTypeGroupGraphConstructorResolver.resolve(gr);
		Map<Integer, List<PrimeNumberGraph>> fgrMap = fieldConstr.constructGraphs();
		addedEdges.addAll(fieldConstr.getAddedEdgesList());
		for (int x : fgrMap.keySet()) {
			StringBuilder strBuilder = new StringBuilder();
			strBuilder.append("Element order = ").append(Integer.toString(x)).append("; ");
			List<PrimeNumberGraph> fGraphList = fgrMap.get(x);
			for (PrimeNumberGraph fGraph : fGraphList) {
				strBuilder.append(fGraph.getCompactGraphRepresentation());
			}
			representation.addFieldGraphsRepr(strBuilder.toString());
		}
		
		// построение графов вида Inndiag(P)<g>, g --- графовый автоморфизм P
		GraphAutConcreteLieTypeGroupGraphConstructor<?> graphConstr = GraphAutLieTypeGroupGraphConstructorResolver.resolve(gr);
		Map<Integer, List<PrimeNumberGraph>> ggrMap = graphConstr.constructGraphs();
		addedEdges.addAll(graphConstr.getAddedEdgesList());
		for (int x : ggrMap.keySet()) {
			StringBuilder strBuilder = new StringBuilder();
			strBuilder.append("Element order = " + Integer.toString(x) + "; ");
			List<PrimeNumberGraph> gGraphList = ggrMap.get(x);
			for (PrimeNumberGraph gGraph : gGraphList) {
				strBuilder.append(gGraph.getCompactGraphRepresentation());
			}
			representation.addGraphGraphsRepr(strBuilder.toString());
		}
		
		// построение итогового графа Aut(P)
		PrimeNumberGraph autGraph = constructFullAutGroupEdges(gr, Lists.newArrayList(addedEdges));
		representation.setAutGraphRepr(autGraph.getCompactGraphRepresentation());
		
		// печать результата
		MainLogger.loggerOn();
		representation.printFillInfo();
	}
	
	/**
	 * Метод строит граф простых чисел группы Aut(P) на основе группы P и добавленных ребер
	 * @param group --- группа P
	 * @param addedEdges --- коллекция добавленных ребер для всех расширений
	 */
	private PrimeNumberGraph constructFullAutGroupEdges(LieTypeGroup group, List<Edge> addedEdges) {
		List<Edge> fullAutGroupEdges = Lists.newArrayList(group.getGraph().getEdgesList());
		fullAutGroupEdges.addAll(addedEdges);
		PrimeNumberGraph result = new PrimeNumberGraph(group.getGraph().getVerticesList(), fullAutGroupEdges);
		return result;
	}
	
	@Test
	public void collectInfoForCurrentGroup() {
		processConcreteLieTypeGroup(CURRENT_GROUP_NAME);
	}
	
	/**
	 * Внутреннее представление, аккумулирующая информацию о графах простых чисел расширений группы её автоморфизмами
	 *
	 */
	protected static class GraphsStringRepresentation {
		
		private String groupName = EMPTY_STRING;
		private String groupGraphRepr = EMPTY_STRING;
		private String inndiagGraphRepr = EMPTY_STRING;
		private List<String> fieldGraphsRepr = Lists.newArrayList();
		private List<String> graphGraphsRepr = Lists.newArrayList();
		private String autGraphRepr = EMPTY_STRING;
		
		protected void setGroupName(String groupName) {
			this.groupName = groupName;
		}
		
		protected void setGroupGraphRepr(String groupGraphRepr) {
			this.groupGraphRepr = groupGraphRepr;
		}
		
		protected void setInndiagGraphRepr(String inndiagGraphRepr) {
			this.inndiagGraphRepr = inndiagGraphRepr;
		}
		
		protected void addFieldGraphsRepr(String fieldGraphRepr) {
			this.fieldGraphsRepr.add(fieldGraphRepr);
		}
		
		protected void addGraphGraphsRepr(String graphGraphRepr) {
			this.graphGraphsRepr.add(graphGraphRepr);
		}
		
		protected void setAutGraphRepr(String autGraphRepr) {
			this.autGraphRepr = autGraphRepr;
		}
		
		/**
		 * Метод печатает отчет, состоящий из:
		 * <li> графа группы;
		 * <li> графа Inndiag;
		 * <li> графа расширения Phi;
		 * <li> графа расширения Gamma;
		 * <li> графа Aut.
		 */
		protected void printFillInfo() {
			MainLogger.info("=======Group=======");
			MainLogger.info("Group name: " + this.groupName);
			MainLogger.info(groupGraphRepr);
			
			MainLogger.info("=======Inndiag=======");
			MainLogger.info("Group name: Inndiag(" + groupName + ")");
			MainLogger.info(inndiagGraphRepr);
			
			MainLogger.info("========FieldAut=======");
			MainLogger.info("Group name: Inndiag(" + groupName + ")Phi");
			for (String fieldGraphRepr : fieldGraphsRepr) {
				MainLogger.info(fieldGraphRepr);
			}
			
			MainLogger.info("========GraphAut=======");
			MainLogger.info("Group name: Inndiag(" + groupName + ")Gamma");
			for (String graphGraphRepr : graphGraphsRepr) {
				MainLogger.info(graphGraphRepr);
			}
			
			MainLogger.info("========Aut=======");
			MainLogger.info("Group name: Aut(" + groupName + ")");
			MainLogger.info(autGraphRepr);
		}
		
	}
	
}