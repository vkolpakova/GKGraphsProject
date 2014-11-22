package Kernel.Graph;

/**
 * Класс объекта, представляющего собой вершину в графе Грюнберга --- Кегеля конечной группы. </br>
 * Вершины могут быть как целыми числами, так и символами, обозначающими некоторое простое число.
 * 
 * @author v.kolpakova
 *
 */
public abstract class Vertex<E> {
	
	/**
	 * Значение
	 */
	private E v;
	
	public Vertex(E v) {
		this.v = v;
	}
	
	public void setVertex(E v) {
		this.v = v;
	}
	
	public E getVertex() {
		return this.v;
	}
	
	/**
	 * ����� ������������ ��������, �������� �� �������� ������� ����������.
	 * @param v
	 * @return true, ���� �������� ���������, false � ��������� ������
	 */
	public abstract boolean checkVertex(E v);
	
	@Override
	public boolean equals(Object arg0) {
		if (arg0 instanceof Vertex) {
			Vertex<?> vert = (Vertex<?>) arg0;
			return this.v.equals(vert.getVertex());
		}
		return false;
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
	
}