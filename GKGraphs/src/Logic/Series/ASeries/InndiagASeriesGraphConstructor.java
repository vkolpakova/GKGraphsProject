package Logic.Series.ASeries;

import java.util.List;
import java.util.Set;

import Logic.Kernel.Graph.SymbolVertex;
import Logic.Series.ASeries.A1.A1Series;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import Logic.Kernel.GraphConstructor.Series.InndiagSeriesGraphConstructor;
import Logic.Kernel.Group.Series;
import Logic.Kernel.Polynom.SimplePolynom;
import Logic.Kernel.Utils.ArithmeticUtils;

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
				qm1Count--;
			}
		}
	}
	
	protected boolean isQM1Poly(SimplePolynom poly) {
		return ((poly.getN() == 1) && (poly.getEpsilon().equals(SimplePolynom.MINUS)));
	}

	private void computePolyAdditionToPartitionPolynoms(SimplePolynom setPoly) {
		if (!(this.group instanceof A1Series) || ((this.group instanceof  A1Series) && (this.group.getP().equals(SymbolVertex.TWO)))) {
			this.partitionsPolynoms.put(setPoly, super.getPolynomCompose(setPoly));
		} else {
			if (((A1Series)this.group).getEpsilon().equals(A1Series.EPSILON_PLUS)) {
				switch (setPoly.getEpsilon()) {
					case SimplePolynom.MINUS : this.partitionsPolynoms.put(setPoly, super.getPolynomCompose(setPoly));
				}
			}
		}
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