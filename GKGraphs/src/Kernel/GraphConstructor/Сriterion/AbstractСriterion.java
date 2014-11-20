package Kernel.GraphConstructor.Сriterion;

import java.util.ArrayList;
import java.util.List;

import Kernel.Graph.Edge;
import Kernel.Group.AbstractGroup;

public abstract class AbstractСriterion {
	
	protected AbstractGroup group;
	
	protected List<Edge> edgeList;
	
	public AbstractСriterion(AbstractGroup group) {
		super();
		this.group = group;
	}
	
	public AbstractСriterion(List<Edge> edgeList, AbstractGroup group) {
		super();
		this.edgeList = edgeList;
		this.group = group;
	}
	
	public List<Edge> getEdgeList() {
		return edgeList;
	}
	
	public void setEdgeList(List<Edge> edgeList) {
		this.edgeList = edgeList;
	}
	
	/**
	 * критерий несмежности двух вершин в графе
	 * @param edge
	 * @return
	 */
	protected abstract boolean check(Edge edge);
	
	/**
	 * Производит удаление всех ребер, если они удовлетворяют условию критерия
	 */
	public List<Edge> checkAll() {
		List<Edge> result = new ArrayList<Edge>(edgeList);
		for (Edge edge : edgeList) {
			if (check(edge)) {
				result.remove(edge);
			}
		}
		return result;
	}
	
}