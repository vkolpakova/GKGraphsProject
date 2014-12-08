package Kernel.GraphConstructor.Concrete;

import java.util.List;
import java.util.Map;

import Kernel.Graph.PrimeNumberGraph;
import Kernel.GraphConstructor.Concrete.Helper.PhiAndGammaAutSubgroupHelper;
import Kernel.Group.LieTypeGroup;
import Kernel.Utils.ArithmeticUtils;

/**
 * Конструктор графа Грюнберга --- Кегеля группы Inndiag, расширенной подгруппой, порожденной некоторым графовым автоморфизмом группы лиева типа
 * 
 * @author v.kolpakova
 *
 */
public abstract class GraphAutConcreteLieTypeGroupGraphConstructor<G extends LieTypeGroup> extends AutSubgroupConcreteLieTypeGroupGraphConstructor<LieTypeGroup> {
	
	protected PhiAndGammaAutSubgroupHelper helper;

	public GraphAutConcreteLieTypeGroupGraphConstructor(LieTypeGroup group) {
		super(group);
		this.helper = new PhiAndGammaAutSubgroupHelper(this);
	}
	
	@Override
	public int getOrder() {
		return this.group.getGraphAutGroupOrder();
	}
	
	@Override
	protected void computeCentralizationsMap() {
		List<Integer> fieldGroupOrderPrimeDivList = ArithmeticUtils.getAllPrimeDevisors(this.getOrder());
		for (int x : fieldGroupOrderPrimeDivList) {
			List<LieTypeGroup> centralizer = computeCentralizer(x);
			this.centralizationsMap.put(x, centralizer);
		}
	}
	
	/**
	 * Метод возвращает централизатор графового автоморфизма порядка x
	 * @param x --- порядок графового автоморфизма
	 * @return
	 */
	protected abstract List<LieTypeGroup> computeCentralizer(int x);
	
	/**
	 * Метод возвращает Map с графами Грюнберга --- Кегеля групп вида Inndiag*g,
	 * где g --- графовый автоморфизм некоторого простого порядка
	 * @return
	 */
	public Map<Integer, List<PrimeNumberGraph>> constructGraphs() {
		return helper.constructGraphs();
	}

	@Override
	public PrimeNumberGraph constructGKGraph() {
		return null; // заглушка абстрактного метода суперкласса
	}

}