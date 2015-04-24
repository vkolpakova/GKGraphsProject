package Logic.Test.Implementations.InndiagGraphConstructor;

import org.junit.Assert;
import org.junit.Test;

import Logic.Test.Implementations._DTypableConcrete;

public class Inndiag_DLieTypeGroup_Test extends AbstractInndiagLieTypeGroup_Test implements _DTypableConcrete {
	
	@Test
	public void test_D_4_3() {
		Assert.assertTrue(super.checkEquality(_D_4_3, V__D_4_3, I_E__D_4_3));
	}
	
	@Test
	public void test_D_5_2() {
		Assert.assertTrue(super.checkEquality(_D_5_2, V__D_5_2, I_E__D_5_2));
	}
	
}