package Logic.Kernel.Graph;

import Logic.Kernel.Utils.ArithmeticUtils;

/**
 * Вершина графа Грюнберга --- Кегеля, представляющая собой простое число.
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