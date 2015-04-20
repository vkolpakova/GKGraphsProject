package Test.Implementations.FieldAutGraphConstructor;

import org.junit.Assert;
import org.junit.Test;

import Test.Implementations.FTypableConcrete;

public class FieldAutFLieTypeGroup_Test extends AbstractFieldAutLieTypeGroup_Test implements FTypableConcrete {
	
	@Test
	public void testF_4_2() {
		Assert.assertTrue(super.checkEqualities(F_4_2, V_F_4_2, F_E_F_4_2));
	}
	
}