package Kernel.Resolvers.Series;

import Kernel.GraphConstructor.Series.InndiagSeriesGraphConstructor;
import Kernel.GraphConstructor.Series.SimpleInndiagSeriesGraphConstructor;
import Kernel.Group.Series;
import Series.ASeries.ASeries;
import Series.ASeries.InndiagASeriesGraphConstructor;
import Series.CSeries.C2.C2Series;
import Series.CSeries.Constructor.InndiagCSeriesGraphConstructor;
import Series._ASeries.Inndiag_ASeriesGraphConstructor;
import Series._ASeries._ASeries;

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
			constr = new InndiagASeriesGraphConstructor(series);
		} else if (series instanceof _ASeries) {
			constr = new Inndiag_ASeriesGraphConstructor(series);
		} else if (series instanceof C2Series) {
			constr = new InndiagCSeriesGraphConstructor(series);
		} else {
			constr = new SimpleInndiagSeriesGraphConstructor(series);
		}
		return constr;
	}
	
}