package Kernel.Resolvers.Series;

import Kernel.GraphConstructor.Series.InndiagSeriesGraphConstructor;
import Kernel.Group.Series;
import Series.ASeries.ASeries;

/**
 * Класс вычисляет, конкструктор Inndiag графа Грюнберга --- Кегеля серии какого класса вызвать на основе типа серии. </br>
 * <b>ВНИМАНИЕ:</b> перед вызовом убедиться, что вычислено поле {@link InndiagSeriesGraphConstructor#groupGraph}
 * 
 * @author v.kolpakova
 *
 */
public class InndiagSeriesGraphConstructorResolver {
	
	public static InndiagSeriesGraphConstructor resolve(Series series) {
		InndiagSeriesGraphConstructor constr = null;
		if (series instanceof ASeries) {
			constr = new InndiagSeriesGraphConstructor(series);
		}
		return constr;
	}
	
}