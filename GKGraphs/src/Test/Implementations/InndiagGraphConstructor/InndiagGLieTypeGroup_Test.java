package Test.Implementations.InndiagGraphConstructor;

import org.junit.Assert;
import org.junit.Test;

import Test.Implementations.GTypableConcrete;

public class InndiagGLieTypeGroup_Test extends AbstractInndiagLieTypeGroup_Test implements GTypableConcrete {
	
	@Test
	public void testG_2_9() {
		Assert.assertTrue(super.checkEquality(G_2_9, V_G_2_9, I_E_G_2_9));
	}
	
	@Test
	public void testG_2_17() {
		Assert.assertTrue(super.checkEquality(G_2_17, V_G_2_17, I_E_G_2_17));
	}
	
}