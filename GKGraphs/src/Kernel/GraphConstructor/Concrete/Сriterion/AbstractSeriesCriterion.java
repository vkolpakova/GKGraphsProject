package Kernel.GraphConstructor.Concrete.Сriterion;

import java.util.List;

import Kernel.Graph.Edge;
import Kernel.Group.Series;

/**
 * Абстрактный класс критерия несмежности двух вершин в графе Грюнберга --- Кегеля
 * группы Лиева типа из некоторой серии
 * 
 * @author v.kolpakova
 *
 */
public abstract class AbstractSeriesCriterion extends AbstractСriterion {
	
	protected Series series;

	public AbstractSeriesCriterion(Series group) {
		super(group);
		this.series = group;
	}

	public AbstractSeriesCriterion(Series series, List<Edge> edgeList) {
		super(edgeList, series);
		this.series = series;
	}
	
}