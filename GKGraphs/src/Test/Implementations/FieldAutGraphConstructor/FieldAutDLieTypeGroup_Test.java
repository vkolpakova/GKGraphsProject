package Test.Implementations.FieldAutGraphConstructor;

import org.junit.Assert;
import org.junit.Test;

import Test.Implementations.DTypableConcrete;

public class FieldAutDLieTypeGroup_Test extends AbstractFieldAutLieTypeGroup_Test implements DTypableConcrete {
	
	@Test
	public void testD_4_4() {
		Assert.assertTrue(super.checkEqualities(D_4_4, V_D_4_4, F_E_D_4_4));
	}
	
	@Test
	public void testD_4_5() {
		Assert.assertTrue(super.checkEqualities(D_4_5, V_D_4_5, F_E_D_4_5));
	}
	
	@Test
	public void testD_4_7() {
		Assert.assertTrue(super.checkEqualities(D_4_7, V_D_4_7, F_E_D_4_7));
	}
	
	@Test
	public void testD_5_2() {
		Assert.assertTrue(super.checkEqualities(D_5_2, V_D_5_2, F_E_D_5_2));
	}
	
}