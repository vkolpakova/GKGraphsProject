package Test.Series.SeriesGraphConstructor;

import Test.Series.A1TypableSeries;

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

}
