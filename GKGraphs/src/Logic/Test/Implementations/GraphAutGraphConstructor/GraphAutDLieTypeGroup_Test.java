package Logic.Test.Implementations.GraphAutGraphConstructor;

import org.junit.Assert;
import org.junit.Test;

import Logic.Test.Implementations.DTypableConcrete;

public class GraphAutDLieTypeGroup_Test extends AbstractGraphAutLieTypeGroup_Test implements DTypableConcrete {
	
	@Test
	public void testD_4_4() {
		Assert.assertTrue(super.checkEqualities(D_4_4, V_D_4_4, G_E_2_D_4_4, G_E_3_D_4_4));
	}
	
	@Test
	public void testD_4_5() {
		Assert.assertTrue(super.checkEqualities(D_4_5, V_D_4_5, G_E_2_D_4_5, G_E_3_D_4_5));
	}
	
	@Test
	public void testD_4_7() {
		Assert.assertTrue(super.checkEqualities(D_4_7, V_D_4_7, G_E_2_D_4_7, G_E_3_D_4_7));
	}
	
	@Test
	public void testD_5_2() {
		Assert.assertTrue(super.checkEqualities(D_5_2, V_D_5_2, G_E_D_5_2));
	}
	
}