package Test.Implementations.InndiagGraphConstructor;

import org.junit.Assert;
import org.junit.Test;

import Test.Implementations.__DTypableConcrete;

public class Inndiag__DLieTypeGroup_Test extends AbstractInndiagLieTypeGroup_Test implements __DTypableConcrete {
	
	@Test
	public void test__D_4_4() {
		Assert.assertTrue(super.checkEquality(__D_4_4, V___D_4_4, I_E___D_4_4));
	}
	
	@Test
	public void test__D_4_5() {
		Assert.assertTrue(super.checkEquality(__D_4_5, V___D_4_5, I_E___D_4_5));
	}
	
}