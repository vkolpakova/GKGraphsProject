package Logic.Test.Implementations;

public interface ATypableConcrete {
	
	// L_5(7)
	public static final String A_4_7 			= "A_4(7)";
	public static final String V_A_4_7 			= "2,3,5,7,19,2801";
	public static final String E_A_4_7 			= "{2,3},{2,5},{2,7},{2,19},{3,5},{3,7},{3,19},{7,19}";
	public static final String I_E_A_4_7 		= E_A_4_7;
	public static final String F_E_A_4_7 		= E_A_4_7;
	public static final String G_E_A_4_7 		= E_A_4_7;
	
	// L_6(3)
	public static final String A_5_3 			= "A_5(3)";
	public static final String V_A_5_3 			= "2,3,5,7,11,13";
	public static final String E_A_5_3 			= "{2,3},{2,5},{2,7},{2,13},{3,5},{3,13},{7,13}";
	public static final String I_E_A_5_3 		= "{2,3},{2,5},{2,7},{2,11},{2,13},{3,5},{3,13},{7,13}";
	public static final String F_E_A_5_3 		= E_A_5_3;
	public static final String G_E_A_5_3 		= E_A_5_3;
	
	// L_7(2)
	public static final String A_6_2 			= "A_6(2)";
	public static final String V_A_6_2 			= "2,3,5,7,31,127";
	public static final String E_A_6_2 			= "{2,3},{2,5},{2,7},{2,31},{3,5},{3,7},{3,31},{5,7}";
	public static final String I_E_A_6_2 		= E_A_6_2;
	public static final String F_E_A_6_2 		= E_A_6_2;
	public static final String G_E_A_6_2 		= E_A_6_2;
	
	// L_2(1024)
	public static final String A_1_1024 		= "A_1(1024)";
	public static final String V_A_1_1024 		= "2,3,5,11,31,41";
	public static final String E_A_1_1024 		= "{3,11},{3,31},{5,41},{11,31}";
	public static final String I_E_A_1_1024 	= E_A_1_1024;
	public static final String F_E_2_A_1_1024 	= "2#{2,3},{2,11},{2,31},{3,11},{3,31},{5,41},{11,31}";
	public static final String F_E_5_A_1_1024 	= "5#{2,5},{3,5},{3,11},{3,31},{5,41},{11,31}";
	public static final String G_E_A_1_1024 	= E_A_1_1024;
	
	// L_2(65536)
	public static final String A_1_65536 		= "A_1(65536)";
	public static final String V_A_1_65536 		= "2,3,5,17,257,65537";
	public static final String E_A_1_65536 		= "{3,5},{3,17},{3,257},{5,17},{5,257},{17,257}";
	public static final String I_E_A_1_65536 	= E_A_1_65536;
	public static final String F_A_1_65536 		= "2#{2,3},{2,5},{2,17},{2,257},{3,5},{3,17},{3,257},{5,17},{5,257},{17,257}";
	public static final String G_E_A_1_65536 	= E_A_1_65536;
	
	// L_2(729)
	public static final String A_1_729 			= "A_1(729)";
	public static final String V_A_1_729 		= "2,3,5,7,13,73";
	public static final String E_A_1_729 		= "{2,7},{2,13},{5,73},{7,13}";
	public static final String I_E_A_1_729 		= "{2,5},{2,7},{2,13},{2,73},{5,73},{7,13}";
	public static final String F_E_2_A_1_729 	= "2#{2,3},{2,7},{2,13},{5,73},{7,13}";
	public static final String F_E_3_A_1_729 	= "3#{2,3},{2,7},{2,13},{3,5},{5,73},{7,13}";
	public static final String G_E_A_1_729 		= E_A_1_729;
	
	//L_2(14621)
	public static final String A_1_14641 		= "A_1(14641)";
	public static final String V_A_1_14641 		= "2,3,5,11,61,7321";
	public static final String E_A_1_14641 		= "{2,3},{2,5},{2,61},{3,5},{3,61},{5,61}";
	public static final String I_E_A_1_14641 	= "{2,3},{2,5},{2,61},{2,7321},{3,5},{3,61},{5,61}";
	public static final String F_E_2_A_1_14641 	= "2#{2,3},{2,5},{2,11},{2,61},{3,5},{3,61},{5,61}";
	public static final String G_E_A_1_14641 	= E_A_1_14641;
	
