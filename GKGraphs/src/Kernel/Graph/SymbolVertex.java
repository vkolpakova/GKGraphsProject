package Kernel.Graph;

/**
 * Вершина графа Грюнберга --- Кегеля в строковом формате. Может предсталять собой:
 * <ol>
 * <li> Простое число.
 * <li> Символ, обозначающий простое число.
 * </ol>
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