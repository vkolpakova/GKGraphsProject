package Logic.Kernel.Group;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import Logic.Kernel.Graph.SymbolVertex;
import Logic.Kernel.Graph.Vertex;
import Logic.Kernel.Group.LieTypeGroup.GroupType;
import Logic.Kernel.Polynom.CompoundPolynom;
import Logic.Kernel.Utils.ArithmeticUtils;

/**
 * Родительский класс, описывающий серию групп Лиева типа. </br>
 * Необходимые поля - ранг и коллекция компонент.
 * 
 * @author v.kolpakova
 *
 */
public class Series extends AbstractGroup {
	
	/**
	 * Коллекция компонент графа Грюнберга --- Кегеля группы данной серии
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
	
	/**
	 * Порядок группы
	 */
	protected CompoundPolynom seriesOrder;
	
	public Series(String name, int n) {
		super(name);
		this.n = n;
		this.p = SymbolVertex.P;
		this.m = SymbolVertex.M;
	}
	
	public Series(String name, int n, String p, String m) {
		super(name);
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
	
	public CompoundPolynom getSeriesOrder() {
		return this.seriesOrder;
	}

	public void setSeriesOrder(CompoundPolynom order) {
		this.seriesOrder = order;
	}
	
	/**
	 * В методе задается порядок групп серии. </br>
	 * <b>Внимание:</b> вызывать после метода {@link #constructComponents()}
	 */
	protected void computeSeriesOrder() {};

	/**
	 * В методе реализуется построение коллекции компонент. </br>
	 * <b>Внимание:</b> после вызывать {@link #computeSeriesOrder()}
	 */
	protected void constructComponents() {
		this.components = Lists.newArrayList();
	}
	
	/**
	 * В методе происходит заполнение множества простых делителей в разложении порядка серии на основе заполненных компонент
	 */
	public void fillSeriesOrderBasedComponents() {};
	
	/**
	 * Метод записывает в конкретную компоненту коллекцию вершин
	 * @param name
	 * @param verticesList
	 */
	public void setVerticesForConcreteComponent(String name, ArrayList<SymbolVertex> verticesList) {
		for (Component component : components) {
			if (component.getName().equals(name)) {
				component.setVertices(verticesList);
			}
		}
	}
	
	/**
	 * Метод заполняет множества вершин у всех компонент на основе переданной коллекции
	 * @param inputMap : key --- наименование компоненты, value --- множество вершин
	 */
	public void setVerticesForAllComponent(Map<String, List<SymbolVertex>> inputMap) {
		for (String name : inputMap.keySet()) {
			setVerticesForConcreteComponent(name, new ArrayList(inputMap.get(name)));
		}
	}
	
	/**
	 * Метод возвращает значение {@link Component#m} для заданной вершины
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
	 * Метод возвращает значение {@link Component#name} для заданной вершины
	 * @param v
	 * @return
	 */
	public String getVertexComponentName(SymbolVertex v) {
		for (Component comp : components) {
			if (comp.getVertices().contains(v)) {
				return comp.getName();
			}
		}
		return "";
	}
	
	/**
	 * Метод возвращает компоненту с заданным {@link Component#m}
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
	 * Метод возвращает компоненту с заданным {@link Component#name}
	 * @param name
	 * @return
	 */
	public Component getComponentByName(String name) {
		for (Component comp : this.components) {
			if (comp.getName().equals(name)) {
				return comp;
			}
		}
		return null;
	}
	
	/**
	 * Метод возвращает строковое представление коллекции простых делителей конкретной компоненты. </br>
	 * Компонента определяется параметром {@link Component#m}.
	 * @param m
	 * @return
	 */
	public List<String> getSimpleDivisorsOfConcreteComponent(int m) {
		Component concreteComponent = getComponentByM(m);
		return concreteComponent.getAllVerticesStringForm();
	}
	
	/**
	 * Метод возвращает строковое представление коллекции простых делителей конкретной компоненты. </br>
	 * Компонента определяется параметром {@link Component#name}.
	 * @param name
	 * @return
	 */
	public List<String> getSimpleDivisorsOfConcreteComponent(String name) {
		Component concreteComponent = getComponentByName(name);
		return concreteComponent.getAllVerticesStringForm();
	}
	
	/**
	 * Метод возвращает коллекицю всех вершин
	 * TODO избавиться от дублирования
	 * @return
	 */
	public List<Vertex<?>> getAllVerticesList() {
		// set необходимо, чтобы избежать повторений вершин (т.к. в различных компонентах м.б. одинаковые вершины)
		Set<Vertex<?>> resultSet = Sets.newHashSet();
		for (Component component : components) {
			resultSet.addAll(component.getVertices());
		}
		List<Vertex<?>> result = Lists.newArrayList(resultSet);
		return result;
	}
	
	/**
	 * Метод возвращает порядок Outdiag(G)
	 * @return
	 */
	public int getOutdiagOrder() { return 1; }
	
	/**
	 * Метод возвращает порядок группы полевых автоморфизмов. </br>
	 * Внимание: метод возвращает только действительную часть порядка группы полевых автоморфизмов,
	 * поскольку только для неё можно построить граф простых чисел. Остальное отбрасывается.
	 * @return
	 */
	public int getIntegerPartFieldAutOrder() { return 1; }
	
	/**
	 * Метод возвращает порядок группы графовых автоморфизмов
	 * @return
	 */
	public int getGraphAutOrder() { return 0; }

	/**
	 * Класс, описывающий множество вершин с одним значением функции {@link ArithmeticUtils#e(int, int)}
	 */
	public class Component {
		
		/**
		 * Число, равное значению функции {@link ArithmeticUtils#e(int, int)} для всех вершин компоненты
		 */
		protected int m;
		
		/**
		 * Коллекция вершин, входящих в компоненту
		 */
		protected ArrayList<SymbolVertex> vertices;
		
		/**
		 * Наименование компоненты, описание
		 */
		protected String name;

		public Component(int m, ArrayList<SymbolVertex> vertices) {
			super();
			this.m = m;
			this.vertices = vertices;
		}
		
		public Component(int m, ArrayList<SymbolVertex> vertices, String name) {
			super();
			this.m = m;
			this.vertices = vertices;
			this.name = name;
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

		public void setVertices(ArrayList<SymbolVertex> vertices) {
			this.vertices = vertices;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
		
		public List<String> getAllVerticesStringForm() {
			List<String> result = Lists.newArrayList();
			for (SymbolVertex vertex : vertices) {
				result.add(vertex.getVertex());
			}
			return result;
		}
		
		public boolean checkContainsVertex(String value) {
			return this.getAllVerticesStringForm().contains(value);
		}
		
	}
	
}