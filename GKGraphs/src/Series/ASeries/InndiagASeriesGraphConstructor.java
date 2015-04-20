package Series.ASeries;

import java.util.List;
import java.util.Set;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import Kernel.GraphConstructor.Series.InndiagSeriesGraphConstructor;
import Kernel.Group.Series;
import Kernel.Polynom.SimplePolynom;
import Kernel.Utils.ArithmeticUtils;

public class InndiagASeriesGraphConstructor extends InndiagSeriesGraphConstructor {

	public InndiagASeriesGraphConstructor(Series group) {
		super(group);
	}
	
	@Override
	protected void computePartitionsPolynoms() {
		List<List<Integer>> partitions = ArithmeticUtils.partition(this.group.getN() + 1);
		Set<SimplePolynom> simplePolynomSet = Sets.newHashSet(); // избавляемся от дублирования
		int qm1Count = 0;
		for (List<Integer> partition : partitions) {
			for (int n : partition) {
				SimplePolynom partitionPoly = new SimplePolynom(SimplePolynom.MINUS, n);
				simplePolynomSet.add(partitionPoly);
				if (isQM1Poly(partitionPoly)) {
					qm1Count ++;
				}
			}
		}
		for (SimplePolynom setPoly : simplePolynomSet) {
			if ((!isQM1Poly(setPoly)) || ((isQM1Poly(setPoly)) && (qm1Count > 1))) {
				this.partitionsPolynoms.put(setPoly, super.getPolynomCompose(setPoly));
			}
		}
	}
	
	protected boolean isQM1Poly(SimplePolynom poly) {
		return ((poly.getN() == 1) && (poly.getEpsilon().equals(SimplePolynom.MINUS)));
	}
	
	@Override
	protected void computeMaxTorsList() {
		List<List<SimplePolynom>> result = Lists.newArrayList();
		List<List<Integer>> partitions = ArithmeticUtils.partition(this.group.getN() + 1);
		for (List<Integer> partition : partitions) {
			List<SimplePolynom> partPoly = Lists.newArrayList();
			for (int n : partition) {
				SimplePolynom poly = this.getSimplePolynomByParams(n, SimplePolynom.MINUS);
				partPoly.add(poly);
			}
			result.add(partPoly);
		}
		this.maxTorusList.addAll(result);
	}
	
}