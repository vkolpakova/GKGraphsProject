package Logic.Kernel.Polynom;

import java.util.List;
import java.util.Set;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

/**
 * Класс, реализующий полином над R. </br>
 * Представлен в виде разложения на неприводимые над R сомножители.
 * 
 * @author v.kolpakova
 *
 */
public class CompoundPolynom {
	
	/**
	 * Полиномы, входящие в разложение данного полинома на неприводимые над R множители
	 */
	protected List<IndecomposablePolynom> multipliers;

	public CompoundPolynom(List<IndecomposablePolynom> multipliers) {
		super();
		this.multipliers = multipliers;
	}

	public List<IndecomposablePolynom> getMultipliers() {
		return multipliers;
	}

	public void setMultipliers(List<IndecomposablePolynom> multipliers) {
		this.multipliers = multipliers;
	}
	
	/**
	 * Метод возвращает простой делитель полинома по его {@link IndecomposablePolynom#description}
	 * @param description
	 * @return
	 */
	public IndecomposablePolynom getMultiplierByDescr(String description) {
		for (IndecomposablePolynom poly : this.multipliers) {
			if (poly.getDescription().equals(description)) {
				return poly;
			}
		}
		return null;
	}
	
	/**
	 * Метод устанавливает множество делителей для конкретного простого делителя полинома
	 * @param description
	 * @param devisors
	 */
	public void setDevisorsForMultiplier(String description, List<String> devisors) {
		for (IndecomposablePolynom poly : multipliers) {
			if (poly.getDescription().equals(description)) {
				poly.setSimpleDevisors(devisors);
			}
		}
	}
	
	/**
	 * Метод возвращает все простые делители полинома (без повторов)
	 * @return
	 */
	public List<String> getAllPrimeDevisors() {
		Set<String> resultSet = Sets.newHashSet();
		for (IndecomposablePolynom mult : this.multipliers) {
			resultSet.addAll(mult.getSimpleDevisors());
		}
		return Lists.newArrayList(resultSet);
	}
	
}