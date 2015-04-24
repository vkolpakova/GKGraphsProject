package Logic.Series._ASeries;

import java.util.List;
import java.util.Set;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import Logic.Kernel.GraphConstructor.Series.InndiagSeriesGraphConstructor;
import Logic.Kernel.Group.Series;
import Logic.Kernel.Polynom.SimplePolynom;
import Logic.Kernel.Utils.ArithmeticUtils;

public class Inndiag_ASeriesGraphConstructor extends InndiagSeriesGraphConstructor {

	public Inndiag_ASeriesGraphConstructor(Series group) {
		super(group);
	}
	@Override
	protected void computePartitionsPolynoms() {
		List<List<Integer>> partitions = ArithmeticUtils.partition(this.group.getN() + 1);
		Set<SimplePolynom> simplePolynomSet = Sets.newHashSet(); // избавляемся от дублирования
		int qp1Count = 0;
		for (List<Integer> partition : partitions) {
			for (int n : partition) {
				SimplePolynom partitionPoly = ((n % 2) != 0) ? new SimplePolynom(SimplePolynom.PLUS, n) : new SimplePolynom(SimplePolynom.MINUS, n);
				simplePolynomSet.add(partitionPoly);
				if (isQP1Poly(partitionPoly)) {
					qp1Count ++;
				}
			}
		}
		for (SimplePolynom setPoly : simplePolynomSet) {
			if ((!isQP1Poly(setPoly)) || ((isQP1Poly(setPoly)) && (qp1Count > 1))) {
				this.partitionsPolynoms.put(setPoly, super.getPolynomCompose(setPoly));
			}
		}
	}
	
	protected boolean isQP1Poly(SimplePolynom poly) {
		return ((poly.getN() == 1) && (poly.getEpsilon().equals(SimplePolynom.PLUS)));
	}
	
	@Override
	protected void computeMaxTorsList() {
		List<List<SimplePolynom>> result = Lists.newArrayList();
		List<List<Integer>> partitions = ArithmeticUtils.partition(this.group.getN() + 1);
		for (List<Integer> partition : partitions) {
			List<SimplePolynom> partPoly = Lists.newArrayList();
			for (int n : partition) {
				SimplePolynom poly = ((n % 2) != 0) ? this.getSimplePolynomByParams(n, SimplePolynom.PLUS) : this.getSimplePolynomByParams(n, SimplePolynom.MINUS);
				partPoly.add(poly);
			}
			result.add(partPoly);
		}
		this.maxTorusList.addAll(result);
	}
	
}