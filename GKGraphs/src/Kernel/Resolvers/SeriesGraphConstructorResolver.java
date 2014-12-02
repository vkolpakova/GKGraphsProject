package Kernel.Resolvers;

import Kernel.GraphConstructor.SeriesGraphConstructor;
import Kernel.Group.Series;
import Series.ASeries.ASeries;
import Series.ASeries.ASeriesGraphConstructor;

public class SeriesGraphConstructorResolver {
	
	public static SeriesGraphConstructor resolve(Series series) {
		if (series instanceof ASeries) {
			return new ASeriesGraphConstructor((ASeries)series);
		}
		return null;
	}
	
}