package Logic.Test.Implementations.Helper;

import java.util.List;

import Logic.Kernel.Graph.Edge;
import Logic.Kernel.Graph.SimpleVertex;
import Logic.Kernel.Graph.Vertex;

import Logic.Test.Helper.CommonTestHelper;
import com.google.common.collect.Lists;

public class AutLieTypeGroupTestHelper {
	
	public static final String EMPTY_STRING = "";
	
	/**
	 * Метод возвращает коллекцию пропарсенных вершин. </br>
	 * Формат строки: "a_1,a_2,...,a_n"
	 * @param verticesStr
	 * @return
	 */
	public static List<Vertex<?>> getParsedVerticesList(String verticesStr) {
		List<Vertex<?>> result = Lists.newArrayList();
		String[] verticesStrArray = verticesStr.split(",");
		for (String vertexStr : verticesStrArray) {
			SimpleVertex sv = new SimpleVertex(Integer.parseInt(vertexStr));
			result.add(sv);
		}
		return result;
	}
	
	/**
	 * Метод строит список вершин из их строкового представления
	 * @param edgesListStr
	 * @return
	 */
	public static List<Edge> constructEdgesList(List<String> edgesListStr) {
		List<Edge> result = Lists.newArrayList();
		for (String edgeStr : edgesListStr) {
			String [] vertices = edgeStr.split(",");
			result.add(new Edge(new SimpleVertex(Integer.parseInt(vertices[0])), new SimpleVertex(Integer.parseInt(vertices[1]))));
		}
		return result;
	}

	/**
	 * Метод возвращает коллекцию пропарсенных ребер
	 * @param edgesStr
	 * @return
	 */
	public static List<Edge> getParsedEdgesList(String edgesStr) {
		List<String> edgesListStr = CommonTestHelper.parseEdgesList(edgesStr);
		return constructEdgesList(edgesListStr);
	}

}