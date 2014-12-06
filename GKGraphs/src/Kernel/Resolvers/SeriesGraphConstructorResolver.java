package Kernel.Resolvers;

import Kernel.GraphConstructor.SeriesGraphConstructor;
import Kernel.Group.Series;
import Series.ASeries.ASeries;
import Series.ASeries.ASeriesGraphConstructor;
import Series.CSeries.C2.C2Series;
import Series.CSeries.C2.C2SeriesGraphConstructor;
import Series.GSeries.G2.G2Series;
import Series.GSeries.G2.G2SeriesGraphConstructor;

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
		}
		return null;
	}
	
}