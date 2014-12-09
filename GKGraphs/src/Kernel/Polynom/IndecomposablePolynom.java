package Kernel.Polynom;

import java.util.List;

/**
 * Класс, реализующий неразложимый полином над R. </br>
 * Полином имеет заданный вид и множество простых делителей (м.б. как действительными числами, так и символами).
 * 
 * @author v.kolpakova
 *
 */
public class IndecomposablePolynom {
	
	/**
	 * Строковое представление полинома
	 */
	protected String description;
	
	/**
	 * Множество простых делителей
	 */
	protected List<String> simpleDevisors;
	
	public IndecomposablePolynom(String description, List<String> simpleDevisors) {
		super();
		this.description = description;
		this.simpleDevisors = simpleDevisors;
	}
	
	public IndecomposablePolynom(IndecomposablePolynom poly) {
		super();
		this.description = poly.description;
		this.simpleDevisors = poly.simpleDevisors;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<String> getSimpleDevisors() {
		return simpleDevisors;
	}

	public void setSimpleDevisors(List<String> simpleDevisors) {
		this.simpleDevisors = simpleDevisors;
	}
	
}