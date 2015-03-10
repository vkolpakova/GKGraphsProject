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
		Assert.assertTrue(super.checkEqualities(_A_5_3, V__A_5_3, F_2_E__A_5_3));
	}
	
}