package Logic.Kernel.Resolvers.Series;

import Logic.Kernel.GraphConstructor.Series.SeriesGraphConstructor;
import Logic.Kernel.Group.Series;
import Logic.Series.ASeries.ASeries;
import Logic.Series.ASeries.ASeriesGraphConstructor;
import Logic.Series.CSeries.C2.C2Series;
import Logic.Series.CSeries.C2.C2SeriesGraphConstructor;
import Logic.Series.GSeries.G2.G2Series;
import Logic.Series.GSeries.G2.G2SeriesGraphConstructor;
import Logic.Series.SzSeries.Sz.SzSeries;
import Logic.Series.SzSeries.Sz.SzSeriesGraphConstructor;
import Logic.Series._ASeries._ASeries;
import Logic.Series._ASeries._ASeriesGraphConstructor;

/**
 * Резолвер для конструкторов графов Грюнберга --- Кегеля групп серий
 * 
 * @author v.kolpakova
 *
 */
public class SeriesGraphConstructorResolver {
	
	public static SeriesGraphConstructor resolve(Series series) {
		if (series instanceof ASeries) {
			return new ASeriesGraphConstructor((ASeries)series);
		} else if (series instanceof C2Series) {
			return new C2SeriesGraphConstructor((C2Series)series);
		} else if (series instanceof G2Series) {
			return new G2SeriesGraphConstructor((G2Series)series);
		} else if (series instanceof SzSeries) {
			return new SzSeriesGraphConstructor((SzSeries)series);
		} else if (series instanceof _ASeries) {
			return new _ASeriesGraphConstructor((_ASeries)series);
		}
		return null;
	}
	
}