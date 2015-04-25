package Client;

import Logic.Kernel.Graph.Edge;
import Logic.Kernel.Graph.PrimeNumberGraph;
import Logic.Kernel.Graph.Vertex;

import Logic.Kernel.GraphConstructor.Concrete.FieldAutConcreteLieTypeGroupGraphConstructor;
import Logic.Kernel.GraphConstructor.Concrete.GraphAutConcreteLieTypeGroupGraphConstructor;
import Logic.Kernel.GraphConstructor.Concrete.InndiagConcreteLieTypeGroupGraphConstructor;
import Logic.Kernel.GraphConstructor.Concrete.LieTypeGroupGraphConstructor;
import Logic.Kernel.Group.LieTypeGroup;
import Logic.Kernel.Resolvers.Concrete.*;
import com.google.common.collect.Maps;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.UndirectedSparseGraph;

import java.util.List;
import java.util.Map;

/**
 * Helper с методами для конвертирования кастомных графов в Jung-овские графы
 *
 * Created by v.kolpakova on 24.04.2015.
 */
public class JungGraphConverterHelper {

    protected static int NUMERATOR = 1;

    /**
     * Метод производит построение и конвертацию графа для конкретной группы Лиева типа
     */
    protected static Map<Integer, Graph<?, ?>> convertConcreteLieTypeGroupGraph(String groupDescription) {
        Map<Integer, Graph<?, ?>> result = Maps.newHashMap();
        Graph g = new UndirectedSparseGraph();
        if (!groupDescription.isEmpty()) {
            LieTypeGroup gr = LieTypeGroupTypeResolver.resolve(groupDescription);
            LieTypeGroupGraphConstructor constructor = LieTypeGroupGraphConstructorResolver.resolve(gr);
            PrimeNumberGraph graph = constructor.constructGKGraph();
            convertToJungGraph(graph, (UndirectedSparseGraph) g);
        }
        result.put(1, g);
        return result;
    }

    /**
     * Метод производит построение и конвертацию графа Inndiag для конкретной группы Лиева типа
     */
    protected static Map<Integer, Graph<?, ?>> convertConcreteInndiagLieTypeGroupGraph(String groupDescription) {
        Map<Integer, Graph<?, ?>> result = Maps.newHashMap();
        Graph g = new UndirectedSparseGraph();
        if (!groupDescription.isEmpty()) {
            LieTypeGroup gr = LieTypeGroupTypeResolver.resolve(groupDescription);
            InndiagConcreteLieTypeGroupGraphConstructor<?> inndiagConstr = InndiagLieTypeGroupGraphConstructorResolver.resolve(gr);
            PrimeNumberGraph inndiagGraph = inndiagConstr.constructGKGraph();
            convertToJungGraph(inndiagGraph, (UndirectedSparseGraph) g);
        }
        result.put(1, g);
        return result;
    }

    /**
     * Метод производит построение и конвертацию графа P:Phi для конкретной группы Лиева типа
     */
    protected static Map<Integer, Graph<?, ?>> convertConcreteFieldAutLieTypeGroupGraph(String groupDescription) {
        Map<Integer, Graph<?, ?>> result = Maps.newHashMap();
        if (!groupDescription.isEmpty()) {
            LieTypeGroup gr = LieTypeGroupTypeResolver.resolve(groupDescription);
            FieldAutConcreteLieTypeGroupGraphConstructor<?> fieldAutConstr = FieldAutLieTypeGroupGraphConstructorResolver.resolve(gr);
            Map<Integer, List<PrimeNumberGraph>> fgrMap = fieldAutConstr.constructGraphs();
            for (Integer i : fgrMap.keySet()) {
                for (PrimeNumberGraph png : fgrMap.get(i)) {
                    Graph g = new UndirectedSparseGraph();
                    convertToJungGraph(png, (UndirectedSparseGraph) g);
                    result.put(i, g);
                }
            }
        }
        return result;
    }

    /**
     * Метод производит построение и конвертацию графа P:Gamma для конкретной группы Лиева типа
     */
    protected static Map<Integer, Graph<?, ?>> convertConcreteGammaAutLieTypeGroupGraph(String groupDescription) {
        Map<Integer, Graph<?, ?>> result = Maps.newHashMap();
        if (!groupDescription.isEmpty()) {
            LieTypeGroup gr = LieTypeGroupTypeResolver.resolve(groupDescription);
            GraphAutConcreteLieTypeGroupGraphConstructor<?> graphAutConstr = GraphAutLieTypeGroupGraphConstructorResolver.resolve(gr);
            Map<Integer, List<PrimeNumberGraph>> grMap = graphAutConstr.constructGraphs();
            for (Integer i : grMap.keySet()) {
                for (PrimeNumberGraph png : grMap.get(i)) {
                    Graph g = new UndirectedSparseGraph();
                    convertToJungGraph(png, (UndirectedSparseGraph) g);
                    result.put(i, g);
                }
            }
        }
        return result;
    }

    /**
     * Метод осуществляет непосредственно конвертацию
     * @param png --- конвертируемый граф
     * @param jg --- результат конвертации
     */
    private static void convertToJungGraph(PrimeNumberGraph png, UndirectedSparseGraph jg) {
        NUMERATOR = 1;
        List<Vertex<?>> vertices = png.getVerticesList();
        for (Vertex<?> v : vertices) {
            jg.addVertex(v.getVertex());
        }
        List<Edge> edges = png.getEdgesList();
        for (Edge e : edges) {
            jg.addEdge(NUMERATOR, e.getVertexA().getVertex(), e.getVertexB().getVertex());
            NUMERATOR ++;
        }
    }

}
