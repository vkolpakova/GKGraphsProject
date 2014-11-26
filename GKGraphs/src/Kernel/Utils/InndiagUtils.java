package Kernel.Utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
			//Set<Integer> intSet = new HashSet<Integer>(list);
			Set<Integer> primeDivSet = new HashSet<Integer>();
			double mult = 1;
			for (int num : list) {
				if (epsilon.equals(PLUS)) {
					mult *= Math.pow(group.getQ(), num) - 1;
				} else {
					mult *= Math.pow(group.getQ(), num) - Math.pow(-1, num);
				}
			}
			mult /= (epsilon.equals(PLUS)) ? (group.getQ() - 1) : (group.getQ() + 1);
			primeDivSet.addAll(ArithmeticUtils.getAllPrimeDevisors(mult));
			List<Integer> primeDivList = new ArrayList<Integer>(primeDivSet);
			result.add(primeDivList);
		}
		return result;
	}
	
}