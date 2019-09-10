package org.firefly.provider.unit.test.runner.theory;

import org.junit.Assume;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertTrue;

// 理论测试
@RunWith(Theories.class)
public class TheoryTest {
    @Theory
    public final void shouldGreaterThanZeroGivenTwoNumberPlus(@Between(last = 0) int i,
                                                              @Between(first = -3, last = 10) int j) {
        Assume.assumeTrue(j >= 0);
        assertTrue(i + j >= 0);
    }
}
