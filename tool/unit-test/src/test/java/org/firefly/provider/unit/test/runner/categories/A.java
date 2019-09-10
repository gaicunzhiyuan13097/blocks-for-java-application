package org.firefly.provider.unit.test.runner.categories;

import org.junit.Test;
import org.junit.experimental.categories.Category;

import static org.junit.Assert.fail;

public class A {
    @Test
    public void a() {
        fail();
    }

    @Category(SlowTests.class)
    @Test
    public void b() {
    }
}
