package Logic.Test.Series;

/**
 * Created by v.kolpakova on 21.04.2015.
 */
public interface A1TypableSeries {

    public static final String A1_1     = "A_1(2^m),pi(q - 1) = {r}, pi(q + 1) = {r_1, r_2, r_3, r_4}";
    public static final String A1_1_V   = "2,r,r_1,r_2,r_3,r_4";
    public static final String A1_1_E   = "{r_1,r_2},{r_1,r_3},{r_1,r_4},{r_2,r_3},{r_2,r_4},{r_3,r_4}";

    public static final String A1_2     = "A_1(2^{p^2}), pi(q - 1) = {r_1, s_1}, pi(q + 1) = {r, s, t}";
    public static final String A1_2_V   = "2,r,s,t,r_1,s_1";
    public static final String A1_2_E   = "{r_1,s_1},{r,s},{r,t},{s,t}";

    public static final String A1_3     = "A_1(2^{p}), pi(q - 1) = {r_1, r_2}, pi(q + 1) = {3, s, t}";
    public static final String A1_3_V   = "2,3,s,t,r_1,r_2";
    public static final String A1_3_E   = "{3,s},{3,t},{s,t},{r_1,r_2}";

    public static final String A1_4     = "A_1(2^{p}), pi(q - 1) = {r, s, t}, pi(q + 1) = {r_1, s_1}";
    public static final String A1_4_V   = "2,r,s,t,r_1,s_1";
    public static final String A1_4_E   = "{r,s},{r,t},{s,t},{r_1,s_1}";

    public static final String A1_5     = "A_1(2^{2p}), pi(q - 1) = {r, s, t}, pi(q + 1) = {r_1, s_1}";
    public static final String A1_5_V   = "2,r,s,t,r_1,s_1";
    public static final String A1_5_E   = "{r,s},{r,t},{s,t},{r_1,s_1}";

}
