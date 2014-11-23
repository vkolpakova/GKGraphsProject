package Kernel.Group;

import java.util.List;

import Kernel.Graph.PrimeNumberGraph;
import Kernel.Utils.MainLogger;

/**
 * Абстрактный класс объекта, являющегося группой. </br>
 * Характеризуется названием, типом вершины, порядком (если задан), набором простых делителей порядка (если есть).
 * 
 * @author v.kolpakova
 *
 */
public abstract class AbstractGroup {
	
	public enum VertexType {
		NUMBER_TYPE,
		SYMBOL_TYPE;
	}
	
	/**
	 * Наименование группы
	 */
	protected String name;
	
	/**
	 * Порядок группы
	 */
	protected long order;
	
	/**
	 * Множество простых делителей порядка группы (если они заданы символами)
	 */
	protected List<String> symbolPrimeDivisorsList;
	
	/**
	 * Граф Грюнберга-Кегеля группы
	 */
	protected PrimeNumberGraph graph;
	
	/**
	 * Тип вершины
	 */
	protected VertexType vType;
	
	public AbstractGroup(String name) {
		super();
		this.name = name;
		MainLogger.info("*AbstractGroup* Group name: " + name);
	}
	
	public AbstractGroup(String name, int order) {
		super();
		this.name = name;
		this.order = order;
		this.vType = VertexType.NUMBER_TYPE;
	}
	
	public AbstractGroup(String name, List<String> symbolPrimeDivisorsList) {
		super();
		this.name = name;
		this.symbolPrimeDivisorsList = symbolPrimeDivisorsList;
		this.vType = VertexType.SYMBOL_TYPE;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public PrimeNumberGraph getGraph() {
		return graph;
	}

	public void setGraph(PrimeNumberGraph graph) {
		this.graph = graph;
	}

	public long getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public List<String> getSymbolPrimeDivisorsList() {
		return symbolPrimeDivisorsList;
	}

	public void setSymbolPrimeDivisorsList(List<String> symbolPrimeDivisorsList) {
		this.symbolPrimeDivisorsList = symbolPrimeDivisorsList;
	}
	
}