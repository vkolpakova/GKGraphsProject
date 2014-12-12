package Kernel.Resolvers.Series;

import Kernel.GraphConstructor.Series.GraphAutSeriesGraphConstructor;
import Kernel.GraphConstructor.Series.InndiagSeriesGraphConstructor;
import Kernel.GraphConstructor.Series.SimpleGraphAutSeriesGraphConstructor;
import Kernel.Group.Series;
import Series.ASeries.A2.A2Series;
import Series.ASeries.A2.GraphAutA2SeriesGraphConstructor;
import Series.ASeries.A3.A3Series;
import Series.ASeries.A3.GraphAutA3SeriesGraphConstructor;

/**
 * Класс вычисляет, конкструктор Graph Aut графа Грюнберга --- Кегеля серии какого класса вызвать на основе типа серии. </br>
 * <b>ВНИМАНИЕ:</b> перед вызовом убедиться, что вычислено поле {@link InndiagSeriesGraphConstructor#groupGraph}
 * 
 * @author v.kolpakova
 *
 */
public class GraphSeriesGraphConstructorResolver {
	
	public static GraphAutSeriesGraphConstructor resolve(Series series) {
		GraphAutSeriesGraphConstructor constr = null;
		if (series instanceof A2Series) {
			constr = new GraphAutA2SeriesGraphConstructor(series);
		} else if (series instanceof A3Series) {
			constr = new GraphAutA3SeriesGraphConstructor(series);
		} else {
			constr = new SimpleGraphAutSeriesGraphConstructor(series);
		}
		return constr;
	}
	
}