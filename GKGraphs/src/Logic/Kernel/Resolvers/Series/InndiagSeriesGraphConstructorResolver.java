package Logic.Kernel.Resolvers.Series;

import Logic.Kernel.GraphConstructor.Series.InndiagSeriesGraphConstructor;
import Logic.Kernel.GraphConstructor.Series.SimpleInndiagSeriesGraphConstructor;
import Logic.Kernel.Group.Series;
import Logic.Series.ASeries.ASeries;
import Logic.Series.ASeries.InndiagASeriesGraphConstructor;
import Logic.Series.CSeries.C2.C2Series;
import Logic.Series.CSeries.Constructor.InndiagCSeriesGraphConstructor;
import Logic.Series._ASeries.Inndiag_ASeriesGraphConstructor;
import Logic.Series._ASeries._ASeries;

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