package Test.Implementations.FieldAutGraphConstructor;

import org.junit.Assert;
import org.junit.Test;

import Test.Implementations.RiTypableConcrete;

public class FieldAutRiLieTypeGroup_Test extends AbstractFieldAutLieTypeGroup_Test implements RiTypableConcrete {
	
	@Test
	public void testRI_27() {
		Assert.assertTrue(super.checkEqualities(RI_27, V_RI_27, F_E_RI_27));
	}
	
}