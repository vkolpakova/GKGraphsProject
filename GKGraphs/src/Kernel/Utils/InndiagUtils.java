package Kernel.Utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import Kernel.Group.LieTypeGroup;

/**
 * Класс утилитарных методов для конструкторов графа группы Inndiag(G)
 * 
 * @author v.kolpakova
 *
 */
public class InndiagUtils {
	
	public static final String PLUS = "+";
	public static final String MINUS = "-";
	
	/**
	 * Метод {@link Kernel.GraphConstructor.InndiagConcreteLieTypeGroupGraphConstructor#computeTorOrdersPartitions}
	 * для групп типов A b 2A 
	 * @param group
	 * @return
	 */
	public static List<List<Integer>> computeTorOrdersPartitionsEpsilonA(LieTypeGroup group, String epsilon) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		int n = group.getN() + 1;
		List<List<Integer>> nPartitions = ArithmeticUtils.partition(n);
		for (List<Integer> list : nPartitions) {
			Set<Integer> primeDivSet = new HashSet<Integer>();
			double mult = 1;
			for (int num : list) {
				if (epsilon.equals(PLUS)) {
					mult *= Math.pow(group.getQ(), num) - 1;
				} else {
					mult *= Math.pow(group.getQ(), num) - Math.pow(-1, num);
				}
			}
			int q = group.getQ();
			mult /= (epsilon.equals(PLUS)) ? (q - 1) : (q + 1);
			primeDivSet.addAll(ArithmeticUtils.getAllPrimeDevisors(mult));
			List<Integer> primeDivList = new ArrayList<Integer>(primeDivSet);
			result.add(primeDivList);
		}
		return result;
	}
	
	/**
	 * Метод {@link Kernel.GraphConstructor.InndiagConcreteLieTypeGroupGraphConstructor#computeTorOrdersPartitions}
	 * для групп типов D b 2D
	 * @param group
	 * @return
	 */
	public static List<List<Integer>> computeTorOrdersPartitionsEpsilonD(LieTypeGroup group, String epsilon) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		int n = group.getN();
		Set<Map<Integer, List<Integer>>> allPartitionsComp = ArithmeticUtils.getAllPartitionsForAllCombinations(n);
		for (Map<Integer, List<Integer>> map: allPartitionsComp) {
			int m = map.get(0).size();
			int l = map.get(1).size();
			if ((((m % 2) == 0) && (l != 0) && (n != 0) && (epsilon.equals(PLUS))) ||
					(((m % 2) != 0) && (m != 0) && (l != 0) && (epsilon.equals(MINUS)))) {
				List<Integer> c = computeCurrentTorOrderPartitionEpsilonD(group, map);
				result.add(c);
			} 
		}
		return result;
	}
	
	protected static List<Integer> computeCurrentTorOrderPartitionEpsilonD(LieTypeGroup group, Map<Integer, List<Integer>> map) {
		int order = 1;
		List<Integer> subN = map.get(1);
		List<Integer> subL = map.get(0);
		if (!subN.isEmpty()) {
			for (int num : subN) {
				order *= Math.pow(group.getQ(), num) - 1;
			}
		}
		if (!subL.isEmpty()) {
			for (int num : subL) {
				order *= Math.pow(group.getQ(), num) + 1;
			}
		}
		return ArithmeticUtils.getAllPrimeDevisors(order);
	}
	
}