	// L_2(6561)
	public static final String A_1_6561 		= "A_1(6561)";
	public static final String V_A_1_6561 		= "2,3,5,17,41,193";
	public static final String E_A_1_6561 		= "{2,5},{2,41},{5,41},{17,193}";
	public static final String I_E_A_1_6561 	= "{2,5},{2,17},{2,41},{2,193},{5,41},{17,193}";
	public static final String F_E_2_A_1_6561 	= "2#{2,3},{2,5},{2,41},{5,41},{17,193}";
	public static final String G_E_A_1_6561 	= E_A_1_6561;
	
	// L_2(3125)
	public static final String A_1_3125 		= "A_1(3125)";
	public static final String V_A_1_3125 		= "2,3,5,11,71,521";
	public static final String E_A_1_3125 		= "{2,11},{2,71},{3,521},{11,71}";
	public static final String I_E_A_1_3125 	= "{2,3},{2,11},{2,71},{2,521},{3,521},{11,71}";
	public static final String F_E_5_A_1_3125 	= "5#{2,5},{2,11},{2,71},{3,5},{3,521},{11,71}";
	public static final String G_E_A_1_3125 	= E_A_1_3125;
	
	// L_2(4913)
	public static final String A_1_4913 		= "A_1(4913)";
	public static final String V_A_1_4913 		= "2,3,7,13,17,307";
	public static final String E_A_1_4913 		= "{2,307},{3,7},{3,13},{7,13}";
	public static final String I_E_A_1_4913 	= "{2,3},{2,7},{2,13},{2,307},{3,7},{3,13},{7,13}";
	public static final String F_E_3_A_1_4913 	= "3#{2,3},{2,307},{3,7},{3,13},{3,17},{7,13}";
	public static final String G_E_A_1_4913 	= E_A_1_4913;
	
	// L_2(83521)
	public static final String A_1_83521 		= "A_1(83521)";
	public static final String V_A_1_83521 		= "2,3,5,17,29,41761";
	public static final String E_A_1_83521 		= "{2,3},{2,5},{2,29},{3,5},{3,29},{5,29}";
	public static final String I_E_A_1_83521 	= "{2,3},{2,5},{2,29},{2,41761},{3,5},{3,29},{5,29}";
	public static final String F_E_2_A_1_83521 	= "2#{2,3},{2,5},{2,17},{2,29},{3,5},{3,29},{5,29}";
	public static final String G_E_A_1_83521 	= E_A_1_83521;
	
	// L_3(16)
	public static final String A_2_16 			= "A_2(16)";
	public static final String V_A_2_16 		= "2,3,5,7,13,17";
	public static final String E_A_2_16 		= "{2,5},{3,5},{5,17},{7,13}";
	public static final String I_E_A_2_16 		= "{2,5},{3,5},{3,7},{3,13},{3,17},{5,17},{7,13}";
	public static final String F_E_2_A_2_16 	= "2#{2,3},{2,5},{2,7},{3,5},{5,17},{7,13}";
	public static final String G_E_A_2_16 		= "2#{2,3},{2,5},{2,17},{3,5},{5,17},{7,13}";
	
	// L_3(128)
	public static final String A_2_128 			= "A_2(128)";
	public static final String V_A_2_128 		= "2,3,7,43,127,337";
	public static final String E_A_2_128 		= "{2,127},{3,43},{3,127},{7,337},{43,127}";
	public static final String I_E_A_2_128 		= E_A_2_128;
	public static final String F_E_7_A_2_128 	= "7#{2,7},{2,127},{3,7},{3,43},{3,127},{7,337},{43,127}";
	public static final String G_E_A_2_128 		= "2#{2,3},{2,43},{2,127},{3,43},{3,127},{7,337},{43,127}";
	
