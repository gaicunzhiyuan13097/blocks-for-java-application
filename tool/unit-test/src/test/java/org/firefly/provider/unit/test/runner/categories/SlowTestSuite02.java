package org.firefly.provider.unit.test.runner.categories;

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.ExcludeCategory;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Categories.class)
@IncludeCategory(SlowTests.class)
@ExcludeCategory(FastTests.class)
@SuiteClasses({A.class, B.class}) // Note that Categories is a kind of Suite
public class SlowTestSuite02 {
    // Will run A.b, but not A.a or B.c
}
