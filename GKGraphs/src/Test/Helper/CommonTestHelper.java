package Test.Helper;

import Kernel.Graph.Edge;
import Kernel.Graph.PrimeNumberGraph;
import Kernel.Graph.Vertex;
import Kernel.Utils.MainLogger;
import Test.Implementations.Helper.AutLieTypeGroupTestHelper;
import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.List;

/**
 * Helper, в котором собраны все общие методы для тестирования конкретных групп или серий.
 *
 * @author v.kolpakova
 */
public class CommonTestHelper {

    /**
     * Метод возвращает коллекцию ребер в строковом формате. </br>
     * Формат строки: "{a_1,b_1},{a_2,b_2},...,{a_n,b_n}"
     *
     * @param edgesString
     * @return коллекция строк вида "вершина_1,вершина_2"
     */
    public static List<String> parseEdgesList(String edgesString) {
        List<String> result = Lists.newArrayList();
        String pattern = "\\{|\\},\\{|\\}";
        result.addAll(Arrays.asList(edgesString.split(pattern)));
        if (result.contains(AutLieTypeGroupTestHelper.EMPTY_STRING)) {
            result.remove(AutLieTypeGroupTestHelper.EMPTY_STRING);
        }
        return result;
    }

    /**
     * Метод выводит результаты сравнения двух графов в случае, если они отличаются
     * @param origGraph --- проверяемый граф
     * @param compGraph --- вычисленный граф
     */
    public static void printDiff(PrimeNumberGraph origGraph, PrimeNumberGraph compGraph) {
        List<Vertex<?>> oVertices = origGraph.getVerticesList();
        List<Vertex<?>> cVertices = compGraph.getVerticesList();
        if (!oVertices.equals(cVertices)) {
            MainLogger.info("ERROR : vertices sets are not equal!");
            return;
        }
        List<Edge> oEdges = origGraph.getEdgesList();
        List<Edge> cEdges = compGraph.getEdgesList();
        for (Edge e : oEdges) {
            if (!cEdges.contains(e)) {
                MainLogger.info("В оригинальном графе лишнее ребро "  + "{" + e.getVertexA().getVertex() + "," + e.getVertexB().getVertex() + "}");
            }
        }
        for (Edge e : cEdges) {
            if (!oEdges.contains(e)) {
                MainLogger.info("В оригинальном графе отсутствует ребро "  + "{" + e.getVertexA().getVertex() + "," + e.getVertexB().getVertex() + "}");
            }
        }
    }

}