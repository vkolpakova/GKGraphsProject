package Test.Implementations.FieldAutGraphConstructor;

import org.junit.Assert;
import org.junit.Test;

import Test.Implementations.ATypableConcrete;

public class FieldAutALieTypeGroup_Test extends AbstractFieldAutLieTypeGroup_Test implements ATypableConcrete {
	
	@Test
	public void testA_4_7() {
		Assert.assertTrue(super.checkEqualities(A_4_7, V_A_4_7, F_E_A_4_7));
	}
	
	@Test
	public void testA_5_3() {
		Assert.assertTrue(super.checkEqualities(A_5_3, V_A_5_3, F_E_A_5_3));
	}
	
	@Test
	public void testA_6_2() {
		Assert.assertTrue(super.checkEqualities(A_6_2, V_A_6_2, F_E_A_6_2));
	}
	
	@Test
	public void testA_1_1024() {
		Assert.assertTrue(super.checkEqualities(A_1_1024, V_A_1_1024, F_E_2_A_1_1024, F_E_5_A_1_1024));
	}
	
	// TODO testA_2_65536
	
	@Test
	public void testA_1_729() {
		Assert.assertTrue(super.checkEqualities(A_1_729, V_A_1_729, F_E_2_A_1_729, F_E_3_A_1_729));
	}
	
	@Test
	public void testA_2_14641() {
		Assert.assertTrue(super.checkEqualities(A_1_14641, V_A_1_14641, F_E_2_A_1_14641));
	}
	
	@Test
	public void testA_1_6561() {
		Assert.assertTrue(super.checkEqualities(A_1_6561, V_A_1_6561, F_E_2_A_1_6561));
	}
	
	@Test
	public void testA_1_3125() {
		Assert.assertTrue(super.checkEqualities(A_1_3125, V_A_1_3125, F_E_5_A_1_3125));
	}
	
	@Test
	public void testA_1_4913() {
		Assert.assertTrue(super.checkEqualities(A_1_4913, V_A_1_4913, F_E_3_A_1_4913));
	}
	
	@Test
	public void testA_1_83521() {
		Assert.assertTrue(super.checkEqualities(A_1_83521, V_A_1_83521, F_E_2_A_1_83521));
	}
	
	@Test
	public void testA_2_16() {
		Assert.assertTrue(super.checkEqualities(A_2_16, V_A_2_16, F_E_2_A_2_16));
	}
	
	@Test
	public void testA_2_128() {
		Assert.assertTrue(super.checkEqualities(A_2_128, V_A_2_128, F_E_7_A_2_128));
	}
	
	@Test
	public void testA_2_512() {
		Assert.assertTrue(super.checkEqualities(A_2_512, V_A_2_512, F_E_3_A_2_512));
	}
	
	@Test
	public void testA_2_25() {
		Assert.assertTrue(super.checkEqualities(A_2_25, V_A_2_25, F_E_2_A_2_25));
	}
	
	@Test
	public void testA_2_49() {
		Assert.assertTrue(super.checkEqualities(A_2_49, V_A_2_49, F_E_2_A_2_49));
	}
	
	@Test
	public void testA_3_8() {
		Assert.assertTrue(super.checkEqualities(A_3_8, V_A_3_8, F_E_3_A_3_8));
	}
	
	@Test
	public void testA_3_9() {
		Assert.assertTrue(super.checkEqualities(A_3_9, V_A_3_9, F_E_2_A_3_9));
	}
	
	@Test
	public void testA_3_17() {
		Assert.assertTrue(super.checkEqualities(A_3_17, V_A_3_17, F_E_A_3_17));
	}
	
}