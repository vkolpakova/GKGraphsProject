package Client.Series;

import Client.Concrete.JungGraphConverterHelper;
import Logic.Kernel.Graph.PrimeNumberGraph;
import Logic.Kernel.GraphConstructor.Series.GraphAutSeriesGraphConstructor;
import Logic.Kernel.Group.Series;
import Logic.Kernel.Resolvers.Series.GraphSeriesGraphConstructorResolver;
import Logic.Kernel.Resolvers.Series.InndiagSeriesGraphConstructorResolver;
import Logic.Kernel.Resolvers.Series.SeriesGraphConstructorResolver;
import Logic.Kernel.Resolvers.Series.SeriesResolver;
import com.google.common.collect.Maps;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.UndirectedSparseGraph;

import java.util.List;
import java.util.Map;

/**
 * Helper ��� ���������� � ����������� ������ ������� ����� ����� �� �������
 *
 * Created by v.kolpakova on 08.05.2015.
 */
public class JungSeriesConverterHelper {

    /**
     * ����� ���������� ���������� � ����������� ����� ������� ����� ��������� �����
     */
    public static Map<Integer, Graph<?, ?>> convertSeriesGraph(String groupDescription) {
        Map<Integer, Graph<?, ?>> result = Maps.newHashMap();
        Graph g = new UndirectedSparseGraph();
        if (!groupDescription.isEmpty()) {
            Series series = SeriesResolver.resolve(groupDescription);
            PrimeNumberGraph sg = SeriesGraphConstructorResolver.resolve(series).constructGKGraph();
            JungGraphConverterHelper.convertToJungGraph(sg, (UndirectedSparseGraph) g);
        }
        result.put(1, g);
        return result;
    }

    /**
     * ����� ���������� ���������� � ����������� ����� Inndiag ��������� �����
     */
    public static Map<Integer, Graph<?, ?>> convertInndiagSeriesGraph(String groupDescription) {
        Map<Integer, Graph<?, ?>> result = Maps.newHashMap();
        Graph g = new UndirectedSparseGraph();
        if (!groupDescription.isEmpty()) {
            Series series = SeriesResolver.resolve(groupDescription);
            List<PrimeNumberGraph> pngs = InndiagSeriesGraphConstructorResolver.resolve(series).constructGKGraphs();
            for (PrimeNumberGraph png : pngs) {
                Graph gr = new UndirectedSparseGraph();
                JungGraphConverterHelper.convertToJungGraph(png, (UndirectedSparseGraph) gr);
                result.put(1, gr);
            }
            return result;
        }
        result.put(1, g);
        return result;
    }

    /**
     * ����� ������ � ������������ ����� ���������� ������ �������� �������������
     */
    public static Map<Integer, Graph<?, ?>> convertGraphAutSeriesGraph(String groupDescription) {
        Map<Integer, Graph<?, ?>> result = Maps.newHashMap();
        Graph g = new UndirectedSparseGraph();
        if (!groupDescription.isEmpty()) {
            Series series = SeriesResolver.resolve(groupDescription);
            GraphAutSeriesGraphConstructor constructor = GraphSeriesGraphConstructorResolver.resolve(series);
            Map<Integer, List<PrimeNumberGraph>> grMap = constructor.getGraphsMap();
            for (Integer key : grMap.keySet()) {
                for (PrimeNumberGraph png : grMap.get(key)) {
                    Graph<?, ?> jg = new UndirectedSparseGraph();
                    JungGraphConverterHelper.convertToJungGraph(png, (UndirectedSparseGraph) jg);
                    result.put(key, jg);
                }
            }
        return result;
        }
        result.put(1, g);
        return result;
    }

}
