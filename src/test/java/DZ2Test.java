import lesson6.DZ2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class DZ2Test {
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {true, new int[]{1,1,4,4,1,1}},
                {true, new int[]{4,4,3}},
                {true, new int[]{1,1,1,6}},
                {true, new int[]{4,4,1,1}},
        });
    }

    private DZ2 result;
    private boolean a;
    private int[] b;

    public DZ2Test(boolean a, int[] b) {
        this.a = a;
        this.b = b;
    }
    @Before
    public void init() {
        result = new DZ2();
    }

    @Test
    public void DZ2Test() {
        Assert.assertTrue(String.valueOf(a), result.DZ2Method(b));
    }
}