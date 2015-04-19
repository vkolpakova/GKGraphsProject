package Test.Implementations.InndiagGraphConstructor;

import org.junit.Assert;
import org.junit.Test;

import Test.Implementations.ATypableConcrete;

public class InndiagALieTypeGroup_Test extends AbstractInndiagLieTypeGroup_Test implements ATypableConcrete {
	
	// =================================6-PRIMES=GROUPS=================================
	
	@Test
	public void testA_4_7() {
		Assert.assertTrue(super.checkEquality(A_4_7, V_A_4_7, I_E_A_4_7));
	}
	
	@Test
	public void testA_5_3() {
		Assert.assertTrue(super.checkEquality(A_5_3, V_A_5_3, I_E_A_5_3));
	}
	
	@Test
	public void testA_6_2() {
		Assert.assertTrue(super.checkEquality(A_6_2, V_A_6_2, I_E_A_6_2));
	}
	
	@Test
	public void testA_2_1024() {
		Assert.assertTrue(super.checkEquality(A_1_1024, V_A_1_1024, I_E_A_1_1024));
	}
	
	@Test
	public void testA_2_65536() {
		// FIXME неудача (выход за границы int порядка группы)
		Assert.assertTrue(super.checkEquality(A_1_65536, V_A_1_65536, I_E_A_1_65536));
	}
	
	@Test
	public void testA_2_729() {
		Assert.assertTrue(super.checkEquality(A_1_729, V_A_1_729, I_E_A_1_729));
	}
	
	@Test
	public void testA_2_14641() {
		Assert.assertTrue(super.checkEquality(A_1_14641, V_A_1_14641, I_E_A_1_14641));
	}
	
	@Test
	public void testA_2_6561() {
		Assert.assertTrue(super.checkEquality(A_1_6561, V_A_1_6561, I_E_A_1_6561));
	}
	
	@Test
	public void testA_2_3125() {
		Assert.assertTrue(super.checkEquality(A_1_3125, V_A_1_3125, I_E_A_1_3125));
	}
	
	@Test
	public void testA_2_4913() {
		Assert.assertTrue(super.checkEquality(A_1_4913, V_A_1_4913, I_E_A_1_4913));
	}
	
	@Test
	public void testA_2_83521() {
		Assert.assertTrue(super.checkEquality(A_1_83521, V_A_1_83521, I_E_A_1_83521));
	}
	
	@Test
	public void testA_2_16() {
		Assert.assertTrue(super.checkEquality(A_2_16, V_A_2_16, I_E_A_2_16));
	}
	
	@Test
	public void testA_2_128() {
		Assert.assertTrue(super.checkEquality(A_2_128, V_A_2_128, I_E_A_2_128));
	}
	
	@Test
	public void testA_2_512() {
		Assert.assertTrue(super.checkEquality(A_2_512, V_A_2_512, I_E_A_2_512));
	}
	
	@Test
	public void testA_2_25() {
		Assert.assertTrue(super.checkEquality(A_2_25, V_A_2_25, I_E_A_2_25));
	}
	
	@Test
	public void testA_2_49() {
		Assert.assertTrue(super.checkEquality(A_2_49, V_A_2_49, I_E_A_2_49));
	}
	
	@Test
	public void testA_3_8() {
		Assert.assertTrue(super.checkEquality(A_3_8, V_A_3_8, I_E_A_3_8));
	}
	
	@Test
	public void testA_3_9() {
		Assert.assertTrue(super.checkEquality(A_3_9, V_A_3_9, I_E_A_3_9));
	}
	
	@Test
	public void testA_3_17() {
		Assert.assertTrue(super.checkEquality(A_3_17, V_A_3_17, I_E_A_3_17));
	}
	
}