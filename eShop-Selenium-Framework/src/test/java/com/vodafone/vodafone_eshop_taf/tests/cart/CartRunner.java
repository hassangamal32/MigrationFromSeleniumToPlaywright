package com.vodafone.vodafone_eshop_taf.tests.cart;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/com/vodafone/vodafone_eshop_taf/tests/cart",
        glue = {"com.vodafone.vodafone_eshop_taf.tests"},
        tags = "@eshop and @pipeline and @cart",
        plugin = {"html:reports/eshop-Website-Report.html"},
        monochrome = true
)
public class CartRunner extends AbstractTestNGCucumberTests {
}
