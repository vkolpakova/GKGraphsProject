package Logic.Test.Implementations.FieldAutGraphConstructor;

import org.junit.Assert;
import org.junit.Test;

import Logic.Test.Implementations.SzTypableConcrete;

public class FieldAutSzLieTypeGroup_Test extends AbstractFieldAutLieTypeGroup_Test implements SzTypableConcrete {
	
	@Test
	public void testSZ_8() {
		Assert.assertTrue(super.checkEqualities(SZ_8, V_SZ_8, F_E_SZ_8));
	}
	
	@Test
	public void testSZ_32() {
		Assert.assertTrue(super.checkEqualities(SZ_32, V_SZ_32, F_E_SZ_32));
	}
	
}