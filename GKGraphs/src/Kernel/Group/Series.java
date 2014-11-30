package Kernel.Group;

import java.util.List;

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
	
	public Series(String name, List<Component> components, int n) {
		super(name);
		this.components = components;
		this.n = n;
		this.p = SymbolVertex.P;
		this.m = SymbolVertex.M;
	}
	
	public Series(String name, List<Component> components, int n, String p, String m) {
		super(name);
		this.components = components;
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
	 * Метод возвращает значение m для заданной вершины
	 * @param v
	 * @return
	 */
	public int getVertexM(SymbolVertex v) {
		for (Component comp : components) {
			if (comp.getVertices().contains(v)) {
				return comp.getM();
			}
		}
		return 0;
	}
	
	/**
	 * Метод возвращает компоненту связанности с заданным m
	 * @param m
	 * @return
	 */
	public Component getComponentByM(int m) {
		for (Component comp : this.components) {
			if (comp.getM() == m) {
				return comp;
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
			result.addAll(component.getVertices());
		}
		return result;
	}

	/**
	 * Класс, описывающий компоненту связности графа Грюнберга --- Кегеля группы
	 */
	public class Component {
		
		/**
		 * Число, равное значению функции {@link ArithmeticUtils#e(int, int)}} для всех вершин компоненты
		 */
		protected int m;
		
		/**
		 * Коллекция вершин, входящих в компоненту
		 */
		protected List<SymbolVertex> vertices;
		
		/**
		 * Наименование компоненты, описание
		 */
		protected String name, description;

		public Component(int m, List<SymbolVertex> vertices) {
			super();
			this.m = m;
			this.vertices = vertices;
		}
		
		public Component(int m, List<SymbolVertex> vertices, String name, String description) {
			super();
			this.m = m;
			this.vertices = vertices;
			this.name = name;
			this.description = description;
		}

		public int getM() {
			return m;
		}

		public void setM(int m) {
			this.m = m;
		}

		public List<SymbolVertex> getVertices() {
			return vertices;
		}

		public void setVertices(List<SymbolVertex> vertices) {
			this.vertices = vertices;
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