package Kernel.GraphConstructor;

import java.util.List;

import Kernel.Graph.Edge;
import Kernel.GraphConstructor.Сriterion.TwoOddNonadjacenceVertexesСriterion;
import Kernel.GraphConstructor.Сriterion.WithCharNonadjacenceVertexesСriterion;
import Kernel.GraphConstructor.Сriterion.WithTwoNonadjanceVertexesСriterion;
import Kernel.Group.LieTypeGroup;

public abstract class LieTypeGroupGraphConstructor extends AbstractGraphConstructor<LieTypeGroup> {

	/**
	 * Критерий несмежности двух нечетных простых чисел
	 */
	protected TwoOddNonadjacenceVertexesСriterion cr1;
	
	/**
	 * Критерий несмежности нечетного простого числа с характеристикой поля
	 */
	protected WithCharNonadjacenceVertexesСriterion cr2;
	
	/**
	 * Критерий несмежности нечетного простого числа с числом 2 (или другим, удовл. некоторому условию)
	 */
	protected WithTwoNonadjanceVertexesСriterion cr3;
	
	public LieTypeGroupGraphConstructor(LieTypeGroup group) {
		super(group);
	}
	
	public LieTypeGroupGraphConstructor(LieTypeGroup group, TwoOddNonadjacenceVertexesСriterion cr1, 
			WithCharNonadjacenceVertexesСriterion cr2, WithTwoNonadjanceVertexesСriterion cr3) {
		super(group);
		this.cr1 = cr1;
		this.cr2 = cr2;
		this.cr3 = cr3;
	}
	
	/**
	 * Метод удаляет все пары нечетных простых чисел, не являющиеся ребром
	 * @param inputList
	 */
	protected List<Edge> twoOddNonadjacenceVertexes(List<Edge> inputList) {
		this.cr1.setEdgeList(inputList);
		return cr1.checkAll();
	}
	
	/**
	 * Метод удаляет все пары "простое нечетное число --- характеристика поля", не являющиеся ребром
	 * @param inputList
	 */
	protected List<Edge> withCharNonadjacenceVertexes(List<Edge> inputList) {
		this.cr2.setEdgeList(inputList);
		return cr2.checkAll();
	}
	
	/**
	 * Метод удаляет все пары "простое нечетное число --- 2", не являющиеся ребром
	 * @param inputList
	 */
	protected List<Edge> withTwoNonadjanceVertexes(List<Edge> inputList) {
		this.cr3.setEdgeList(inputList);
		return cr3.checkAll();
	}
	
}