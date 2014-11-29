package Test.Kernel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import com.google.common.collect.Lists;

import Kernel.Utils.ArithmeticUtils;
import Kernel.Utils.MainLogger;

public class ArithmeticUtils_Test {
		
	@Test
	public void isPrimeNumberTest() {
		Assert.assertTrue(ArithmeticUtils.isPrimeNumber(2));
		Assert.assertTrue(ArithmeticUtils.isPrimeNumber(7));
		Assert.assertFalse(ArithmeticUtils.isPrimeNumber(15));
	}
	
	@Test
	public void getAllPrimeDevisorsTest() {
		List<Integer> res1 = ArithmeticUtils.getAllPrimeDevisors(7);
		Assert.assertTrue(res1.equals(Arrays.asList(7)));
		List<Integer> res2 = ArithmeticUtils.getAllPrimeDevisors(15);
		Assert.assertTrue(res2.equals(Arrays.asList(3, 5)));
		List<Integer> res3 = ArithmeticUtils.getAllPrimeDevisors(70560);
		Assert.assertTrue(res3.equals(Arrays.asList(2, 3, 5, 7)));
	}
	
	@Test
	public void eTest() {
		int res1 = ArithmeticUtils.e(7, 25);
		Assert.assertTrue(res1 == 3);
		int res2 = ArithmeticUtils.e(7, 5);
		Assert.assertTrue(res2 == 6);
	}
	
	@Test
	public void nPartTest() {
		int res1 = ArithmeticUtils.nPart(50, 5);
		Assert.assertTrue(res1 == 25);
		int res2 = ArithmeticUtils.nPart(50, 3);
		Assert.assertTrue(res2 == 1);
		int res3 = ArithmeticUtils.nPart(25, 5);
		Assert.assertTrue(res3 == 25);
		int res4 = ArithmeticUtils.nPart(25, 25);
		Assert.assertTrue(res4 == 25);
	}
	
	@Test
	public void etaTest() {
		int res1 = ArithmeticUtils.eta(1);
		Assert.assertTrue(res1 == 1);
		int res2 = ArithmeticUtils.eta(6);
		Assert.assertTrue(res2 == 3);
		int res3 = ArithmeticUtils.eta(7);
		Assert.assertTrue(res3 == 7);
	}
	
	@Test
	public void nuTest() {
		int res1 = ArithmeticUtils.nu(24);
		Assert.assertTrue(res1 == 24);
		int res2 = ArithmeticUtils.nu(18);
		Assert.assertTrue(res2 == 9);
		int res3 = ArithmeticUtils.nu(7);
		Assert.assertTrue(res3 == 14);
	}
	
	@Test
	public void NODTest() {
		int res1 = ArithmeticUtils.NOD(2, 5);
		Assert.assertTrue(res1 == 1);
		int res2 = ArithmeticUtils.NOD(30, 55);
		Assert.assertTrue(res2 == 5);
		int res3 = ArithmeticUtils.NOD(315, 140);
		Assert.assertTrue(res3 == 35);
		int res4 = ArithmeticUtils.NOD(155, 155);
		Assert.assertTrue(res4 == 155);
	}
	
	@Test
	public void primeDivMultiplicationTest() {
		int res1 = ArithmeticUtils.primeDivMultiplication(11);
		Assert.assertTrue(res1 == 11);
		int res2 = ArithmeticUtils.primeDivMultiplication(100);
		Assert.assertTrue(res2 == 10);
	}
	
	@Test
	public void partitionTest() {
		List<List<Integer>> res = ArithmeticUtils.partition(4);
		List<List<Integer>> testList = new ArrayList<List<Integer>>(5);
		List<Integer> l1 = new ArrayList<Integer>(Arrays.asList(1, 1, 1, 1));
		List<Integer> l2 = new ArrayList<Integer>(Arrays.asList(2, 1, 1));
		List<Integer> l3 = new ArrayList<Integer>(Arrays.asList(2, 2));
		List<Integer> l4 = new ArrayList<Integer>(Arrays.asList(3, 1));
		List<Integer> l5 = new ArrayList<Integer>(Arrays.asList(4));
		testList.add(l1);
		testList.add(l2);
		testList.add(l3);
		testList.add(l4);
		testList.add(l5);
		Assert.assertTrue(res.equals(testList));
		for (List<Integer> list : res) {
			int index = res.indexOf(list);
			for (int n : list) {
				MainLogger.info("List #"+index+" "+Integer.toString(n));
			}
		}
	}
	
	@Test
	public void combinationTest() {
		int n = 10;
		Integer[] arr = new Integer[n];
		for (int i = 0; i < 10; i ++) {
			arr[i] = 0;
		}
		List<List<Integer>> result = Lists.newArrayList();
		ArithmeticUtils.combination(result, arr, 10, 0);
		for (List<Integer> list : result) {
			String str = "";
			for (int num : list) {
				str = str.concat(Integer.toString(num).concat(", "));
			}
			System.out.println(str);
		}
	}
	
	@Test
	public void getFullPartitionMapForConcreteCombinationTest() {
		@SuppressWarnings({ "unchecked", "rawtypes" })
		List<Integer> numList = new ArrayList(Arrays.asList(new Integer(1), new Integer(2), new Integer(3)));
		List<Map<Integer, List<Integer>>> result = ArithmeticUtils.getFullPartitionMapForConcreteCombination(numList);
		for (Map<Integer, List<Integer>> res : result) {
			List<Integer> subset = res.get(1);
			List<Integer> complement = res.get(0);
			String str = "";
			for (Integer num : subset) {
				str = str.concat(Integer.toString(num)).concat(", ");
			}
			System.out.println("Subset: "+str);
			str = "";
			for (Integer num : complement) {
				str = str.concat(Integer.toString(num)).concat(", ");
			}
			System.out.println("Complement: "+str);
		}
	}
	
	@Test
	public void getAllPartitionsForAllCombinationsTest() {
		Set<Map<Integer, List<Integer>>> result = ArithmeticUtils.getAllPartitionsForAllCombinations(3);
		for (Map<Integer, List<Integer>> map : result) {
			List<Integer> subset = map.get(1);
			List<Integer> complement = map.get(0);
			String str = "";
			for (Integer num : subset) {
				str = str.concat(Integer.toString(num)).concat(", ");
			}
			System.out.println("Subset: "+str);
			str = "";
			for (Integer num : complement) {
				str = str.concat(Integer.toString(num)).concat(", ");
			}
			System.out.println("Complement: "+str);
		}
	}
	
}