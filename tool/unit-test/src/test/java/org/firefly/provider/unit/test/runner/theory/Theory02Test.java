package org.firefly.provider.unit.test.runner.theory;

import org.junit.Assume;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertTrue;

@RunWith(Theories.class)
public class Theory02Test {
    @DataPoints
    public static int[] integers() {
        return new int[]{-1, -10, 1, 10, 123456};
    }

    @Theory
    public final void shouldGreaterThanAddon(Integer i, Integer j) {
        Assume.assumeTrue(i >= 0 && j >= 0);
        assertTrue(i + j >= i);
        assertTrue(i + j >= j);
    }
}
