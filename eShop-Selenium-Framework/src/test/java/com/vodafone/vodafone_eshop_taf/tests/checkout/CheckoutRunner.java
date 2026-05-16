package com.vodafone.vodafone_eshop_taf.tests.checkout;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/com/vodafone/vodafone_eshop_taf/tests/checkout",
        glue = {"com.vodafone.vodafone_eshop_taf.tests"},
        tags = "@eshop and @pipeline and @checkout",
        plugin = {"html:reports/eshop-Website-Report.html"},
        monochrome = true
)
public class CheckoutRunner extends AbstractTestNGCucumberTests {
}