	// L_3(512)
	public static final String A_2_512 			= "A_2(512)";
	public static final String V_A_2_512 		= "2,3,7,19,73,262657";
	public static final String E_A_2_512 		= "{2,7},{2,73},{3,7},{3,19},{3,73},{7,19},{7,73},{19,73}";
	public static final String I_E_A_2_512 		= E_A_2_512;
	public static final String F_E_3_A_2_512 	= "3#{2,3},{2,7},{2,73},{3,7},{3,19},{3,73},{7,19},{7,73},{19,73}";
	public static final String G_E_A_2_512 		= "2#{2,3},{2,7},{2,19},{2,73},{3,7},{3,19},{3,73},{7,19},{7,73},{19,73}";
	
	// L_3(25)
	public static final String A_2_25 			= "A_2(25)";
	public static final String V_A_2_25 		= "2,3,5,7,13,31";
	public static final String E_A_2_25 		= "{2,3},{2,5},{2,13},{7,31}";
	public static final String I_E_A_2_25 		= "{2,3},{2,5},{2,13},{3,7},{3,13},{3,31},{7,31}";
	public static final String F_E_2_A_2_25 	= "2#{2,3},{2,5},{2,13},{2,31},{7,31}";
	public static final String G_E_A_2_25 		= E_A_2_25;
	
	// L_3(49)
	public static final String A_2_49 			= "A_2(49)";
	public static final String V_A_2_49 		= "2,3,5,7,19,43";
	public static final String E_A_2_49 		= "{2,3},{2,5},{2,7},{19,43}";
	public static final String I_E_A_2_49 		= "{2,3},{2,5},{2,7},{3,5},{3,19},{3,43},{19,43}";
	public static final String F_E_2_A_2_49 	= "2#{2,3},{2,5},{2,7},{2,19},{19,43}";
	public static final String G_E_A_2_49 		= E_A_2_49;
	
	// L_4(8)
	public static final String A_3_8 			= "A_3(8)";
	public static final String V_A_3_8 			= "2,3,5,7,13,73";
	public static final String E_A_3_8 			= "{2,3},{2,7},{3,5},{3,7},{3,13},{5,13},{7,73}";
	public static final String I_E_A_3_8 		= E_A_3_8;
	public static final String F_E_3_A_3_8 		= "3#{2,3},{2,7},{3,5},{3,7},{3,13},{5,13},{7,73}";
	public static final String G_E_A_3_8 		= "2#{2,3},{2,5},{2,7},{2,13},{3,5},{3,7},{3,13},{5,13},{7,73}";
	
	// L_4(9)
	public static final String A_3_9 			= "A_3(9)";
	public static final String V_A_3_9 			= "2,3,5,7,13,41";
	public static final String E_A_3_9 			= "{2,3},{2,5},{2,7},{2,13},{3,5},{7,13},{5,41}";
	public static final String I_E_A_3_9 		= "{2,3},{2,5},{2,7},{2,13},{2,41},{3,5},{7,13},{5,41}";
	public static final String F_E_2_A_3_9 		= "2#{2,3},{2,5},{2,7},{2,13},{3,5},{7,13},{5,41}";
	public static final String G_E_A_3_9 		= "2#{2,3},{2,5},{2,7},{2,13},{2,41},{3,5},{7,13},{5,41}";
	
	// L_4(17)
	public static final String A_3_17 			= "A_3(17)";
	public static final String V_A_3_17 		= "2,3,5,17,29,307";
	public static final String E_A_3_17 		= "{2,3},{2,17},{2,307},{3,5},{3,17},{3,29},{5,29}";
	public static final String I_E_A_3_17 		= "{2,3},{2,5},{2,17},{2,29},{2,307},{3,5},{3,17},{3,29},{5,29}";
	public static final String F_E_A_3_17 		= "{2,3},{2,17},{2,307},{3,5},{3,17},{3,29},{5,29}";
	public static final String G_E_A_3_17 		= "2#{2,3},{2,5},{2,17},{2,29},{2,307},{3,5},{3,17},{3,29},{5,29}";
	
}