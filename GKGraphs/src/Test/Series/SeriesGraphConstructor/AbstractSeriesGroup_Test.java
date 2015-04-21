package Test.Series.SeriesGraphConstructor;

import Kernel.Graph.Edge;
import Kernel.Graph.PrimeNumberGraph;
import Kernel.Graph.SymbolVertex;
import Kernel.Graph.Vertex;
import Kernel.GraphConstructor.Series.SeriesGraphConstructor;
import Kernel.Group.Series;
import Kernel.Resolvers.Series.SeriesGraphConstructorResolver;
import Kernel.Resolvers.Series.SeriesResolver;
import Test.Helper.CommonTestHelper;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * Абстрактный класс тестирования серий.
 *
 * Created by v.kolpakova on 21.04.2015.
 */
public class AbstractSeriesGroup_Test {

    protected Series series;
    protected PrimeNumberGraph graph;

    /**
     * Первоначальная инициализация тестовых данных на основе входящей строки описаний серии
     * @param inputString --- строковое представление серии
     */
    protected void determineGroupWithGraph(String inputString) {
        this.series = SeriesResolver.resolve(inputString);
        SeriesGraphConstructor constructor = SeriesGraphConstructorResolver.resolve(this.series);
        this.graph = constructor.constructGKGraph();
    }

    /**
     * Основная проверка теста: вычисленный граф сравнивается с исходным. Критерии проверки:
     * <ol>
     *     <li>Совпадение множества вершин.</li>
     *     <li>Совпадение множества ребер.</li>
     * </ol>
     * @param inputString --- строковое представление серии
     * @param vList --- проверяемое множество вершин
     * @param eList --- проверяемое множество ребер
     * @return
     */
    protected boolean checkEquality(String inputString, String vString, String eString) {
        determineGroupWithGraph(inputString);
        List<Vertex<?>> parsedVertices = getParsedVertexList(vString);
        List<Edge> parsedEdges = getParsedEdgesList(eString);
        PrimeNumberGraph parsedGraph = new PrimeNumberGraph(parsedVertices, parsedEdges);
        boolean result = this.graph.equals(parsedGraph);
        if (!result) {
            CommonTestHelper.printDiff(parsedGraph, this.graph);
            return false;
        } else {
            return true;
        }
    }

    /**
     * Парсинг строки с вершинами.
     * @param vString --- исходная строка формата "a_1,...,a_n"
     * @return коллекция вершин
     */
    private List<Vertex<?>> getParsedVertexList(String vString) {
        List<Vertex<?>> result = Lists.newArrayList();
        String[] verticesStrArray = vString.split(",");
        for (String vertexStr : verticesStrArray) {
            SymbolVertex sv = new SymbolVertex(vertexStr);
            result.add(sv);
        }
        return result;
    }

    /**
     * Парсинг строки с ребрами.
     * @param eString --- исходная строка формата "{a_1,b_1},...,{a_n,b_n}"
     * @return коллекция ребер
     */
    private List<Edge> getParsedEdgesList(String eString) {
        List<Edge> result = Lists.newArrayList();
        List<String> parsedEStringList = CommonTestHelper.parseEdgesList(eString);
        for (String parsedEStr : parsedEStringList) {
            String[] verticesStr = parsedEStr.split(",");
            result.add(new Edge(new SymbolVertex(verticesStr[0]), new SymbolVertex(verticesStr[1])));
        }
        return result;
    }

}
