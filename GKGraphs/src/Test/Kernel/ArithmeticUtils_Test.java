package Test.Kernel;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import Kernel.Utils.ArithmeticUtils;

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
	
}