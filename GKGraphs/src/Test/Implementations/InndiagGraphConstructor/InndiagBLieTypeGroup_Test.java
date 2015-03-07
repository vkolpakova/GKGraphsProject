package Test.Implementations.InndiagGraphConstructor;

import org.junit.Assert;
import org.junit.Test;

import Test.Implementations.BTypableConcrete;

public class InndiagBLieTypeGroup_Test extends AbstractInndiagLieTypeGroup_Test implements BTypableConcrete {
	
	@Test
	public void test_C_3_4() {
		Assert.assertTrue(super.checkEquality(C_3_4, V_C_3_4, I_E_C_3_4));
	}
	
	@Test
	public void test_C_3_5() {
		Assert.assertTrue(super.checkEquality(C_3_5, V_C_3_5, I_E_C_3_5));
	}
	
	@Test
	public void test_C_3_7() {
		Assert.assertTrue(super.checkEquality(C_3_7, V_C_3_7, I_E_C_3_7));
	}
	
	@Test
	public void test_C_4_3() {
		Assert.assertTrue(super.checkEquality(C_4_3, V_C_4_3, I_E_C_4_3));
	}
	
	@Test
	public void test_C_2_32() {
		Assert.assertTrue(super.checkEquality(C_2_32, V_C_2_32, I_E_C_2_32));
	}
	
	@Test
	public void test_C_2_27() {
		Assert.assertTrue(super.checkEquality(C_2_27, V_C_2_27, I_E_C_2_27));
	}
	
	@Test
	public void test_C_2_81() {
		Assert.assertTrue(super.checkEquality(C_2_81, V_C_2_81, I_E_C_2_81));
	}
	
	@Test
	public void test_C_2_243() {
		Assert.assertTrue(super.checkEquality(C_2_243, V_C_2_243, I_E_C_2_243));
	}
	
	@Test
	public void test_C_2_289() {
		Assert.assertTrue(super.checkEquality(C_2_289, V_C_2_289, I_E_C_2_289));
	}
	
}