package Test.Implementations.FieldAutGraphConstructor;

import org.junit.Assert;
import org.junit.Test;

import Test.Implementations._DTypableConcrete;

public class FieldAut_DLieTypeGroup_Test extends AbstractFieldAutLieTypeGroup_Test implements _DTypableConcrete {
	
	@Test
	public void test_D_4_3() {
		Assert.assertTrue(super.checkEqualities(_D_4_3, V__D_4_3, F_E__D_4_3));
	}
	
	@Test
	public void test_D_5_2() {
		Assert.assertTrue(super.checkEqualities(_D_5_2, V__D_5_2, F_E__D_5_2));
	}
	
}