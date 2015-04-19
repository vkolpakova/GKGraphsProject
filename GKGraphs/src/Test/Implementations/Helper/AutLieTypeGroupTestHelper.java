package Test.Implementations.Helper;

import java.util.Arrays;
import java.util.List;

import Kernel.Graph.Edge;
import Kernel.Graph.SimpleVertex;
import Kernel.Graph.Vertex;

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
	 * Метод возвращает коллекцию пропарсенных ребер
	 * @param edgesStr
	 * @return
	 */
	public static List<Edge> getParsedEdjesList(String edgesStr) {
		List<String> edgesListStr = parseEdgesList(edgesStr);
		return constructEdgesList(edgesListStr);
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
	 * Метод возвращает коллекцию ребер в строковом формате. </br>
	 * Формат строки: "{a_1,b_1},{a_2,b_2},...,{a_n,b_n}"
	 * @param edgesString
	 * @return коллекция строк вида "вершина_1,вершина_2"
	 */
	public static List<String> parseEdgesList(String edgesString) {
		List<String> result = Lists.newArrayList();
		String pattern = "\\{|\\},\\{|\\}";
		result.addAll(Arrays.asList(edgesString.split(pattern)));
		if (result.contains(EMPTY_STRING)) {
			result.remove(EMPTY_STRING);
		}
		return result;
	}
	
}