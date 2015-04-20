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
	
	public static final String TWO = "2";
	public static final String THREE = "3";
	public static final String P = "p";
	public static final String Q = "q";
	public static final String M = "m";
	public static final String LEFT_BRACE = "{";
	public static final String RIGHT_BRACE = "}";

	public SymbolVertex(String v) {
		super(v);
	}

	@Override
	public boolean checkVertex(String v) {
		return true;
	}
	
	@Override
	public boolean equals(Object arg0) {
		// TODO проверить
		return this.getVertex().equals(((SymbolVertex)arg0).getVertex());
	}
	
}