package Kernel.Graph;

import Kernel.Utils.ArithmeticUtils;

/**
 * ����� ��������� ���������� ������� ������� ����� ���������-������ --- ������� �����.
 * 
 * @author v.kolpakova
 *
 */
public class SimpleVertex extends Vertex<Integer> {

	public SimpleVertex(Integer v) {
		super(v);
	}

	@Override
	public boolean checkVertex(Integer v) {
		return ArithmeticUtils.isPrimeNumber(v);
	}
	
}