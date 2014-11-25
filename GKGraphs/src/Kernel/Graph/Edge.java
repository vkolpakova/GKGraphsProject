package Kernel.Graph;

/**
 * Класс, представляющий ребро графа Грюнберга-Кегеля </br>
 * 
 * @author v.kolpakova
 */
public class Edge {
	
	/**
	 * Вершина a
	 */
	private Vertex<?> a;
	
	/**
	 * Вершина b
	 */
	private Vertex<?> b;
	
	public Edge(Vertex<?> a, Vertex<?> b) {
		super();
		this.a = a;
		this.b = b;
	}

	public Vertex<?> getVertexA() {
		return a;
	}

	public void setVertexA(Vertex<?> a) {
		this.a = a;
	}

	public Vertex<?> getVertexB() {
		return b;
	}

	public void setVertexB(Vertex<?> b) {
		this.b = b;
	}
	
	@Override
	public boolean equals(Object arg0) {
		if (arg0 instanceof Edge) {
			Edge edge = (Edge) arg0;
			// ребра ненаправленные
			return ((this.a.equals(edge.getVertexA()) && this.b.equals(edge.getVertexB())) ||
					(this.a.equals(edge.getVertexB()) && this.b.equals(edge.getVertexA())));
		}
		return false;
	}
	
}