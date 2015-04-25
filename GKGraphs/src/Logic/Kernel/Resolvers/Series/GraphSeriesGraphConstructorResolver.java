package Logic.Kernel.Resolvers.Series;

import Logic.Kernel.GraphConstructor.Series.GraphAutSeriesGraphConstructor;
import Logic.Kernel.GraphConstructor.Series.InndiagSeriesGraphConstructor;
import Logic.Kernel.GraphConstructor.Series.SimpleGraphAutSeriesGraphConstructor;
import Logic.Kernel.Group.Series;
import Logic.Series.ASeries.A2.A2Series;
import Logic.Series.ASeries.A2.GraphAutA2SeriesGraphConstructor;
import Logic.Series.ASeries.A3.A3Series;
import Logic.Series.ASeries.A3.GraphAutA3SeriesGraphConstructor;

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