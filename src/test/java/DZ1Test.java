import lesson6.DZ1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class DZ1Test {
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {new int[]{5,6}, new int[]{1,2,4,4,2,3,0,1,7}},
                {new int[]{0,3,3,0}, new int[]{4,0,3,3,0}},
        });
    }

    private DZ1 calculatedArray;
    private int[] a;
    private int[] b;

    public DZ1Test(int[] a, int[] b) {
        this.a = a;
        this.b = b;
    }
    @Before
    public void init() {
        calculatedArray = new DZ1();
    }

    @Test
    public void DZ1Test() {
        Assert.assertTrue("Массивы не равны", Arrays.equals(a, calculatedArray.DZ1Method(b)));
    }
}