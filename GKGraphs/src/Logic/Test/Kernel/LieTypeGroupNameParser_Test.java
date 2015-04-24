package Logic.Test.Kernel;

import org.junit.Assert;
import org.junit.Test;

import Logic.Kernel.Group.LieTypeGroup.GroupType;
import Logic.Kernel.Utils.LieTypeGroupNameParser;

public class LieTypeGroupNameParser_Test {
	
	private static final String GR1 = "A_3(7)";
	private static final String GR2 = "_A_15(16)";
	private static final String GR3 = "B_20(125)";
	private static final String GR4 = "C_3(11)";
	private static final String GR5 = "D_44(2)";
	private static final String GR6 = "_D_5(43)";
	private static final String GR7 = "__D_300(16)";
	private static final String GR8 = "F_4(61)";
	private static final String GR9 = "G_4(4)";
	private static final String GR10 = "Sz(8)";
	private static final String GR11 = "Ri(27)";
	
	@Test
	public void computeGroupTypeTest() {
		try {
			Assert.assertTrue(LieTypeGroupNameParser.computeGroupType(GR1).equals(GroupType.A));
			Assert.assertTrue(LieTypeGroupNameParser.computeGroupType(GR2).equals(GroupType._A));
			Assert.assertTrue(LieTypeGroupNameParser.computeGroupType(GR3).equals(GroupType.B));
			Assert.assertTrue(LieTypeGroupNameParser.computeGroupType(GR4).equals(GroupType.C));
			Assert.assertTrue(LieTypeGroupNameParser.computeGroupType(GR5).equals(GroupType.D));
			Assert.assertTrue(LieTypeGroupNameParser.computeGroupType(GR6).equals(GroupType._D));
			Assert.assertTrue(LieTypeGroupNameParser.computeGroupType(GR7).equals(GroupType.__D));
			Assert.assertTrue(LieTypeGroupNameParser.computeGroupType(GR8).equals(GroupType.F));
			Assert.assertTrue(LieTypeGroupNameParser.computeGroupType(GR9).equals(GroupType.G));
			Assert.assertTrue(LieTypeGroupNameParser.computeGroupType(GR10).equals(GroupType.Sz));
			Assert.assertTrue(LieTypeGroupNameParser.computeGroupType(GR11).equals(GroupType.Ri));
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	@Test
	public void computeN() {
		try {
			Assert.assertTrue(LieTypeGroupNameParser.computeN(GR1) == 3);
			Assert.assertTrue(LieTypeGroupNameParser.computeN(GR2) == 15);
			Assert.assertTrue(LieTypeGroupNameParser.computeN(GR3) == 20);
			Assert.assertTrue(LieTypeGroupNameParser.computeN(GR4) == 3);
			Assert.assertTrue(LieTypeGroupNameParser.computeN(GR5) == 44);
			Assert.assertTrue(LieTypeGroupNameParser.computeN(GR6) == 5);
			Assert.assertTrue(LieTypeGroupNameParser.computeN(GR7) == 300);
			Assert.assertTrue(LieTypeGroupNameParser.computeN(GR8) == 4);
			Assert.assertTrue(LieTypeGroupNameParser.computeN(GR9) == 4);
			Assert.assertTrue(LieTypeGroupNameParser.computeN(GR10) == 2);
			Assert.assertTrue(LieTypeGroupNameParser.computeN(GR11) == 2);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	@Test
	public void computeQ() {
		try {
			Assert.assertTrue(LieTypeGroupNameParser.computeQ(GR1) == 7);
			Assert.assertTrue(LieTypeGroupNameParser.computeQ(GR2) == 16);
			Assert.assertTrue(LieTypeGroupNameParser.computeQ(GR3) == 125);
			Assert.assertTrue(LieTypeGroupNameParser.computeQ(GR4) == 11);
			Assert.assertTrue(LieTypeGroupNameParser.computeQ(GR5) == 2);
			Assert.assertTrue(LieTypeGroupNameParser.computeQ(GR6) == 43);
			Assert.assertTrue(LieTypeGroupNameParser.computeQ(GR7) == 16);
			Assert.assertTrue(LieTypeGroupNameParser.computeQ(GR8) == 61);
			Assert.assertTrue(LieTypeGroupNameParser.computeQ(GR9) == 4);
			Assert.assertTrue(LieTypeGroupNameParser.computeQ(GR10) == 8);
			Assert.assertTrue(LieTypeGroupNameParser.computeQ(GR11) == 27);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	@Test
	public void computeP() {
		try {
			Assert.assertTrue(LieTypeGroupNameParser.computeP(GR1) == 7);
			Assert.assertTrue(LieTypeGroupNameParser.computeP(GR2) == 2);
			Assert.assertTrue(LieTypeGroupNameParser.computeP(GR3) == 5);
			Assert.assertTrue(LieTypeGroupNameParser.computeP(GR4) == 11);
			Assert.assertTrue(LieTypeGroupNameParser.computeP(GR5) == 2);
			Assert.assertTrue(LieTypeGroupNameParser.computeP(GR6) == 43);
			Assert.assertTrue(LieTypeGroupNameParser.computeP(GR7) == 2);
			Assert.assertTrue(LieTypeGroupNameParser.computeP(GR8) == 61);
			Assert.assertTrue(LieTypeGroupNameParser.computeP(GR9) == 2);
			Assert.assertTrue(LieTypeGroupNameParser.computeP(GR10) == 2);
			Assert.assertTrue(LieTypeGroupNameParser.computeP(GR11) == 3);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
}