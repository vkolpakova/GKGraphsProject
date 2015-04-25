package Logic.Test.Implementations.FieldAutGraphConstructor;

import org.junit.Assert;
import org.junit.Test;

import Logic.Test.Implementations.BTypableConcrete;

public class FieldAutBLieTypeGroup_Test extends AbstractFieldAutLieTypeGroup_Test implements BTypableConcrete {
	
	@Test
	public void testC_3_4() {
		Assert.assertTrue(super.checkEqualities(C_3_4, V_C_3_4, F_E_C_3_4));
	}
	
	@Test
	public void testC_3_5() {
		Assert.assertTrue(super.checkEqualities(C_3_5, V_C_3_5, F_E_C_3_5));
	}
	
	@Test
	public void testC_3_7() {
		Assert.assertTrue(super.checkEqualities(C_3_7, V_C_3_7, F_E_C_3_7));
	}
	
	@Test
	public void testC_4_3() {
		Assert.assertTrue(super.checkEqualities(C_4_3, V_C_4_3, F_E_C_4_3));
	}
	
	@Test
	public void testC_2_32() {
		Assert.assertTrue(super.checkEqualities(C_2_32, V_C_2_32, F_E_C_2_32));
	}
	
	@Test
	public void testC_2_27() {
		Assert.assertTrue(super.checkEqualities(C_2_27, V_C_2_27, F_E_C_2_27));
	}
	
	@Test
	public void testC_2_81() {
		Assert.assertTrue(super.checkEqualities(C_2_81, V_C_2_81, F_E_C_2_81));
	}
	
	@Test
	public void testC_2_121() {
		Assert.assertTrue(super.checkEqualities(C_2_121, V_C_2_121, F_E_C_2_121));
	}
	
	@Test
	public void testC_2_243() {
		Assert.assertTrue(super.checkEqualities(C_2_243, V_C_2_243, F_E_C_2_243));
	}
	
	@Test
	public void testC_2_289() {
		Assert.assertTrue(super.checkEqualities(C_2_289, V_C_2_289, F_E_C_2_289));
	}
	
}