package Kernel.Group;

import java.util.List;
import java.util.Map;

import com.google.common.collect.Lists;

import Kernel.Graph.SymbolVertex;
import Kernel.Graph.Vertex;
import Kernel.Group.AbstractGroup;
import Kernel.Group.LieTypeGroup.GroupType;
import Kernel.Utils.ArithmeticUtils;

/**
 * Родительский класс, описывающий серию групп Лиева типа. </br>
 * Необходимые поля - ранг и коллекция компонент связности.
 * 
 * @author v.kolpakova
 *
 */
public class Series extends AbstractGroup {
	
	/**
	 * Коллекция компонент связности графа Грюнберга --- Кегеля группы данной серии
	 */
	protected List<Component> components;
	
	/**
	 * Лиев ранг
	 */
	protected int n;
	
	/**
	 * Характеристика поля
	 */
	protected String p;
	
	/**
	 * Показатель степени в q = p^m
	 */
	protected String m;
	
	/**
	 * Тип группы
	 */
	protected GroupType grType;
	
	public Series(String name, int n) {
		super(name);
		//constructComponents();
		this.n = n;
		this.p = SymbolVertex.P;
		this.m = SymbolVertex.M;
	}
	
	public Series(String name, int n, String p, String m) {
		super(name);
		//constructComponents();
		this.n = n;
		this.p = p;
		this.m = m;
	}

	public List<Component> getComponents() {
		return components;
	}

	public void setComponents(List<Component> components) {
		this.components = components;
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

	public String getP() {
		return p;
	}

	public void setP(String p) {
		this.p = p;
	}

	public String getM() {
		return m;
	}

	public void setM(String m) {
		this.m = m;
	}

	public GroupType getGrType() {
		return grType;
	}

	public void setGrType(GroupType grType) {
		this.grType = grType;
	}
	
	/**
	 * В методе реализуется построение коллекции компонент
	 */
	protected void constructComponents() {
		this.components = Lists.newArrayList();
	}
	
	/**
	 * Метод записывает в конкретную компоненту коллекцию вершин
	 * @param name
	 * @param verticesList
	 */
	public void setVeticesForConcreteComponent(String name, Map<Integer, List<SymbolVertex>> verticesMap) {
		for (Component component : components) {
			if (component.getName().equals(name)) {
				component.setVerticesMap(verticesMap);
			}
		}
	}
	
	/**
	 * Метод заполняет множества вершин у всех компонент на основе переданной коллекции
	 * @param inputMap : key --- наименование компоненты, value --- множество вершин
	 */
	public void setVerticesForAllComponent(Map<String, Map<Integer, List<SymbolVertex>>> inputMap) {
		for (String name : inputMap.keySet()) {
			setVeticesForConcreteComponent(name, inputMap.get(name));
		}
	}
	
	/**
	 * Метод возвращает значение m для заданной вершины
	 * @param v
	 * @return
	 */
	public int getVertexM(SymbolVertex v) {
		for (Component comp : components) {
			int vKey = comp.getVertexKey(v);
			if (vKey != -1) {
				return vKey;
			}
		}
		return 0;
	}
	
	/**
	 * Метод возвращает компоненту связанности, содержащее подмножество вершин 
	 * с заданным значением параметра m
	 * @param m
	 * @return Component
	 */
	public Component getComponentByM(int m) {
		for (Component comp : this.components) {
			if ((comp.getVerticesByKey(m) != null) && !comp.getVerticesByKey(m).isEmpty()) {
				return comp;
			}
		}
		return null;
	}
	
	/**
	 * Метод возвращает подмножество вершин с заданным значением параметра m
	 * @param m
	 * @return List<SymbolVertex>
	 */
	public List<SymbolVertex> getVerticesByM(int m) {
		for (Component comp : this.components) {
			List<SymbolVertex> verticesList = comp.getVerticesByKey(m);
			if ((verticesList != null) && !verticesList.isEmpty()) {
				return verticesList;
			}
		}
		return null;
	}
	
	/**
	 * Метод возвращает коллекицю всех вершин
	 * @return
	 */
	public List<Vertex<?>> getAllVerticesList() {
		List<Vertex<?>> result = Lists.newArrayList();
		for (Component component : components) {
			result.addAll(component.getAllVertices());
		}
		return result;
	}

	/**
	 * Класс, описывающий компоненту связности графа Грюнберга --- Кегеля группы
	 */
	public class Component {
		
		public static final String PI_1 = "pi_1";
		public static final String PI_2 = "pi_2";
		public static final String PI_3 = "pi_3";
		
		/**
		 * Map, состоящий из вершин компоненты и их параметров. </br>
		 * <b>Ключ:</b> Число, равное значению функции {@link ArithmeticUtils#e(int, int)} для всех вершин компоненты
		 * <b>Значение:</b> Коллекция вершин, входящих в компоненту с соотв. значением ключа
		 */
		protected Map<Integer, List<SymbolVertex>> verticesMap;
		
		/**
		 * Наименование компоненты, описание
		 */
		protected String name, description;

		public Component(Map<Integer, List<SymbolVertex>> verticesMap) {
			super();
			this.verticesMap = verticesMap;
		}
		
		public Component(Map<Integer, List<SymbolVertex>> verticesMap, String name, String description) {
			super();
			this.verticesMap = verticesMap;
			this.name = name;
			this.description = description;
		}

		public Map<Integer, List<SymbolVertex>> getVerticesMap() {
			return verticesMap;
		}

		public void setVerticesMap(Map<Integer, List<SymbolVertex>> verticesMap) {
			this.verticesMap = verticesMap;
		}
		
		/**
		 * Метод возвращает все вершины, входящие в компоненту связаности
		 * @return все вершины
		 */
		public List<SymbolVertex> getAllVertices() {
			List<SymbolVertex> result = Lists.newArrayList();
			for (List<SymbolVertex> list : this.verticesMap.values()) {
				result.addAll(list);
			}
			return result;
		}
		
		/**
		 * Метод возвращает коллекцию вершин компоненты с соотв. значением {@link ArithmeticUtils#e(int, int)}
		 */
		public List<SymbolVertex> getVerticesByKey(int key) {
			return this.verticesMap.get(key);
		}
		
		/**
		 * Метод возвращает значение {@link ArithmeticUtils#e(int, int)} для данной вершины
		 */
		public int getVertexKey(SymbolVertex vertex) {
			for (int k : this.verticesMap.keySet()) {
				if (this.verticesMap.get(k).contains(vertex)) {
					return k;
				}
			}
			return -1;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}
		
	}
	
}