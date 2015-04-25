package Client;

import Logic.Kernel.Graph.Edge;
import Logic.Kernel.Graph.PrimeNumberGraph;
import Logic.Kernel.Graph.Vertex;

import Logic.Kernel.GraphConstructor.Concrete.InndiagConcreteLieTypeGroupGraphConstructor;
import Logic.Kernel.GraphConstructor.Concrete.LieTypeGroupGraphConstructor;
import Logic.Kernel.Group.LieTypeGroup;
import Logic.Kernel.Resolvers.Concrete.*;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.UndirectedSparseGraph;

import java.util.List;

/**
 * Helper с методами для конвертирования кастомных графов в Jung-овские графы
 *
 * Created by v.kolpakova on 24.04.2015.
 */
public class JungGraphConverterHelper {

    protected static int NUMERATOR = 1;

    /**
     * Метод производит построение графа для конкретной группы Лиева типа
     */
    protected static Graph<?, ?> convertConcreteLieTypeGroupGraph(String groupDescription) {
        Graph g = new UndirectedSparseGraph();
        if (!groupDescription.isEmpty()) {
            LieTypeGroup gr = LieTypeGroupTypeResolver.resolve(groupDescription);
            LieTypeGroupGraphConstructor constructor = LieTypeGroupGraphConstructorResolver.resolve(gr);
            PrimeNumberGraph graph = constructor.constructGKGraph();
            convertToJungGraph(graph, (UndirectedSparseGraph) g);
        }
        return g;
    }

    /**
     * Метод производит построение графа Inndiag для конкретной группы Лиева типа
     */
    protected static Graph<?, ?> convertConcreteInndiagLieTypeGroupGraph(String groupDescription) {
        Graph g = new UndirectedSparseGraph();
        if (!groupDescription.isEmpty()) {
            LieTypeGroup gr = LieTypeGroupTypeResolver.resolve(groupDescription);
            InndiagConcreteLieTypeGroupGraphConstructor<?> inndiagConstr = InndiagLieTypeGroupGraphConstructorResolver.resolve(gr);
            PrimeNumberGraph inndiagGraph = inndiagConstr.constructGKGraph();
            convertToJungGraph(inndiagGraph, (UndirectedSparseGraph) g);
        }
        return g;
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
