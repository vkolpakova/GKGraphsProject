package Test.Implementations.InndiagGraphConstructor;

import org.junit.Assert;
import org.junit.Test;

import Test.Implementations.SzTypableConcrete;

public class InndiagSzLieTypeGroup_Test extends AbstractInndiagLieTypeGroup_Test implements SzTypableConcrete {
	
	@Test
	public void testSz_8() {
		Assert.assertTrue(super.checkEquality(SZ_8, V_SZ_8, I_E_SZ_8));
	}
	
	@Test
	public void testSz_32() {
		Assert.assertTrue(super.checkEquality(SZ_32, V_SZ_32, I_E_SZ_32));
	}
	
}