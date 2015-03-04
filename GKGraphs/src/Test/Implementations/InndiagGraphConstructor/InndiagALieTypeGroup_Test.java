package Test.Implementations.InndiagGraphConstructor;

import org.junit.Assert;
import org.junit.Test;

public class InndiagALieTypeGroup_Test extends AbstractInndiagLieTypeGroup_Test {
	
	private static final String A_4_7 	= "A_4(7)";
	private static final String V_A_4_7 = "2,3,5,7,19,2801";
	private static final String E_A_4_7 = "{2,3},{2,5},{2,7},{2,19},{3,5},{3,7},{3,19},{7,19}";
	
	@Test
	public void testA_4_7() {
		Assert.assertTrue(super.checkEquality(A_4_7, V_A_4_7, E_A_4_7));
	}
	
}