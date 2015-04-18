package Test.Implementations.FieldAutGraphConstructor;

import org.junit.Assert;
import org.junit.Test;

import Test.Implementations._ATypableConcrete;

public class FieldAut_ALieTypeGroup_Test extends AbstractFieldAutLieTypeGroup_Test implements _ATypableConcrete {
	
	@Test
	public void test__A_4_4() {
		Assert.assertTrue(super.checkEqualities(_A_4_4, V__A_4_4, F_2_E__A_4_4));
	}
	
	@Test
	public void test__A_4_5() {
		Assert.assertTrue(super.checkEqualities(_A_4_5, V__A_4_5, F_2_E__A_4_5));
	}
	
	@Test
	public void test__A_4_9() {
		Assert.assertTrue(super.checkEqualities(_A_4_9, V__A_4_9, F_2_E__A_4_9));
	}
	
	@Test
	public void test__A_5_3() {
		Assert.assertTrue(super.checkEqualities(_A_5_3, V__A_5_3, F_2_E__A_5_3, F_2_E__A_5_3, F_2_E__A_5_3));
	}
	
	@Test
	public void test__A_6_2() {
		Assert.assertTrue(super.checkEqualities(_A_6_2, V__A_6_2, F_2_E__A_6_2));
	}
	
	@Test
	public void test__A_2_512() {
		Assert.assertTrue(super.checkEqualities(_A_2_512, V__A_2_512, F_2_E__A_2_512, F_3_E__A_2_512));
	}
	
	@Test
	public void test__A_2_27() {
		Assert.assertTrue(super.checkEqualities(_A_2_27, V__A_2_27, F_2_E__A_2_27, F_3_E__A_2_27));
	}
	
	@Test
	public void test__A_2_125() {
		Assert.assertTrue(super.checkEqualities(_A_2_125, V__A_2_125, F_2_E__A_2_125, F_3_E__A_2_125));
	}
	
	@Test
	public void test__A_2_625() {
		Assert.assertTrue(super.checkEqualities(_A_2_625, V__A_2_625, F_2_E__A_2_625));
	}
	
	@Test
	public void test__A_2_49() {
		Assert.assertTrue(super.checkEqualities(_A_2_49, V__A_2_49, F_2_E__A_2_49));
	}
	
	@Test
	public void test__A_2_343() {
		Assert.assertTrue(super.checkEqualities(_A_2_343, V__A_2_343, F_2_E__A_2_343, F_3_E__A_2_343));
	}
	
	@Test
	public void test__A_2_289() {
		Assert.assertTrue(super.checkEqualities(_A_2_289, V__A_2_289, F_2_E__A_2_289));
	}
	
	@Test
	public void test__A_3_8() {
		Assert.assertTrue(super.checkEqualities(_A_3_8, V__A_3_8, F_2_E__A_3_8, F_3_E__A_3_8));
	}
	
	@Test
	public void test__A_3_16() {
		Assert.assertTrue(super.checkEqualities(_A_3_16, V__A_3_16, F_2_E__A_3_16));
	}
	
	@Test
	public void test__A_3_25() {
		Assert.assertTrue(super.checkEqualities(_A_3_25, V__A_3_25, F_2_E__A_3_25, F_2_E__A_3_25, F_2_E__A_3_25));
	}
	
}