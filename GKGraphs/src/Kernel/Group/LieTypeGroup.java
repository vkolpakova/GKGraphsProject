package Kernel.Group;

import java.util.List;

import Kernel.Utils.LieTypeGroupNameParser;
import Kernel.Utils.MainLogger;

/**
 * Класс объекта, представляющего собой группу Лиева типа. </br>
 * Дополнительно характеризуется рангом, характеристикой поля, типом.
 * 
 * @author v.kolpakova
 */
public class LieTypeGroup extends AbstractGroup {
		
	public LieTypeGroup(String name) {
		super(name);
		try {
			GroupType type = LieTypeGroupNameParser.computeGroupType(name);
			this.grType = type;
			MainLogger.info("*LieTypeGroup* Group type: " + type.name());
			int n = LieTypeGroupNameParser.computeN(name);
			this.n = n;
			MainLogger.info("*LieTypeGroup* Group range = " + Integer.toString(n));
			int q = LieTypeGroupNameParser.computeQ(name);
			this.q = q;
			MainLogger.info("*LieTypeGroup* Field order = " + Integer.toString(q));
			int p = LieTypeGroupNameParser.computeP(name);
			MainLogger.info("*LieTypeGroup* Field characteristic = " + Integer.toString(p));
			computeGroupOrder();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
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
		A, _A, B, C, D, _D, __D, G, F, Sz, Ri;
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
	
	/**
	 * Вычисляет тип группы Лиева типа
	 */
	protected void computeGroupType() {}
	
	/**
	 * Вычисляет порядок группы. </br>
	 * <b>Внимание:</b> вместо множителя = 'степень q' необходимо использовать p и 
	 * разлагать каждый сомножитель с пом. метода {@link ArithmeticUtils.primeDivMultiplication()}, 
	 * чтобы не выйти за границы int и уменьшить время факторизации.
	 */
	protected void computeGroupOrder() {}
	
}