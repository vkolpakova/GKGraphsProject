package Logic.Test.Implementations.InndiagGraphConstructor;

import org.junit.Assert;
import org.junit.Test;

import Logic.Test.Implementations.FTypableConcrete;

public class InndiagFLieTypeGroup_Test extends AbstractInndiagLieTypeGroup_Test implements FTypableConcrete {
	
	@Test
	public void testF_4_2() {
		Assert.assertTrue(super.checkEquality(F_4_2, V_F_4_2, I_E_F_4_2));
	}
	
}