package Kernel.Group;

import java.util.List;

/**
 * Класс объекта, представляющего собой группу Лиева типа. </br>
 * Дополнительно характеризуется рангом, характеристикой поля, типом.
 * 
 * @author v.kolpakova
 */
public class LieTypeGroup extends AbstractGroup {
	
	// TODO реализовать вычисление типа группы по названию
	
	public LieTypeGroup(String name, int n, int p, int q) {
		super(name);
		this.n = n;
		this.p = p;
		this.q = q;
		computeGroupType();
		computeGroupOrder();
	}
	
	public LieTypeGroup(String name, int n, int p, int q, int order) {
		super(name, order);
		this.n = n;
		this.p = p;
		this.q = q;
	}
	
	public LieTypeGroup(String name, int n, int p, int q, List<String> symbolPrimeDivisorsList) {
		super(name, symbolPrimeDivisorsList);
		this.n = n;
		this.p = p;
		this.q = q;
	}

	public enum GroupType {
		A, _A, B, C, D, _D, __D, G, F, E6, E7, E8;
	}
		
	/**
	 * Лиев ранг
	 */
	protected int n;
	
	/**
	 * Характеристика поля
	 */
	protected int p;
	
	/**
	 * Порядок поля, степень числа p
	 */
	protected int q;
	
	/**
	 * Тип группы
	 */
	protected GroupType grType;

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}
	
	public int getP() {
		return p;
	}

	public void setP(int p) {
		this.p = p;
	}

	public int getQ() {
		return q;
	}

	public void setQ(int q) {
		this.q = q;
	}

	public GroupType getGrType() {
		return grType;
	}

	public void setGrType(GroupType grType) {
		this.grType = grType;
	}
	
	protected void computeGroupType() {}
	
	protected void computeGroupOrder() {}
	
}