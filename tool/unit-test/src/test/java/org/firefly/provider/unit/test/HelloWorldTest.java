package org.firefly.provider.unit.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

// JUnit是一个针对Java语言的单元测试的框架，由Kent Beck和Erich Gamma建立。
// 由它开始衍生出一系列xUnit。
// 单元测试是软件高质量的一个指标。
// 单元测试也称白盒测试，需要程序员知道被测试的代码如何完成功能，以及完成什么样的功能。

// TDD，测试驱动开发，即编写产品代码前，先写单元测试。这样做的好处是：
// 1）设计更好。反向看，如果先写产品代码，可能写出高耦合的代码，那么写测试比较难。反之，先写测试再写产品代码，那么产品代码天然就避开了强耦合。
// 2）真正的质量保证。如果先写代码，有的为了完成单元测试覆盖率指标，就会运行程序，将结果写到单元测试中，这就是那些烦单元测试的人说的“单元测试
// ”是自欺欺人。而实际上，先写测试代码，就保证了所写功能的验收标准，就不能“自欺欺人”了。实际上，更进一步的，单元测试和产品代码由两个不同的人
// 写，一个人先写单元测试，另一个人负责写产品代码让单元测试通过。
public class HelloWorldTest {
    private HelloWorld helloWorld;

    @Before
    public void setUp() {
        helloWorld = new HelloWorld();
    }

    @After
    public void tearDown() {
        helloWorld = null;
    }

    // 空白处按Att+Enter并选择Test Method，则创建一个测试用例。

    // 测试用例一般采用三段式描述结构：准备数据，执行动作，判断结果。
    @Test
    public void shouldReturnGreetingWordWhenGreetSomeBody() {
        // 准备数据：被调用方法的参数等的准备
        String name = "Michal";

        // 执行动作
        String greetingWord = helloWorld.greet(name);

        // 判断结果
        assertEquals("Hello, Michal!", greetingWord);
    }
}