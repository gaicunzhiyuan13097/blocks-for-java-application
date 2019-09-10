package org.firefly.provider.unit.test.runner.categories;

import org.junit.Test;
import org.junit.experimental.categories.Category;

// 分类测试用于给测试添加元数据。典型的场景包括：
// The type of automated tests: UnitTests, IntegrationTests, SmokeTests, RegressionTests, PerformanceTests ...
// How quick the tests execute: SlowTests, QuickTests
// In which part of the ci build the tests should be executed: NightlyBuildTests
// The state of the test: UnstableTests, InProgressTests
@Category({SlowTests.class, FastTests.class})
public class B {
    @Test
    public void c() {

    }
}
