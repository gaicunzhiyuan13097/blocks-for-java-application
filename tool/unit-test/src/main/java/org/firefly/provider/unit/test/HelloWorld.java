package org.firefly.provider.unit.test;

// 类名上按Alt+Ins并选择Test...，进行简单的配置就可以创建单元测试。
public class HelloWorld {
    public String greet(String name) {
        if (name == null || "".equals(name.trim())) {
            throw new IllegalArgumentException("People name is blank");
        }

        return "Hello, " + name + "!";
    }
}
