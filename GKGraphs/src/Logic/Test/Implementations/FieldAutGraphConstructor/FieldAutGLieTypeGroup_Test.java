package Logic.Test.Implementations.FieldAutGraphConstructor;

import org.junit.Assert;
import org.junit.Test;

import Logic.Test.Implementations.GTypableConcrete;

public class FieldAutGLieTypeGroup_Test extends AbstractFieldAutLieTypeGroup_Test implements GTypableConcrete {
	
	@Test
	public void testG_2_9() {
		Assert.assertTrue(super.checkEqualities(G_2_9, V_G_2_9, F_E_G_2_9));
	}
	
	@Test
	public void testG_2_17() {
		Assert.assertTrue(super.checkEqualities(G_2_17, V_G_2_17, F_E_G_2_17));
	}
	
}