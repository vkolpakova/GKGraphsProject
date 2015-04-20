package Kernel.GraphConstructor.Concrete.Сriterion;

import java.util.List;

import Kernel.Graph.Edge;
import Kernel.Group.LieTypeGroup;

/**
 * Абстрактный класс критерия несмежности двух вершин в графе Грюнберга --- Кегеля
 * некоторой группы Лиева типа
 * 
 * @author v.kolpakova
 *
 */
public abstract class AbstractLieTypeGroupCriterion extends AbstractСriterion {
	
	protected LieTypeGroup ltGroup;

	public AbstractLieTypeGroupCriterion(LieTypeGroup group) {
		super(group);
		this.ltGroup = group;
	}

	public AbstractLieTypeGroupCriterion(List<Edge> edgeList, LieTypeGroup group) {
		super(edgeList, group);
		this.ltGroup = group;
	}
	
}