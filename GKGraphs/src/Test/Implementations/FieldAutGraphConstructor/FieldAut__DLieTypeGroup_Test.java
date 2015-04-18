package Test.Implementations.FieldAutGraphConstructor;

import org.junit.Assert;
import org.junit.Test;

import Test.Implementations.__DTypableConcrete;

public class FieldAut__DLieTypeGroup_Test extends AbstractFieldAutLieTypeGroup_Test implements __DTypableConcrete {
	
	@Test
	public void test__D_4_4() {
		Assert.assertTrue(super.checkEqualities(__D_4_4, V___D_4_4, F_2_E___D_4_4, F_3_E___D_4_4));
	}
	
	@Test
	public void test__D_4_5() {
		Assert.assertTrue(super.checkEqualities(__D_4_5, V___D_4_5, F_E___D_4_5));
	}
	
}