package Kernel.Polynom;

/**
 * Класс представляет объекты - простые полиномы вида q^n + epsilon1, где n --- натуральное число, epsilon = +/-.
 * @author v.kolpakova
 *
 */
public class SimplePolynom {
	
	public static final String PLUS = "+";
	public static final String MINUS = "-";
	
	/**
	 * Знак
	 */
	protected String epsilon;
	
	/**
	 * Степень
	 */
	protected int n;
	
	public SimplePolynom(String epsilon, int n) {
		super();
		this.epsilon = epsilon;
		this.n = n;
	}
	
	public String getEpsilon() {
		return epsilon;
	}
	
	public void setEpsilon(String epsilon) {
		this.epsilon = epsilon;
	}
	
	public int getN() {
		return n;
	}
	
	public void setN(int n) {
		this.n = n;
	}
	
}