package Logic.Test.Implementations.InndiagGraphConstructor;

import org.junit.Assert;
import org.junit.Test;

import Logic.Test.Implementations.RiTypableConcrete;

public class InndiagRiLieTypeGroup_Test extends AbstractInndiagLieTypeGroup_Test implements RiTypableConcrete {
	
	@Test
	public void testRi_27() {
		Assert.assertTrue(super.checkEquality(RI_27, V_RI_27, I_E_RI_27));
	}
	
}