package Test.Implementations.InndiagGraphConstructor;

import org.junit.Assert;
import org.junit.Test;

import Test.Implementations.DTypableConcrete;

public class InndiagDLieTypeGroup_Test extends AbstractInndiagLieTypeGroup_Test implements DTypableConcrete {
	
	@Test
	public void testD_4_4() {
		Assert.assertTrue(super.checkEquality(D_4_4, V_D_4_4, I_E_D_4_4));
	}
	
	@Test
	public void testD_4_5() {
		Assert.assertTrue(super.checkEquality(D_4_5, V_D_4_5, I_E_D_4_5));
	}
	
	@Test
	public void testD_4_7() {
		Assert.assertTrue(super.checkEquality(D_4_7, V_D_4_7, I_E_D_4_7));
	}
	
	@Test
	public void testD_5_2() {
		Assert.assertTrue(super.checkEquality(D_5_2, V_D_5_2, I_E_D_5_2));
	}
	
}