package Series.ASeries;

import java.util.List;

import com.google.common.collect.Lists;

import Kernel.Graph.SymbolVertex;
import Kernel.GraphConstructor.Series.GraphAutSeriesGraphConstructor;
import Kernel.Group.Series;
import Kernel.Polynom.CompoundPolynom;

public abstract class GraphAutASeriesGraphConstructor extends GraphAutSeriesGraphConstructor {

	public GraphAutASeriesGraphConstructor(Series group) {
		super(group);
	}
	
	@Override
	protected void computeCentralizationsMap() {
		if (this.checkNotTrivial()) {
			if ((this.group.getN() % 2) == 0) {
				this.centralizationsMap.put(2, Lists.newArrayList(getBhalf_nOrder()));
			} else if ((this.group.getN() >= 3) && ((this.group.getN() % 2) != 0) && (this.group.getP().equals(SymbolVertex.TWO))) {
				this.centralizationsMap.put(2, Lists.newArrayList(getChalf_np1Order()));
			} else if ((this.group.getN() >= 3) && ((this.group.getN() % 2) != 0)) {
				List<CompoundPolynom> polyList = Lists.newArrayList(getChalf_np1Order(), getBhalf_np1Order(), 
						getDhalf_np1Order(), get2Dhalf_np1Order());
				this.centralizationsMap.put(2, polyList);
			}
		}
	}
	
	protected abstract CompoundPolynom getBhalf_nOrder();
	
	protected abstract CompoundPolynom getChalf_np1Order();
	
	protected abstract CompoundPolynom getBhalf_np1Order();
	
	protected abstract CompoundPolynom getDhalf_np1Order();
	
	protected abstract CompoundPolynom get2Dhalf_np1Order();
	
}