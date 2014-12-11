package Series.CSeries.Constructor;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import Kernel.GraphConstructor.Series.InndiagSeriesGraphConstructor;
import Kernel.Group.Series;
import Kernel.Polynom.SimplePolynom;
import Kernel.Utils.ArithmeticUtils;

public class InndiagCSeriesGraphConstructor extends InndiagSeriesGraphConstructor {

	public InndiagCSeriesGraphConstructor(Series group) {
		super(group);
	}
	
	@Override
	protected void computePartitionsPolynoms() {
		Set<Map<Integer, List<Integer>>> setOfPartitions = ArithmeticUtils.getAllPartitionsForAllCombinations(this.group.getN());
		Set<SimplePolynom> simplePolynomSet = Sets.newHashSet(); // избавляемся от дублирования
		for (Map<Integer, List<Integer>> complexPartition : setOfPartitions) {
			List<Integer> expansionSet = complexPartition.get(1);
			List<Integer> expansionComplement = complexPartition.get(0);
			for (int n : expansionSet) {
				SimplePolynom poly = new SimplePolynom(SimplePolynom.PLUS, n);
				simplePolynomSet.add(poly);
			}
			for (int n : expansionComplement) {
				SimplePolynom poly = new SimplePolynom(SimplePolynom.MINUS, n);
				simplePolynomSet.add(poly);
			}
		}
		for (SimplePolynom setPoly : simplePolynomSet) {
			this.partitionsPolynoms.put(setPoly, super.getPolynomCompose(setPoly));
		}
	}
	
	@Override
	protected void computeMaxTorsList() {
		List<List<SimplePolynom>> result = Lists.newArrayList();
		Set<Map<Integer, List<Integer>>> setOfPartitions = ArithmeticUtils.getAllPartitionsForAllCombinations(this.group.getN());
		for (Map<Integer, List<Integer>> partitionExpansion : setOfPartitions) {
			List<SimplePolynom> partPoly = Lists.newArrayList();
			List<Integer> expansionSet = partitionExpansion.get(1);
			List<Integer> expansionComplement = partitionExpansion.get(0);
			for (int n : expansionSet) {
				SimplePolynom poly = this.getSimplePolynomByParams(n, SimplePolynom.PLUS);
				partPoly.add(poly);
			}
			for (int n : expansionComplement) {
				SimplePolynom poly = this.getSimplePolynomByParams(n, SimplePolynom.MINUS);
				partPoly.add(poly);
			}
			result.add(partPoly);
		}
		this.maxTorusList.addAll(result);
	}
	
}