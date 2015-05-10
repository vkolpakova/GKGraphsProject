package Logic.Test.Series.SeriesGraphConstructor;

import Logic.Test.Series.A1TypableSeries;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by v.kolpakova on 21.04.2015.
 */
public class A1SeriesGraphConstructor_Test extends AbstractSeriesGroup_Test implements A1TypableSeries {

    @Test
    public void A1_1_Test() {
        Assert.assertTrue(checkEquality(A1_1, A1_1_V, A1_1_E));
    }

    @Test
    public void A1_2_Test() {
        Assert.assertTrue(checkEquality(A1_2, A1_2_V, A1_2_E));
    }

    @Test
    public void A1_3_Test() {
        Assert.assertTrue(checkEquality(A1_3, A1_3_V, A1_3_E));
    }

    @Test
    public void A1_4_Test() {
        Assert.assertTrue(checkEquality(A1_4, A1_4_V, A1_4_E));
    }

    @Test
    public void A1_5_Test() {
        Assert.assertTrue(checkEquality(A1_5, A1_5_V, A1_5_E));
    }

    @Test
    public void A1_6_Test() {
        Assert.assertTrue(checkEquality(A1_6, A1_6_V, A1_6_E));
    }

    @Test
    public void A1_7_Test() {
        Assert.assertTrue(checkEquality(A1_7, A1_7_V, A1_7_E));
    }

}
