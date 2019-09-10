package org.firefly.provider.unit.test.runner.parameters;

import org.firefly.provider.unit.test.HelloWorld;
import org.junit.Assume;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ParameterizedTest02Runner {
    private HelloWorld helloWorld = new HelloWorld();
    // 使用字段指定参数，需要指定参数的坐标，第一个默认为0，可以不指定。
    // 此法中，字段必须为public。
    @Parameter
    public String name;
    @Parameter(1)
    public String greetingWord;

    // 用那么指定测试用例名称，默认是"{index}"。
    // 如果只有一个参数，则可以用Iterable<? extends Object>，或者Object[]。
    @Parameters(name = "{index}: shouldReturn\"{1}\"WhenGreet\"{0}\"")
    public static Iterable<Object[]> data() {
        // 如果不满足假设，则终止创建参数集，测试就不进行了。
        String os = System.getProperty("os.name").toLowerCase();
        Assume.assumeTrue(os.contains("win"));

        return asList(new Object[][]{
                {"James", "Hello, James!"},
                {"Kobe", "Hello, Kobe!"},
                {"Joy", "Hello, Joy!"}
        });
    }

    @Test
    public void greetBodies() {
        assertEquals(greetingWord, helloWorld.greet(name));
    }
}
