package Kernel.Graph;

/**
 * ����� ��������� ������� ���� String (������, ������������ ������� �����).
 * 
 * @author v.kolpakova
 *
 */
public class SymbolVertex extends Vertex<String> {

	public SymbolVertex(String v) {
		super(v);
	}

	@Override
	public boolean checkVertex(String v) {
		return true;
	}
	
}