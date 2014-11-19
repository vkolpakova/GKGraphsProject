package Kernel.Graph;

/**
 * �����, ����������� ������� ����� ���������-������. </br>
 * �������� �������� ���� ������� �����, ���� ������, ������������ ������� �����.
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
	
}