package org.firefly.provider.unit.test;

import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

public class Demo03Test {
    // 忽略测试，不会报告失败，但会报出忽略了多少测试用例。
    // 如果注解放到测试类上，则忽略所有测试用例。
    @Ignore("ignore because condition is not meet")
    @Test
    public void testForIgnore() {
        assertEquals(1, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testForException01() {
        new HelloWorld().greet(null);
    }

    // 测试可以比expected更深入。
    @Test
    public void testForException02() {
        try {
            new HelloWorld().greet(null);
            fail("Expected an IllegalArgumentException to be thrown");
        } catch (Exception e) {
            assertThat(e, is(instanceOf(IllegalArgumentException.class)));
            assertThat(e.getMessage(), is("People name is blank"));
        }
    }

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testForException03() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("People name is blank");
        expectedException.expectMessage(containsString("name is blank"));
        new HelloWorld().greet(null);
    }

    @Test(timeout = 2000)
    public void testForTimeout() throws InterruptedException {
        // 模拟耗时操作
        Thread.sleep(1000);
    }

    @Rule
    public Timeout globalTimeout = Timeout.seconds(2);

    @Test
    public void testForTimeout02() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
    }

    // 持续测试，Continuous Testing，即一改变，测试就会自动跑起来，而且一般先跑最新的和最近的测试。
    // 对IntelliJ IDEA的插件：
    // http://infinitest.github.io/#intellij
    // http://infinitest.github.io/doc/intellij#get-started
}
